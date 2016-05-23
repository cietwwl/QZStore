package com.ks.logic.service;

import java.util.List;

import com.ks.access.Transaction;
import com.ks.db.cfg.Mall;
import com.ks.db.cfg.MallGoods;
import com.ks.db.cfg.PayGoods;
import com.ks.model.user.BlackMarketGoods;
import com.ks.protocol.vo.goods.GainGameAwardVO;
import com.ks.protocol.vo.mall.PayBillVO;

/**
 * 获得mall
 * @author ks
 */
public interface MallService {
	/**
	 * 获得商城
	 * @return
	 */
	List<Mall> gainMall();
	/**
	 * 查询所有商城道具
	 * @return
	 */
	List<MallGoods>queryAllMallGoods();
	/**
	 * 购买
	 * @param userId 用户编号
	 * @param id 商城编号
	 * @param num 数量
	 * @return 获得的道具
	 */
	@Transaction
	GainGameAwardVO buy(int userId,int id,int num);
	/**
	 * 刷新黑市物品
	 * @param userId
	 */
	@Transaction
	void refreshBlackMarket(int userId);
	/**
	 * 
	 * @return
	 */
	List<BlackMarketGoods> createBlackMarketGoods() ;
	
	/**
	 * 查询支付商品
	 */
	List<PayGoods> queryPayGoods();
	

	/**
	 * 购买支付商品
	 */
	PayBillVO gainPayBill(int userId, int payGoodsId, String serverId);
}
