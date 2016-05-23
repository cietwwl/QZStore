package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
/**
 * 成就
 * @author ks
 */
@DBBeanSet(tablename="t_achieve", createDeleteSql=false, createSelectSql=false, createInsertSql=false, createUpdateSql=false)
public class Achieve implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**成就编号*/
	@DBFieldSet(dbfname="achieve_id")
	private int achieveId;
	/**成就名称*/
	@DBFieldSet(dbfname="name")
	private String name;
	/**类型*/
	@DBFieldSet(dbfname="type")
	private int type;
	/**关联编号*/
	@DBFieldSet(dbfname="ass_id")
	private int assId;
	/**数量*/
	@DBFieldSet(dbfname="num")
	private int num;
	public int getAchieveId() {
		return achieveId;
	}
	public void setAchieveId(int achieveId) {
		this.achieveId = achieveId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
