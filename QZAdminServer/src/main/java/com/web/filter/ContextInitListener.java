package com.web.filter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cache.GameErrorCache;
import com.cache.GamePartnerCache;
import com.cache.GameServerCache;
import com.cache.SysJurisdictionCache;
import com.cache.SysMenuCache;
import com.cache.SysRequestCache;
import com.cache.SysUserCache;
import com.db.util.ConnUtil;
import com.game.action.EActionPool;
import com.game.constant.GameConstant;
import com.ks.access.DBBeanRowMapperManager;

public class ContextInitListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0){
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event){
		PropertyConfigurator.configure("conf/admin_log4j.properties");
		Logger logger = Logger.getLogger(this.getClass().getSimpleName());
		logger.info("init start...");
		ConnUtil.init("conf/db_config.properties");
		GameErrorCache.init("conf/error_lang.properties");
		GameConstant.init("conf/server_config.properties");
		try{
			DBBeanRowMapperManager.init(null, "com.ks.table");
		}catch(Exception e){
			e.printStackTrace();
		}
		EActionPool.init();
		SysMenuCache.load();
		SysUserCache.load();
		SysRequestCache.load();
		SysJurisdictionCache.load();
		GameServerCache.load();
		GamePartnerCache.load();
		logger.info("init is end!!!!");
	}

}
