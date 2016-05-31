package com.web.db.game;

import com.db.bean.BaseBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper=true)
@Data
public class GameRegistReportInfo extends BaseBean implements Comparable<GameRegistReportInfo>{
	private String serverId;
	private int time;
	private int amount;
	private int addAmount;
	@Override
	public int compareTo(GameRegistReportInfo o) {
		if(o.time > time){
			return 1;
		}else{
			return -1;
		}
	}
	
}
