package com.ks.protocol.vo.hero;

import java.util.ArrayList;
import java.util.List;

import com.ks.db.model.UserHero;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;

public class UserHeroVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="编号")
	private int id;
	@FieldDesc(desc="武将编号")
	private int heroId;
	@FieldDesc(desc="等级")
	private int level;
	@FieldDesc(desc="经验")
	private int exp;
	@FieldDesc(desc="属性等级")
	private int eleLevel;
	@FieldDesc(desc="状态")
	private int state;
	@FieldDesc(desc="技能等级")
	private int skillLevel;
	@FieldDesc(desc="队长技能等级")
	private int capSkillLevel;
	@FieldDesc(desc="武魂")
	private int eternal;
	@FieldDesc(desc="突破等级")
	private int breakLevel;
	@FieldDesc(desc="激活的灵元点")
	private List<Integer> breakedSlots;
	
	public void init(UserHero o){
		this.id = o.getId();
		this.heroId = o.getHeroId();
		this.level = o.getLevel();
		this.exp = o.getExp();
		this.eleLevel = o.getEleLevel();
		this.state = o.getState();
		this.skillLevel = o.getSkillLevel();
		this.capSkillLevel = o.getCapSkillLevel();
		this.eternal = o.getEternal();
		this.breakLevel = o.getBreakLevel();
		
		this.breakedSlots = new ArrayList<>();
		for(int slot : o.getBreakedSlotList()){
			this.breakedSlots.add(slot);
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public List<Integer> getBreakedSlots() {
		return breakedSlots;
	}
	public void setBreakedSlots(List<Integer> breakedSlots) {
		this.breakedSlots = breakedSlots;
	}
}
