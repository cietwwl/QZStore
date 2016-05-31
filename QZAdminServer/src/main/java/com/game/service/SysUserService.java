package com.game.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cache.SysJurisdictionCache;
import com.cache.SysUserCache;
import com.db.util.ConnUtil;
import com.security.MD5;
import com.utils.StringUtil;
import com.web.db.bean.SysUserGroupInfo;
import com.web.db.bean.SysUserInfo;
import com.web.obj.ParamError;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SysUserService {
	

	
	/**
	 * //TODO 获取用户分组列表-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getUserGroupList(HttpServletRequest request)throws Exception{
		ParamError error = new ParamError();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int total = 0;
			int begin = (pageNumber - 1) * pageSize;
			List<SysUserGroupInfo> list = new ArrayList<SysUserGroupInfo>();
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + new SysUserGroupInfo().getTableName() + " limit " + begin + "," + pageSize;
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){
						SysUserGroupInfo info = new SysUserGroupInfo();
						info.read(rs);
						list.add(info);
					}
					String sql1 = "select count(n_id) from " + new SysUserGroupInfo().getTableName();
					ResultSet result1 = stmt.executeQuery(sql1);
					try{
						if(result1.next()){
							total = result1.getInt(1);
						}
					}finally{
						result1.close();
					}
				}finally{
					stmt.close();
				}
			}finally{
				conn.close();
			}
			resp = new JSONObject();
			resp.put("page", pageNumber);
			resp.put("total", total);
			JSONArray array = new JSONArray();
			for(SysUserGroupInfo info : list){
				array.add(info.toJson());
			}
			resp.put("rows", array);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO 删除用户分组-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject userGroupDelete(HttpServletRequest request)throws Exception{
		ParamError error = new ParamError();
		int gid = ServletService.getParamInt(request, "gid", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "delete from " + new SysUserGroupInfo().getTableName() + " where n_id=" + gid + " and n_type != 1";
					stmt.executeUpdate(sql);
					SysUserCache.loadGroup();
					resp = new JSONObject();
					resp.put("code", 0);
				}finally{
					stmt.close();
				}
			}finally{
				conn.close();
			}
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO 用户分组添加/修改-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject userGroupSave(HttpServletRequest request)throws Exception{
		ParamError error = new ParamError();
		int gid = ServletService.getParamInt(request, "gid", error);
		String oname = ServletService.getParamString(request, "oname", error);
		String gname = ServletService.getParamString(request, "gname", error);
		String jurisdictionstr = ServletService.getParamString(request, "jurisdictions", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int code = 0;
			String tip = "";
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + new SysUserGroupInfo().getTableName() + " where n_name = " + StringUtil.getSqlValue(gname);
					ResultSet rs = stmt.executeQuery(sql);
					try{
						if(rs.next() && rs.getInt("n_id") != gid){
							code = -1;
							tip = "用户组名已存在!";
						}
					}finally{
						rs.close();
					}
					if(code == 0){
						SysUserGroupInfo ugroup = new SysUserGroupInfo();
						ugroup.setId(gid);
						ugroup.setJurisdictions(StringUtil.parseString(SysJurisdictionCache.validJurids(StringUtil.parseList(jurisdictionstr, ",")), ","));
						ugroup.setName(gname);
						ugroup.setType(2);
						if(oname.length() == 0){
							sql = ugroup.getInsertData();
						}else if(oname.length() > 0){
							sql = "update " + ugroup.getTableName() + " set n_jurisdictions='" + ugroup.getJurisdictions() + "', n_name='" + ugroup.getName() + "', n_type=" + ugroup.getType() + " where n_name='" + oname + "'";
						}else{
							sql = ugroup.getUpdateData();
						}
						stmt.executeUpdate(sql);
						SysUserCache.loadGroup();
						resp = new JSONObject();
						resp.put("code", code);
						resp.put("tip", tip);
					}
				}finally{
					stmt.close();
				}
			}finally{
				conn.close();
			}
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO 获取用户列表-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getUserList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int total = 0;
			int begin = (pageNumber - 1) * pageSize;
			List<SysUserInfo> list = new ArrayList<SysUserInfo>();
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					SysUserInfo user = (SysUserInfo)session.getAttribute("user");
					String sql = "select * from " + new SysUserInfo().getTableName() + " limit " + begin + "," + pageSize;
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){
						SysUserInfo info = new SysUserInfo();
						info.read(rs);
						if(info.getUserGroupId() == 1){
							if(info.getNote().length() <= 0 || user == null || user.getUserGroupId() != 1){
								info.setNote("<b style='color:red;'>备注内容仅对超级管理员显示！</b>");
							}
						}else if(user == null || user.getUserGroupId() != 1){
							info.setNote("");
						}
						list.add(info);
					}
					String sql1 = "select count(n_id) from " + new SysUserInfo().getTableName();
					ResultSet result1 = stmt.executeQuery(sql1);
					try{
						if(result1.next()){
							total = result1.getInt(1);
						}
					}finally{
						result1.close();
					}
				}finally{
					stmt.close();
				}
			}finally{
				conn.close();
			}
			resp = new JSONObject();
			resp.put("page", pageNumber);
			resp.put("total", total);
			JSONArray array = new JSONArray();
			List<SysUserGroupInfo> groups = SysUserCache.getUserGroupInfos();
			for(SysUserInfo info : list){
				JSONObject json = info.toJson();
				for(SysUserGroupInfo group : groups){
					if(group.getId() == info.getUserGroupId()){
						json.put("userGroupName", group.getName());
						json.put("userGroupType", group.getType());
					}
				}
				array.add(json);
			}
			resp.put("rows", array);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO 删除用户-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject userDelete(HttpServletRequest request)throws Exception{
		ParamError error = new ParamError();
		int uid = ServletService.getParamInt(request, "uid", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "delete from " + new SysUserInfo().getTableName() + " where n_id=" + uid + " and n_userGroupId != 1";
					stmt.executeUpdate(sql);
					SysUserCache.loadUser();
					resp = new JSONObject();
					resp.put("code", 0);
				}finally{
					stmt.close();
				}
			}finally{
				conn.close();
			}
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO 用户添加/修改-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject userSave(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int uid = ServletService.getParamInt(request, "uid", error);
		int rowNum = ServletService.getParamInt(request, "rowNum", error);
		String username = ServletService.getParamString(request, "username", error);
		String password = ServletService.getParamString(request, "password", error);
		String noteText = ServletService.getParamString(request, "noteText", error);
		int userGroupId = ServletService.getParamInt(request, "userGroupId", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int code = 0;
			String tip = "";
			if(uid == 0 && password.length() == 0){
				code = -1;
				tip = "帐号密码不参为空";
			}else{
				Connection conn = ConnUtil.getConnection();
				try{
					Statement stmt = conn.createStatement();
					try{
						String sql = "select * from " + new SysUserInfo().getTableName() + " where n_username = " + StringUtil.getSqlValue(username);
						ResultSet rs = stmt.executeQuery(sql);
						try{
							if(rs.next()){
								if(rowNum == -1 || rs.getInt("n_id") != uid){
									code = -1;
									tip = "用户名已存在!";
								}
							}
						}finally{
							rs.close();
						}
						if(code == 0){
							SysUserInfo user = (SysUserInfo)session.getAttribute("user");
							SysUserInfo uinfo = new SysUserInfo();
							if(user != null && user.getUserGroupId() == 1 && noteText.length() > 0){
								uinfo.setNote(noteText);
							}
							if(rowNum == -1){
								uinfo.setUsername(username);
								uinfo.setPassword(MD5.encode(password));
								uinfo.setUserGroupId(userGroupId);
								sql = uinfo.getInsertData();
							}else if(uid > 0){
								sql = "update " + uinfo.getTableName() + " set n_username=" + StringUtil.getSqlValue(username) + ",n_userGroupId=" + StringUtil.getSqlValue(userGroupId);
								if(password.length() > 0){
									sql += ",n_password=" + StringUtil.getSqlValue(MD5.encode(password));
								}
								if(uinfo.getNote().length() > 0){
									sql += ",n_note=" + StringUtil.getSqlValue(noteText);
								}
								sql += " where n_id=" + uid;
							}
							stmt.executeUpdate(sql);
							SysUserCache.loadUser();
							resp = new JSONObject();
							resp.put("code", code);
							resp.put("tip", tip);
						}
					}finally{
						stmt.close();
					}
				}finally{
					conn.close();
				}
			}
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	

	//TODO 
	/******************************************************************************************/

	public static List<SysUserInfo> getUserInfos() throws Exception{
		List<SysUserInfo> list = new ArrayList<SysUserInfo>();
		Connection conn = ConnUtil.getConnection();
		try{
			Statement stmt = conn.createStatement();
			try{
				String sql = "select * from " + new SysUserInfo().getTableName();
				ResultSet result = stmt.executeQuery(sql);
				try{
					while(result.next()){
						SysUserInfo info = new SysUserInfo();
						info.read(result);
						list.add(info);
					}
				}finally{
					result.close();
				}
			}finally{
				stmt.close();
			}
		}finally{
			conn.close();
		}
		return list;
	}
	
	public static List<SysUserGroupInfo> getUserGroupInfos() throws Exception{
		List<SysUserGroupInfo> list = new ArrayList<SysUserGroupInfo>();
		Connection conn = ConnUtil.getConnection();
		try{
			Statement stmt = conn.createStatement();
			try{
				String sql = "select * from " + new SysUserGroupInfo().getTableName();
				ResultSet result = stmt.executeQuery(sql);
				try{
					while(result.next()){
						SysUserGroupInfo info = new SysUserGroupInfo();
						info.read(result);
						list.add(info);
					}
				}finally{
					result.close();
				}
			}finally{
				stmt.close();
			}
		}finally{
			conn.close();
		}
		return list;
	}
	
}
