package com.ks.db.model;

import java.io.Serializable;

import lombok.Data;

/**
 * 商店的奖励词
 *
 */
@Data
public class ArenaShopping implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**商店id*/
	private int shoppingId;
	/**关联ID*/
	private int goodsId;
	/**奖励类型*/
	private int type;
	/**物品数量*/
	private int num;
	/**需要消耗的钱*/
	private int money;
	/**等级*/
	private int level;

}
