package com.ks.db.cfg;

import java.io.Serializable;
import java.util.List;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.constant.SystemConstant;
import com.ks.util.StringUtil;

/**
 * 伙伴
 *
 */
@DBBeanSet(tablename="t_hero", imports={"com.ks.util.StringUtil"}, createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class Hero implements Serializable {
	private static final long serialVersionUID = 1L;
	/**英雄编号*/
	@DBFieldSet(dbfname="hero_id")
	private int heroId;
	/**图鉴编号*/
	@DBFieldSet(dbfname="card_id")
	private int cardId;
	/**名称*/
	@DBFieldSet(dbfname="name")
	private String name;
	/**品质*/
	@DBFieldSet(dbfname="quality")
	private int quality;
	/**稀有度*/
	@DBFieldSet(dbfname="rare_degree")
	private int rareDegree;
	/**统治力*/
	@DBFieldSet(dbfname="cost")
	private int cost;
	/**属性*/
	@DBFieldSet(dbfname="ele")
	private int ele;
	/**能力*/
	@DBFieldSet(dbfname="ability")
	private int ability;
	/**最高等级*/
	@DBFieldSet(dbfname="max_level")
	private int maxLevel;
	/**血量*/
	@DBFieldSet(dbfname="hp")
	private double hp;
	/**血量成长*/
	@DBFieldSet(dbfname="hp_up")
	private double hpUp;
	/**攻击力*/
	@DBFieldSet(dbfname="atk")
	private double atk;
	/**攻击力成长*/
	@DBFieldSet(dbfname="atk_up")
	private double atkUp;
	/**攻击次数*/
	@DBFieldSet(dbfname="atk_count")
	private int atkCount;
	/**攻击方式*/
	@DBFieldSet(dbfname="atk_mode")
	private String atkMode;
	/**移动方式*/
	@DBFieldSet(dbfname="move_mode")
	private String moveMode;
	/**暴击率*/
	@DBFieldSet(dbfname="crit_rate")
	private int critRate;
	/**暴击伤害*/
	@DBFieldSet(dbfname="crit_hit")
	private int critHit;
	/**多躲闪率*/
	@DBFieldSet(dbfname="dodge_rate")
	private int dodgeRate;
	/**技能编号*/
	@DBFieldSet(dbfname="skill_id")
	private int skillId;
	/**队长技能编号*/
	@DBFieldSet(dbfname="cap_skill_id")
	private int capSkillId;
	/**被动技能*/
	/**被动技能*/
	@DBFieldSet(dbfname="passive_skills")
	private String passiveSkillStr;
	private List<Integer>passiveSkills;
	/**卖出价格*/
	@DBFieldSet(dbfname="sell_price")
	private int sellPrice;
	/**产出经验*/
	@DBFieldSet(dbfname="give_exp")
	private int giveExp;
	/**格挡率*/
	@DBFieldSet(dbfname="block_rate")
	private int blockRate;
	/**格挡伤害*/
	@DBFieldSet(dbfname="block_hit")
	private int blockHit;
	/**弹射*/
	private byte catapult;
	/**突破消耗组{@link HeroBreakSetting#getGroupId()}*/
	@DBFieldSet(dbfname="breakGroup")
	private int breakGroup;
	/**突破属性增加组{@link HeroBreakAttrSetting#getGroupId()}*/
	@DBFieldSet(dbfname="breakAttrGroup")
	private int breakAttrGroup;
	
	/**
	 * 获得属性克制
	 * @param attEle 攻击方属性
	 * @param attEleLevel 攻击方属性等级
	 * @param defEle 防守方属性
	 * @param defEleLevel 防守方属性等级
	 * @return 伤害百分比
	 */
	public static final double getRestraint(int attEle,int attEleLevel,int defEle,int defEleLevel){
		double hurt = 1;
		if((attEle == SystemConstant.FIGHT_ELE_FIRE && defEle == SystemConstant.FIGHT_ELE_WOOD)//火克木
				|| (attEle == SystemConstant.FIGHT_ELE_WOOD && defEle == SystemConstant.FIGHT_ELE_WATER)//木克水
				|| (attEle == SystemConstant.FIGHT_ELE_WATER && defEle == SystemConstant.FIGHT_ELE_FIRE)//水克火
				|| (attEle == SystemConstant.FIGHT_ELE_LIGHT && defEle == SystemConstant.FIGHT_ELE_DARK)//光克暗
				|| (attEle == SystemConstant.FIGHT_ELE_DARK && defEle == SystemConstant.FIGHT_ELE_LIGHT)//暗克光
				){//克制
			hurt = SystemConstant.FIGHT_RESTRAINT[attEleLevel-1][0];
		}else if((attEle == SystemConstant.FIGHT_ELE_WOOD && defEle == SystemConstant.FIGHT_ELE_FIRE)//木被火克
				|| (attEle == SystemConstant.FIGHT_ELE_WATER && defEle == SystemConstant.FIGHT_ELE_WOOD)//水被木克
				|| (attEle == SystemConstant.FIGHT_ELE_FIRE && defEle == SystemConstant.FIGHT_ELE_WATER)//火被水克
				){//被克
			hurt = SystemConstant.FIGHT_RESTRAINT[defEleLevel-1][1];
		}
		return hurt;
	}
	/**
	 * 获得防守方攻击模型
	 * @param atkModel 攻击模型
	 * @return 防守方攻击模型
	 */
	public static final String getDetAtkModel(String atkModel){
		char[] cs = new char[atkModel.length()];
		for(int i=0;i<atkModel.length();i++){
			cs[i]=atkModel.charAt(SystemConstant.FIGHT_DEF_ATK_MODEL[i]);
		}
		return new String(cs);
	}
	
	public int getHeroId() {
		return heroId;
	}
	public void setHeroId(int heroId) {
		this.heroId = heroId;
	}
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
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
	public int getMaxLevel() {
		return maxLevel;
	}
	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}
	public double getHp() {
		return hp;
	}
	public void setHp(double hp) {
		this.hp = hp;
	}
	public double getHpUp() {
		return hpUp;
	}
	public void setHpUp(double hpUp) {
		this.hpUp = hpUp;
	}
	public double getAtk() {
		return atk;
	}
	public void setAtk(double atk) {
		this.atk = atk;
	}
	public double getAtkUp() {
		return atkUp;
	}
	public void setAtkUp(double atkUp) {
		this.atkUp = atkUp;
	}
	public int getAtkCount() {
		return atkCount;
	}
	public void setAtkCount(int atkCount) {
		this.atkCount = atkCount;
	}
	public int getCritRate() {
		return critRate;
	}
	public void setCritRate(int critRate) {
		this.critRate = critRate;
	}
	public int getCritHit() {
		return critHit;
	}
	public void setCritHit(int critHit) {
		this.critHit = critHit;
	}
	public int getDodgeRate() {
		return dodgeRate;
	}
	public void setDodgeRate(int dodgeRate) {
		this.dodgeRate = dodgeRate;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public int getCapSkillId() {
		return capSkillId;
	}
	public void setCapSkillId(int capSkillId) {
		this.capSkillId = capSkillId;
	}
	public String getAtkMode() {
		return atkMode;
	}
	public void setAtkMode(String atkMode) {
		this.atkMode = atkMode;
	}
	public int getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}
	public int getGiveExp() {
		return giveExp;
	}
	public void setGiveExp(int giveExp) {
		this.giveExp = giveExp;
	}
	public String getMoveMode() {
		return moveMode;
	}
	public void setMoveMode(String moveMode) {
		this.moveMode = moveMode;
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
	public int getRareDegree() {
		return rareDegree;
	}
	public void setRareDegree(int rareDegree) {
		this.rareDegree = rareDegree;
	}
	public List<Integer> getPassiveSkills() {
		return passiveSkills;
	}
	public void setPassiveSkills(List<Integer> passiveSkills) {
		this.passiveSkills = passiveSkills;
	}
	public int getBlockHit() {
		return blockHit;
	}
	public void setBlockHit(int blockHit) {
		this.blockHit = blockHit;
	}
	public int getBreakGroup() {
		return breakGroup;
	}
	public void setBreakGroup(int breakGroup) {
		this.breakGroup = breakGroup;
	}
	public int getBreakAttrGroup() {
		return breakAttrGroup;
	}
	public void setBreakAttrGroup(int breakAttrGroup) {
		this.breakAttrGroup = breakAttrGroup;
	}
	
	/**
	 * 获取当前等级英雄hp
	 * @param level
	 * @return
	 */
	public int getTotalHp(int level){
		return (int) (hp+hpUp*(level-1));
	}
	
	/**
	 * 获取当前等级英雄攻击
	 * @param level
	 * @return
	 */
	public int getTotalAtk(int level){
		return (int) (atk+atkUp*(level-1));
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPassiveSkillStr() {
		return passiveSkillStr;
	}
	public void setPassiveSkillStr(String passiveSkillStr) {
		this.passiveSkillStr = passiveSkillStr;
		this.passiveSkills = StringUtil.stringToList(passiveSkillStr);
	}
}
