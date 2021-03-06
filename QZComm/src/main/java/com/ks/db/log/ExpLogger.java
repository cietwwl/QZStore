package com.ks.db.log;

import com.ks.access.DBBeanSet;
import com.ks.db.model.User;

/**
 * 经验日志
 *
 */
@DBBeanSet(tablename="t_exp_logger", primaryKey={"id"})
public class ExpLogger extends GameLogger {
	private static final long serialVersionUID = 1L;
	public ExpLogger(){
		super();
	}
	public ExpLogger(int logType, int logSubType, User user, int oamount, int amount, int samount, int assId, String logDec){
		super(logType, logSubType, user, oamount, amount, samount, assId, logDec);
	}
}
