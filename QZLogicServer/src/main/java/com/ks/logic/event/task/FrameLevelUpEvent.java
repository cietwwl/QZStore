package com.ks.logic.event.task;

import com.ks.db.model.User;
import com.ks.model.task.constant.ConstEventNames;

/**
 * 提升名望事件
 * @author hanjie.l
 *
 */
public class FrameLevelUpEvent  extends AbstractTaskEvent{

	public FrameLevelUpEvent(User user) {
		super(user);
	}

	@Override
	public String getEventName() {
		return ConstEventNames.FRAME_LEVELUP;
	}

	/**
	 * 提升名望事件
	 * @return
	 */
	public static FrameLevelUpEvent valueOf(User user, int frameLevel){
		FrameLevelUpEvent event = new FrameLevelUpEvent(user);
		event.getContext().put("frameLevel", frameLevel);
		return event;
	}

	@Override
	public boolean mayBringNewTask() {
		return true;
	}
}
