package com.game.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import com.db.util.ConnUtil;
import com.http.message.CommonHttpRequest;
import com.utils.HttpUtil;
import com.utils.JSONUtil;
import com.web.db.game.GameRefreshInfo;
import com.web.obj.ParamError;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GameWebService{

	
	/**
	 * //TODO 获取Web区服缓存刷新列表-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getWebRefreshList(HttpServletRequest request)throws Exception{
		ParamError error = new ParamError();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		int type = ServletService.getParamInt(request, "type", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int total = 0;
			int begin = (pageNumber - 1) * pageSize;
			JSONArray array = new JSONArray();
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					String conditions = "";
					if(type != 0){
						conditions = " where n_type=" + type;
					}
					String sql = "select * from " + new GameRefreshInfo().getTableName() + conditions + " limit " + begin + "," + pageSize;
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){
						GameRefreshInfo info = new GameRefreshInfo();
						info.read(rs);
						array.add(info.toJson());
					}
					String sql1 = "select count(n_id) from " + new GameRefreshInfo().getTableName() + conditions;
					ResultSet result1 = stmt.executeQuery(sql1);
					try{
						if(result1.next()){
							total = result1.getInt(1);
						}
					}finally{
						result1.close();
					}
					resp = new JSONObject();
					resp.put("page", pageNumber);
					resp.put("total", total);
					resp.put("rows", array);
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
	 * //TODO WEB区服缓存地址删除-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject webRefreshDelete(HttpServletRequest request)throws Exception{
		ParamError error = new ParamError();
		int id = ServletService.getParamInt(request, "id", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "delete from " + new GameRefreshInfo().getTableName() +" where n_id=" + id;
					stmt.executeUpdate(sql);
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
	 * //TODO  WEB区服缓存地址添加/修改-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject webRefreshSave(HttpServletRequest request)throws Exception{
		ParamError error = new ParamError();
		int id = ServletService.getParamInt(request, "id", error);
		int type = ServletService.getParamInt(request, "type", error);
		String name = ServletService.getParamString(request, "name", error);
		String refUrl = ServletService.getParamString(request, "furl", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int code = 0;
			String tip = "";
			if(name.length() == 0 || refUrl.length() == 0){
				code = -1;
				tip = "名称或地址不能为空！";
			}else{
				Connection conn = ConnUtil.getConnection();
				try{
					Statement stmt = conn.createStatement();
					try{
						if(id == 0){
							String sql = "select * from " + new GameRefreshInfo().getTableName() + " where n_refUrl = '" + refUrl + "'";
							ResultSet rs = stmt.executeQuery(sql);
							try{
								if(rs.next()){
									code = -1;
									tip = "目标地址已存在 ！";
								}
							}finally{
								rs.close();
							}
						}
						if(code == 0){
							GameRefreshInfo req = new GameRefreshInfo();
							req.setId(id);
							req.setType(type);
							req.setName(name);
							req.setRefUrl(refUrl);
							String sql = "";
							if(id == 0){
								sql = req.getInsertData();
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
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO 刷新web缓存-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject webRefresh(HttpServletRequest request)throws Exception{
		ParamError error = new ParamError();
		String url = ServletService.getParamString(request, "furl", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			resp = new JSONObject();
			CommonHttpRequest req = new CommonHttpRequest(url, CommonHttpRequest.METHOD_POST);
			String result = HttpUtil.send(req);
			if(result.length() > 0){
				JSONObject obj = JSONUtil.parseJSON(result);
				resp.put("code", obj.getInt("code"));
			}else{
				resp.put("code", -1);
				resp.put("tip", "刷新失败！请检查对应地址是否可用！");
			}
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
}
