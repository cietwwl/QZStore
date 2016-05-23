package com.ks.db.log;

import com.ks.access.DBBeanSet;

/**
 * 英雄经验池日志
 * @author ks
 */
@DBBeanSet(tablename="t_hero_exp_pool_logger", primaryKey={"id"})
public class HeroExpPoolLogger extends GameLogger {
	private static final long serialVersionUID = 1L;
	public HeroExpPoolLogger(){
		super();
	}
	public HeroExpPoolLogger(int logType, int logSubType, int uid, int oamount, int amount, int samount, int assId, String logDec){
		super(logType, logSubType, uid, oamount, amount, samount, assId, logDec);
	}
	
}
