package com.ks.db.log;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.util.XyTimeUtil;

@DBBeanSet(tablename="t_regist_loss_logger", primaryKey={"id"})
public class RegistLossLogger implements Serializable{
	private static final long serialVersionUID = 1L;

	@DBFieldSet(dbfname="id")
	private int id;
	@DBFieldSet(dbfname="type")  
	private int type;  //1未注册，2注册，3注册完成
	@DBFieldSet(dbfname="username")
	private String username;
	@DBFieldSet(dbfname="partner")
	private int partner;
	@DBFieldSet(dbfname="time")
	private int time;
	
	public RegistLossLogger(){}
	public RegistLossLogger(int type, String username, int partner){
		this.type = type;
		this.username = username;
		this.partner = partner;
		this.time = XyTimeUtil.getNowSecond();
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public void setType(int type){
		this.type = type;
	}
	public int getType(){
		return type;
	}
	public void setUsername(String name){
		this.username = name;
	}
	public String getUsername(){
		return username;
	}
	public void setPartner(int partner){
		this.partner = partner;
	}
	public int getPartner(){
		return partner;
	}
	public void setTime(int time){
		this.time = time;
	}
	public int getTime(){
		return time;
	}
}
