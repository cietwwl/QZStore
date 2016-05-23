package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

import lombok.Data;

@Data
@DBBeanSet(tablename="t_arena_buy", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class ArenaBuy implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**累计购买次数*/
	@DBFieldSet(dbfname="count")
	private int count;
	/**购买挑战次数价格*/
	@DBFieldSet(dbfname="buy_count")
	private int buyBattlePrice;
	/**购买刷新次数价格*/
	@DBFieldSet(dbfname="shopping_money")
	private int buyRefreshPrice;

}
