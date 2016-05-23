package com.ks.logic.event.task;

import com.ks.db.model.User;
import com.ks.model.task.constant.ConstEventNames;

/**
 * 竞技场战斗事件
 * @author hanjie.l
 *
 */
public class ArenaFightEvent extends AbstractTaskEvent{

	public ArenaFightEvent(User user) {
		super(user);
	}

	@Override
	public String getEventName() {
		return ConstEventNames.ARENA_FIGHT;
	}
	
	
	public static ArenaFightEvent valueOf(User user){
		ArenaFightEvent event = new ArenaFightEvent(user);
		return event;
	}

	@Override
	public boolean mayBringNewTask() {
		return false;
	}

}
