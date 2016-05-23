package com.ks.logic.cache;

import java.util.HashMap;
import java.util.Map;

import com.ks.db.model.User;

public class UserCache {
	private static ThreadLocal<Map<Integer, User>> local = new ThreadLocal<>();
	
	public static void add(User user){
		Map<Integer, User> map = local.get();
		if(map == null){
			map = new HashMap<>();
			local.set(map);
		}
		User old = map.get(user.getUserId());
		if(old == null){
			map.put(user.getUserId(), user);
		}
	}
	
	public static User getUser(int userId){
		Map<Integer, User> map = local.get();
		if(map != null){
			return map.get(userId);
		}
		return null;
	}
	
	public static void clear(){
		local.remove();
	}

}
