package com.ks.protocol.vo.user;

import com.ks.db.model.User;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 用户简单信息
 * @author ks
 */
public class UserSimpleInfoVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="等级")
	private int level;
	@FieldDesc(desc="经验")
	private int exp;
	@FieldDesc(desc="替补统治力")
	private int addExpPool;
	@FieldDesc(desc="体力")
	private int stamina;
	@FieldDesc(desc="金币")
	private int gold;
	@FieldDesc(desc="钻石")
	private int diamond;
	@FieldDesc(desc="英雄容量")
	private int heroCapacity;
	@FieldDesc(desc="神之召唤点")
	private int gp;
	@FieldDesc(desc="最后恢体时间")
	private long lastRegainStaminaTime;
	@FieldDesc(desc="累计充值")
	private int chargeDiamond;
	@FieldDesc(desc="名望")
	private int fame;
	@FieldDesc(desc="石板")
	private int slate;
	
	public void init(User o){
		this.level = o.getLevel();
		this.exp = o.getExp();
		this.addExpPool = o.getAddExpPool();
		this.stamina = o.getStamina();
		this.gold = o.getGold();
		this.diamond = o.getDiamond();
		this.heroCapacity = o.getHeroCapacity();
		this.gp = o.getGp();
		this.lastRegainStaminaTime = o.getLastRegainStaminaTime().getTime();
		this.chargeDiamond = o.getChargeDiamond();
		this.fame = o.getFame();
		this.slate = o.getSlate();
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
	public int getAddExpPool() {
		return addExpPool;
	}
	public void setAddExpPool(int addExpPool) {
		this.addExpPool = addExpPool;
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
	
	
}
