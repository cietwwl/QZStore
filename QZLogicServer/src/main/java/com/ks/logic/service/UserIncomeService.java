package com.ks.logic.service;

import java.util.Collection;
import java.util.List;

import com.ks.access.Transaction;
import com.ks.db.model.User;
import com.ks.object.ItemEffect;

public interface UserIncomeService {
	
	/**
	 * 获取收益
	 */
	@Transaction
	void addIncomes(User user, Collection<ItemEffect> effects);
	
	/**
	 * 获取收益
	 */
	@Transaction
	List<?> addIncome(User user, ItemEffect effect);

	/**
	 * 获取收益
	 * @param user
	 * @param effectType
	 * @param value
	 * @param logSubType
	 */
	@Transaction
	void addIncome(User user, int effectType, int value, int logSubType);
	/**
	 * 获取收益
	 * @param user
	 * @param type  效果类型
	 * @param value 效果值
	 * @param logDec  日志说明
	 */
	@Transaction
	void addIncome(User user, int effectType, int value, int logSubType, String logDec);
	
	/**
	 * 扣除
	 */
	@Transaction
	void delIncomes(User user, Collection<ItemEffect> effects);

	/**
	 * 扣除
	 */
	@Transaction
	void delIncome(User user, ItemEffect effect);
	
	/**
	 * 扣除
	 */
	@Transaction
	void delIncome(User user, int effectType, int value, int logSubType);
	
	/**
	 * 扣除
	 */
	@Transaction
	void delIncome(User user, int effectType, int value, int logSubType, String logDec);
	
	/**
	 * 添加日志
	 */
	@Transaction
	void addLogger(int logType, int logSubType, int uid, int originalAmount, int amount, int surplusAmount, int assId, String logDec);
	
	void initSize(User user, int type);
}
