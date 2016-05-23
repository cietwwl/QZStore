package com.ks.logic.service;

import java.util.List;

import com.ks.db.cfg.Equipment;
import com.ks.db.cfg.EquipmentProperty;
import com.ks.db.cfg.EquipmentUp;
import com.ks.db.cfg.EquipmentUpRate;

/**
 * 装备服务
 * @author ks
 */
public interface EquipmentService {
	/**
	 * 查询所有装备
	 * @return 所有装备
	 */
	List<Equipment> queryEquipment();
	/**
	 * 查询装备升级消耗
	 * 
	 * @return
	 */
	public List<EquipmentUp> queryEquipmentUp();
	/**
	 * 查询装备升级成功概率
	 * 
	 * @return
	 */
	public List<EquipmentUpRate> queryEquipmentUpRate();
	/**
	 * 附加属性
	 * 
	 * @return
	 */
	public List<EquipmentProperty> queryEquipmentProperty();
}
