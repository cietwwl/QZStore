package com.ks.protocol.vo.hero;

import com.ks.db.model.UserExplore;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 用户探索
 * @author ks
 */
public abstract class UserExploreVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="探索编号")
	private int exploreId;
	@FieldDesc(desc="用户英雄编号")
	private int userHeroId;
	@FieldDesc(desc="探索类型")
	private int exploreType;
	@FieldDesc(desc="状态")
	private int state;
	@FieldDesc(desc="结束时间")
	private long endTime;
	public void init(UserExplore o){
		this.exploreId = o.getExploreId();
		this.userHeroId = o.getUserHeroId();
		this.exploreType = o.getExploreType();
		this.state = o.getState();
		this.endTime = o.getEndTime().getTime();
	}

	public int getExploreId() {
		return exploreId;
	}
	public void setExploreId(int exploreId) {
		this.exploreId = exploreId;
	}
	public int getUserHeroId() {
		return userHeroId;
	}
	public void setUserHeroId(int userHeroId) {
		this.userHeroId = userHeroId;
	}
	public int getExploreType() {
		return exploreType;
	}
	public void setExploreType(int exploreType) {
		this.exploreType = exploreType;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
}
