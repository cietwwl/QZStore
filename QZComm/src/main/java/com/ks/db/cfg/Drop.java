package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

import lombok.Data;
/**
 * 掉落
 * @author ks
 */
@Data
@DBBeanSet(tablename="t_drop", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class Drop implements Serializable {
	private static final long serialVersionUID = 1L;
	/**怪物编号*/
	@DBFieldSet(dbfname="monsterId")
	private int monsterId;
	/**掉落物品*/
	@DBFieldSet(dbfname="dropItems")
	private String dropItems;
	
}
