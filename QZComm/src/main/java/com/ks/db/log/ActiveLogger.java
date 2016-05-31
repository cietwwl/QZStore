package com.ks.db.log;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.util.XyTimeUtil;

import lombok.Data;

/**
 * 活跃日志
 *
 */
@Data
@DBBeanSet(tablename="t_active_logger", primaryKey={"id"})
public class ActiveLogger implements Serializable{
	private static final long serialVersionUID = 1L;
	@DBFieldSet(dbfname="id")
	private int id;
	@DBFieldSet(dbfname="partner")
	private int partner;  //平台
	@DBFieldSet(dbfname="uid")
	private int uid;  //玩家id
	@DBFieldSet(dbfname="username")
	private String username;//玩家帐号
	@DBFieldSet(dbfname="playername")
	private String playername;//玩家名称
	@DBFieldSet(dbfname="loginTime")
	private int loginTime;//登录时间
	@DBFieldSet(dbfname="totalOnlineTime")
	private int totalOnlineTime;  //累计在线时间
	
	public ActiveLogger(){}
	public ActiveLogger(int partner, int uid, String username, String playername){
		this.partner = partner;
		this.uid = uid;
		this.username = username;
		this.playername = playername;
		this.loginTime = XyTimeUtil.getNowSecond();
	}
}
