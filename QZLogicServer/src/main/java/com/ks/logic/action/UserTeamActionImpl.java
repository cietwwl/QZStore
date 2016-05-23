package com.ks.logic.action;

import com.ks.action.logic.UserTeamAction;
import com.ks.db.model.UserTeam;
import com.ks.logic.service.ServiceFactory;
import com.ks.logic.service.UserTeamService;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.user.UserTeamVO;

public class UserTeamActionImpl implements UserTeamAction {
	
	private static final UserTeamService userTeamService = ServiceFactory.getService(UserTeamService.class);
	@Override
	public UserTeamVO queryUserTeam(int userId) {
		UserTeam team = userTeamService.queryUserTeam(userId);
		UserTeamVO vo = MessageFactory.getMessage(UserTeamVO.class);
		vo.init(team);
		return vo;
	}

	@Override
	public void updateUserTeam(int userId, UserTeamVO vo) {
		userTeamService.updateUserTeam(userId, vo);
	}

}
