package com.ks.db.log;

import com.ks.access.DBBeanSet;

/**
 * 钻石日志
 * @author ks
 */
@DBBeanSet(tablename="t_diamond_logger", primaryKey={"id"})
public class DiamondLogger extends GameLogger {
	private static final long serialVersionUID = 1L;
	
	public DiamondLogger(){
		super();
	}
	public DiamondLogger(int logType, int logSubType, int uid, int oamount, int amount, int samount, int assId, String logDec){
		super(logType, logSubType, uid, oamount, amount, samount, assId, logDec);
	}
	
}
