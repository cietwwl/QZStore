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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cache.GamePartnerCache;
import com.cache.GameServerCache;
import com.db.util.ConnParam;
import com.db.util.ConnUtil;
import com.game.action.EActionPool;
import com.game.action.GameMailAction;
import com.game.constant.GameCmd;
import com.http.message.CommonHttpRequest;
import com.ks.constant.SystemConstant;
import com.ks.db.model.SysMail;
import com.ks.db.model.User;
import com.ks.table.SysMailTable;
import com.ks.table.UserTable;
import com.utils.DBBeanUtil;
import com.utils.HttpUtil;
import com.utils.JSONUtil;
import com.utils.StringUtil;
import com.utils.TimeUtil;
import com.web.db.bean.SysUserInfo;
import com.web.db.game.GameMailInfo;
import com.web.db.game.GameServerInfo;
import com.web.obj.ParamError;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 邮件逻辑类
 *
 */
public class GameMailService {
	
	/**
	 * //TODO 获取游戏邮件列表-jsp
	 * @param server
	 * @param sendType
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getGameMailList(HttpServletRequest request, HttpSession session) throws Exception{
		ParamError error = new ParamError();
		int sendType = ServletService.getParamInt(request, "sendType", error);
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			if(server == null){
				resp = error.getServerError();
			}else{
				int total = 0;
				int begin = (pageNumber - 1) * pageSize;
				List<SysMail> list = new ArrayList<SysMail>();
				Connection conn = ConnUtil.getConnection(server.getMainConnParam());
				try{
					Statement stmt = conn.createStatement();
					try{
						String sql = "select * from " + SysMailTable.TABLE_NAME;
						String condition = "";
						if(sendType != 0){
							condition = " where " + SysMailTable.SENDTYPE + "=" + sendType;
						}
						sql = sql + condition + " order by " + SysMailTable.ID + " desc limit " + begin + "," + pageSize;
						ResultSet rs = stmt.executeQuery(sql);
						while(rs.next()){
							SysMail info = new SysMail();
							info = DBBeanUtil.read(info, rs);
							list.add(info);
						}
						String sql1 = "select count(*) from " + SysMailTable.TABLE_NAME + condition;
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
				for(SysMail mail : list){
					JSONObject obj = JSONUtil.parseSimpleJSON(mail, SysMail.class);
					obj.put("sid", server.getServerId());
					obj.put("partnerName", GamePartnerCache.getPartnerName(mail.getPartner()));
					array.add(obj);
				}
				resp.put("rows", array);
				resp.put("code", 0);
			}
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO 获取本地邮件-jsp
	 * @param state
	 * @param serverId
	 * @param pageNumber
	 * @param pageSize
	 * @return 
	 * @throws Exception 
	 */
	public static JSONObject getMailList(HttpServletRequest request) throws Exception{
		ParamError error = new ParamError();
		int state = ServletService.getParamInt(request, "state", error);
		String serverId = ServletService.getParamString(request, "serverId", error);
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int total = 0;
			int begin = (pageNumber - 1) * pageSize;
			List<GameMailInfo> list = new ArrayList<GameMailInfo>();
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + new GameMailInfo().getTableName();
					String condition = "";
					if(state != -1){
						condition = " where n_state=" + state;
					}
					if(serverId != null && serverId.length() > 0){
						if(condition.length() > 0){
							condition = condition + " and n_serverId=" + StringUtil.getSqlValue(serverId);
						}else{
							condition = " where n_serverId=" + StringUtil.getSqlValue(serverId);
						}
					}
					sql = sql + condition + " order by n_id desc limit " + begin + "," + pageSize;
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){
						GameMailInfo info = new GameMailInfo();
						info.read(rs);
						list.add(info);
					}
					String sql1 = "select count(n_id) from " + new GameMailInfo().getTableName() + condition;
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
			for(GameMailInfo info : list){
				JSONObject json = info.toJson();
				json.put("serverName", GameServerCache.getServerName(info.getServerId()));
				json.put("partnerName", GamePartnerCache.getPartnerName(info.getPartner()));
				array.add(json);
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
	 * //TODO 游戏邮件删除-jsp
	 * @param ids
	 * @param serverId
	 * @return
	 * @throws Exception 
	 */
	public static JSONObject mailDelete(HttpServletRequest request) throws Exception{
		ParamError error = new ParamError();
		String ids = ServletService.getParamString(request, "ids", error);
		String serverId = ServletService.getParamString(request, "serverId", error);
		JSONObject resp = null;
		if(error.isSuccess() && ids.length() > 0){
			resp = new JSONObject();
			GameServerInfo server = GameServerCache.getGameServerInfo(serverId);
			if(server != null){
				CommonHttpRequest hreq = new CommonHttpRequest(server.getAdminUrl(), CommonHttpRequest.METHOD_POST);
				hreq.addParam("mailIds", ids);
				hreq.addParam("check", server.getAdminCheck());
				hreq.addParam("action", GameCmd.CMD_MAIL_DELETE);
				String resultstr = HttpUtil.send(hreq);
				if(resultstr.length() > 0){
					JSONObject result = JSONUtil.parseJSON(resultstr);
					resp.put("code", result.getInt("code"));
				}else{
					resp.put("code", -1);
					resp.put("tip", "删除邮件请求异常，请确认对应服务器是否开启！");
				}
			}else{
				resp.put("code", -1);
				resp.put("tip", "服务器不存在！！！");
			}
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO 系统邮件申请-jsp
	 * @param user
	 * @param partner
	 * @param sendType
	 * @param title
	 * @param content
	 * @param serverIdStr
	 * @param openids
	 * @param nicknames
	 * @param selTime
	 * @param itemStr
	 * @return 
	 */
	public static JSONObject sysmailApply(HttpServletRequest request, HttpSession session) throws Exception{
		ParamError error = new ParamError();
		int partner = ServletService.getParamInt(request, "partner", error);
		int sendType = ServletService.getParamInt(request, "sendType", error);
		String title = ServletService.getParamString(request, "title", error);
		String content = ServletService.getParamString(request, "content", error);
		String serverIdStr = ServletService.getParamString(request, "servers", error);
		String openids = ServletService.getParamString(request, "openids", error);
		String nicknames = ServletService.getParamString(request, "nicknames", error);
		String selTime = ServletService.getParamString(request, "selTime", error);
		String itemStr = ServletService.getParamString(request, "items", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			SysUserInfo user = (SysUserInfo)session.getAttribute("user");
			if(user == null){
				resp = error.getUserError();
			}else{
				List<Integer> serverIds = StringUtil.parseList(serverIdStr, ";");
				List<GameServerInfo> servers = GameServerCache.getGameServers();
				int code = 0;
				String tip = "";
				Connection conn1 = ConnUtil.getConnection();
				try{
					conn1.setAutoCommit(false);
					Statement stmt1 = conn1.createStatement();
					try{
						List<GameMailInfo> adds = new ArrayList<GameMailInfo>();
						out : for(Integer id : serverIds){
							for(GameServerInfo server : servers){
								if(server.getId() == id){
									String t = "";
									Set<Integer> uidset = new HashSet<Integer>();
									Set<String> openidset = new HashSet<String>();
									if(sendType == SystemConstant.SYS_MAIL_TYPE_USER){
										ConnParam mainConnParam = server.getMainConnParam();
										Connection conn = ConnUtil.getConnection(mainConnParam);
										try{
											if(openids != null && openids.length() > 0){
												String[] strs = openids.split(";");
												List<String> list = new ArrayList<String>();
												String sql = "select * from " + UserTable.TABLE_NAME + " where "
														+ UserTable.USERNAME + " in (";
												for(String str : strs){
													sql += StringUtil.getSqlValue(str) + ",";
													list.add(str);
												}
												sql = sql.substring(0, sql.length() - 1);
												sql += ")";
												Statement stmt = conn.createStatement();
												try{
													ResultSet result = stmt.executeQuery(sql);
													while(result.next()){
														User player = new User();
														player = DBBeanUtil.read(player, result);
														list.remove(player.getUsername());
														if(uidset.add(player.getUserId())){
															openidset.add(player.getUsername());
														}
													}
												}finally{
													stmt.close();
												}
												if(!list.isEmpty()){
													code = -1;
													t = "玩家帐号";
													for(String str : list){
														t += "[" + str + "]";
													}
												}
											}
											if(nicknames != null && nicknames.length() > 0){
												String[] strs = nicknames.split(";");
												List<String> list = new ArrayList<String>();
												String sql = "select * from " + UserTable.TABLE_NAME + " where "
														+ UserTable.PLAYERNAME + " in (";
												for(String str : strs){
													sql += StringUtil.getSqlValue(str) + ",";
													list.add(str);
												}
												sql = sql.substring(0, sql.length() - 1);
												sql += ")";
												Statement stmt = conn.createStatement();
												try{
													ResultSet result = stmt.executeQuery(sql);
													while(result.next()){
														User player = new User();
														player = DBBeanUtil.read(player, result);
														list.remove(player.getPlayerName());
														if(uidset.add(player.getUserId())){
															openidset.add(player.getUsername());
														}
													}
												}finally{
													stmt.close();
												}
												if(!list.isEmpty()){
													code = -1;
													if(t.length() > 0){
														t += "、";
													}
													t += "玩家昵称";
													for(String str : list){
														t += "[" + str + "]";
													};
												}
											}
											if(t.length() > 0){
												t = server.getServerName() + "-" + t + "不存在!";
												tip += t + "\n";
											}
										}finally{
											conn.close();
										}
									}else if(sendType == SystemConstant.SYS_MAIL_TYPE_TIMES){
										List<String> list = StringUtil.parseListByString(selTime, "--");
										if(list.size() < 2){
											code = -1;
										}else{
											try{
												Date start = TimeUtil.parseDate(list.get(0),
														TimeUtil.DATE_FORMATER.yyyy_MM_dd_HH_mm_ss);
												Date end = TimeUtil.parseDate(list.get(1),
														TimeUtil.DATE_FORMATER.yyyy_MM_dd_HH_mm_ss);
												if(end.getTime() <= start.getTime()){
													code = -1;
												}else if(end.getTime() <= TimeUtil.getNowSecond()){
													code = -1;
												}else{
													selTime = TimeUtil.getSecond(start.getTime()) + "_"
															+ TimeUtil.getSecond(end.getTime());
												}
											}catch(Exception e){
												code = -1;
											}
										}
										if(code != 0){
											tip = "指定时间已过期，或格式错误！！！！";
											break out;
										}
									}
									if(code == 0){
										GameMailInfo mail = new GameMailInfo();
										mail.setUid(user.getId());
										mail.setUsername(user.getUsername());
										mail.setServerId(server.getServerId());
										mail.setCreateTime(TimeUtil.getNowSecond());
										mail.setPartner(partner);
										mail.setSendType(sendType);
										mail.setTitle(title);
										mail.setContent(content);
										mail.setOpenids(StringUtil.parseString(openidset, ";"));
										mail.setTimes(selTime);
										mail.setItems(itemStr);
										adds.add(mail);
									}
								}
							}
						}
						if(tip.length() <= 0){
							for(GameMailInfo mail : adds){
								stmt1.executeUpdate(mail.getInsertData());
							}
							conn1.commit();
						}
					}finally{
						stmt1.close();
					}
				}finally{
					conn1.close();
				}
				resp = new JSONObject();
				resp.put("code", code);
				resp.put("tip", tip);
			}
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO 系统邮件审核-jsp
	 * @param ids
	 * @param state
	 * @return
	 * @throws Exception 
	 */
	public static JSONObject sysmailAuditing(HttpServletRequest request) throws Exception{
		ParamError error = new ParamError();
		String ids = ServletService.getParamString(request, "ids", error);
		int state = ServletService.getParamInt(request, "state", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			Connection conn = ConnUtil.getConnection();
			List<GameMailInfo> mails = new ArrayList<GameMailInfo>();
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + new GameMailInfo().getTableName() + " where n_id in (" + ids + ")";
					ResultSet rs = stmt.executeQuery(sql);
					try{
						String updateids = "";
						while(rs.next()){
							GameMailInfo mail = new GameMailInfo();
							mail.read(rs);
							if(mail.getState() == 0){
								mail.setState(state);
								mails.add(mail);
								updateids += mail.getId() + ",";
							}
						}
						if(updateids.length() > 0){
							updateids = updateids.substring(0, updateids.length() - 1);
							String updatesql = "update " + new GameMailInfo().getTableName() + " set n_state=" + state + " where n_id in (" + updateids + ")";
							stmt.executeUpdate(updatesql);
						}
					}finally{
						rs.close();
					}
				}finally{
					stmt.close();
				}
			}finally{
				ConnUtil.closeConnection(conn);
			}
			for(GameMailInfo mail : mails){
				EActionPool.addAction(new GameMailAction(mail));
			}
			resp = new JSONObject();
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	
	/**
	 * //TODO 系统邮件删除-jsp
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public static JSONObject sysmailDelete(HttpServletRequest request) throws Exception{
		ParamError error = new ParamError();
		String ids = ServletService.getParamString(request, "ids", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "delete from " + new GameMailInfo().getTableName() + " where n_id in (" + ids + ")";
					stmt.executeUpdate(sql);
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
	 * //TODO 系统邮件刷新-jsp
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public static JSONObject sysmailFlush(HttpServletRequest request) throws Exception{
		ParamError error = new ParamError();
		String ids = ServletService.getParamString(request, "ids", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			resp = new JSONObject();
			if(EActionPool.isEmpty()){
				Connection conn = ConnUtil.getConnection();
				List<GameMailInfo> mails = new ArrayList<GameMailInfo>();
				try{
					Statement stmt = conn.createStatement();
					try{
						List<GameServerInfo> servers = GameServerCache.getGameServers();
						Map<String, GameServerInfo> serverMap = new HashMap<String, GameServerInfo>();
						String sql = "select * from " + new GameMailInfo().getTableName() + " where n_id in (" + ids + ") and n_state=1";
						ResultSet rs = stmt.executeQuery(sql);
						try{
							while(rs.next()){
								GameMailInfo mail = new GameMailInfo();
								mail.read(rs);
								if(!serverMap.containsKey(mail.getServerId())){
									for(GameServerInfo info : servers){
										if(info.getServerId().equals(mail.getServerId())){
											serverMap.put(info.getServerId(), info);
											mails.add(mail);
											break;
										}
									}
								}else{
									mails.add(mail);
								}
							}
						}finally{
							rs.close();
						}
						if(mails.isEmpty()){
							resp.put("code", -1);
							resp.put("tip", "只能刷新‘通过’状态的邮件 !");
						}else{
							String tip = "";
							for(GameServerInfo server : serverMap.values()){
								try{
									//测试地址是否可用
									URL url = new URL(server.getAdminUrl());
									InetAddress inetAddress = InetAddress.getByName(url.getHost());
									Socket socket = new Socket();
									InetSocketAddress address = new InetSocketAddress(inetAddress.getHostAddress(), url.getPort());
									socket.connect(address, 1000);
									socket.close();
								}catch(Exception e){
									tip += server.getServerName() + ",";
								}
							}
							if(tip.length() > 0){
								resp.put("code", -1);
								resp.put("tip", "服务器 [ " + tip.substring(0, tip.length() - 1)+ " ] 不可用 !");
							}else{
								for(GameMailInfo mail : mails){
									EActionPool.addAction(new GameMailAction(mail));
								}
								resp.put("code", 0);
							}
						}
					}finally{
						stmt.close();
					}
				}finally{
					ConnUtil.closeConnection(conn);
				}
			}else{
				resp.put("code", -1);
				resp.put("tip", "事务处理繁忙，请稍后刷新！");
			}
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	

	//TODO 
	/******************************************************************************************/
	
	public static GameMailInfo getGameMaillInfo(int mid) throws Exception{
		GameMailInfo mail = null;
		Connection conn = ConnUtil.getConnection();
		try{
			Statement stmt = conn.createStatement();
			try{
				String sql = "select * from " + new GameMailInfo().getTableName() + " where n_id =" + mid;
				ResultSet rs = stmt.executeQuery(sql);
				
				try{
					if(rs.next()){
						mail = new GameMailInfo();
						mail.read(rs);
					}
				}finally{
					rs.close();
				}
			}finally{
				stmt.close();
			}
		}finally{
			ConnUtil.closeConnection(conn);
		}
		return mail;
	}
}
