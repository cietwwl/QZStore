package com.ks.db.cfg;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.object.PeriodTime;
import com.ks.util.XyStringUtil;

@DBBeanSet(tablename="t_period_activity_time", createDeleteSql=false, createSelectSql=false, createInsertSql=false, createUpdateSql=false)
public class PeriodActivityTime implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**周期活动时间类型*/
	@DBFieldSet(dbfname="n_type")
	private int type;
	/**活动时间*/
	@DBFieldSet(dbfname="n_openTimes")
	private String openTimes;
	/**活动时间*/
	public Map<Integer, PeriodTime> timeMap = new HashMap<Integer, PeriodTime>();

	public void setType(int type){
		this.type = type;
	}
	public int getType(){
		return type;
	}
	public void setOpenTimes(String openTimes){
		this.openTimes = openTimes;
		initTimeMap();
	}
	public String getOpenTimes(){
		return openTimes;
	}
	
	private void initTimeMap(){
		try{
			List<String> list = XyStringUtil.parseListByString(openTimes, XyStringUtil.SPLIT_AND);
			for(String str : list){
				PeriodTime time = new PeriodTime(str);
				timeMap.put(time.getPeriodDay(), time);
			}
		}catch(Exception e){
			timeMap.clear();
			e.printStackTrace();
		}
	}
	/**
	 * 是否活动中
	 */
	public boolean isActivity(){
		for(PeriodTime time : timeMap.values()){
			if(time.isStart()){
				return true;
			}
		}
		return false;
	}
}
