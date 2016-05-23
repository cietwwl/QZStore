package com.ks.action.logic;

import java.util.List;

import com.ks.model.page.PagingModel;
import com.ks.protocol.vo.guild.GuildInfoVO;
import com.ks.protocol.vo.guild.GuildMemberVO;
import com.ks.rpc.Async;

public interface GuildAction {
	/**
	 * 创建公会
	 * @param userId 用户编号
	 * @param name 玩家名
	 * @param moneyType 消费类型
	 */
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
	int joinGuild(int userId,int guildId);
	/**
	 * 取消申请
	 * @param userId 用户编号
	 */
	void cancelGuildApply(int userId);
	/**
	 * 退出公会
	 * @param userId 用户编号
	 */
	void exitGuild(int userId);
	/**
	 * 获得成员列表
	 * @param userId 用户编号
	 * @return 成员列表
	 */
	List<GuildMemberVO> gainMembers(int userId);
	/**
	 * 审批申请
	 * @param userId 用户编号
	 * @param applyUserId 审批的玩家编号
	 * @param pass 是否通过
	 */
	void execApply(int userId,int applyUserId,boolean pass);
	/**
	 * 踢出成员
	 * @param userId 用户编号
	 * @param memberId 成员编号
	 */
	void kickedOutMember(int userId,int memberId);
	
	/**
	 * 改名
	 * @param userId 用户编号
	 * @param name 名称
	 */
	void rename(int userId,String name);
	/**
	 * 更改会长
	 * @param userId 用户编号
	 * @param changeUserId 更改到的人
	 */
	void changePresident(int userId,int changeUserId);
	/**
	 * 解散公会
	 * @param userId 用户编号
	 */
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
	void addSkillGP(int userId,int skillId,int gp);
	
	/**
	 * 发起弹劾会长
	 * @param userId 用户编号
	 */
	void initiateAccuseCrd(int userId);
	/**
	 * 响应弹劾会长
	 * @param userId 用户编号
	 */
	void respAccuse(int userId);
	
	/**
	 * 发放排名奖励
	 */
	@Async
	void grantRankAward();
}
