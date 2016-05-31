package com.game.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cache.GamePartnerCache;
import com.cache.GameServerCache;
import com.db.util.ConnUtil;
import com.game.action.EActionPool;
import com.game.action.GameBillAction;
import com.game.constant.GameConstant;
import com.http.message.CommonHttpRequest;
import com.security.BASE64;
import com.utils.StringUtil;
import com.utils.TimeUtil;
import com.utils.TimeUtil.DATE_FORMATER;
import com.web.db.game.GameBillInfo;
import com.web.db.game.GameServerInfo;
import com.web.obj.ParamError;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GameRechargeService {

	
	/**
	 * //TODO 获取充值列表-jsp
	 * @param serverId
	 * @param sendState
	 * @param bill
	 * @param username
	 * @param begintimestr
	 * @param endtimestr
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getRechargeList(HttpServletRequest request) throws Exception{
		ParamError error = new ParamError();
		String serverId = ServletService.getParamString(request, "serverId", error);
		int sendState = ServletService.getParamInt(request, "sendState", error);
		String bill = ServletService.getParamString(request, "bill", error);
		String username = ServletService.getParamString(request, "username", error);
		String begintimestr = ServletService.getParamString(request, "begintime", error);
		String endtimestr = ServletService.getParamString(request, "endtime", error);
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			Date beginDate = TimeUtil.parseDate(begintimestr, DATE_FORMATER.yyyy_MM_dd);
			Date endDate = TimeUtil.parseDate(endtimestr, DATE_FORMATER.yyyy_MM_dd);
			endDate = new Date(endDate.getTime() + TimeUtil.DAY_MILLIS);
			Date now = TimeUtil.getNextDate(new Date(), Calendar.MINUTE, 10);
			if(TimeUtil.before(now, endDate)){
				endDate = now;
			}
			int beginTime = TimeUtil.getSecond(beginDate.getTime());
			int endTime = TimeUtil.getSecond(endDate.getTime());
			int total = 0;
			int begin = (pageNumber - 1) * pageSize;
			List<GameBillInfo> list = new ArrayList<GameBillInfo>();
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					String condition = " where n_confirmTime >= " + beginTime + " and n_confirmTime <= " + endTime;
					if(serverId.length() > 0){
						condition += " and n_serverId=" + StringUtil.getSqlValue(serverId);
					}
					if(bill.length() > 0){
						condition += " and n_bill=" + StringUtil.getSqlValue(bill);
					}
					if(sendState != -1){
						if(sendState != 0){
							condition += " and n_completeTime > 0";
						}else{
							condition += " and n_completeTime = 0";
						}
					}
					if(username.length() > 0){
						condition += " and n_username=" + StringUtil.getSqlValue(username);
					}
					String sql = "select * from " + new GameBillInfo().getTableName() + condition + " limit " + begin + "," + pageSize;
					ResultSet result = stmt.executeQuery(sql);
					while(result.next()){
						GameBillInfo payBill = new GameBillInfo();
						payBill.read(result);
						list.add(payBill);
					}
					String sql1 = "select count(n_id) from " + new GameBillInfo().getTableName() + condition;
					ResultSet result1 = stmt.executeQuery(sql1);
					if(result1.next()){
						total = result1.getInt(1);
					}
				}finally{
					stmt.close();
				}
			}finally{
				ConnUtil.closeConnection(conn);
			}
			resp = new JSONObject();
			resp.put("page", pageNumber);
			resp.put("total", total);
			JSONArray array = new JSONArray();
			for(GameBillInfo info : list){
				JSONObject json = info.toJson();
				json.put("serverName", GameServerCache.getServerName(info.getServerId()));
				json.put("partnerName", GamePartnerCache.getPartnerName(info.getPartner()));
				array.add(json);
			}
			resp.put("rows", array);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO 订单发货-jsp
	 * @param ids
	 * @return
	 * @throws Exception 
	 */
	public static JSONObject billResend(HttpServletRequest request) throws Exception{
		ParamError error = new ParamError();
		String ids = ServletService.getParamString(request, "ids", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			Connection conn = ConnUtil.getConnection();
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + new GameBillInfo().getTableName() + " where n_id in (" + ids + ")";
					ResultSet rs = stmt.executeQuery(sql);
					try{
						while(rs.next()){
							GameBillInfo bill = new GameBillInfo();
							bill.read(rs);
							EActionPool.addAction(new GameBillAction(bill, true));
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
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 * //TODO 充值-jsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject recharge(HttpServletRequest request)throws Exception{
		String remoteAddr = ServletService.getRemoteAddr(request);
		JSONObject resp = new JSONObject();
		if(GamePartnerCache.hasCallback(remoteAddr)){
			ParamError error = new ParamError();
			String billno = ServletService.getParamString(request, "billno", error);
			String openid = ServletService.getParamString(request, "openid", error);
			String sid = ServletService.getParamString(request, "sid", error);
			int money = ServletService.getParamInt(request, "money", error);
			String check = ServletService.getParamString(request, "check", error);
			if(!error.isSuccess() || billno.length() == 0 || openid.length() == 0 || sid.length() == 0){
				resp = error.getErrorData();
			}else{
				GameServerInfo server = GameServerCache.getGameServerInfo(sid);
				if(server != null){
					CommonHttpRequest req = new CommonHttpRequest("", "");
					req.addParam("billno", billno);
					req.addParam("openid", openid);
					req.addParam("sid", sid);
					req.addParam("money", money);
					req.sortParams();
					String str = req.getEncodeParamString();
					str += "&key=" + GameConstant.MONEY_KEY;
					byte[] bytes = str.getBytes("utf-8");
					String rcheck = BASE64.encode(bytes);
					if(check.equals(rcheck)){
						if(server.getMerge() == 1){
							openid = server.getServerId() + "_" + openid;
						}
					}else{
						resp.put("code", -4);
						resp.put("tip", "check校验错误");
					}
				}else{
					resp.put("code", -3);
					resp.put("tip", "服务器不存在");
				}
			}
		}else{
			resp.put("code", -2);
			resp.put("tip", "请求的源ip不在记录范围");
		}
		return resp;
	}
	

	//TODO 
	/******************************************************************************************/
	
	public static GameBillInfo getPayBillInfoByBillno(String billno) throws Exception{
		GameBillInfo bill = null;
		Connection conn = ConnUtil.getConnection();
		try{
			Statement stmt = conn.createStatement();
			try{
				String sql = "select * from " + new GameBillInfo().getTableName() + " where n_bill=" + StringUtil.getSqlValue(billno) + " limit 1";
				ResultSet result = stmt.executeQuery(sql);
				try{
					if(result.next()){
						bill = new GameBillInfo();
						bill.read(result);
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
		return bill;
	}
	
}
