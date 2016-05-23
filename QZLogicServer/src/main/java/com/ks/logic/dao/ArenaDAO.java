package com.ks.logic.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
import com.ks.access.SQLOpt;
import com.ks.constant.SystemConstant;
import com.ks.db.model.Arena;
import com.ks.db.model.ArenaLogger;
import com.ks.db.model.ArenaShopping;
import com.ks.db.model.User;
import com.ks.table.ArenaLoggerTable;
import com.ks.table.ArenaTable;
import com.ks.util.JSONUtil;

public class ArenaDAO extends GameDAOTemplate {
	
	/**今天胜场*/
	public static final String USER_TODAY_WINS = "USER_TODAY_WINS";
	/**今天最高连胜场*/
	public static final String USER_TODAY_MAX_WINS = "USER_TODAY_MAX_WINS";
	/**竞技场记录*/
	private static final String ARENA_LOGGER_ = "ARENA_LOGGER_";
	private static final String LOAD = "LOAD";
	
	private static final String getTableName(int userId){
		return "t_arena_logger_"+(userId%10);
	}
	
	public static final String getArenaLoggerSetKey(int userId, int type){
		return ARENA_LOGGER_ + type + "_" + userId;
	}
	
	public static final String getArenaLoggerSetKey(int loggerId){
		return String.valueOf(loggerId);
	}
	
