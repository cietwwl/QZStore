package com.ks.world.admin;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class AdminWorkActionCache {
	private static Map<String, AdminWorkAction> cache = new ConcurrentHashMap<String, AdminWorkAction>();
	public static void init(String file) throws Exception{
		Properties propertes = new Properties();
		propertes.load(AdminWorkActionCache.class.getClassLoader().getResourceAsStream(file));
		for(Object okey : propertes.keySet()){
			String key = String.valueOf(okey);
			String value = (String)propertes.get(key);
			AdminWorkAction action = (AdminWorkAction)Class.forName(value).newInstance();
			cache.put(key, action);
		}
	}
	public static AdminWorkAction getAction(String key){
		return cache.get(key);
	}
}
