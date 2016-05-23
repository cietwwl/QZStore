package com.ks.logic.action;

import java.util.ArrayList;
import java.util.List;

import com.ks.action.logic.UserBuffAction;
import com.ks.db.model.UserBuff;
import com.ks.logic.service.ServiceFactory;
import com.ks.logic.service.UserBuffService;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.user.UserBuffVO;

public class UserBuffActionImpl implements UserBuffAction {
	
	private static final UserBuffService userBuffService = ServiceFactory.getService(UserBuffService.class);
	
	@Override
	public List<UserBuffVO> gainUserBuffs(int userId) {
		List<UserBuff> buffs = userBuffService.gainUserBuffs(userId);
		List<UserBuffVO> vos = new ArrayList<>();
		for(UserBuff buff : buffs){
			UserBuffVO vo = MessageFactory.getMessage(UserBuffVO.class);
			vo.init(buff);
			vos.add(vo);
		}
		return vos;
	}
}
