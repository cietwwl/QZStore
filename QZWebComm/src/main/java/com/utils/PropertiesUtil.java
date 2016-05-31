package com.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtil {
	public static Properties read(String file) throws Exception{
		FileInputStream input = new FileInputStream(file);
		Properties properties = new Properties();
		try{
			properties.load(input);
		}finally{
			input.close();
		}
		return properties;
	}
	public static String getValue(Properties properties, String key) throws Exception{
		String str = properties.getProperty(key);
		if(str != null){
			return StringUtil.encode(str, "ISO-8859-1", "UTF-8");
		}
		return "";
	}
	
	public static int getValueInt(Properties properties, String key) throws Exception{
		return Integer.parseInt(getValue(properties, key));
	}
	
	public static boolean getValueBoolean(Properties properties, String key) throws Exception{
		return Boolean.parseBoolean(getValue(properties, key));
	}
}
