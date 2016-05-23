package com.ks.db.cfg;

import java.io.Serializable;
import java.util.List;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
/**
 * 召唤英雄规则
 * @author ks
 */
@DBBeanSet(tablename="t_call_hero_rule", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class CallHeroRule implements Serializable {
	private static final long serialVersionUID = 1L;
	/**数组编号*/
	@DBFieldSet(dbfname="array_id")
	private int arrayId;
	/**类型*/
	@DBFieldSet(dbfname="type")
	private int type;
	/**概率*/
	@DBFieldSet(dbfname="rate")
	private int rate;
	/**能召唤到的战魂*/
	List<CallHero> heros;
	public int getArrayId() {
		return arrayId;
	}
	public void setArrayId(int arrayId) {
		this.arrayId = arrayId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public List<CallHero> getHeros() {
		return heros;
	}
	public void setHeros(List<CallHero> heros) {
		this.heros = heros;
	}
}
