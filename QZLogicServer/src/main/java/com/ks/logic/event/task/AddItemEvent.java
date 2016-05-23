package com.ks.logic.event.task;

import com.ks.db.model.User;
import com.ks.model.task.constant.ConstEventNames;

/**
 * 获得道具事件
 * @author hanjie.l
 *
 */
public class AddItemEvent extends AbstractTaskEvent{

	public AddItemEvent(User user) {
		super(user);
	}

	@Override
	public String getEventName() {
		return ConstEventNames.ADD_ITEM;
	}
	
	public static AddItemEvent valueOf(User user, int goodsId, int num){
		AddItemEvent event = new AddItemEvent(user);
		event.getContext().put("goodsId", goodsId);
		event.getContext().put("num", num);
		return event;
	}

	@Override
	public boolean mayBringNewTask() {
		return false;
	}

}
