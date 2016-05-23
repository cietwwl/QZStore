package com.ks.logic.action;

import java.util.List;
import com.ks.action.logic.UserEternalAction;
import com.ks.logic.service.ServiceFactory;
import com.ks.logic.service.UserEternalService;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.eternal.UserEternalVO;
import com.ks.protocol.vo.prop.EternalSmeltingVO;
import com.ks.protocol.vo.prop.SmeltingVO;

public class UserEternalActionImpl implements UserEternalAction {
	
	private static final UserEternalService userEternalService = ServiceFactory.getService(UserEternalService.class);
	
	@Override
	public List<UserEternalVO> gainUserEternal(int userId) {
		return userEternalService.gainUserEternal(userId);
	}

	@Override
	public void wearEternal(int userId, int userEternalId, int userHeroId) {
		userEternalService.wearEternal(userId, userEternalId, userHeroId);
	}

	@Override
	public void disEternal(int userId, int userHeroId, boolean retain) {
		userEternalService.disEternal(userId, userHeroId, retain);
	}

	@Override
	public List<EternalSmeltingVO> gainEternalSmeltings(int userId) {
		return userEternalService.gainEternalSmeltings(userId);
	}

	@Override
	public SmeltingVO eternal(int userId, int type,
			List<Integer> equipmentIds,List<Integer> eternalIds) {
		return userEternalService.eternal(userId, type, equipmentIds,eternalIds);
	}

	@Override
	public UserEternalVO blowing(int userId, int type) {
		UserEternalVO vo = MessageFactory.getMessage(UserEternalVO.class);
		vo.init(userEternalService.blowing(userId, type));
		return vo;
	}

	@Override
	public void sellEternal(int userId, int userEternalId) {
		userEternalService.sellEternal(userId, userEternalId);
	}

}
