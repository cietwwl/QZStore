package com.ks.action.logic;

import java.util.List;

import com.ks.protocol.vo.goods.GainGameAwardVO;
import com.ks.protocol.vo.mall.MallVO;
import com.ks.protocol.vo.mall.PayBillVO;

public interface MallAction {
	/**
	 * 获得商城
	 * @return
	 */
	List<MallVO> gainMall();
	/**
	 * 购买
	 * @param userId 用户编号
	 * @param id 商城编号
	 * @param num 数量
	 * @return 获得的道具
	 */
	GainGameAwardVO buy(int userId,int id,int num);
	
	/**
	 * 刷新黑市
	 * @param userId
	 */
	void refreshBlackMarket(int userId);
	
	/**
	 * 获取商品订单
	 */
	PayBillVO gainPayBill(int userId, int payGoodsId, String serverId);
}
