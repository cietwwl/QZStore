package com.game.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cache.GameErrorCache;
import com.cache.GamePartnerCache;
import com.db.util.ConnParam;
import com.db.util.ConnUtil;
import com.game.constant.GameCmd;
import com.game.constant.GameConstant;
import com.http.message.CommonHttpRequest;
import com.ks.db.model.User;
import com.ks.table.UserTable;
import com.utils.DBBeanUtil;
import com.utils.HttpUtil;
import com.utils.JSONUtil;
import com.utils.StringUtil;
import com.utils.TimeUtil;
import com.utils.TimeUtil.DATE_FORMATER;
import com.web.db.game.GameServerInfo;
import com.web.obj.ParamError;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 玩家逻辑类
 *
 */
public class GamePlayerService{
	
	/**
	 * //TODO 获取玩家列表-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getPlayerList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int partner = ServletService.getParamInt(request, "partner", error);
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		String sortname = ServletService.getParamString(request, "sortname", error);
		String sortorder = ServletService.getParamString(request, "sortorder", error);
		int searchType = ServletService.getParamInt(request, "searchType", error);
		String searchValue = ServletService.getParamString(request, "searchValue", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int begin = (pageNumber - 1) * pageSize;
			List<User> players = new ArrayList<User>();
			String orderby = "";
			if(sortname.length() > 0){
				orderby = " order by " + sortname;
				if(sortorder.length() > 0){
					orderby = orderby + " " + sortorder;
				}
			}
			String condition = "";
			int now = TimeUtil.getNowSecond();
			if(searchType == 4 || searchValue.length() > 0){
				if(searchType == 1){
					condition += UserTable.USERNAME + " like " + StringUtil.getLikeSqlValue(searchValue, true, true);
				}else if(searchType == 2){
					condition += UserTable.PLAYERNAME + " like " + StringUtil.getLikeSqlValue(searchValue, true, true);
				}else if(searchType == 3){
					condition += UserTable.LEVEL + "=" + StringUtil.getSqlValue(searchValue);
				}else if(searchType == 4){
					condition += UserTable.ONLINE + "=1 and " + UserTable.ACCESSTIME + " >= " + (now - 5 * TimeUtil.MINUTE_SECOND);
				}
			}
			if(partner > 0){
				if(condition.length() > 0){
					condition += " and " + UserTable.PARTNER + "=" + partner;
				}else{
					condition = UserTable.PARTNER + "=" + partner;
				}
			}
			if(condition.length() > 0){
				condition = " where " + condition;
			}
			int total = 0;
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			ConnParam mainConnParam = server.getMainConnParam();
			Connection conn = ConnUtil.getConnection(mainConnParam);
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + UserTable.TABLE_NAME + condition + orderby + " limit " + begin + "," + pageSize;
					ResultSet result = stmt.executeQuery(sql);
					try{
						while(result.next()){
							User player = new User();
							player = DBBeanUtil.read(player, result);
							players.add(player);
						}
					}finally{
						result.close();
					}
					String sql1 = "select count(" + UserTable.USERID + ") from " + UserTable.TABLE_NAME + " " + condition;
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
				ConnUtil.closeConnection(conn);
			}
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("page", pageNumber);
			result.put("total", total);
			JSONArray array = new JSONArray();
			for(User player : players){
				JSONObject obj = toJson(player);
				obj.put("partnerName", GamePartnerCache.getPartnerName(player.getPartner()));
				array.add(obj);
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
	 * //TODO 获取玩家-jsp
	 * @param server
	 * @param partner
	 * @param openId
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getPlayer(HttpServletRequest request, HttpSession session) throws Exception{
		ParamError error = new ParamError();
		int partner = ServletService.getParamInt(request, "partner", error);
		String openId = ServletService.getParamString(request, "openId", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			if(server == null){
				resp = error.getServerError();
			}else{
				resp = new JSONObject();
				ConnParam mainConnParam = server.getMainConnParam();
				Connection conn = ConnUtil.getConnection(mainConnParam);
				try{
					Statement stmt = conn.createStatement();
					try{
						String condition = "";
						if(partner > 0){
							condition = " and " + UserTable.PARTNER + "=" + partner;
						}
						String sql = "select * from " + UserTable.TABLE_NAME + " where " + UserTable.USERNAME + "='" + openId + "'" + condition;
						ResultSet result = stmt.executeQuery(sql);
						try{
							if(result.next()){
								User player = new User();
								player = DBBeanUtil.read(player, result);
								resp.put("partner", player.getPartner());
								resp.put("username", player.getUsername());
								resp.put("playername", player.getPlayerName());
								resp.put("level", player.getLevel());
								resp.put("exp", player.getExp());
								resp.put("recharge", player.getChargeDiamond());
								resp.put("gold", player.getGold());
								resp.put("diamond", player.getDiamond());
								resp.put("stamina", player.getStamina());
								resp.put("slate", player.getSlate());
								resp.put("code", 0);
							}else{
								resp.put("code", -1);
								resp.put("tip", "所选渠道找不到玩家：" + openId);
							}
						}finally{
							result.close();
						}
					}finally{
						stmt.close();
					}
				}finally{
					ConnUtil.closeConnection(conn);
				}
			}
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO 封号/禁言-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject banAccount(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int banType = ServletService.getParamInt(request, "banType", error);
		String username = ServletService.getParamString(request, "username", error);
		int partner = ServletService.getParamInt(request, "partner", error);
		String datestr = ServletService.getParamString(request, "banDate", error);
		JSONObject resp = null;
		if(error.isSuccess()){
		int banTime = 0;
			if(datestr != null && !datestr.equals("")){
				Date date = TimeUtil.parseDate(datestr, DATE_FORMATER.yyyy_MM_dd_HH_mm_ss);
				banTime = TimeUtil.getTime(date);
			}
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			CommonHttpRequest req = new CommonHttpRequest(server.getAdminUrl(), CommonHttpRequest.METHOD_POST);
			req.addParam("check", server.getAdminCheck());
			req.addParam("username", username);
			req.addParam("partner", partner);
			req.addParam("banType", banType);
			req.addParam("banTime", banTime);
			req.addParam("action", GameCmd.CMD_PLAYER_BAN);
			String resultstr = HttpUtil.sendPost(req);
			resp = new JSONObject();
			JSONObject result = JSONUtil.parseJSON(resultstr);
			int code = result.getInt("code");
			resp.put("code", code);
			Map<String, Object> data = new HashMap<String, Object>();
			if(code == 0){
				ConnParam mainConnParam = server.getMainConnParam();
				Connection conn = ConnUtil.getConnection(mainConnParam);
				try{
					Statement stmt = conn.createStatement();
					try{
						String sql = "select * from " + UserTable.TABLE_NAME + " where " + UserTable.USERNAME + "=" + StringUtil.getSqlValue(username) + " and " + UserTable.PARTNER + "=" + StringUtil.getSqlValue(partner);
						ResultSet rs = stmt.executeQuery(sql);
						if(rs.next()){
							User player = new User();
							player = DBBeanUtil.read(player, rs);
							data.put("player", toJson(player));
						}
					}finally{
						stmt.close();
					}
				}finally{
					conn.close();
				}
			}else{
				resp.put("tip", GameErrorCache.getErrorName(code));
			}
			resp.put("data", data);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}

	//TODO 
	/******************************************************************************************/

	private static JSONObject toJson(User info) throws Exception{
		JSONObject json = JSONUtil.parseSimpleJSON(info, User.class);
		String loginTimeStr = TimeUtil.formatDate(info.getLastLoginTime(), DATE_FORMATER.yyyy_MM_dd_HH_mm_ss);
		json.put("loginTimeStr", loginTimeStr);
		String registTimeStr = TimeUtil.formatDate(info.getCreateTime(), DATE_FORMATER.yyyy_MM_dd_HH_mm_ss);
		json.put("registTimeStr", registTimeStr);
		int now = TimeUtil.getNowSecond();
		if(now < info.getBanChatTime()){
			json.put("banChatSign", 1);
		}else{
			json.put("banChatSign", 0);
		}
		if(now < info.getBanLoginTime()){
			json.put("banLoginSign", 1);
		}else{
			json.put("banLoginSign", 0);
		}
		if(info.getOnline() == 1 && now - info.getAccessTime() <= GameConstant.ACCESS_TIME){
			json.put("online", 1);
		}else{
			json.put("online", 0);
		}
		return json;
	}
}
