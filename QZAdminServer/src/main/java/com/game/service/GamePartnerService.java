package com.game.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import com.cache.GamePartnerCache;
import com.db.util.ConnUtil;
import com.web.db.game.GamePartnerInfo;
import com.web.obj.ParamError;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 游戏渠道逻辑类
 *
 */
public class GamePartnerService{
	

	/**
	 * //TODO 获取渠道列表-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getPartnerList(HttpServletRequest request)throws Exception{
		ParamError error = new ParamError();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		int searchType = ServletService.getParamInt(request, "searchType", error);
		String searchValue = ServletService.getParamString(request, "searchValue", error);
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
					if(searchValue.length() > 0){
						if(searchType == 1){
							int val = 0;
							try{
								val = Integer.parseInt(searchValue);
							}catch(Exception e){}
							conditions += " where n_id=" + val;
						}else{
							conditions += " where n_name='" + searchValue + "'";
						}
					}
					String sql = "select * from " + new GamePartnerInfo().getTableName() + conditions + " limit " + begin + "," + pageSize;
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){
						GamePartnerInfo info = new GamePartnerInfo();
						info.read(rs);
						array.add(info.toJson());
					}
					String sql1 = "select count(n_id) from " + new GamePartnerInfo().getTableName() + conditions;
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
			resp.put("rows", array);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO 删除渠道-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject partnerDelete(HttpServletRequest request)throws Exception{
		ParamError error = new ParamError();
		int id = ServletService.getParamInt(request, "id", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "delete from " + new GamePartnerInfo().getTableName() +" where n_id=" + id;
					stmt.executeUpdate(sql);
					GamePartnerCache.load();
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
	 * //TODO 保存渠道-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject partnerSave(HttpServletRequest request)throws Exception{
		ParamError error = new ParamError();
		int rowNum = ServletService.getParamInt(request, "rowNum", error);
		int id = ServletService.getParamInt(request, "id", error);
		int oid = ServletService.getParamInt(request, "oid", error);
		String name = ServletService.getParamString(request, "name", error);
		String payUrl = ServletService.getParamString(request, "payUrl", error);
		String payDebugUrl = ServletService.getParamString(request, "payDebugUrl", error);
		String callbackUrl = ServletService.getParamString(request, "callbackUrl", error);
		String privateKey = ServletService.getParamString(request, "privateKey", error);
		String publicKey = ServletService.getParamString(request, "publicKey", error);
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
						String sql = "select * from " + new GamePartnerInfo().getTableName() + " where n_id = " + id;
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
							GamePartnerInfo req = new GamePartnerInfo();
							req.setId(id);
							req.setName(name);
							req.setPayUrl(payUrl);
							req.setPayDebugUrl(payDebugUrl);
							req.setCallbackUrl(callbackUrl);
							req.setPrivateKey(privateKey);
							req.setPublicKey(publicKey);
							if(rowNum == -1){
								sql = req.getInsertData();
							}else if(oid > 0){
								sql = "update " + req.getTableName() + " set n_id=" + req.getId() + ", n_name='" + req.getName() + "', n_payUrl='" + req.getPayUrl() 
								+ "', n_payDebugUrl='" + req.getPayDebugUrl() + "', n_callbackUrl='" + req.getCallbackUrl() + "', n_privateKey='" + req.getPrivateKey() + "', n_publicKey='" + req.getPublicKey() + "' where n_id =" + oid; 
							}else{
								sql = req.getUpdateData();
							}
							stmt.executeUpdate(sql);
							GamePartnerCache.load();
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
	
	
}
