package com.ks.db.log;

import com.ks.access.DBBeanSet;

/**
 * 装备日志
 *
 */
@DBBeanSet(tablename="t_equipment_logger", primaryKey={"id"})
public class EquipmentLogger extends GameLogger {
	private static final long serialVersionUID = 1L;
	
	public EquipmentLogger(){
		super();
	}
	public EquipmentLogger(int logType, int logSubType, int uid, int oamount, int amount, int samount, int assId, String logDec){
		super(logType, logSubType, uid, oamount, amount, samount, assId, logDec);
	}
}
