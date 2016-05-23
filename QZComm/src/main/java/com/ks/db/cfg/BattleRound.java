package com.ks.db.cfg;

import java.io.Serializable;
import java.util.List;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
/**
 * 战场回合
 * @author ks
 */
@DBBeanSet(tablename="t_zone_battle_round", imports={"com.ks.util.StringUtil"}, createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class BattleRound implements Serializable {
	private static final long serialVersionUID = 1L;

	/**战场编号*/
	@DBFieldSet(dbfname="battle_id")
	private int battleId;
	/**回合编号*/
	@DBFieldSet(dbfname="round_id")
	private int roundId;
	/**怪物*/
	@DBFieldSet(dbfname="monsters", parseJavaField="StringUtil.stringToList1(rs.getString(\"monsters\"))")
	private List<Integer> monsters;
	/**是否为BOOS关卡*/
	@DBFieldSet(dbfname="boss_round")
	private boolean bossRound;
	public int getBattleId() {
		return battleId;
	}
	public void setBattleId(int battleId) {
		this.battleId = battleId;
	}
	public int getRoundId() {
		return roundId;
	}
	public void setRoundId(int roundId) {
		this.roundId = roundId;
	}
	public List<Integer> getMonsters() {
		return monsters;
	}
	public void setMonsters(List<Integer> monsters) {
		this.monsters = monsters;
	}
	public boolean isBossRound() {
		return bossRound;
	}
	public void setBossRound(boolean bossRound) {
		this.bossRound = bossRound;
	}
	
}
