package com.ks.world.admin;

import java.util.List;
import java.util.Map;

public class HttpUtils {
	public static String getParam(String key, Map<String, List<String>> parammaps){
		String ret = "";
		if(parammaps != null){
			List<String> values = parammaps.get(key);
			if(values != null && !values.isEmpty()){
				for(String value : values){
					ret += value + ",";
				}
				if(ret.endsWith(",")){
					ret = ret.substring(0, ret.length() - 1);
				}
			}
		}
		return ret;
	}
	public static int getParamInt(String key,
			Map<String, List<String>> parammaps) {
		String ret = getParam(key, parammaps);
		if(ret != null && ret.length() > 0){
			return Integer.parseInt(ret);
		}
		return 0;
	}
}
