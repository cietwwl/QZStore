package com.ks.protocol.vo.reward;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;

@EqualsAndHashCode(callSuper=true)
@Data
public class ItemEffectVO extends Message{
	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="类型(参照public里面server文件夹内的说明)")
	private int type;  
	@FieldDesc(desc="效果道具id，没有id的默认为0")
	private int id;
	@FieldDesc(desc="数量")
	private int value1;
	@FieldDesc(desc="暂时为伙伴、装备等级")
	private int value2;

	public void init(int type, int id, int value1, int value2){
		this.type = type;
		this.id = id;
		this.value1 = value1;
		this.value2 = value2;
	}
}
