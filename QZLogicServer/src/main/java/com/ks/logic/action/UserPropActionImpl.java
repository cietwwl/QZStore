package com.ks.logic.action;

import java.util.List;

import com.ks.action.logic.UserPropAction;
import com.ks.db.model.UserProp;
import com.ks.logic.service.ServiceFactory;
import com.ks.logic.service.UserPropService;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.prop.SellPropVO;
import com.ks.protocol.vo.prop.UserPropVO;
import com.ks.protocol.vo.reward.RewardVO;

public class UserPropActionImpl implements UserPropAction {
	
	private static final UserPropService userPropService = ServiceFactory.getService(UserPropService.class);
	
	@Override
	public UserPropVO useProp(int userId, int propId, int amount) {
		UserProp prop = userPropService.useProp(userId, propId, amount);
		UserPropVO vo = MessageFactory.getMessage(UserPropVO.class);
		vo.init(prop);
		return vo;
	}

	@Override
	public void sellProp(int userId, List<SellPropVO> sellProps) {
		userPropService.sellProp(userId, sellProps);
	}
	
	@Override
	public RewardVO openBox(int userId, int propId){
		return userPropService.openBox(userId, propId);
	}
}
