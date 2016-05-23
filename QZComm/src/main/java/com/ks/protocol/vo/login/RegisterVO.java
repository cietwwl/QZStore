package com.ks.protocol.vo.login;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 注册
 * @author ks
 */
public class RegisterVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="用户名")
	private String username;
	@FieldDesc(desc="合作方编号")
	private int partner;
	@FieldDesc(desc="玩家名称")
	private String playerName;
	@FieldDesc(desc="初始化选择英雄")
	private int initHeroId;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPartner() {
		return partner;
	}
	public void setPartner(int partner) {
		this.partner = partner;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getInitHeroId() {
		return initHeroId;
	}
	public void setInitHeroId(int initHeroId) {
		this.initHeroId = initHeroId;
	}
}
