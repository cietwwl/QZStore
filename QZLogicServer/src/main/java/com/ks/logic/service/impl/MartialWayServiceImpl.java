package com.ks.logic.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ks.access.SQLOpt;
import com.ks.constant.SystemConstant;
import com.ks.db.cfg.MartialWayAward;
import com.ks.db.cfg.MartialWayAwardExp;
import com.ks.db.model.Goods;
import com.ks.db.model.Mail;
import com.ks.db.model.User;
import com.ks.db.model.UserStat;
import com.ks.exceptions.GameException;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.MartialWayService;
import com.ks.model.martial.MartialWay;
import com.ks.model.martial.MartialWayAwardList;
import com.ks.model.user.UserBaseinfo;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.martial.MartialWayRankVO;
import com.ks.protocol.vo.martial.MartialWayUserVO;
import com.ks.protocol.vo.martial.MartialWayVO;
import com.ks.table.UserStatTable;
import com.ks.util.MathUtil;
import com.ks.util.XyTimeUtil;

public class MartialWayServiceImpl extends BaseService implements
		MartialWayService {

	@Override
	public MartialWayVO enterMartialWay(int userId) {
		User user = userService.getOnlineUser(userId);
		int rank=0;
		if (user.getLevel() < SystemConstant.MARTIAL_WAY_OPEN_LEVEL) {
			throw new GameException(GameException.CODE_参数错误, "");
		}
		MartialWay mw = martialWayDAO.getMartialWay(userId);
		if(mw == null){
			mw = new MartialWay();
			mw.setUserId(userId);
			mw.setLastWinTime(XyTimeUtil.parse("1979-01-01 00:00:00", XyTimeUtil.yyyy_MM_dd_HH_mm_ss1));
			martialWayDAO.addMartialWay(mw);
			martialWayDAO.updateMartialWayRank(userId, 0);
		}else{
			rank = martialWayDAO.getUserRank(userId);
		}
		MartialWayVO vo = MessageFactory.getMessage(MartialWayVO.class);
		vo.init(mw, rank);
		return vo;
	}

	@Override
	public MartialWay math(int userId) {
		User user = userService.getOnlineUser(userId);
		if (user.getLevel() < SystemConstant.MARTIAL_WAY_OPEN_LEVEL) {
			throw new GameException(GameException.CODE_功能未开放, "");
		}
		UserStat stat = userService.getUserStat(userId);
		if(!stat.hasMartialWayNum()){
			throw new GameException(GameException.CODE_挑战次数不足, "");
		}
		MartialWay mw = martialWayDAO.getMartialWay(userId);
		if(mw == null){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		return mw;
	}

	@Override
	public void mathSucee(List<Integer> userIds) {
		for(int userId : userIds){
			UserStat stat = userService.getUserStat(userId);
			SQLOpt opt = new SQLOpt();
			opt.putFieldOpt(UserStatTable.MARTIALWAYCOUNT, SQLOpt.EQUAL);
			stat.setMartialWayCount((byte) (stat.getMartialWayCount()+1));
//			userStatDAO.updateUserStat(opt, stat);
			userService.updateUserStat(stat, opt);
		}
	}

	@Override
	public MartialWayUserVO gainMartialWayUser(int userId) {
		UserBaseinfo baseInfo = userService.getUserBaseInfo(userId);
		int rank = martialWayDAO.getUserRank(userId);
		int fightingCapacity = userService.getUserFighting(userId);
		
		MartialWayUserVO vo = MessageFactory.getMessage(MartialWayUserVO.class);
		vo.init(baseInfo, rank, fightingCapacity);
		return vo;
	}

	@Override
	public void buyMartialWayCount(int userId) { 
		User user = userService.getOnlineUser(userId);
		UserStat stat = userService.getUserStat(userId);
		if(stat.getMartialWayBuyCount() >= privilegeService.getPrivilegesValue(user, SystemConstant.PRIVILEGE_TYPE_BUY_MARTIAL_WAY_NUMBER)){
			throw new GameException(GameException.CODE_可购买次数不足, "");
		}else{
			effectService.delIncome(user, SystemConstant.ITEM_EFFECT_TYPE_DIAMOND, 0, MathUtil.getBuyMartialWayCountPrice(stat.getMartialWayBuyCount()), SystemConstant.LOGGER_APPROACH_购买武道大会次数);
			stat.setMartialWayBuyCount((byte) (stat.getMartialWayBuyCount() + 1));
			SQLOpt opt = new SQLOpt();
			opt.putFieldOpt(UserStatTable.MARTIALWAYBUYCOUNT, SQLOpt.EQUAL);
//			userStatDAO.updateUserStat(opt, stat);
			userService.updateUserStat(stat, opt);
		}
	}

	@Override
	public void updateMartialWay(MartialWay way) {
		martialWayDAO.addMartialWay(way);
		martialWayDAO.updateMartialWayRank(way.getUserId(), way.getScore());
	}

	@Override
	public MartialWayRankVO getMartialWayRank(int userId,int page) {
		MartialWayRankVO vo = MessageFactory.getMessage(MartialWayRankVO.class);
		UserBaseinfo myInfo = userService.getUserBaseInfo(userId);
		MartialWay myWay = martialWayDAO.getMartialWay(userId);
		int rank = 0;
		if(myWay!=null){
			rank = martialWayDAO.getUserRank(userId);
		}
		List<Integer> userIds = martialWayDAO.gainMartialWayRank(page*10,10);
		List<MartialWay> rankWays = martialWayDAO.gainMartialWays(userIds);
		List<UserBaseinfo> rankInfos = userService.getUserBaseInfo(userIds);
		vo.init(myInfo, myWay, rank, rankInfos, rankWays,page);
		return vo;
	}

	@Override
	public void gainAward() {  
		List<MartialWayAward> as = martialWayAwardDAO.queryMartialWayAwards();
		List<MartialWayAwardList> list = new ArrayList<MartialWayAwardList>();
		out:
		for(MartialWayAward a : as){
			for(MartialWayAwardList l : list){
				if(l.getMinRank() == a.getMinRank() && l.getMaxRank() == a.getMaxRank()){
					l.getGoodses().add(Goods.createGoods(a.getGoodsId(), a.getType(), a.getNum(), a.getLevel()));
					continue out;
				}
			}
			MartialWayAwardList l = new MartialWayAwardList();
			l.setMinRank(a.getMinRank());
			l.setMaxRank(a.getMaxRank());
			l.setGoodses(new ArrayList<Goods>());
			l.getGoodses().add(Goods.createGoods(a.getGoodsId(), a.getType(), a.getNum(), a.getLevel()));
			list.add(l);
		}
		int i=1;
		for(MartialWayAwardList l : list){
			List<Integer> userIds = martialWayDAO.gainMartialWayRank(l.getMinRank()-1,l.getMaxRank()-l.getMinRank()+1);
			for(int userId : userIds){
				Mail mail = Mail.createMail(userId, SystemConstant.MAIL_TYPE_武道大会每天奖励, "", i+"", l.getGoodses());
				mailService.sendMail(userId, mail, true);
				i++;
			}
		}
		
	}

	@Override
	public List<MartialWayAwardExp> queryMartialWayAwardExp() {
		return martialWayAwardDAO.queryMartialWayAwardExp();
	}

}