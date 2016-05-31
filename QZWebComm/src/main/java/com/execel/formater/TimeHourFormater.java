package com.execel.formater;

import java.util.Date;

import com.utils.TimeUtil;
import com.utils.TimeUtil.DATE_FORMATER;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)
@Data
public class TimeHourFormater extends ValueFormater {

	public TimeHourFormater(String hname, String fname) {
		super(hname, fname);
	}

	@Override
	public String format(Object obj) throws Exception {
		String value = super.format(obj);
		Integer time = Integer.parseInt(value);
		time = time / TimeUtil.HOUR_SECOND * TimeUtil.HOUR_SECOND;
		Date date = TimeUtil.getDate(time);
		return TimeUtil.formatDate(date, DATE_FORMATER.yyyy_MM_dd_HH_mm_ss);
	}

}
