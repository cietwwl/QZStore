package com.ks.game.handler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ks.app.Application;
import com.ks.db.model.Guild;
import com.ks.db.model.GuildApply;
import com.ks.game.model.Player;
import com.ks.handler.GameHandler;
import com.ks.model.page.PagingModel;
import com.ks.protocol.MainCmd;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.SubCmd;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.GuildCMD;
import com.ks.protocol.vo.guild.GuildApplyVO;
import com.ks.protocol.vo.guild.GuildVO;

@MainCmd(mainCmd=MainCMD.GUILD)
public class GuildHandler extends ActionAdapter {
	
	/**
	 * 创建公会
	 * @param handler 用户编号
	 * @param name 玩家名
	 * @param moneyType 消费类型
	 */
	@SubCmd(subCmd=GuildCMD.CREATE_GUILD,args={"String","int"})
	public void createGuild(GameHandler handler,String name,int moneyType){
		Player player = handler.getPlayer();
		guildAction().createGuild(player.getUserId(), name, moneyType);
		Application.sendMessage(handler.getChannel(), handler.getHead());
	}
	/**
	 * 获得公会信息
	 * @param handler 用户编号
	 */
	@SubCmd(subCmd=GuildCMD.GAIN_GUILD_INFO)
	public void gainGuildInfo(GameHandler handler){
		Player player = handler.getPlayer();
		Application.sendMessage(handler.getChannel(), handler.getHead(),guildAction().gainGuildInfo(player.getUserId()));
	}
	/**
	 * 获得公会排名
	 * @param handler
	 * @param pageIndex
	 */
	@SubCmd(subCmd=GuildCMD.GAIN_GUILD_RANK,args={"int"})
	public void  gainGuildRank(GameHandler handler,int pageIndex){
		PagingModel pagingModel = guildAction().gainGuildRank(pageIndex);
		List<GuildVO> vos = new ArrayList<>();
		int rank = 1;
		for(Serializable s : pagingModel.getData()){
			GuildVO vo = MessageFactory.getMessage(GuildVO.class);
			vo.init((Guild) s, rank+(pageIndex*10));
			vos.add(vo);
			rank++;
		}
		Application.sendMessage(handler.getChannel(),handler.getHead(),pagingModel.getDataCount(),vos);
	}
	/**
	 * 加入公会
	 * @param handler 用户编号
	 * @param guildId 公会编号
	 */
	@SubCmd(subCmd=GuildCMD.JOIN_GUILD,args={"int"})
	public void  joinGuild(GameHandler handler,int guildId){
		Player player = handler.getPlayer();
		Application.sendMessage(handler.getChannel(), handler.getHead(),guildAction().joinGuild(player.getUserId(),guildId));
	}
	/**
	 * 取消申请
	 * @param handler 用户编号
	 */
	@SubCmd(subCmd=GuildCMD.CANCEL_GUILD_APPLY)
	public void cancelGuildApply(GameHandler handler){
		Player player = handler.getPlayer();
		guildAction().cancelGuildApply(player.getUserId());
		Application.sendMessage(handler.getChannel(), handler.getHead());
	}
	/**
	 * 退出公会
	 * @param handler 用户编号
	 */
	@SubCmd(subCmd=GuildCMD.EXIT_GUILD)
	public void  exitGuild(GameHandler handler){
		Player player = handler.getPlayer();
		guildAction().exitGuild(player.getUserId());
		Application.sendMessage(handler.getChannel(), handler.getHead());
	}
	/**
	 * 获得成员列表
	 * @param handler 用户编号
	 */
	@SubCmd(subCmd=GuildCMD.GAIN_MEMBERS)
	public void  gainMembers(GameHandler handler){
		Player player = handler.getPlayer();
		Application.sendMessage(handler.getChannel(), handler.getHead(),guildAction().gainMembers(player.getUserId()));
	}
	/**
	 * 审批申请
	 * @param handler 用户编号
	 * @param applyUserId 审批的玩家编号
	 * @param pass 是否通过
	 */
	@SubCmd(subCmd=GuildCMD.EXEC_APPLY,args={"int","boolean"})
	public void  execApply(GameHandler handler,int applyUserId,boolean pass){
		Player player = handler.getPlayer();
		guildAction().execApply(player.getUserId(),applyUserId,pass);
		Application.sendMessage(handler.getChannel(), handler.getHead());
	}
	/**
	 * 踢出成员
	 * @param handler 用户编号
	 * @param memberId 成员编号
	 */
	@SubCmd(subCmd=GuildCMD.KICKED_OUT_MEMBER,args={"int"})
	public void  kickedOutMember(GameHandler handler,int memberId){
		Player player = handler.getPlayer();
		guildAction().kickedOutMember(player.getUserId(),memberId);
		Application.sendMessage(handler.getChannel(), handler.getHead());
	}
	
