package com.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.utils.PropertiesUtil;

/**
 * 游戏错误缓存
 *
 */
public class GameErrorCache {
	private static Map<Integer, String> errorMap = new HashMap<Integer, String>();
	
	public static void init(String file){
		try{
			Properties properties = PropertiesUtil.read(file);
			for(Object obj : properties.keySet()){
				String key = obj.toString();
				errorMap.put(Integer.parseInt(key), PropertiesUtil.getValue(properties, key));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static String getErrorName(int errorId){
		String name = errorMap.get(errorId);
		if(name == null){
			return String.valueOf(errorId);
		}
		return name;
	}
}
