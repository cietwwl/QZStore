package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
/**
 * 开炉规则
 * @author ks
 */
@DBBeanSet(tablename="t_blowing_rule", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class BlowingRule implements Serializable {
	private static final long serialVersionUID = 1L;
	/**类型*/
	@DBFieldSet(dbfname="type")
	private int type;
	/**道具编号*/
	@DBFieldSet(dbfname="prop_id")
	private int propId;
	/**概率*/
	@DBFieldSet(dbfname="rate")
	private int rate;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getPropId() {
		return propId;
	}
	public void setPropId(int propId) {
		this.propId = propId;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	
}
