package com.ks.model.fight;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ks.constant.SystemConstant;
import com.ks.db.cfg.Drop;
import com.ks.db.model.UserBuff;
import com.ks.model.fight.ai.BaseAI;
import com.ks.model.fight.ai.MonsterAI;
import com.ks.protocol.Message;
/**
 * 战场
 * @author ks
 */
/**
 * 战场
 * @author ks
 */
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
	private List<Drop> drops;
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
	
	public String getBattleId() {
		return battleId;
	}
	public void setBattleId(String battleId) {
		this.battleId = battleId;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public List<FightModel> getAttackers() {
		return attackers;
	}
	public void setAttackers(List<FightModel> attackers) {
		this.attackers = attackers;
	}
	public List<FightModel> getDefenders() {
		return defenders;
	}
	public void setDefenders(List<FightModel> defenders) {
		this.defenders = defenders;
	}
	public Map<Point, Grid> getGrids() {
		return grids;
	}
	public void setGrids(Map<Point, Grid> grids) {
		this.grids = grids;
	}
	public int getAttackUserId() {
		return attackUserId;
	}
	public void setAttackUserId(int attackUserId) {
		this.attackUserId = attackUserId;
	}
	public int getShotUserId() {
		return shotUserId;
	}
	public void setShotUserId(int shotUserId) {
		this.shotUserId = shotUserId;
	}
	public int getDefenderUserId() {
		return defenderUserId;
	}
	public void setDefenderUserId(int defenderUserId) {
		this.defenderUserId = defenderUserId;
	}
	public String getAttackAI() {
		return attackAI;
	}
	public void setAttackAI(String attackAI) {
		this.attackAI = attackAI;
	}
	public String getDefendAI() {
		return defendAI;
	}
	public void setDefendAI(String defendAI) {
		this.defendAI = defendAI;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public FightModel getAttSub() {
		return attSub;
	}
	public void setAttSub(FightModel attSub) {
		this.attSub = attSub;
	}
	public FightModel getDefSub() {
		return defSub;
	}
	public void setDefSub(FightModel defSub) {
		this.defSub = defSub;
	}
	public int getBattleType() {
		return battleType;
	}
	public void setBattleType(int battleType) {
		this.battleType = battleType;
	}
	public int getZoneBattleId() {
		return zoneBattleId;
	}
	public void setZoneBattleId(int zoneBattleId) {
		this.zoneBattleId = zoneBattleId;
	}
	public int getBattleRoundId() {
		return battleRoundId;
	}
	public void setBattleRoundId(int battleRoundId) {
		this.battleRoundId = battleRoundId;
	}
	public List<Drop> getDrops() {
		return drops;
	}
	public void setDrops(List<Drop> drops) {
		this.drops = drops;
	}
	public boolean isDis() {
		return dis;
	}
	public void setDis(boolean dis) {
		this.dis = dis;
	}
	public int getSlate() {
		return slate;
	}
	public void setSlate(int slate) {
		this.slate = slate;
	}
	public List<UserBuff> getBuffs() {
		return buffs;
	}
	public void setBuffs(List<UserBuff> buffs) {
		this.buffs = buffs;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public int getMaxRound() {
		return maxRound;
	}
	public void setMaxRound(int maxRound) {
		this.maxRound = maxRound;
	}
	public boolean isRevive() {
		return revive;
	}

	public void setRevive(boolean revive) {
		this.revive = revive;
	}

	public String getMapId() {
		return mapId;
	}

	public Map<Integer, Message> getBattleMessage() {
		return battleMessage;
	}

	public void setBattleMessage(Map<Integer, Message> battleMessage) {
		this.battleMessage = battleMessage;
	}

	public void setMapId(String mapId) {
		this.mapId = mapId;
	}
	
	
	public boolean isGiveUpFight() {
		return giveUpFight;
	}

	public void setGiveUpFight(boolean giveUpFight) {
		this.giveUpFight = giveUpFight;
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
