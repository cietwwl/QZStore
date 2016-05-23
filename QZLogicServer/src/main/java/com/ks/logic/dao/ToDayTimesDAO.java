package com.ks.logic.dao;

import com.ks.access.GameDAOTemplate;
/**
 * 专门缓存各种今天次数的DAO
 * @author hanjie.l
 *
 */
public class ToDayTimesDAO extends GameDAOTemplate{
	
	/**装备今日提升等级*/
	private static final String EQUIP_LEVELUP_TIMES_SET = "EQUIP_LEVELUP_TIMES_SET";
	private static final String EQUIP_LEVELUP_TIMES = "EQUIP_LEVELUP_TIMES_";
	
	private static final String getEquipLevelUpKey(int userId){
		return EQUIP_LEVELUP_TIMES+userId;
	}
	
	
	public void updateEquipLevelUpTime(int useId, int times){
		sadd(EQUIP_LEVELUP_TIMES_SET, getEquipLevelUpKey(useId));
		set(getEquipLevelUpKey(useId), times+"");
	}
	
	public int getEquipLevelUpTimes(int useId){
		String value = get(getEquipLevelUpKey(useId));
		if(value == null){
			return 0;
		}
		return Integer.parseInt(value);
	}
	
}
