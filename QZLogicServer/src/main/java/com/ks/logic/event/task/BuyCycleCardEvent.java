package com.ks.logic.event.task;

import com.ks.db.model.User;
import com.ks.model.task.constant.ConstEventNames;

/**
 * 购买月卡事件
 * @author hanjie.l
 *
 */
public class BuyCycleCardEvent extends AbstractTaskEvent{

	public BuyCycleCardEvent(User user) {
		super(user);
	}

	@Override
	public String getEventName() {
		return ConstEventNames.BUY_CYCLECARD;
	}
	
	public static BuyCycleCardEvent valueOf(User user){
		BuyCycleCardEvent event = new BuyCycleCardEvent(user);
		return event;
	}

	@Override
	public boolean mayBringNewTask() {
		return false;
	}

}
