package com.ks.logic.event.task;

import com.ks.db.model.User;
import com.ks.model.task.constant.ConstEventNames;
/**
 * 玩家升级事件
 * @author hanjie.l
 *
 */
public class PlayerLevelUpEvent extends AbstractTaskEvent{

	public PlayerLevelUpEvent(User user) {
		super(user);
	}

	@Override
	public String getEventName() {
		return ConstEventNames.PLAYER_UPLEVEL;
	}
	
	public static PlayerLevelUpEvent valueOf(User user, int playerLevel){
		PlayerLevelUpEvent event = new PlayerLevelUpEvent(user);
		event.getContext().put("playerLevel", playerLevel);
		return event;
	}

	@Override
	public boolean mayBringNewTask() {
		return true;
	}

}
