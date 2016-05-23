package com.ks.protocol.vo.user;

import com.ks.db.model.UserBuff;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;

public abstract class UserBuffVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="效果编号")
	private int effectId;
	@FieldDesc(desc="值")
	private int val;
	@FieldDesc(desc="cd")
	private int cd;
	
	public void init(UserBuff o){
		this.effectId = o.getEffectId();
		this.val = o.getVal();
		this.cd = o.getCd();
	}
	
	public int getEffectId() {
		return effectId;
	}
	public void setEffectId(int effectId) {
		this.effectId = effectId;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public int getCd() {
		return cd;
	}
	public void setCd(int cd) {
		this.cd = cd;
	}
	
}
