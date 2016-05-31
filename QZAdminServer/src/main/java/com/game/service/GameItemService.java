package com.game.service;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.db.util.ConnParam;
import com.db.util.ConnUtil;
import com.ks.constant.SystemConstant;
import com.ks.db.cfg.Equipment;
import com.ks.db.cfg.Eternal;
import com.ks.db.cfg.Hero;
import com.ks.db.cfg.Prop;
import com.ks.db.model.User;
import com.ks.db.model.UserEquipment;
import com.ks.db.model.UserEternal;
import com.ks.db.model.UserHero;
import com.ks.db.model.UserProp;
import com.ks.table.EquipmentTable;
import com.ks.table.EternalTable;
import com.ks.table.HeroTable;
import com.ks.table.PropTable;
import com.ks.table.UserEquipmentTable;
import com.ks.table.UserEternalTable;
import com.ks.table.UserHeroTable;
import com.ks.table.UserPropTable;
import com.ks.table.UserTable;
import com.utils.DBBeanUtil;
import com.utils.JSONUtil;
import com.utils.StringUtil;
import com.web.db.game.GameServerInfo;
import com.web.obj.ParamError;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GameItemService{
	
	/**
	 *  //TODO 获取Item列表-jsp
	 * @param server
	 * @param itemType
	 * @param searchType
	 * @param pageNumber
	 * @param pageSize
	 * @param searchValue
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getItemList(HttpServletRequest request, HttpSession session) throws Exception{
		ParamError error = new ParamError();
		int itemType = ServletService.getParamInt(request, "itemType", error);
		int searchType = ServletService.getParamInt(request, "searchType", error);
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		String searchValue = ServletService.getParamString(request, "searchValue", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			if(server == null){
				resp = error.getServerError();
			}else{
				int begin = (pageNumber - 1) * pageSize;
				JSONArray array = new JSONArray();
				int total = 0;
				if(searchValue == null){
					searchValue = "";
				}else if(searchValue.length() > 0){
					searchValue = searchValue.trim();
				}
				if(itemType == SystemConstant.ITEM_EFFECT_TYPE_HERO 
						|| itemType == SystemConstant.ITEM_EFFECT_TYPE_PROP 
						|| itemType == SystemConstant.ITEM_EFFECT_TYPE_EQUIPMENT 
						|| itemType == SystemConstant.ITEM_EFFECT_TYPE_ETERNAL){
					ConnParam connParam = server.getConfigConnParam();
					Connection conn = ConnUtil.getConnection(connParam);
					try{
						Statement stmt = conn.createStatement();
						ResultSet result = null;
						Class<?> clazz = null;
						String sql = null;
						String totalsql = null;
						String key = null;
						if(itemType == SystemConstant.ITEM_EFFECT_TYPE_HERO){
							key = HeroTable.J_HEROID;
							totalsql = "select count(1) from " + HeroTable.TABLE_NAME;
							sql = "select * from " + HeroTable.TABLE_NAME;
							if(searchValue.length() > 0){
								if(searchType == 1){
									sql += " where " + HeroTable.HEROID + " like " + StringUtil.getLikeSqlValue(searchValue, true, true);
								}else{
									sql += " where " + HeroTable.NAME + " like " + StringUtil.getLikeSqlValue(searchValue, true, true);
								}
							}
							clazz = Hero.class;
						}else if(itemType == SystemConstant.ITEM_EFFECT_TYPE_PROP){
							key = PropTable.J_PROPID;
							totalsql = "select count(1) from " + PropTable.TABLE_NAME;
							sql = "select * from " + PropTable.TABLE_NAME;
							if(searchValue.length() > 0){
								if(searchType == 1){
									sql += " where " + PropTable.PROPID + " like " + StringUtil.getLikeSqlValue(searchValue, true, true);
								}else{
									sql += " where " + PropTable.NAME + " like " + StringUtil.getLikeSqlValue(searchValue, true, true);
								}
							}
							clazz = Prop.class;
						}else if(itemType == SystemConstant.ITEM_EFFECT_TYPE_EQUIPMENT){
							key = EquipmentTable.J_EQUIPMENTID;
							totalsql = "select count(1) from " + EquipmentTable.TABLE_NAME;
							sql = "select * from " + EquipmentTable.TABLE_NAME;
							if(searchValue.length() > 0){
								if(searchType == 1){
									sql += " where " + EquipmentTable.EQUIPMENTID + " like " + StringUtil.getLikeSqlValue(searchValue, true, true);
								}else{
									sql += " where " + EquipmentTable.NAME + " like " + StringUtil.getLikeSqlValue(searchValue, true, true);
								}
							}
							clazz = Equipment.class;
						}else{
							key = EternalTable.J_ETERNALID;
							totalsql = "select count(1) from " + EternalTable.TABLE_NAME;
							sql = "select * from " + EternalTable.TABLE_NAME;
							if(searchValue.length() > 0){
								if(searchType == 1){
									sql += " where " + EternalTable.ETERNALID + " like " + StringUtil.getLikeSqlValue(searchValue, true, true);
								}else{
									sql += " where " + EternalTable.NAME + " like " + StringUtil.getLikeSqlValue(searchValue, true, true);
								}
							}
							clazz = Eternal.class;
						}
						sql += " limit " + begin + "," + pageSize;
						result = stmt.executeQuery(sql);
						List<Field> fields = DBBeanUtil.getDBFields(clazz);
						while(result.next()){
							Object obj = clazz.newInstance();
							obj = DBBeanUtil.read(obj, result);
							JSONObject json = JSONUtil.parseDBJsonObject(obj, fields);
							json.put("id", json.get(key));
							json.put("itemType", itemType);
							if(itemType == SystemConstant.ITEM_EFFECT_TYPE_HERO
									|| itemType == SystemConstant.ITEM_EFFECT_TYPE_EQUIPMENT){
								json.put("level", 1);
							}
							array.add(json);
						}
						result = stmt.executeQuery(totalsql);
						if(result.next()){
							total = result.getInt(1);
						}
					}finally{
						ConnUtil.closeConnection(conn);
					}
				}else{
					for(int i = 0; i < SystemConstant.ITEM_EFFECTS_TYPE_CURRENCY.length; i++){
						itemType = SystemConstant.ITEM_EFFECTS_TYPE_CURRENCY[i];
						JSONObject json = new JSONObject();
						json.put("id", 0);
						json.put("name", SystemConstant.getGoodsTypeName(itemType));
						json.put("itemType", itemType);
						array.add(json);
					}
					total = SystemConstant.ITEM_EFFECTS_TYPE_CURRENCY.length;
				}
				resp = new JSONObject();
				resp.put("page", pageNumber);
				resp.put("total", total);
				resp.put("rows", array);
			}
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 *  //TODO 获取玩家装备列表-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getEquipList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		String sortname = ServletService.getParamString(request, "sortname", error);
		String sortorder = ServletService.getParamString(request, "sortorder", error);
		int searchType = ServletService.getParamInt(request, "searchType", error);
		String searchValue = ServletService.getParamString(request, "searchValue", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int begin = (pageNumber - 1) * pageSize;
			List<UserEquipment> items = new ArrayList<UserEquipment>();
			String orderby = "";
			if(sortname.length() > 0){
				orderby = " order by " + sortname;
				if(sortorder.length() > 0){
					orderby = orderby + " " + sortorder;
				}
			}
			String condition = "";
			if(searchType == 1){
				condition += " where " + UserTable.USERNAME + " = " + StringUtil.getSqlValue(searchValue);
			}else{
				condition += " where " + UserTable.PLAYERNAME + " = " + StringUtil.getSqlValue(searchValue);
			}
			int total = 0;
			User player = null;
			Set<Integer> cfgIds = new HashSet<Integer>();
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			ConnParam mainConnParam = server.getMainConnParam();
			Connection conn = ConnUtil.getConnection(mainConnParam);
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + UserTable.TABLE_NAME + condition;
					ResultSet result = stmt.executeQuery(sql);
					try{
						if(result.next()){
							player = new User();
							player = DBBeanUtil.read(player, result);
						}
					}finally{
						result.close();
					}
					if(player != null){
						condition = " where " + UserEquipmentTable.USERID + " = " + player.getUserId() + " and " + UserEquipmentTable.EQUIPMENTID + " != 0 ";
						String sql1 = "select * from " + UserEquipmentTable.getTableName(player.getUserId()) + condition + orderby + " limit " + begin + "," + pageSize;
						ResultSet result1 = stmt.executeQuery(sql1);
						try{
							while(result1.next()){
								UserEquipment item = new UserEquipment();
								item = DBBeanUtil.read(item, result1);
								items.add(item);
								cfgIds.add(item.getEquipmentId());
							}
						}finally{
							result1.close();
						}
						String sql2 = "select count(" + UserEquipmentTable.USEREQUIPMENTID + ") from " + UserEquipmentTable.getTableName(player.getUserId()) + condition;
						ResultSet result2 = stmt.executeQuery(sql2);
						try{
							if(result2.next()){
								total = result2.getInt(1);
							}
						}finally{
							result2.close();
						}
					}
				}finally{
					stmt.close();
				}
			}finally{
				ConnUtil.closeConnection(conn);
			}
			Map<Integer, Equipment> cfgMap = getEquipConfigMap(server, cfgIds);
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("code", 0);
			if(player != null){
				result.put("playerName", player.getPlayerName());
				result.put("page", pageNumber);
				result.put("total", total);
				JSONArray array = new JSONArray();
				for(UserEquipment info : items){
					JSONObject json = JSONUtil.parseSimpleJSON(info, UserEquipment.class);
					Equipment config = cfgMap.get(info.getEquipmentId());
					if(config != null){
						json.put("name", config.getName());
						json.put("quality", config.getQuality());
					}else{
						json.put("name", "");
						json.put("quality", 1);
					}
					array.add(json);
				}
				result.put("rows", array);
			}else{
				result.put("code", -1);
				result.put("tip", "指定玩家不存在！");
			}
			resp = JSONObject.fromObject(result);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 *  //TODO 获取玩家武魂列表-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getEternalList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		String sortname = ServletService.getParamString(request, "sortname", error);
		String sortorder = ServletService.getParamString(request, "sortorder", error);
		int searchType = ServletService.getParamInt(request, "searchType", error);
		String searchValue = ServletService.getParamString(request, "searchValue", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int begin = (pageNumber - 1) * pageSize;
			List<UserEternal> items = new ArrayList<UserEternal>();
			String orderby = "";
			if(sortname.length() > 0){
				orderby = " order by " + sortname;
				if(sortorder.length() > 0){
					orderby = orderby + " " + sortorder;
				}
			}
			String condition = "";
			if(searchType == 1){
				condition += " where " + UserTable.USERNAME + " = " + StringUtil.getSqlValue(searchValue);
			}else{
				condition += " where " + UserTable.PLAYERNAME + " = " + StringUtil.getSqlValue(searchValue);
			}
			int total = 0;
			User player = null;
			Set<Integer> cfgIds = new HashSet<Integer>();
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			ConnParam mainConnParam = server.getMainConnParam();
			Connection conn = ConnUtil.getConnection(mainConnParam);
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + UserTable.TABLE_NAME + condition;
					ResultSet result = stmt.executeQuery(sql);
					try{
						if(result.next()){
							player = new User();
							player = DBBeanUtil.read(player, result);
						}
					}finally{
						result.close();
					}
					if(player != null){
						condition = " where " + UserEternalTable.USERID + " = " + player.getUserId() + " and " + UserEternalTable.ETERNALID + " != 0 ";
						String sql1 = "select * from " + UserEternalTable.getTableName(player.getUserId()) + condition + orderby + " limit " + begin + "," + pageSize;
						ResultSet result1 = stmt.executeQuery(sql1);
						try{
							while(result1.next()){
								UserEternal item = new UserEternal();
								item = DBBeanUtil.read(item, result1);
								items.add(item);
								cfgIds.add(item.getEternalId());
							}
						}finally{
							result1.close();
						}
						String sql2 = "select count(" + UserEternalTable.USERETERNALID + ") from " + UserEternalTable.getTableName(player.getUserId()) + condition;
						ResultSet result2 = stmt.executeQuery(sql2);
						try{
							if(result2.next()){
								total = result2.getInt(1);
							}
						}finally{
							result2.close();
						}
					}
				}finally{
					stmt.close();
				}
			}finally{
				ConnUtil.closeConnection(conn);
			}
			Map<Integer, Eternal> cfgMap = getEternalConfigMap(server, cfgIds);
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("code", 0);
			if(player != null){
				result.put("playerName", player.getPlayerName());
				result.put("page", pageNumber);
				result.put("total", total);
				JSONArray array = new JSONArray();
				for(UserEternal info : items){
					JSONObject json = JSONUtil.parseSimpleJSON(info, UserEternal.class);
					Eternal config = cfgMap.get(info.getEternalId());
					if(config != null){
						json.put("name", config.getName());
						json.put("quality", config.getQuality());
					}else{
						json.put("name", "");
						json.put("quality", 1);
					}
					array.add(json);
				}
				result.put("rows", array);
			}else{
				result.put("code", -1);
				result.put("tip", "指定玩家不存在！");
			}
			resp = JSONObject.fromObject(result);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	

	
	/**
	 *  //TODO 获取玩家伙伴列表-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getHeroList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		String sortname = ServletService.getParamString(request, "sortname", error);
		String sortorder = ServletService.getParamString(request, "sortorder", error);
		int searchType = ServletService.getParamInt(request, "searchType", error);
		String searchValue = ServletService.getParamString(request, "searchValue", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int begin = (pageNumber - 1) * pageSize;
			List<UserHero> items = new ArrayList<UserHero>();
			String orderby = "";
			if(sortname.length() > 0){
				orderby = " order by " + sortname;
				if(sortorder.length() > 0){
					orderby = orderby + " " + sortorder;
				}
			}
			String condition = "";
			if(searchType == 1){
				condition += " where " + UserTable.USERNAME + " = " + StringUtil.getSqlValue(searchValue);
			}else{
				condition += " where " + UserTable.PLAYERNAME + " = " + StringUtil.getSqlValue(searchValue);
			}
			int total = 0;
			User player = null;
			Set<Integer> cfgIds = new HashSet<Integer>();
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			ConnParam mainConnParam = server.getMainConnParam();
			Connection conn = ConnUtil.getConnection(mainConnParam);
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + UserTable.TABLE_NAME + condition;
					ResultSet result = stmt.executeQuery(sql);
					try{
						if(result.next()){
							player = new User();
							player = DBBeanUtil.read(player, result);
						}
					}finally{
						result.close();
					}
					if(player != null){
						condition = " where " + UserHeroTable.USERID + " = " + player.getUserId() + " and " + UserHeroTable.HEROID + " != 0 ";
						String sql1 = "select * from " + UserHeroTable.getTableName(player.getUserId()) + condition + orderby + " limit " + begin + "," + pageSize;
						ResultSet result1 = stmt.executeQuery(sql1);
						try{
							while(result1.next()){
								UserHero item = new UserHero();
								item = DBBeanUtil.read(item, result1);
								items.add(item);
								cfgIds.add(item.getHeroId());
							}
						}finally{
							result1.close();
						}
						String sql2 = "select count(" + UserHeroTable.ID + ") from " + UserHeroTable.getTableName(player.getUserId()) + condition;
						ResultSet result2 = stmt.executeQuery(sql2);
						try{
							if(result2.next()){
								total = result2.getInt(1);
							}
						}finally{
							result2.close();
						}
					}
				}finally{
					stmt.close();
				}
			}finally{
				ConnUtil.closeConnection(conn);
			}
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("code", 0);
			if(player != null){
				result.put("playerName", player.getPlayerName());
				result.put("page", pageNumber);
				result.put("total", total);
				Map<Integer, Hero> cfgMap = getHeroConfigMap(server, cfgIds);
				JSONArray array = new JSONArray();
				for(UserHero info : items){
					JSONObject json = JSONUtil.parseSimpleJSON(info, UserHero.class);
					Hero config = cfgMap.get(info.getHeroId());
					if(config != null){
						json.put("name", config.getName());
						json.put("quality", config.getQuality());
					}else{
						json.put("name", "");
						json.put("quality", 1);
					}
					array.add(json);
				}
				result.put("rows", array);
			}else{
				result.put("code", -1);
				result.put("tip", "指定玩家不存在！");
			}
			resp = JSONObject.fromObject(result);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	/**
	 *  //TODO 获取道具列表-jsp
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getPropList(HttpServletRequest request, HttpSession session)throws Exception{
		ParamError error = new ParamError();
		int pageNumber = ServletService.getParamInt(request, "page", error);
		int pageSize = ServletService.getParamInt(request, "rp", error);
		String sortname = ServletService.getParamString(request, "sortname", error);
		String sortorder = ServletService.getParamString(request, "sortorder", error);
		int searchType = ServletService.getParamInt(request, "searchType", error);
		String searchValue = ServletService.getParamString(request, "searchValue", error);
		JSONObject resp = null;
		if(error.isSuccess()){
			int begin = (pageNumber - 1) * pageSize;
			List<UserProp> items = new ArrayList<UserProp>();
			String orderby = "";
			if(sortname.length() > 0){
				orderby = " order by " + sortname;
				if(sortorder.length() > 0){
					orderby = orderby + " " + sortorder;
				}
			}
			String condition = "";
			if(searchType == 1){
				condition += " where " + UserTable.USERNAME + " = " + StringUtil.getSqlValue(searchValue);
			}else{
				condition += " where " + UserTable.PLAYERNAME + " = " + StringUtil.getSqlValue(searchValue);
			}
			int total = 0;
			User player = null;
			Set<Integer> cfgIds = new HashSet<Integer>();
			GameServerInfo server = (GameServerInfo) session.getAttribute("selserver");
			ConnParam mainConnParam = server.getMainConnParam();
			Connection conn = ConnUtil.getConnection(mainConnParam);
			try{
				Statement stmt = conn.createStatement();
				try{
					String sql = "select * from " + UserTable.TABLE_NAME + condition;
					ResultSet result = stmt.executeQuery(sql);
					try{
						if(result.next()){
							player = new User();
							player = DBBeanUtil.read(player, result);
						}
					}finally{
						result.close();
					}
					if(player != null){
						condition = " where " + UserPropTable.USERID + " = " + player.getUserId() + " and " + UserPropTable.PROPID + " != 0 and " + UserPropTable.NUM + " > 0";
						String sql1 = "select * from " + UserPropTable.getTableName(player.getUserId()) + condition + orderby + " limit " + begin + "," + pageSize;
						ResultSet result1 = stmt.executeQuery(sql1);
						try{
							while(result1.next()){
								UserProp item = new UserProp();
								item = DBBeanUtil.read(item, result1);
								items.add(item);
								cfgIds.add(item.getPropId());
							}
						}finally{
							result1.close();
						}
						String sql2 = "select count(" + UserPropTable.PROPID + ") from " + UserPropTable.getTableName(player.getUserId()) + condition;
						ResultSet result2 = stmt.executeQuery(sql2);
						try{
							if(result2.next()){
								total = result2.getInt(1);
							}
						}finally{
							result2.close();
						}
					}
				}finally{
					stmt.close();
				}
			}finally{
				ConnUtil.closeConnection(conn);
			}
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("code", 0);
			if(player != null){
				result.put("playerName", player.getPlayerName());
				result.put("page", pageNumber);
				result.put("total", total);
				Map<Integer, Prop> cfgMap = getPropConfigMap(server, cfgIds);
				JSONArray array = new JSONArray();
				for(UserProp info : items){
					JSONObject json = JSONUtil.parseSimpleJSON(info, UserProp.class);
					Prop config = cfgMap.get(info.getPropId());
					if(config != null){
						json.put("name", config.getName());
					}else{
						json.put("name", "");
					}
					array.add(json);
				}
				result.put("rows", array);
			}else{
				result.put("code", -1);
				result.put("tip", "指定玩家不存在！");
			}
			resp = JSONObject.fromObject(result);
		}else{
			resp = error.getErrorData();
		}
		return resp;
	}
	
	//TODO
	/************************************************************************************************/  
	
	private static Map<Integer, Equipment> getEquipConfigMap(GameServerInfo server, Set<Integer> ids) throws Exception{
		String condition = "";
		for(int id : ids){
			condition += id + ",";
		}
		if(condition.length() > 0){
			condition = " where " + EquipmentTable.EQUIPMENTID + " in (" + condition.substring(0, condition.length() - 1) + ")";
		}
		Map<Integer, Equipment> map = new HashMap<Integer, Equipment>(); 
		String sql1 = "select * from " + EquipmentTable.TABLE_NAME + condition;
		if(condition.length() > 0){
			ConnParam connParam = server.getConfigConnParam();
			Connection conn = ConnUtil.getConnection(connParam);
			try{
				Statement stmt = conn.createStatement();
				try{
					if(condition.length() > 0){
						ResultSet result1 = stmt.executeQuery(sql1);
						while(result1.next()){
							Equipment cfg = new Equipment();
							cfg = DBBeanUtil.read(cfg, result1);
							map.put(cfg.getEquipmentId(), cfg);
						}
					}
				}finally{
					stmt.close();
				}
			}finally{
				conn.close();
			}
		}
		return map;
	}
	
	private static Map<Integer, Eternal> getEternalConfigMap(GameServerInfo server, Set<Integer> ids) throws Exception{
		String condition = "";
		for(int id : ids){
			condition += id + ",";
		}
		if(condition.length() > 0){
			condition = " where " + EternalTable.ETERNALID + " in (" + condition.substring(0, condition.length() - 1) + ")";
		}
		Map<Integer, Eternal> map = new HashMap<Integer, Eternal>(); 
		String sql1 = "select * from " + EternalTable.TABLE_NAME + condition;
		if(condition.length() > 0){
			ConnParam connParam = server.getConfigConnParam();
			Connection conn = ConnUtil.getConnection(connParam);
			try{
				Statement stmt = conn.createStatement();
				try{
					if(condition.length() > 0){
						ResultSet result1 = stmt.executeQuery(sql1);
						while(result1.next()){
							Eternal cfg = new Eternal();
							cfg = DBBeanUtil.read(cfg, result1);
							map.put(cfg.getEternalId(), cfg);
						}
					}
				}finally{
					stmt.close();
				}
			}finally{
				conn.close();
			}
		}
		return map;
	}

	
	private static Map<Integer, Prop> getPropConfigMap(GameServerInfo server, Set<Integer> ids) throws Exception{
		String condition = "";
		for(int id : ids){
			condition += id + ",";
		}
		if(condition.length() > 0){
			condition = " where " + PropTable.PROPID + " in (" + condition.substring(0, condition.length() - 1) + ")";
		}
		Map<Integer, Prop> map = new HashMap<Integer, Prop>(); 
		String sql1 = "select * from " + PropTable.TABLE_NAME + condition;
		if(condition.length() > 0){
			ConnParam connParam = server.getConfigConnParam();
			Connection conn = ConnUtil.getConnection(connParam);
			try{
				Statement stmt = conn.createStatement();
				try{
					if(condition.length() > 0){
						ResultSet result1 = stmt.executeQuery(sql1);
						while(result1.next()){
							Prop cfg = new Prop();
							cfg = DBBeanUtil.read(cfg, result1);
							map.put(cfg.getPropId(), cfg);
						}
					}
				}finally{
					stmt.close();
				}
			}finally{
				conn.close();
			}
		}
		return map;
	}
	
	private static Map<Integer, Hero> getHeroConfigMap(GameServerInfo server, Set<Integer> ids) throws Exception{
		String condition = "";
		for(int id : ids){
			condition += id + ",";
		}
		if(condition.length() > 0){
			condition = " where " + HeroTable.HEROID + " in (" + condition.substring(0, condition.length() - 1) + ")";
		}
		Map<Integer, Hero> map = new HashMap<Integer, Hero>(); 
		String sql1 = "select * from " + HeroTable.TABLE_NAME + condition;
		if(condition.length() > 0){
			ConnParam connParam = server.getConfigConnParam();
			Connection conn = ConnUtil.getConnection(connParam);
			try{
				Statement stmt = conn.createStatement();
				try{
					if(condition.length() > 0){
						ResultSet result1 = stmt.executeQuery(sql1);
						while(result1.next()){
							Hero cfg = new Hero();
							cfg = DBBeanUtil.read(cfg, result1);
							map.put(cfg.getHeroId(), cfg);
						}
					}
				}finally{
					stmt.close();
				}
			}finally{
				conn.close();
			}
		}
		return map;
	}
	
}
