package com.ks.db.log;

import com.ks.access.DBBeanSet;
import com.ks.db.model.User;

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
	public EternalLogger(int logType, int logSubType, User user, int oamount, int amount, int samount, int assId, String logDec){
		super(logType, logSubType, user, oamount, amount, samount, assId, logDec);
	}
}
