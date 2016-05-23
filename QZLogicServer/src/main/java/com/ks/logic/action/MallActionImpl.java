package com.ks.logic.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.ks.action.logic.MallAction;
import com.ks.db.cfg.Mall;
import com.ks.logic.cache.GameCache;
import com.ks.logic.service.MallService;
import com.ks.logic.service.ServiceFactory;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.goods.GainGameAwardVO;
import com.ks.protocol.vo.mall.MallVO;
import com.ks.protocol.vo.mall.PayBillVO;

public class MallActionImpl implements MallAction {
	private static final MallService mallService = ServiceFactory.getService(MallService.class);
	@Override
	public List<MallVO> gainMall() {
		Collection<Mall> malls = GameCache.getMall();
		List<MallVO> vos = new ArrayList<MallVO>();
		for(Mall m : malls){
			if(m.getShelvesTime()!=null){
				if(m.getShelvesTime().before(new Date())){
					continue;
				}
			}
			MallVO vo = MessageFactory.getMessage(MallVO.class);
			vo.init(m);
			
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public GainGameAwardVO buy(int userId, int id, int num) {
		return mallService.buy(userId, id, num);
	}

	@Override
	public void refreshBlackMarket(int userId) {
		mallService.refreshBlackMarket(userId);
	}

	@Override
	public PayBillVO gainPayBill(int userId, int payGoodsId, String serverId) {
		return mallService.gainPayBill(userId, payGoodsId, serverId);
	}

}
