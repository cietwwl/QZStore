package com.ks.logic.event.task;

import com.ks.db.model.User;
import com.ks.model.task.constant.ConstEventNames;
/**
 * 召唤英雄事件
 * @author hanjie.l
 *
 */
public class CallHeroEvent extends AbstractTaskEvent{

	public CallHeroEvent(User user) {
		super(user);
	}

	@Override
	public String getEventName() {
		return ConstEventNames.CALL_HERO;
	}
	
	/**
	 * 召唤事件
	 * @param userId
	 * @param count
	 * @param type 	1金币召唤
	 * 				2钻石召唤
	 * 				3金币免费召唤
	 * 				4钻石免费召唤
	 * @return
	 */
	public static CallHeroEvent valueOf(User user, int count, int type){
		CallHeroEvent event = new CallHeroEvent(user);
		event.getContext().put("count", count);
		event.getContext().put("type", type);
		return event;
	}

	@Override
	public boolean mayBringNewTask() {
		return false;
	}

}
