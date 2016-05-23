package com.ks.world.kernel;

import java.io.Serializable;

/**
 * 用户静态信息
 * @author ks
 *
 */
public final class PlayerStaticInfo implements Serializable{
	
	private static final long serialVersionUID = -7443821858864443018L;
	/**用户编号*/
	private int userId;
	/**合作方*/
	private int partner;
	/**用户名*/
	private String username;
	/**玩家名*/
	private String playerName;
	/**会话编号*/
	private String sessionId;
	/**所在游戏服务器编号*/
	private String gameServerId;
	/**战斗房间编号*/
	private String battleRoomId;
	/**武道大会匹配*/
	private boolean martialWayMatch;
	/**禁言结束时间*/
	private int banChatTime;
	
	public int getPartner() {
		return partner;
	}
	public void setPartner(int partner) {
		this.partner = partner;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public String getGameServerId() {
		return gameServerId;
	}
	public void setGameServerId(String gameServerId) {
		this.gameServerId = gameServerId;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBattleRoomId() {
		return battleRoomId;
	}
	public void setBattleRoomId(String battleRoomId) {
		this.battleRoomId = battleRoomId;
	}
	public boolean isMartialWayMatch() {
		return martialWayMatch;
	}
	public void setMartialWayMatch(boolean martialWayMatch) {
		this.martialWayMatch = martialWayMatch;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getBanChatTime(){
		return banChatTime;
	}
	public void setBanChatTime(int time){
		this.banChatTime = time;
	}
	
}
