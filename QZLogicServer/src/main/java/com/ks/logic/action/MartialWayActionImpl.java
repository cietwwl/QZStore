package com.ks.logic.action;

import com.ks.action.logic.MartialWayAction;
import com.ks.logic.service.MartialWayService;
import com.ks.logic.service.ServiceFactory;
import com.ks.model.martial.MartialWay;
import com.ks.protocol.vo.martial.MartialWayRankVO;
import com.ks.protocol.vo.martial.MartialWayUserVO;
import com.ks.protocol.vo.martial.MartialWayVO;

public class MartialWayActionImpl implements MartialWayAction {
	
	private static final MartialWayService service = ServiceFactory.getService(MartialWayService.class);
	
	@Override
	public MartialWayVO enterMartialWay(int userId) {
		return service.enterMartialWay(userId);
	}
	
	@Override
	public MartialWay mach(int userId) {
		return service.math(userId);
	}
	
//	@Override
//	public void mathSucee(List<Integer> userIds) {
//		service.mathSucee(userIds);
//	}

	@Override
	public MartialWayUserVO gainMartialWayUser(int userId) {
		return service.gainMartialWayUser(userId);
	}

	@Override
	public void buyMartialWayCount(int userId) {
		service.buyMartialWayCount(userId);
	}

	@Override
	public MartialWayRankVO getMartialWayRank(int userId, int page) {
		return service.getMartialWayRank(userId, page);
	}

	@Override
	public void gainAward() {
		service.gainAward();
	}

}
