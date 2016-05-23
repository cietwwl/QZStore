package com.ks.protocol.vo.hero;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 英雄操作结果
 * @author ks
 */
public class HeroOptResultVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="类型")
	private int type;
	@FieldDesc(desc="获得经验")
	private int exp;
	@FieldDesc(desc="操作后的英雄")
	private UserHeroVO hero;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public UserHeroVO getHero() {
		return hero;
	}
	public void setHero(UserHeroVO hero) {
		this.hero = hero;
	}
}
