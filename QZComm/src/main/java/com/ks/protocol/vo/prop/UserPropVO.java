package com.ks.protocol.vo.prop;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.ks.db.model.UserProp;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;

@EqualsAndHashCode(callSuper=true)
@Data
public abstract class UserPropVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="主键id")
	private int id;
	@FieldDesc(desc="道具编号")
	private int propId;
	@FieldDesc(desc="数量")
	private int num;
	public void init(UserProp o){
		this.id = o.getId();
		this.propId = o.getPropId();
		this.num = o.getNum();
	}
	
}