	public void deleteArenaLogger(int userId,int type){
		String sql="delete from "+getTableName(userId)+" where " + ArenaLoggerTable.ID + " in (select t." + ArenaLoggerTable.ID + " from (select * from "+ getTableName(userId)+" where " + ArenaLoggerTable.USERID + "=? and " + ArenaLoggerTable.TYPE + "=? order by " + ArenaLoggerTable.ID +" desc limit 50, 30) as t)";
		saveOrUpdate(sql,userId,type);
	}
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryArenaLogger", dbbean=ArenaLogger.class, wheres={ArenaLoggerTable.USERID, ArenaLoggerTable.TYPE}, limit={"30"})})
	public List<ArenaLogger> queryArenaLogger(int userId,int type){
		String sql = DBBeanRowMapperManager.getDynamicSql(ArenaLogger.class, "queryArenaLogger", getTableName(userId));
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(ArenaLogger.class), userId,type);
	}
	
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addArenaLogger", dbbean=ArenaLogger.class)})
	public void addArenaLogger(ArenaLogger al){
		String sql = DBBeanRowMapperManager.getDynamicSql(ArenaLogger.class, "addArenaLogger", getTableName(al.getUserId()));
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(ArenaLogger.class, "addArenaLogger", al);
//		saveOrUpdate(sql, params.toArray());
		int id = insertAndReturnId(sql, INT_KEY, params.toArray());
		al.setId(id);
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryLockArena", dbbean=Arena.class, wheres={ArenaTable.USERID}, forupdate=true)})
	public Arena queryLockArena(int userId){
		String sql = DBBeanRowMapperManager.getDynamicSql(Arena.class, "queryLockArena", getTableName(userId));
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(Arena.class), userId);
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryMyArena", dbbean=Arena.class, wheres={ArenaTable.USERID})})
	public Arena queryMyArena(int userId){
		String sql = DBBeanRowMapperManager.getDynamicSql(Arena.class, "queryMyArena", getTableName(userId));
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(Arena.class), userId);
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryRankArena", dbbean=Arena.class)})
	public List<Arena> queryRankArena(){
		String sql = DBBeanRowMapperManager.getDynamicSql(Arena.class, "queryRankArena");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(Arena.class));
	}
	String QUERYARENARANKTOP50_SQL = "select * from " + ArenaTable.TABLE_NAME + " where " + ArenaTable.WINCOUNT + "!=0  order by " + ArenaTable.WINCOUNT + " asc limit 50";
	public List<Arena> queryArenaRankTop50(){ 
		return  queryForList(QUERYARENARANKTOP50_SQL, DBBeanRowMapperManager.getRowMapper(Arena.class));
	}
	String QUERYARENAMAXWINCOUNTTOP50_SQL = "select * from " + ArenaTable.TABLE_NAME + " where " + ArenaTable.MAXWINSTREAK + "!=0 order by " + ArenaTable.MAXWINSTREAK + " asc limit 50";
	public List<Arena> queryArenaMaxWinCountTop50(){
		return queryForList(QUERYARENAMAXWINCOUNTTOP50_SQL, DBBeanRowMapperManager.getRowMapper(Arena.class));
	}
	
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateArena", dbbean=Arena.class, auto_fields=true, wheres={ArenaTable.USERID})})
	public void updateArena(Arena arena,SQLOpt opt){
		arena.setUpdateTime(new Date());
		opt.putFieldOpt(ArenaTable.UPDATETIME, SQLOpt.EQUAL);
		DBBeanSqlSet set = DBBeanRowMapperManager.getDynamicUpdateDBBeanSqlSet(Arena.class, "updateArena", arena, opt);
		saveOrUpdate(set.getSql(), set.getParams().toArray());
	}
	
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addArena", dbbean=Arena.class)})
	public void addArena(Arena arena){
		String sql = DBBeanRowMapperManager.getDynamicSql(Arena.class, "addArena");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(Arena.class, "addArena", arena);
		saveOrUpdate(sql, params.toArray());
	}
	
	String CLEARARENA_SQL = "update " + ArenaTable.TABLE_NAME + " set " + ArenaTable.WINCOUNT + "=0," + ArenaTable.STREAKWIN + "=0," + ArenaTable.MAXWINSTREAK + "=0;";
	public void clearArena(){
		saveOrUpdate(CLEARARENA_SQL);
	}
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="refArenaShopping", dbbean=Arena.class, fields={ArenaTable.SHOPPING}, wheres={ArenaTable.USERID})})
	public void refArenaShopping(List<ArenaShopping> list,int userId){
		String sql = DBBeanRowMapperManager.getDynamicSql(Arena.class, "refArenaShopping");
		saveOrUpdate(sql,JSONUtil.toJson(list),userId);
	}
	/**
	 * 存储用户今天总胜利场次
	 * @param todayWins
	 * @param userId
	 */
	public void updateTodayWins(int todayWins,int userId){
		zadd(USER_TODAY_WINS, todayWins, String.valueOf(userId));
	}
	/**
	 * 存储今天用户最高连胜场次
	 * @param todayMaxWins
	 * @param userId
	 */
	public void updateTodayMaxWins(int todayMaxWins,int userId){
		zadd(USER_TODAY_MAX_WINS, todayMaxWins, String.valueOf(userId));	
	}
	
	public List<Integer> getMatchUserIds(User user){
		int[] condition=Arena.getCondition(user.getLevel());
		int fighting=(int)zscore(UserDAO.USER_FIGHTING, String.valueOf(user.getUserId()));
		int minFighting=fighting-condition[0];
		int maxFighting= fighting+condition[0];
		int count = (int) zcount(UserDAO.USER_FIGHTING, minFighting, maxFighting);
		Set<String> newSet=new HashSet<>();
		if(count>=4){
			 int random=(int)(Math.random()*(count-4));
		     if(random<0){
		    	 random=0; 
		     }
			newSet.addAll(zrangeByScore(UserDAO.USER_FIGHTING, minFighting, maxFighting, random, 4));
			Iterator<String> it=newSet.iterator();
			while (it.hasNext()) {
				if(Integer.parseInt(it.next())==user.getUserId()){
					it.remove();
					break;
				}
			}
			if(newSet.size() >=4){
				it = newSet.iterator();
				int r = (int) (Math.random()*newSet.size());
				int i = 0;
				while(it.hasNext()){
					it.next();
					if(i == r){
						it.remove();
						break;
					}
					i++;
				}
			}
		}
		if(count <4 && count>0){
			 minFighting=fighting-condition[1];
		     maxFighting=fighting+condition[1];
		     count = (int) zcount(UserDAO.USER_FIGHTING, minFighting, maxFighting);
		     int random=(int)(Math.random()*(count-4));
		     if(random<0){
		    	 random=0; 
		     }
		     if(random<=newSet.size()){
		    	 random=random+newSet.size();
		     }
		     if(random<=newSet.size()){
		    	 random=1+newSet.size();
		     }
	    	 newSet.addAll(zrangeByScore(UserDAO.USER_FIGHTING, minFighting, maxFighting, 0,4)); 
			Iterator<String> it=newSet.iterator();
			while (it.hasNext()) {
				if(Integer.parseInt(it.next())==user.getUserId()){
					it.remove();
					break;
				}
			}
			if(newSet.size() >=4){
				it = newSet.iterator();
				int r = (int) (Math.random()*newSet.size());
				int i = 0;
				while(it.hasNext()){
					it.next();
					if(i == r){
						it.remove();
						break;
					}
					i++;
				}
			}
		}
		if(newSet.size()<3){
			 minFighting=fighting-condition[2];
		     maxFighting=fighting+condition[2];
		     count = (int) zcount(UserDAO.USER_FIGHTING, minFighting, maxFighting);
		     int random=(int)(Math.random()*(count-4));
		     if(random<0){
		    	 random=0; 
		     }
		     if(random<=newSet.size()){
		    	 random=random+newSet.size();
		     }
		     if(random<=newSet.size()){
		    	 random=1+newSet.size();
		     }
		     if(count>4){
		    	 newSet.addAll(zrangeByScore(UserDAO.USER_FIGHTING, minFighting, maxFighting, random,4-newSet.size()));
		     }else{
		    	 newSet.addAll(zrangeByScore(UserDAO.USER_FIGHTING, minFighting, maxFighting, 0,4)); 
		     }
				Iterator<String> it=newSet.iterator();
				while (it.hasNext()) {
					if(Integer.parseInt(it.next())==user.getUserId()){
						it.remove();
						break;
					}
				}
				if(newSet.size() >=4){
					it = newSet.iterator();
					int r = (int) (Math.random()*newSet.size());
					int i = 0;
					while(it.hasNext()){
						it.next();
						if(i == r){
							it.remove();
							break;
						}
						i++;
					}
				}
		}
		if(newSet.size() <3){
			 minFighting=0;
		     maxFighting=1000000;
		     count = (int) zcount(UserDAO.USER_FIGHTING, minFighting, maxFighting);
		     int random=(int)(Math.random()*(count-4));
		     if(random<0){
		    	 random=0; 
		     }
		     if(random<=newSet.size()){
		    	 random=random+newSet.size();
		     }
		     if(random<=newSet.size()){
		    	 random=1+newSet.size();
		     }
		     if(count>4){
		    	 newSet.addAll(zrangeByScore(UserDAO.USER_FIGHTING, minFighting, maxFighting, random,4-newSet.size()));
		     }else{
		    	 newSet.addAll(zrangeByScore(UserDAO.USER_FIGHTING, minFighting, maxFighting, 0,4)); 
		     }
				Iterator<String> it=newSet.iterator();
				while (it.hasNext()) {
					if(Integer.parseInt(it.next())==user.getUserId()){
						it.remove();
					}
				}
				if(newSet.size() >=4){
					it = newSet.iterator();
					int r = (int) (Math.random()*newSet.size());
					int i = 0;
					while(it.hasNext()){
						it.next();
						if(i == r){
							it.remove();
							break;
						}
						i++;
					}
				}
		}
		List<Integer> userIds = new ArrayList<Integer>();
		if(!newSet.isEmpty()){
			for(String s : newSet){
				userIds.add(Integer.parseInt(s));
			}	
		}
		return userIds;
	}
	public List<Integer> getArenaTodayWinsRankTop50(){
		List<Integer> userIds = new ArrayList<Integer>();
		Set<String> set = zrevrange(USER_TODAY_WINS,0,50);
		if(!set.isEmpty()){
			for(String s : set){
				userIds.add(Integer.parseInt(s));
			}	
		}
		return userIds;	
	}
	public List<Integer> getArenaTodayMaxWinsRankTop50(){
		List<Integer> userIds = new ArrayList<Integer>();
		Set<String> set = zrevrange(USER_TODAY_MAX_WINS,0,50);
		if(!set.isEmpty()){
			for(String s : set){
				userIds.add(Integer.parseInt(s));
			}	
		}
		return userIds;	
	}
	
	/**
	 * 定时清理排行榜
	 */
    public void delArenaRank(){
    	del(USER_TODAY_WINS,USER_TODAY_MAX_WINS);
    }
    
    /****************************************************arena_logger cache**********************************************************/
    public static class ArenaLoggerListMapper{
		public static List<ArenaLogger> rowMapper(Map<String, String> map) {
			List<ArenaLogger> result = new ArrayList<ArenaLogger>();
			for(String str : map.values()){
				if(!LOAD.equals(str)){
					ArenaLogger bean = JSONUtil.toObject(str, ArenaLogger.class);
					result.add(bean);
				}
			}
			return result;
		}
	}
	
	public static class ArenaLoggerObjMapper{
		public static Map<String, String> objMapper(List<ArenaLogger> list) {
			Map<String, String> result = new HashMap<String, String>();
			for(ArenaLogger al : list){
				result.put(String.valueOf(al.getId()), JSONUtil.toJson(al).toString());
			}
			return result;
		}
	}
	/**
	 * 是否已经加载了缓存记录
	 * @param userId
	 * @return
	 */
	public boolean hasArenaLoggersCache(int userId, int type){
		String setKey = getArenaLoggerSetKey(userId, type);
		if(LOAD.equals(hget(setKey, LOAD))){
			return true;
		}
		return false;
	}
	/**
	 * 查询缓存记录
	 */
	public List<ArenaLogger> queryArenaLoggersCache(int userId, int type){
		if(hasArenaLoggersCache(userId, type)){
			String setKey = getArenaLoggerSetKey(userId, type);
			Map<String, String> map = hgetAll(setKey);
			expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
			List<ArenaLogger> list = ArenaLoggerListMapper.rowMapper(map);
			while(list.size() > 50){
				int did = Integer.MAX_VALUE;
				int index = 0;
				int size = list.size();
				for(int i = 0; i < size; i++){
					ArenaLogger al = list.get(i);
					if(al.getId() < did){
						did = al.getId();
						index = i;
					}
				}
				list.remove(index);
				hdel(setKey, String.valueOf(did));
			}
			return list;
		}
		return null;
	}
	
	/**
	 * 添加缓存记录
	 */
	public void addArenaLoggerCache(ArenaLogger al){
		String setKey = getArenaLoggerSetKey(al.getUserId(), al.getType());
		hset(setKey, String.valueOf(al.getId()), JSONUtil.toJson(al).toString());
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}

	/**
	 * 添加记录到缓存
	 */
	public void setArenaLoggersCache(int userId, int type, List<ArenaLogger> list){
		setCacheSign();
		try{
			String setKey = getArenaLoggerSetKey(userId, type);
			del(setKey);
			if(!list.isEmpty()){
				hmset(setKey, ArenaLoggerObjMapper.objMapper(list));
			}
			hset(setKey, LOAD, LOAD);
			expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
		}finally{
			clearCacheSign();
		}
	}
	
	/**
	 * 清理好友缓存
	 */
	public void clearArenaLoggersCache(int userId){
		for(int type : SystemConstant.ARENA_LOGGER_TYPES){
			del(getArenaLoggerSetKey(userId, type));
		}
	}
}
