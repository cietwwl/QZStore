package com.ks.logic.event;

import com.ks.constant.SystemConstant;
import com.ks.db.log.ActiveLogger;
import com.ks.db.log.GameLogger;
import com.ks.db.log.ZoneBattleLogger;
import com.ks.event.GameEvent;
import com.ks.logic.service.GameLoggerService;
import com.ks.logic.service.ServiceFactory;
import com.ks.util.XyTimeUtil;
/**
 * 游戏日志事件
 * @author ks
 */
public class GameLoggerEvent extends GameEvent {
	private int type;
	private Object logger;
	
	public GameLoggerEvent(int type, Object logger) {
		this.type = type;
		this.logger = logger;
	}

	@Override
	public void runEvent() {
		GameLoggerService service = ServiceFactory.getService(GameLoggerService.class);
		if(type == SystemConstant.LOG_EVENT_TYPE_GAME){
			service.addGameLogger((GameLogger)logger);
		}else if(type == SystemConstant.LOG_EVENT_TYPE_ACTICE){
			ActiveLogger activeLogger = (ActiveLogger) logger;
			if(activeLogger.getUid() > 0){
				int startTime = XyTimeUtil.getTimeOfSecond(0, 0, 0);
				int endTime = XyTimeUtil.getNowSecond();
				ActiveLogger oldLogger = service.queryActiveLogger(activeLogger.getUid(), activeLogger.getPartner(), startTime, endTime);
				if(oldLogger == null){
					oldLogger = service.queryActiveLogger(activeLogger.getUid(), activeLogger.getPartner(), startTime - XyTimeUtil.DAY_SECOND, endTime - XyTimeUtil.DAY_SECOND);
				}
				if(oldLogger != null && activeLogger.getTotalOnlineTime() > oldLogger.getTotalOnlineTime()){
					oldLogger.setTotalOnlineTime(activeLogger.getTotalOnlineTime());
					service.updateActiveLogger(oldLogger);
				}
			}
		}else if(type == SystemConstant.LOG_EVENT_TYPE_BATTLE){
			ZoneBattleLogger zoneBattleLogger = (ZoneBattleLogger) logger;
			if(zoneBattleLogger.getUserId() > 0){
				ZoneBattleLogger target = service.queryZoneBattleLogger(zoneBattleLogger.getUserId(), zoneBattleLogger.getZoneBattleId());
				if(target == null){
					service.addZoneBattleLogger(zoneBattleLogger);
				}else{
					boolean update = false;
					if(zoneBattleLogger.getBattleNum() > 0){
						target.setBattleNum(target.getBattleNum() + zoneBattleLogger.getBattleNum());
						update = true;
					}
					if(target.getFirstState() == 0 && zoneBattleLogger.getState() != 1){
						target.setFirstState(zoneBattleLogger.getState() == 3 ? 1 : 2);
						update = true;
					}
					if(target.getState() != 3 && target.getState() != zoneBattleLogger.getState()){
						target.setState(zoneBattleLogger.getState());
						update = true;
					}
					if(update){
						service.updateZoneBattleLogger(target);
					}
				}
			}
		}
	}

}

