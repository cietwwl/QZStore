package com.web.db.game;

import com.db.bean.BaseBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper=true)
@Data
public class GameRegistLossInfo extends BaseBean implements Comparable<GameRegistLossInfo>{
	private int time;
	private String serverId;
	private int newAmount;//新账号数
	private int requestRegistAmount;//请求注册数量
	private int registAmount;//成功创建数量
	private int enterAmount;//进入游戏数量
	public void setAmount(int type, int amount){
		if(type == 1){
			this.newAmount = amount;
		}else if(type == 2){
			this.requestRegistAmount = amount;
		}else if(type == 3){
			this.registAmount = amount;
		}else if(type == 4){
			this.enterAmount = amount;
		}
	}
	
	@Override
	public int compareTo(GameRegistLossInfo info) {
		if(this.time < info.time){
			return -1;
		}else if(this.time > info.time){
			return 1;
		}
		return 0;
	}
}
