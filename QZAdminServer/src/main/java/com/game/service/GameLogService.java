package com.game.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.db.util.ConnParam;
import com.db.util.ConnUtil;
import com.ks.constant.SystemConstant;
import com.ks.db.log.DiamondLogger;
import com.ks.db.log.EquipmentLogger;
import com.ks.db.log.EternalLogger;
import com.ks.db.log.ExpLogger;
import com.ks.db.log.GoldLogger;
import com.ks.db.log.GpLogger;
import com.ks.db.log.HeroExpPoolLogger;
import com.ks.db.log.HeroLogger;
import com.ks.db.log.LoginLogger;
import com.ks.db.log.PropLogger;
import com.ks.db.log.SlateLogger;
import com.ks.db.log.StaminaLogger;
import com.ks.table.DiamondLoggerTable;
import com.ks.table.EquipmentLoggerTable;
import com.ks.table.EternalLoggerTable;
import com.ks.table.ExpLoggerTable;
import com.ks.table.GoldLoggerTable;
import com.ks.table.GpLoggerTable;
import com.ks.table.HeroExpPoolLoggerTable;
import com.ks.table.HeroLoggerTable;
import com.ks.table.LoginLoggerTable;
import com.ks.table.PropLoggerTable;
import com.ks.table.SlateLoggerTable;
import com.ks.table.StaminaLoggerTable;
import com.utils.DBBeanUtil;
import com.utils.JSONUtil;
import com.utils.StringUtil;
import com.utils.TimeUtil;
import com.utils.TimeUtil.DATE_FORMATER;
import com.web.db.game.GameServerInfo;
import com.web.obj.ParamError;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GameLogService{
	
	/**
	 * //TODO 获取装备日志-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getGameEquipLogList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		String sortname = ServletService.getParamString(request, "sortname", error);
		String sortorder = ServletService.getParamString(request, "sortorder", error);
		String searchName = ServletService.getParamString(request, "searchName", error);
		String searchValue = ServletService.getParamString(request, "searchValue", error);
		int consumeType = ServletService.getParamInt(request, "consumeType", error);
		String begintime = ServletService.getParamString(request, "begintime", error);
		String endtime = ServletService.getParamString(request, "endtime", error);
		JSONObject resp = null;
		if(error.isSuccess()){
//			int t1 = TimeUtil.getSecond(TimeUtil.parseDate(begintime, DATE_FORMATER.yyyy_MM_dd).getTime());
			int t2 = TimeUtil.getSecond(TimeUtil.parseDate(endtime, DATE_FORMATER.yyyy_MM_dd).getTime()) + TimeUtil.DAY_SECOND;
			endtime = DATE_FORMATER.yyyy_MM_dd.format(TimeUtil.getDate(t2));
			int begin = (pageNumber - 1) * pageSize;
			List<EquipmentLogger> list = new ArrayList<EquipmentLogger>();
			String orderby = " order by " + EquipmentLoggerTable.CREATETIME + " desc";
			if(sortname.length() > 0){
				orderby = " order by " + sortname;
				if(sortorder.length() > 0){
					orderby = orderby + " " + sortorder;
				}
			}
			String condition = " where date(" + EquipmentLoggerTable.CREATETIME + ") between '" + begintime + "' and '" + endtime + "'";
			if(searchValue.length() > 0){
				condition += " and " + searchName + " like " + StringUtil.getSqlValue(searchValue);
			}
			if(consumeType == 1){
				condition += " and " + EquipmentLoggerTable.NUM + ">0";
			}else if(consumeType == 2){
				condition += " and " + EquipmentLoggerTable.NUM + "<0";
			}
			int total = 0;
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			ConnParam mainConnParam = server.getMainConnParam();
			Connection conn = ConnUtil.getConnection(mainConnParam);
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + EquipmentLoggerTable.TABLE_NAME + condition + orderby + " limit " + begin + "," + pageSize;
					ResultSet result = stmt.executeQuery(sql);
					try{
						while(result.next()){
							EquipmentLogger log = new EquipmentLogger();
							log = DBBeanUtil.read(log, result);
							list.add(log);
						}
					}finally{
						result.close();
					}
					String sql1 = "select count(" + EquipmentLoggerTable.ID + ") from " + EquipmentLoggerTable.TABLE_NAME + condition;
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
			JSONArray array = toJsonArray(list);
			resp.put("rows", array);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}


	/**
	 * //TODO 获取武魂日志-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getGameEternalLogList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		String sortname = ServletService.getParamString(request, "sortname", error);
		String sortorder = ServletService.getParamString(request, "sortorder", error);
		String searchName = ServletService.getParamString(request, "searchName", error);
		String searchValue = ServletService.getParamString(request, "searchValue", error);
		int consumeType = ServletService.getParamInt(request, "consumeType", error);
		String begintime = ServletService.getParamString(request, "begintime", error);
		String endtime = ServletService.getParamString(request, "endtime", error);
		JSONObject resp = null;
		if(error.isSuccess()){
//			int t1 = TimeUtil.getSecond(TimeUtil.parseDate(begintime, DATE_FORMATER.yyyy_MM_dd).getTime());
			int t2 = TimeUtil.getSecond(TimeUtil.parseDate(endtime, DATE_FORMATER.yyyy_MM_dd).getTime()) + TimeUtil.DAY_SECOND;
			endtime = DATE_FORMATER.yyyy_MM_dd.format(TimeUtil.getDate(t2));
			int begin = (pageNumber - 1) * pageSize;
			List<EternalLogger> list = new ArrayList<EternalLogger>();
			String orderby = " order by " + EternalLoggerTable.CREATETIME + " desc";
			if(sortname.length() > 0){
				orderby = " order by " + sortname;
				if(sortorder.length() > 0){
					orderby = orderby + " " + sortorder;
				}
			}
			String condition = " where date(" + EternalLoggerTable.CREATETIME + ") between '" + begintime + "' and '" + endtime + "'";
			if(searchValue.length() > 0){
				condition += " and " + searchName + " like " + StringUtil.getSqlValue(searchValue);
			}
			if(consumeType == 1){
				condition += " and " + EternalLoggerTable.NUM + ">0";
			}else if(consumeType == 2){
				condition += " and " + EternalLoggerTable.NUM + "<0";
			}
			int total = 0;
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			ConnParam mainConnParam = server.getMainConnParam();
			Connection conn = ConnUtil.getConnection(mainConnParam);
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + EternalLoggerTable.TABLE_NAME + condition + orderby + " limit " + begin + "," + pageSize;
					ResultSet result = stmt.executeQuery(sql);
					try{
						while(result.next()){
							EternalLogger log = new EternalLogger();
							log = DBBeanUtil.read(log, result);
							list.add(log);
						}
					}finally{
						result.close();
					}
					String sql1 = "select count(" + EternalLoggerTable.ID + ") from " + EternalLoggerTable.TABLE_NAME + condition;
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
			JSONArray array = toJsonArray(list);
			resp.put("rows", array);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}

	/**
	 * //TODO 获取玩家经验日志-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getGameExpLogList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		String sortname = ServletService.getParamString(request, "sortname", error);
		String sortorder = ServletService.getParamString(request, "sortorder", error);
		String searchName = ServletService.getParamString(request, "searchName", error);
		String searchValue = ServletService.getParamString(request, "searchValue", error);
		int consumeType = ServletService.getParamInt(request, "consumeType", error);
		String begintime = ServletService.getParamString(request, "begintime", error);
		String endtime = ServletService.getParamString(request, "endtime", error);
		JSONObject resp = null;
		if(error.isSuccess()){
//			int t1 = TimeUtil.getSecond(TimeUtil.parseDate(begintime, DATE_FORMATER.yyyy_MM_dd).getTime());
			int t2 = TimeUtil.getSecond(TimeUtil.parseDate(endtime, DATE_FORMATER.yyyy_MM_dd).getTime()) + TimeUtil.DAY_SECOND;
			endtime = DATE_FORMATER.yyyy_MM_dd.format(TimeUtil.getDate(t2));
			int begin = (pageNumber - 1) * pageSize;
			List<ExpLogger> list = new ArrayList<ExpLogger>();
			String orderby = " order by " + ExpLoggerTable.CREATETIME + " desc";
			if(sortname.length() > 0){
				orderby = " order by " + sortname;
				if(sortorder.length() > 0){
					orderby = orderby + " " + sortorder;
				}
			}
			String condition = " where date(" + ExpLoggerTable.CREATETIME + ") between '" + begintime + "' and '" + endtime + "'";
			if(searchValue.length() > 0){
				condition += " and " + searchName + " like " + StringUtil.getSqlValue(searchValue);
			}
			if(consumeType == 1){
				condition += " and " + ExpLoggerTable.NUM + ">0";
			}else if(consumeType == 2){
				condition += " and " + ExpLoggerTable.NUM + "<0";
			}
			int total = 0;
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			ConnParam mainConnParam = server.getMainConnParam();
			Connection conn = ConnUtil.getConnection(mainConnParam);
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + ExpLoggerTable.TABLE_NAME + condition + orderby + " limit " + begin + "," + pageSize;
					ResultSet result = stmt.executeQuery(sql);
					try{
						while(result.next()){
							ExpLogger log = new ExpLogger();
							log = DBBeanUtil.read(log, result);
							list.add(log);
						}
					}finally{
						result.close();
					}
					String sql1 = "select count(" + ExpLoggerTable.ID + ") from " + ExpLoggerTable.TABLE_NAME + condition;
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
			JSONArray array = toJsonArray(list);
			resp.put("rows", array);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}

	/**
	 * //TODO 获取金币日志-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getGameGoldLogList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		String sortname = ServletService.getParamString(request, "sortname", error);
		String sortorder = ServletService.getParamString(request, "sortorder", error);
		String searchName = ServletService.getParamString(request, "searchName", error);
		String searchValue = ServletService.getParamString(request, "searchValue", error);
		int consumeType = ServletService.getParamInt(request, "consumeType", error);
		String begintime = ServletService.getParamString(request, "begintime", error);
		String endtime = ServletService.getParamString(request, "endtime", error);
		JSONObject resp = null;
		if(error.isSuccess()){
//			int t1 = TimeUtil.getSecond(TimeUtil.parseDate(begintime, DATE_FORMATER.yyyy_MM_dd).getTime());
			int t2 = TimeUtil.getSecond(TimeUtil.parseDate(endtime, DATE_FORMATER.yyyy_MM_dd).getTime()) + TimeUtil.DAY_SECOND;
			endtime = DATE_FORMATER.yyyy_MM_dd.format(TimeUtil.getDate(t2));
			int begin = (pageNumber - 1) * pageSize;
			List<GoldLogger> list = new ArrayList<GoldLogger>();
			String orderby = " order by " + GoldLoggerTable.CREATETIME + " desc";
			if(sortname.length() > 0){
				orderby = " order by " + sortname;
				if(sortorder.length() > 0){
					orderby = orderby + " " + sortorder;
				}
			}
			String condition = " where date(" + GoldLoggerTable.CREATETIME + ") between '" + begintime + "' and '" + endtime + "'";
			if(searchValue.length() > 0){
				condition += " and " + searchName + " like " + StringUtil.getSqlValue(searchValue);
			}
			if(consumeType == 1){
				condition += " and " + GoldLoggerTable.NUM + ">0";
			}else if(consumeType == 2){
				condition += " and " + GoldLoggerTable.NUM + "<0";
			}
			int total = 0;
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			ConnParam mainConnParam = server.getMainConnParam();
			Connection conn = ConnUtil.getConnection(mainConnParam);
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + GoldLoggerTable.TABLE_NAME + condition + orderby + " limit " + begin + "," + pageSize;
					ResultSet result = stmt.executeQuery(sql);
					try{
						while(result.next()){
							GoldLogger log = new GoldLogger();
							log = DBBeanUtil.read(log, result);
							list.add(log);
						}
					}finally{
						result.close();
					}
					String sql1 = "select count(" + GoldLoggerTable.ID + ") from " + GoldLoggerTable.TABLE_NAME + condition;
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
			JSONArray array = toJsonArray(list);
			resp.put("rows", array);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}

	/**
	 * //TODO 获取灵气日志-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getGameGpLogList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		String sortname = ServletService.getParamString(request, "sortname", error);
		String sortorder = ServletService.getParamString(request, "sortorder", error);
		String searchName = ServletService.getParamString(request, "searchName", error);
		String searchValue = ServletService.getParamString(request, "searchValue", error);
		int consumeType = ServletService.getParamInt(request, "consumeType", error);
		String begintime = ServletService.getParamString(request, "begintime", error);
		String endtime = ServletService.getParamString(request, "endtime", error);
		JSONObject resp = null;
		if(error.isSuccess()){
//			int t1 = TimeUtil.getSecond(TimeUtil.parseDate(begintime, DATE_FORMATER.yyyy_MM_dd).getTime());
			int t2 = TimeUtil.getSecond(TimeUtil.parseDate(endtime, DATE_FORMATER.yyyy_MM_dd).getTime()) + TimeUtil.DAY_SECOND;
			endtime = DATE_FORMATER.yyyy_MM_dd.format(TimeUtil.getDate(t2));
			int begin = (pageNumber - 1) * pageSize;
			List<GpLogger> list = new ArrayList<GpLogger>();
			String orderby = " order by " + GpLoggerTable.CREATETIME + " desc";
			if(sortname.length() > 0){
				orderby = " order by " + sortname;
				if(sortorder.length() > 0){
					orderby = orderby + " " + sortorder;
				}
			}
			String condition = " where date(" + GpLoggerTable.CREATETIME + ") between '" + begintime + "' and '" + endtime + "'";
			if(searchValue.length() > 0){
				condition += " and " + searchName + " like " + StringUtil.getSqlValue(searchValue);
			}
			if(consumeType == 1){
				condition += " and " + GpLoggerTable.NUM + ">0";
			}else if(consumeType == 2){
				condition += " and " + GpLoggerTable.NUM + "<0";
			}
			int total = 0;
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			ConnParam mainConnParam = server.getMainConnParam();
			Connection conn = ConnUtil.getConnection(mainConnParam);
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + GpLoggerTable.TABLE_NAME + condition + orderby + " limit " + begin + "," + pageSize;
					ResultSet result = stmt.executeQuery(sql);
					try{
						while(result.next()){
							GpLogger log = new GpLogger();
							DBBeanUtil.read(log, result);
							list.add(log);
						}
					}finally{
						result.close();
					}
					String sql1 = "select count(" + GpLoggerTable.ID + ") from " + GpLoggerTable.TABLE_NAME + condition;
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
			JSONArray array = toJsonArray(list);
			resp.put("rows", array);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}

	/**
	 * //TODO 获取伙伴经验池经验日志-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getGameHeroExpPoolLogList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		String sortname = ServletService.getParamString(request, "sortname", error);
		String sortorder = ServletService.getParamString(request, "sortorder", error);
		String searchName = ServletService.getParamString(request, "searchName", error);
		String searchValue = ServletService.getParamString(request, "searchValue", error);
		int consumeType = ServletService.getParamInt(request, "consumeType", error);
		String begintime = ServletService.getParamString(request, "begintime", error);
		String endtime = ServletService.getParamString(request, "endtime", error);
		JSONObject resp = null;
		if(error.isSuccess()){
//			int t1 = TimeUtil.getSecond(TimeUtil.parseDate(begintime, DATE_FORMATER.yyyy_MM_dd).getTime());
			int t2 = TimeUtil.getSecond(TimeUtil.parseDate(endtime, DATE_FORMATER.yyyy_MM_dd).getTime()) + TimeUtil.DAY_SECOND;
			endtime = DATE_FORMATER.yyyy_MM_dd.format(TimeUtil.getDate(t2));
			int begin = (pageNumber - 1) * pageSize;
			List<HeroExpPoolLogger> list = new ArrayList<HeroExpPoolLogger>();
			String orderby = " order by " + HeroExpPoolLoggerTable.CREATETIME + " desc";
			if(sortname.length() > 0){
				orderby = " order by " + sortname;
				if(sortorder.length() > 0){
					orderby = orderby + " " + sortorder;
				}
			}
			String condition = " where date(" + HeroExpPoolLoggerTable.CREATETIME + ") between '" + begintime + "' and '" + endtime + "'";
			if(searchValue.length() > 0){
				condition += " and " + searchName + " like " + StringUtil.getSqlValue(searchValue);
			}
			if(consumeType == 1){
				condition += " and " + HeroExpPoolLoggerTable.NUM + ">0";
			}else if(consumeType == 2){
				condition += " and " + HeroExpPoolLoggerTable.NUM + "<0";
			}
			int total = 0;
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			ConnParam mainConnParam = server.getMainConnParam();
			Connection conn = ConnUtil.getConnection(mainConnParam);
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + HeroExpPoolLoggerTable.TABLE_NAME + condition + orderby + " limit " + begin + "," + pageSize;
					ResultSet result = stmt.executeQuery(sql);
					try{
						while(result.next()){
							HeroExpPoolLogger log = new HeroExpPoolLogger();
							log = DBBeanUtil.read(log, result);
							list.add(log);
						}
					}finally{
						result.close();
					}
					String sql1 = "select count(" + HeroExpPoolLoggerTable.ID + ") from " + HeroExpPoolLoggerTable.TABLE_NAME + condition;
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
			JSONArray array = toJsonArray(list);
			resp.put("rows", array);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}

	/**
	 * //TODO 获取伙伴日志-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getGameHeroLogList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		String sortname = ServletService.getParamString(request, "sortname", error);
		String sortorder = ServletService.getParamString(request, "sortorder", error);
		String searchName = ServletService.getParamString(request, "searchName", error);
		String searchValue = ServletService.getParamString(request, "searchValue", error);
		int consumeType = ServletService.getParamInt(request, "consumeType", error);
		String begintime = ServletService.getParamString(request, "begintime", error);
		String endtime = ServletService.getParamString(request, "endtime", error);
		JSONObject resp = null;
		if(error.isSuccess()){
//			int t1 = TimeUtil.getSecond(TimeUtil.parseDate(begintime, DATE_FORMATER.yyyy_MM_dd).getTime());
			int t2 = TimeUtil.getSecond(TimeUtil.parseDate(endtime, DATE_FORMATER.yyyy_MM_dd).getTime()) + TimeUtil.DAY_SECOND;
			endtime = DATE_FORMATER.yyyy_MM_dd.format(TimeUtil.getDate(t2));
			int begin = (pageNumber - 1) * pageSize;
			List<HeroLogger> list = new ArrayList<HeroLogger>();
			String orderby = " order by " + HeroLoggerTable.CREATETIME + " desc";
			if(sortname.length() > 0){
				orderby = " order by " + sortname;
				if(sortorder.length() > 0){
					orderby = orderby + " " + sortorder;
				}
			}
			String condition = " where date(" + HeroLoggerTable.CREATETIME + ") between '" + begintime + "' and '" + endtime + "'";
			if(searchValue.length() > 0){
				condition += " and " + searchName + " like " + StringUtil.getSqlValue(searchValue);
			}
			if(consumeType == 1){
				condition += " and " + HeroLoggerTable.NUM + ">0";
			}else if(consumeType == 2){
				condition += " and " + HeroLoggerTable.NUM + "<0";
			}
			int total = 0;
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			ConnParam mainConnParam = server.getMainConnParam();
			Connection conn = ConnUtil.getConnection(mainConnParam);
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + HeroLoggerTable.TABLE_NAME + condition + orderby + " limit " + begin + "," + pageSize;
					ResultSet result = stmt.executeQuery(sql);
					try{
						while(result.next()){
							HeroLogger log = new HeroLogger();
							log = DBBeanUtil.read(log, result);
							list.add(log);
						}
					}finally{
						result.close();
					}
					String sql1 = "select count(" + HeroLoggerTable.ID + ") from " + HeroLoggerTable.TABLE_NAME + condition;
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
			JSONArray array = toJsonArray(list);
			resp.put("rows", array);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}

	/**
	 * //TODO 获取登录日志-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getGameLoginLogList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		String sortname = ServletService.getParamString(request, "sortname", error);
		String sortorder = ServletService.getParamString(request, "sortorder", error);
		String searchName = ServletService.getParamString(request, "searchName", error);
		String searchValue = ServletService.getParamString(request, "searchValue", error);
		int type = ServletService.getParamInt(request, "type", error);
		String begintime = ServletService.getParamString(request, "begintime", error);
		String endtime = ServletService.getParamString(request, "endtime", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int t1 = TimeUtil.getSecond(TimeUtil.parseDate(begintime, DATE_FORMATER.yyyy_MM_dd).getTime());
			int t2 = TimeUtil.getSecond(TimeUtil.parseDate(endtime, DATE_FORMATER.yyyy_MM_dd).getTime()) + TimeUtil.DAY_SECOND;
			int begin = (pageNumber - 1) * pageSize;
			List<LoginLogger> list = new ArrayList<LoginLogger>();
			String orderby = " order by " + LoginLoggerTable.ID + " desc";
			if(sortname.length() > 0){
				orderby = " order by " + sortname;
				if(sortorder.length() > 0){
					orderby = orderby + " " + sortorder;
				}
			}
			String condition = " where " + LoginLoggerTable.TIME + ">=" + t1 + " and " + LoginLoggerTable.TIME + "<" + t2;
			if(searchValue.length() > 0){
				condition += " and " + searchName + " like " + StringUtil.getSqlValue(searchValue);
			}
			if(type != 0){
				condition += " and " + LoginLoggerTable.TYPE + "=" + StringUtil.getSqlValue(type);
			}
			int total = 0;
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			ConnParam mainConnParam = server.getMainConnParam();
			Connection conn = ConnUtil.getConnection(mainConnParam);
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + LoginLoggerTable.TABLE_NAME + " " + condition + orderby + " limit " + begin + "," + pageSize;
					ResultSet result = stmt.executeQuery(sql);
					try{
						while(result.next()){
							LoginLogger log = new LoginLogger();
							log = DBBeanUtil.read(log, result);
							list.add(log);
						}
					}finally{
						result.close();
					}
					String sql1 = "select count(" + LoginLoggerTable.ID + ") from " + LoginLoggerTable.TABLE_NAME + condition;
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
			JSONArray array = toJsonArray(list);
			resp.put("rows", array);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}

	/**
	 * //TODO 获取消费日志-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getGameMoneyLogList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		String sortname = ServletService.getParamString(request, "sortname", error);
		String sortorder = ServletService.getParamString(request, "sortorder", error);
		String searchName = ServletService.getParamString(request, "searchName", error);
		String searchValue = ServletService.getParamString(request, "searchValue", error);
		int consumeType = ServletService.getParamInt(request, "consumeType", error);
		String begintime = ServletService.getParamString(request, "begintime", error);
		String endtime = ServletService.getParamString(request, "endtime", error);
		JSONObject resp = null;
		if(error.isSuccess()){
//			int t1 = TimeUtil.getSecond(TimeUtil.parseDate(begintime, DATE_FORMATER.yyyy_MM_dd).getTime());
			int t2 = TimeUtil.getSecond(TimeUtil.parseDate(endtime, DATE_FORMATER.yyyy_MM_dd).getTime()) + TimeUtil.DAY_SECOND;
			endtime = DATE_FORMATER.yyyy_MM_dd.format(TimeUtil.getDate(t2));
			int begin = (pageNumber - 1) * pageSize;
			List<DiamondLogger> list = new ArrayList<DiamondLogger>();
			String orderby = " order by " + DiamondLoggerTable.CREATETIME + " desc";
			if(sortname.length() > 0){
				orderby = " order by " + sortname;
				if(sortorder.length() > 0){
					orderby = orderby + " " + sortorder;
				}
			}
			String condition = " where date(" + DiamondLoggerTable.CREATETIME + ") between '" + begintime + "' and '" + endtime + "'";
			if(searchValue.length() > 0){
				condition += " and " + searchName + " like " + StringUtil.getSqlValue(searchValue);
			}
			if(consumeType == 1){
				condition += " and " + DiamondLoggerTable.NUM + ">0";
			}else if(consumeType == 2){
				condition += " and " + DiamondLoggerTable.NUM + "<0";
			}
			int total = 0;
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			ConnParam mainConnParam = server.getMainConnParam();
			Connection conn = ConnUtil.getConnection(mainConnParam);
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + DiamondLoggerTable.TABLE_NAME + condition + orderby + " limit " + begin + "," + pageSize;
					ResultSet result = stmt.executeQuery(sql);
					try{
						while(result.next()){
							DiamondLogger log = new DiamondLogger();
							log = DBBeanUtil.read(log, result);
							list.add(log);
						}
					}finally{
						result.close();
					}
					String sql1 = "select count(" + DiamondLoggerTable.ID + ") from " + DiamondLoggerTable.TABLE_NAME + condition;
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
			JSONArray array = toJsonArray(list);
			resp.put("rows", array);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}

	/**
	 * //TODO 获取道具日志-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getGamePropLogList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		String sortname = ServletService.getParamString(request, "sortname", error);
		String sortorder = ServletService.getParamString(request, "sortorder", error);
		String searchName = ServletService.getParamString(request, "searchName", error);
		String searchValue = ServletService.getParamString(request, "searchValue", error);
		int consumeType = ServletService.getParamInt(request, "consumeType", error);
		String begintime = ServletService.getParamString(request, "begintime", error);
		String endtime = ServletService.getParamString(request, "endtime", error);
		JSONObject resp = null;
		if(error.isSuccess()){
//			int t1 = TimeUtil.getSecond(TimeUtil.parseDate(begintime, DATE_FORMATER.yyyy_MM_dd).getTime());
			int t2 = TimeUtil.getSecond(TimeUtil.parseDate(endtime, DATE_FORMATER.yyyy_MM_dd).getTime()) + TimeUtil.DAY_SECOND;
			endtime = DATE_FORMATER.yyyy_MM_dd.format(TimeUtil.getDate(t2));
			int begin = (pageNumber - 1) * pageSize;
			List<PropLogger> list = new ArrayList<PropLogger>();
			String orderby = " order by " + PropLoggerTable.CREATETIME + " desc";
			if(sortname.length() > 0){
				orderby = " order by " + sortname;
				if(sortorder.length() > 0){
					orderby = orderby + " " + sortorder;
				}
			}
			String condition = " where date(" + PropLoggerTable.CREATETIME + ") between '" + begintime + "' and '" + endtime + "'";
			if(searchValue.length() > 0){
				condition += " and " + searchName + " like " + StringUtil.getSqlValue(searchValue);
			}
			if(consumeType == 1){
				condition += " and " + PropLoggerTable.NUM + ">0";
			}else if(consumeType == 2){
				condition += " and " + PropLoggerTable.NUM + "<0";
			}
			int total = 0;
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			ConnParam mainConnParam = server.getMainConnParam();
			Connection conn = ConnUtil.getConnection(mainConnParam);
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + PropLoggerTable.TABLE_NAME + condition + orderby + " limit " + begin + "," + pageSize;
					ResultSet result = stmt.executeQuery(sql);
					try{
						while(result.next()){
							PropLogger log = new PropLogger();
							log = DBBeanUtil.read(log, result);
							list.add(log);
						}
					}finally{
						result.close();
					}
					String sql1 = "select count(" + PropLoggerTable.ID + ") from " + PropLoggerTable.TABLE_NAME + condition;
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
			JSONArray array = toJsonArray(list);
			resp.put("rows", array);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}

	/**
	 * //TODO 获取石板日志-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getGameSlateLogList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		String sortname = ServletService.getParamString(request, "sortname", error);
		String sortorder = ServletService.getParamString(request, "sortorder", error);
		String searchName = ServletService.getParamString(request, "searchName", error);
		String searchValue = ServletService.getParamString(request, "searchValue", error);
		int consumeType = ServletService.getParamInt(request, "consumeType", error);
		String begintime = ServletService.getParamString(request, "begintime", error);
		String endtime = ServletService.getParamString(request, "endtime", error);
		JSONObject resp = null;
		if(error.isSuccess()){
//			int t1 = TimeUtil.getSecond(TimeUtil.parseDate(begintime, DATE_FORMATER.yyyy_MM_dd).getTime());
			int t2 = TimeUtil.getSecond(TimeUtil.parseDate(endtime, DATE_FORMATER.yyyy_MM_dd).getTime()) + TimeUtil.DAY_SECOND;
			endtime = DATE_FORMATER.yyyy_MM_dd.format(TimeUtil.getDate(t2));
			int begin = (pageNumber - 1) * pageSize;
			List<SlateLogger> list = new ArrayList<SlateLogger>();
			String orderby = " order by " + SlateLoggerTable.CREATETIME + " desc";
			if(sortname.length() > 0){
				orderby = " order by " + sortname;
				if(sortorder.length() > 0){
					orderby = orderby + " " + sortorder;
				}
			}
			String condition = " where date(" + SlateLoggerTable.CREATETIME + ") between '" + begintime + "' and '" + endtime + "'";
			if(searchValue.length() > 0){
				condition += " and " + searchName + " like " + StringUtil.getSqlValue(searchValue);
			}
			if(consumeType == 1){
				condition += " and " + SlateLoggerTable.NUM + ">0";
			}else if(consumeType == 2){
				condition += " and " + SlateLoggerTable.NUM + "<0";
			}
			int total = 0;
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			ConnParam mainConnParam = server.getMainConnParam();
			Connection conn = ConnUtil.getConnection(mainConnParam);
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + SlateLoggerTable.TABLE_NAME + condition + orderby + " limit " + begin + "," + pageSize;
					ResultSet result = stmt.executeQuery(sql);
					try{
						while(result.next()){
							SlateLogger log = new SlateLogger();
							log = DBBeanUtil.read(log, result);
							list.add(log);
						}
					}finally{
						result.close();
					}
					String sql1 = "select count(" + SlateLoggerTable.ID + ") from " + SlateLoggerTable.TABLE_NAME + condition;
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
			JSONArray array = toJsonArray(list);
			resp.put("rows", array);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}

	/**
	 * //TODO 获取体力日志-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getGameStaminaLogList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		String sortname = ServletService.getParamString(request, "sortname", error);
		String sortorder = ServletService.getParamString(request, "sortorder", error);
		String searchName = ServletService.getParamString(request, "searchName", error);
		String searchValue = ServletService.getParamString(request, "searchValue", error);
		int consumeType = ServletService.getParamInt(request, "consumeType", error);
		String begintime = ServletService.getParamString(request, "begintime", error);
		String endtime = ServletService.getParamString(request, "endtime", error);
		JSONObject resp = null;
		if(error.isSuccess()){
//			int t1 = TimeUtil.getSecond(TimeUtil.parseDate(begintime, DATE_FORMATER.yyyy_MM_dd).getTime());
			int t2 = TimeUtil.getSecond(TimeUtil.parseDate(endtime, DATE_FORMATER.yyyy_MM_dd).getTime()) + TimeUtil.DAY_SECOND;
			endtime = DATE_FORMATER.yyyy_MM_dd.format(TimeUtil.getDate(t2));
			int begin = (pageNumber - 1) * pageSize;
			List<StaminaLogger> list = new ArrayList<StaminaLogger>();
			String orderby = " order by " + StaminaLoggerTable.CREATETIME + " desc";
			if(sortname.length() > 0){
				orderby = " order by " + sortname;
				if(sortorder.length() > 0){
					orderby = orderby + " " + sortorder;
				}
			}
			String condition = " where date(" + StaminaLoggerTable.CREATETIME + ") between '" + begintime + "' and '" + endtime + "'";
			if(searchValue.length() > 0){
				condition += " and " + searchName + " like " + StringUtil.getSqlValue(searchValue);
			}
			if(consumeType == 1){
				condition += " and " + StaminaLoggerTable.NUM + ">0";
			}else if(consumeType == 2){
				condition += " and " + StaminaLoggerTable.NUM + "<0";
			}
			int total = 0;
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			ConnParam mainConnParam = server.getMainConnParam();
			Connection conn = ConnUtil.getConnection(mainConnParam);
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + StaminaLoggerTable.TABLE_NAME + condition + orderby + " limit " + begin + "," + pageSize;
					ResultSet result = stmt.executeQuery(sql);
					try{
						while(result.next()){
							StaminaLogger log = new StaminaLogger();
							log = DBBeanUtil.read(log, result);
							list.add(log);
						}
					}finally{
						result.close();
					}
					String sql1 = "select count(" + StaminaLoggerTable.ID + ") from " + StaminaLoggerTable.TABLE_NAME + condition;
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
			JSONArray array = toJsonArray(list);
			resp.put("rows", array);
			resp.put("code", 0);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	//TODO 
	/******************************************************************************************/
	
	@SuppressWarnings("rawtypes")
	public static JSONArray toJsonArray(List list) throws Exception{
		JSONArray array = new JSONArray();
		for(Object logger : list){
			JSONObject json = JSONUtil.parseSimpleJSON(logger, logger.getClass());
			if(json.containsKey("loggerType")){
				json.put("typeName", SystemConstant.getLoggerApproachName(json.getInt("loggerType")));
			}
			array.add(json);
		}
		return array;
	}
	
}
