package com.ks.db.model;

import java.io.Serializable;

/**
 * 商店的奖励词
 *
 */
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
	
	public int getShoppingId() {
		return shoppingId;
	}
	public void setShoppingId(int shoppingId) {
		this.shoppingId = shoppingId;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

}
