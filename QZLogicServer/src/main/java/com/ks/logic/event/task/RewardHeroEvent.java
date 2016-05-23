package com.ks.logic.event.task;

import com.ks.db.model.User;
import com.ks.model.task.constant.ConstEventNames;
/**
 * 获得英雄事件
 * @author hanjie.l
 *
 */
public class RewardHeroEvent extends AbstractTaskEvent {

	public RewardHeroEvent(User user) {
		super(user);
	}

	@Override
	public String getEventName() {
		return ConstEventNames.REWARD_HERO;
	}
	
	public static RewardHeroEvent valueOf(User user, int heroId){
		RewardHeroEvent event = new RewardHeroEvent(user);
		event.getContext().put("heroId", heroId);
		return event;
	}

	@Override
	public boolean mayBringNewTask() {
		return false;
	}

}
