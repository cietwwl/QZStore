package com.ks.protocol.vo.hero;

import java.util.List;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 进化英雄结果
 * @author ks
 */
public class EvolutionHeroResultVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="操作后的英雄")
	private UserHeroVO hero;
	@FieldDesc(desc="删除的英雄")
	private List<Integer> remHeros;
	public UserHeroVO getHero() {
		return hero;
	}
	public void setHero(UserHeroVO hero) {
		this.hero = hero;
	}
	public List<Integer> getRemHeros() {
		return remHeros;
	}
	public void setRemHeros(List<Integer> remHeros) {
		this.remHeros = remHeros;
	}
}
