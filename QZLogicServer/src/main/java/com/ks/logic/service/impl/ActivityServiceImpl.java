package com.ks.logic.service.impl;

import java.util.List;

import com.ks.constant.SystemConstant;
import com.ks.db.cfg.PeriodActivityTime;
import com.ks.logic.cache.GameCache;
import com.ks.logic.service.ActivityService;
import com.ks.logic.service.BaseService;

public class ActivityServiceImpl extends BaseService implements ActivityService{

	@Override
	public List<PeriodActivityTime> queryPeriodActivityTimes() {
		return activityDao.queryPeriodActivityTimes();
	}
	
	@Override
	public boolean isMultTime(int zoneId){
		PeriodActivityTime multTime = null;
		if(zoneId == SystemConstant.ZONE_ID_BREAD_STORE){
			multTime = GameCache.getPeriodActivityTime(SystemConstant.PERIOD_TYPE_DOUBLE_BREAD_STORE);
		}else if(zoneId == SystemConstant.ZONE_ID_GOD_WEALTH){
			multTime = GameCache.getPeriodActivityTime(SystemConstant.PERIOD_TYPE_DOUBLE_GOD_WEALTH);
		}else if(zoneId == SystemConstant.ZONE_ID_ANIMA_TEMPLE){
			multTime = GameCache.getPeriodActivityTime(SystemConstant.PERIOD_TYPE_DOUBLE_ANIMA_TEMPLE);
		}
		if(multTime != null){
			return multTime.isActivity();
		}
		return false;
	}
	
	@Override
	public boolean isOpenTime(int zoneId){
		PeriodActivityTime openTime = null;
		if(zoneId == SystemConstant.ZONE_ID_GOD_WEALTH){
			openTime = GameCache.getPeriodActivityTime(SystemConstant.PERIOD_TYPE_OPEN_GOD_WEALTH);
		}else if(zoneId == SystemConstant.ZONE_ID_ANIMA_TEMPLE){
			openTime = GameCache.getPeriodActivityTime(SystemConstant.PERIOD_TYPE_OPEN_ANIMA_TEMPLE);
		}
		if(openTime != null){
			return openTime.isActivity();
		}
		return true;
	}
	
	@Override
	public int getMultNumByZoneId(int zoneId){
		if(isMultTime(zoneId) && isOpenTime(zoneId)){
			return 2;
		}
		return 1;
	}

}
