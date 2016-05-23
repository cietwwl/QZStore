package com.ks.logic.action;

import java.util.ArrayList;
import java.util.List;

import com.ks.action.logic.UserAchieveAction;
import com.ks.db.model.UserAchieve;
import com.ks.logic.service.ServiceFactory;
import com.ks.logic.service.UserAchieveService;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.achieve.UserAchieveVO;
import com.ks.protocol.vo.goods.GainGameAwardVO;

public class UserAchieveActionImpl implements UserAchieveAction {
	
	private static final UserAchieveService userAchieveService = ServiceFactory.getService(UserAchieveService.class);
	@Override
	public List<UserAchieveVO> queryUserAchieve(int userId) {
		List<UserAchieve> uas = userAchieveService.queryUserAchieve(userId);
		List<UserAchieveVO> vos = new ArrayList<UserAchieveVO>();
		for(UserAchieve ua : uas){
			UserAchieveVO vo = MessageFactory.getMessage(UserAchieveVO.class);
			vo.init(ua);
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public GainGameAwardVO gainAchieveAward(int userId, int achieveId) {
		return userAchieveService.gainAchieveAward(userId, achieveId);
	}

}
