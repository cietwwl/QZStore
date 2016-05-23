package com.ks.db.log;

import com.ks.access.DBBeanSet;

/**
 * 金币日志
 *
 */
@DBBeanSet(tablename="t_gold_logger", primaryKey={"id"})
public class GoldLogger extends GameLogger {
	private static final long serialVersionUID = 1L;
	public GoldLogger(){
		super();
	}
	public GoldLogger(int logType, int logSubType, int uid, int oamount, int amount, int samount, int assId, String logDec){
		super(logType, logSubType, uid, oamount, amount, samount, assId, logDec);
	}
}
