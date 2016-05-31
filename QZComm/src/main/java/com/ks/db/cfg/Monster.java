package com.ks.db.cfg;

import java.io.Serializable;
import java.util.List;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.object.DropEffect;

import lombok.Data;
/**
 * 怪物
 * @author ks
 */
@Data
@DBBeanSet(tablename="t_monster", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class Monster implements Serializable {
	private static final long serialVersionUID = 1L;
	/**怪物编号*/
	@DBFieldSet(dbfname="monster_id")
	private int monsterId;
	/**名称*/
	@DBFieldSet(dbfname="name")
	private String name;
	/**属性*/
	@DBFieldSet(dbfname="ele")
	private int ele;
	/**属性等级*/
	@DBFieldSet(dbfname="ele_lv")
	private int eleLv=1;
	/**能力*/
	@DBFieldSet(dbfname="ability")
	private int ability;
	/**血量*/
	@DBFieldSet(dbfname="hp")
	private int hp;
	/**攻击力*/
	@DBFieldSet(dbfname="atk")
	private int atk;
	/**攻击次数*/
	@DBFieldSet(dbfname="atk_count")
	private int atkCount;
	/**暴击率*/
	@DBFieldSet(dbfname="crit_rate")
	private int critRate;
	/**暴击伤害*/
	@DBFieldSet(dbfname="crit_hit")
	private int critHit;
	/**躲闪率*/
	@DBFieldSet(dbfname="dodge_rate")
	private int dodgeRate;
	/**队长技能编号*/
	private int capSkillId;
	/**体型*/
	@DBFieldSet(dbfname="body_type")
	private int bodyType;
	/**怪物攻击方式*/
	private List<MonsterAtkMode> modes;
	/**怪物掉落*/
	private List<DropEffect> drops;
	
}
