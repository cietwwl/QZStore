package com.ks.logic.event.task;

import com.ks.db.model.User;
import com.ks.model.task.constant.ConstEventNames;
/**
 * 强化装备事件
 * @author hanjie.l
 *
 */
public class LevelUpEquipEvent extends AbstractTaskEvent{

	public LevelUpEquipEvent(User user) {
		super(user);
	}

	@Override
	public String getEventName() {
		return ConstEventNames.LEVELUP_EQUIP;
	}
	
	/**
	 * 装备升级
	 * @param user
	 * @param equipId
	 * @param level
	 * @param upLevel
	 * @param count
	 * 		装备升级1次提升等级不一定是1级，所以count！=upLevel
	 * @return
	 */
	public static LevelUpEquipEvent valueOf(User user, int equipId, int level, int upLevel, int count){
		LevelUpEquipEvent event = new LevelUpEquipEvent(user);
		event.getContext().put("equipId", equipId);
		event.getContext().put("level", level);
		event.getContext().put("upLevel", upLevel);
		event.getContext().put("count", count);
		return event;
	}

	@Override
	public boolean mayBringNewTask() {
		return false;
	}

}
