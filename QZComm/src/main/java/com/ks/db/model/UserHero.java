package com.ks.db.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.cache.JedisBeanSet;
import com.ks.cache.JedisFieldSet;
import com.ks.constant.SystemConstant;
import com.ks.model.fight.FightModel;
import com.ks.util.StringUtil;
/**
 * 用户英雄
 * @author ks
 */
@DBBeanSet(primaryKey={"id"})
@JedisBeanSet()
@Data
public class UserHero implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**编号*/
	@DBFieldSet(dbfname="id")
	@JedisFieldSet()
	private int id;
	/**用户编号*/
	@DBFieldSet(dbfname="user_id")
	@JedisFieldSet()
	private int userId;
	/**武将编号*/
	@DBFieldSet(dbfname="hero_id")
	@JedisFieldSet()
	private int heroId;
	/**等级*/
	@DBFieldSet(dbfname="level")
	@JedisFieldSet()
	private int level;
	/**经验*/
	@DBFieldSet(dbfname="exp")
	@JedisFieldSet()
	private int exp;
	/**属性等级*/
	@DBFieldSet(dbfname="ele_level")
	@JedisFieldSet()
	private int eleLevel;
	/**状态*/
	@DBFieldSet(dbfname="state")
	@JedisFieldSet()
	private int state;
	/**技能等级*/
	@DBFieldSet(dbfname="skill_level")
	@JedisFieldSet()
	private int skillLevel=1;
	/**队长技能等级*/
	@DBFieldSet(dbfname="cap_skill_level")
	@JedisFieldSet()
	private int capSkillLevel=1;
	/**创建时间*/
	@DBFieldSet(dbfname="create_time")
	@JedisFieldSet()
	private Date createTime = new Date();
	/**修改时间*/
	@DBFieldSet(dbfname="update_time")
	@JedisFieldSet()
	private Date updateTime = new Date();
	/**是否修改过*/
	@JedisFieldSet()
	private boolean update;
	/**武魂*/
	@DBFieldSet(dbfname="eternal")
	@JedisFieldSet()
	private int eternal;
	/**突破等级*/
	@DBFieldSet(dbfname="breakLevel")
	@JedisFieldSet()
	private int breakLevel;
	/**激活的灵元点*/
	@DBFieldSet(dbfname="breakedSlots")
	@JedisFieldSet()
	private String breakedSlots;
	private List<Integer> breakedSlotList = new ArrayList<Integer>();
	
	private void initBreakedSlotList(){
		breakedSlotList = StringUtil.stringToList(breakedSlots);
	}
	private void initBreakedSlots(){
		breakedSlots = StringUtil.listToString(breakedSlotList);
	}
	
	/**战斗buff*/
	private FightModel model;
	

	public FightModel getModel() {
		return model;
	}

	public void setModel(FightModel model) {
		this.model = model;
	}

	/**
	 * 升级类型加成
	 * @param upType 升级类型
	 * @return 升级类型加成
	 */
	public static final double getLevelUpVal(int upType){
		return SystemConstant.HERO_UP_TYPE_VAL[upType-1]/100d;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getHeroId() {
		return heroId;
	}
	public void setHeroId(int heroId) {
		this.heroId = heroId;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getEleLevel() {
		return eleLevel;
	}
	public void setEleLevel(int eleLevel) {
		this.eleLevel = eleLevel;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getSkillLevel() {
		return skillLevel;
	}
	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}
	public int getCapSkillLevel() {
		return capSkillLevel;
	}
	public void setCapSkillLevel(int capSkillLevel) {
		this.capSkillLevel = capSkillLevel;
	}
	public boolean isUpdate() {
		return update;
	}
	public void setUpdate(boolean update) {
		this.update = update;
	}
	public int getEternal() {
		return eternal;
	}
	public void setEternal(int eternal) {
		this.eternal = eternal;
	}
	public int getBreakLevel() {
		return breakLevel;
	}
	public void setBreakLevel(int breakLevel) {
		this.breakLevel = breakLevel;
	}
	public String getBreakedSlots() {
		initBreakedSlots();
		return breakedSlots;
	}
	public void setBreakedSlots(String breakedSlots) {
		this.breakedSlots = breakedSlots;
		initBreakedSlotList();
	}
}
