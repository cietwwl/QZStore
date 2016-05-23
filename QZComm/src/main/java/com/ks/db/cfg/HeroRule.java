package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.constant.SystemConstant;
/**
 * 英雄规则
 * @author ks
 */
@DBBeanSet(tablename="t_hero_rule", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class HeroRule implements Serializable {
	private static final long serialVersionUID = 1L;
	/**等级*/
	@DBFieldSet(dbfname="level")
	private int level;
	/**下一级经验*/
	@DBFieldSet(dbfname="next_exp")
	private int nextExp;
	/**金钱*/
	@DBFieldSet(dbfname="money")
	private int money;
	/**熔炼经验*/
	@DBFieldSet(dbfname="rong_lian_exp")
	private int rongLianExp;
	/**分解经验*/
	@DBFieldSet(dbfname="fen_jie_exp")
	private int fenjieExp;
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getNextExp() {
		return nextExp;
	}
	public int getNextExp(int quality) {
		return (int) (nextExp * SystemConstant.HERO_RULE_LEVEL_UP[quality-1][0]);
	}
	public void setNextExp(int nextExp) {
		this.nextExp = nextExp;
	}
	public int getMoney() {
		return money;
	}
	public int getMoney(int quality) {
		return (int) (money * SystemConstant.HERO_RULE_LEVEL_UP[quality-1][1]);
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getRongLianExp() {
		return rongLianExp;
	}
	public void setRongLianExp(int rongLianExp) {
		this.rongLianExp = rongLianExp;
	}
	public int getFenjieExp() {
		return fenjieExp;
	}
	public void setFenjieExp(int fenjieExp) {
		this.fenjieExp = fenjieExp;
	}
	
}
