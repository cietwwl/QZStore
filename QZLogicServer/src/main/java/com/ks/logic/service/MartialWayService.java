package com.ks.logic.service;

import java.util.List;

import com.ks.access.Transaction;
import com.ks.db.cfg.MartialWayAwardExp;
import com.ks.model.martial.MartialWay;
import com.ks.protocol.vo.martial.MartialWayRankVO;
import com.ks.protocol.vo.martial.MartialWayUserVO;
import com.ks.protocol.vo.martial.MartialWayVO;

/**
 * 武道大会
 * @author ks
 */
public interface MartialWayService {
	
	/**
	 * 进入武道大会
	 * @param userId
	 * @return
	 */
	MartialWayVO enterMartialWay(int userId);
	/**
	 * 匹配
	 * @param userId
	 * @return
	 */
	@Transaction
	MartialWay math(int userId);
	/**
	 * 匹配成功
	 * @param userId
	 */
	@Transaction
	void mathSucee(List<Integer> userIds);
	/**
	 * 获得武道大会用户
	 * @return
	 */
	MartialWayUserVO gainMartialWayUser(int userId);
	/**
	 * 购买武道大会次数
	 * @param userId
	 */
	@Transaction
	void buyMartialWayCount(int userId);
	/**
	 * 修改武道大会
	 * @param way
	 */
	void updateMartialWay(MartialWay way);
	/**
	 * 获得武道大会排名
	 * @param userId
	 * @return
	 */
	MartialWayRankVO getMartialWayRank(int userId,int page);
	/**
	 * 获得奖励
	 */
	@Transaction
	void gainAward();
	/**
	 * 经验奖励
	 * @return
	 */
	List<MartialWayAwardExp> queryMartialWayAwardExp();

}
