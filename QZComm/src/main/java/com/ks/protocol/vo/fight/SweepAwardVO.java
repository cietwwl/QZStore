package com.ks.protocol.vo.fight;

import java.util.ArrayList;
import java.util.List;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)
@Data
public class SweepAwardVO extends Message {
	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="扫荡结果")
	private List<SweepVO> sweeps = new ArrayList<>();
	
	public void addSweep(SweepVO vo){
		sweeps.add(vo);
	}
	
}
