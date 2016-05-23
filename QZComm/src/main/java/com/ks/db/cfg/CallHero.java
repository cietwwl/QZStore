package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
/**
 * 召唤战魂
 * @author ks
 */
@DBBeanSet(tablename="t_call_hero", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class CallHero implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**数组编号*/
	@DBFieldSet(dbfname="array_id")
	private int arrayId;
	/**英雄编号*/
	@DBFieldSet(dbfname="hero_id")
	private int heroId;
	public int getArrayId() {
		return arrayId;
	}
	public void setArrayId(int arrayId) {
		this.arrayId = arrayId;
	}
	public int getHeroId() {
		return heroId;
	}
	public void setHeroId(int heroId) {
		this.heroId = heroId;
	}
	
}
