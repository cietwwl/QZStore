package com.ks.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * String工具类
 * @author hanjie.l
 *
 */
public class StringUtils {
	/**
	 * ":"
	 */
	public static final String DELIMITER_ARGS = ":";
	
	/**
	 * ","
	 */
	public static final String BETWEEN_DOT = ",";
	
	/**
	 * "\\|"
	 */
	public static final String ELEMENT_SPLIT = "\\|";
	
	/**
	 * "|" 调用String.split时不能用ELEMENT_DELIMITER, 用ELEMENT_SPLIT即可
	 */
	public static final String ELEMENT_DELIMITER = "|";
	
	
	/**
	 * 将Map<Integer, Map<Integer, Integer>> 转化成字符串
	 * 字符串的格式:
	 * key,subKey:subVal,subKey:subVal|key,subKey:subVal,subKey:subVal
	 * @param map
	 * @return
	 */
	public static String intMapToString(Map<Integer, Map<Integer, Integer>> map) {
		if (map == null || map.isEmpty()) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder();		
		for (Integer key : map.keySet()) {
			Map<Integer, Integer> subMap = map.get(key);
			if (subMap == null || subMap.isEmpty()) {
				continue;
			}
			sb.append(key).append(BETWEEN_DOT);
			for (Entry<Integer, Integer> entry : subMap.entrySet()) {
				sb.append(entry.getKey()).append(DELIMITER_ARGS);
				sb.append(entry.getValue()).append(BETWEEN_DOT);
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append(ELEMENT_DELIMITER);
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
	/**
	 * 字符串转Map<Integer, Map<Integer, Integer>>
	 * 字符串的格式是:
	 * key,subKey:subVal,subKey:subVal|key,subKey:subVal,subKey:subVal
	 * @param delimiterString
	 * @param split
	 * @return
	 */
	public static  Map<Integer, Map<Integer, Integer>> stringToIntMap(String delimiterString) {
		if ((delimiterString == null) || (delimiterString.trim().length() == 0)) {
			return new ConcurrentHashMap<>();
		}

		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
		String[] ss = split(delimiterString.trim(), ELEMENT_SPLIT);
		if (ss != null && ss.length > 0) {
			for (String str : ss) {
				String subStrs[] = split(str , BETWEEN_DOT);
				Integer key = Integer.parseInt(subStrs[0]);
				Map<Integer, Integer> subMap = new HashMap<>();
				for (int i = 1; i < subStrs.length; i++) {
					String[] keyValue = split(subStrs[i],DELIMITER_ARGS);
					if(keyValue != null){
						Integer subKey = Integer.valueOf(keyValue[0]);
						Integer subVal = Integer.valueOf(keyValue[1]);
						subMap.put(subKey, subVal);		
					}
				}
				map.put(key, subMap);
			}
		}
		return map;
	}
	
	/**
	 * 分隔符字符串转换为Set<Integer>集合
	 * @param delimiterString  11,12,13,14
	 * @return
	 */
	public static Set<Integer> stringToSet(String splitString) {
		Set<Integer> set = new HashSet<Integer>();
		if (!isBlank(splitString)){
			String[] stringArray = split(splitString, BETWEEN_DOT);
			
			for (String str : stringArray) {
				if(!isBlank(str)) {
					set.add(Integer.valueOf(str));
				}
			}
		}
		
		return set;
	}
	
	/**
	 * Set<Integer>集合转换为分隔符字符串
	 * @param 
	 * @return 11,12,13,14
	 */
	public static String setToString(Set<? extends Number> set) {
		StringBuilder builder = new StringBuilder("");
		for(Number i : set) {
			builder.append(i).append(BETWEEN_DOT);
		}
		if(builder.length() > 0) {
			builder.deleteCharAt(builder.length() - 1);
		}
		
		return builder.toString();
	}
	
	/**
	 * 分割
	 * @param src
	 * @param splitable
	 * @return
	 */
	public static String[] split(String src, String splitable) {
		if (isBlank(src) || isBlank(splitable)) {
			return null;
		}
		
		String[] items = src.split(splitable);	
		String[] result = new String[items.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = new String(items[i]);
		}
		
		return result;
	}
	
	/**
	 * 字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		}
		return false;
	}
	

}
