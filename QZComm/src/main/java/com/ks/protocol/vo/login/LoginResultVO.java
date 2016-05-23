package com.ks.protocol.vo.login;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 登录结果
 * @author ks.wu
 *
 */
public class LoginResultVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="用户编号")
	private int userId;
	@FieldDesc(desc="玩家名")
	private String playerName;
	@FieldDesc(desc="会话编号")
	private String sessionId;
	@FieldDesc(desc="游戏服务器ip")
	private String gameServerHost;
	@FieldDesc(desc="游戏服务器端口")
	private int gameServerPort;
	
	public String getGameServerHost() {
		return gameServerHost;
	}
	public void setGameServerHost(String gameServerHost) {
		this.gameServerHost = gameServerHost;
	}
	public int getGameServerPort() {
		return gameServerPort;
	}
	public void setGameServerPort(int gameServerPort) {
		this.gameServerPort = gameServerPort;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
}
