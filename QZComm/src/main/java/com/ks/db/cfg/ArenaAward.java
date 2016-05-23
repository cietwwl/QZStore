package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

/**
 * 商店的奖励词
 *
 */
@DBBeanSet(tablename="t_arena_award", createDeleteSql=false, createSelectSql=false, createInsertSql=false, createUpdateSql=false)
public class ArenaAward implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**商店id*/
	@DBFieldSet(dbfname="shopping_id")
	private int shoppingId;
	/**关联ID*/
	@DBFieldSet(dbfname="goods_id")
	private int goodsId;
	/**奖励类型*/
	@DBFieldSet(dbfname="type")
	private int type;
	/**物品数量*/
	@DBFieldSet(dbfname="num")
	private int num;
	/**需要消耗的钱*/
	@DBFieldSet(dbfname="money")
	private int money;
	/**等级*/
	@DBFieldSet(dbfname="level")
	private int level;
	/**概率*/
	@DBFieldSet(dbfname="rate")
	private int rate;
	
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
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	

}
