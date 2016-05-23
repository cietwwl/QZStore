package com.ks.world.admin;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtil {
	public static Properties read(String file) throws Exception{
//		File f = new File(file);
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
		return properties.getProperty(key);
	}
}
