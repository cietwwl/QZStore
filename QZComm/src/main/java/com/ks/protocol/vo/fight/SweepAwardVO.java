package com.ks.protocol.vo.fight;

import java.util.List;

import com.ks.protocol.Message;
import com.ks.protocol.vo.hero.UserHeroVO;

public class SweepAwardVO extends Message {

	private static final long serialVersionUID = 1L;
	
	private List<UserHeroVO> heros;
	private List<SweepVO> sweeps;
	public List<UserHeroVO> getHeros() {
		return heros;
	}
	public void setHeros(List<UserHeroVO> heros) {
		this.heros = heros;
	}
	public List<SweepVO> getSweeps() {
		return sweeps;
	}
	public void setSweeps(List<SweepVO> sweeps) {
		this.sweeps = sweeps;
	}
	
	
	
}
