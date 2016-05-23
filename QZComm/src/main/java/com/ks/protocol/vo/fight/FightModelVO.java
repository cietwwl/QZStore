package com.ks.protocol.vo.fight;

import java.util.ArrayList;
import java.util.List;

import com.ks.model.fight.FightAtkMode;
import com.ks.model.fight.FightBuff;
import com.ks.model.fight.FightModel;
import com.ks.model.fight.Point;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.fight.skill.FightBuffVO;

public class FightModelVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="战斗编号")
	private int fightId;
	@FieldDesc(desc="是否为NPC")
	private boolean npc;
	@FieldDesc(desc="对应编号")
	private int assId;
	@FieldDesc(desc="状态")
	private int state;
	@FieldDesc(desc="属性")
	private int ele;
	@FieldDesc(desc="能力")
	private int ability;
	@FieldDesc(desc="属性等级")
	private int eleLv;
	@FieldDesc(desc="攻击力")
	private int atk;
	@FieldDesc(desc="攻击次数")
	private int atkCount;
	@FieldDesc(desc="攻击模式")
	private List<FightAtkModeVO> atkMode;
	@FieldDesc(desc="生命")
	private int hp;
	@FieldDesc(desc="最大血量")
	private int maxHp;
	@FieldDesc(desc="基础血量")
	private int baseHp;
	@FieldDesc(desc="暴击率")
	private double  critRate;
	@FieldDesc(desc="暴击伤害")
	private double  crithurt;
	@FieldDesc(desc="躲避率")
	private double dodgeRate;
	@FieldDesc(desc="所在格子")
	private List<PointVO> gridCoors;
	@FieldDesc(desc="战斗buff")
	private List<FightBuffVO> buffs;
	@FieldDesc(desc="格挡率")
	private int blockRate;
	@FieldDesc(desc="弹射")
	private byte catapult; 
	
	@FieldDesc(desc="格挡伤害")
	private double blockHit ;
	
	public void init(FightModel o){
		this.fightId = o.getFightId();
		this.npc = o.isNpc();
		this.assId = o.getAssId();
		this.state = o.getState();
		this.ele = o.getEle();
		this.ability = o.getAbility();
		this.eleLv = o.getEleLv();
		this.atk = o.getAtk();
		this.atkCount = o.getAtkCount();
		this.baseHp = o.getHp();
		this.atkMode = new ArrayList<FightAtkModeVO>();
		for(FightAtkMode fam : o.getAtkMode()){
			FightAtkModeVO vo = MessageFactory.getMessage(FightAtkModeVO.class);
			vo.init(fam);
			atkMode.add(vo);
		}
		this.maxHp = o.getMaxHp();
		this.hp = o.getHp();
		this.critRate = o.getCritRate();
		this.crithurt = o.getCrithurt();
		this.dodgeRate = o.getDodgeRate();
		this.gridCoors = new ArrayList<PointVO>();
		for(Point p : o.getGridCoors()){
			PointVO vo = MessageFactory.getMessage(PointVO.class);
			vo.init(p);
			gridCoors.add(vo);
		}
		this.buffs = new ArrayList<FightBuffVO>();
		for(FightBuff fb : o.getBuffs()){
			FightBuffVO vo = MessageFactory.getMessage(FightBuffVO.class);
			vo.init(fb);
			buffs.add(vo);
		}
		this.blockRate = o.getBlockRate();
		this.catapult = o.getCatapult();
		this.blockHit = o.getBlockHit();
	}
	
	public int getFightId() {
		return fightId;
	}
	public void setFightId(int fightId) {
		this.fightId = fightId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getEle() {
		return ele;
	}
	public void setEle(int ele) {
		this.ele = ele;
	}
	public int getAbility() {
		return ability;
	}
	public void setAbility(int ability) {
		this.ability = ability;
	}
	public int getEleLv() {
		return eleLv;
	}
	public void setEleLv(int eleLv) {
		this.eleLv = eleLv;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getAtkCount() {
		return atkCount;
	}
	public void setAtkCount(int atkCount) {
		this.atkCount = atkCount;
	}
	public List<FightAtkModeVO> getAtkMode() {
		return atkMode;
	}
	public void setAtkMode(List<FightAtkModeVO> atkMode) {
		this.atkMode = atkMode;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public double getCritRate() {
		return critRate;
	}
	public void setCritRate(double critRate) {
		this.critRate = critRate;
	}
	public double getCrithurt() {
		return crithurt;
	}
	public void setCrithurt(double crithurt) {
		this.crithurt = crithurt;
	}
	public double getDodgeRate() {
		return dodgeRate;
	}
	public void setDodgeRate(double dodgeRate) {
		this.dodgeRate = dodgeRate;
	}
	public List<PointVO> getGridCoors() {
		return gridCoors;
	}
	public void setGridCoors(List<PointVO> gridCoors) {
		this.gridCoors = gridCoors;
	}
	public boolean isNpc() {
		return npc;
	}
	public double getBlockHit() {
		return blockHit;
	}

	public void setBlockHit(double blockHit) {
		this.blockHit = blockHit;
	}

	public void setNpc(boolean npc) {
		this.npc = npc;
	}
	public int getAssId() {
		return assId;
	}
	public void setAssId(int assId) {
		this.assId = assId;
	}
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	public List<FightBuffVO> getBuffs() {
		return buffs;
	}
	public void setBuffs(List<FightBuffVO> buffs) {
		this.buffs = buffs;
	}
	public int getBlockRate() {
		return blockRate;
	}
	public void setBlockRate(int blockRate) {
		this.blockRate = blockRate;
	}
	public byte getCatapult() {
		return catapult;
	}
	public void setCatapult(byte catapult) {
		this.catapult = catapult;
	}
	public int getBaseHp() {
		return baseHp;
	}
	public void setBaseHp(int baseHp) {
		this.baseHp = baseHp;
	}
	
}
