package com.ks.protocol.vo.data;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.ks.data.DataSet;
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
import com.ks.protocol.vo.user.UserRecordVO;
import com.ks.protocol.vo.user.UserStatVO;
import com.ks.protocol.vo.user.UserVO;

@EqualsAndHashCode(callSuper=true)
@Data
public class DataSetVO extends Message {
	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="玩家数据")
	private UserVO user;
	@FieldDesc(desc="用户统计")
	private UserStatVO userStat;
	@FieldDesc(desc="用户记录")
	private UserRecordVO userRecord;
	@FieldDesc(desc="伙伴")
	private List<UserHeroVO> heros;
	@FieldDesc(desc="道具")
	private List<UserPropVO> props;
	@FieldDesc(desc="装备")
	private List<UserEquipmentVO> equips;
	@FieldDesc(desc="武魂")
	private List<UserEternalVO> eternals;
	@FieldDesc(desc="删除的伙伴ID")
	private List<Integer> deleteHeroIds;
	@FieldDesc(desc="删除的装备ID")
	private List<Integer> deleteEquipIds;
	@FieldDesc(desc="删除的武魂ID")
	private List<Integer> deleteEternalIds;
	
	public void init(DataSet set){
		if(set.getUser() != null){
			user = MessageFactory.getMessage(UserVO.class);
			user.init(set.getUser());
		}
		if(set.getUserStat() != null){
			userStat = MessageFactory.getMessage(UserStatVO.class);
			userStat.init(set.getUserStat());
		}
		if(set.getUserRecord()!= null){
			userRecord = MessageFactory.getMessage(UserRecordVO.class);
			userRecord.init(set.getUserRecord());
		}
		heros = new ArrayList<UserHeroVO>();
		for(UserHero hero : set.getHeros()){
			UserHeroVO vo = MessageFactory.getMessage(UserHeroVO.class);
			vo.init(hero);
			heros.add(vo);
		}
		props = new ArrayList<UserPropVO>();
		for(UserProp prop : set.getProps()){
			UserPropVO vo = MessageFactory.getMessage(UserPropVO.class);
			vo.init(prop);
			props.add(vo);
		}
		equips = new ArrayList<UserEquipmentVO>();
		for(UserEquipment equip : set.getEquips()){
			UserEquipmentVO vo = MessageFactory.getMessage(UserEquipmentVO.class);
			vo.init(equip);
			equips.add(vo);
		}
		eternals = new ArrayList<UserEternalVO>();
		for(UserEternal eternal : set.getEternals()){
			UserEternalVO vo = MessageFactory.getMessage(UserEternalVO.class);
			vo.init(eternal);
			eternals.add(vo);
		}
		deleteHeroIds = set.getDeleteHeroIds();
		deleteEquipIds = set.getDeleteEquipIds();
		deleteEternalIds =  set.getDeleteEternalIds();
	}
	
	
}
