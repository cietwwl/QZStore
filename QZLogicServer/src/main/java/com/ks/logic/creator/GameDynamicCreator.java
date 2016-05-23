package com.ks.logic.creator;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.ks.access.DBBeanSqlTemplateUtil;
import com.ks.access.DBBeanTableUtil;
import com.ks.exception.ExceptionUtil;
import com.ks.exceptions.GameException;
import com.ks.util.JedisBeanUtil;
import com.ks.util.MessageUtil;

public class GameDynamicCreator {
	public static void main(String args[]) throws Exception{
		FileInputStream fis = new FileInputStream(new File("conf/GameDynamic.properties"));
		Properties properties = new Properties();
		properties.load(fis);
		/**生成as error*/
		ExceptionUtil.createExceptionXMLFile(new GameException(), properties.getProperty("as_error_xml"));
		ExceptionUtil.createAs3ExceptionClass(new GameException(), properties.getProperty("as_error_clazz"));
		/**生成table*/
		InputStream stream = GameDynamicCreator.class.getClassLoader().getResourceAsStream("DBBeanMapper.properties");
		DBBeanTableUtil.createBeanTables(stream, properties.getProperty("table_clazz"), "com.ks.table");
		/**生成Message*/
		MessageUtil.initProxyMessages(properties.getProperty("message_clazz"), "com.ks.protocol.proxy", properties.getProperty("as_error_clazz"));
		/**生成JedisBean*/
		InputStream jedisstream = GameDynamicCreator.class.getClassLoader().getResourceAsStream("JedisBeanMapper.properties");
		JedisBeanUtil.initJedisBean(jedisstream, properties.getProperty("jedis_clazz"), "com.ks.jedis.model");
		/**生成DAO sql*/
		InputStream stream1 = GameDynamicCreator.class.getClassLoader().getResourceAsStream("DBBeanMapper.properties");
		InputStream stream2 = GameDynamicCreator.class.getClassLoader().getResourceAsStream("DynamicSqlMapper.properties");
		DBBeanSqlTemplateUtil.createDBBeanSqlTemplates(stream1, stream2, properties.getProperty("dao_sql"), "com.ks.logic.db_template");
	
	}
}
