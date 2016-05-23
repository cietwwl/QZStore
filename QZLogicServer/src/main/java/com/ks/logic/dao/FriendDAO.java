package com.ks.logic.dao;

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
import com.ks.cache.JedisBeanManager;
import com.ks.cache.JedisNoLoadException;
import com.ks.constant.SystemConstant;
import com.ks.db.model.Friend;
import com.ks.db.model.FriendApply;
import com.ks.db.model.FriendReco;
import com.ks.table.FriendApplyTable;
import com.ks.table.FriendRecoTable;
import com.ks.table.FriendTable;
import com.ks.util.JSONUtil;

public class FriendDAO extends GameDAOTemplate {
	
	private static final String FRIEND_KEY = "FRIEND_";
	private static final String FRIEND_APPLY_KEY = "FRIEND_APPLY_";
	private static final String FRIEND_RECO = "FRIEND_RECO_";
	private static final String LOAD = "LOAD";
	
	private static final String getTableName(int userId){
		return "t_friend_"+(userId%10);
	}
	
	private static final String getFriendSetKey(int userId){
		return FRIEND_KEY+userId;
	}
	
	private static final String getFriendApplySetKey(int userId){
		return FRIEND_APPLY_KEY + userId;
	}
	
	private static final String getFriendRecoKey(int userId){
		return FRIEND_RECO + userId;
	}
	
	public int queryFriendCount(int userId){
		String sql = "select count(1) from "+getTableName(userId)+" where " + FriendTable.USERID + "=?";
		return queryForEntity(sql, INT_ROW_MAPPER, userId);
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryFriends", dbbean=Friend.class, wheres={FriendTable.USERID})})
	public List<Friend> queryFriends(int userId){
		String sql = DBBeanRowMapperManager.getDynamicSql(Friend.class, "queryFriends", getTableName(userId));
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(Friend.class), userId);
	}
	
	
//	public void updateFriendState(int friendId,int userId,int num){
//		String sql = "update "+getTableName(userId)+" set " + FriendTable.STATE + "=" + FriendTable.STATE + "+?," + FriendTable.UPDATETIME + "=now() where " + FriendTable.USERID + "=? and "+ FriendTable.FRIENDID + "=?";
//		saveOrUpdate(sql, num,userId,friendId);
//	}
	
//	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryFriend", dbbean=Friend.class, wheres={FriendTable.USERID, FriendTable.FRIENDID})})
//	public Friend queryFriend(int userId,int friendId){
//		String sql = DBBeanRowMapperManager.getDynamicSql(Friend.class, "queryFriend", getTableName(userId));
//		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(Friend.class), userId,friendId);
//	}
	
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateFriend", dbbean=Friend.class, wheres={FriendTable.USERID, FriendTable.FRIENDID})})
	public void updateFriend(Friend friend){
		friend.setUpdateTime(new Date());
		String sql = DBBeanRowMapperManager.getDynamicSql(Friend.class, "updateFriend", getTableName(friend.getUserId()));
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(Friend.class, "updateFriend", friend);
		saveOrUpdate(sql, params.toArray());
	}
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addFriend", dbbean=Friend.class)})
	public void addFriend(Friend friend){
		String sql = DBBeanRowMapperManager.getDynamicSql(Friend.class, "addFriend", getTableName(friend.getUserId()));
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(Friend.class, "addFriend", friend);
		saveOrUpdate(sql, params.toArray());
	}
	
	@DBBeanSetSqlSetList(deletes={@DBBeanSetDeleteSqlSet(name="deleteFriend", dbbean=Friend.class, wheres={FriendTable.USERID, FriendTable.FRIENDID})})
	public void deleteFriend(int userId,int friendId){
		String sql = DBBeanRowMapperManager.getDynamicSql(Friend.class, "deleteFriend", getTableName(userId));
		saveOrUpdate(sql, userId,friendId);
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryFriendApplys", dbbean=FriendApply.class, wheres={FriendApplyTable.USERID})})
	public List<FriendApply> queryFriendApplys(int userId){
		String sql = DBBeanRowMapperManager.getDynamicSql(FriendApply.class, "queryFriendApplys");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(FriendApply.class), userId);
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryFriendApply", dbbean=FriendApply.class, wheres={FriendApplyTable.USERID, FriendApplyTable.APPLYUSERID})})
	public FriendApply queryFriendApply(int userId,int applyUserId){
		String sql = DBBeanRowMapperManager.getDynamicSql(FriendApply.class, "queryFriendApply");
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(FriendApply.class), userId,applyUserId);
	}
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addFriendApply", dbbean=FriendApply.class)})
	public void addFriendApply(FriendApply apply){
		String sql = DBBeanRowMapperManager.getDynamicSql(FriendApply.class, "addFriendApply");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(FriendApply.class, "addFriendApply", apply);
		saveOrUpdate(sql, params.toArray());
	}
	
