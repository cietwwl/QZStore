package com.ks.db.log;

import com.ks.access.DBBeanSet;

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
	public SlateLogger(int logType, int logSubType, int uid, int oamount, int amount, int samount, int assId, String logDec){
		super(logType, logSubType, uid, oamount, amount, samount, assId, logDec);
	}
}
