package com.ks.db.log;

import com.ks.access.DBBeanSet;
import com.ks.db.model.User;

/**
 * 掉落日志
 *
 */
@DBBeanSet(tablename="t_prop_logger", primaryKey={"id"})
public class PropLogger extends GameLogger {
	private static final long serialVersionUID = 1L;
	public PropLogger(){
		super();
	}
	public PropLogger(int logType, int logSubType, User user, int oamount, int amount, int samount, int assId, String logDec){
		super(logType, logSubType, user, oamount, amount, samount, assId, logDec);
	}
}
