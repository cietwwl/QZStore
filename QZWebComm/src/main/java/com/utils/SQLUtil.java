package com.utils;

public class SQLUtil {
	/**
	 * 转为unix_timestamp(秒)
	 * @param name
	 * @return
	 */
	public static String parseUnixTimestamp(String name){
		return "unix_timestamp(" + name + ")";
	}
}
