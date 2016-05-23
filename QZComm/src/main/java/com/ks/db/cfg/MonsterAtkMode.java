package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
/**
 * 
 * @author ks
 */
@DBBeanSet(tablename="t_monster_atk_mode", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class MonsterAtkMode implements Serializable {
	private static final long serialVersionUID = 1L;
	/**编号*/
	@DBFieldSet(dbfname="id")
	private int id;
	/**怪物编号*/
	@DBFieldSet(dbfname="monster_id")
	private int monsterId;
	/**攻击方式*/
	@DBFieldSet(dbfname="atk_mode")
	private String atkMode;
	/**移动模型*/
	@DBFieldSet(dbfname="move_mode")
	private String moveMode;
	/**技能编号*/
	@DBFieldSet(dbfname="skill_id")
	private int skillId;
	/**持续回合*/
	@DBFieldSet(dbfname="cd")
	private int cd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMonsterId() {
		return monsterId;
	}
	public void setMonsterId(int monsterId) {
		this.monsterId = monsterId;
	}
	public String getAtkMode() {
		return atkMode;
	}
	public void setAtkMode(String atkMode) {
		this.atkMode = atkMode;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public int getCd() {
		return cd;
	}
	public void setCd(int cd) {
		this.cd = cd;
	}
	public String getMoveMode() {
		return moveMode;
	}
	public void setMoveMode(String moveMode) {
		this.moveMode = moveMode;
	}
	
}
