package com.cache;

import java.util.Iterator;
import java.util.List;

import com.game.service.SysJurisdictionService;
import com.web.db.bean.SysJurisdictionInfo;
import com.web.db.bean.SysMenuInfo;

/**
 * 权限缓存
 *
 */
public class SysJurisdictionCache{
	private static List<SysJurisdictionInfo> juris;
	
	public static void load(){
		try{
			juris = SysJurisdictionService.getJurisdictions();
			List<SysMenuInfo> menus = SysMenuCache.getMenus();
			Iterator<SysJurisdictionInfo> it = juris.iterator();
			while(it.hasNext()){
				SysJurisdictionInfo info = it.next();
				int menuId = info.getId() / 100;
				for(SysMenuInfo menu : menus){
					if(menu.getId() == menuId){
						menuId = 0;
						break;
					}
				}
				if(menuId != 0){
					it.remove();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static List<SysJurisdictionInfo> getJurisdictions(){
		return juris;
	}
	
	public static List<Integer> validJurids(List<Integer> ids){
		Iterator<Integer> it = ids.iterator();
		while(it.hasNext()){
			int id = it.next();
			if(id == 0){
				it.remove();
			}else{
				for(SysJurisdictionInfo info : juris){
					if(info.getId() == id){
						id = 0;
						break;
					}
				}
				if(id != 0){
					it.remove();
				}
			}
		}
		return ids;
	}
	
}
