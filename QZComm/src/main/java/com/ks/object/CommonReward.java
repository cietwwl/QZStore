package com.ks.object;

public class CommonReward {
	private int id;    //自增长id
	private int state;    //状态
	
	public CommonReward(int id, int state){
		this.id = id;
		this.state = state;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getState(){
		return state;
	}
	public void setState(int state){
		this.state = state;
	}
}
