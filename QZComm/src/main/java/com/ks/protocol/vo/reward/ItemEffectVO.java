package com.ks.protocol.vo.reward;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.ks.protocol.Message;

@EqualsAndHashCode(callSuper=true)
@Data
public class ItemEffectVO extends Message{
	private static final long serialVersionUID = 1L;
	private int type;  
	private int id;
	private int value1;
	private int value2;

}
