package com.ks.protocol.vo.fight;

import java.util.ArrayList;
import java.util.List;

import com.ks.model.fight.Battle;
import com.ks.model.fight.FightModel;
import com.ks.model.fight.Grid;
import com.ks.model.fight.Point;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.MessageFactory;

public class FightVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="战场编号")
	private String battleId;
	@FieldDesc(desc="战场类型")
	private int battleType;
	@FieldDesc(desc="副本战场编号")
	private int zoneBattleId;
	@FieldDesc(desc="副本战场回合")
	private int battleRoundId;
	@FieldDesc(desc="攻击方用户编号")
	private int attackUserId;
	@FieldDesc(desc="防守方用户编号")
	private int defenderUserId;
	@FieldDesc(desc="出手方用户编号")
	private int shotUserId;
	@FieldDesc(desc="格子")
	private List<GridVO> grids;
	@FieldDesc(desc="攻击方")
	private List<FightModelVO> attackers;
	@FieldDesc(desc="攻击方替补")
	private FightModelVO attSub;
	@FieldDesc(desc="防守方")
	private List<FightModelVO> defenders;
	@FieldDesc(desc="防守方替补")
	private FightModelVO defSub;
	@FieldDesc(desc="攻击回合")
	private List<AttackRoundVO> rounds;
	@FieldDesc(desc="战场编号")
	private String mapId;
	@FieldDesc(desc="回合")
	private int round;
	@FieldDesc(desc="是否结束")
	private boolean end;
	
	public void init(Battle o){
		this.battleId = o.getBattleId();
		this.battleType = o.getBattleType();
		this.zoneBattleId = o.getZoneBattleId();
		this.battleRoundId = o.getBattleRoundId();
		this.attackUserId = o.getAttackUserId();
		this.defenderUserId = o.getDefenderUserId();
		this.shotUserId = o.getShotUserId();
		this.grids = new ArrayList<GridVO>();
		this.round = o.getRound();
		for(int x=1;x<=o.getWidth();x++){
			for(int y=1;y<=o.getHeight();y++){
				int c = y%2==0?1:2;
				Point coor = new Point( (x-1)*2+c,y);
				Grid grid = o.getGrids().get(coor);
				GridVO vo = MessageFactory.getMessage(GridVO.class);
				vo.init(grid);
				grids.add(vo);
			}
		}
		
		this.attackers = new ArrayList<FightModelVO>();
		
		for(FightModel fm : o.getAttackers()){
			FightModelVO vo = MessageFactory.getMessage(FightModelVO.class);
			vo.init(fm);
			attackers.add(vo);
		}
		if(o.getAttSub()!=null){
			attSub = MessageFactory.getMessage(FightModelVO.class);
			attSub.init(o.getAttSub());
		}
		
		this.defenders = new ArrayList<FightModelVO>();
		
		for(FightModel fm : o.getDefenders()){
			FightModelVO vo = MessageFactory.getMessage(FightModelVO.class);
			vo.init(fm);
			defenders.add(vo);
		}
		
		if(o.getDefSub()!=null){
			defSub = MessageFactory.getMessage(FightModelVO.class);
			defSub.init(o.getDefSub());
		}
		
		this.rounds = new ArrayList<AttackRoundVO>();
		this.mapId = o.getMapId();
		this.end = o.isEnd();
	}
	
	public String getBattleId() {
		return battleId;
	}
	public void setBattleId(String battleId) {
		this.battleId = battleId;
	}
	public int getAttackUserId() {
		return attackUserId;
	}
	public void setAttackUserId(int attackUserId) {
		this.attackUserId = attackUserId;
	}
	public int getDefenderUserId() {
		return defenderUserId;
	}
	public void setDefenderUserId(int defenderUserId) {
		this.defenderUserId = defenderUserId;
	}
	public int getShotUserId() {
		return shotUserId;
	}
	public void setShotUserId(int shotUserId) {
		this.shotUserId = shotUserId;
	}
	public List<GridVO> getGrids() {
		return grids;
	}
	public void setGrids(List<GridVO> grids) {
		this.grids = grids;
	}
	public List<FightModelVO> getAttackers() {
		return attackers;
	}
	public void setAttackers(List<FightModelVO> attackers) {
		this.attackers = attackers;
	}
	public List<FightModelVO> getDefenders() {
		return defenders;
	}
	public void setDefenders(List<FightModelVO> defenders) {
		this.defenders = defenders;
	}
	public List<AttackRoundVO> getRounds() {
		return rounds;
	}
	public void setRounds(List<AttackRoundVO> rounds) {
		this.rounds = rounds;
	}
	public FightModelVO getAttSub() {
		return attSub;
	}
	public void setAttSub(FightModelVO attSub) {
		this.attSub = attSub;
	}
	public FightModelVO getDefSub() {
		return defSub;
	}
	public void setDefSub(FightModelVO defSub) {
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
	public String getMapId() {
		return mapId;
	}
	public void setMapId(String mapId) {
		this.mapId = mapId;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}
	
}
