package com.ks.object;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import lombok.Data;

import com.ks.util.XyTimeUtil;

@Data
public class CycleCard {
	/**支付id*/
	private int payId;
	/**到期时间*/
	private int endTime;
	/**最后一次领取时间*/
	private int receiveTime;
	public CycleCard(List<Integer> list){
		this.payId = list.get(0);
		this.endTime = list.get(1);
		this.receiveTime = list.get(2);
	}
	public CycleCard(int payId, int day){
		this.payId = payId;
		this.endTime = getTime(day);
	}
	public void updateEndTime(int day){
		if(XyTimeUtil.before(endTime, XyTimeUtil.getNowSecond())){
			this.endTime = getTime(day);
			this.receiveTime = 0;
		}else{
			this.endTime += XyTimeUtil.DAY_SECOND * day;
		}
	}
	private int getTime(int day){
		Date date = XyTimeUtil.getNextDate(XyTimeUtil.getDate(0, 0, 0), Calendar.DAY_OF_YEAR, day);
		return XyTimeUtil.getTimeOfSecond(date);
	}
	public boolean canBuy(int day){
		int now = XyTimeUtil.getNowSecond();
		return endTime < now || now > endTime - XyTimeUtil.DAY_SECOND * day;
	}
	public boolean isOutTime(){
		return endTime < XyTimeUtil.getNowSecond();
	}
}
