package com.ks.model.user;

import java.io.Serializable;

import com.ks.db.cfg.MallGoods;

/**
 * 黑市物品
 *
 */
public class BlackMarketGoods implements Serializable {
	private static final long serialVersionUID = 1L;
	/**是否买过*/
	private boolean buy;
	/**物品*/
	private MallGoods goods;
	public boolean isBuy() {
		return buy;
	}
	public void setBuy(boolean buy) {
		this.buy = buy;
	}
	public MallGoods getGoods() {
		return goods;
	}
	public void setGoods(MallGoods goods) {
		this.goods = goods;
	}
	
	
}
