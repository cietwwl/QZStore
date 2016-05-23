package com.ks.logic.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.ks.access.GameDAOTemplate;
import com.ks.cache.JedisBeanManager;
import com.ks.model.martial.MartialWay;
/**
 * 武道大会dao
 * @author hanjie.l
 *
 */
public class MartialWayDAO extends GameDAOTemplate {
	
	
	private static final String MARTIAL_WAY_KEY = "MARTIAL_WAY_";
	private static final String MARTIAL_WAY_SET_KEY = "MARTIAL_WAY_SET";
	private static final String MARTIAL_WAY_RANK_KEY = "MARTIAL_WAY_RANK";
	
	private static final String getMartialWayKey(int userId){
		return MARTIAL_WAY_KEY+userId;
	}
	
	public MartialWay getMartialWay(int userId){
		return hgetAll(getMartialWayKey(userId), JedisBeanManager.getRowMapper(MartialWay.class));
	}
	
	public void addMartialWay(MartialWay way){
		sadd(MARTIAL_WAY_SET_KEY, getMartialWayKey(way.getUserId()));
		updateMartialWay(way);
	}
	public void updateMartialWay(MartialWay way){
		hmset(getMartialWayKey(way.getUserId()), JedisBeanManager.getObjMapper(MartialWay.class).objectToMap(way));
	}
	
	public void updateMartialWayRank(int userId,int score){
		zadd(MARTIAL_WAY_RANK_KEY, score, String.valueOf(userId));
	}
	public List<MartialWay> gainMartialWays(Collection<Integer> userIds){
		List<String> keys = new ArrayList<String>();
		for(int s : userIds){
			keys.add(getMartialWayKey(s));
		}
		return hgetAll(JedisBeanManager.getRowMapper(MartialWay.class), keys.toArray(new String[keys.size()]));
	}
	public List<Integer> gainMartialWayRank(int star,int count){
		Set<String> set = zrevrangeByScore(MARTIAL_WAY_RANK_KEY, Integer.MAX_VALUE, 0, star, count);
		List<Integer> userIds = new ArrayList<Integer>();
		for(String s : set){
			userIds.add(Integer.parseInt(s));
		}
		return userIds;
	}
	public long getUserRank(int userId){
		return zrevrank(MARTIAL_WAY_RANK_KEY, String.valueOf(userId))+1;
	}
	public void clearMartialWay(){
		Set<String> keys = smembers(MARTIAL_WAY_SET_KEY);
		keys.add(MARTIAL_WAY_RANK_KEY);
		keys.add(MARTIAL_WAY_SET_KEY);
		del(keys.toArray(new String[keys.size()]));
	}
}
