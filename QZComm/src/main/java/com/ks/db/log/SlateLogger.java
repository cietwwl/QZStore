package com.ks.db.log;

import com.ks.access.DBBeanSet;
import com.ks.db.model.User;

/**
 * 石板日志
 *
 */
@DBBeanSet(tablename="t_slate_logger", primaryKey={"id"})
public class SlateLogger extends GameLogger {
	private static final long serialVersionUID = 1L;
	public SlateLogger(){
		super();
	}
	public SlateLogger(int logType, int logSubType, User user, int oamount, int amount, int samount, int assId, String logDec){
		super(logType, logSubType, user, oamount, amount, samount, assId, logDec);
	}
}
