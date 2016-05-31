package com.web.db.game;

import com.db.bean.BaseBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper=true)
@Data
public class GameDailyPayPenetranceInfo extends BaseBean implements Comparable<GameDailyPayPenetranceInfo> {
	private String serverId;
	private int time;
	private int regist;//创角数
	private int keep1 = -1;
	private int keep2 = -1;
	private int keep3 = -1;
	private int keep4 = -1;
	private int keep5 = -1;
	private int keep6 = -1;
	private int keep7 = -1;
	private int keep15 = -1;
	private int keep30 = -1;
	
	public boolean unReportKeep(int keepDay){
		if(keepDay == 1){
			return keep1 == -1;
		}else if(keepDay == 2){
			return keep2 == -1;
		}else if(keepDay == 3){
			return keep3 == -1;
		}else if(keepDay == 4){
			return keep4 == -1;
		}else if(keepDay == 5){
			return keep5 == -1;
		}else if(keepDay == 6){
			return keep6 == -1;
		}else if(keepDay == 7){
			return keep7 == -1;
		}else if(keepDay == 15){
			return keep15 == -1;
		}else if(keepDay == 30){
			return keep30 == -1;
		}
		return false;
	}
	
	public void setKeep(int keep, int keepDay){
		if(keepDay == 1){
			keep1 = keep;
		}else if(keepDay == 2){
			keep2 = keep;
		}else if(keepDay == 3){
			keep3 = keep;
		}else if(keepDay == 4){
			keep4 = keep;
		}else if(keepDay == 5){
			keep5 = keep;
		}else if(keepDay == 6){
			keep6 = keep;
		}else if(keepDay == 7){
			keep7 = keep;
		}else if(keepDay == 15){
			keep15 = keep;
		}else if(keepDay == 30){
			keep30 = keep;
		}
	}

	@Override
	public int compareTo(GameDailyPayPenetranceInfo info) {
		if(this.time < info.time){
			return -1;
		}else if(this.time > info.time){
			return 1;
		}
		return 0;
	}
}
