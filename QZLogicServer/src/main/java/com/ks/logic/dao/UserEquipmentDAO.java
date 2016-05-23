package com.ks.logic.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetDeleteSqlSet;
import com.ks.access.DBBeanSetInsertSqlSet;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.DBBeanSetUpdateSqlSet;
import com.ks.access.GameDAOTemplate;
import com.ks.constant.SystemConstant;
import com.ks.db.model.UserEquipment;
import com.ks.table.UserEquipmentTable;
import com.ks.util.JSONUtil;

public class UserEquipmentDAO extends GameDAOTemplate {
	
	private static final String USER_EQUIPMENT_KEY = "USER_EQUIPMENT_";
	private static final String LOAD = "LOAD";
	
	public static class UserEquipmentMapMapper{
		public static Map<Integer, UserEquipment> rowMapper(Map<String, String> map) {
			Map<Integer, UserEquipment> result = new HashMap<Integer, UserEquipment>();
			for(Map.Entry<String, String> entry : map.entrySet()){
				if(!entry.getKey().equals(LOAD)){
					UserEquipment bean = JSONUtil.toObject(entry.getValue(), UserEquipment.class);
					result.put(bean.getUserEquipmentId(), bean);
				}
			}
			return result;
		}
	}
	
	public static class UserEquipmentObjMapper{
		public static Map<String, String> objMapper(Map<Integer, UserEquipment> map) {
			Map<String, String> result = new HashMap<String, String>();
			for(Map.Entry<Integer, UserEquipment> entry : map.entrySet()){
				result.put(entry.getKey().toString(), JSONUtil.toJson(entry.getValue()));
			}
			return result;
		}
	}
	
	private static final String getUserEquipmentSetKey(int userId){
		return USER_EQUIPMENT_KEY + userId;
	}
	
	private static String getTableName(int userId){
		return "t_user_equipment_"+(userId%10);
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryAllUserEquipment", dbbean=UserEquipment.class, wheres={UserEquipmentTable.USERID})})
	public List<UserEquipment> queryAllUserEquipment(int userId){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserEquipment.class, "queryAllUserEquipment", getTableName(userId));
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(UserEquipment.class), userId);
	}
	
	@DBBeanSetSqlSetList(deletes={@DBBeanSetDeleteSqlSet(name="deleteUserEquipment", dbbean=UserEquipment.class, wheres={UserEquipmentTable.USEREQUIPMENTID, UserEquipmentTable.USERID})})
	public void deleteUserEquipment(int userId,int userEquipmentId){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserEquipment.class, "deleteUserEquipment", getTableName(userId));
		saveOrUpdate(sql, userEquipmentId,userId);
	}
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateUserEquipments", dbbean=UserEquipment.class, wheres={UserEquipmentTable.USERID, UserEquipmentTable.USEREQUIPMENTID})})
	public void updateUserEquipments(List<UserEquipment> equipments){
		if(equipments == null || equipments.size() == 0){
			return;
		}
		String sql = DBBeanRowMapperManager.getDynamicSql(UserEquipment.class, "updateUserEquipments", getTableName(equipments.get(0).getUserId()));
		List<Object[]> args = new ArrayList<Object[]>();
		for(UserEquipment ue : equipments){
			Object[] arg = DBBeanRowMapperManager.getDynamicParams(UserEquipment.class, "updateUserEquipments", ue).toArray();
			args.add(arg);
		}
		executeBatch(sql, args);
	}
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateUserEquipment", dbbean=UserEquipment.class, wheres={UserEquipmentTable.USERID, UserEquipmentTable.USEREQUIPMENTID})})
	public void updateUserEquipment(UserEquipment equipment){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserEquipment.class, "updateUserEquipment", getTableName(equipment.getUserId()));
		Object[] args = DBBeanRowMapperManager.getDynamicParams(UserEquipment.class, "updateUserEquipment", equipment).toArray();
		saveOrUpdate(sql, args);
	}
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addUserEquipment", dbbean=UserEquipment.class)})
	public void addUserEquipment(UserEquipment ue){
		String sql =  DBBeanRowMapperManager.getDynamicSql(UserEquipment.class, "addUserEquipment", getTableName(ue.getUserId()));
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserEquipment.class, "addUserEquipment", ue);
		int id = insertAndReturnId(sql, INT_KEY, params.toArray());
		ue.setUserEquipmentId(id);
	}
	
	/**
	 * 查询装备
	 */
	public Map<Integer, UserEquipment> queryUserEquipmentCache(int userId, boolean checkload){
		String setKey = getUserEquipmentSetKey(userId);
		Map<String, String> map = hgetAll(setKey);
		if(!checkload || isLoad(map)){
			expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
			return UserEquipmentMapMapper.rowMapper(map);
		}
		return null;
	}
	
	/**
	 * 添加装备到缓存
	 */
	public void addUserEquipmetCache(UserEquipment ue){
		String setKey = getUserEquipmentSetKey(ue.getUserId());
		hset(setKey, String.valueOf(ue.getUserEquipmentId()), JSONUtil.toJson(ue));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}
	
	/**
	 * 添加装备到缓存
	 */
	public void setUserEquipmetCache(int userId, Map<Integer, UserEquipment> uemap){
		setCacheSign();
		try{
			String setKey = getUserEquipmentSetKey(userId);
			del(setKey);
			if(!uemap.isEmpty()){
				hmset(setKey, UserEquipmentObjMapper.objMapper(uemap));
			}
			hset(setKey, LOAD, LOAD);
			expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
		}finally{
			clearCacheSign();
		}
	}
	
	/**
	 * 删除缓存中的装备
	 */
	public void deleteUserEquipmentCache(int userId,int userEquipmentId){
		String setKey = getUserEquipmentSetKey(userId);
		hdel(setKey, String.valueOf(userEquipmentId));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}
	
	/**
	 * 更新缓存中的装备
	 */
	public void updateUserEquipmentCache(UserEquipment ue){
		ue.setUpdateTime(new Date());
		ue.setUpdate(true);
		String setKey = getUserEquipmentSetKey(ue.getUserId());
		hset(setKey, String.valueOf(ue.getUserEquipmentId()), JSONUtil.toJson(ue));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}

	public void clearUserEquipmentCache(int userId){
//		Map<Integer, UserEquipment> uemap = queryUserEquipmentCache(userId, false);
//		if(uemap != null){
//			List<UserEquipment> es = new ArrayList<UserEquipment>();
//			for(UserEquipment ue : uemap.values()){
//				if(ue.isUpdate()){
//					es.add(ue);
//				}
//			}
//			updateUserEquipments(es);
//			del(getUserEquipmentSetKey(userId));
//		}
		del(getUserEquipmentSetKey(userId));
	}
	
	/**
	 * 获取装备数量
	 */
	public int getEquipmentSize(int userId){
		String setKey = getUserEquipmentSetKey(userId);
		if(exists(setKey)){
			int value =  hlen(setKey).intValue() - 1;
			if(value >= 0){
				return value;
			}
		}
		return 0;
	}
	
}
