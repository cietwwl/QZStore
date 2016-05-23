package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
/**
 * 活动副本
 * @author ks
 */
@DBBeanSet(tablename="t_activity_zone", createDeleteSql=false, createSelectSql=false, createInsertSql=false, createUpdateSql=false)
public class ActivityZone implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**副本编号*/
	@DBFieldSet(dbfname="zone_id")
	private int zoneId;
	/**类型*/
	@DBFieldSet(dbfname="type")
	private int type;
	/**开始时间*/
	@DBFieldSet(dbfname="start_time", parseJavaField="com.ks.util.XyTimeUtil.getTime(rs.getString(\"start_time\"))")
	private long startTime;
	/**结束时间*/
	@DBFieldSet(dbfname="end_time", parseJavaField="com.ks.util.XyTimeUtil.getTime(rs.getString(\"start_time\"))")
	private long endTime;
	/**胜利次数*/
	@DBFieldSet(dbfname="num")
	private int num;
	public int getZoneId() {
		return zoneId;
	}
	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	} 
	
}
