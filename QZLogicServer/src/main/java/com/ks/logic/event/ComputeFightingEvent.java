package com.ks.logic.event;

import com.ks.event.GameEvent;
import com.ks.logic.service.FightService;
import com.ks.logic.service.ServiceFactory;
import com.ks.manager.ClientLockManager;
import com.ks.util.LockKeyUtil;

public class ComputeFightingEvent extends GameEvent {
	
	private int userId;
	public ComputeFightingEvent(int userId) {
		this.userId = userId;
	}

	@Override
	public void runEvent() throws Exception {
		FightService fightService = ServiceFactory.getService(FightService.class);
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(userId));
		try{
			fightService.computeFighting(userId);
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
}
