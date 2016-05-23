package com.ks.logic.kernel;

import java.io.File;
import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.sql.Timestamp;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DataSourceUtils;
import com.ks.action.world.LockAction;
import com.ks.action.world.WorldServerAction;
import com.ks.app.Application;
import com.ks.cache.JedisBeanManager;
import com.ks.cache.JedisFactory;
import com.ks.data.DataSetCache;
import com.ks.logger.LoggerFactory;
import com.ks.logic.cache.GameCache;
import com.ks.logic.service.impl.DataServiceImpl;
import com.ks.manager.ClientLockManager;
import com.ks.rpc.RPCKernel;
import com.ks.rpc.client.RPCClient;
import com.ks.rpc.server.RPCServerBootstrap;

/**
 * 
 * @author ks
 *
 */
public final class QZLogicServerKernel {
	private static final Logger logger = LoggerFactory.get(QZLogicServerKernel.class);
	private QZLogicServerKernel(){}
	public static void initDataSource() throws Exception{
		logger.info("init data source...");
		try(FileInputStream fis = new FileInputStream(new File("conf"+File.separatorChar+"Datasource.properties"))){
			Properties properties = new Properties();
			properties.load(fis);
			
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setUrl(properties.getProperty("url"));
			dataSource.setUsername(properties.getProperty("username"));
			dataSource.setPassword(properties.getProperty("password"));
			dataSource.setInitialSize(Integer.parseInt(properties.getProperty("initialSize")));
			
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setMaxIdle(Runtime.getRuntime().availableProcessors()*2);
			dataSource.setMinIdle(Runtime.getRuntime().availableProcessors()*2);
			dataSource.setMaxActive(Runtime.getRuntime().availableProcessors()*2);
			
			dataSource.setMaxWait(60000);
			dataSource.setTestWhileIdle(true);
			dataSource.setTestOnBorrow(false);
			dataSource.setTestOnReturn(false);
			dataSource.setValidationQuery("select 1");
			dataSource.setTimeBetweenEvictionRunsMillis(3600000);
			dataSource.setNumTestsPerEvictionRun(Runtime.getRuntime().availableProcessors());
			dataSource.setDefaultAutoCommit(true);
			
			DataSourceUtils.setDataSource(dataSource);
			

			/**初始化配置数据源*/
			Properties cfgproperties = new Properties();
			cfgproperties.load(new FileInputStream(new File("conf"+File.separatorChar+"CfgDatasource.properties")));
			BasicDataSource cfgDataSource = new BasicDataSource();
			cfgDataSource.setUrl(cfgproperties.getProperty("url"));
			cfgDataSource.setUsername(cfgproperties.getProperty("username"));
			cfgDataSource.setPassword(cfgproperties.getProperty("password"));
			dataSource.setInitialSize(Integer.parseInt(properties.getProperty("initialSize")));
			
			cfgDataSource.setDriverClassName("com.mysql.jdbc.Driver");
			cfgDataSource.setMaxIdle(Runtime.getRuntime().availableProcessors()*2);
			cfgDataSource.setMinIdle(Runtime.getRuntime().availableProcessors()*2);
			cfgDataSource.setMaxActive(Runtime.getRuntime().availableProcessors()*2);
			
			cfgDataSource.setMaxWait(60000);
			cfgDataSource.setTestWhileIdle(true);
			cfgDataSource.setTestOnBorrow(true);
			cfgDataSource.setTestOnReturn(true);
			cfgDataSource.setValidationQuery("select 1");
			cfgDataSource.setTimeBetweenEvictionRunsMillis(3600000);
			cfgDataSource.setNumTestsPerEvictionRun(Runtime.getRuntime().availableProcessors());
			cfgDataSource.setDefaultAutoCommit(true);
			
			DataSourceUtils.setCfgDataSource(cfgDataSource);
			
			DBBeanRowMapperManager.init("com.ks.logic.db_template", "com.ks.table");
			JedisBeanManager.init("com.ks.jedis.model");
			
			JedisFactory.init();
		}
	}
	private static void init() throws Exception{
		try{
			Application application = new Application();
			application.init("QZLogicApplication.xml",application);
			initDataSource();
			initGameCache();
			RPCClient client = new RPCClient(new InetSocketAddress(Application.WORLD_SERVER_HOST,
					Application.WORLD_SERVER_PORT), "", Application.WORLD_SERVER);
			RPCKernel.addRPCClient(client);
			RPCServerBootstrap.start(Application.RPC_PORT);
			RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, WorldServerAction.class).
			logicServerConndeted(Application.RPC_HOST,
					Application.RPC_PORT,Application.serverId);
			ClientLockManager.init(RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, LockAction.class));
		}finally{
			DataSourceUtils.releaseConnection();
		}
	}
	private static void startServer() throws Exception{
		init();
	}
	public static void initGameCache() throws Exception{
		logger.info("init game cache...");
		DataSetCache.init(new DataServiceImpl());
		GameCache.init();
	}
	public static void main(String[] args) throws Exception {
		final long start = System.currentTimeMillis();
		try{
			startServer();
		}catch(Exception e){
			logger.error("",e);
			System.exit(-1);
		}
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				logger.info("Logic Server shut down..");
				logger.info("start run time : " + new Timestamp(start));
				logger.info("end run time ->" + new Timestamp(System.currentTimeMillis()));
			}
		}));
	}
}