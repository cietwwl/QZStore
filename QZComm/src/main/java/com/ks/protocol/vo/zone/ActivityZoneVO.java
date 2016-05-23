package com.ks.protocol.vo.zone;

import com.ks.db.cfg.ActivityZone;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;

public class ActivityZoneVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="副本编号")
	private int zoneId;
	@FieldDesc(desc="类型")
	private int type;
	@FieldDesc(desc="开始时间")
	private long startTime;
	@FieldDesc(desc="结束时间")
	private long endTime;
	@FieldDesc(desc="胜利次数")
	private int num;
	public void init(ActivityZone o){
		this.zoneId = o.getZoneId();
		this.type = o.getType();
		this.startTime = o.getStartTime();
		this.endTime = o.getEndTime();
		this.num = o.getNum();
	}
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
