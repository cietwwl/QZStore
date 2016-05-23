package com.ks.protocol.vo.achieve;

import com.ks.db.model.UserAchieve;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 成就VO
 * @author ks
 */
public abstract class UserAchieveVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="成就编号")
	private int achieveId;
	@FieldDesc(desc="当前数量")
	private int num;
	@FieldDesc(desc="状态")
	private int state;
	public void init(UserAchieve o){
		this.achieveId = o.getAchieveId();
		this.num = o.getNum();
		this.state = o.getState();
	}

	public int getAchieveId() {
		return achieveId;
	}
	public void setAchieveId(int achieveId) {
		this.achieveId = achieveId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
