package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
/**
 * 英雄进化材料
 * @author ks
 */
@DBBeanSet(tablename="t_hero_evo_material", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class HeroEvoMaterial implements Serializable {
	private static final long serialVersionUID = 1L;
	/**进化编号*/
	@DBFieldSet(dbfname="evo_id")
	private int evoId;
	/**类型*/
	@DBFieldSet(dbfname="type")
	private int type;
	/**关联编号*/
	@DBFieldSet(dbfname="ass_id")
	private int assId;
	/**数量*/
	@DBFieldSet(dbfname="num")
	private int num;
	public int getEvoId() {
		return evoId;
	}
	public void setEvoId(int evoId) {
		this.evoId = evoId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getAssId() {
		return assId;
	}
	public void setAssId(int assId) {
		this.assId = assId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
