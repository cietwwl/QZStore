package com.game.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cache.SysRequestCache;
import com.db.util.ConnUtil;
import com.web.db.bean.SysRequestInfo;
import com.web.obj.ParamError;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 请求权限逻辑类
 *
 */
public class SysRequestService {

	
	/**
	 * //TODO 获取请求列表-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getRequestList(HttpServletRequest request)throws Exception{
		ParamError error = new ParamError();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int begin = (pageNumber - 1) * pageSize;
			List<SysRequestInfo> list = new ArrayList<SysRequestInfo>();
			int total = 0;
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + new SysRequestInfo().getTableName() +  " order by n_id asc, n_url asc limit " + begin + "," + pageSize;
					ResultSet rs = stmt.executeQuery(sql);
					try{
						while(rs.next()){
							SysRequestInfo info = new SysRequestInfo();
							info.read(rs);
							list.add(info);
						}
					}finally{
						rs.close();
					}
					String sql1 = "select count(n_id) from " + new SysRequestInfo().getTableName();
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
			JSONArray array = new JSONArray();
			for(SysRequestInfo info : list){
				array.add(info.toJson());
			}
			resp = new JSONObject();
			resp.put("page", pageNumber);
			resp.put("total", total);
			resp.put("rows", array);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	

	/**
	 * //TODO 删除请求-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject requestDelete(HttpServletRequest request)throws Exception{
		ParamError error = new ParamError();
		int id = ServletService.getParamInt(request, "id", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "delete from " + new SysRequestInfo().getTableName() + " where n_id=" + id;
					stmt.executeUpdate(sql);
				}finally{
					stmt.close();
				}
			}finally{
				conn.close();
			}
			resp = new JSONObject();
			resp.put("code", 0);
			SysRequestCache.load();
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO 保存请求-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject requestSave(HttpServletRequest request)throws Exception{
		ParamError error = new ParamError();
		int rowNum = ServletService.getParamInt(request, "rowNum", error);
		int id = ServletService.getParamInt(request, "id", error);
		int oid = ServletService.getParamInt(request, "oid", error);
		String name = ServletService.getParamString(request, "name", error);
		String url = ServletService.getParamString(request, "url", error);
		int jurisdictionId = ServletService.getParamInt(request, "jurisdictionId", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int code = 0;
			String tip = "";
			if(name.length() <= 0){
				code = -1;
				tip = "名称不能为空！";
			}else{
				Connection conn = ConnUtil.getConnection();
				try{
					Statement stmt = conn.createStatement();
					try{
						String sql = "select * from " + new SysRequestInfo().getTableName() + " where n_id = " + id;
						ResultSet rs = stmt.executeQuery(sql);
						try{
							if(rowNum == -1){
								if(rs.next()){
									code = -1;
									tip = "目标ID已存在 ！";
								}
							}else if(!rs.next() && oid == 0){
								code = -1;
								tip = "目标ID不存在 ！";
							}
						}finally{
							rs.close();
						}
						if(code == 0){
							SysRequestInfo req = new SysRequestInfo();
							req.setId(id);
							req.setName(name);
							req.setUrl(url);
							req.setJurisdictionId(jurisdictionId);
							if(rowNum == -1){
								sql = req.getInsertData();
							}else if(oid > 0){
								sql = "update " + req.getTableName() + " set n_id=" + req.getId() + ", n_name='" + req.getName() + "', n_url='" + req.getUrl() + "', n_jurisdictionId=" + req.getJurisdictionId() + " where n_id =" + oid; 
							}else{
								sql = req.getUpdateData();
							}
							stmt.executeUpdate(sql);
						}
					}finally{
						stmt.close();
					}
				}finally{
					ConnUtil.closeConnection(conn);
				}
			}
			resp = new JSONObject();
			resp.put("code", code);
			resp.put("tip", tip);
			SysRequestCache.load();
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	

	//TODO  
	/******************************************************************************************/
	
	public static List<SysRequestInfo> getRequests() throws Exception{
		List<SysRequestInfo> list = new ArrayList<SysRequestInfo>();
		Connection conn = ConnUtil.getConnection();
		try{
			Statement stmt = conn.createStatement();
			try{
				String sql = "select * from " + new SysRequestInfo().getTableName() + " order by n_jurisdictionId asc, n_url asc";
				ResultSet rs = stmt.executeQuery(sql);
				try{
					while(rs.next()){
						SysRequestInfo info = new SysRequestInfo();
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
