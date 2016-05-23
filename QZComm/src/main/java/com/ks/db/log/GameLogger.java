package com.ks.db.log;

import java.io.Serializable;
import java.util.Date;

import com.ks.access.DBFieldSet;
/**
 * 游戏日志
 * @author ks
 */
public class GameLogger implements Serializable {
	private static final long serialVersionUID = 1L;
	/**编号*/
	@DBFieldSet(dbfname="id")
	private int id;
	/**用户编号*/
	@DBFieldSet(dbfname="user_id")
	private int userId;
	/**日志类型*/
	@DBFieldSet(dbfname="logger_type")
	private int loggerType;
	/**类型*/
	@DBFieldSet(dbfname="type")
	private int type;
	/**关联编号*/
	@DBFieldSet(dbfname="ass_id")
	private int assId;
	/**数量*/
	@DBFieldSet(dbfname="num")
	private int num;
	/**描述*/
	@DBFieldSet(dbfname="description")
	private String description;
	/**创建时间*/
	@DBFieldSet(dbfname="create_time")
	private Date createTime = new Date();
	/**原有数量*/
	@DBFieldSet(dbfname="originalAmount")
	private int originalAmount;
	/**剩余数量*/
	@DBFieldSet(dbfname="surplusAmount")
	private int surplusAmount;
	
	
	public GameLogger(){}
	public GameLogger(int logType, int logSubType, int uid, int oamount, int amount, int samount, int assId, String logDec){
		this.loggerType = logType;
		this.userId = uid; 
		this.type = logSubType;
		this.originalAmount = oamount;
		this.num = amount;
		this.surplusAmount = samount;
		this.assId = assId;
		this.description = logDec;
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
	public int getLoggerType() {
		return loggerType;
	}
	public void setLoggerType(int loggerType) {
		this.loggerType = loggerType;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getAssId() {
		return assId;
	}
	public void setAssId(int assId) {
		this.assId = assId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getOriginalAmount(){
		return originalAmount;
	}
	public void setOriginalAmount(int originalAmount){
		this.originalAmount = originalAmount;
	}
	public int getSurplusAmount(){
		return surplusAmount;
	}
	public void setSurplusAmount(int surplusAmount){
		this.surplusAmount = surplusAmount;
	}
	
}
