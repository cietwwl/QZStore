package com.ks.game.action;

import java.util.Date;

import com.ks.action.game.GameFightAction;
import com.ks.action.logic.FightAction;
import com.ks.action.world.WorldFightAction;
import com.ks.app.Application;
import com.ks.constant.SystemConstant;
import com.ks.game.model.Player;
import com.ks.manager.PlayerManager;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.FightCMD;
import com.ks.protocol.vo.Head;
import com.ks.protocol.vo.user.ViewUserVO;
import com.ks.rpc.RPCKernel;

public class GameFightActionImpl implements GameFightAction {

	@Override
	public void againstFight(int userId,String againstUserUId,ViewUserVO viewUser) {
		Player player = PlayerManager.getOnlinePlayer(againstUserUId);
		player.lock();
		try{
			Head head = MessageFactory.getMessage(Head.class);
			head.init(MainCMD.FIGHT, FightCMD.REQUSTER_FIGHT);
			
			player.setAgainstType(SystemConstant.FIGHT_AGAINST_TYPE_接受者);
			player.setAgainstTime(new Date());
			player.setAgainstUserId(userId);
			
			Application.sendMessage(player.getGameHandler().getChannel(), head, viewUser);
		}finally{
			player.unlock();
		}
	}

	@Override
	public void cancelFight(String sessionId) {
		Player player = PlayerManager.getOnlinePlayer(sessionId);
		player.lock();
		try{
			player.setAgainstType(0);
			player.setAgainstUserId(0);
			
			Head head  = MessageFactory.getMessage(Head.class);
			head.init(MainCMD.FIGHT, FightCMD.CANCEL_FIGHT);
			Application.sendMessage(player.getGameHandler().getChannel(), head);
		}finally{
			player.unlock();
		}
	}

	@Override
	public void agreedFight(String sessionId) {
		Player player = PlayerManager.getOnlinePlayer(sessionId);
		player.lock();
		try{
			player.setAgainstType(0);
			player.setAgainstUserId(0);
		}finally{
			player.unlock();
		}
	}

	@Override
	public void execFightAI(String sessionId) {
		Player player = PlayerManager.getOnlinePlayer(sessionId);
		player.lock();
		try{
			FightAction action = RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, FightAction.class);
			try{
				action.execFightAI(player.getUserId(), false);
			}catch(Exception e){
				WorldFightAction wa = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, WorldFightAction.class);
				wa.checkFight(player.getUserId());
			}
		}finally{
			player.unlock();
		}
	}

}
