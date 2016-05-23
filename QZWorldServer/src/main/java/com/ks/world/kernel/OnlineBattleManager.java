package com.ks.world.kernel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import com.ks.action.game.GameFightAction;
import com.ks.action.logic.FightAction;
import com.ks.app.Application;
import com.ks.model.fight.Battle;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.FightCMD;
import com.ks.protocol.vo.Head;
import com.ks.protocol.vo.fight.FightVO;
import com.ks.rpc.RPCKernel;
import com.ks.timer.BaseTimer;
import com.ks.timer.TimerController;
import com.ks.world.action.WorldServerActionImpl;

/**
 * 在线战斗管理
 * @author ks
 */
public class OnlineBattleManager {
	
	private OnlineBattleManager(){}
	
	public static final OnlineBattleManager manager = new OnlineBattleManager();
	
	public static OnlineBattleManager getManager(){
		return manager;
	}
	private Map<String, OnlineBattle> battles = new ConcurrentHashMap<>();
	private Map<Integer, OnlineBattle> userWatchBattles = new ConcurrentHashMap<Integer, OnlineBattleManager.OnlineBattle>();
	
	public OnlineBattle getOnlineBattleByUserId(int userId){
		return userWatchBattles.get(userId);
	}
	
	public void addUserIdToWatchBattle(int userId, OnlineBattle battle){
		synchronized (battle) {
			if(!battle.getViewers().contains(userId)){
				battle.getViewers().add(userId);
			}
			userWatchBattles.put(userId, battle);
		}
	}
	
	public OnlineBattle getOnlineBattleById(String battleId){
		return battles.get(battleId);
	}
	
	public void addOnlineBattle(Battle battle){
		final OnlineBattle ob = new OnlineBattle();
		ob.addViewerId(battle.getAttackUserId());
		ob.addViewerId(battle.getDefenderUserId());
		ob.battleId = battle.getBattleId();
		ob.attUserId = battle.getAttackUserId();
		ob.defUserId = battle.getDefenderUserId();
		ob.shotUserId = battle.getAttackUserId();
		
		//原有
//		BaseTimer timer = new BaseTimer() {
//			
//			@Override
//			public void run() {
//				synchronized (ob) {
//					ob.state = OnlineBattle.STATE_BEGINING;
//				}
//				if(ob.attHosting&&ob.defHosting){
//					ob.state = OnlineBattle.STATE_CLOSED;
//					execAllBattleAI(ob.battleId, ob.shotUserId);
//				}else if(ob.attHosting || ob.defHosting){
//					execBattleAI(ob.battleId, ob.shotUserId,ob);
//				}
//			}
//		};
//		timer.setInitialDelay(60);
//		timer.setUnit(TimeUnit.SECONDS);
//		ob.future = TimerController.register(timer);
		
		battles.put(battle.getBattleId(), ob);
		
		updateBattleRoom(battle.getAttackUserId(),battle.getBattleId());
		updateBattleRoom(battle.getDefenderUserId(),battle.getBattleId());
		userWatchBattles.put(battle.getAttackUserId(), ob);
		userWatchBattles.put(battle.getDefenderUserId(), ob);
		
		Head head = MessageFactory.getMessage(Head.class);
		head.init(MainCMD.FIGHT, FightCMD.START_ONLINE_FIGHT);
		
		FightVO fight = MessageFactory.getMessage(FightVO.class);
		fight.init(battle);
		new WorldServerActionImpl().sendMessage(ob.viewers, head, fight);
		
	}
	
	private void updateBattleRoom(int userId, String battleId) {
		PlayerStaticInfo staticInfo = WorldServerCache.getPlayerStaticInfoByUserId(userId);
		if(staticInfo!=null){
			staticInfo.setBattleRoomId(battleId);
		}
	}

