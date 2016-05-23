package com.ks.logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetInsertSqlSet;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.DBBeanSetUpdateSqlSet;
import com.ks.access.DBBeanSqlSet;
import com.ks.access.GameDAOTemplate;
import com.ks.access.GameDaoException;
import com.ks.access.SQLOpt;
import com.ks.cache.JedisBeanManager;
import com.ks.constant.SystemConstant;
import com.ks.db.model.User;
import com.ks.db.model.UserRecord;
import com.ks.model.user.UserBaseinfo;
import com.ks.table.UserRecordTable;
import com.ks.table.UserTable;

/**
 * 用户数据操作
 * 
 * @author ks
 * 
 */
public class UserDAO extends GameDAOTemplate {
	
	/**用户缓存*/
	private static final String USER_CACHE = "USER_CACHE_";
	/**用户基本信息缓存*/
	public static final String USER_BASE_INFO_CACHE = "USER_BASE_INFO_";
	/**用户等级*/
	public static final String USER_LEVEL_KEY = "USER_LEVEL";
	/**用户战斗力*/
	public static final String USER_FIGHTING = "USER_FIGHTING";
	/**玩家id*/
	public static final String USER_ID = "USER_ID";
	/**开服修复玩家(list=[id, id])*/
	public static final String USER_REPAIR = "USER_REPAIR";
//	
//	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="getAlllUser", dbbean=User.class)})
//	public List<User> getAlllUser(){
//		String sql = DBBeanRowMapperManager.getDynamicSql(User.class, "getAlllUser");
//		return this.queryForList(sql,  DBBeanRowMapperManager.getRowMapper(User.class));
//	}

	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="findUserByUsername", dbbean=User.class, wheres={UserTable.USERNAME, UserTable.PARTNER}, limit={"1"})})
	public User findUserByUsername(String username, int partner) {
		String sql = DBBeanRowMapperManager.getDynamicSql(User.class, "findUserByUsername");
		return this.queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(User.class), username, partner);
	}
	
	public int findUserIdByUsername(String username, int partner) {
		String member = partner + "_" + username;
		int userId = (int)zscore(USER_ID, member);
		if(userId == 0){
			User user = findUserByUsername(username, partner);
			if(user != null){
				userId = user.getUserId();
				zadd(USER_ID, userId, member);
			}
		}
		return userId;
	}

	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="findUserByUserId", dbbean=User.class, wheres={UserTable.USERID}, limit={"1"})})
	public User findUserByUserId(int userId) {
		String sql = DBBeanRowMapperManager.getDynamicSql(User.class, "findUserByUserId");
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(User.class), userId);
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="findUserByPlayerName", dbbean=User.class, wheres={UserTable.PLAYERNAME}, limit={"1"})})
	public User findUserByPlayerName(String playerName){
		String sql = DBBeanRowMapperManager.getDynamicSql(User.class, "findUserByPlayerName");
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(User.class), playerName);
	}
	
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addUser", dbbean=User.class)})
	public void addUser(User user) {
		String sql = DBBeanRowMapperManager.getDynamicSql(User.class, "addUser");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(User.class, "addUser", user);
		int userId = insertAndReturnId(sql, INT_KEY, params.toArray());
		user.setUserId(userId);
	}

	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateUser", dbbean=User.class, wheres={UserTable.USERID})})
	public void updateUser(User user) {
		user.setUpdateTime(new Date());
		String sql = DBBeanRowMapperManager.getDynamicSql(User.class, "updateUser");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(User.class, "updateUser", user);
		saveOrUpdate(sql, params.toArray());
	}

	public void addUserCache(User user) {
		hmset(USER_CACHE + user.getUserId(), JedisBeanManager.getObjMapper(User.class).objectToMap(user));
		lpush(USER_REPAIR, String.valueOf(user.getUserId()));  
	}

	public User getUserFromCache(int userId) {
		return hgetAll(USER_CACHE + userId, JedisBeanManager.getRowMapper(User.class));
	}

	public void delUserCache(int userId) {
		this.del(USER_CACHE + userId);
		lrem(USER_REPAIR, 1, String.valueOf(userId));  
	}
	
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="clearUserFightId", dbbean=User.class, wheres={UserTable.USERID})})
	public void clearUserFightId(int userId){
		String key = USER_CACHE + userId;
		
		if(getUserFromCache(userId)!=null){
			Map<String, String> hash = new HashMap<String, String>();
			hash.put(UserTable.J_FIGHTID, "");
			hash.put(UserTable.J_UPDATETIME, String.valueOf(new Date().getTime()));
			this.hmset(key, hash, true);
		}else{
			String sql = DBBeanRowMapperManager.getDynamicSql(User.class, "clearUserFightId");
			saveOrUpdate(sql,"", userId);
		}
	}
	
	public void updateUserCache(int userId, Map<String, String> hash) {
		String key = USER_CACHE + userId;
		hash.put(UserTable.J_UPDATETIME, String.valueOf(new Date().getTime()));
		this.hmset(key, hash, true);
	}
	
	public UserBaseinfo getUserBaseinfo(int userId){
		return hgetAll(USER_BASE_INFO_CACHE+userId, JedisBeanManager.getRowMapper(UserBaseinfo.class));
	}
	
	public void updateUserBaseinfo(UserBaseinfo info){
		hmset(USER_BASE_INFO_CACHE + info.getUserId(), JedisBeanManager.getObjMapper(UserBaseinfo.class).objectToMap(info));
	}
	
	public List<UserBaseinfo> getUserBaseinfos(Collection<Integer> userIds){
		List<String> keys = new ArrayList<String>();
		for(int userId : userIds){
			keys.add(USER_BASE_INFO_CACHE+userId);
		}
		return hgetAll(JedisBeanManager.getRowMapper(UserBaseinfo.class), keys);
	}
	
	public void updateUserLevel(int userLevel,int userId){
		zadd(USER_LEVEL_KEY, userLevel, String.valueOf(userId));
	}
	
	public List<Integer> gainUserLevel(int userLevel,int c){
		int count = (int) zcount(USER_LEVEL_KEY, userLevel-5, userLevel+5);
		if(count == 0){
			return new ArrayList<Integer>();
		}
		int offset = (int) (Math.random()*count-5);
		offset=offset<0?0:offset;
		Set<String> set = zrangeByScore(USER_LEVEL_KEY, userLevel-5, userLevel+5, offset, c);
		List<Integer> userIds = new ArrayList<Integer>();
		for(String s : set){
			userIds.add(Integer.parseInt(s));
		}
		return userIds;
	}
	
	/**
	 * 更新玩家名
	 * @param userId
	 * @param playerName
	 */
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updatePlayerName", dbbean=User.class, fields={UserTable.PLAYERNAME}, wheres={UserTable.USERID})})
	public void updatePlayerName(int userId, String playerName) {
		String sql = DBBeanRowMapperManager.getDynamicSql(User.class, "updatePlayerName");
		saveOrUpdate(sql, playerName, userId);
	}
	
	/**
	 * 获取玩家领取记录
	 */
	@DBBeanSetSqlSetList(
			selects={@DBBeanSetSelectSqlSet(name="getUserRecord", dbbean=UserRecord.class, wheres={UserRecordTable.ID})},
			inserts={@DBBeanSetInsertSqlSet(name="addUserRecord", dbbean=UserRecord.class)})
	public UserRecord getUserRecord(int userId){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserRecord.class, "getUserRecord");
		UserRecord record = queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(UserRecord.class), userId);
		if(record == null){
			record = new UserRecord();
			record.setId(userId);
			sql = DBBeanRowMapperManager.getDynamicSql(UserRecord.class, "addUserRecord");
			List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserRecord.class, "addUserRecord", record);
			saveOrUpdate(sql, params.toArray());
		}
		return record;
	}
