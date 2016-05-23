package com.ks.app;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.ks.logger.LoggerFactory;
import com.ks.protocol.MessageProcess;
/**
 * 
 * @author ks
 *
 */
public final class Application extends ServerEngine{
	
	
	private static final Logger logger = LoggerFactory.get(Application.class);
	/**游戏服务器*/
	public static final int GAME_SERVER = 1;
	/**世界服务器*/
	public static final int WORLD_SERVER = 2;
	/**登录服务器*/
	public static final int LOGIN_SERVER = 3;
	/**逻辑服务器服务器*/
	public static final int LOGIC_SERVER = 4;
	/**Boss服务器*/
	public static final int BOSS_SERVER = 5;
	/**账号服务器*/
	public static final int ACCOUNT_SERVER = 6;
	
	/**服务器端口*/
	public static int PORT;
	/**远程调用端口*/
	public static int RPC_PORT;
	/**服务器主机名或IP*/
	public static String HOST;
	/**远程调用主机名或IP*/
	public static String RPC_HOST;
	/**世界服务器地址*/
	public static String WORLD_SERVER_HOST;
	/**世界服务器端口*/
	public static int WORLD_SERVER_PORT;
	/**最大工作线程数*/
	public static int MAXIMUM_POOL_SIZE;
	/**后台指令端口*/
	public static int ADMIN_PORT;
	/**世界服务器id*/
	public static String WORLD_SERVER_ID;
	/**订单地址*/
	public static String BILL_URL;
	
	public static MessageProcess messageProcess;

	@Override
	public void addMessagePropcess(Object o) {
		messageProcess = (MessageProcess) o;
	}
	public void initApplication() throws Exception{
		try(FileInputStream fis = new FileInputStream(new File("conf"+File.separatorChar+"ServerInfo.properties"))){
			Properties properties = new Properties();
			properties.load(fis);
			LoggerFactory.setFile(properties.getProperty("logger.file"));
			LoggerFactory.setLevel(properties.getProperty("logger.level"));
			SERVVER_STATUS = Boolean.parseBoolean(properties.getProperty("status"));
			RPC_PORT = properties.getProperty("rpcPort")==null?0:Integer.parseInt(properties.getProperty("rpcPort"));
			PORT=properties.getProperty("port")==null?0:Integer.parseInt(properties.getProperty("port"));
			HOST=properties.getProperty("host");
			RPC_HOST = properties.getProperty("rpcHost");
			WORLD_SERVER_HOST = properties.getProperty("worldServerHost");
			WORLD_SERVER_PORT = properties.getProperty("worldServerPort")==null?0:Integer.parseInt(properties.getProperty("worldServerPort"));
			HEAD_LENGTH = Integer.parseInt(properties.getProperty("headLength"));
			serverId = properties.getProperty("serverId");
			ADMIN_PORT = properties.getProperty("adminPort") == null ? 0 : Integer.parseInt(properties.getProperty("adminPort"));
			MAXIMUM_POOL_SIZE = properties.getProperty("maximumPoolSize")==null?Runtime.getRuntime().availableProcessors()*2:Integer.parseInt(properties.getProperty("maximumPoolSize"));
			WORLD_SERVER_ID = properties.getProperty("worldServerId"); 
			BILL_URL = properties.getProperty("billUrl");
			GameWorkExecutor.initGameWorkExecutor(MAXIMUM_POOL_SIZE);
			logger.info("init server info");
			logger.info("Server Status : "+(SERVVER_STATUS?"Release":"Develop"));
		}
	}
	@Override
	public boolean isInitVO() {
		return true;
	}
	@Override
	public boolean isCreateProxyVO(){
		return false;
	}
}