package com.game.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cache.SysJurisdictionCache;
import com.cache.SysMenuCache;
import com.db.util.ConnUtil;
import com.web.db.bean.SysMenuInfo;
import com.web.obj.ParamError;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SysMenuService{
	
	/**
	 * //TODO 获取按钮列表-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getMenuList(HttpServletRequest request) throws Exception{
		ParamError error = new ParamError();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int total = 0;
			int begin = (pageNumber - 1) * pageSize;
			List<SysMenuInfo> list = new ArrayList<SysMenuInfo>();
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + new SysMenuInfo().getTableName() + " limit " + begin + "," + pageSize;
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){
						SysMenuInfo info = new SysMenuInfo();
						info.read(rs);
						list.add(info);
					}
					String sql1 = "select count(n_id) from " + new SysMenuInfo().getTableName();
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
			for(SysMenuInfo info : list){
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
	 * //TODO 菜单删除-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject menuDelete(HttpServletRequest request)throws Exception{
		ParamError error = new ParamError();
		int id = ServletService.getParamInt(request, "id", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "delete from " + new SysMenuInfo().getTableName() + " where n_id=" + id;
					stmt.executeUpdate(sql);
					SysMenuCache.load();
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
	 * //TODO 菜单保存-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject menuSave(HttpServletRequest request)throws Exception{
		ParamError error = new ParamError();
		int oid = ServletService.getParamInt(request, "oid", error);
		int id = ServletService.getParamInt(request, "id", error);
		String name = ServletService.getParamString(request, "name", error);
		String url = ServletService.getParamString(request, "url", error);
		int parentId = ServletService.getParamInt(request, "parentId", error);
		int enable = ServletService.getParamInt(request, "enable", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int code = 0;
			String tip = "";
			if(name.length() <= 0){
				tip = "菜单名称不能为空!";
			}else{
				Connection conn = ConnUtil.getConnection();
				try{
					Statement stmt = conn.createStatement();
					try{
						String sql = "";
						if(oid != id){
							sql = "select * from " + new SysMenuInfo().getTableName() + " where n_id = " + id;
							ResultSet rs = stmt.executeQuery(sql);
							try{
								if(rs.next()){
									code = -1;
									tip = "菜单ID已存在!";
								}
							}finally{
								rs.close();
							}
						}
						if(code == 0){
							if(oid == 0){
								SysMenuInfo info = new SysMenuInfo();
								info.setId(id);
								info.setName(name);
								info.setParentId(parentId);
								info.setUrl(url);
								sql = info.getInsertData();
							}else{
								SysMenuInfo info = new SysMenuInfo();
								if(id == oid){
									info.setId(oid);
									info.setName(name);
									info.setParentId(parentId);
									info.setUrl(url);
									info.setEnable(enable);
									sql = info.getUpdateData();
								}else{
									sql = "update " + new SysMenuInfo().getTableName() + " set n_id=" + id + ", n_name='" + name + "', n_parentId=" + parentId + ", n_url='" + url + "' where n_id = " + oid;
								}
							}
							stmt.executeUpdate(sql);
							SysMenuCache.load();
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
	
	/**
	 * //TODO 菜单开关-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject menuEnable(HttpServletRequest request)throws Exception{
		ParamError error = new ParamError();
		int id = ServletService.getParamInt(request, "id", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			resp = new JSONObject();
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + new SysMenuInfo().getTableName() + " where n_id=" + id;
					ResultSet rs = stmt.executeQuery(sql);
					try{
						if(rs.next()){
							SysMenuInfo info = new SysMenuInfo();
							info.read(rs);
							if(info.getEnable() == 1){
								info.setEnable(0);
							}else{
								info.setEnable(1);
							}
							stmt.executeUpdate("update " + new SysMenuInfo().getTableName() + " set n_enable = " + info.getEnable() + " where n_id=" + id);
							resp.put("code", 0);
							resp.put("tip", "");
							resp.put("oid", info.getId());
							resp.put("enable", info.getEnable());
							SysMenuCache.load();
							SysJurisdictionCache.load();
						}else{
							resp.put("code", -1);
							resp.put("tip", "菜单不存在！");
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
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}

	//TODO 
	/******************************************************************************************/
	
	public static List<SysMenuInfo> getMenusInfos()throws Exception{
		List<SysMenuInfo> menus = new ArrayList<SysMenuInfo>();
		Connection conn = ConnUtil.getConnection();
		try{
			Statement stmt = conn.createStatement();
			try{
				String sql = "select * from " + new SysMenuInfo().getTableName();
				ResultSet result = stmt.executeQuery(sql);
				try{
					while(result.next()){
						SysMenuInfo menu = new SysMenuInfo();
						menu.read(result);
						menus.add(menu);
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
		return menus;
	}
	
}
