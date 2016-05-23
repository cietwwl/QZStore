package com.ks.logic.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ks.access.SQLOpt;
import com.ks.app.Application;
import com.ks.constant.SystemConstant;
import com.ks.db.cfg.Mall;
import com.ks.db.cfg.MallGoods;
import com.ks.db.cfg.PayGoods;
import com.ks.db.model.Goods;
import com.ks.db.model.User;
import com.ks.db.model.UserStat;
import com.ks.exceptions.GameException;
import com.ks.logic.cache.GameCache;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.MallService;
import com.ks.model.user.AssStat;
import com.ks.model.user.BlackMarketGoods;
import com.ks.object.CycleCard;
import com.ks.object.ItemEffects;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.goods.GainGameAwardVO;
import com.ks.protocol.vo.mall.PayBillVO;
import com.ks.table.UserStatTable;
import com.ks.util.HttpUtil;
import com.ks.util.JSONUtil;

public class MallServiceImpl extends BaseService implements MallService {

	@Override
	public List<Mall> gainMall() {
		return mallDAO.queryAllMall();
	}

	@Override
	public GainGameAwardVO buy(int userId, int id, int amount){ 
		User user = userService.getOnlineUser(userId);
		Mall mall = GameCache.getMall(id);
		if(amount <= 0 || mall == null){
			throw new GameException(GameException.CODE_参数错误, "");
		}else if(mall.getShelvesTime() != null && mall.getShelvesTime().before(new Date())){
			throw new GameException(GameException.CODE_购买时间已到, "");
		}
		UserStat stat = userService.getUserStat(userId);
		ItemEffects removes = new ItemEffects(SystemConstant.LOGGER_APPROACH_商城购买);
		if(mall.getMoneyType() == SystemConstant.MALL_MONEY_TYPE_GOLD){
			removes.delItem(SystemConstant.ITEM_EFFECT_TYPE_GOLD, 0, amount * mall.getMoney());
		}else{
			removes.delItem(SystemConstant.ITEM_EFFECT_TYPE_DIAMOND, 0, amount * mall.getMoney());
		}
		int code = effectService.validDels(user, removes);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}else{
			ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_商城购买);
			if(mall.getType() == SystemConstant.MALL_TYPE_普通){
				effects.addItems(mall.getGoodses(), 0);
			}else if(mall.getType() == SystemConstant.MALL_TYPE_黑市){
				for(BlackMarketGoods bmg : stat.getBlackMarketGoodsList()){
					if(bmg.getGoods().getMallId() == id){
						Goods goods = bmg.getGoods();
						effects.addItem(goods.getType(), goods.getGoodsId(), goods.getNum(), goods.getLevel());
						break;
					}
				}
			}
			code = effectService.validAdds(user, effects);
			if(code != GameException.CODE_正常){
				throw new GameException(code, "");
			}else{
				SQLOpt opt = new SQLOpt();
				boolean updateStat = false;
				if(mall.getType() == SystemConstant.MALL_TYPE_普通){
					if(mall.getToleCount() > 0){
						addAssStat(stat.getMallTotleBuyCountList(), id, mall.getToleCount(), amount);
						opt.putFieldOpt(UserStatTable.MALLTOTLEBUYCOUNT, SQLOpt.EQUAL);
						updateStat = true;
					}
					if(mall.getBuyCount() > 0){
						addAssStat(stat.getMallBuyCountList(), id, mall.getBuyCount(), amount);
						opt.putFieldOpt(UserStatTable.MALLBUYCOUNT, SQLOpt.EQUAL);
						updateStat = true;
					}
				}else if(mall.getType() == SystemConstant.MALL_TYPE_黑市){
					for(BlackMarketGoods bmg : stat.getBlackMarketGoodsList()){
						if(bmg.getGoods().getMallId() == id){
							if(bmg.isBuy()){
								throw new GameException(GameException.CODE_参数错误, "");
							}
							bmg.setBuy(true);
							opt.putFieldOpt(UserStatTable.BLACKMARKETGOODS, SQLOpt.EQUAL);
							updateStat = true;
							break;
						}
					}
				}
				effectService.delIncome(user, removes);
				if(updateStat){
					userService.updateUserStat(stat, opt);
				}
				return effectService.addGainGameAwardVo(user, effects);
			}
		}
	}
	
	/**
	 * 添加记录
	 */
	private void addAssStat(List<AssStat> stats, int assId, int max, int amount){
		AssStat target = null;
		for(AssStat stat : stats){
			if(stat.getAssId() == assId){
				target = stat;
				break;
			}
		}
		if(target == null){
			target = new AssStat();
			target.setAssId(assId);
			stats.add(target);
		}
		if(max < target.getNum() + amount){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		target.setNum(target.getNum() + amount);
	}

	@Override
	public List<MallGoods> queryAllMallGoods() {
		return mallDAO.queryAllMallGoods();
	}

	@Override
	public void refreshBlackMarket(int userId){
		User user = userService.getOnlineUser(userId);
		UserStat stat = userService.getUserStat(userId);
		if(stat.getBlackMarketRefCount() >= privilegeService.getPrivilegesValue(user, SystemConstant.PRIVILEGE_TYPE_BLACK_SHOP_REFRESH_NUMBER)){
			throw new GameException(GameException.CODE_可刷新次数不足, "");
		}else{
			effectService.delIncome(user, SystemConstant.ITEM_EFFECT_TYPE_DIAMOND, 0, SystemConstant.MALL_REFRESH_BLACK_MARKET, SystemConstant.LOGGER_APPROACH_刷新黑市);
			stat.setBlackMarketRefCount(stat.getBlackMarketRefCount() + 1);
			stat.setBlackMarketGoodsList(createBlackMarketGoods());
			SQLOpt opt = new SQLOpt();
			opt.putFieldOpt(UserStatTable.BLACKMARKETGOODS, SQLOpt.EQUAL);
			opt.putFieldOpt(UserStatTable.BLACKMARKETREFCOUNT, SQLOpt.EQUAL);
//			userStatDAO.updateUserStat(opt, stat);
			userService.updateUserStat(stat, opt);
		}
	}

	public List<BlackMarketGoods> createBlackMarketGoods() {
		List<BlackMarketGoods> blackMarketGoods = new ArrayList<BlackMarketGoods>();
		for(int i=1;i<=6;i++){
			List<Mall> bmg = GameCache.getBlackMarketMalls().get(i);
			int totle = 0;
			Mall mall = null;
			int random = (int) (Math.random()*100);
			for(Mall m : bmg){
				totle += m.getRate();
				if(totle > random){
					mall = m;
					break;
				}
			}
			BlackMarketGoods bg = new BlackMarketGoods();
			bg.setBuy(false);
			bg.setGoods(mall.getGoodses().get(0));
			blackMarketGoods.add(bg);
		}
		return blackMarketGoods;
	}
	
	@Override
	public List<PayGoods> queryPayGoods(){
		return mallDAO.queryPayGoodses();
	}

	@SuppressWarnings("unchecked")
	@Override
	public PayBillVO gainPayBill(int userId, int payGoodsId, String serverId){
		User user = userService.getUser(userId);
		if(user == null){
			throw new GameException(GameException.CODE_用户不存在, "");
		}else if(serverId == null || serverId.length() == 0){
			throw new GameException(GameException.CODE_订单服务器不存在, "");
		}
		PayGoods goods = GameCache.getPayGoods(payGoodsId);
		if(goods == null){
			throw new GameException(GameException.CODE_商品不存在, "");
		}else if(goods.getType() == SystemConstant.PAY_TYPE_CYCLE_CARD){
			UserStat stat = userService.getUserStat(userId);
			CycleCard card = stat.getCycleCard(payGoodsId);
			if(card != null && !card.canBuy(goods.getBuyCD())){
				throw new GameException(GameException.CODE_处于冷却CD中, "");
			}
		}
		String param = "partner=" + user.getPartner() +  "&userId=" + userId + "&username=" + user.getUsername() + "&payGoodsId=" + payGoodsId
				+ "&playername=" + user.getPlayerName() + "&level=" + user.getLevel() + "&serverId=" + serverId + "&money=" + goods.getMoney();
		String result = HttpUtil.postRet(Application.BILL_URL, param, "UTF-8", "UTF-8");
		Map<String, Object> map = JSONUtil.toObject(result, Map.class);
		int code = (int) map.get("code");
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
		PayBillVO vo = MessageFactory.getMessage(PayBillVO.class);
		vo.setBill((String) map.get("bill"));
		return vo;
	}

}
