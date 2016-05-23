package com.ks.db.model;

import java.io.Serializable;

import com.ks.access.DBFieldSet;
/**
 * 物品
 * @author ks
 */
public class Goods implements Serializable {
	private static final long serialVersionUID = 1L;
	/**物品编号*/
	@DBFieldSet(dbfname="goods_id")
	private int goodsId;
	/**类型*/
	@DBFieldSet(dbfname="type")
	private int type;
	/**数量*/
	@DBFieldSet(dbfname="num")
	private int num;
	/**等级*/
	@DBFieldSet(dbfname="level")
	private int level;
	
	
	public static final Goods createGoods(int goodsId, int type, int num, int level) {
		Goods goods = new Goods();
		goods.setGoodsId(goodsId);
		goods.setType(type);
		goods.setNum(num);
		goods.setLevel(level);
		return goods;
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
}
