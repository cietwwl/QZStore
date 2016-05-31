package com.ks.db.model;

import java.io.Serializable;

import com.ks.access.DBFieldSet;

import lombok.Data;
/**
 * 物品
 * @author ks
 */
@Data
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
	
}
