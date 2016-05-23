package com.ks.protocol.vo.goods;

import java.util.List;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.vo.equment.UserEquipmentVO;
import com.ks.protocol.vo.eternal.UserEternalVO;
import com.ks.protocol.vo.hero.UserHeroVO;
import com.ks.protocol.vo.prop.UserPropVO;
/**
 * 获得奖励
 * @author ks
 */
public abstract class GainAwardVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="英雄")
	private List<UserHeroVO> heros;
	@FieldDesc(desc="受影响的道具")
	private List<UserPropVO> props;
	@FieldDesc(desc="装备")
	private List<UserEquipmentVO> equipments;
	@FieldDesc(desc="武魂")
	private List<UserEternalVO> enternals;
	public List<UserEternalVO> getEnternals() {
		return enternals;
	}
	public void setEnternals(List<UserEternalVO> enternals) {
		this.enternals = enternals;
	}
	public List<UserHeroVO> getHeros() {
		return heros;
	}
	public void setHeros(List<UserHeroVO> heros) {
		this.heros = heros;
	}
	public List<UserPropVO> getProps() {
		return props;
	}
	public void setProps(List<UserPropVO> props) {
		this.props = props;
	}
	public List<UserEquipmentVO> getEquipments() {
		return equipments;
	}
	public void setEquipments(List<UserEquipmentVO> equipments) {
		this.equipments = equipments;
	}
}
