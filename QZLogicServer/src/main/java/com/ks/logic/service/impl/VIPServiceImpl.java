package com.ks.logic.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ks.db.cfg.VipConfig;
import com.ks.db.model.User;
import com.ks.logic.cache.GameCache;
import com.ks.logic.event.task.VipLevelUpEvent;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.VIPService;
import com.ks.object.Privileges;
import com.ks.table.UserTable;
import com.ks.timer.TimerController;

public class VIPServiceImpl extends BaseService implements VIPService {
	
	@Override
	public List<VipConfig> queryVipConfigs(){
		return vipDAO.queryVipConfigs();
	}
	
	@Override
	public void updateVip(User user, int oldVip){
		if(user.getChargeDiamond() > 0){   //修复玩家vip等级
			VipConfig newConfig = GameCache.getVipConfigByMoney(user.getChargeDiamond());
			if(newConfig != null && newConfig.getVipLevel() > 0){
				if(oldVip == 0 || oldVip != newConfig.getVipLevel()){
					user.setVip(newConfig.getVipLevel());
					Map<String, String> hash = new HashMap<String, String>();
					hash.put(UserTable.J_VIP, String.valueOf(user.getVip()));
					userService.updateUser(user, hash, false);
					
					//vip升级事件
					VipLevelUpEvent event = VipLevelUpEvent.valueOf(user, oldVip, newConfig.getVipLevel());
					TimerController.submitGameEvent(event);
				}
			}
		}
		if(oldVip < user.getVip()){
			Privileges news = privilegeService.getPrivileges(user.getVip());
			user.setPrivileges(news);
			privilegeService.updateDate(user, privilegeService.getPrivileges(oldVip), news);
		}
	}
	
	@Override
	public void repairVip(User user){
		if(user.getChargeDiamond() > 0){
			int oldVip = user.getVip();
			VipConfig newConfig = GameCache.getVipConfigByMoney(user.getChargeDiamond());
			if(newConfig != null && newConfig.getVipLevel() > 0){
				if(newConfig.getVipLevel() != oldVip){
					user.setVip(newConfig.getVipLevel());
					Map<String, String> hash = new HashMap<String, String>();
					hash.put(UserTable.J_VIP, String.valueOf(user.getVip()));
					userService.updateUser(user, hash, false);

					//vip升级事件
					VipLevelUpEvent event = VipLevelUpEvent.valueOf(user, oldVip, newConfig.getVipLevel());
					TimerController.submitGameEvent(event);
				}
			}
		}
	}
	

}
