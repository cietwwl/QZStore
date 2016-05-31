package com.ks.db.log;

import java.io.Serializable;
import java.util.Date;

import com.ks.access.DBFieldSet;
import com.ks.db.model.User;

import lombok.Data;
/**
 * 游戏日志
 * @author ks
 */
@Data
public class GameLogger implements Serializable {
	private static final long serialVersionUID = 1L;
	/**编号*/
	@DBFieldSet(dbfname="id")
	private int id;
	/**玩家ID*/
	@DBFieldSet(dbfname="user_id")
	private int userId;
	/**玩家名称*/
	@DBFieldSet(dbfname="playername")
	private String playername = "";
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
	public GameLogger(int logType, int logSubType, User user, int oamount, int amount, int samount, int assId, String logDec){
		this.loggerType = logType;
		this.userId = user.getUserId(); 
		this.playername = user.getPlayerName();
		this.type = logSubType;
		this.originalAmount = oamount;
		this.num = amount;
		this.surplusAmount = samount;
		this.assId = assId;
		this.description = logDec;
	}
	
}