	/**
	 * 改名
	 * @param handler 用户编号
	 * @param name 名称
	 */
	@SubCmd(subCmd=GuildCMD.RENAME,args={"String"})
	public void  rename(GameHandler handler,String name){
		Player player = handler.getPlayer();
		guildAction().rename(player.getUserId(),name);
		Application.sendMessage(handler.getChannel(), handler.getHead());
	}
	/**
	 * 更改会长
	 * @param handler 用户编号
	 * @param changeUserId 更改到的人
	 */
	@SubCmd(subCmd=GuildCMD.CHANGE_PRESIDENT,args={"int"})
	public void  changePresident(GameHandler handler,int changeUserId){
		Player player = handler.getPlayer();
		guildAction().changePresident(player.getUserId(),changeUserId);
		Application.sendMessage(handler.getChannel(), handler.getHead());
	}
	/**
	 * 解散公会
	 * @param handler 用户编号
	 */
	@SubCmd(subCmd=GuildCMD.DISSOLVE_GUILD)
	public void  dissolveGuild(GameHandler handler){
		Player player = handler.getPlayer();
		guildAction().dissolveGuild(player.getUserId());
		Application.sendMessage(handler.getChannel(), handler.getHead());
	}
	
	/**
	 * 获得申请列表
	 * @param handler 用户编号
	 * @param pageIndex 页数
	 * @return 申请列表
	 */
	@SubCmd(subCmd=GuildCMD.GAIN_GUILD_APPLY,args={"int"})
	public void  gainGuildApply(GameHandler handler,int pageIndex){
		Player player = handler.getPlayer();
		PagingModel pagingModel = guildAction().gainGuildApply(player.getUserId(),pageIndex);
		
		List<GuildApplyVO> vos = new ArrayList<>();
		for(Serializable s : pagingModel.getData()){
			GuildApplyVO vo = MessageFactory.getMessage(GuildApplyVO.class);
			vo.init((GuildApply) s);
			vos.add(vo);
		}
		
		Application.sendMessage(handler.getChannel(), handler.getHead(),pagingModel.getDataCount(),vos);
	}
	/**
	 * 注入技能灵气
	 * @param handler 用户编号
	 * @param skillId 技能编号
	 * @param gp 灵气
	 */
	@SubCmd(subCmd=GuildCMD.ADD_SKILL_GP,args={"int","int"})
	public void  addSkillGP(GameHandler handler,int skillId,int gp){
		Player player = handler.getPlayer();
		guildAction().addSkillGP(player.getUserId(),skillId,gp);
		Application.sendMessage(handler.getChannel(), handler.getHead());
	}
	/**
	 * 发起弹劾会长
	 * @param handler 用户编号
	 */
	@SubCmd(subCmd=GuildCMD.INITIATE_ACCUSE_CRD)
	public void  initiateAccuseCrd(GameHandler handler){
		Player player = handler.getPlayer();
		guildAction().initiateAccuseCrd(player.getUserId());
		Application.sendMessage(handler.getChannel(), handler.getHead());
	}
	/**
	 * 响应弹劾会长
	 * @param handler 用户编号
	 */
	@SubCmd(subCmd=GuildCMD.RESP_ACCUSE)
	public void  respAccuse(GameHandler handler){
		Player player = handler.getPlayer();
		guildAction().respAccuse(player.getUserId());
		Application.sendMessage(handler.getChannel(), handler.getHead());
	}
}
