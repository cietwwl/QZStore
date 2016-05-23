package com.ks.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LockKeyUtil {
	public static final String USER_PREFIX = "USER_";
	/**
	 * 得到玩家锁key
	 * @param userId
	 * @return
	 */
	public static String getUserLockKey(int userId){
		return "USER_" + userId;
	}
	
	public static List<String> getUserLockKeys(Collection<Integer> userIds){
		List<String> list = new ArrayList<String>();
		for(int userId : userIds){
			list.add(getUserLockKey(userId));
		}
		return list;
	}
	
}
