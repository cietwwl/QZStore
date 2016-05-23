package com.ks.protocol.vo.fight;

import java.util.List;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.vo.equment.UserEquipmentVO;
import com.ks.protocol.vo.hero.UserHeroVO;
import com.ks.protocol.vo.prop.UserPropVO;
/**
 * 战斗结果
 * @author ks
 */
public class FightResultVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="获得的英雄")
	private List<UserHeroVO> heros;
	@FieldDesc(desc="获得的道具")
	private List<UserPropVO> props;
	@FieldDesc(desc="获得的装备")
	private List<UserEquipmentVO> equips;
	@FieldDesc(desc="获得的经验")
	private int exp;
	@FieldDesc(desc="获得的金钱")
	private int gold;
	@FieldDesc(desc="总金钱")
	private int totleGold;
	@FieldDesc(desc="星级")
	private int star;
	@FieldDesc(desc="熔炼点数")
	private int smeltingPoint;
	@FieldDesc(desc="英雄经验")
	private int heroExp;
	
	public List<UserHeroVO> getHeros() {
		return heros;
	}
	public void setHeros(List<UserHeroVO> heros) {
		this.heros = heros;
	}
	public List<UserPropVO> getProps(){
		return props;
	}
	public void setProps(List<UserPropVO> props){
		this.props = props;
	}
	public List<UserEquipmentVO> getEquips(){
		return equips;
	}
	public void setEquips(List<UserEquipmentVO> equips){
		this.equips = equips;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public int getTotleGold() {
		return totleGold;
	}
	public void setTotleGold(int totleGold) {
		this.totleGold = totleGold;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public int getSmeltingPoint() {
		return smeltingPoint;
	}

	public void setSmeltingPoint(int smeltingPoint) {
		this.smeltingPoint = smeltingPoint;
	}

	public int getHeroExp() {
		return heroExp;
	}

	public void setHeroExp(int heroExp) {
		this.heroExp = heroExp;
	}
	
}
