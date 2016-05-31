package com.ks.db.log;

import com.ks.access.DBBeanSet;
import com.ks.db.model.User;

/**
 * 体力日志
 *
 */
@DBBeanSet(tablename="t_stamina_logger", primaryKey={"id"})
public class StaminaLogger extends GameLogger {
	private static final long serialVersionUID = 1L;
	public StaminaLogger(){
		super();
	}
	public StaminaLogger(int logType, int logSubType, User user, int oamount, int amount, int samount, int assId, String logDec){
		super(logType, logSubType, user, oamount, amount, samount, assId, logDec);
	}
}
