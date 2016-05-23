package com.ks.logic.event.task;

import com.ks.db.model.User;
import com.ks.model.task.constant.ConstEventNames;
/**
 * 英雄升级事件
 * @author hanjie.l
 *
 */
public class HeroLevelUpEvent extends AbstractTaskEvent{

	public HeroLevelUpEvent(User user) {
		super(user);
	}

	@Override
	public String getEventName() {
		return ConstEventNames.HERO_LEVELUP;
	}
	
	/**
	 * 英雄升级
	 * @param user
	 * @param heroId
	 * @param level
	 * @param upLevel
	 * @param count
	 *		在英雄升级功能中，提升1次英雄必定是升1级，所以count==upLevel
	 * @return
	 */
	public static HeroLevelUpEvent valueOf(User user, int heroId, int level, int upLevel, int count){
		HeroLevelUpEvent event = new HeroLevelUpEvent(user);
		event.getContext().put("heroId", heroId);
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
