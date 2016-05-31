package com.ks.db.log;

import com.ks.access.DBBeanSet;
import com.ks.db.model.User;

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
	public HeroLogger(int logType, int logSubType, User user, int oamount, int amount, int samount, int assId, String logDec){
		super(logType, logSubType, user, oamount, amount, samount, assId, logDec);
	}
	
}
