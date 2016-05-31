package com.execel.formater;

import java.util.Date;

import com.utils.TimeUtil;
import com.utils.TimeUtil.DATE_FORMATER;


public class TimeFormater extends ValueFormater {

	public TimeFormater(String hname, String fname) {
		super(hname, fname);
	}

	@Override
	public String format(Object obj) throws Exception {
		String value = super.format(obj);
		Integer time = Integer.parseInt(value);
		if(time == 0){
			return "";
		}else{
			Date date = TimeUtil.getDate(time);
			return TimeUtil.formatDate(date, DATE_FORMATER.yyyy_MM_dd_HH_mm_ss);
		}
	}
	
}