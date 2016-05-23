package com.ks.world.action;

import com.ks.action.game.GameFightAction;
import com.ks.action.logic.FightAction;
import com.ks.action.world.WorldFightAction;
import com.ks.app.Application;
import com.ks.exceptions.GameException;
import com.ks.protocol.Message;
import com.ks.protocol.vo.Head;
import com.ks.protocol.vo.user.ViewUserVO;
import com.ks.rpc.RPCKernel;
import com.ks.world.kernel.OnlineBattleManager;
import com.ks.world.kernel.OnlineBattleManager.OnlineBattle;
import com.ks.world.kernel.PlayerStaticInfo;
import com.ks.world.kernel.WorldServerCache;

public class WorldFightActionImpl implements WorldFightAction {

	@Override
	public void againstFight(int userId,int againstUserId,ViewUserVO viewUser) {
		PlayerStaticInfo againstUserInfo = WorldServerCache.getPlayerStaticInfoByUserId(againstUserId);
		if(againstUserInfo != null){
			GameFightAction gameFightAction =RPCKernel.getRemoteByServerId(againstUserInfo.getGameServerId(), GameFightAction.class);
			gameFightAction.againstFight(userId, againstUserInfo.getSessionId(), viewUser);
		}
	}

	@Override
	public void cancelFight(int againstUserId) {
		PlayerStaticInfo againstUserInfo = WorldServerCache.getPlayerStaticInfoByUserId(againstUserId);
		RPCKernel.getRemoteByServerId(againstUserInfo.getGameServerId(), GameFightAction.class).cancelFight(againstUserInfo.getSessionId());
	}

	@Override
	public void agreedFight(int userId) {
		PlayerStaticInfo againstUserInfo = WorldServerCache.getPlayerStaticInfoByUserId(userId);
		
		RPCKernel.getRemoteByServerId(againstUserInfo.getGameServerId(), GameFightAction.class).agreedFight(againstUserInfo.getSessionId());
	}

	@Override
	public void onlineFightAction(String battleId, int nextShotUserId, Head head,
			Object rounds,boolean end) {
		OnlineBattleManager.getManager().onlineFightAction(battleId, nextShotUserId, head, rounds, end);
	}

	@Override
	public void giveUpFight(String battleId, int userId) {
		OnlineBattleManager.getManager().giveUpFight(battleId, userId);
	}

	@Override
	public void ready(int userId) {
		OnlineBattleManager.getManager().ready(userId);
	}

	@Override
	public void hostingFight(int userId) {
		PlayerStaticInfo againstUserInfo = WorldServerCache.getPlayerStaticInfoByUserId(userId);
		if(againstUserInfo==null){
			return;
		}
		if(againstUserInfo.isMartialWayMatch()){
			new WorldMartialWayActionImpl().cancelMatch(userId);
		}
		ready(userId);
		if(!"".equals(againstUserInfo.getBattleRoomId())&&againstUserInfo.getBattleRoomId()!=null){
			OnlineBattleManager.getManager().hosting(againstUserInfo.getBattleRoomId(), userId);
		}
	}

	@Override
	public boolean ready(String fightId,int userId) {
		PlayerStaticInfo againstUserInfo = WorldServerCache.getPlayerStaticInfoByUserId(userId);
		if(againstUserInfo==null){
			return false;
		}
		againstUserInfo.setBattleRoomId(fightId);
		return OnlineBattleManager.getManager().ready(userId);
	}

	@Override
	public synchronized Message getFightRes(int userId) {
		FightAction action = RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, FightAction.class);
		return action.getFightRes(userId);
	}

	@Override
	public void checkFight(int userId) {
		OnlineBattleManager.getManager().checkFight(userId);
	}
	
	@Override
	public void watch(int userId, String fightId){
		OnlineBattle battle = OnlineBattleManager.getManager().getOnlineBattleById(fightId);
		if(battle == null){
			throw new GameException(GameException.CODE_战斗已结束, "");
		}else{
			OnlineBattleManager.getManager().addUserIdToWatchBattle(userId, battle);
		}
	}

}
