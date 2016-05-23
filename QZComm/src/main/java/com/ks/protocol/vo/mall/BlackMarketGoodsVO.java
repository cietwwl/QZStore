package com.ks.protocol.vo.mall;

import com.ks.model.user.BlackMarketGoods;
import com.ks.protocol.Message;
import com.ks.protocol.MessageFactory;

public class BlackMarketGoodsVO extends Message {

	private static final long serialVersionUID = 1L;
	
	private boolean buy;
	
	private MallGoodsVO goods;

	public void init(BlackMarketGoods g){
		this.buy = g.isBuy();
		goods = MessageFactory.getMessage(MallGoodsVO.class);
		goods.init(g.getGoods());
	}
	
	public boolean isBuy() {
		return buy;
	}

	public void setBuy(boolean buy) {
		this.buy = buy;
	}

	public MallGoodsVO getGoods() {
		return goods;
	}

	public void setGoods(MallGoodsVO goods) {
		this.goods = goods;
	}
	
}
