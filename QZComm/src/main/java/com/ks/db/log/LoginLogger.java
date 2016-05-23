package com.ks.db.log;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.util.XyTimeUtil;

@DBBeanSet(tablename="t_login_logger", primaryKey={"id"})
public class LoginLogger implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@DBFieldSet(dbfname="id")
	private int id;
	@DBFieldSet(dbfname="userId")
	private int userId; //玩家id
	@DBFieldSet(dbfname="playername")
	private String playername = "";//玩家昵称
	@DBFieldSet(dbfname="type")
	private int type;//登录类型：1注册,2登录,3退出
	@DBFieldSet(dbfname="time")
	private int time;//时间
	
	public LoginLogger(){}
	/**
	 * 登录类型：1注册,2登录,3退出
	 */
	public LoginLogger(int userId, String playername, int type){
		this.userId = userId;
		this.playername = playername;
		this.type = type;
		this.time = XyTimeUtil.getNowSecond();
	}
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getPlayername(){
		return playername;
	}
	public void setPlayername(String name){
		this.playername = name;
	}
	public int getUserId(){
		return userId;
	}
	public void setUserId(int userId){
		this.userId = userId;
	}
	public int getType(){
		return type;
	}
	public void setType(int type){
		this.type = type;
	}
	public int getTime(){
		return time;
	}
	public void setTime(int time){
		this.time = time;
	}

}
