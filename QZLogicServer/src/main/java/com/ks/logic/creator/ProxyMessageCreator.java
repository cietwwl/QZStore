package com.ks.logic.creator;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.ks.util.MessageUtil;

public class ProxyMessageCreator {
	public static void main(String args[]) throws Exception{
		FileInputStream fis = new FileInputStream(new File("conf/GameDynamic.properties"));
		Properties properties = new Properties();
		properties.load(fis);
		MessageUtil.initProxyMessages(properties.getProperty("message_clazz"), "com.ks.protocol.proxy", properties.getProperty("as_error_clazz"));
	}
}
