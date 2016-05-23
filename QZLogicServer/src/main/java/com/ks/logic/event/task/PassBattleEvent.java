package com.ks.logic.event.task;

import com.ks.constant.SystemConstant;
import com.ks.db.model.User;
import com.ks.model.task.constant.ConstEventNames;
/**
 * 通过游戏关卡事件
 * @author hanjie.l
 *
 */
public class PassBattleEvent extends AbstractTaskEvent {

	public PassBattleEvent(User user) {
		super(user);
	}

	@Override
	public String getEventName() {
		return ConstEventNames.PASS_BATTLE;
	}
	
	/**
	 * 
	 * @param user
	 * @param type  1正常通关， 2扫荡
	 * @param battleId
	 * @param count
	 * @param zoneType 副本类型 {@link SystemConstant#ZONE_TYPE_ELITE}
	 * @return
	 */
	public static PassBattleEvent valueOf(User user,int type, int battleId, int count, int zoneType){
		PassBattleEvent event = new PassBattleEvent(user);
		event.getContext().put("type", type);
		event.getContext().put("battleId", battleId);
		event.getContext().put("count", count);
		event.getContext().put("zoneType", zoneType);
		return event;
	}

	@Override
	public boolean mayBringNewTask() {
		return false;
	}

}
