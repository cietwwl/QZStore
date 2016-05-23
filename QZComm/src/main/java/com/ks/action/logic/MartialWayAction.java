package com.ks.action.logic;

import com.ks.model.martial.MartialWay;
import com.ks.protocol.vo.martial.MartialWayRankVO;
import com.ks.protocol.vo.martial.MartialWayUserVO;
import com.ks.protocol.vo.martial.MartialWayVO;
import com.ks.rpc.Async;

/**
 * 
 * @author ks
 */
public interface MartialWayAction {
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
	MartialWay mach(int userId);
//	/**
//	 * 匹配成功
//	 * @param userId
//	 */
//	@Async
//	void mathSucee(List<Integer> userIds);
	/**
	 * 
	 * @param userId
	 * @return
	 */
	MartialWayUserVO gainMartialWayUser(int userId) ;
	/**
	 * 购买武道大会次数
	 * @param userId
	 */
	void buyMartialWayCount(int userId);
	/**
	 * 获得排名
	 * @param userId
	 * @param page
	 * @return
	 */
	MartialWayRankVO getMartialWayRank(int userId,int page);
	
	/**
	 * 获得奖励
	 */
	@Async
	void gainAward();
}