	@DBBeanSetSqlSetList(deletes={@DBBeanSetDeleteSqlSet(name="deleteFriendApply", dbbean=FriendApply.class, wheres={FriendApplyTable.USERID, FriendApplyTable.APPLYUSERID})})
	public void deleteFriendApply(int userId,int applyUserId){
		String sql = DBBeanRowMapperManager.getDynamicSql(FriendApply.class, "deleteFriendApply");
		saveOrUpdate(sql, userId,applyUserId);
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryFriendReco", dbbean=FriendReco.class, wheres={FriendRecoTable.USERID})})
	public FriendReco queryFriendReco(int userId){
		String sql = DBBeanRowMapperManager.getDynamicSql(FriendReco.class, "queryFriendReco");
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(FriendReco.class), userId);
	}
	
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addFriendReco", dbbean=FriendReco.class)})
	public void addFriendReco(FriendReco fr){
		String sql = DBBeanRowMapperManager.getDynamicSql(FriendReco.class, "addFriendReco");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(FriendReco.class, "addFriendReco", fr);
		saveOrUpdate(sql, params.toArray());
	}
	
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateFriendReco", dbbean=FriendReco.class, wheres={FriendRecoTable.USERID})})
	public void updateFriendReco(FriendReco fr){
		String sql = DBBeanRowMapperManager.getDynamicSql(FriendReco.class, "updateFriendReco");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(FriendReco.class, "updateFriendReco", fr);
		saveOrUpdate(sql, params.toArray());
	}
	/*******************************************************friend cache********************************************************************/
	public static class FriendMapMapper{
		public static Map<Integer, Friend> rowMapper(Map<String, String> map) {
			Map<Integer, Friend> result = new HashMap<Integer, Friend>();
			for(Map.Entry<String, String> entry : map.entrySet()){
				if(!entry.getKey().equals(LOAD)){
					Friend bean = JSONUtil.toObject(entry.getValue(), Friend.class);
					result.put(bean.getFriendId(), bean);
				}
			}
			return result;
		}
	}
	
	public static class FriendObjMapper{
		public static Map<String, String> objMapper(Map<Integer, Friend> map) {
			Map<String, String> result = new HashMap<String, String>();
			for(Map.Entry<Integer, Friend> entry : map.entrySet()){
				result.put(entry.getKey().toString(), JSONUtil.toJson(entry.getValue()));
			}
			return result;
		}
	}
	/**
	 * 查询缓存好友
	 */
	public Map<Integer, Friend> queryFriendsCache(int userId){
		String setKey = getFriendSetKey(userId);
		Map<String, String> map = hgetAll(setKey);
		if(isLoad(map)){
			expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
			return FriendMapMapper.rowMapper(map);
		}
		return null;
	}
	/**
	 * 查询缓存好友
	 */
	public Friend queryFriendCache(int userId, int friendId) throws JedisNoLoadException{
		String setKey = getFriendSetKey(userId);
		String str = hget(setKey, String.valueOf(friendId));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
		if(str != null){
			return JSONUtil.toObject(str, Friend.class);
		}else if(!isLoad(setKey)){
			throw new JedisNoLoadException();
		}
		return null;
	}
	
	/**
	 * 添加缓存好友
	 */
	public void addFriendCache(Friend friend){
		String setKey = getFriendSetKey(friend.getUserId());
		hset(setKey, String.valueOf(friend.getFriendId()), JSONUtil.toJson(friend));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}

	/**
	 * 添加好友到缓存
	 */
	public void setFriendsCache(int userId, Map<Integer, Friend> friendmap){
		setCacheSign();
		try{
			String setKey = getFriendSetKey(userId);
			del(setKey);
			if(!friendmap.isEmpty()){
				hmset(setKey, FriendObjMapper.objMapper(friendmap));
			}
			hset(setKey, LOAD, LOAD);
			expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
		}finally{
			clearCacheSign();
		}
	}
	
	/**
	 * 更新好友缓存
	 */
	public void updateFriendCache(Friend friend){
		String setKey = getFriendSetKey(friend.getUserId());
		hset(setKey, String.valueOf(friend.getFriendId()), JSONUtil.toJson(friend));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}

	/**
	 * 删除好友缓存
	 * @param userId
	 * @param friendId
	 */
	public void delFriendCache(int userId, int friendId){
		String setKey = getFriendSetKey(userId);
		hdel(setKey, String.valueOf(friendId));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}
	
