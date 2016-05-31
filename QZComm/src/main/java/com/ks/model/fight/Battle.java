package com.ks.model.fight;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ks.constant.SystemConstant;
import com.ks.db.model.UserBuff;
import com.ks.model.fight.ai.BaseAI;
import com.ks.model.fight.ai.MonsterAI;
import com.ks.object.ItemEffect;
import com.ks.protocol.Message;

import lombok.Data;

/**
 * 战斗
 *
 */
@Data
public class Battle implements Serializable {
	private static final long serialVersionUID = 1L;
	/**战场编号*/
	private String battleId;
	/**战场类型*/
	private int battleType;
	/**副本战场编号*/
	private int zoneBattleId;
	/**副本战场回合*/
	private int battleRoundId;
	/**是否乱入过*/
	private boolean dis;
	/**宽*/
	private int width;
	/**高*/
	private int height;
	/**攻击方AI*/
	private String attackAI;
	/**防守方AI*/
	private String defendAI;
	/**攻击方用户编号*/
	private int attackUserId;
	/**防守方用户编号*/
	private int defenderUserId;
	/**出手方用户编号*/
	private int shotUserId;
	/**战场中的格子*/
	private Map<Point,Grid> grids;
	/**攻击方*/
	private List<FightModel> attackers;
	/**攻击方替补*/
	private FightModel attSub;
	/**防守方*/
	private List<FightModel> defenders;
	/**防守方替补*/
	private FightModel defSub;
	/**掉落*/
	private List<ItemEffect> drops;
	/**获得的石板*/
	private int slate;
	/**战斗buff*/
	private List<UserBuff> buffs;
	/**最大回合 0为无限*/
	private int maxRound;
	/**回合*/
	private int round;
	/**是否复活过*/
	private boolean revive;
	/**战场编号*/
	private String mapId="";
	/**战场消息*/
	private Map<Integer,Message> battleMessage = new HashMap<Integer, Message>();
	/**是否放弃*/
	private boolean giveUpFight;
	
	/**
	 * 是否为在线战斗
	 * @return
	 */
	public boolean isOnlineFight(){
		return battleType == SystemConstant.FIGHT_TYPE_ONLINE_PVP || battleType == SystemConstant.FIGHT_TYPE_MARTIAL_WAY;
	}
	
	public static final BaseAI createFightAI(String fightAI,List<FightModel> attackers, List<FightModel> defenders,
			Map<Point, Grid> grids){
		switch (fightAI) {
		case SystemConstant.FIGHT_AI_MONSTER_AI:
			return new MonsterAI(attackers, defenders, grids);
		default:
			break;
		}
		return null;
	}
	/**
	 * 是否为攻击者
	 * @param fightId 攻击编号
	 * @return 是否为攻击者
	 */
	public boolean isAttacker(int fightId){
		for(FightModel fm : attackers){
			if(fightId == fm.getFightId()){
				return true;
			}
		}
		return false;
	}

	public boolean isEnd(){
		if(giveUpFight){
			return true;
		}
		int attLeftCount = 0;
		for(FightModel fm : defenders){
			if(fm.getState()!= SystemConstant.FIGHT_MODEL_STATE_死亡){
				attLeftCount+=1;
			}
		}
		
		int defLeftCount = 0;
		for(FightModel fm : attackers){
			if(fm.getState()!= SystemConstant.FIGHT_MODEL_STATE_死亡){
				defLeftCount+=1;
			}
		}
		boolean end = (attLeftCount==0 || defLeftCount==0)||(getMaxRound()!=0?getMaxRound()<=getRound():false);
		return end;
	}
}
