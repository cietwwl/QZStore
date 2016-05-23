package com.ks.db.log;

import com.ks.access.DBBeanSet;

/**
 * 武魂日志
 * @author ks
 */
@DBBeanSet(tablename="t_eternal_logger", primaryKey={"id"})
public class EternalLogger extends GameLogger {
	private static final long serialVersionUID = 1L;
	public EternalLogger(){
		super();
	}
	public EternalLogger(int logType, int logSubType, int uid, int oamount, int amount, int samount, int assId, String logDec){
		super(logType, logSubType, uid, oamount, amount, samount, assId, logDec);
	}
}
