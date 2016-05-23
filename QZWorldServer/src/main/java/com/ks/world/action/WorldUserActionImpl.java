package com.ks.world.action;

import java.util.List;

import com.ks.action.world.WorldUserAction;
import com.ks.world.kernel.WorldServerCache;

public class WorldUserActionImpl implements WorldUserAction{

	@Override
	public List<Integer> getOnlineUserIds(){
		return WorldServerCache.getOnlineUids();
	}
	
}
