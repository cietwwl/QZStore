package com.ks.object;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ks.util.XyStringUtil;
import com.ks.util.XyTimeUtil;

public class PeriodTime {
	private int periodDay;   //周期日
	private Date start;   //开始时间
	private Date end;   //结束时间
	
	public PeriodTime(String times) throws Exception{
		List<String> strs = XyStringUtil.parseListByString(times, XyStringUtil.SPLIT_EQUAL);
		periodDay = new Integer(strs.get(0));
		List<List<Integer>> lists = XyStringUtil.parseLists(strs.get(1), XyStringUtil.SPLIT_VERTICALLINE, XyStringUtil.SPLIT_UNDERLINE);
		int startHour = lists.get(0).get(0);  //周期开始小时
		int startMinute = lists.get(0).get(1);  //周期开始分钟
		int endHour = lists.get(1).get(0);  //周期结束小时
		int endMinute = lists.get(1).get(1);   //周期结束分钟
		Date now = XyTimeUtil.getNowDate();
		start = XyTimeUtil.getDateOfWeekDay(now, periodDay, startHour, startMinute, 0);
		end = XyTimeUtil.getDateOfWeekDay(now, periodDay, endHour, endMinute, 59);
	}
	
	public boolean isStart(){
		Date now = XyTimeUtil.getNowDate();
		if(XyTimeUtil.before(end, now)){
			int day = 1;
			if(periodDay > 0){
				day = 7;
			}
			start = XyTimeUtil.getNextDateByExecute(start, Calendar.DAY_OF_YEAR, day);
			end = XyTimeUtil.getNextDateByExecute(end, Calendar.DAY_OF_YEAR, day);
			if(XyTimeUtil.before(end, start)){
				start = XyTimeUtil.getLastDate(start, Calendar.DAY_OF_YEAR, day);
			}
		}
		return XyTimeUtil.before(start, now) && XyTimeUtil.before(now, end);
	}
	
	public int getPeriodDay(){
		return periodDay;
	}
}

