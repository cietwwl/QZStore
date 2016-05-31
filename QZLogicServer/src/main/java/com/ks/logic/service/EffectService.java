package com.ks.logic.service;

import java.util.List;

import com.ks.db.model.User;
import com.ks.object.DropEffect;
import com.ks.object.ItemEffect;
import com.ks.object.ItemEffects;
import com.ks.object.Reward;
import com.ks.protocol.vo.goods.GainAwardVO;
import com.ks.protocol.vo.goods.GainGameAwardVO;

public interface EffectService {

	
	/**
	 * 解析成ItemEffect
	 * @param str=type_id_vlaue_level_probability|type_id_value_level_probability
	 * @return
	 */
	List<ItemEffect> parseItemEffects(String str, int logSubType);

	/**
	 * 解析：probability1#amount1#type_id_amount_level_probability|type_id_amount_level_probability
	 *       &probability2#amoun2t#type_id_amount_level_probability|type_id_amount_level_probability
	 * @param str
	 * @param logSubType
	 * @return
	 */
	List<DropEffect> parseDropEffects(String str, int logSubType);
	
	/**
	 * 合并道具
	 * @param items1
	 * @param items2
	 * @return
	 */
	List<ItemEffect> mergeItemEffect(List<ItemEffect> items1, List<ItemEffect> items2);

	/**
	 * 整合效果
	 */
	List<ItemEffect> mergeEffect(List<ItemEffect> list, int mult);
	
	/**
	 * 校验掉落
	 */
	int validAddDrops(User user, List<DropEffect> drops);
	
	/**
	 * 创建概率值效果
	 */
	ItemEffect createEffect(int effectType, int id, int value1, int value2, int logSubType);
	
	/**
	 * 添加掉落
	 */
	List<ItemEffect> addDrops(User user, List<DropEffect> drops, boolean dbUp);
	
	/**
	 * 校验添加
	 * @param user
	 * @param effects
	 * @return
	 */
	int validAdds(User user, ItemEffects effects);
	
	/**
	 * 校验格子数
	 * @param user
	 * @param heroSize
	 * @param eternalSize
	 * @param equipSize
	 * @param propSize
	 * @return
	 */
	int validSize(User user, int heroSize, int eternalSize, int equipSize, int propSize);
	
	/**
	 * 校验可扣除个数
	 * @param user
	 * @param effects
	 * @param delAmount
	 * @return
	 */
	int validDels(User user, ItemEffects effects, int delAmount);
	
	/**
	 * 校验扣除
	 * @param user
	 * @param effects
	 * @return
	 */
	int validDels(User user, ItemEffects effects);
	
	/**
	 * 添加收益
	 * @param user
	 * @param type
	 * @param value
	 * @param logSubType
	 */
	void addIncome(User user, int type, int value, Reward reward, boolean dbUp, int logSubType);
	
	/**
	 * 添加收益
	 * @param user
	 * @param effects
	 */
	void addIncome(User user, ItemEffects effects, Reward reward);
	
	/**
	 * 扣除效益(带校验)
	 * @param user
	 * @param type
	 * @param id
	 * @param value
	 * @param logSubType
	 */
	void delIncome(User user, int type, int id,  int value, int logSubType);
	
	/**
	 * 扣除收益
	 * @param user
	 * @param effects
	 */
	void delIncome(User user, ItemEffects effects);

	/**
	 * 添加获得返回GainAwardVO
	 * @param user
	 * @param effects
	 * @return
	 */
	GainAwardVO addGainAwardVo(User user, ItemEffects effects);

	/**
	 * 添加获得返回GainGameAwardVO
	 * @param user
	 * @param effects
	 * @return
	 */
	GainGameAwardVO addGainGameAwardVo(User user, ItemEffects effects);
	
//	/**
//	 * 掉落处理
//	 * @param user
//	 * @param userZoneBattle
//	 * @param battle
//	 * @param drops
//	 * @param reward
//	 * @param logSubType
//	 * @return
//	 */
//	List<Drop> drop(User user, UserZoneBattle userZoneBattle, Battle battle, List<Drop> drops, Reward reward, int logSubType);
}
