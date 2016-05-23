package com.ks.protocol.vo.prop;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 出售道具
 * @author ks
 */
public class SellPropVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="出售道具编号")
	private int propId;
	@FieldDesc(desc="出售数量")
	private int num;
	public int getPropId() {
		return propId;
	}
	public void setPropId(int propId) {
		this.propId = propId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
}
