package com.game.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cache.GamePartnerCache;
import com.db.util.ConnParam;
import com.db.util.ConnUtil;
import com.ks.db.cfg.PayGoods;
import com.ks.db.cfg.ZoneBattle;
import com.ks.db.log.ActiveLogger;
import com.ks.db.log.OnlineReportLogger;
import com.ks.db.model.User;
import com.ks.table.ActiveLoggerTable;
import com.ks.table.LoginLoggerTable;
import com.ks.table.OnlineReportLoggerTable;
import com.ks.table.PayGoodsTable;
import com.ks.table.RegistLossLoggerTable;
import com.ks.table.UserTable;
import com.ks.table.ZoneBattleLoggerTable;
import com.ks.table.ZoneBattleTable;
import com.ks.util.XyStringUtil;
import com.ks.util.XyTimeUtil;
import com.utils.DBBeanUtil;
import com.utils.SQLUtil;
import com.utils.StringUtil;
import com.utils.TimeUtil;
import com.utils.TimeUtil.DATE_FORMATER;
import com.web.db.game.GameBillInfo;
import com.web.db.game.GameDailyRechargeInfo;
import com.web.db.game.GameDurationInfo;
import com.web.db.game.GameFirstDurationInfo;
import com.web.db.game.GameKeepInfo;
import com.web.db.game.GameLevelLossInfo;
import com.web.db.game.GamePandectInfo;
import com.web.db.game.GameRegistLossInfo;
import com.web.db.game.GameRegistReportInfo;
import com.web.db.game.GameServerInfo;
import com.web.db.game.GameTwiceLoginInfo;
import com.web.obj.ParamError;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 游戏统计逻辑类
 *
 */
public class GameStatsService {
	
