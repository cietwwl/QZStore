//package com.ks.db.cfg;
//
//import java.io.Serializable;
//import java.util.Date;
//
//import com.ks.access.DBBeanSet;
//import com.ks.access.DBFieldSet;
///**
// * 武魂熔炼
// * @author ks
// */
//@DBBeanSet(tablename="t_eternal_smelting", primaryKey={"type", "user_id"}, createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
//public class EternalSmelting implements Serializable {
//	private static final long serialVersionUID = 1L;
//	/**用户编号*/
//	@DBFieldSet(dbfname="user_id")
//	private int userId;
//	/**类型*/
//	@DBFieldSet(dbfname="type")
//	private int type;
//	/**值*/
//	@DBFieldSet(dbfname="val")
//	private int val;
//	/**增加熔炼点上限*/
//	@DBFieldSet(dbfname="addEternalVal")
//	private int addEternalVal;
//	/**创建时间*/
//	@DBFieldSet(dbfname="create_time")
//	private Date createTime = new Date();
//	/**修改时间*/
//	@DBFieldSet(dbfname="update_time")
//	private Date updateTime = new Date();
//	
//	public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//	public int getType() {
//		return type;
//	}
//	public void setType(int type) {
//		this.type = type;
//	}
//	public int getVal() {
//		return val;
//	}
//	public void setVal(int val) {
//		this.val = val;
//	}
//	public Date getCreateTime() {
//		return createTime;
//	}
//	public void setCreateTime(Date createTime) {
//		this.createTime = createTime;
//	}
//	public Date getUpdateTime() {
//		return updateTime;
//	}
//	public void setUpdateTime(Date updateTime) {
//		this.updateTime = updateTime;
//	}
//	public int getAddEternalVal() {
//		return addEternalVal;
//	}
//	public void setAddEternalVal(int addEternalVal) {
//		this.addEternalVal = addEternalVal;
//	}
//	
//}
