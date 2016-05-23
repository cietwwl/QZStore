package com.ks.logic.service;

import java.util.List;

import com.ks.db.model.User;
import com.ks.db.model.UserEquipment;
import com.ks.db.model.UserEternal;
import com.ks.db.model.UserHero;
import com.ks.db.model.UserProp;
import com.ks.db.model.UserRecord;
import com.ks.db.model.UserStat;

/**
 * 更新
 * @author zck
 *
 */
public interface DataService {
	/**
	 * 更新玩家
	 * @param user
	 */
	void updateUser(User user);
	/**
	 * 更新玩家统计
	 * @param state
	 */
	void updateUserStat(UserStat stat);
	/**
	 * 更新用户道具
	 * @param prop
	 */
	void updateProp(int userId, UserProp... prop);
	/**
	 * 更新用户道具
	 * @param prop
	 */
	void updateProps(int userId, List<UserProp> props);
	/**
	 * 更新用户装备
	 * @param equip
	 */
	void updateEquip(int userId, UserEquipment... equip);
	/**
	 * 更新用户装备
	 * @param equip
	 */
	void updateEquips(int userId, List<UserEquipment> equips);
	/**
	 * 删除装备
	 * @param userId
	 * @param id
	 */
	void deleteEquip(int userId, int... id);
	/**
	 * 删除装备
	 * @param userId
	 * @param id
	 */
	void deleteEquips(int userId, List<Integer> ids);
	/**
	 * 更新武魂
	 * @param eternal
	 */
	void updateEternal(int userId, UserEternal... eternal);
	/**
	 * 更新武魂
	 * @param eternal
	 */
	void updateEternals(int userId, List<UserEternal> eternals);
	/**
	 * 删除武魂
	 * @param userId
	 * @param id
	 */
	void deleteEternal(int userId, int... id);
	/**
	 * 删除武魂
	 * @param userId
	 * @param id
	 */
	void deleteEternals(int userId, List<Integer> ids);
	/**
	 * 更新英雄
	 * @param hero
	 */
	void updateHero(int userId, UserHero... hero);
	/**
	 * 更新英雄
	 * @param hero
	 */
	void updateHeros(int userId, List<UserHero> heros);
	/**
	 * 删除英雄
	 * @param userId
	 * @param id
	 */
	void deleteHero(int userId, int... id);
	/**
	 * 删除英雄
	 * @param userId
	 * @param id
	 */
	void deleteHeros(int userId, List<Integer> ids);
	
	/**
	 * 更新用户记录
	 * @param userRecord
	 */
	void updateUserRecord(UserRecord userRecord);
}
