package com.ks.db.cfg;

import java.io.Serializable;
import java.util.List;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
/**
 * 武魂
 * @author ks
 */
@DBBeanSet(tablename="t_eternal", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class Eternal implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**武魂编号*/
	@DBFieldSet(dbfname="eternal_id")
	private int eternalId;
	/**名称*/
	@DBFieldSet(dbfname="name")
	private String name;
	/**属性*/
	@DBFieldSet(dbfname="ele")
	private int ele;
	/**品质*/
	@DBFieldSet(dbfname="quality")
	private int quality;
	/**出售价格*/
	@DBFieldSet(dbfname="sell_price")
	private int sellPrice;
	/**稀有度*/
	@DBFieldSet(dbfname="rarity")
	private int rarity;
	/**技能*/
	@DBFieldSet(dbfname="skill_id")
	private int skillId;
	/**熔炼点*/
	@DBFieldSet(dbfname="eternal_val")
	private int eternalVal;
	/**武魂效果*/
	private List<EternalEffect> effects;
	public int getRarity() {
		return rarity;
	}
	public void setRarity(int rarity) {
		this.rarity = rarity;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public int getEternalId() {
		return eternalId;
	}
	public void setEternalId(int eternalId) {
		this.eternalId = eternalId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public int getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}
	public List<EternalEffect> getEffects() {
		return effects;
	}
	public void setEffects(List<EternalEffect> effects) {
		this.effects = effects;
	}
	public int getEle() {
		return ele;
	}
	public void setEle(int ele) {
		this.ele = ele;
	}
	public int getEternalVal() {
		return eternalVal;
	}
	public void setEternalVal(int eternalVal) {
		this.eternalVal = eternalVal;
	}
	
}
