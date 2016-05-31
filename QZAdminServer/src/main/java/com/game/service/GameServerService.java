package com.game.service;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cache.GameServerCache;
import com.db.util.ConnUtil;
import com.http.message.CommonHttpRequest;
import com.ks.constant.SystemConstant;
import com.ks.exceptions.GameException;
import com.ks.util.XyTimeUtil;
import com.utils.HttpUtil;
import com.utils.JSONUtil;
import com.utils.StringUtil;
import com.utils.TimeUtil;
import com.utils.TimeUtil.DATE_FORMATER;
import com.web.db.game.GameServerInfo;
import com.web.obj.ParamError;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GameServerService {
	
	/**
	 * //TODO 获取服务器列表-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getGameServerList(HttpServletRequest request, HttpSession session) throws Exception{
		ParamError error = new ParamError();
		int searchType = ServletService.getParamInt(request, "searchType", error);
		String searchValue = ServletService.getParamString(request, "searchValue", error).toLowerCase();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int begin = (pageNumber - 1) * pageSize;
			List<String> updates = new ArrayList<String>();
			List<GameServerInfo> servers = GameServerCache.getGameServers();
			JSONArray array = new JSONArray();
			for(int index = begin; index < servers.size() && array.size() < pageSize; index++){
				GameServerInfo server = servers.get(index);
				if(server.getStateTime() + TimeUtil.MINUTE_SECOND <= TimeUtil.getNowSecond()){
					updateState(server, false);
					updates.add(server.getUpdateData());
				}
				if(searchValue.length() > 0){
					if(searchType == 1){
						if(server.getServerId().toLowerCase().contains(searchValue)){
							array.add(server.toJson());
						}
					}else if(searchType == 2){
						if(server.getServerName().toLowerCase().contains(searchValue)){
							array.add(server.toJson());
						}
					}
				}else{
					array.add(server.toJson());
				}
			}
			if(!updates.isEmpty()){
				Connection conn = ConnUtil.getConnection();
				try{
					Statement stat = conn.createStatement();
					try{
						for(String str : updates){
							stat.executeUpdate(str);
						}
					}catch(Exception e){
						e.printStackTrace();
					}finally{
						stat.close();
					}
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					conn.close();
				}
			}
			resp = new JSONObject();
			resp.put("page", pageNumber);
			resp.put("total", servers.size());
			resp.put("rows", array);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO 游戏缓存加载-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject gameCacheLoad(HttpServletRequest request)throws Exception{
		ParamError error = new ParamError();
		int id = ServletService.getParamInt(request, "id", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			List<GameServerInfo> servers = GameServerCache.getGameServers();
			int code = GameException.CODE_系统错误;
			for(GameServerInfo info : servers){
				if(info.getId() == id){
					CommonHttpRequest req = new CommonHttpRequest(info.getAdminUrl(), CommonHttpRequest.METHOD_POST);
					req.addParam("action", "LoadGameCacheAction");
					String resultstr = HttpUtil.sendPost(req);
					if(resultstr.length() > 0){
						JSONObject result = JSONUtil.parseJSON(resultstr);
						code = result.getInt("code");
					}
					break;
				}
			}
			String str = "";
			if(code == GameException.CODE_正常){
				str = "加载缓存成功！！！";
			}else{
				str = "加载缓存失败！！！";
			}
			resp = new JSONObject();
			resp.put("code", code);
			resp.put("tip", str);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO 添加服务器-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject serverAdd(HttpServletRequest request, HttpSession session) throws Exception{
		ParamError error = new ParamError();
		String serverId = ServletService.getParamString(request, "serverId", error);
		int serverNo = ServletService.getParamInt(request, "serverNo", error);
		int type = ServletService.getParamInt(request, "type", error);
		boolean defaultSelect = ServletService.getParamBoolean(request, "defaultSelect", error);
		int merge = ServletService.getParamInt(request, "merge", error);
		String serverName = ServletService.getParamString(request, "serverName", error);
		String mainDBUrl = ServletService.getParamString(request, "mainDBUrl", error);
		String mainDBUsername = ServletService.getParamString(request, "mainDBUsername", error);
		String mainDBPassword = ServletService.getParamString(request, "mainDBPassword", error);
		String configDBUrl = ServletService.getParamString(request, "configDBUrl", error);
		String configDBUsername = ServletService.getParamString(request, "configDBUsername", error);
		String configDBPassword = ServletService.getParamString(request, "configDBPassword", error);
		String adminUrl = ServletService.getParamString(request, "adminUrl", error);
		String adminCheck = ServletService.getParamString(request, "adminCheck", error);
		String startTimeStr = ServletService.getParamString(request, "startTime", error);
		int recommond = ServletService.getParamInt(request, "recommond", error);
		int status = ServletService.getParamInt(request, "status", error);
		String maintainMsg = ServletService.getParamString(request, "maintainMsg", error);
		String maintainTime = ServletService.getParamString(request, "maintainTime", error);
		String ip = ServletService.getParamString(request, "ip", error);
		int port = ServletService.getParamInt(request, "port", error);
		String worldIp = ServletService.getParamString(request, "worldIp", error);
		int worldPort = ServletService.getParamInt(request, "worldPort", error);
		String desc = ServletService.getParamString(request, "desc", error);
		String rechargeUrl = ServletService.getParamString(request, "rechargeUrl", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			Date maintainStartTime = null;
			Date maintainEndTime = null;
			Date startTime = null;
			if(startTimeStr.length() > 0){
				try{
					startTime = TimeUtil.parseDate(startTimeStr, DATE_FORMATER.yyyy_MM_dd_HH_mm_ss);
				}catch(Exception e){
					startTime = null;
				}
			}
			if(maintainTime.length() > 0){
				List<String> list = StringUtil.parseListByString(maintainTime, "--");
				if(list.size() >= 2){
					try{
						maintainStartTime = TimeUtil.parseDate(list.get(0), DATE_FORMATER.yyyy_MM_dd_HH_mm_ss);
						maintainEndTime = TimeUtil.parseDate(list.get(1), DATE_FORMATER.yyyy_MM_dd_HH_mm_ss);
						if(maintainEndTime.getTime() <= maintainStartTime.getTime()){
							throw new Exception();
						}
					}catch(Exception e){
						maintainStartTime = null;
						maintainEndTime = null;
					}
				}
			}
			int code = 0;
			String tip = "";
			Connection conn = ConnUtil.getConnection();
			try{
				String sql = "select * from " + new GameServerInfo().getTableName() + " where n_serverId = " + StringUtil.getSqlValue(serverId)
						+ " or " + "n_serverName=" + StringUtil.getSqlValue(serverName);
				Statement stmt = conn.createStatement();
				try{
					ResultSet rs = stmt.executeQuery(sql);
					try{
						if(rs.next()){
							code = -1;
							tip = "服务器ID或服务器名称已经被使用!";
						}else{
							if(defaultSelect){
								List<GameServerInfo> list = GameServerCache.getGameServers();
								for(GameServerInfo info : list){
									if(info.isDefaultSelect()){
										conn.setAutoCommit(false);
										stmt.executeUpdate("update " + new GameServerInfo().getTableName() + " set n_defaultSelect = 0");
										conn.commit();
										conn.setAutoCommit(true);
										break;
									}
								}
							}
							GameServerInfo newserver = new GameServerInfo();
							newserver.setServerId(serverId);
							newserver.setDefaultSelect(defaultSelect);
							newserver.setType(type);
							newserver.setServerName(serverName);
							newserver.setMerge(merge);
							newserver.setMainDBUrl(mainDBUrl);
							newserver.setMainDBUsername(mainDBUsername);
							newserver.setMainDBPassword(mainDBPassword);
							newserver.setConfigDBUrl(configDBUrl);
							newserver.setConfigDBUsername(configDBUsername);
							newserver.setConfigDBPassword(configDBPassword);
							newserver.setAdminUrl(adminUrl);
							newserver.setAdminCheck(adminCheck);
							newserver.setStartTime(startTime);
							newserver.setServerNo(serverNo);
							newserver.setRecommend(recommond);
							newserver.setStatus(status);
							newserver.setMaintainMsg(maintainMsg);
							if(maintainStartTime != null && maintainEndTime != null){
								newserver.setMaintainStartTime(maintainStartTime);
								newserver.setMaintainEndTime(maintainEndTime);
							}
							newserver.setIp(ip);
							newserver.setPort(port);
							newserver.setWorldIp(worldIp);
							newserver.setWorldPort(worldPort);
							newserver.setDesc(desc);
							newserver.setRechargeUrl(rechargeUrl);
							updateState(newserver, false);
							String insertSql = newserver.getInsertData();
							stmt.executeUpdate(insertSql);
							GameServerCache.load();
							if(defaultSelect || session.getAttribute("selserver") == null){
								GameServerCache.initDefaultServer(session);
							}
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
			resp.put("code", code);
			resp.put("tip", tip);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO 删除服务器-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject serverDelete(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int id = ServletService.getParamInt(request, "id", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			String sql = "delete from " + new GameServerInfo().getTableName() + " where n_id=" + id;
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					stmt.executeUpdate(sql);
					GameServerInfo info = GameServerCache.getGameServerInfo(id);
					if(info != null){
						GameServerCache.load();
						if(info.isDefaultSelect() || GameServerCache.getGameServers().isEmpty()){
							GameServerCache.initDefaultServer(session);
						}
					}
				}finally{
					stmt.close();
				}
			}finally{
				conn.close();
			}
			resp = new JSONObject();
			resp.put("code", 0);
			resp.put("tip", "");
			resp.put("did", id);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO 修改服务器-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject serverModify(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int id = ServletService.getParamInt(request, "id", error);
		int serverNo = ServletService.getParamInt(request, "serverNo", error);
		String serverId = ServletService.getParamString(request, "serverId", error);
		int type = ServletService.getParamInt(request, "type", error);
		boolean defaultSelect = ServletService.getParamBoolean(request, "defaultSelect", error);
		String serverName = ServletService.getParamString(request, "serverName", error);
		int merge = ServletService.getParamInt(request, "merge", error);
		String mainDBUrl = ServletService.getParamString(request, "mainDBUrl", error);
		String mainDBUsername = ServletService.getParamString(request, "mainDBUsername", error);
		String mainDBPassword = ServletService.getParamString(request, "mainDBPassword", error);
		String configDBUrl = ServletService.getParamString(request, "configDBUrl", error);
		String configDBUsername = ServletService.getParamString(request, "configDBUsername", error);
		String configDBPassword = ServletService.getParamString(request, "configDBPassword", error);
		String adminUrl = ServletService.getParamString(request, "adminUrl", error);
		String adminCheck = ServletService.getParamString(request, "adminCheck", error);
		String startTimeStr = ServletService.getParamString(request, "startTime", error);
		int recommond = ServletService.getParamInt(request, "recommond", error);
		int status = ServletService.getParamInt(request, "status", error);
		String maintainMsg = ServletService.getParamString(request, "maintainMsg", error);
		String maintainTime = ServletService.getParamString(request, "maintainTime", error);
		String ip = ServletService.getParamString(request, "ip", error);
		int port = ServletService.getParamInt(request, "port", error);
		String worldIp = ServletService.getParamString(request, "worldIp", error);
		int worldPort = ServletService.getParamInt(request, "worldPort", error);
		String desc = ServletService.getParamString(request, "desc", error);
		String rechargeUrl = ServletService.getParamString(request, "rechargeUrl", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			Date maintainStartTime = null;
			Date maintainEndTime = null;
			Date startTime = null;
			if(startTimeStr.length() > 0){
				try{
					startTime = TimeUtil.parseDate(startTimeStr, DATE_FORMATER.yyyy_MM_dd_HH_mm_ss);
				}catch(Exception e){
					startTime = null;
				}
			}
			if(maintainTime.length() > 0){
				List<String> list = StringUtil.parseListByString(maintainTime, "--");
				if(list.size() >= 2){
					try{
						maintainStartTime = TimeUtil.parseDate(list.get(0), DATE_FORMATER.yyyy_MM_dd_HH_mm_ss);
						maintainEndTime = TimeUtil.parseDate(list.get(1), DATE_FORMATER.yyyy_MM_dd_HH_mm_ss);
						if(maintainEndTime.getTime() <= maintainStartTime.getTime()){
							throw new Exception();
						}
					}catch(Exception e){
						maintainStartTime = null;
						maintainEndTime = null;
					}
				}
			}
			int code = 0;
			String tip = "";
			GameServerInfo server = GameServerCache.getGameServerInfo(id);
			if(server == null){
				code = 1;
				tip = "服务器不存在";
			}else{
				Connection conn = ConnUtil.getConnection();
				try{
					Statement stmt = conn.createStatement();
					try{
						String sql = "select * from " + new GameServerInfo().getTableName() + " where (n_serverId = " + StringUtil.getSqlValue(serverId) + " or " + "n_serverName=" + StringUtil.getSqlValue(serverName) + ") and " + "n_id != " + StringUtil.getSqlValue(id);
						ResultSet rs = stmt.executeQuery(sql);
						try{
							if(rs.next()){
								code = -1;
								tip = "服务器ID或服务器名称已经被使用!";
							}else{
								if(defaultSelect){
									conn.setAutoCommit(false);
									List<GameServerInfo> list = GameServerCache.getGameServers();
									for(GameServerInfo info : list){
										if(info.isDefaultSelect()){
											stmt.executeUpdate("update " + new GameServerInfo().getTableName() + " set n_defaultSelect = 0 where n_id != " + server.getId() + ";");
											conn.commit();
											break;
										}
									}
									conn.setAutoCommit(true);
								}
								server.setType(type);
								server.setServerId(serverId);
								server.setDefaultSelect(defaultSelect);
								server.setServerName(serverName);
								server.setMerge(merge);
								server.setMainDBUrl(mainDBUrl);
								server.setMainDBUsername(mainDBUsername);
								server.setMainDBPassword(mainDBPassword);
								server.setConfigDBUrl(configDBUrl);
								server.setConfigDBUsername(configDBUsername);
								server.setConfigDBPassword(configDBPassword);
								server.setAdminUrl(adminUrl);
								server.setAdminCheck(adminCheck);
								server.setStartTime(startTime);
								server.setServerNo(serverNo);
								server.setRecommend(recommond);
								server.setStatus(status);
								server.setMaintainStartTime(maintainStartTime);
								server.setMaintainEndTime(maintainEndTime);
								server.setMaintainMsg(maintainMsg);
								server.setIp(ip);
								server.setPort(port);
								server.setWorldIp(worldIp);
								server.setWorldPort(worldPort);
								server.setDesc(desc);
								server.setRechargeUrl(rechargeUrl);
								String updateSql = server.getUpdateData();
								stmt.executeUpdate(updateSql);
								GameServerCache.load();
								GameServerCache.initDefaultServer(session);
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
	 * //TODO 选择服务器-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject serverSelect(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int check = ServletService.getParamInt(request, "check", error);
		int sid = ServletService.getParamInt(request, "sid", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int oid = 0;
			int openTime = 0;
			resp = new JSONObject();
			GameServerInfo server = GameServerCache.getGameServerInfo(sid);
			try{
				if(server == null){
					throw new Exception();
				}else if(check == 1){
					URL url = new URL(server.getAdminUrl());
					InetAddress inetAddress = InetAddress.getByName(url.getHost());
					Socket socket = new Socket();
					InetSocketAddress address = new InetSocketAddress(inetAddress.getHostAddress(), url.getPort());
					socket.connect(address, 100);
					socket.close();
				}
				session.setAttribute("selserver", server);
				openTime = XyTimeUtil.getTimeOfSecond(server.getStartTime());
				resp.put("sign", 1);
			}catch(Exception e){
				resp.put("sign", 2);
			}
			if(openTime > 0){
				GameServerInfo info = (GameServerInfo)session.getAttribute("selserver");
				if(info != null){
					oid = info.getId();
				}
			}
			resp.put("oid", oid);
			resp.put("openTime", openTime);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO 刷新服务器状态-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject serverFlushState(HttpServletRequest request)throws Exception{
		ParamError error = new ParamError();
		String serverId = ServletService.getParamString(request, "serverId", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			GameServerInfo target = null;
			List<GameServerInfo> servers = GameServerCache.getGameServers();
			for(GameServerInfo info : servers){
				if(info.getServerId().equals(serverId)){
					int oldState = info.getState();
					updateState(info, true);
					if(oldState != info.getState()){
						target = info;
					}
					break;
				}
			}
			resp = new JSONObject();
			if(target != null){
				resp.put("code", GameException.CODE_正常);
				resp.put("tip", "成功刷新！！！");
				resp.put("server", JSONUtil.parseSimpleJSON(target, GameServerInfo.class));
			}else{
				resp.put("code", GameException.CODE_参数错误);
				resp.put("tip", "状态无更改！！！");
			}
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO 停服-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject serverStop(HttpServletRequest request)throws Exception{
		ParamError error = new ParamError();
		int id = ServletService.getParamInt(request, "id", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			GameServerInfo target = GameServerCache.getGameServerInfo(id);
			if(target == null){
				resp = error.getServerError();
			}else{
				resp = new JSONObject();
				CommonHttpRequest req = new CommonHttpRequest(target.getAdminUrl(), CommonHttpRequest.METHOD_POST);
				req.addParam("action", "StopServerAction");
				req.addParam("checkStop", Integer.toString(SystemConstant.STOP_SERVER_CODE));
				String resultstr = HttpUtil.sendPost(req);
				if(resultstr.length() > 0){
					JSONObject result = JSONUtil.parseJSON(resultstr);
					resp.put("code", result.getInt("code"));
					resp.put("tip", "服务器成功关闭！！！");
					resp.put("server", JSONUtil.parseSimpleJSON(target, GameServerInfo.class));
					int count = 0;
					while(target.getState() > 0){
						count++;
						Thread.sleep(100);
						updateState(target, true);
						if(count >= 10){
							break;
						}
					}
					GameServerCache.load();
				}else{
					resp.put("code", -1);
					resp.put("tip", "服务器关闭异常！！！");
				}
			}
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}

	//TODO 
	/******************************************************************************************/
	
	private static void updateState(GameServerInfo server, boolean actice){
		int time = 10;
		if(server.getAdminUrl().indexOf("192.168.") == -1){
			time = 100;
		}
		try{
			URL url = new URL(server.getAdminUrl());
			InetAddress inetAddress = InetAddress.getByName(url.getHost());
			Socket socket = new Socket();
			InetSocketAddress address = new InetSocketAddress(inetAddress.getHostAddress(), url.getPort());
			socket.connect(address, time);
			socket.close();
			server.setState(1);
		}catch(Exception e){
			server.setState(0);
		}
		server.setStateTime(TimeUtil.getNowSecond());
		if(actice){
			try{
				Connection conn = ConnUtil.getConnection();
				try{
					Statement stat = conn.createStatement();
					try{
						stat.executeUpdate(server.getUpdateData());
					}catch(Exception e){
						e.printStackTrace();
					}finally{
						stat.close();
					}
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static List<GameServerInfo> getGameServers() throws Exception{
		List<GameServerInfo> servers = new ArrayList<GameServerInfo>();
		Connection conn = ConnUtil.getConnection();
		try{
			Statement stmt = conn.createStatement();
			try{
				String sql = "select * from " + new GameServerInfo().getTableName();
				ResultSet result = stmt.executeQuery(sql);
				try{
					while(result.next()){
						GameServerInfo server = new GameServerInfo();
						server.read(result);
						servers.add(server);
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
		return servers;
	}
	
}
