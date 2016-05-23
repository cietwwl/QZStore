package com.ks.logic.action;

import java.util.List;

import com.ks.action.logic.GuildAction;
import com.ks.logic.service.GuildService;
import com.ks.logic.service.ServiceFactory;
import com.ks.model.page.PagingModel;
import com.ks.protocol.vo.guild.GuildInfoVO;
import com.ks.protocol.vo.guild.GuildMemberVO;

public class GuildActionImpl implements GuildAction {
	
	private static final GuildService guildService = ServiceFactory.getService(GuildService.class);
	
	@Override
	public void createGuild(int userId, String name, int moneyType) {
		guildService.createGuild(userId, name, moneyType);
	}

	@Override
	public GuildInfoVO gainGuildInfo(int userId) {
		return guildService.gainGuildInfo(userId);
	}

	@Override
	public PagingModel gainGuildRank(int pageIndex) {
		return guildService.gainGuildRank(pageIndex);
	}

	@Override
	public int joinGuild(int userId, int guildId) {
		return guildService.joinGuild(userId, guildId);
	}

	@Override
	public void cancelGuildApply(int userId) {
		guildService.cancelGuildApply(userId);
	}

	@Override
	public void exitGuild(int userId) {
		guildService.exitGuild(userId);
	}

	@Override
	public List<GuildMemberVO> gainMembers(int userId) {
		return guildService.gainMembers(userId);
	}

	@Override
	public void execApply(int userId, int applyUserId, boolean pass) {
		guildService.execApply(userId, applyUserId, pass);
	}

	@Override
	public void kickedOutMember(int userId, int memberId) {
		guildService.kickedOutMember(userId, memberId);
	}

	@Override
	public void rename(int userId, String name) {
		guildService.rename(userId, name);
	}

	@Override
	public void changePresident(int userId, int changeUserId) {
		guildService.changePresident(userId, changeUserId);
	}

	@Override
	public void dissolveGuild(int userId) {
		guildService.dissolveGuild(userId);
	}

	@Override
	public PagingModel gainGuildApply(int userId, int pageIndex) {
		return guildService.gainGuildApply(userId, pageIndex);
	}

	@Override
	public void addSkillGP(int userId, int skillId, int gp) {
		guildService.addSkillGP(userId, skillId, gp);
	}

	@Override
	public void initiateAccuseCrd(int userId) {
		guildService.initiateAccuseCrd(userId);
	}

	@Override
	public void respAccuse(int userId) {
		guildService.respAccuse(userId);
	}

	@Override
	public void grantRankAward() {
		guildService.grantRankAward();
	}

}
