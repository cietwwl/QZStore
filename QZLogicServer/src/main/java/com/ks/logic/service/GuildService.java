package com.ks.logic.service;

import java.util.List;

import com.ks.access.Transaction;
import com.ks.db.cfg.GuildRankAward;
import com.ks.model.page.PagingModel;
import com.ks.protocol.vo.guild.GuildInfoVO;
import com.ks.protocol.vo.guild.GuildMemberVO;

/**
 * 公会
 * @author ks
 */
public interface GuildService {
	/**
	 * 创建公会
	 * @param userId 用户编号
	 * @param name 玩家名
	 * @param moneyType 消费类型
	 */
	@Transaction
	void createGuild(int userId,String name,int moneyType);
	/**
	 * 获得公会信息
	 * @param userId 用户编号
	 * @return 公会信息
	 */
	GuildInfoVO gainGuildInfo(int userId);
	/**
	 * 获得公会排名
	 * @return 公会排名
	 */
	PagingModel gainGuildRank(int pageIndex);
	/**
	 * 加入公会
	 * @param userId 用户编号
	 * @param guildId 公会编号
	 */
	@Transaction
	int joinGuild(int userId,int guildId);
	/**
	 * 取消申请
	 * @param userId 用户编号
	 */
	@Transaction
	void cancelGuildApply(int userId);
	/**
	 * 退出公会
	 * @param userId 用户编号
	 */
	@Transaction
	void exitGuild(int userId);
	/**
	 * 获得成员列表
	 * @param userId 用户编号
	 * @return 成员列表
	 */
	@Transaction
	List<GuildMemberVO> gainMembers(int userId);
	/**
	 * 审批申请
	 * @param userId 用户编号
	 * @param applyUserId 审批的玩家编号
	 * @param pass 是否通过
	 */
	@Transaction
	void execApply(int userId,int applyUserId,boolean pass);
	/**
	 * 踢出成员
	 * @param userId 用户编号
	 * @param memberId 成员编号
	 */
	@Transaction
	void kickedOutMember(int userId,int memberId);
	
	/**
	 * 改名
	 * @param userId 用户编号
	 * @param name 名称
	 */
	@Transaction
	void rename(int userId,String name);
	/**
	 * 更改会长
	 * @param userId 用户编号
	 * @param changeUserId 更改到的人
	 */
	@Transaction
	void changePresident(int userId,int changeUserId);
	/**
	 * 解散公会
	 * @param userId 用户编号
	 */
	@Transaction
	void dissolveGuild(int userId);
	
	/**
	 * 获得申请列表
	 * @param userId 用户编号
	 * @param pageIndex 页数
	 * @return 申请列表
	 */
	PagingModel gainGuildApply(int userId,int pageIndex);
	/**
	 * 注入技能灵气
	 * @param userId 用户编号
	 * @param skillId 技能编号
	 * @param gp 灵气
	 */
	@Transaction
	void addSkillGP(int userId,int skillId,int gp);
	/**
	 * 发起弹劾会长
	 * @param userId 用户编号
	 */
	@Transaction
	void initiateAccuseCrd(int userId);
	/**
	 * 响应弹劾会长
	 * @param userId 用户编号
	 */
	@Transaction
	void respAccuse(int userId);
	/**
	 * 获得公会排名奖励
	 * @return 公会排名奖励
	 */
	List<GuildRankAward> queryAwards();
	/**
	 * 发放排名奖励
	 */
	@Transaction
	void grantRankAward();
}
