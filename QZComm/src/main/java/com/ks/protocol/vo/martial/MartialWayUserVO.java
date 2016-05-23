package com.ks.protocol.vo.martial;

import com.ks.model.user.UserBaseinfo;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.user.UserBaseinfoVO;

public class MartialWayUserVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="用户基础数据")
	private UserBaseinfoVO baseInfo;
	@FieldDesc(desc="排名")
	private int rank;
	@FieldDesc(desc="战斗力")
	private int fightingCapacity;
	
	public void init(UserBaseinfo baseInfo,int rank,int fightingCapacity){
		this.baseInfo = MessageFactory.getMessage(UserBaseinfoVO.class);
		this.baseInfo.init(baseInfo);
		this.rank = rank;
		this.fightingCapacity = fightingCapacity;
	}
	
	public UserBaseinfoVO getBaseInfo() {
		return baseInfo;
	}
	public void setBaseInfo(UserBaseinfoVO baseInfo) {
		this.baseInfo = baseInfo;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getFightingCapacity() {
		return fightingCapacity;
	}
	public void setFightingCapacity(int fightingCapacity) {
		this.fightingCapacity = fightingCapacity;
	}
}