//	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateUserRecord", dbbean=UserRecord.class, fields={UserRecordTable.SYSMAILIDS}, wheres={UserRecordTable.ID})})
//	public void updateUserRecord(UserRecord record){
//		String sql = DBBeanRowMapperManager.getDynamicSql(UserRecord.class, "updateUserRecord");
//		saveOrUpdate(sql, record.getSysMailIds(), record.getId());
//	}
	
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateUserRecord", dbbean=UserRecord.class, auto_fields=true, wheres={UserRecordTable.ID})})
	public void updateUserRecord(UserRecord record, SQLOpt opt){
		DBBeanSqlSet set = DBBeanRowMapperManager.getDynamicUpdateDBBeanSqlSet(UserRecord.class, "updateUserRecord", record, opt);
		saveOrUpdate(set.getSql(), set.getParams().toArray());
	}
	
	/**
	 * 查询最大玩家id
	 */
	public static final String QUERY_MAX_USER_ID = "select max(user_id) from t_user";
	public int queryUserByMaxId(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(QUERY_MAX_USER_ID);
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		}catch(SQLException e){
			throw new GameDaoException("update data error",e);
		}finally{
			releaseResources(ps, rs);
		}
		return 0;
	}
	

	/**
	 * 存储用户当前总战斗力
	 * @param fighting
	 * @param userId
	 */
	public void updateFighting(int fighting,int userId){
		zadd(USER_FIGHTING, fighting, String.valueOf(userId));
	}
	/**
	 * 获取用户战力
	 * @param userId
	 * @return
	 */
	public int getFighting(int userId){
		int fighting = 0;
		try{
			fighting=(int)zscore(USER_FIGHTING, String.valueOf(userId));
		}catch(Exception e){
			fighting = 0;
		}
		return fighting;
	}
	/**
	 * 加载战力
	 * @return
	 */
	String SQL_LOADDBFIGHTINGS = "select * from " + UserTable.TABLE_NAME + " where " + UserTable.FIGHTING + " > 0";
	public List<User> loadDBFightings(int start, int end){
		String sql = SQL_LOADDBFIGHTINGS  + " and " + UserTable.LEVEL + " >= " + SystemConstant.ARENA_OPEN_LEVEL;
		if(start >= 0){
			sql = sql + " limit " + start;
		}
		if(end != 0){
			sql = sql + "," + end;
		}
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(User.class));
	}
	
	/**
	 * 加载等级
	 * @param start
	 * @param end
	 * @return
	 */
	String SQL_LOADDBLEVELS = "select * from " + UserTable.TABLE_NAME;
	public List<User> loadDBLevels(int start, int end){
		String sql = SQL_LOADDBLEVELS;
		if(start >= 0){
			sql = sql + " limit " + start;
		}
		if(end != 0){
			sql = sql + "," + end;
		}
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(User.class));
	}
	
	/**
	 * 查询推荐ids
	 * @param ids 过滤ids
	 * @param level 玩家等级
	 * @param limit 查询数量
	 * @return
	 */
	public List<Integer> queryRecoIds(List<Integer> ids, int level, int limit){
		List<Integer> list = new ArrayList<>();
		String notIn = "";
		if(!ids.isEmpty()){
			notIn += " and user_id not in(";
			for(Integer id : ids){
				notIn += id + ",";
			}
			notIn = notIn.substring(0, notIn.length() - 1) + ")";
		}
		int minLevel = SystemConstant.FRIEND_OPEN_LEVEL;
		int count = level - minLevel;
		if(count > 0){
			if(count > 10){
				minLevel = level - 10;
			}else{
				minLevel = level - count;
			}
		}
		int maxLevel = level + 10;
		String sql = "select * from t_user where level >= " + minLevel + " and level <= " + maxLevel + notIn + " order by RAND() limit " + limit;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(rs.getInt(1));
			}
		}catch(SQLException e){
			throw new GameDaoException("query data error",e);
		}finally{
			releaseResources(ps, rs);
		}
		return list;
	}
	
	public List<Integer> queryRepairIds(){
		List<Integer> ids = new ArrayList<>();
		List<String> list = lrange(USER_REPAIR);
		if(list != null && !list.isEmpty()){
			for(String str : list){
				try{
					ids.add(new Integer(str));
				}catch(Exception e){}
			}
		}
		return ids;
	}
	
}
