package com.ks.logic.event;

import com.ks.event.GameEvent;
import com.ks.logic.service.ServiceFactory;
import com.ks.logic.service.UserService;

/**
 * 重新加载战力事件
 * @author zck
 *
 */
public class ReloadFightingCacheEvent extends GameEvent {

	@Override
	public void runEvent() throws Exception {
		UserService userService = ServiceFactory.getService(UserService.class);
		userService.reloadUserFightingCache();
	}

}
