package com.ks.game.model;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.locks.Lock;

import com.ks.handler.GameHandler;
/**
 * 玩家
 * @author ks
 *
 */
public class Player implements Serializable {

	private static final long serialVersionUID = -1153785658945723719L;
	
	/**心跳频率 毫秒*/
	public static final long HEART_FREQUENCY = 5*60*1000L;
	/**下线时长*/
	public static final long LOGOUT_TIME = 10*60*1000L;
	private transient Lock lock;
	
	private transient GameHandler gameHandler;
	/**用户编号*/
	private int userId;
	/**合作方*/
	private int partner;
	/**用户名*/
	private String username;
	/**玩家名*/
	private String playerName;
	/**校验字段*/
	private short checkVal; 
	/**会话编号*/
	private String sessionId;
	/**最后心跳时间*/
	private Date lastHeartTime;
	/**最后发送消息时间*/
	private Date lastMessageTime = new Date();
	/**异常心跳次数*/
	private int exceptionHeartCount;
	/**对战类型*/
	private int againstType;
	/**对战用户编号*/
	private int againstUserId;
	/**对战发起时间*/
	private Date againstTime;
	/**聊天channelId*/
	private int chatChannelId;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public GameHandler getGameHandler() {
		return gameHandler;
	}
	public void setGameHandler(GameHandler gameHandler) {
		this.gameHandler = gameHandler;
	}
	public void lock(){
		this.lock.lock();
	}
	public void unlock(){
		this.lock.unlock();
	}
	public void setLock(Lock lock) {
		this.lock = lock;
	}
	public Date getLastHeartTime() {
		return lastHeartTime;
	}
	public void setLastHeartTime(Date lastHeartTime) {
		this.lastHeartTime = lastHeartTime;
	}
	public short getCheckVal() {
		return checkVal;
	}
	public void setCheckVal(short checkVal) {
		this.checkVal = checkVal;
	}
	public int getExceptionHeartCount() {
		return exceptionHeartCount;
	}
	public void setExceptionHeartCount(int exceptionHeartCount) {
		this.exceptionHeartCount = exceptionHeartCount;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public int getPartner() {
		return partner;
	}
	public void setPartner(int partner) {
		this.partner = partner;
	}
	public Date getLastMessageTime() {
		return lastMessageTime;
	}
	public void setLastMessageTime(Date lastMessageTime) {
		this.lastMessageTime = lastMessageTime;
	}
	public int getAgainstUserId() {
		return againstUserId;
	}
	public void setAgainstUserId(int againstUserId) {
		this.againstUserId = againstUserId;
	}
	public Date getAgainstTime() {
		return againstTime;
	}
	public void setAgainstTime(Date againstTime) {
		this.againstTime = againstTime;
	}
	public int getAgainstType() {
		return againstType;
	}
	public void setAgainstType(int againstType) {
		this.againstType = againstType;
	}
	public int getChatChannelId() {
		return chatChannelId;
	}
	public void setChatChannelId(int chatChannelId) {
		this.chatChannelId = chatChannelId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	@Override
	public String toString() {
		return "Player [userId=" + userId + ",playerName=" + playerName + ", checkVal=" + checkVal+ ", sessionId=" + sessionId +"]";
	}
	
}