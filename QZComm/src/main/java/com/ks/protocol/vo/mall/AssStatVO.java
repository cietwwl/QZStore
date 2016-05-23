package com.ks.protocol.vo.mall;

import com.ks.model.user.AssStat;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 关联统计
 * @author ks
 */
public abstract class AssStatVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="编号")
	private int assId;
	@FieldDesc(desc="数量")
	private int num;
	
	public void init(AssStat o){
		this.assId = o.getAssId();
		this.num = o.getNum();
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getAssId() {
		return assId;
	}
	public void setAssId(int assId) {
		this.assId = assId;
	}
	
}
