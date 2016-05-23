package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

/**
 * @author fengpeng E-mail:fengpeng_15@163.com
 * @version 创建时间：2015年4月8日 上午11:29:36
 * 类说明
 */
@DBBeanSet(tablename="t_equipment_up", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class EquipmentUp implements Serializable {
	private static final long serialVersionUID = 1L;
	/**主键Id*/
	@DBFieldSet(dbfname="id")
	private int id;
	/**装备等级*/
	@DBFieldSet(dbfname="equipment_level")
	private int equipmentLevel;
	/**关联Id*/
	@DBFieldSet(dbfname="ass_id")
	private int assId;
	/**物品类型*/
	@DBFieldSet(dbfname="type")
	private int type;
	/**数量*/
	@DBFieldSet(dbfname="num")
	private int num;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEquipmentLevel() {
		return equipmentLevel;
	}
	public void setEquipmentLevel(int equipmentLevel) {
		this.equipmentLevel = equipmentLevel;
	}
	public int getAssId() {
		return assId;
	}
	public void setAssId(int assId) {
		this.assId = assId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}


}
