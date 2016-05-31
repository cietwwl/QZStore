package com.ks.protocol.vo.fight;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;

public class DropVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="类型")
	private int type;
	@FieldDesc(desc="关联编号")
	private int assId;
	@FieldDesc(desc="数量")
	private int num;
	
	public void init(int type, int assId, int num){
		this.type = type;
		this.assId = assId;
		this.num = num;
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
