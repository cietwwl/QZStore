package com.ks.protocol.vo.arena;



import com.ks.db.model.ArenaLogger;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;

public class ArenaLoggerVO extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="主键id")
	private int id;
	@FieldDesc(desc="用户id")
	private int userId;
	@FieldDesc(desc="用户名称")
	private String userName;
	@FieldDesc(desc="对手名称")
	private String matchUserName;
	@FieldDesc(desc="对手名称")
	private int matchLevel;
	@FieldDesc(desc="对手id")
	private int matchUserId;
	@FieldDesc(desc="胜败")
	private int winLos;
	@FieldDesc(desc="挑战时的队长id")
	private int capId;
	@FieldDesc(desc="挑战时间")
	private long createTime;
	public void init(ArenaLogger al){
		this.id=al.getId();
		this.userId=al.getUserId();
		this.userName=al.getUserName();
		this.matchUserName=al.getMatchUserName();
		this.matchLevel=al.getMatchLevel();
		this.matchUserId=al.getMatchUserId();
		this.winLos=al.getWinLos();
		this.capId=al.getCapId();
		this.createTime=al.getCreateTime().getTime();	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMatchUserName() {
		return matchUserName;
	}
	public void setMatchUserName(String matchUserName) {
		this.matchUserName = matchUserName;
	}
	public int getMatchLevel() {
		return matchLevel;
	}
	public void setMatchLevel(int matchLevel) {
		this.matchLevel = matchLevel;
	}
	public int getMatchUserId() {
		return matchUserId;
	}
	public void setMatchUserId(int matchUserId) {
		this.matchUserId = matchUserId;
	}
	public int getWinLos() {
		return winLos;
	}
	public void setWinLos(int winLos) {
		this.winLos = winLos;
	}
	public int getCapId() {
		return capId;
	}
	public void setCapId(int capId) {
		this.capId = capId;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

}
