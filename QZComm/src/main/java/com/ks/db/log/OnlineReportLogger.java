package com.ks.db.log;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

@DBBeanSet(tablename="t_online_report_logger", primaryKey={"id"})
public class OnlineReportLogger implements Serializable{
	private static final long serialVersionUID = 1L;
	@DBFieldSet(dbfname="id")
	private int id;
	/**人数*/
	@DBFieldSet(dbfname="amount")
	private int amount;
	/**时间*/
	@DBFieldSet(dbfname="time")
	private int time;
	
	public OnlineReportLogger(){}
	public OnlineReportLogger(int amount, int time){
		this.amount = amount;
		this.time = time;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public void setAmount(int amount){
		this.amount = amount;
	}
	public int getAmount(){
		return amount;
	}
	public void setTime(int time){
		this.time = time;
	}
	public int getTime(){
		return time;
	}
}
