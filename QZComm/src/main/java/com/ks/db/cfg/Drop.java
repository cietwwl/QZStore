package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
/**
 * 掉落
 * @author ks
 */
@DBBeanSet(tablename="t_drop", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class Drop implements Serializable {
	private static final long serialVersionUID = 1L;
	/**怪物编号*/
	@DBFieldSet(dbfname="monster_id")
	private int monsterId;
	/**类型*/
	@DBFieldSet(dbfname="type")
	private int type;
	/**关联编号*/
	@DBFieldSet(dbfname="ass_id")
	private int assId;
	/**数量*/
	@DBFieldSet(dbfname="num")
	private int num;
	/**概率*/
	@DBFieldSet(dbfname="rate")
	private double rate;
	/**是否成功掉落*/
	private boolean successDrop = true;
	public int getMonsterId() {
		return monsterId;
	}
	public void setMonsterId(int monsterId) {
		this.monsterId = monsterId;
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
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public boolean isSuccessDrop(){
		return successDrop;
	}
	public void setSuccessDrop(boolean drop){
		this.successDrop = drop;
	}
	public Drop copy(){
		Drop drop = new Drop();
		drop.setType(type);
		drop.setAssId(assId);
		drop.setNum(num);
		drop.setMonsterId(monsterId);
		drop.setRate(rate);
		drop.setSuccessDrop(successDrop);
		return drop;
	}
	
}