	/**
	 * //TODO 获取战斗流失统计-jsp 
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getBattleLossList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		int type = ServletService.getParamInt(request, "type", error);
		String begintimestr = ServletService.getParamString(request, "begin", error);
		String endtimestr = ServletService.getParamString(request, "end", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int limitNum = (pageNumber - 1) * pageSize;
			Date beginDate = TimeUtil.parseDate(begintimestr, DATE_FORMATER.yyyy_MM_dd);
			Date endDate = TimeUtil.parseDate(endtimestr, DATE_FORMATER.yyyy_MM_dd);
			int beginTime = TimeUtil.getSecond(beginDate.getTime());
			int endTime = TimeUtil.getSecond(endDate.getTime()) + XyTimeUtil.DAY_SECOND;
			if(endTime - beginTime >= TimeUtil.DAY_SECOND * 30){
				beginTime = endTime - TimeUtil.DAY_SECOND * 30;
			}
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			ConnParam mainConnParam = server.getMainConnParam();
			Connection conn = ConnUtil.getConnection(mainConnParam);
			try{
				Statement stmt = conn.createStatement();
				try{
					String userIds = "";
					String sql = "select " + UserTable.USERID + " from " + UserTable.TABLE_NAME + " where " + SQLUtil.parseUnixTimestamp(UserTable.LASTLOGINTIME) + " >= " + XyTimeUtil.getTimeOfSecond(0, 0, 0); 
					ResultSet rs = stmt.executeQuery(sql);
					try{
						while(rs.next()){
							userIds += rs.getInt(1) + ",";
						}
						if(userIds.length() > 0){
							userIds = userIds.substring(0, userIds.length() - 1);
						}
					}finally{
						rs.close();
					}
					int total = 0;
					String zoneCondition = ZoneBattleLoggerTable.ZONEID + ">=" + (type * 1000) + " and " + ZoneBattleLoggerTable.ZONEID + "<=" + (type * 1000 + 1000);
					String timeCondition = ZoneBattleLoggerTable.CREATETIME + " between " + beginTime + " and " + endTime;
					String having = " group by " + ZoneBattleLoggerTable.ZONEBATTLEID + " having count(" + ZoneBattleLoggerTable.ZONEBATTLEID + ")>0";
					String fromTable = " from " + ZoneBattleLoggerTable.TABLE_NAME + " where " + zoneCondition + " and " + timeCondition + having;
					String csql = "select count(*) from (select *" + fromTable + ")table1";
					rs = stmt.executeQuery(csql);
					try{
						if(rs.next()){
							total = rs.getInt(1);
						}else{
							total = 0;
						}
					}finally{
						rs.close();
					}
					JSONArray array = new JSONArray();
					if(total > 0){
						Map<Integer, ZoneBattle> configMap = new HashMap<Integer, ZoneBattle>();
						Connection conn1 = ConnUtil.getConnection(server.getConfigConnParam());
						try{
							Statement stmt1 = conn1.createStatement();
							try{
								String sql1 = "select * from " + ZoneBattleTable.TABLE_NAME;
								ResultSet rs1 = stmt1.executeQuery(sql1);
								while(rs1.next()){
									ZoneBattle battle = DBBeanUtil.read(new ZoneBattle(), rs1);
									configMap.put(battle.getBattleId(), battle);
								}
							}finally{
								stmt1.close();
							}
						}finally{
							conn1.close();
						}
						String idsCondition = "";
						if(userIds.length() > 0){
							idsCondition = ZoneBattleLoggerTable.USERID + " not in (" + userIds + ") and ";
						}
						String firstNum = " count(case when " + ZoneBattleLoggerTable.FIRSTSTATE + " = 1 then " + ZoneBattleLoggerTable.FIRSTSTATE + " end) as firstNum,";
						String countNum = " count(*) as countNum,";
						String battleLossNum = " count(case when " + idsCondition + ZoneBattleLoggerTable.STATE + " = 1 then " + ZoneBattleLoggerTable.USERID + " end) as battleLossNum,";
						String endLossNum = " count(case when " + idsCondition + ZoneBattleLoggerTable.STATE + " != 1 then " + ZoneBattleLoggerTable.USERID + " end) as endLossNum";
						sql =  "select zoneId, zoneBattleId," + firstNum + countNum + battleLossNum + endLossNum + fromTable + " limit " + limitNum + "," + pageSize;
						rs = stmt.executeQuery(sql);
						try{
							while(rs.next()){
								JSONObject obj = new JSONObject();
								obj.put("battleId", rs.getInt("zoneBattleId"));
								obj.put("zoneId", rs.getInt("zoneId"));
								obj.put("firstNum", rs.getInt("firstNum"));
								obj.put("countNum", rs.getInt("countNum"));
								obj.put("battleLossNum", rs.getInt("battleLossNum"));
								obj.put("battleEndLossNum", rs.getInt("endLossNum"));
								ZoneBattle battle = configMap.get(obj.get("battleId"));
								if(battle != null){
									obj.put("name", battle.getName());
								}else{
									obj.put("name", "");
								}
								array.add(obj);
							}
						}finally{
							rs.close();
						}
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
	 * //TODO 获取在线时长统计-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getDurationList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		String begintime = ServletService.getParamString(request, "begin", error);
		String endtime = ServletService.getParamString(request, "end", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			Date beginDate = TimeUtil.parseDate(begintime, DATE_FORMATER.yyyy_MM_dd);
			Date endDate = TimeUtil.parseDate(endtime, DATE_FORMATER.yyyy_MM_dd);
			int beginTime = TimeUtil.getSecond(beginDate.getTime());
			int endTime = TimeUtil.getSecond(endDate.getTime()) + TimeUtil.DAY_SECOND;
			if(endTime - beginTime >= TimeUtil.DAY_SECOND * 30){
				beginTime = endTime - TimeUtil.DAY_SECOND * 30;
			}
			int[] a = {60,30,15,10,5,1,0};
			List<GameDurationInfo> list = new ArrayList<GameDurationInfo>();
			List<GameDurationInfo> infos = new ArrayList<GameDurationInfo>();
			Connection con = ConnUtil.getConnection();
			try{
				Statement stmt1 = con.createStatement();
				try{
					GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
					String sql1 = "select * from " + new GameDurationInfo().getTableName() + " where n_serverId='" + server.getServerId() + "' and n_time between " + beginTime + " and " + endTime;
					ResultSet rs1 = stmt1.executeQuery(sql1);
					try{
						while(rs1.next()){
							GameDurationInfo info = new GameDurationInfo();
							info.read(rs1);
							list.add(info);
						}
					}finally{
						rs1.close();
					}
					int zero = TimeUtil.getSecond(TimeUtil.getDate(0, 0, 0).getTime());
					for(int time = beginTime; time < endTime; time += TimeUtil.DAY_SECOND){
						boolean add = true; 
						for(GameDurationInfo info : list){
							if(info.getTime() == time){
								add = false;
								break;
							}
						}
						if(add){
							GameDurationInfo info = new GameDurationInfo();
							info.setServerId(server.getServerId());
							if(time > zero){
								time = zero;
							}
							info.setTime(time);
							infos.add(info);
						}
					}
					if(!infos.isEmpty()){
						ConnParam mainConnParam = server.getMainConnParam();
						Connection conn = ConnUtil.getConnection(mainConnParam);
						try{
							Statement stmt2 = conn.createStatement();
							try{
								for(GameDurationInfo info : infos){
									int totalNum = 0;
									Map<Integer, Integer> map = new HashMap<Integer, Integer>();
									int initTime = info.getTime();
									int dayTime = initTime + TimeUtil.DAY_SECOND;
									String sql2 = "select * from " + ActiveLoggerTable.TABLE_NAME + " where loginTime between " + initTime + " and " + dayTime;
									ResultSet rs2 = stmt2.executeQuery(sql2);
									try{
										while(rs2.next()){
											ActiveLogger logger = DBBeanUtil.read(new ActiveLogger(), rs2);
											if(logger.getTotalOnlineTime() > 0){
												int val = logger.getTotalOnlineTime() / 60;
												for(int i = 0; i < a.length; i++){
													if(val > a[i]){
														val = i;
														break;
													}
												}
												Integer value = map.get(val);
												if(value == null){
													map.put(val, 1);
												}else{
													map.put(val, value + 1);
												}
												totalNum ++;
											}
										}
									}finally{
										rs2.close();
									}
									info.setDurationNums(XyStringUtil.parseString(map, XyStringUtil.JOIN_VERTICALLINE, XyStringUtil.JOIN_UNDERLINE));
									info.setTotalNum(totalNum);
									if(info.getTime() != zero){
										stmt1.executeUpdate(info.getInsertData());
									}
									list.add(info);
								}
							}finally{
								stmt2.close();
							}
						}finally{
							conn.close();
						}
					}
				}finally{
					stmt1.close();
				}
			}finally{
				con.close();
			}
			infos.clear();
			if(!list.isEmpty()){
				for(GameDurationInfo info : list){
					int val = -1;
					for(int j = 0; j < infos.size(); j++){
						GameDurationInfo target = infos.get(j);
						if(target.getTime() > info.getTime()){
							val = j;
							break;
						}
					}
					if(val == -1){
						infos.add(info);
					}else{
						infos.add(val, info);
					}
				}
			}
			JSONArray array = new JSONArray();
			for(GameDurationInfo info : infos){
				if(info.getTime() < endTime){
					JSONObject json = new JSONObject();
					json.put("time", info.getTime());
					Map<Integer, Integer> map = XyStringUtil.parseMap(info.getDurationNums(), XyStringUtil.SPLIT_VERTICALLINE, XyStringUtil.SPLIT_UNDERLINE);
					for(int i = 0; i < a.length; i++){
						Integer val = map.get(i);
						if(val == null){
							json.put("durationNum" + i, 0);
						}else{
							json.put("durationNum" + i, val);
						}
					}
					json.put("totalNum", info.getTotalNum());
					array.add(json);
				}
			}
			resp = new JSONObject();
			resp.put("page", 1);
			resp.put("total", infos.size());
			resp.put("rows", array);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO 首登在线时长-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getFirstDurationList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		String begintime = ServletService.getParamString(request, "begin", error);
		String endtime = ServletService.getParamString(request, "end", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			Date beginDate = TimeUtil.parseDate(begintime, DATE_FORMATER.yyyy_MM_dd);
			Date endDate = TimeUtil.parseDate(endtime, DATE_FORMATER.yyyy_MM_dd);
			int beginTime = TimeUtil.getSecond(beginDate.getTime());
			int endTime = TimeUtil.getSecond(endDate.getTime()) + TimeUtil.DAY_SECOND;
			if(endTime - beginTime >= TimeUtil.DAY_SECOND * 30){
				beginTime = endTime - TimeUtil.DAY_SECOND * 30;
			}
			int count = 0;
			int[] a = {60,30,15,10,5,1,0};
			String[] b = {"60分钟以上","30-60分钟","15-30分钟","10-15分钟","5-10分钟","1-5分钟","1分钟以下"};
			Map<Integer, Integer> sendMap = new HashMap<Integer, Integer>();
			Connection con = ConnUtil.getConnection();
			try{
				Statement stmt1 = con.createStatement();
				try{
					List<GameFirstDurationInfo> list = new ArrayList<GameFirstDurationInfo>();
					List<GameFirstDurationInfo> infos = new ArrayList<GameFirstDurationInfo>();
					GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
					String sql1 = "select * from " + new GameFirstDurationInfo().getTableName() + " where n_serverId='" + server.getServerId() + "' and n_time between " + beginTime + " and " + endTime;
					ResultSet rs1 = stmt1.executeQuery(sql1);
					try{
						while(rs1.next()){
							GameFirstDurationInfo info = new GameFirstDurationInfo();
							info.read(rs1);
							list.add(info);
							Map<Integer, Integer> map = XyStringUtil.parseMap(info.getFirstDurationNums(), XyStringUtil.SPLIT_VERTICALLINE, XyStringUtil.SPLIT_UNDERLINE);
							for(int i = 0; i < a.length; i++){
								Integer val = map.get(i);
								if(val != null && val > 0){
									Integer old = sendMap.get(i);
									if(old != null){
										sendMap.put(i, old + val);
									}else{
										sendMap.put(i, val);
									}
									count += val;
								}
							}
						}
					}finally{
						rs1.close();
					}
					int zero = TimeUtil.getSecond(TimeUtil.getDate(0, 0, 0).getTime());
					for(int time = beginTime; time < endTime; time += TimeUtil.DAY_SECOND){
						boolean add = true; 
						for(GameFirstDurationInfo info : list){
							if(info.getTime() == time){
								add = false;
								break;
							}
						}
						if(add){
							GameFirstDurationInfo info = new GameFirstDurationInfo();
							info.setServerId(server.getServerId());
							if(time > zero){
								time = zero;
							}
							info.setTime(time);
							infos.add(info);
						}
					}
					if(!infos.isEmpty()){
						ConnParam mainConnParam = server.getMainConnParam();
						Connection conn = ConnUtil.getConnection(mainConnParam);
						try{
							Statement stmt2 = conn.createStatement();
							try{
								for(GameFirstDurationInfo info : infos){
									int totalNum = 0;
									Map<Integer, Integer> map = new HashMap<Integer, Integer>();
									int initTime = info.getTime();
									int dayTime = initTime + TimeUtil.DAY_SECOND;
									String sql2 = "select * from " + UserTable.TABLE_NAME + " where " + SQLUtil.parseUnixTimestamp(UserTable.CREATETIME) + " between " + initTime + " and " + dayTime + " and " + UserTable.FIRSTONLINETIME + " > 0";
									ResultSet rs2 = stmt2.executeQuery(sql2);
									try{
										while(rs2.next()){
											User user = DBBeanUtil.read(new User(), rs2);
											int val = user.getFirstOnlineTime() / 60;
											for(int i = 0; i < a.length; i++){
												if(val > a[i]){
													val = i;
													break;
												}
											}
											Integer value = map.get(val);
											if(value == null){
												map.put(val, 1);
											}else{
												map.put(val, value + 1);
											}
											Integer old = sendMap.get(val);
											if(old != null){
												sendMap.put(val, old + 1);
											}else{
												sendMap.put(val, 1);
											}
											totalNum ++;
											count++;
										}
									}finally{
										rs2.close();
									}
									info.setFirstDurationNums(XyStringUtil.parseString(map, XyStringUtil.JOIN_VERTICALLINE, XyStringUtil.JOIN_UNDERLINE));
									info.setTotalNum(totalNum);
									if(info.getTime() != zero){
										stmt1.executeUpdate(info.getInsertData());
									}
								}
							}finally{
								stmt2.close();
							}
						}finally{
							conn.close();
						}
					}
				}finally{
					stmt1.close();
				}
			}finally{
				con.close();
			}
			int total = 0;
			JSONArray array = new JSONArray();
			DecimalFormat format = new DecimalFormat("0.00");
			for(int k = a.length - 1; k >= 0; k--){
				JSONObject json = new JSONObject();
				json.put("timeName", b[k]);
				Integer curNum = sendMap.get(k);
				if(curNum == null){
					curNum = 0;
				}
				json.put("curNum", curNum);
				json.put("totalNum", count);
				if(curNum > 0 && count > 0){
					double value = curNum / (double)count * 100;
					json.put("percent", new Double(format.format(value)));
				}else {
					json.put("percent", 0);
				}
				array.add(json);
				total++;
			}
			resp = new JSONObject();
			resp.put("page", 1);
			resp.put("total", total);
			resp.put("rows", array);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 *  //TODO 获取留存统计-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getKeepList(HttpServletRequest request, HttpSession session) throws Exception{
		ParamError error = new ParamError();
		String begintimestr = ServletService.getParamString(request, "begintime", error);
		String endtimestr = ServletService.getParamString(request, "endtime", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			Date beginDate = TimeUtil.parseDate(begintimestr, DATE_FORMATER.yyyy_MM_dd);
			Date endDate = TimeUtil.parseDate(endtimestr, DATE_FORMATER.yyyy_MM_dd);
			int beginTime = TimeUtil.getSecond(beginDate.getTime());
			int endTime = TimeUtil.getSecond(endDate.getTime());
			if(endTime - beginTime >= TimeUtil.DAY_SECOND * 30){
				beginTime = endTime - TimeUtil.DAY_SECOND * 30;
			}
			List<GameKeepInfo> list = new ArrayList<GameKeepInfo>();
			if(server != null){
				int now = TimeUtil.getNowSecond();
				Date today = TimeUtil.getDate(0, 0, 0);
				int zero = TimeUtil.getSecond(today.getTime());
				beginTime =  getZeroTime(server, beginTime);
				endTime = getZeroTime(server, endTime);
				Connection conn = ConnUtil.getConnection();
				try{
					Statement stmt = conn.createStatement();
					String sql = "select * from " + new GameKeepInfo().getTableName() + " where n_serverId=" + StringUtil.getSqlValue(server.getServerId())
							+ " and n_time >= " + beginTime + " and n_time <= " + endTime + " order by n_time";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){
						GameKeepInfo info = new GameKeepInfo();
						info.read(rs);
						list.add(info);
					}
					Connection conn1 = ConnUtil.getConnection(server.getMainConnParam());
					try{
						Statement stmt1 = conn1.createStatement();
						for(int time = beginTime; time <= endTime; time += TimeUtil.DAY_SECOND){
							GameKeepInfo target = null;
							for(GameKeepInfo info : list){
								if(info.getTime() == time){
									target = info;
									break;
								}
							}
							int day = (zero - time) / TimeUtil.DAY_SECOND;
							int loginEnd = zero;
							int loginBegin = loginEnd - TimeUtil.DAY_SECOND;
							int registBegin = time;
							int registEnd = time + TimeUtil.DAY_SECOND;
							int keepDay = day - 1;
							boolean insert = false;
							boolean update = false;
							String like = " ";
							if(server.getMerge() == 1){
								like += UserTable.USERNAME + " like '" + server.getServerId() + "_%' and "; 
							}
							if(target == null && registEnd <= now){
								target = new GameKeepInfo();
								target.setTime(time);
								target.setServerId(server.getServerId());
								String regsql = "select count("+UserTable.USERID+") from "+UserTable.TABLE_NAME+" where " + like + "unix_timestamp(" + UserTable.CREATETIME + ") >=" + registBegin + " and unix_timestamp(" + UserTable.CREATETIME + ") < " + registEnd;
								ResultSet rs1 = stmt1.executeQuery(regsql);
								if(rs1.next()){
									int regist = rs1.getInt(1);
									target.setRegist(regist);
								}
								String nsql = "select count(distinct "+RegistLossLoggerTable.USERNAME+","+RegistLossLoggerTable.PARTNER+") from "+RegistLossLoggerTable.TABLE_NAME+" where "  + like +  RegistLossLoggerTable.TYPE + " = 1 and "+RegistLossLoggerTable.TIME+" >= " + registBegin + " and "+RegistLossLoggerTable.TIME+" < " + registEnd;
								ResultSet rs2 = stmt1.executeQuery(nsql);
								if(rs2.next()){
									int newAmount = rs2.getInt(1);
									target.setNewAmount(newAmount);
								}
								insert = true;
							}
							if(target != null){
								while(day >= 2){
									if(target.unReportKeep(keepDay)){
										String rsql = "select count(distinct "+LoginLoggerTable.USERID+") from "+LoginLoggerTable.TABLE_NAME+" where "  + like +  " "+RegistLossLoggerTable.TIME+" >= " + loginBegin + " and "+RegistLossLoggerTable.TIME+" < " + loginEnd + " and "+RegistLossLoggerTable.TYPE+ "= 2"
												+ " and "+LoginLoggerTable.USERID+" in (select "+UserTable.USERID+" from "+UserTable.TABLE_NAME+" where "  + like +  " unix_timestamp(" + UserTable.CREATETIME + ") >= " + registBegin + " and unix_timestamp(" + UserTable.CREATETIME + ") < " + registEnd  + ")";
										ResultSet rs1 = stmt1.executeQuery(rsql);
										if(rs1.next()){
											int keep = rs1.getInt(1);
											target.setKeep(keep, keepDay);
										}
										update = true;
									}
									loginEnd -= TimeUtil.DAY_SECOND;
									loginBegin = loginEnd - TimeUtil.DAY_SECOND;
									day--;
									keepDay--;
								}
								if(insert){
									ConnUtil.insert(stmt, target);
									list.add(target);
								}else if(update){
									String usql = target.getUpdateData();
									stmt.executeUpdate(usql);
								}
							}
						}
					}finally{
						conn1.close();
					}
				}finally{
					conn.close();
				}
			}
			Collections.sort(list);
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("page", 1);
			result.put("total", list.size());
			JSONArray array = new JSONArray();
			for(GameKeepInfo info : list){
				array.add(info.toJson());
			}
			result.put("rows", array);
			resp = JSONObject.fromObject(result);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 *  //TODO 获取等级流失统计-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getLevelLossList(HttpServletRequest request, HttpSession session)throws Exception{
		GameServerInfo server = (GameServerInfo)session.getAttribute("selserver");
		List<GameLevelLossInfo> list = new ArrayList<GameLevelLossInfo>();
		if(server != null){
			int now = TimeUtil.getNowSecond();
			Date today = TimeUtil.getDate(0, 0, 0);
			int zero = TimeUtil.getSecond(today.getTime());
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				String sql = "select * from " + new GameLevelLossInfo().getTableName() + " where n_serverId=" + StringUtil.getSqlValue(server.getServerId()) + " order by n_level";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					GameLevelLossInfo info = new GameLevelLossInfo();
					info.read(rs);
					list.add(info);
				}
				boolean update = true;
				if(!list.isEmpty()){
					GameLevelLossInfo info = list.get(0);
					if(now - info.getTime() < 5 * TimeUtil.MINUTE_SECOND){
						update = false;
					}
				}
				if(update){
					String createsql = "truncate " + new GameLevelLossInfo().getTableName();
					stmt.executeUpdate(createsql);
					list.clear();
					Connection conn1 = ConnUtil.getConnection(server.getMainConnParam());
					try{
						Statement stmt1 = conn1.createStatement();
						String rcsql = "select count(" + UserTable.USERID + ") from " + UserTable.TABLE_NAME;
						ResultSet rs1 = stmt1.executeQuery(rcsql);
						int rcount = 0;
						if(rs1.next()){
							rcount = rs1.getInt(1);
						}
						String csql = "select y.lv n_level, y.cn n_levelAmount, y.cn1 n_lossAmount, count(p."+UserTable.USERID+") n_reachLevelAmount from " + UserTable.TABLE_NAME + " p,"
								+ " (select a.lv lv, a.cn cn,  case when ISNULL(b.cn) then 0 else b.cn END 'cn1' from("
								+ " select "+UserTable.LEVEL+" lv, count("+UserTable.USERID+") cn from " + UserTable.TABLE_NAME + " GROUP BY "+UserTable.LEVEL+") a "
								+ " left join (select "+UserTable.LEVEL+" lv, count("+UserTable.USERID+") cn from " + UserTable.TABLE_NAME
								+ " where "+UserTable.ACCESSTIME+" < " + zero + " GROUP BY "+UserTable.LEVEL+") b "
								+ " on a.lv = b.lv) y "
								+ " where "+UserTable.LEVEL+" >= y.lv GROUP BY y.lv";
						System.out.println(csql);
						ResultSet rs2 = stmt1.executeQuery(csql);
						while(rs2.next()){
							GameLevelLossInfo info = new GameLevelLossInfo();
							info.read(rs2);
							info.setServerId(server.getServerId());
							info.setTime(now);
							info.setRegistAmount(rcount);
							list.add(info);
							ConnUtil.insert(stmt, info);
						}
					}finally{
						conn1.close();
					}
				}
			}finally{
				conn.close();
			}
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("page", 1);
		result.put("total", list.size());
		JSONArray array = new JSONArray();
		for(GameLevelLossInfo info : list){
			array.add(info.toJson());
		}
		result.put("rows", array);
		JSONObject json = JSONObject.fromObject(result);
		json.put("code", 0);
		return json;
	}
	
	/**
	 *  //TODO 获取最大在线统计-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getMaxOnlineReport(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int type = ServletService.getParamInt(request, "type", error);
		String begintime = ServletService.getParamString(request, "begin", error);
		String endtime = ServletService.getParamString(request, "end", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			Date beginDate = TimeUtil.parseDate(begintime, DATE_FORMATER.yyyy_MM_dd);
			Date endDate = TimeUtil.parseDate(endtime, DATE_FORMATER.yyyy_MM_dd);
			endDate = new Date(endDate.getTime() + TimeUtil.DAY_MILLIS);
			Date now = TimeUtil.getNextDate(new Date(), Calendar.MINUTE, 10);
			if(TimeUtil.before(now, endDate)){
				endDate = now;
			}
			int beginTime = TimeUtil.getSecond(beginDate.getTime());
			int endTime = TimeUtil.getSecond(endDate.getTime());
			if(endTime - beginTime >= TimeUtil.DAY_SECOND * 30){
				beginTime = endTime - TimeUtil.DAY_SECOND * 30;
			}
			List<OnlineReportLogger> list = new ArrayList<OnlineReportLogger>();
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			ConnParam mainConnParam = server.getMainConnParam();
			Connection conn = ConnUtil.getConnection(mainConnParam);
			try{
				//;
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + OnlineReportLoggerTable.TABLE_NAME + " where " + OnlineReportLoggerTable.TIME + " between " + beginTime + " and " + endTime + " order by " + OnlineReportLoggerTable.TIME;
					if(type == 2){
						sql = "select " + OnlineReportLoggerTable.ID + ", max(" + OnlineReportLoggerTable.AMOUNT + ") as " + OnlineReportLoggerTable.AMOUNT + ", " + OnlineReportLoggerTable.TIME + ", (floor(" + OnlineReportLoggerTable.TIME + "/3600) * 3600) as t from " + OnlineReportLoggerTable.TABLE_NAME + " where " + OnlineReportLoggerTable.TIME + " between " + beginTime + " and " + endTime + " group by t order by " + OnlineReportLoggerTable.TIME;
					}
					ResultSet rs = stmt.executeQuery(sql);
					try{
						while(rs.next()){
							OnlineReportLogger log = new OnlineReportLogger();
							log = DBBeanUtil.read(log, rs);
							list.add(log);
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
			resp.put("page", 1);
			int total = 0;
			JSONArray array = new JSONArray();
			for(int i = beginTime; i <= endTime; i += TimeUtil.DAY_SECOND){
				if(i >= endTime){
					break;
				}
				int time = i + TimeUtil.DAY_SECOND;
				int max = 0;
				int maxTime = 0;
				Iterator<OnlineReportLogger> it = list.iterator();
				while(it.hasNext()){
					OnlineReportLogger info = it.next();
					if(info.getTime() >= i && info.getTime() <= time){
						if(info.getAmount() > max){
							max = info.getAmount();
							maxTime = info.getTime();
						}
						it.remove();
					}
				}
				JSONObject json = new JSONObject();
				json.put("time", i);
				json.put("maxOnline", max);
				json.put("maxOnlineTime", maxTime);
				array.add(json);
				total ++;
			}
			resp.put("total", total);
			resp.put("rows", array);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 *  //TODO 获取在线统计-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getOnlineReport(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int type = ServletService.getParamInt(request, "type", error);
		String begintime = ServletService.getParamString(request, "begin", error);
		String endtime = ServletService.getParamString(request, "end", error);
		int selectTime = ServletService.getParamInt(request, "selectTime", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			Date beginDate = TimeUtil.parseDate(begintime, DATE_FORMATER.yyyy_MM_dd);
			Date endDate = TimeUtil.parseDate(endtime, DATE_FORMATER.yyyy_MM_dd);
			endDate = new Date(endDate.getTime() + TimeUtil.DAY_MILLIS);
			Date now = TimeUtil.getNextDate(new Date(), Calendar.MINUTE, 10);
			if(TimeUtil.before(now, endDate)){
				endDate = now;
			}
			int beginTime = TimeUtil.getSecond(beginDate.getTime());
			int endTime = TimeUtil.getSecond(endDate.getTime());
			if(endTime - beginTime >= TimeUtil.DAY_SECOND * 14){
				beginTime = endTime - TimeUtil.DAY_SECOND * 14;
			}
			List<OnlineReportLogger> list = new ArrayList<OnlineReportLogger>();
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			ConnParam mainConnParam = server.getMainConnParam();
			Connection conn = ConnUtil.getConnection(mainConnParam);
			try{
				//;
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + OnlineReportLoggerTable.TABLE_NAME + " where " + OnlineReportLoggerTable.TIME + " between " + beginTime + " and " + endTime + " order by " + OnlineReportLoggerTable.TIME;
					if(type == 2){
						sql = "select " + OnlineReportLoggerTable.ID + ", max(" + OnlineReportLoggerTable.AMOUNT + ") as " + OnlineReportLoggerTable.AMOUNT + ", " + OnlineReportLoggerTable.TIME + ", (floor(" + OnlineReportLoggerTable.TIME + "/3600) * 3600) as t from " + OnlineReportLoggerTable.TABLE_NAME + " where " + OnlineReportLoggerTable.TIME + " between " + beginTime + " and " + endTime + " group by t order by " + OnlineReportLoggerTable.TIME;
					}
					ResultSet rs = stmt.executeQuery(sql);
					try{
						while(rs.next()){
							OnlineReportLogger log = new OnlineReportLogger();
							log = DBBeanUtil.read(log, rs);
							list.add(log);
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
			resp.put("page", 1);
			int total = 0;
			int size = 0;
			Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
			JSONArray array = new JSONArray();
			for(int i = beginTime; i <= endTime; i += TimeUtil.DAY_SECOND){
				if(i >= endTime){
					break;
				}
				int time = i + TimeUtil.DAY_SECOND;
				JSONArray arra = new JSONArray();
				JSONArray tarra = new JSONArray();
				List<String> cols = new ArrayList<String>();
				Iterator<OnlineReportLogger> it = list.iterator();
				while(it.hasNext()){
					OnlineReportLogger info = it.next();
					if(info.getTime() >= i && info.getTime() <= time){
						tarra.add(info.getTime());
						arra.add(info.getAmount());
						int val = (info.getTime() - i) / 60;
						int minute = val % 60;
						if(minute % selectTime != 0){
							continue;
						}
						int hour = val / 60;
						cols.add((hour < 10 ? "0" + hour : String.valueOf(hour)) + ":" + (minute < 10 ? "0" + minute : String.valueOf(minute)) + " 在线：" + info.getAmount());
						it.remove();
					}
				}
				if(cols.size() > size){
					size = cols.size();
				}
				map.put(i, cols);
				JSONObject json = new JSONObject();
				json.put("time", i);
				json.put("data", arra);
				json.put("date", tarra);
				array.add(json);
				total ++;
			}
			resp.put("total", total);
			resp.put("data", array);
			JSONArray rows = new JSONArray();
			for(int k = 0; k < size; k++){
				JSONObject col = new JSONObject();
				for(int i = beginTime; i <= endTime; i += TimeUtil.DAY_SECOND){
					List<String> cols = map.get(i);
					if(cols != null && cols.size() > k){
						col.put("t" + i, cols.get(k));
					}else{
						col.put("t" + i, "");
					}
				}
				rows.add(col);
			}
			resp.put("rows", rows);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 *  //TODO 获取数据总览-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getPandectList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		String begintime = ServletService.getParamString(request, "begin", error);
		String endtime = ServletService.getParamString(request, "end", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			Date beginDate = TimeUtil.parseDate(begintime, DATE_FORMATER.yyyy_MM_dd);
			Date endDate = TimeUtil.parseDate(endtime, DATE_FORMATER.yyyy_MM_dd);
			int beginTime = TimeUtil.getSecond(beginDate.getTime());
			int endTime = TimeUtil.getSecond(endDate.getTime()) + TimeUtil.DAY_SECOND;
			if(endTime - beginTime >= TimeUtil.DAY_SECOND * 30){
				beginTime = endTime - TimeUtil.DAY_SECOND * 30;
			}
			List<GamePandectInfo> list = new ArrayList<GamePandectInfo>();
			List<GamePandectInfo> infos = new ArrayList<GamePandectInfo>();
			Connection con = ConnUtil.getConnection();
			try{
				Statement stmt1 = con.createStatement();
				try{
					GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
					String sql1 = "select * from " + new GamePandectInfo().getTableName() + " where n_serverId='" + server.getServerId() + "' and n_time between " + beginTime + " and " + endTime;
					ResultSet rs1 = stmt1.executeQuery(sql1);
					try{
						while(rs1.next()){
							GamePandectInfo info = new GamePandectInfo();
							info.read(rs1);
							list.add(info);
						}
					}finally{
						rs1.close();
					}
					int zero = TimeUtil.getSecond(TimeUtil.getDate(0, 0, 0).getTime());
					for(int time = beginTime; time < endTime; time += TimeUtil.DAY_SECOND){
						boolean add = true; 
						for(GamePandectInfo info : list){
							if(info.getTime() == time){
								add = false;
								break;
							}
						}
						if(add){
							GamePandectInfo info = new GamePandectInfo();
							info.setServerId(server.getServerId());
							if(time > zero){
								time = zero;
							}
							info.setTime(time);
							infos.add(info);
						}
					}
					if(!infos.isEmpty()){
						ConnParam mainConnParam = server.getMainConnParam();
						Connection conn = ConnUtil.getConnection(mainConnParam);
						try{
							Statement stmt2 = conn.createStatement();
							try{
								for(GamePandectInfo info : infos){
									int dayCountRegisterNum = 0;
									int dayCountActiveNum = 0;
									long dayCountRecharge = 0;
									int initTime = info.getTime();
									int dayTime = initTime + TimeUtil.DAY_SECOND;
									String sql2 = "select count(*) from " + RegistLossLoggerTable.TABLE_NAME + " where type=1 and time between " + initTime + " and " + dayTime;
									ResultSet rs2 = stmt2.executeQuery(sql2);
									try{
										if(rs2.next()){
											dayCountRegisterNum = rs2.getInt(1);
										}
									}finally{
										rs2.close();
									}
									sql2 = "select count(*) from " + ActiveLoggerTable.TABLE_NAME + " where loginTime between " + initTime + " and " + dayTime;
									rs2 = stmt2.executeQuery(sql2);
									try{
										if(rs2.next()){
											dayCountActiveNum = rs2.getInt(1);
										}
									}finally{
										rs2.close();
									}
									sql1 = "select sum(n_money) from " + new GameBillInfo().getTableName() + " where n_serverId='" + server.getServerId() + "' and n_completeTime between " + initTime + " and " + dayTime;
									rs1 = stmt1.executeQuery(sql1);
									try{
										if(rs1.next()){
											dayCountRecharge = rs1.getLong(1);
										}
									}finally{
										rs1.close();
									}
									info.setDayCountRegisterNum(dayCountRegisterNum);
									info.setDayCountActiveNum(dayCountActiveNum);
									info.setDayCountRecharge(dayCountRecharge);
									if(info.getTime() != zero){
										stmt1.executeUpdate(info.getInsertData());
									}
									list.add(info);
								}
							}finally{
								stmt2.close();
							}
						}finally{
							conn.close();
						}
					}
				}finally{
					stmt1.close();
				}
			}finally{
				con.close();
			}
			infos.clear();
			if(!list.isEmpty()){
				for(GamePandectInfo info : list){
					int val = -1;
					for(int j = 0; j < infos.size(); j++){
						GamePandectInfo target = infos.get(j);
						if(target.getTime() > info.getTime()){
							val = j;
							break;
						}
					}
					if(val == -1){
						infos.add(info);
					}else{
						infos.add(val, info);
					}
				}
			}
			JSONArray array = new JSONArray();
			for(GamePandectInfo info : infos){
				if(info.getTime() < endTime){
					JSONObject json = new JSONObject();
					json.put("time", info.getTime());
					json.put("dayCountRegisterNum", info.getDayCountRegisterNum());
					json.put("dayCountActiveNum", info.getDayCountActiveNum());
					json.put("dayCountRecharge", info.getDayCountRecharge());
					array.add(json);
				}
			}
			resp = new JSONObject();
			resp.put("page", 1);
			resp.put("total", infos.size());
			resp.put("rows", array);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 *  //TODO 获取充值明细-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getRechargeDetailsList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		String begintimestr = ServletService.getParamString(request, "begin", error);
		String endtimestr = ServletService.getParamString(request, "end", error);
		int partner = ServletService.getParamInt(request, "partner", error);
		int userType = ServletService.getParamInt(request, "userType", error);
		String userValue = ServletService.getParamString(request, "userValue", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int limitNum = (pageNumber - 1) * pageSize;
			Date beginDate = TimeUtil.parseDate(begintimestr, DATE_FORMATER.yyyy_MM_dd);
			Date endDate = TimeUtil.parseDate(endtimestr, DATE_FORMATER.yyyy_MM_dd);
			int beginTime = TimeUtil.getSecond(beginDate.getTime());
			int zero = TimeUtil.getSecond(endDate.getTime());
			int endTime = zero + TimeUtil.DAY_SECOND;
			if(endTime - beginTime >= TimeUtil.DAY_SECOND * 30){
				beginTime = endTime - TimeUtil.DAY_SECOND * 30;
			}
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			if(server != null){
				Connection aconn = ConnUtil.getConnection();
				try{
					Statement astmt = aconn.createStatement();
					try{
						int total = 0;
						String billCondition = " where n_serverId='" + server.getServerId() + "' and n_time between " + beginTime + " and " + endTime;
						if(partner > 0){
							billCondition += " and n_partner=" + partner; 
						}
						if(userType > 0 && userValue.length() > 0){
							if(userType == 1){
								billCondition += " and n_username='" + userValue + "'";
							}else{
								billCondition += " and n_playerName='" + userValue + "'";
							}
						}
						List<GameBillInfo> infos = new ArrayList<GameBillInfo>();
						String sql = "select count(*) from " + new GameBillInfo().getTableName() + billCondition;
						ResultSet ars = astmt.executeQuery(sql);
						try{
							if(ars.next()){
								total = ars.getInt(1);
							}
						}finally{
							ars.close();
						}
						String asql = "select * from " + new GameBillInfo().getTableName() + billCondition + " order by n_completeTime" + " limit " + limitNum + "," + pageSize;
						ars = astmt.executeQuery(asql);
						try{
							while(ars.next()){
								GameBillInfo info = new GameBillInfo();
								info.read(ars);
								infos.add(info);
							}
						}finally{
							ars.close();
						}
						JSONArray array = new JSONArray();
						if(!infos.isEmpty()){
							Map<Integer, PayGoods> goodsMap = new HashMap<Integer, PayGoods>();
							Connection conn = ConnUtil.getConnection(server.getConfigConnParam());
							try{
								Statement stmt = conn.createStatement();
								try{
									ResultSet rs = stmt.executeQuery("select * from " + PayGoodsTable.TABLE_NAME);
									try{
										while(rs.next()){
											PayGoods goods = DBBeanUtil.read(new PayGoods(), rs);
											goodsMap.put(goods.getId(), goods);
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
							for(GameBillInfo info : infos){
								JSONObject obj = new JSONObject();
								obj.put("partner", info.getPartner());
								obj.put("time", info.getTime());
								obj.put("rechargeMoney", info.getMoney());
								obj.put("username", info.getUsername());
								obj.put("playername", info.getPlayerName());
								PayGoods goods = goodsMap.get(info.getPayGoodsId());
								if(goods != null){
									obj.put("goodsName", goods.getName());
								}else{
									obj.put("goodsName", "找不到物品配置");
								}
								obj.put("partnerName", GamePartnerCache.getPartnerName(info.getPartner()));
								array.add(obj);
							}
						}
						resp = new JSONObject();
						resp.put("page", pageNumber);
						resp.put("total", total);
						resp.put("rows", array);
						resp.put("code", 0);
					}finally{
						astmt.close();
					}
				}finally{
					aconn.close();
				}
			}
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 *  //TODO 获取充值额度-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getRechargeQuotaList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		String begintime = ServletService.getParamString(request, "begin", error);
		String endtime = ServletService.getParamString(request, "end", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			Date beginDate = TimeUtil.parseDate(begintime, DATE_FORMATER.yyyy_MM_dd);
			Date endDate = TimeUtil.parseDate(endtime, DATE_FORMATER.yyyy_MM_dd);
			int beginTime = TimeUtil.getSecond(beginDate.getTime());
			int endTime = TimeUtil.getSecond(endDate.getTime()) + TimeUtil.DAY_SECOND;
			if(endTime - beginTime >= TimeUtil.DAY_SECOND * 30){
				beginTime = endTime - TimeUtil.DAY_SECOND * 30;
			}
			int[] a = {0, 10,100,200,500,1000,2000,5000,10000};
			String[] b = {"10RMB以下","10-100RMB","100-200RMB","200-500RMB","500-1000RMB","1000-2000RMB","2000-5000RMB", "5000-10000RMB", "10000RMB以上"};
			Map<Integer, Integer> simpleMap = new HashMap<Integer, Integer>();
			Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
			Connection con = ConnUtil.getConnection();
			try{
				Statement stmt = con.createStatement();
				try{
					GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
					for(int i = 0; i < a.length; i++){
						String condition = "";
						if(i != a.length - 1){
							condition = " between " + a[i] + " and " + a[i + 1];
						}else{
							condition = " > " + a[i];
						}
						String sql = "select count(*) from " + new GameBillInfo().getTableName() + " where n_serverId='" + server.getServerId() + "' and n_time between " + beginTime + " and " + endTime + " and n_money " + condition;
						ResultSet rs = stmt.executeQuery(sql);
						try{
							if(rs.next()){
								int value = rs.getInt(1);
								Integer old = simpleMap.get(i);
								if(old == null){
									simpleMap.put(i, value);
								}else if(value > 0){
									simpleMap.put(i, value + old);
								}
							}
						}finally{
							rs.close();
						}
						String sunSql = "select sum(n_money) as money from " + new GameBillInfo().getTableName() + " where n_serverId='" + server.getServerId() + "' and n_time between " + beginTime + " and " + endTime +" group by n_userId";
						rs = stmt.executeQuery("select count(*) from (" + sunSql + ")table2 where money " + condition);
						try{
							if(rs.next()){
								int value = rs.getInt(1);
								Integer old = countMap.get(i);
								if(old == null){
									countMap.put(i, value);
								}else if(value > 0){
									countMap.put(i, value + old);
								}
							}
						}finally{
							rs.close();
						}
					}
				}finally{
					stmt.close();
				}
			}finally{
				con.close();
			}
			int simpleValue = 0;
			for(int value : simpleMap.values()){
				simpleValue += value;
			}
			int countValue = 0;
			for(int value : countMap.values()){
				countValue += value;
			}
			JSONArray array = new JSONArray();
			for(int k = 0; k < a.length; k++){
				JSONObject json = new JSONObject();
				json.put("rechargeQuota", b[k]);
				Integer simpleNum = simpleMap.get(k);
				if(simpleNum == null){
					json.put("simpleNum", 0);
				}else{
					json.put("simpleNum", simpleNum);
				}
				json.put("simplePercent", simpleValue);
				Integer countNum = countMap.get(k);
				if(countNum == null){
					json.put("countNum", 0);
				}else{
					json.put("countNum", countNum);
				}
				json.put("countPercent", countValue);
				array.add(json);
			}
			resp = new JSONObject();
			resp.put("page", 1);
			resp.put("total", a.length);
			resp.put("rows", array);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 *  //TODO 获取充值排行-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getRechargeRankList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		String begintimestr = ServletService.getParamString(request, "begintime", error);
		String endtimestr = ServletService.getParamString(request, "endtime", error);
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int limitNum = (pageNumber - 1) * pageSize;
			Date beginDate = TimeUtil.parseDate(begintimestr, DATE_FORMATER.yyyy_MM_dd);
			Date endDate = TimeUtil.parseDate(endtimestr, DATE_FORMATER.yyyy_MM_dd);
			endDate = new Date(endDate.getTime() + TimeUtil.DAY_MILLIS);
			Date now = TimeUtil.getNextDate(new Date(), Calendar.MINUTE, 10);
			if(TimeUtil.before(now, endDate)){
				endDate = now;
			}
			int total = 0;
			int beginTime = TimeUtil.getSecond(beginDate.getTime());
			int endTime = TimeUtil.getSecond(endDate.getTime());
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			JSONArray array = new JSONArray();
			if(server != null){
				String condition = " where n_serverId=" + StringUtil.getSqlValue(server.getServerId()) + " and n_confirmTime >= " + beginTime + " and n_confirmTime < " + endTime;
				Connection conn = ConnUtil.getConnection();
				try{
					Statement stmt = conn.createStatement();
					try{
						String sql = "select *,sum(n_money) as n_totalMoney,count(n_id) as n_num from " + new GameBillInfo().getTableName() + condition + " group by n_userId order by n_totalMoney desc limit " + limitNum + "," + pageSize;
						ResultSet result = stmt.executeQuery(sql);
						try{
							int rank = limitNum + 1;
							while(result.next()){
								JSONObject obj = new JSONObject();
								obj.put("rank", rank++);
								obj.put("partner", result.getString("n_partner"));
								obj.put("username", result.getString("n_username"));
								obj.put("playerName", result.getString("n_playerName"));
								obj.put("totalMoney", result.getInt("n_totalMoney"));
								obj.put("serverId", result.getString("n_serverId"));
								obj.put("num", result.getString("n_num"));
								obj.put("partnerName", GamePartnerCache.getPartnerName(result.getInt("n_partner")));
								array.add(obj);
							}
						}finally{
							result.close();
						}
						if(array.size() > 0){
							sql = "select count(*) from (select n_userId from " + new GameBillInfo().getTableName() + " group by n_userId)table1";
							try{
								result = stmt.executeQuery(sql);
								if(result.next()){
									total = result.getInt(1);
								}
							}finally{
								result.close();
							}
						}
					}finally{
						stmt.close();
					}
				}finally{
					conn.close();
				}
			}
			resp = new JSONObject();
			resp.put("code", 0);
			resp.put("total", total);
			resp.put("page", pageNumber);
			resp.put("rows", array);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO 获取充值汇总-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getRechargeSummary(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		String begintimestr = ServletService.getParamString(request, "begintime", error);
		String endtimestr = ServletService.getParamString(request, "endtime", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			Date beginDate = TimeUtil.parseDate(begintimestr, DATE_FORMATER.yyyy_MM_dd);
			Date endDate = TimeUtil.parseDate(endtimestr, DATE_FORMATER.yyyy_MM_dd);
			int beginTime = TimeUtil.getSecond(beginDate.getTime());
			int zero = TimeUtil.getSecond(endDate.getTime());
			int endTime = zero + TimeUtil.DAY_SECOND;
			if(endTime - beginTime >= TimeUtil.DAY_SECOND * 30){
				beginTime = endTime - TimeUtil.DAY_SECOND * 30;
			}
			List<GameDailyRechargeInfo> infos = new ArrayList<GameDailyRechargeInfo>();
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			if(server != null){
				Map<Integer, Integer> partnerMap = new HashMap<Integer, Integer>();
				Connection aconn = ConnUtil.getConnection();
				try{
					Statement astmt = aconn.createStatement();
					try{
						String asql = "select * from " + new GameDailyRechargeInfo().getTableName() + " where n_serverId='" + server.getServerId() + "' and n_time between " + beginTime + " and " + endTime;
						ResultSet ars = astmt.executeQuery(asql);
						try{
							while(ars.next()){
								GameDailyRechargeInfo info = new GameDailyRechargeInfo();
								info.read(ars);
								infos.add(info);
							}
						}finally{
							ars.close();
						}
						List<GameDailyRechargeInfo> list = new ArrayList<GameDailyRechargeInfo>();
						for(int i = beginTime; i < endTime; i+= TimeUtil.DAY_SECOND){
							boolean add = true;
							for(GameDailyRechargeInfo info : infos){
								if(info.getTime() == i){
									add = false;
									break;
								}
							}
							if(add){
								GameDailyRechargeInfo info = new GameDailyRechargeInfo();
								info.setServerId(server.getServerId());
								info.setTime(i);
								list.add(info);
							}
						}
						Connection conn = ConnUtil.getConnection(server.getMainConnParam());
						try{
							Statement stmt = conn.createStatement();
							try{
								List<Integer> ids = new ArrayList<Integer>();
								String sql = "select " + UserTable.PARTNER + " from " + UserTable.TABLE_NAME + " group by " + UserTable.PARTNER;
								ResultSet rs = stmt.executeQuery(sql);
								try{
									while(rs.next()){
										ids.add(rs.getInt(1));
									}
								}finally{
									rs.close();
								}
								for(GameDailyRechargeInfo info : list){
									int start = info.getTime();
									int end = start + TimeUtil.DAY_SECOND;
									List<List<Integer>> datas = new ArrayList<List<Integer>>();
									for(int partner : ids){
										List<Integer> ds = new ArrayList<Integer>();
										ds.add(partner);
										int registNum =  0;
										sql =  "select count(*)," + UserTable.USERID + " from " + UserTable.TABLE_NAME + " where " + UserTable.PARTNER + " = " + partner + " and " +  SQLUtil.parseUnixTimestamp(UserTable.CREATETIME) + " <= " + end;
										rs = stmt.executeQuery(sql);
										try{
											if(rs.next()){
												registNum = rs.getInt(1);
											}
										}finally{
											rs.close();
										}
										ds.add(registNum);
										int money = 0;
										asql = "select sum(n_money) from " + new GameBillInfo().getTableName() + " where n_serverId='" + server.getServerId() + "' and n_partner=" + partner + " and n_completeTime between " + start + " and " + end;
										ars = astmt.executeQuery(asql);
										try{
											if(ars.next()){
												money = ars.getInt(1);
											}
										}finally{
											ars.close();
										}
										ds.add(money);
										datas.add(ds);
									}
									if(!datas.isEmpty()){
										info.setRechargeDatas(XyStringUtil.parseString(datas, XyStringUtil.JOIN_VERTICALLINE, XyStringUtil.JOIN_UNDERLINE));
									}
									if(info.getTime() != zero){
										astmt.executeUpdate(info.getInsertData());
									}
									infos.add(info);
								}
								for(int partner : ids){
									int amount = 0;
									asql = "select count(*) from (select n_userId from " + new GameBillInfo().getTableName() + " where n_serverId='" + server.getServerId() + "' and n_partner=" + partner + " and n_completeTime between " + beginTime + " and " + endTime + " group by n_userId)table1;";
									ars = astmt.executeQuery(asql);
									try{
										if(ars.next()){
											amount = ars.getInt(1);
										}
									}finally{
										ars.close();
									}
									partnerMap.put(partner, amount);
								}
							}finally{
								stmt.close();
							}
						}finally{
							conn.close();
						}
					}finally{
						astmt.close();
					}
				}finally{
					aconn.close();
				}
				Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
				for(GameDailyRechargeInfo info : infos){
					List<List<Integer>> lists = XyStringUtil.parseLists(info.getRechargeDatas(), XyStringUtil.SPLIT_VERTICALLINE, XyStringUtil.SPLIT_UNDERLINE);
					for(List<Integer> list : lists){
						if(list.size() >= 3){
							List<Integer> target = map.get(list.get(0));
							if(target == null){
								map.put(list.get(0), list);
							}else{
								if(target.get(1) < list.get(1)){
									target.set(1, list.get(1));
								}
								target.set(2, target.get(2) + list.get(2));
							}
						}
					}
				}
				JSONArray array = new JSONArray();
				for(List<Integer> list : map.values()){
					JSONObject obj = new JSONObject();
					obj.put("partner", list.get(0));
					obj.put("registAmount", list.get(1));
					obj.put("rechargeMoney", list.get(2));
					Integer value = partnerMap.get(list.get(0));
					if(value != null){
						obj.put("rechargeAmount", value);
					}else{
						obj.put("rechargeAmount", 0);
					}
					obj.put("partnerName", GamePartnerCache.getPartnerName(list.get(0)));
					array.add(obj);
				}
				resp = new JSONObject();
				resp.put("page", 1);
				resp.put("total", array.size());
				resp.put("rows", array);
				resp.put("code", 0);
			}
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 *  //TODO 获取注册流失统计-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getRegistLossList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		String begintimestr = ServletService.getParamString(request, "begintime", error);
		String endtimestr = ServletService.getParamString(request, "endtime", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			Date beginDate = TimeUtil.parseDate(begintimestr, DATE_FORMATER.yyyy_MM_dd);
			Date endDate = TimeUtil.parseDate(endtimestr, DATE_FORMATER.yyyy_MM_dd);
			int beginTime = TimeUtil.getSecond(beginDate.getTime());
			int endTime = TimeUtil.getSecond(endDate.getTime());
			if(endTime - beginTime >= TimeUtil.DAY_SECOND * 31){
				beginTime = endTime - TimeUtil.DAY_SECOND * 31;
			}
			List<GameRegistLossInfo> list = new ArrayList<GameRegistLossInfo>();
			if(server != null){
				Date today = TimeUtil.getDate(0, 0, 0);
				int zero = TimeUtil.getSecond(today.getTime());
				beginTime =  getZeroTime(server, beginTime);
				endTime = getZeroTime(server, endTime);
				Connection conn = ConnUtil.getConnection();
				try{
					Statement stmt = conn.createStatement();
					String sql = "select * from " + new GameRegistLossInfo().getTableName() + " where n_serverId=" + StringUtil.getSqlValue(server.getServerId())
							+ " and n_time >= " + beginTime + " and n_time <= " + endTime + " order by n_time";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){
						GameRegistLossInfo info = new GameRegistLossInfo();
						info.read(rs);
						list.add(info);
					}
					Connection conn1 = ConnUtil.getConnection(server.getMainConnParam());
					try{
						Statement stmt1 = conn1.createStatement();
						for(int time = beginTime; time <= endTime; time += TimeUtil.DAY_SECOND){
							GameRegistLossInfo target = null;
							for(GameRegistLossInfo info : list){
								if(info.getTime() == time){
									target = info;
									break;
								}
							}
							if(target == null){
								target = new GameRegistLossInfo();
								target.setServerId(server.getServerId());
								target.setTime(time);
								String like = "";
								if(server.getMerge() == 1){
									like = " " + RegistLossLoggerTable.USERNAME + " like '" + server.getServerId() + "_%' and ";
								}
								for(int type = 1; type <= 4; type++){
									String csql = "select count(distinct " + RegistLossLoggerTable.USERNAME + "," + RegistLossLoggerTable.PARTNER + ") from " 
												+ RegistLossLoggerTable.TABLE_NAME 
												+" where " 
												+ like 
												+ RegistLossLoggerTable.TYPE 
												+ " = " 
												+ type 
												+ " and " + RegistLossLoggerTable.TIME + " >= " + time 
												+ " and " + RegistLossLoggerTable.TIME + " < " + (time + TimeUtil.DAY_SECOND);
									ResultSet rs1 = stmt1.executeQuery(csql);
									if(rs1.next()){
										int amount = rs1.getInt(1);
										target.setAmount(type, amount);
									}
								}
								if(target.getTime() < zero){
									ConnUtil.insert(stmt, target);
								}
								list.add(target);
							}
						}
					}finally{
						conn1.close();
					}
				}finally{
					conn.close();
				}
			}
			Collections.sort(list);
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("page", 1);
			result.put("total", list.size());
			JSONArray array = new JSONArray();
			for(GameRegistLossInfo info : list){
				array.add(info.toJson());
			}
			result.put("rows", array);
			resp = JSONObject.fromObject(result);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO 获取注册统计-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getRegisterReport(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		String begintime = ServletService.getParamString(request, "begin", error);
		String endtime = ServletService.getParamString(request, "end", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			Date beginDate = TimeUtil.parseDate(begintime, DATE_FORMATER.yyyy_MM_dd);
			Date endDate = TimeUtil.parseDate(endtime, DATE_FORMATER.yyyy_MM_dd);
			Date now = TimeUtil.getNowDate();
			if(TimeUtil.before(now, endDate)){
				endDate = now;
			}
			int beginTime = TimeUtil.getSecond(beginDate.getTime());
			int endTime = TimeUtil.getSecond(endDate.getTime());
			if(endTime - beginTime >= TimeUtil.DAY_SECOND * 30){
				beginTime = endTime - TimeUtil.DAY_SECOND * 30;
			}
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			ConnParam mainConnParam = server.getMainConnParam();
			Connection conn = ConnUtil.getConnection();
			Connection conn1 = ConnUtil.getConnection(mainConnParam);
			int totalRegister = 0;
			JSONArray array = new JSONArray();
			try{
				Statement stmt = conn.createStatement();
				Statement stmt1 = conn1.createStatement();
				try{
					JSONObject obj = null;
					List<GameRegistReportInfo> list = new ArrayList<GameRegistReportInfo>();
					for(int i = beginTime; i <= endTime; i+=TimeUtil.DAY_SECOND){
						list = new ArrayList<GameRegistReportInfo>();
						obj = new JSONObject();
						int time = i + TimeUtil.DAY_SECOND;
						String sql = "select * from " + new GameRegistReportInfo().getTableName() + " where n_time > " + i + " and n_time <= " + time + " and n_serverId='" + server.getServerId() + "' order by n_time asc";
						ResultSet result = stmt.executeQuery(sql);
						try{
							while(result.next()){
								GameRegistReportInfo info = new GameRegistReportInfo();
								info.read(result);
								list.add(info);
							}
						}finally{
							result.close();
						}
						for(int j = i + TimeUtil.HOUR_SECOND; j <= time; j += TimeUtil.HOUR_SECOND){
							boolean sign = true;
							for(GameRegistReportInfo info : list){
								if(info.getTime() == j){
									sign = false;
									break;
								}
							}
							if(sign){
								String countSql = "select count(*) from " + UserTable.TABLE_NAME + " where " + SQLUtil.parseUnixTimestamp(UserTable.CREATETIME) + " <= " + j + " and " + SQLUtil.parseUnixTimestamp(UserTable.CREATETIME) + " > " + (j - TimeUtil.HOUR_SECOND);
								ResultSet result1 = stmt1.executeQuery(countSql);
								try{
									if(result1.next()){
										int amount = result1.getInt(1);
										GameRegistReportInfo info = new GameRegistReportInfo();
										info.setServerId(server.getServerId());
										info.setTime(j);
										info.setAmount(amount);
										int addAmount = amount;
										countSql = "select count(*) from " + RegistLossLoggerTable.TABLE_NAME + " where " + RegistLossLoggerTable.TIME + " between " + (j - TimeUtil.HOUR_SECOND) + " and " + j + " and " + RegistLossLoggerTable.TYPE + "=1";
										try{
											result1 = stmt1.executeQuery(countSql);
											if(result1.next()){
												addAmount = result1.getInt(1);
												if(addAmount < amount){
													addAmount = amount;
												}
											}
										}finally{
											result1.close();
										}
										info.setAddAmount(addAmount);
										if(time <= TimeUtil.getNowSecond()){
											ConnUtil.insert(stmt, info);
										}
										list.add(info);
									}
								}finally{
									result1.close();
								}
							}
						}
						int createAmount = 0;
						int addAmount = 0;
						JSONArray array1 = new JSONArray();
						for(GameRegistReportInfo info : list){
							array1.add(info.getAmount());
							createAmount += info.getAmount();
							addAmount += info.getAddAmount();
						}
						obj.put("time", i);
						obj.put("data", array1);
						obj.put("createAmount", createAmount);
						obj.put("addAmount", addAmount);
						array.add(obj);
					}
					
					String totalSql = "select count(*) from " + UserTable.TABLE_NAME;
					ResultSet result3 = stmt1.executeQuery(totalSql);
					if(result3.next()){
						totalRegister = result3.getInt(1);
					}
				}finally{
					stmt.close();
					stmt1.close();
				}
			}finally{
				conn.close();
				conn1.close();
			}
			resp = new JSONObject();
			resp.put("page", 1);
			resp.put("total", array.size());
			resp.put("rows", array);
			resp.put("totalRegister", totalRegister);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 *  //TODO 获取二次登录列表-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getTwiceLoginList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		String begintime = ServletService.getParamString(request, "begin", error);
		String endtime = ServletService.getParamString(request, "end", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			Date beginDate = TimeUtil.parseDate(begintime, DATE_FORMATER.yyyy_MM_dd);
			Date endDate = TimeUtil.parseDate(endtime, DATE_FORMATER.yyyy_MM_dd);
			int beginTime = TimeUtil.getSecond(beginDate.getTime());
			int endTime = TimeUtil.getSecond(endDate.getTime()) + TimeUtil.DAY_SECOND;
			if(endTime - beginTime >= TimeUtil.DAY_SECOND * 31){
				beginTime = endTime - TimeUtil.DAY_SECOND * 31;
			}
			List<GameTwiceLoginInfo> list = new ArrayList<GameTwiceLoginInfo>();
			List<GameTwiceLoginInfo> infos = new ArrayList<GameTwiceLoginInfo>();
			Connection con = ConnUtil.getConnection();
			try{
				Statement stmt1 = con.createStatement();
				try{
					GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
					String sql1 = "select * from " + new GameTwiceLoginInfo().getTableName() + " where n_serverId='" + server.getServerId() + "' and n_time between " + beginTime + " and " + endTime;
					ResultSet rs1 = stmt1.executeQuery(sql1);
					try{
						while(rs1.next()){
							GameTwiceLoginInfo info = new GameTwiceLoginInfo();
							info.read(rs1);
							list.add(info);
						}
					}finally{
						rs1.close();
					}
					int zero = TimeUtil.getSecond(TimeUtil.getDate(0, 0, 0).getTime());
					for(int time = beginTime; time < endTime; time += TimeUtil.DAY_SECOND){
						boolean add = true; 
						for(GameTwiceLoginInfo info : list){
							if(info.getTime() == time){
								add = false;
								break;
							}
						}
						if(add){
							GameTwiceLoginInfo info = new GameTwiceLoginInfo();
							info.setServerId(server.getServerId());
							if(time > zero){
								time = zero;
							}
							info.setTime(time);
							infos.add(info);
						}
					}
					if(!infos.isEmpty()){
						ConnParam mainConnParam = server.getMainConnParam();
						Connection conn = ConnUtil.getConnection(mainConnParam);
						try{
							Statement stmt2 = conn.createStatement();
							try{
								for(GameTwiceLoginInfo info : infos){
									int newNum = 0;
									int twiceLoginNum = 0;
									int initTime = info.getTime();
									int dayTime = initTime + TimeUtil.DAY_SECOND;
									String sql2 = "select count(*) from " + UserTable.TABLE_NAME + " where " + SQLUtil.parseUnixTimestamp(UserTable.CREATETIME) + " between " + initTime + " and " + dayTime;
									ResultSet rs2 = stmt2.executeQuery(sql2);
									try{
										if(rs2.next()){
											newNum = rs2.getInt(1);
										}
									}finally{
										rs2.close();
									}
									sql2 = "select count(*) from " + UserTable.TABLE_NAME + " where " + SQLUtil.parseUnixTimestamp(UserTable.CREATETIME) + " != " + SQLUtil.parseUnixTimestamp(UserTable.LASTLOGINTIME) + " and " + SQLUtil.parseUnixTimestamp(UserTable.CREATETIME) + " between " + initTime + " and " + dayTime;
									rs2 = stmt2.executeQuery(sql2);
									try{
										if(rs2.next()){
											twiceLoginNum = rs2.getInt(1);
										}
									}finally{
										rs2.close();
									}
									info.setTwiceLoginNum(twiceLoginNum);
									info.setNewNum(newNum);
									if(info.getTime() != zero){
										stmt1.executeUpdate(info.getInsertData());
									}
									list.add(info);
								}
							}finally{
								stmt2.close();
							}
						}finally{
							conn.close();
						}
					}
				}finally{
					stmt1.close();
				}
			}finally{
				con.close();
			}
			infos.clear();
			if(!list.isEmpty()){
				for(GameTwiceLoginInfo info : list){
					int val = -1;
					for(int j = 0; j < infos.size(); j++){
						GameTwiceLoginInfo target = infos.get(j);
						if(target.getTime() > info.getTime()){
							val = j;
							break;
						}
					}
					if(val == -1){
						infos.add(info);
					}else{
						infos.add(val, info);
					}
				}
			} 
			JSONArray array = new JSONArray();
			for(GameTwiceLoginInfo info : infos){
				if(info.getTime() < endTime){
					JSONObject json = new JSONObject();
					json.put("time", info.getTime());
					json.put("twiceNum", info.getTwiceLoginNum());
					json.put("newUser", info.getNewNum());
					array.add(json);
				}
			}
			resp = new JSONObject();
			resp.put("page", 1);
			resp.put("total", infos.size());
			resp.put("rows", array);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	

	//TODO 
	/******************************************************************************************/

	private static int getZeroTime(GameServerInfo server, int time){
		Date date = null;
		int now = TimeUtil.getNowSecond();
		if(server != null){
			date = TimeUtil.getDate(time);
			int t = TimeUtil.getSecond(server.getStartTime().getTime());
			if(time < t){
				date = TimeUtil.getDate(t);
			}else if(time > now){
				date = TimeUtil.getNowDate();
			}
		}else{
			if(time > now){
				date = TimeUtil.getNowDate();
			}else{
				date = TimeUtil.getDate(time);
			}
		}
		return TimeUtil.getSecond(TimeUtil.getZeroTime(date, 0, 0, 0).getTime());
	}
}
