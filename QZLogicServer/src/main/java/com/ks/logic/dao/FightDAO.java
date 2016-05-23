package com.ks.logic.dao;

import com.ks.access.GameDAOTemplate;
import com.ks.model.fight.Battle;
import com.ks.util.SerializableUtil;

public class FightDAO extends GameDAOTemplate {
	private static final String BATTLE_KEY = "BATTLE_";
	
	public void updateBattle(Battle battle){
		set((BATTLE_KEY+battle.getBattleId()).getBytes(), SerializableUtil.encode(battle));
	}
	
	public Battle getBattle(String battleId){
		return SerializableUtil.decode(get((BATTLE_KEY+battleId).getBytes()), Battle.class);
	}
	
	public void deleteBattle(String battleId){
		del((BATTLE_KEY+battleId).getBytes());
	}
}
