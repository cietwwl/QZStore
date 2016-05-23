package com.ks.protocol.vo.user;

import java.util.List;

import com.ks.db.model.UserTeam;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 用户队伍
 * @author ks
 */
public class UserTeamVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="英雄")
	private List<Integer> heros;
	@FieldDesc(desc="位置")
	private List<Integer> pos;
	
	public void init(UserTeam ut){
		this.heros = ut.getHeroList();
		this.pos = ut.getPosList();
	}
	
	public List<Integer> getHeros() {
		return heros;
	}
	public void setHeros(List<Integer> heros) {
		this.heros = heros;
	}
	public List<Integer> getPos() {
		return pos;
	}
	public void setPos(List<Integer> pos) {
		this.pos = pos;
	}
}
