package com.ks.world.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ks.action.logic.FightAction;
import com.ks.action.world.WorldMartialWayAction;
import com.ks.app.Application;
import com.ks.constant.SystemConstant;
import com.ks.model.fight.Battle;
import com.ks.model.martial.MartialWay;
import com.ks.rpc.RPCKernel;
import com.ks.world.kernel.OnlineBattleManager;
import com.ks.world.kernel.PlayerStaticInfo;
import com.ks.world.kernel.WorldServerCache;

public class WorldMartialWayActionImpl implements WorldMartialWayAction {
	
	private static final List<MartialWay> ways = new ArrayList<>();
	
	@Override
	public synchronized void match(MartialWay way) {
		MartialWay mw = null;
		if(ways.indexOf(way)!=-1){
			return;
		}
		for(MartialWay w : ways){
			if(mw==null){
				mw=w;
			}else{
				if(Math.abs(w.getScore()-way.getScore())<Math.abs(mw.getScore()-way.getScore())){
					mw = w;
				}
			}
		}
		if(mw!=null){//匹配到人了
			ways.remove(mw);
			FightAction action = RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, FightAction.class);
			int attUserId = Math.random()>0.5?mw.getUserId():way.getUserId();
			Battle battle = action.startOnlinePVPFight(attUserId, attUserId==way.getUserId()?mw.getUserId():way.getUserId(), SystemConstant.FIGHT_TYPE_MARTIAL_WAY, 30);
			OnlineBattleManager.getManager().addOnlineBattle(battle);
		}else{
			PlayerStaticInfo againstUserInfo = WorldServerCache.getPlayerStaticInfoByUserId(way.getUserId());
			againstUserInfo.setMartialWayMatch(true);
			ways.add(way);
		}
	}

	@Override
	public synchronized void cancelMatch(int userId) {
		Iterator<MartialWay> it = ways.iterator();
		while(it.hasNext()){
			if(it.next().getUserId() == userId){
				PlayerStaticInfo againstUserInfo = WorldServerCache.getPlayerStaticInfoByUserId(userId);
				againstUserInfo.setMartialWayMatch(false);
				it.remove();
			}
		}
	}

}
