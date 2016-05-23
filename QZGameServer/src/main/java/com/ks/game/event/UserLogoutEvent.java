package com.ks.game.event;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.ks.action.logic.PlayerAction;
import com.ks.action.world.LoginAction;
import com.ks.app.Application;
import com.ks.event.GameEvent;
import com.ks.game.model.Player;
import com.ks.logger.LoggerFactory;
import com.ks.manager.ClientLockManager;
import com.ks.manager.PlayerManager;
import com.ks.rpc.RPCKernel;
import com.ks.timer.TimerController;
import com.ks.timer.task.BaseTask;
import com.ks.util.LockKeyUtil;
/**
 * 用户登出事件
 * @author ks
 */
public class UserLogoutEvent extends GameEvent {
	
	private static final Logger logger = LoggerFactory.get(UserLogoutEvent.class);
	
	private Player player;
	private int count = 0;
	public UserLogoutEvent(Player player) {
		super();
		this.player = player;
	}
	@Override
	public void runEvent() {
		player.lock();
		try{
			ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
			try{
				if(PlayerManager.getOnlinePlayer(player.getSessionId())==null){
					return;
				}
				
				LoginAction action = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, LoginAction.class);
				if(!action.logout(player.getUserId())){
					TimerController.register(new ReLoginOutTask(this));
					return;
				}
				
				PlayerAction playerAction = RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, PlayerAction.class);
				playerAction.logout(player.getUserId());
				
				PlayerManager.removeOnlinePlayer(player.getSessionId());
			}finally{
				ClientLockManager.unlockThreadLock();
			}
		}catch(Exception e){
			if(count<5){
				count++;
				TimerController.execEvent(this);
			}
			logger.error("logout error",e);
		}finally{
			player.unlock();
		}
	}

}
class ReLoginOutTask extends BaseTask{
	private GameEvent event;
	public ReLoginOutTask(GameEvent event) {
		super();
		this.event = event;
		this.initialDelay = 10;
		this.unit = TimeUnit.SECONDS;
	}

	@Override
	public void runTask() {
		TimerController.execEvent(event);
	}
	
}