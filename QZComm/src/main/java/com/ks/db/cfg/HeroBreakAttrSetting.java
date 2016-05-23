package com.ks.db.cfg;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

/**
 * 突破属性增加基础表
 * @author hanjie.l
 *
 */
@DBBeanSet(tablename="t_hero_break_attr_setting", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class HeroBreakAttrSetting {
	/**组id*/
	@DBFieldSet(dbfname="groupId")
	private int groupId;
	/**突破等级*/
	@DBFieldSet(dbfname="breakLevel")
	private int breakLevel;
	/**灵元槽位*/
	@DBFieldSet(dbfname="slot")
	private int slot;
	/**增加血量*/
	@DBFieldSet(dbfname="hp")
	private int hp;
	/**增加攻击力*/
	@DBFieldSet(dbfname="atk")
	private int atk;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getBreakLevel() {
		return breakLevel;
	}

	public void setBreakLevel(int breakLevel) {
		this.breakLevel = breakLevel;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}
}
