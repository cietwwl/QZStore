package com.ks.logic.event.task;

import com.ks.db.model.User;
import com.ks.model.task.constant.ConstEventNames;

/**
 * vip升级事件
 * @author hanjie.l
 *
 */
public class VipLevelUpEvent extends AbstractTaskEvent{

	public VipLevelUpEvent(User user) {
		super(user);
	}

	@Override
	public String getEventName() {
		return ConstEventNames.VIPLEVEL_UP;
	}

	public static VipLevelUpEvent valueOf(User user, int oldLevel, int newLevel){
		VipLevelUpEvent event = new VipLevelUpEvent(user);
		event.getContext().put("oldLevel", oldLevel);
		event.getContext().put("newLevel", newLevel);
		return event;
	}

	@Override
	public boolean mayBringNewTask() {
		return true;
	}
}
