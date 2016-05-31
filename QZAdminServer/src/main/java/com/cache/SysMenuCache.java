package com.cache;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.game.service.SysMenuService;
import com.web.db.bean.SysMenuInfo;
import com.web.obj.UserGroup;

/**
 * 菜单缓存
 *
 */
public class SysMenuCache{
	private static List<SysMenuInfo> menus;
	
	public static void load(){
		try{
			menus = SysMenuService.getMenusInfos();
			Iterator<SysMenuInfo> it = menus.iterator();
			while(it.hasNext()){
				SysMenuInfo info = it.next();
	        	if(info.getEnable() != 1){
	        		it.remove();
	        	}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static List<SysMenuInfo> getMenus(UserGroup group){
		List<SysMenuInfo> list = new ArrayList<SysMenuInfo>();
		for(SysMenuInfo info : menus){
			if(group.hasJurisdict(info.getId() * 100)){
				list.add(info);
			}
		}
		return list;
	}
	
	public static List<SysMenuInfo> getMenus(){
		return menus;
	}
	
}
