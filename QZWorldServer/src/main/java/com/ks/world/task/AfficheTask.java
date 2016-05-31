package com.ks.world.task;

import java.util.TimerTask;

public class AfficheTask extends TimerTask{
	private int cycleNum;  //循环次数
	private int alreadyNum;  //已完成次数
	private int colorId;    
	private String contents; 
	
	public AfficheTask(int cycleNum, int colorId, String contents){
		this.cycleNum = cycleNum;
		this.colorId = colorId;
		this.contents = contents;
	}

	@Override
	public void run(){
		alreadyNum++;
		if(alreadyNum > cycleNum){
			this.cancel();
		}else{
			//TODO 
		}
	}

}
