package com.game.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cache.SysJurisdictionCache;
import com.db.util.ConnUtil;
import com.web.db.bean.SysJurisdictionInfo;
import com.web.obj.ParamError;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SysJurisdictionService {
	
	
	/**
	 * //TODO 获取权限列表-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getJurisdictionList(HttpServletRequest request) throws Exception{
		ParamError error = new ParamError();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int total = 0;
			int limitNum = (pageNumber - 1) * pageSize;
			List<SysJurisdictionInfo> list = new ArrayList<SysJurisdictionInfo>();
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + new SysJurisdictionInfo().getTableName() + " limit " + limitNum + "," + pageSize;
					ResultSet rs = stmt.executeQuery(sql);
					try{
						while(rs.next()){
							SysJurisdictionInfo info = new SysJurisdictionInfo();
							info.read(rs);
							list.add(info);
						}
					}finally{
						rs.close();
					}
					sql = "select count(*) from " + new SysJurisdictionInfo().getTableName();
					rs = stmt.executeQuery(sql);
					try{
						if(rs.next()){
							total = rs.getInt(1);
						}
					}finally{
						rs.close();
					}
				}finally{
					stmt.close();
				}
			}finally{
				conn.close();
			}
			resp = new JSONObject();
			resp.put("code", 0);
			JSONArray array = new JSONArray();
			for(SysJurisdictionInfo info : list){
				array.add(info.toJson());
			}
			resp.put("page", pageNumber);
			resp.put("total", total);
			resp.put("rows", array);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO 权限删除-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject jurisdictionDelete(HttpServletRequest request)throws Exception{
		ParamError error = new ParamError();
		String idstr = ServletService.getParamString(request, "ids", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "delete from " + new SysJurisdictionInfo().getTableName() +" where n_id in (" + idstr + ")";
					stmt.executeUpdate(sql);
					SysJurisdictionCache.load();
				}finally{
					stmt.close();
				}
			}finally{
				conn.close();
			}
			resp = new JSONObject();
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO 权限保存-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject jurisdictionSave(HttpServletRequest request)throws Exception{
		ParamError error = new ParamError();
		int rowNum = ServletService.getParamInt(request, "rowNum", error);
		int id = ServletService.getParamInt(request, "id", error);
		int oid = ServletService.getParamInt(request, "oid", error);
		int parentId = ServletService.getParamInt(request, "parentId", error);
		String desc = ServletService.getParamString(request, "desc", error);
		String name = ServletService.getParamString(request, "name", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int code = 0;
			String tip = "";
			if(id == 0 && name.length() == 0){
				code = -1;
				tip = "名称或id不能为空";
			}else{
				Connection conn = ConnUtil.getConnection();
				try{
					Statement stmt = conn.createStatement();
					try{
						String sql = "select * from " + new SysJurisdictionInfo().getTableName() + " where n_id = " + id;
						ResultSet rs = stmt.executeQuery(sql);
						try{
							if(rowNum == -1){
								if(rs.next()){
									code = -1;
									tip = "目标ID已存在!";
								}
							}else if(!rs.next() && oid == 0){
								code = -1;
								tip = "目标ID不存在!";
							}
						}finally{
							rs.close();
						}
						if(code == 0){
							SysJurisdictionInfo info = new SysJurisdictionInfo();
							info.setId(id);
							info.setParentId(parentId);
							info.setName(name);
							info.setDesc(desc);
							if(rowNum == -1){
								sql = info.getInsertData();
							}else if(oid > 0){
								sql = "update " + info.getTableName() + " set n_id=" + info.getId() + ",n_parentId=" + info.getParentId() + ",n_name='" + info.getName() + "',n_desc='" + info.getDesc() + "' where n_id=" + oid;
							}else{
								sql = info.getUpdateData();
							}
							stmt.executeUpdate(sql);
							SysJurisdictionCache.load();
						}
					}finally{
						conn.close();
					}
				}finally{
					conn.close();
				}
			}
			resp = new JSONObject();
			resp.put("code", code);
			resp.put("tip", tip);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}

	//TODO 
	/******************************************************************************************/

	public static List<SysJurisdictionInfo> getJurisdictions() throws Exception{
		List<SysJurisdictionInfo> list = new ArrayList<SysJurisdictionInfo>();
		Connection conn = ConnUtil.getConnection();
		try{
			Statement stmt = conn.createStatement();
			try{
				String sql = "select * from " + new SysJurisdictionInfo().getTableName();
				ResultSet rs = stmt.executeQuery(sql);
				try{
					while(rs.next()){
						SysJurisdictionInfo info = new SysJurisdictionInfo();
						info.read(rs);
						list.add(info);
					}
				}finally{
					rs.close();
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
