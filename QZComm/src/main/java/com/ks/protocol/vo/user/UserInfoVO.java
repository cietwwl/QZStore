package com.ks.protocol.vo.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.ks.db.model.User;
import com.ks.db.model.UserEquipment;
import com.ks.db.model.UserEternal;
import com.ks.db.model.UserHero;
import com.ks.db.model.UserProp;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.equment.UserEquipmentVO;
import com.ks.protocol.vo.eternal.UserEternalVO;
import com.ks.protocol.vo.hero.UserHeroVO;
import com.ks.protocol.vo.prop.UserPropVO;
/**
 * 用户信息
 * @author ks
 */
@EqualsAndHashCode(callSuper=true)
@Data
public class UserInfoVO extends Message {
	
	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="用户")
	private UserVO user;
	@FieldDesc(desc="英雄")
	private List<UserHeroVO> heros;
	@FieldDesc(desc="道具")
	private List<UserPropVO> props;
	@FieldDesc(desc="装备")
	private List<UserEquipmentVO> equipments;
	@FieldDesc(desc="武魂")
	private List<UserEternalVO> eternals;
	@FieldDesc(desc="首充支付ids")
	private List<Integer> firstRechangeIds;
	
	public void init(User u,Collection<UserHero> hs,Collection<UserProp> userProps,Collection<UserEquipment> eqs, Collection<UserEternal> eternals, List<Integer> firstRechangeIds){
		user = MessageFactory.getMessage(UserVO.class);
		user.init(u);
		this.heros = new ArrayList<UserHeroVO>();
		for(UserHero us : hs){
			UserHeroVO vo = MessageFactory.getMessage(UserHeroVO.class);
			vo.init(us);
			heros.add(vo);
		}
		this.props = new ArrayList<UserPropVO>();
		for(UserProp up : userProps){
			if(up.getNum()>0){
				UserPropVO vo = MessageFactory.getMessage(UserPropVO.class);
				vo.init(up);
				props.add(vo);
			}
		}
		this.equipments = new ArrayList<UserEquipmentVO>();
		for(UserEquipment ue : eqs){
			UserEquipmentVO vo = MessageFactory.getMessage(UserEquipmentVO.class);
			vo.init(ue);
			equipments.add(vo);
		}
		this.eternals = new ArrayList<UserEternalVO>();
		for(UserEternal eternal : eternals){
			UserEternalVO vo = MessageFactory.getMessage(UserEternalVO.class);
			vo.init(eternal);
			this.eternals.add(vo);
		}
		if(firstRechangeIds != null){
			this.firstRechangeIds = firstRechangeIds;
		}else{
			this.firstRechangeIds = new ArrayList<Integer>();
		}
	}
}
