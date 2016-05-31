package com.ks.db.log;

import com.ks.access.DBBeanSet;
import com.ks.db.model.User;

/**
 * 灵气日志
 *
 */
@DBBeanSet(tablename="t_gp_logger", primaryKey={"id"})
public class GpLogger extends GameLogger {
	private static final long serialVersionUID = 1L;
	public GpLogger(){
		super();
	}
	public GpLogger(int logType, int logSubType, User user, int oamount, int amount, int samount, int assId, String logDec){
		super(logType, logSubType, user, oamount, amount, samount, assId, logDec);
	}
}
