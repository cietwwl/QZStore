package com.ks.logic.action;

import java.util.List;

import com.ks.action.logic.UserEquipmentAction;
import com.ks.logic.service.ServiceFactory;
import com.ks.logic.service.UserEquipmentService;

public class UserEquipmentActionImpl implements UserEquipmentAction {
	
	public static final UserEquipmentService service = ServiceFactory.getService(UserEquipmentService.class);
	
	@Override
	public int levelUpEquipment(int userId, int userEquipmentId, int type) {
		return service.levelUpEquipment(userId, userEquipmentId, type);
	}

	@Override
	public void sellEquipment(int userId, List<Integer> equipments) {
		service.sellEquipment(userId, equipments);
	}

	@Override
	public void useEquipment(int userId, int userEquipmentId, int userHeroId) {
		service.useEquipment(userId, userEquipmentId, userHeroId);
	}

}
