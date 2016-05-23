package com.ks.logic.event.task;

import com.ks.db.model.User;
import com.ks.model.task.constant.ConstEventNames;
/**
 * 武道大会战斗事件
 * @author hanjie.l
 *
 */
public class MartialWayFightEvent extends AbstractTaskEvent{

	public MartialWayFightEvent(User user) {
		super(user);
	}

	@Override
	public String getEventName() {
		return ConstEventNames.MARTIALWAY_FIGHT;
	}
	
	
	public static MartialWayFightEvent valueOf(User user){
		MartialWayFightEvent event = new MartialWayFightEvent(user);
		return event;
	}

	@Override
	public boolean mayBringNewTask() {
		return false;
	}

}
