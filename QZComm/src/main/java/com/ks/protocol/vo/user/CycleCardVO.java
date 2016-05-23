package com.ks.protocol.vo.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.ks.protocol.Message;

@EqualsAndHashCode(callSuper=true)
@Data
public class CycleCardVO extends Message{
	private static final long serialVersionUID = 1L;
	private int payId;
	private int endTime;

}
