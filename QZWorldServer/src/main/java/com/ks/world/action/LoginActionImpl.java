package com.ks.world.action;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.locks.Lock;

import com.ks.action.game.LoginGameAction;
import com.ks.action.logic.PlayerAction;
import com.ks.action.world.LoginAction;
import com.ks.app.Application;
import com.ks.game.model.Player;
import com.ks.game.model.PlayerModel;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.login.LoginResultVO;
import com.ks.protocol.vo.login.LoginVO;
import com.ks.protocol.vo.login.RegisterVO;
import com.ks.rpc.RPCKernel;
import com.ks.rpc.ServerInfo;
import com.ks.world.kernel.OnlineBattleManager;
import com.ks.world.kernel.PlayerStaticInfo;
import com.ks.world.kernel.WorldServerCache;

public final class LoginActionImpl implements
		LoginAction {

	@Override
	public LoginResultVO userLogin(LoginVO loginVO) {
		PlayerModel model = PlayerModel.create(loginVO.getPartner(), loginVO.getUsername());
//		GameLockManager.getInstance().lockUser(model.getUsername(), model.getPartner());
//		try{
			Lock playerLock = WorldServerCache.getPlayerLock(model);
			playerLock.lock();
			try{
				PlayerStaticInfo info = WorldServerCache.getPlayerStaticInfoByUsername(model);
				Player player;
				LoginResultVO vo;
				if(info!=null){//重复登录
					vo = MessageFactory.getMessage(LoginResultVO.class);
					vo.setUserId(info.getUserId());
					
					player = new Player();
					player.setUserId(vo.getUserId());
					player.setUsername(info.getUsername());
					player.setPartner(loginVO.getPartner());
					
					LoginGameAction loginGameAction = RPCKernel.getRemoteByServerId(info.getGameServerId(), LoginGameAction.class);
					loginGameAction.repeatLogin(info.getSessionId());
					
					WorldServerCache.removePlayerStaticInfo(info.getUserId(), info.getPartner(), info.getUsername());
					WorldServerCache.decrementServerInfo(info.getGameServerId());
				}else{
					PlayerAction playerAction = RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, PlayerAction.class);
					vo = playerAction.userLogin(loginVO);
				}
				if(vo.getUserId()!=0){
					vo.setSessionId(UUID.randomUUID().toString());
					ServerInfo gameServerInfo = WorldServerCache.gainGameServerInfo();
					vo.setGameServerHost(gameServerInfo.getHost());
					vo.setGameServerPort(gameServerInfo.getPort());
					
					player = new Player();
					player.setUserId(vo.getUserId());
					player.setUsername(loginVO.getUsername());
					player.setPlayerName(vo.getPlayerName());
					player.setLastHeartTime(new Date());
					player.setSessionId(vo.getSessionId());
					player.setPartner(model.getPartner());
					
					LoginGameAction loginGameAction = RPCKernel.getRemoteByServerId(gameServerInfo.getServerId(), LoginGameAction.class);
					loginGameAction.addOnlinePlayer(vo.getSessionId(), player);
					
					WorldServerCache.incrementGameServerInfo(gameServerInfo.getServerId());
					WorldServerCache.addPlayerStaticInfo(player, gameServerInfo.getServerId(),vo.getSessionId(),info!=null?info.getBattleRoomId():"");
				}
				return vo;
			}finally{
				playerLock.unlock();
			}
//		}finally{
//			GameLockManager.getInstance().unlockThreadLock();
//		}
	}

	@Override
	public boolean logout(int userId){
		PlayerStaticInfo info = WorldServerCache.getPlayerStaticInfoByUserId(userId);
		if(info!=null){
			PlayerModel model = PlayerModel.create(info.getPartner(), info.getUsername());
			Lock playerLock = WorldServerCache.getPlayerLock(model);
			playerLock.lock();
			try{
				if(OnlineBattleManager.getManager().hasFight(info.getBattleRoomId())){
					return false;
				}
				
				WorldServerCache.removePlayerStaticInfo(userId, info.getPartner(), info.getUsername());
				WorldServerCache.decrementServerInfo(info.getGameServerId());
			}finally{
				playerLock.unlock();
			}
		}
		return true;
	}

	@Override
	public void userRegister(RegisterVO register) {
		PlayerModel model = PlayerModel.create(register.getPartner(), register.getUsername());
		Lock playerLock = WorldServerCache.getPlayerLock(model);
		playerLock.lock();
		try{
			PlayerAction playerAction = RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, PlayerAction.class);
			playerAction.userRegister(register);
		}finally{
			playerLock.unlock();
		}
	}

	@Override
	public boolean isOnline(int userId) {
		return WorldServerCache.getPlayerStaticInfoByUserId(userId)!=null;
	}
}