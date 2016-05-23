package com.ks.protocol.vo.user;

import com.ks.db.model.User;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 用户
 * @author ks
 *
 */
public class UserVO extends Message {
	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="用户编号")
	private int userId;
	@FieldDesc(desc="用户名")
	private String username;
	@FieldDesc(desc="合作方编号")
	private int partner;
	@FieldDesc(desc="玩家名")
	private String playerName;
	@FieldDesc(desc="金币")
	private int gold;
	@FieldDesc(desc="钻石")
	private int diamond;
	@FieldDesc(desc="英雄容量")
	private int heroCapacity;
	@FieldDesc(desc="战斗编号")
	private String fightId;
	@FieldDesc(desc="等级")
	private int level;
	@FieldDesc(desc="经验")
	private int exp;
	@FieldDesc(desc="增加的经验池上限")
	private int addExpPool;
	@FieldDesc(desc="体力")
	private int stamina;
	@FieldDesc(desc="神之召唤点")
	private int gp;
	@FieldDesc(desc="最后恢体时间")
	private long lastRegainStaminaTime;
	@FieldDesc(desc="累计充值")
	private int chargeDiamond;
	@FieldDesc(desc="英雄经验池")
	private int heroExpPool;
	@FieldDesc(desc="装备容量")
	private int equipmentCapacity;
	@FieldDesc(desc="武魂容量")
	private int eternalCapacity;
	@FieldDesc(desc="剧情步骤")
	private int plotStep;
	@FieldDesc(desc="新手步骤")
	private int guideStep;
	@FieldDesc(desc="功能解锁")
	private int funUnlock;
	@FieldDesc(desc="名望")
	private int fame;
	@FieldDesc(desc="石板")
	private int slate;
	@FieldDesc(desc="vip等级")
	private int vip;
	public void init(User o){
		this.userId = o.getUserId();
		this.username = o.getUsername();
		this.partner = o.getPartner();
		this.playerName = o.getPlayerName();
		this.gold = o.getGold();
		this.diamond = o.getDiamond();
		this.heroCapacity = o.getHeroCapacity();
		this.fightId = o.getFightId();
		this.level = o.getLevel();
		this.exp = o.getExp();
		this.addExpPool = o.getAddExpPool();
		this.stamina = o.getStamina();
		this.gp = o.getGp();
		this.lastRegainStaminaTime = o.getLastRegainStaminaTime().getTime();
		this.chargeDiamond = o.getChargeDiamond();
		this.heroExpPool = o.getHeroExpPool();
		this.equipmentCapacity = o.getEquipmentCapacity();
		this.eternalCapacity = o.getEternalCapacity();
		this.plotStep = o.getPlotStep();
		this.guideStep = o.getGuideStep();
		this.funUnlock = o.getFunUnlock();
		this.fame = o.getFame();
		this.slate = o.getSlate();
		this.vip = o.getVip();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPartner() {
		return partner;
	}
	public void setPartner(int partner) {
		this.partner = partner;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public int getDiamond() {
		return diamond;
	}
	public void setDiamond(int diamond) {
		this.diamond = diamond;
	}
	public int getHeroCapacity() {
		return heroCapacity;
	}
	public void setHeroCapacity(int heroCapacity) {
		this.heroCapacity = heroCapacity;
	}
	public String getFightId() {
		return fightId;
	}
	public void setFightId(String fightId) {
		this.fightId = fightId;
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
	public int getStamina() {
		return stamina;
	}
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	public int getGp() {
		return gp;
	}
	public void setGp(int gp) {
		this.gp = gp;
	}
	public long getLastRegainStaminaTime() {
		return lastRegainStaminaTime;
	}
	public void setLastRegainStaminaTime(long lastRegainStaminaTime) {
		this.lastRegainStaminaTime = lastRegainStaminaTime;
	}
	public int getChargeDiamond() {
		return chargeDiamond;
	}
	public void setChargeDiamond(int chargeDiamond) {
		this.chargeDiamond = chargeDiamond;
	}
	public int getHeroExpPool() {
		return heroExpPool;
	}
	public void setHeroExpPool(int heroExpPool) {
		this.heroExpPool = heroExpPool;
	}
	public int getEquipmentCapacity() {
		return equipmentCapacity;
	}
	public void setEquipmentCapacity(int equipmentCapacity) {
		this.equipmentCapacity = equipmentCapacity;
	}
	public int getEternalCapacity() {
		return eternalCapacity;
	}
	public void setEternalCapacity(int eternalCapacity) {
		this.eternalCapacity = eternalCapacity;
	}
	public int getAddExpPool() {
		return addExpPool;
	}
	public void setAddExpPool(int addExpPool) {
		this.addExpPool = addExpPool;
	}
	public int getPlotStep() {
		return plotStep;
	}
	public void setPlotStep(int plotStep) {
		this.plotStep = plotStep;
	}
	public int getGuideStep() {
		return guideStep;
	}
	public void setGuideStep(int guideStep) {
		this.guideStep = guideStep;
	}
	public int getFunUnlock() {
		return funUnlock;
	}
	public void setFunUnlock(int funUnlock) {
		this.funUnlock = funUnlock;
	}
	public int getFame() {
		return fame;
	}
	public void setFame(int fame) {
		this.fame = fame;
	}
	public int getSlate() {
		return slate;
	}
	public void setSlate(int slate) {
		this.slate = slate;
	}
	public int getVip(){
		return vip;
	}
	public void setVip(int vip){
		this.vip = vip;
	}
	
}