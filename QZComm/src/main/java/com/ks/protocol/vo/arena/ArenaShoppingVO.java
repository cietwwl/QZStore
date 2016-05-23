package com.ks.protocol.vo.arena;

import com.ks.db.model.ArenaShopping;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;

public class ArenaShoppingVO extends Message {

	/**
	 * 商店的奖励词
	 */
	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="商店id")
	private int shoppingId;
	@FieldDesc(desc="关联ID")
	private int goodsId;
	@FieldDesc(desc="奖励类型")
	private int type;
	@FieldDesc(desc="物品数量")
	private int num;
	@FieldDesc(desc="需要消耗的钱")
	private int money;
	@FieldDesc(desc="等级")
	private int level;
	public void init(ArenaShopping o){
		this.shoppingId = o.getShoppingId();
		this.goodsId = o.getGoodsId();
		this.type  = o.getType();
		this.money=o.getMoney();
		this.num=o.getNum();
	}
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
