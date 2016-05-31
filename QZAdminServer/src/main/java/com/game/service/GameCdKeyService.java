package com.game.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cache.GamePartnerCache;
import com.cache.GameServerCache;
import com.db.util.ConnUtil;
import com.security.MD5;
import com.utils.StringUtil;
import com.utils.TimeUtil;
import com.utils.TimeUtil.DATE_FORMATER;
import com.web.db.bean.SysUserInfo;
import com.web.db.game.GameCdKeyInfo;
import com.web.db.game.GameCdKeyRecordInfo;
import com.web.obj.ParamError;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 * CDKEY逻辑类
 *
 */
public class GameCdKeyService {
	
	/**
	 * //TODO 获取CDKEY列表-jsp
	 * @param code
	 * @param convert
	 * @param activated
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getCdkeyList(HttpServletRequest request) throws Exception{
		ParamError error = new ParamError();
		String code = ServletService.getParamString(request, "code", error);
		int convert = ServletService.getParamInt(request, "convert", error);
		int activated = ServletService.getParamInt(request, "activated", error);
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int total = 0;
			int begin = (pageNumber - 1) * pageSize;
			List<GameCdKeyInfo> list = new ArrayList<GameCdKeyInfo>();
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + new GameCdKeyInfo().getTableName();
					String condition = "";
					if(activated != -1){
						condition = " n_activated=" + activated;
					}
					if(convert != -1){
						String val = ">";
						if(convert > 0){
							val = "<=";
						}
						if(condition.length() > 0){
							condition += " and n_totalNum " + val + " n_convertNum";
						}else{
							condition += " n_totalNum " + val + " n_convertNum";
						}
					}
					if(code.length() > 0){
						if(condition.length() > 0){
							condition += " and n_code=" + StringUtil.getSqlValue(code);
						}else{
							condition += " n_code=" + StringUtil.getSqlValue(code);
						}
					}
					if(condition.length() > 0){
						condition = " where " + condition;
					}
					sql = sql + condition + " order by n_id desc limit " + begin + "," + pageSize;
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){
						GameCdKeyInfo info = new GameCdKeyInfo();
						info.read(rs);
						list.add(info);
					}
					String sql1 = "select count(n_id) from " + new GameCdKeyInfo().getTableName() + condition;
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
			for(GameCdKeyInfo info : list){
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
	 * //TODO 获取本地CDKEY兑换记录-jsp
	 * @param selTime
	 * @param begintimestr
	 * @param endtimestr
	 * @param serverId
	 * @param openId
	 * @param cdkey
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getCdkeyRecordList(HttpServletRequest request) throws Exception{
		ParamError error = new ParamError();
		int selTime = ServletService.getParamInt(request, "selTime", error);
		String begintimestr = ServletService.getParamString(request, "begin", error);
		String endtimestr = ServletService.getParamString(request, "end", error);
		String serverId = ServletService.getParamString(request, "sid", error);
		String openId = ServletService.getParamString(request, "openid", error);
		String cdkey = ServletService.getParamString(request, "cdkey", error);
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int total = 0;
			int begin = (pageNumber - 1) * pageSize;
			List<GameCdKeyRecordInfo> list = new ArrayList<GameCdKeyRecordInfo>();
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + new GameCdKeyRecordInfo().getTableName();
					String condition = "";
					if(serverId.length() > 0){
						condition = " n_serverId=" + StringUtil.getSqlValue(serverId);
					}
					if(openId.length() > 0){
						if(condition.length() > 0){
							condition += " and n_openid=" + StringUtil.getSqlValue(openId);
						}else{
							condition = " n_openid=" + StringUtil.getSqlValue(openId);
						}
					}
					if(cdkey.length() > 0){
						if(condition.length() > 0){
							condition += " and n_cdkey=" + StringUtil.getSqlValue(cdkey);
						}else{
							condition = " n_cdkey=" + StringUtil.getSqlValue(cdkey);
						}
					}
					if(selTime > 0){
						Date beginDate = TimeUtil.parseDate(begintimestr, DATE_FORMATER.yyyy_MM_dd);
						Date endDate = TimeUtil.parseDate(endtimestr, DATE_FORMATER.yyyy_MM_dd);
						int beginTime = TimeUtil.getSecond(beginDate.getTime());
						int endTime = TimeUtil.getSecond(endDate.getTime()) + TimeUtil.DAY_SECOND;
						if(endTime > beginTime){
							if(condition.length() > 0){
								condition += " and n_convertTime between " + beginTime + " and " + endTime;
							}else{
								condition = " n_convertTime between " + beginTime + " and " + endTime;
							}
						}
					}
					if(condition.length() > 0){
						condition = " where " + condition;
					}
					sql = sql + condition + " order by n_id desc limit " + begin + "," + pageSize;
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){
						GameCdKeyRecordInfo info = new GameCdKeyRecordInfo();
						info.read(rs);
						list.add(info);
					}
					String sql1 = "select count(n_id) from " + new GameCdKeyRecordInfo().getTableName() + condition;
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
			for(GameCdKeyRecordInfo info : list){
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
	 * //TODO CDKEY激活-jsp
	 * @param ids
	 * @param state
	 * @return
	 * @throws Exception
	 */
	public static JSONObject cdkeyActivated(HttpServletRequest request) throws Exception{
		ParamError error = new ParamError();
		String ids = ServletService.getParamString(request, "ids", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "update " + new GameCdKeyInfo().getTableName() + " set n_activated=1 where n_id in (" + ids + ")";
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
	 * //TODO CDKEY删除-jsp
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public static JSONObject cdkeyDelete(HttpServletRequest request) throws Exception{
		ParamError error = new ParamError();
		String ids = ServletService.getParamString(request, "ids", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "delete from " + new GameCdKeyInfo().getTableName() + " where n_id in (" + ids + ")";
					stmt.executeUpdate(sql);
					sql = "delete from " + new GameCdKeyRecordInfo().getTableName() + " where n_cdkeyId in (" + ids + ")";
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
	 * //TODO CDKEY生成-jsp
	 * @param user
	 * @param activited
	 * @param type
	 * @param code
	 * @param num
	 * @param rewards
	 * @param name
	 * @param desc
	 * @return
	 * @throws Exception
	 */
	public static JSONObject cdkeyGenerate(HttpServletRequest request, HttpSession session) throws Exception{
		ParamError error = new ParamError();
		int activited = ServletService.getParamInt(request, "activited", error);
		int type = ServletService.getParamInt(request, "type", error);
		String code = ServletService.getParamString(request, "code", error);
		int num = ServletService.getParamInt(request, "num", error);
		String rewards = ServletService.getParamString(request, "rewards", error);
		String name = ServletService.getParamString(request, "name", error);
		String desc = ServletService.getParamString(request, "desc", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			SysUserInfo user = (SysUserInfo) session.getAttribute("user");
			if(user == null){
				resp = error.getUserError();
			}else{
				if(code != null && code.length() > 0 && num > 0){
					int now = TimeUtil.getNowSecond();
					Connection conn = ConnUtil.getConnection();
					try{
						conn.setAutoCommit(false);
						Statement stmt = conn.createStatement();
						try{
							if(type == 1){
								for(int index = 1; index <= num; index++){
									String str = code + "_" + now + "_" + index + "_" + Math.random();
									String cdkey = MD5.encode(str);
									GameCdKeyInfo info = new GameCdKeyInfo();
									info.setType(type);
									info.setCdkey(cdkey);
									info.setCode(code);
									info.setCreateTime(now);
									info.setCreator(user.getUsername());
									info.setActivated(activited);
									info.setName(name);
									info.setDesc(desc);
									info.setRewards(rewards);
									info.setTotalNum(1);
									String sql = info.getInsertData();
									stmt.executeUpdate(sql);
								}
							}else{
								String str = code + "_" + now + "_" + num + "_" + Math.random();
								String cdkey = MD5.encode(str);
								GameCdKeyInfo info = new GameCdKeyInfo();
								info.setType(type);
								info.setCdkey(cdkey);
								info.setCode(code);
								info.setCreateTime(now);
								info.setCreator(user.getUsername());
								info.setActivated(activited);
								info.setName(name);
								info.setDesc(desc);
								info.setRewards(rewards);
								info.setTotalNum(num);
								String sql = info.getInsertData();
								stmt.executeUpdate(sql);
							}
							conn.commit();
						}finally{
							stmt.close();
						}
					}catch(Exception e){
						e.printStackTrace();
						conn.rollback();
					}finally{
						ConnUtil.closeConnection(conn);
					}
				}
				resp = new JSONObject();
				resp.put("code", 0);
			}
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	
	
	/**
	 * //TODO 兑换CDKEY-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public synchronized static JSONObject convertCdkey(HttpServletRequest request) throws Exception{
		ParamError param = new ParamError();
		int partner = ServletService.getParamInt(request, "partner", param);
		String cdkey = ServletService.getParamString(request, "cdkey", param);
		String sid = ServletService.getParamString(request, "sid", param);
		String openid = ServletService.getParamString(request, "openid", param);
		String nickname = ServletService.getParamString(request, "nickname", param);
		JSONObject resp = null;
		if(param.isSuccess()){
			resp = new JSONObject();
			int code = 0;
			String keyname = "";
			String keydesc = "";
			String rewards = "";
			String error = "";
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					GameCdKeyInfo target = null;
					String sql = "select * from " + new GameCdKeyInfo().getTableName() + " where n_cdkey=" + StringUtil.getSqlValue(cdkey);
					ResultSet rs = stmt.executeQuery(sql);
					try{
						if(rs.next()){
							target = new GameCdKeyInfo();
							target.read(rs);
						}
					}finally{
						rs.close();
					}
					if(target == null){
						error = "该兑换码不存在！";
					}else if(target.getActivated() != 1){
						error = "该兑换码未激活！";
					}else if(target.getTotalNum() <= target.getConvertNum()){
						if(target.getTotalNum() <= 1){
							error = "该兑换码已兑换过！";
						}else{
							error = "该兑换码兑换次数已达到上限！";
						}
					}else{
						sql = "select * from " + new GameCdKeyRecordInfo().getTableName() + " where n_cdkey=" + StringUtil.getSqlValue(cdkey) + " and n_serverId=" + StringUtil.getSqlValue(sid) + " and n_partner=" + partner + " and n_openid=" + StringUtil.getSqlValue(openid);
						rs = stmt.executeQuery(sql);
						try{
							if(rs.next()){
								error = "已兑换过奖励，不可重复兑换";
							}else{
								target.setConvertNum(target.getConvertNum() + 1);
								stmt.executeUpdate(target.getUpdateData());
								GameCdKeyRecordInfo info = new GameCdKeyRecordInfo();
								info.setCdkeyId(target.getId());
								info.setCdkey(cdkey);
								info.setPartner(partner);
								info.setServerId(sid);
								info.setOpenid(openid);
								info.setNickname(nickname);
								info.setConvertTime(TimeUtil.getNowSecond());
								stmt.executeUpdate(info.getInsertData());
								keyname = target.getName();
								keydesc = target.getDesc();
								rewards = target.getRewards();
							}
						}finally{
							rs.close();
						}
					}
					if(error.length() > 0){
						code = -1;
					}
				}finally{
					stmt.close();
				}
			}finally{
				ConnUtil.closeConnection(conn);
			}
			resp.put("code", code);
			resp.put("error", error);
			resp.put("keyname", keyname);
			resp.put("keydesc", keydesc);
			resp.put("rewards", rewards);
		}else{
			resp = param.getErrorData();
		}
		return resp;
	}
}
