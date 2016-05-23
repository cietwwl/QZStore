package com.ks.protocol.vo.user;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.ks.db.model.UserStat;
import com.ks.model.user.AssStat;
import com.ks.model.user.BlackMarketGoods;
import com.ks.object.CycleCard;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.mall.AssStatVO;
import com.ks.protocol.vo.mall.BlackMarketGoodsVO;
/**
 * 用户统计VO
 * @author ks
 */
@EqualsAndHashCode(callSuper=true)
@Data
public abstract class UserStatVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="竞技场挑战次数")
	private int arenaCount;
	@FieldDesc(desc="竞技场购买次数")
	private int arenaBuyCount;
	@FieldDesc(desc="竞技场刷新次数")
	private int arenaRefreshCount;
	@FieldDesc(desc="退出公会时间")
	private long exitGuildTime;
	@FieldDesc(desc="商城购买")
	private List<AssStatVO> mallBuys;
	@FieldDesc(desc="赠送过的好友")
	private List<Integer> givingFriend;
	@FieldDesc(desc="收取的体力")
	private int collectStamina;
	@FieldDesc(desc="是否领取登录礼包")
	private boolean drawLoginAward;
	@FieldDesc(desc="领取VIP礼包")
	private List<Integer> drawVIPGifis;
	@FieldDesc(desc="活动副本胜利次数")
	private List<AssStatVO> activityZoneCount;
	@FieldDesc(desc="雇佣GP")
	private int hireGp;
	@FieldDesc(desc="免费金币召唤")
	private int goldCall;
	@FieldDesc(desc="最后金币召唤时间")
	private long lastGoldCallTime;
	@FieldDesc(desc="免费钻石召唤")
	private int diamondCall;
	@FieldDesc(desc="最后钻石召唤时间")
	private long lastDiamondCallTime;
	@FieldDesc(desc="武道大会次数")
	private byte martialWayCount;
	@FieldDesc(desc="武道大会购买次数")
	private byte martialWayBuyCount;
	@FieldDesc(desc="购买金币次数")
	private byte buyGoldCount;
	@FieldDesc(desc="购买体力次数")
	private byte buyStaminaCount;
	
	@FieldDesc(desc="签到天数")
	private List<Integer> signinDays;
	@FieldDesc(desc="补签次数")
	private int fillSignin;
	@FieldDesc(desc="累计签到奖励领取")
	private List<Integer> sumSigninDays;
	@FieldDesc(desc="黑市物品")
	private List<BlackMarketGoodsVO> bmg;
	@FieldDesc(desc="商城购买")
	private List<AssStatVO> mallTotleBuyCount;
	@FieldDesc(desc="黑市刷新次数")
	private int blackMarketRefCount;
	@FieldDesc(desc="石板领取时间")
	private long slateGainTime;
	@FieldDesc(desc="周期卡")
	private List<CycleCardVO> cycleCards;
	
	public void init(UserStat stat){
		this.arenaBuyCount = stat.getArenaBuyCount();
		this.arenaCount = stat.getArenaCount();
		this.arenaRefreshCount = stat.getArenaRefreshCount();
		this.exitGuildTime = stat.getExitGuildTime().getTime();
		mallBuys = new ArrayList<AssStatVO>();
		for(AssStat mb : stat.getMallBuyCountList()){
			AssStatVO vo = MessageFactory.getMessage(AssStatVO.class);
			vo.init(mb);
			
			mallBuys.add(vo);
		}
		this.givingFriend = stat.getGivingFriendList();
		this.collectStamina = stat.getCollectStamina();
		this.drawLoginAward = stat.isDrawLoginAward();
		this.drawVIPGifis = stat.getDrawVIPGifisList();
		activityZoneCount = new ArrayList<AssStatVO>();
		for(AssStat mb : stat.getActivityZoneCountList()){
			AssStatVO vo = MessageFactory.getMessage(AssStatVO.class);
			vo.init(mb);
			
			activityZoneCount.add(vo);
		}
		this.hireGp = stat.getHireGp();
		this.goldCall = stat.getGoldCall();
		this.lastGoldCallTime = stat.getLastGoldCallTime().getTime();
		this.diamondCall = stat.getDiamondCall();
		this.lastDiamondCallTime = stat.getLastDiamondCallTime().getTime();
		this.martialWayBuyCount = stat.getMartialWayBuyCount();
		this.martialWayCount = stat.getMartialWayCount();
		this.buyGoldCount = stat.getBuyGoldCount();
		this.buyStaminaCount = stat.getBuyStaminaCount();
		this.signinDays = stat.getSigninDaysList();
		this.sumSigninDays = stat.getSumSigninDaysList();
		this.fillSignin = stat.getFillSignin();
		this.bmg = new ArrayList<BlackMarketGoodsVO>();
		for(BlackMarketGoods g : stat.getBlackMarketGoodsList()){
			BlackMarketGoodsVO b = MessageFactory.getMessage(BlackMarketGoodsVO.class);
			b.init(g);
			bmg.add(b);
		}
		mallTotleBuyCount = new ArrayList<AssStatVO>();
		for(AssStat mb : stat.getMallTotleBuyCountList()){
			AssStatVO vo = MessageFactory.getMessage(AssStatVO.class);
			vo.init(mb);
			
			mallTotleBuyCount.add(vo);
		}
		blackMarketRefCount = stat.getBlackMarketRefCount();
		slateGainTime = stat.getSlateGainTime().getTime();
		cycleCards = new ArrayList<CycleCardVO>();
		for(CycleCard card : stat.getCycleCardMap().values()){
			CycleCardVO vo = MessageFactory.getMessage(CycleCardVO.class);
			vo.setPayId(card.getPayId());
			vo.setEndTime(card.getEndTime());
			cycleCards.add(vo);
		}
	}
	
}
