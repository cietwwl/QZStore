package com.ks.logic.service.impl;

import java.util.List;

import com.ks.db.cfg.Equipment;
import com.ks.db.cfg.EquipmentProperty;
import com.ks.db.cfg.EquipmentUp;
import com.ks.db.cfg.EquipmentUpRate;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.EquipmentService;

public class EquipmentServiceImpl extends BaseService implements
		EquipmentService {

	@Override
	public List<Equipment> queryEquipment() {
		return equipmentDAO.queryEquipment();
	}

	@Override
	public List<EquipmentUp> queryEquipmentUp() {
		return equipmentDAO.queryEquipmentUp();
	}

	@Override
	public List<EquipmentUpRate> queryEquipmentUpRate() {
		return equipmentDAO.queryEquipmentUpRate();
	}

	@Override
	public List<EquipmentProperty> queryEquipmentProperty() {
		return equipmentDAO.queryEquipmentProperty();
	}

}