	private void execAllBattleAI(String battleId,int userId){
		FightAction fightAction = RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, FightAction.class);
		fightAction.execFightAI(userId,true);
	}
	
	private void execBattleAI(String battleId,int userId,OnlineBattle ob){
		PlayerStaticInfo staticInfo = WorldServerCache.getPlayerStaticInfoByUserId(userId);
		if(staticInfo!=null){//在线
			GameFightAction gfa = RPCKernel.getRemoteByServerId(staticInfo.getGameServerId(), GameFightAction.class);
			gfa.execFightAI(staticInfo.getSessionId());
		}else {
			FightAction fightAction = RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, FightAction.class);
			fightAction.execFightAI(userId,false);
		}
		if(ob.future != null){
			ob.future.cancel(false);
		}
		if(battles.get(ob.battleId)!=null){
			ob.future = TimerController.register(new BattleTimer(ob, ob.shotUserId,2));
		}
	}
	
	private class BattleTimer extends BaseTimer{
		private OnlineBattle ob;
		private int shotUserId;
		public BattleTimer(OnlineBattle ob,int shotUserId,int seconds){
			this.ob = ob;
			this.shotUserId = shotUserId;
			this.initialDelay = seconds;
			this.unit = TimeUnit.SECONDS;
		}
		@Override
		public void run() {
			synchronized (ob) {
				if(ob.shotUserId == shotUserId){
					execBattleAI(ob.battleId, shotUserId,ob);
				}
			}
		}
	}
	
	public boolean ready(int userId){
		PlayerStaticInfo staticInfo = WorldServerCache.getPlayerStaticInfoByUserId(userId);
		OnlineBattle ob = battles.get(staticInfo.getBattleRoomId());
		if(ob==null){
			return false;
		}
		boolean execBattle = false;
		synchronized (ob) {
			if(ob.state == OnlineBattle.STATE_CLOSED){
				return false;
			}
			cancelHosting(staticInfo.getBattleRoomId(), userId);
			if(ob.state == OnlineBattle.STATE_WAIE){
//				if(!ob.attHosting && !ob.defHosting){
//					if(ob.future != null){
//						ob.future.cancel(false);
//					}
//					ob.future = TimerController.register(new BattleTimer(ob, ob.shotUserId,60));
//				}
				if(!ob.attReady && ob.attUserId == userId){
					ob.attReady = true;
				}else if(!ob.defReady && ob.defUserId == userId){
					ob.defReady = true;
				}
				Head head = MessageFactory.getMessage(Head.class);
				head.init(MainCMD.FIGHT, FightCMD.START_ONLINE_FIGHT_READY);
				
				new WorldServerActionImpl().sendMessage(ob.viewers, head, userId);
				if(ob.attReady && ob.defReady){
					if(ob.future != null){
						ob.future.cancel(false);
					}
					if(!ob.attHosting){
						ob.future = TimerController.register(new BattleTimer(ob, ob.shotUserId,60));
					}else{
						execBattle = true;
					}
					ob.state = OnlineBattle.STATE_BEGINING;
				}
			}
		}
		if(execBattle){
			execBattleAI(ob.battleId, ob.shotUserId,ob);
		}
		return true;
	}
	
	public void hosting(String battleId,int userId){
		OnlineBattle ob = battles.get(battleId);
		if(ob==null){
			return;
		}
		synchronized (ob) {
			if(ob.attUserId == userId){
				ob.attHosting = true;
			}else if(userId == ob.defUserId){
				ob.defHosting = true;
			}
		}
		if(ob.attHosting&&ob.defHosting){
			ob.state = OnlineBattle.STATE_CLOSED;
			execAllBattleAI(ob.battleId, ob.shotUserId);
		}else if(ob.shotUserId == userId){
			if(ob.attReady && ob.defReady){
				execBattleAI(battleId, userId,ob);
			}
		}
	}
	
	public void cancelHosting(String battleId,int userId){
		OnlineBattle ob = battles.get(battleId);
		if(ob==null){
			return;
		}
		synchronized (ob) {
			if(ob.attUserId == userId){
				ob.attHosting = false;
			}else if(userId == ob.defUserId){
				ob.defHosting = false;
			}
		}
	}
	
	public boolean hasFight(String battleId){
		return battles.get(battleId)!=null;
	}
	
	public void checkFight(int userId){
		PlayerStaticInfo staticInfo = WorldServerCache.getPlayerStaticInfoByUserId(userId);
		OnlineBattle ob = battles.get(staticInfo.getBattleRoomId());
		if(ob==null){
			staticInfo.setBattleRoomId("");
		}
	}
	
	public void onlineFightAction(String battleId, int nextShotUserId, Head head,
			Object rounds,boolean end){
		OnlineBattle ob = battles.get(battleId);
		if(ob==null){
			return;
		}
		if(ob.future != null){
			ob.future.cancel(false);
		}
		new WorldServerActionImpl().sendMessage(ob.viewers, head, rounds);
		if(end){
			removeBattle(battleId);
		}else{
			synchronized (ob) {
				ob.shotUserId=nextShotUserId;
			}
			if((ob.shotUserId == ob.attUserId&&ob.attHosting)||(ob.shotUserId==ob.defUserId && ob.defHosting)){
				execBattleAI(battleId, nextShotUserId, ob);
			}else{
				ob.future = TimerController.register(new BattleTimer(ob, nextShotUserId, 60));
			}
		}
	}
	
	public void giveUpFight(String battleId,int userId){
		OnlineBattle ob = removeBattle(battleId);
		if(ob==null){
			return;
		}
		if(ob.future != null){
			ob.future.cancel(false);
		}
		Head head = MessageFactory.getMessage(Head.class);
		head.init(MainCMD.FIGHT, FightCMD.GIVE_UP_FIGHT);
		new WorldServerActionImpl().sendMessage(ob.viewers, head, userId);
	}

	private OnlineBattle removeBattle(String battleId) {
		OnlineBattle ob = battles.remove(battleId);
		if(ob==null){
			return null;
		}
		for(int userId : ob.viewers){
			updateBattleRoom(userId, "");
			userWatchBattles.remove(userId);
		}
		return ob;
	}
	
	public static class OnlineBattle{
		/**等待状态*/
		private static final byte STATE_WAIE = 0;
		/**开始中*/
		private static final byte STATE_BEGINING = 1;
		/**已结束*/
		private static final byte STATE_CLOSED = 2;
		
		/**状态*/
		private byte state;
		/**战斗编号*/
		private String battleId;
		/**攻击方托管*/
		private boolean attHosting = false;
		/**防守方托管*/
		private boolean defHosting = false;
		/**攻击方是否ready*/
		private boolean attReady = false;
		/**防守方是否ready*/
		private boolean defReady = false;
		/**出售用户编号*/
		private int shotUserId;
		/**攻击方用户编号*/
		private int attUserId;
		/**防守方用户编号*/
		private int defUserId;
		/**观众*/
		private List<Integer> viewers = new ArrayList<Integer>();
		/**未来计划*/
		private ScheduledFuture<?> future;
		
		public void addViewerId(int viewerId){
			viewers.add(viewerId);
		}
		
		public List<Integer> getViewers(){
			return viewers;
		}
	}
}
