package com.ks.protocol.vo.prop;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 武魂熔炼
 * @author ks
 */
public class EternalSmeltingVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="类型")
	private int type;
	@FieldDesc(desc="值")
	private int val;
	@FieldDesc(desc="增加熔炼点上限")
	private int addEternalVal;
	
	public void init(int type, int smeltingExp, int addSmeltingVal){
		this.type = type;
		this.val = smeltingExp;
		this.addEternalVal = addSmeltingVal;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public int getAddEternalVal() {
		return addEternalVal;
	}
	public void setAddEternalVal(int addEternalVal) {
		this.addEternalVal = addEternalVal;
	}
	
}