	/**
	 * 清理好友缓存
	 */
	public void clearFriendsCache(int userId){
		del(getFriendSetKey(userId));
	}
	
	/*******************************************************friend apply cache********************************************************************/
	public static class FriendApplyMapMapper{
		public static Map<Integer, FriendApply> rowMapper(Map<String, String> map) {
			Map<Integer, FriendApply> result = new HashMap<Integer, FriendApply>();
			for(Map.Entry<String, String> entry : map.entrySet()){
				if(!entry.getKey().equals(LOAD)){
					FriendApply bean = JSONUtil.toObject(entry.getValue(), FriendApply.class);
					result.put(bean.getApplyUserId(), bean);
				}
			}
			return result;
		}
	}
	
	public static class FriendApplyObjMapper{
		public static Map<String, String> objMapper(Map<Integer, FriendApply> map) {
			Map<String, String> result = new HashMap<String, String>();
			for(Map.Entry<Integer, FriendApply> entry : map.entrySet()){
				result.put(entry.getKey().toString(), JSONUtil.toJson(entry.getValue()));
			}
			return result;
		}
	}
	/**
	 * 查询缓存好友申请
	 */
	public Map<Integer, FriendApply> queryFriendApplysCache(int userId){
		String setKey = getFriendApplySetKey(userId);
		Map<String, String> map = hgetAll(setKey);
		if(isLoad(map)){
			expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
			return FriendApplyMapMapper.rowMapper(map);
		}
		return null;
	}
	/**
	 * 查询缓存好友申请
	 */
	public FriendApply queryFriendApplyCache(int userId, int applyUserId) throws JedisNoLoadException{
		String setKey = getFriendApplySetKey(userId);
		String str = hget(setKey, String.valueOf(applyUserId));
		if(str != null){
			expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
			return JSONUtil.toObject(str, FriendApply.class);
		}else if(!isLoad(setKey)){
			throw new JedisNoLoadException();
		}
		return null;
	}
	
	/**
	 * 添加缓存好友申请
	 */
	public void addFriendApplyCache(FriendApply apply){
		String setKey = getFriendApplySetKey(apply.getUserId());
		hset(setKey, String.valueOf(apply.getApplyUserId()), JSONUtil.toJson(apply));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}

	/**
	 * 添加好友申请到缓存
	 */
	public void setFriendApplysCache(int userId, Map<Integer, FriendApply> applymap){
		setCacheSign();
		try{
			String setKey = getFriendApplySetKey(userId);
			del(setKey);
			if(!applymap.isEmpty()){
				hmset(setKey, FriendApplyObjMapper.objMapper(applymap));
			}
			hset(setKey, LOAD, LOAD);
			expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
		}finally{
			clearCacheSign();
		}
	}
	
	/**
	 * 删除好友申请
	 * @param userId
	 * @param friendId
	 */
	public void delFriendApplyCache(int userId, int applyUserId){
		String setKey = getFriendApplySetKey(userId);
		hdel(setKey, String.valueOf(applyUserId));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}
	
	/**
	 * 清理好友缓存
	 */
	public void clearFriendApplysCache(int userId){
		del(getFriendApplySetKey(userId));
	}
	
	/*******************************************************friend reco cache********************************************************************/
	/**
	 * 查询缓存好友推荐
	 */
	public FriendReco queryFriendRecoCache(int userId){
		String key = getFriendRecoKey(userId);
		expire(key, SystemConstant.CACHE_EXPIRE_TIME);
		return hgetAll(key, JedisBeanManager.getRowMapper(FriendReco.class));
	}

	/**
	 * 添加好友申请到缓存
	 */
	public void setFriendRecoCache(FriendReco reco, boolean cache){
		if(reco != null){
			if(cache){
				setCacheSign();
			}
			try{
				String key = getFriendRecoKey(reco.getUserId());
				del(key);
				hmset(key, JedisBeanManager.getObjMapper(FriendReco.class).objectToMap(reco));
				expire(key, SystemConstant.CACHE_EXPIRE_TIME);
			}finally{
				if(cache){
					clearCacheSign();
				}
			}
		}
	}
	/**
	 * 更新好友缓存
	 */
	public void updateFriendCache(FriendReco reco){
		String key = getFriendRecoKey(reco.getUserId());
		hmset(key, JedisBeanManager.getObjMapper(FriendReco.class).objectToMap(reco));
		expire(key, SystemConstant.CACHE_EXPIRE_TIME);
	}
	/**
	 * 清理好友缓存
	 */
	public void clearFriendRecoCache(int userId){
		del(getFriendRecoKey(userId));
	}
}
