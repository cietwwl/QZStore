package com.ks.db.log;

import com.ks.access.DBBeanSet;

/**
 * 英雄日志
 * @author ks
 */
@DBBeanSet(tablename="t_hero_logger", primaryKey={"id"})
public class HeroLogger extends GameLogger {
	private static final long serialVersionUID = 1L;
	public HeroLogger(){
		super();
	}
	public HeroLogger(int logType, int logSubType, int uid, int oamount, int amount, int samount, int assId, String logDec){
		super(logType, logSubType, uid, oamount, amount, samount, assId, logDec);
	}
	
}
