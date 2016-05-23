package com.ks.db.cfg;

import java.io.Serializable;
import java.util.List;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
/**
 * 副本战场
 * @author ks
 */
import com.ks.object.ConditionParams;
@DBBeanSet(imports={"com.ks.util.StringUtil"}, tablename="t_zone_battle", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class ZoneBattle implements Serializable {
	private static final long serialVersionUID = 1L;
	/**战场编号*/
	@DBFieldSet(dbfname="battle_id")
	private int battleId;
	/**副本编号*/
	@DBFieldSet(dbfname="zone_id")
	private int zoneId;
	/**战场类型*/
	@DBFieldSet(dbfname="battle_type")
	private int battleType;
	/**消耗精力*/
	@DBFieldSet(dbfname="sp")
	private int sp;
	/**掉落经验*/
	@DBFieldSet(dbfname="exp")
	private int exp;
	/**第一次掉落经验*/
	@DBFieldSet(dbfname="first_exp")
	private int firstExp;
	/**掉落金币*/
	@DBFieldSet(dbfname="gold")
	private int gold;
	/**第一次掉落金钱*/
	@DBFieldSet(dbfname="first_exp")
	private int firstGold;
	/**前置副本编号*/
	@DBFieldSet(dbfname="pev_battle")
	private int pevBattle;
	/**后置副本编号*/
	@DBFieldSet(dbfname="next_battle")
	private int nextBattle;
	/**乱入概率*/
	@DBFieldSet(dbfname="dis_rate")
	private int disRate;
	/**乱入怪物*/
	@DBFieldSet(dbfname="dis_monster", parseJavaField="StringUtil.stringToList(rs.getString(\"dis_monster\"))")
	private List<Integer> disMonster;
	/**道具概率*/
	@DBFieldSet(dbfname="item_rate")
	private int itemRate;
	/**石板概率*/
	@DBFieldSet(dbfname="slate_rate")
	private int slateRate;
	/**战场配置*/
	@DBFieldSet(dbfname="hinder", parseJavaField="StringUtil.getHinder(rs.getString(\"hinder\"))")
	private int[][] hinder;
	/**分组*/
	@DBFieldSet(dbfname="group")
	private int group;
	/**子分组*/
	@DBFieldSet(dbfname="subGroup")
	private int subGroup;
	/**开放条件*/
	@DBFieldSet(dbfname="conditions")
	private String conditions;
	/**条件参数*/
	private ConditionParams conditionParams;

	
	public int getBattleId() {
		return battleId;
	}
	public void setBattleId(int battleId) {
		this.battleId = battleId;
	}
	public int getZoneId() {
		return zoneId;
	}
	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}
	public int getSp() {
		return sp;
	}
	public void setSp(int sp) {
		this.sp = sp;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getPevBattle() {
		return pevBattle;
	}
	public void setPevBattle(int pevBattle) {
		this.pevBattle = pevBattle;
	}
	public int getNextBattle() {
		return nextBattle;
	}
	public void setNextBattle(int nextBattle) {
		this.nextBattle = nextBattle;
	}
	public List<Integer> getDisMonster() {
		return disMonster;
	}
	public void setDisMonster(List<Integer> disMonster) {
		this.disMonster = disMonster;
	}
	public int getDisRate() {
		return disRate;
	}
	public void setDisRate(int disRate) {
		this.disRate = disRate;
	}
	public int getItemRate() {
		return itemRate;
	}
	public void setItemRate(int itemRate) {
		this.itemRate = itemRate;
	}
	public int getSlateRate() {
		return slateRate;
	}
	public void setSlateRate(int slateRate) {
		this.slateRate = slateRate;
	}
	public int[][] getHinder() {
		return hinder;
	}
	public void setHinder(int[][] hinder) {
		this.hinder = hinder;
	}
	public int getFirstExp() {
		return firstExp;
	}
	public void setFirstExp(int firstExp) {
		this.firstExp = firstExp;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public int getFirstGold() {
		return firstGold;
	}
	public void setFirstGold(int firstGold) {
		this.firstGold = firstGold;
	}
	public int getBattleType() {
		return battleType;
	}
	public void setBattleType(int battleType) {
		this.battleType = battleType;
	}
	public void setGroup(int group){
		this.group = group;
	}
	public int getGroup(){
		return group;
	}
	public void setSubGroup(int subGroup){
		this.subGroup = subGroup;
	}
	public int getSubGroup(){
		return subGroup;
	}
	public void setConditions(String conditions){
		this.conditions = conditions;
		initConditions();
	}
	public String getConditions(){
		return conditions;
	}
	public void initConditions(){
		if(conditions.length() > 0){
			conditionParams = new ConditionParams(conditions);
		}
	}
	public ConditionParams getConditionParams(){
		return conditionParams;
	}
	
}
