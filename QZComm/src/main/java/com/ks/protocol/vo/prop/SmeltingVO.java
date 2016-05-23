package com.ks.protocol.vo.prop;

import com.ks.protocol.Message;

public class SmeltingVO extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int type;
	
	private int gainPoint;
	
	private EternalSmeltingVO es;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getGainPoint() {
		return gainPoint;
	}

	public void setGainPoint(int gainPoint) {
		this.gainPoint = gainPoint;
	}

	public EternalSmeltingVO getEs() {
		return es;
	}

	public void setEs(EternalSmeltingVO es) {
		this.es = es;
	}
	
	
}
