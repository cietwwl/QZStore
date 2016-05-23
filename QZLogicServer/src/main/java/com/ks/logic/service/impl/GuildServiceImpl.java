package com.ks.logic.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ks.access.SQLOpt;
import com.ks.constant.SystemConstant;
import com.ks.db.cfg.GuildRankAward;
import com.ks.db.model.Goods;
import com.ks.db.model.Guild;
import com.ks.db.model.GuildAccuse;
import com.ks.db.model.GuildApply;
import com.ks.db.model.GuildMember;
import com.ks.db.model.GuildSkill;
import com.ks.db.model.Mail;
import com.ks.db.model.User;
import com.ks.db.model.UserStat;
import com.ks.exceptions.GameException;
import com.ks.logic.cache.GameCache;
import com.ks.logic.event.GuildMailEvent;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.GuildService;
import com.ks.model.page.PagingModel;
import com.ks.model.user.UserBaseinfo;
import com.ks.object.ItemEffects;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.guild.GuildAccuseVO;
import com.ks.protocol.vo.guild.GuildApplyVO;
import com.ks.protocol.vo.guild.GuildInfoVO;
import com.ks.protocol.vo.guild.GuildMemberVO;
import com.ks.protocol.vo.guild.GuildSkillVO;
import com.ks.protocol.vo.guild.GuildVO;
import com.ks.protocol.vo.user.UserBaseinfoVO;
import com.ks.table.GuildMemberTable;
import com.ks.table.GuildTable;
import com.ks.table.UserStatTable;
import com.ks.timer.TimerController;
import com.ks.util.KeyWordsUtil;

public class GuildServiceImpl extends BaseService implements GuildService {

	@Override
	public void createGuild(int userId, String name,int moneyType) {
		if(name.length()>8){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		if(KeyWordsUtil.hasBadWords(name)){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		if(guildDAO.queryGuildCount(name)>0){
			throw new GameException(GameException.CODE_名称重复, "");
		}
		GuildMember gm = guildMemberDAO.queryGuildMember(userId);
		if(gm!=null){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		
		GuildApply guildApply = guildApplyDAO.queryGuildApply(userId);
		if(guildApply!=null){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		
		UserStat stat = userService.getUserStat(userId);
		if(System.currentTimeMillis()-stat.getExitGuildTime().getTime()<24*60*60*1000L){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		
		User user = userService.getOnlineUser(userId);
		ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_创建公会);
		if(moneyType == 1){
			effects.delItem(SystemConstant.ITEM_EFFECT_TYPE_GOLD, 0, SystemConstant.GUILD_CREATE_GOLD_PRICE);
		}else{
			effects.delItem(SystemConstant.ITEM_EFFECT_TYPE_DIAMOND, 0, SystemConstant.GUILD_CREATE_DIAMOND_PRICE);
		}
		int code = effectService.validDels(user, effects);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
		effectService.delIncome(user, effects);
		Guild guild = new Guild();
		guild.setName(name);
		guild.setCdrUserId(user.getUserId());
		guild.setMemberNum(1);
		guildDAO.addGuild(guild);
		
		GuildMember member = GuildMember.createGuildMember(userId, guild.getGuildId(), user.getPlayerName(), user.getLevel(), SystemConstant.GUILD_MEMBER_会长);
		guildMemberDAO.addGuildMember(member);
		
		for(int skillId : SystemConstant.GUILD_SKILLS){
			GuildSkill skill = new GuildSkill();
			skill.setGuildId(guild.getGuildId());
			skill.setSkillId(skillId);
			guildSkillDAO.addGuildSkill(skill);
		}
	}

	@Override
	public GuildInfoVO gainGuildInfo(int userId) {
		GuildInfoVO info = MessageFactory.getMessage(GuildInfoVO.class);
		GuildMember gm = guildMemberDAO.queryGuildMember(userId);
		if(gm!=null){
			Guild guild = guildDAO.queryGuild(gm.getGuildId());
			UserBaseinfo baseInfo = userService.getUserBaseInfo(guild.getCdrUserId());
			guild.setCdrBaseInfo(baseInfo);
			GuildVO vo = MessageFactory.getMessage(GuildVO.class);
			int rank = guildDAO.queryMyGuildRank(guild.getExp());
			vo.init(guild, rank+1);
			info.setGuild(vo);
			
			List<GuildSkill> skills = guildSkillDAO.queryGuildSkills(guild.getGuildId());
			
			List<GuildSkillVO> vos = new ArrayList<GuildSkillVO>();
			for(GuildSkill skill : skills){
				GuildSkillVO gs = MessageFactory.getMessage(GuildSkillVO.class);
				gs.init(skill);
				vos.add(gs);
			}
			info.setSkills(vos);
			
			GuildMemberVO member = MessageFactory.getMessage(GuildMemberVO.class);
			member.init(gm);
			
			UserBaseinfo baseinfo = userService.getUserBaseInfo(userId);
			UserBaseinfoVO bvo = MessageFactory.getMessage(UserBaseinfoVO.class);
			bvo.init(baseinfo);
			member.setInfo(bvo);
			
			info.setGuildMember(member);
			
			GuildAccuse accuse = guildAccuseDAO.queryGuildAccuse(gm.getGuildId());
			if(accuse!=null){
				if(System.currentTimeMillis() - accuse.getCreateTime().getTime()>1*24*60*60*1000L){
					guildAccuseDAO.deleteGuildAccuse(gm.getGuildId());
				}else{
					GuildAccuseVO accVO = MessageFactory.getMessage(GuildAccuseVO.class);
					 accVO.init(accuse);
					info.setAccuse(accVO);
				}
			}
			
			GuildMember hz = guildMemberDAO.queryCdr(gm.getGuildId());
			User cdrUser = userService.getUser(hz.getUserId());
			info.setCdrLastLoginTime(cdrUser.getLastLoginTime().getTime());
			
		}else{
			GuildApply apply = guildApplyDAO.queryGuildApply(userId);
			info.setSkills(new ArrayList<GuildSkillVO>());
			if(apply!=null){
				apply.setBaseInfo(userService.getUserBaseInfo(userId));
				GuildApplyVO applyVO = MessageFactory.getMessage(GuildApplyVO.class);
				applyVO.init(apply);
				info.setApply(applyVO);
			}
		}
		return info;
	}

	@Override
	public PagingModel gainGuildRank(int pageIndex) {
		PagingModel model = new PagingModel();
		int dataCount = guildDAO.queryGuildCount();
		int totlePageSize = dataCount%10==0?dataCount/10:dataCount/10+1;
		if(pageIndex>totlePageSize){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		List<Guild> guilds = guildDAO.queryGuildRank(pageIndex);
		
		List<Integer> userIds = new ArrayList<Integer>();
		for(Guild guild : guilds){
			userIds.add(guild.getCdrUserId());
		}
		
		List<UserBaseinfo> baseinfos = userService.getUserBaseInfo(userIds);
		
		for(Guild guild : guilds){
			for(UserBaseinfo info : baseinfos){
				if(guild.getCdrUserId() == info.getUserId()){
					guild.setCdrBaseInfo(info);
					break;
				}
			}
		}
		
		model.setDataCount(dataCount);
		model.setData(guilds);
		return model;
	}

	@Override
	public int joinGuild(int userId, int guildId) {
		User user = userService.getOnlineUser(userId);
		Guild guild = guildDAO.queryGuildLock(guildId);
		if(guild == null){
			throw new GameException(GameException.CODE_公会不存在, "");
		}
		if(guild.getMaxMemberNum()<=guild.getMemberNum()){
			throw new GameException(GameException.CODE_人数已满, "");
		}
		
		GuildMember gm = guildMemberDAO.queryGuildMember(userId);
		if(gm!=null){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		
		GuildApply guildApply = guildApplyDAO.queryGuildApply(userId);
		if(guildApply!=null){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		UserStat stat = userService.getUserStat(userId);
		if(System.currentTimeMillis()-stat.getExitGuildTime().getTime()<24*60*60*1000L){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		if(guild.getState() == SystemConstant.GUILD_STAT_自动){
			GuildMember member = GuildMember.createGuildMember(userId, guild.getGuildId(), user.getPlayerName(), user.getLevel(), SystemConstant.GUILD_MEMBER_成员);
			guildMemberDAO.addGuildMember(member);
			
			guild.setMemberNum(guild.getMemberNum() + 1);
			SQLOpt opt = new SQLOpt();
			opt.putFieldOpt(GuildTable.MEMBERNUM, SQLOpt.EQUAL);
			guildDAO.updateGuild(opt, guild);
			return 1;
		}else{
			GuildApply apply = new GuildApply();
			apply.setUserId(userId);
			apply.setGuildId(guildId);
			
			guildApplyDAO.addGuildApply(apply);
			return 2;
		}
	}

	@Override
	public void cancelGuildApply(int userId) {
		guildApplyDAO.deleteGuildApply(userId);
	}

	@Override
	public void exitGuild(int userId) {
		GuildMember gm = guildMemberDAO.queryGuildMemberLock(userId);
		if(gm == null){
			throw new GameException(GameException.CODE_没有公会, "");
		}
		if(gm.getProperty() == SystemConstant.GUILD_MEMBER_会长){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		Guild guild = guildDAO.queryGuildLock(gm.getGuildId());
		
		UserStat stat = userService.getUserStat(userId);
		stat.setExitGuildTime(new Date());
		
		SQLOpt sopt = new SQLOpt();
		sopt.putFieldOpt(UserStatTable.EXITGUILDTIME, SQLOpt.EQUAL);
//		userStatDAO.updateUserStat(sopt, stat);
		userService.updateUserStat(stat, sopt);
		
		if(guild != null){
			if(guild.getMemberNum() > 0){
				guild.setMemberNum(guild.getMemberNum() - 1);
				SQLOpt opt = new SQLOpt();
				opt.putFieldOpt(GuildTable.MEMBERNUM, SQLOpt.EQUAL);
				guildDAO.updateGuild(opt, guild);
			}
		}
		guildMemberDAO.deleteGuildMember(userId);
	}

	@Override
	public List<GuildMemberVO> gainMembers(int userId) {
		GuildMember gm = guildMemberDAO.queryGuildMember(userId);
		if(gm == null){
			throw new GameException(GameException.CODE_没有公会, "");
		}
		List<GuildMember> menbers = guildMemberDAO.queryGuildMembers(gm.getGuildId());
		List<GuildMemberVO> vos = new ArrayList<GuildMemberVO>();
		
		List<Integer> userIds = new ArrayList<Integer>();
		for(GuildMember g : menbers){
			GuildMemberVO vo = MessageFactory.getMessage(GuildMemberVO.class);
			vo.init(g);
			vos.add(vo);
			userIds.add(g.getUserId());
		}
		List<UserBaseinfo> infos = userService.getUserBaseInfo(userIds); 
		for(UserBaseinfo info : infos){
			for(GuildMemberVO vo : vos){
				if(vo.getUserId() == info.getUserId()){
					UserBaseinfoVO ub = MessageFactory.getMessage(UserBaseinfoVO.class);
					ub.init(info);
					vo.setInfo(ub);
					break;
				}
			}
		}
		return vos;
	}

	@Override
	public void execApply(int userId, int applyUserId, boolean pass) {
		GuildMember gm = guildMemberDAO.queryGuildMember(userId);
		if(gm == null){
			throw new GameException(GameException.CODE_没有公会, "");
		}
		if(gm.getProperty() != SystemConstant.GUILD_MEMBER_会长){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		GuildApply apply = guildApplyDAO.queryGuildApply(applyUserId);
		if(apply==null){
			throw new GameException(GameException.CODE_申请不存在, "");
		}
		if(apply.getGuildId()!=gm.getGuildId()){
			throw new GameException(GameException.CODE_申请不存在, "");
		}
		if(pass){
			Guild guil = guildDAO.queryGuildLock(gm.getGuildId());
			if(guil.getMaxMemberNum()<=guil.getMemberNum()){
				throw new GameException(GameException.CODE_人数已满, "");
			}
			User applyUser = userService.getUser(applyUserId);
			GuildMember member = GuildMember.createGuildMember(applyUser.getUserId(), guil.getGuildId(), applyUser.getPlayerName(), applyUser.getLevel(), SystemConstant.GUILD_MEMBER_成员);
			guildMemberDAO.addGuildMember(member);
			guil.setMemberNum(guil.getMemberNum() + 1);
			SQLOpt opt = new SQLOpt();
			opt.putFieldOpt(GuildTable.MEMBERNUM, SQLOpt.EQUAL);
			guildDAO.updateGuild(opt, guil);
		}
		guildApplyDAO.deleteGuildApply(applyUserId);
	}

	@Override
	public void kickedOutMember(int userId, int memberId) {
		if(userId == memberId){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		GuildMember hz = guildMemberDAO.queryGuildMember(userId);
		if(hz == null){
			throw new GameException(GameException.CODE_没有公会, "");
		}
		if(hz.getProperty() != SystemConstant.GUILD_MEMBER_会长){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		
		GuildMember cy = guildMemberDAO.queryGuildMember(memberId);
		if(cy == null){
			throw new GameException(GameException.CODE_没有公会, "");
		}
		if(cy.getGuildId() != hz.getGuildId()){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		
		Guild guild = new Guild();
		guild.setGuildId(hz.getGuildId());
		guild.setMemberNum(1);
		
		SQLOpt opt = new SQLOpt();
		opt.putFieldOpt(GuildTable.MEMBERNUM, SQLOpt.MINUS);
		guildDAO.updateGuild(opt, guild);
		guildMemberDAO.deleteGuildMember(memberId);
	}

	@Override
	public void rename(int userId, String name) {
		if(name.length()>8){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		if(KeyWordsUtil.hasBadWords(name)){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		if(guildDAO.queryGuildCount(name)>0){
			throw new GameException(GameException.CODE_名称重复, "");
		}
		GuildMember hz = guildMemberDAO.queryGuildMember(userId);
		if(hz == null){
			throw new GameException(GameException.CODE_没有公会, "");
		}
		if(hz.getProperty() != SystemConstant.GUILD_MEMBER_会长){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		
		User user = userService.getOnlineUser(userId);
		effectService.delIncome(user, SystemConstant.ITEM_EFFECT_TYPE_DIAMOND, 0, SystemConstant.GUILD_AMEND_NAME_DIAMOND, SystemConstant.LOGGER_APPROACH_修改公会名称);
		Guild guild = new Guild();
		guild.setGuildId(hz.getGuildId());
		guild.setName(name);
		
		SQLOpt opt = new SQLOpt();
		opt.putFieldOpt(GuildTable.NAME, SQLOpt.EQUAL);
		guildDAO.updateGuild(opt, guild);
		
		
		List<GuildMember> mems = guildMemberDAO.queryGuildMembers(hz.getGuildId());
		List<Integer> userIds = new ArrayList<Integer>();
		for(GuildMember gm : mems){
			userIds.add(gm.getUserId());
		}
		Mail mail = Mail.createMail(0, SystemConstant.MAIL_TYPE_公会改名, "", name, new ArrayList<Goods>());
		GuildMailEvent event = new GuildMailEvent(userIds, mail);
		TimerController.submitGameEvent(event);
		
	}

	@Override
	public void changePresident(int userId, int changeUserId) {
		GuildMember hz = guildMemberDAO.queryGuildMember(userId);
		if(hz == null){
			throw new GameException(GameException.CODE_没有公会, "");
		}
		if(hz.getProperty() != SystemConstant.GUILD_MEMBER_会长){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		
		GuildMember cy = guildMemberDAO.queryGuildMemberLock(changeUserId);
		if(cy == null){
			throw new GameException(GameException.CODE_没有公会, "");
		}
		if(cy.getGuildId() != hz.getGuildId()){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		
		hz.setProperty(SystemConstant.GUILD_MEMBER_成员);
		cy.setProperty(SystemConstant.GUILD_MEMBER_会长);
		
		SQLOpt opt = new SQLOpt();
		opt.putFieldOpt(GuildMemberTable.PROPERTY, SQLOpt.EQUAL);
		
		guildMemberDAO.updateGuildMemberByOpt(opt, hz);
		guildMemberDAO.updateGuildMemberByOpt(opt, cy);
		
		User user = userService.getUser(changeUserId);
		
		Guild guild = new Guild();
		guild.setGuildId(cy.getGuildId());
		guild.setCdrUserId(changeUserId);
		
		SQLOpt guildOpt = new SQLOpt();
		guildOpt.putFieldOpt(GuildTable.CDRUSERID, SQLOpt.EQUAL);
		guildDAO.updateGuild(guildOpt, guild);
		
		List<GuildMember> mems = guildMemberDAO.queryGuildMembers(hz.getGuildId());
		List<Integer> userIds = new ArrayList<Integer>();
		for(GuildMember gm : mems){
			userIds.add(gm.getUserId());
		}
		Mail mail = Mail.createMail(0, SystemConstant.MAIL_TYPE_更换会长, "", user.getPlayerName(), new ArrayList<Goods>());
		GuildMailEvent event = new GuildMailEvent(userIds, mail);
		TimerController.submitGameEvent(event);
		
	}

	@Override
	public void dissolveGuild(int userId) {
		GuildMember hz = guildMemberDAO.queryGuildMember(userId);
		if(hz == null){
			throw new GameException(GameException.CODE_没有公会, "");
		}
		if(hz.getProperty() != SystemConstant.GUILD_MEMBER_会长){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		User user = userService.getOnlineUser(userId);
		Guild guild = guildDAO.queryGuild(hz.getGuildId());
		List<GuildMember> mems = guildMemberDAO.queryGuildMembers(hz.getGuildId());
		List<Integer> userIds = new ArrayList<Integer>();
		for(GuildMember gm : mems){
			userIds.add(gm.getUserId());
			UserStat stat = userService.getUserStat(gm.getUserId());
			stat.setExitGuildTime(new Date());
			
			SQLOpt sopt = new SQLOpt();
			sopt.putFieldOpt(UserStatTable.EXITGUILDTIME, SQLOpt.EQUAL);
//			userStatDAO.updateUserStat(sopt, stat);
			userService.updateUserStat(stat, sopt);
		}
		guildMemberDAO.deleteAllGuildMember(hz.getGuildId());
		guildDAO.deleteGuild(hz.getGuildId());
		guildSkillDAO.deleteGuildSkill(hz.getGuildId());
		guildApplyDAO.deleteAllGuildApply(hz.getGuildId());
		
		Mail mail = Mail.createMail(0, SystemConstant.MAIL_TYPE_公会解散, "", guild.getName()+","+user.getPlayerName()+","+System.currentTimeMillis(), new ArrayList<Goods>());
		GuildMailEvent event = new GuildMailEvent(userIds, mail);
		TimerController.submitGameEvent(event);
	}

	@Override
	public PagingModel gainGuildApply(int userId,int pageIndex) {
		GuildMember gm = guildMemberDAO.queryGuildMember(userId);
		if(gm == null){
			throw new GameException(GameException.CODE_没有公会, "");
		}
		PagingModel model = new PagingModel();
		int dataCount = guildApplyDAO.queryGuildApplyCount(gm.getGuildId());
		int totlePageSize = dataCount%10==0?dataCount/10:dataCount/10+1;
		if(pageIndex>totlePageSize){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		List<GuildApply> applys = guildApplyDAO.queryGuildApplys(gm.getGuildId(), pageIndex);
		
		List<Integer> userIds = new ArrayList<Integer>();
		for(GuildApply apply : applys){
			userIds.add(apply.getUserId());
		}
		
		List<UserBaseinfo> baseinfos = userService.getUserBaseInfo(userIds);
		
		for(GuildApply apply : applys){
			for(UserBaseinfo info : baseinfos){
				if(apply.getUserId() == info.getUserId()){
					apply.setBaseInfo(info);
					break;
				}
			}
		}
		
		model.setDataCount(dataCount);
		model.setData(applys);
		return model;
	}

	@Override
	public void addSkillGP(int userId, int skillId,int gp) {
		GuildMember hz = guildMemberDAO.queryGuildMember(userId);
		if(hz == null){
			throw new GameException(GameException.CODE_没有公会, "");
		}
		if(hz.getProperty() != SystemConstant.GUILD_MEMBER_会长){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		Guild guild = guildDAO.queryGuild(hz.getGuildId());
		if(guild.getSkillPoint()<gp){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		
		GuildSkill skill = guildSkillDAO.queryGuildSkill(hz.getGuildId(), skillId);
		if(skill==null){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		int skillLevel = skill.getSkillLevel();
		
		skill.setGp(skill.getGp()+gp);
		guildSkillDAO.updateGuildSkill(skill);
		
		guild.setSkillPoint(gp);
		
		SQLOpt opt = new SQLOpt();
		opt.putFieldOpt(GuildTable.SKILLPOINT, SQLOpt.MINUS);
		guildDAO.updateGuild(opt, guild);
		
		if(skill.getSkillLevel()>skillLevel){
			List<GuildMember> mems = guildMemberDAO.queryGuildMembers(hz.getGuildId());
			List<Integer> userIds = new ArrayList<Integer>();
			for(GuildMember gm : mems){
				userIds.add(gm.getUserId());
			}
			Mail mail = Mail.createMail(0, SystemConstant.MAIL_TYPE_公会技能升级, "",skillId+","+skill.getSkillLevel() , new ArrayList<Goods>());
			GuildMailEvent event = new GuildMailEvent(userIds, mail);
			TimerController.submitGameEvent(event);
		}
	}

	@Override
	public void initiateAccuseCrd(int userId) {
		GuildMember guildMember = guildMemberDAO.queryGuildMember(userId);
		if(guildMember==null){
			throw new GameException(GameException.CODE_公会不存在, "");
		}
		Guild guild = guildDAO.queryGuildLock(guildMember.getGuildId());
		GuildAccuse accuse = guildAccuseDAO.queryGuildAccuse(guildMember.getGuildId());
		if(accuse!=null){
			if(System.currentTimeMillis() - accuse.getCreateTime().getTime()>1*24*60*60*1000L){
				guildAccuseDAO.deleteGuildAccuse(guildMember.getGuildId());
			}else{
				throw new GameException(GameException.CODE_参数错误, "");
			}
		}
		
		GuildMember hz = guildMemberDAO.queryCdr(guildMember.getGuildId());
		User user = userService.getUser(hz.getUserId());
		if(System.currentTimeMillis() - user.getLastLoginTime().getTime()<7*24*60*60*1000L){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		accuse = new GuildAccuse();
		accuse.setGuildId(guild.getGuildId());
		accuse.setOriginator(userId);
		accuse.setPlayerName(guildMember.getPlayerName());
		accuse.setResperList(new ArrayList<Integer>());
		guildAccuseDAO.addGuildAccuse(accuse);
		
		List<GuildMember> mems = guildMemberDAO.queryGuildMembers(hz.getGuildId());
		List<Integer> userIds = new ArrayList<Integer>();
		for(GuildMember gm : mems){
			userIds.add(gm.getUserId());
		}
		Mail mail = Mail.createMail(0, SystemConstant.MAIL_TYPE_弹劾会长, "",guildMember.getPlayerName()+","+hz.getPlayerName(), new ArrayList<Goods>());
		GuildMailEvent event = new GuildMailEvent(userIds, mail);
		TimerController.submitGameEvent(event);
	}

	@Override
	public void respAccuse(int userId) {
		GuildMember guildMember = guildMemberDAO.queryGuildMember(userId);
		if(guildMember==null){
			throw new GameException(GameException.CODE_公会不存在, "");
		}
		Guild guild = guildDAO.queryGuildLock(guildMember.getGuildId());
		GuildAccuse accuse = guildAccuseDAO.queryGuildAccuse(guild.getGuildId());
		if(accuse==null){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		accuse.getResperList().add(userId);
		if(accuse.getResperList().size()>=3){
			GuildMember hz = guildMemberDAO.queryCdr(guildMember.getGuildId());
			guildMember.setProperty(SystemConstant.GUILD_MEMBER_会长);
			hz.setProperty(SystemConstant.GUILD_MEMBER_成员);

			SQLOpt opt = new SQLOpt();
			opt.putFieldOpt(GuildMemberTable.PROPERTY, SQLOpt.EQUAL);
			
			guildMemberDAO.updateGuildMemberByOpt(opt, hz);
			guildMemberDAO.updateGuildMemberByOpt(opt, guildMember);
			
			guildAccuseDAO.deleteGuildAccuse(guild.getGuildId());
		}else{
			guildAccuseDAO.updateGuildAccuse(accuse);
		}
	}

	@Override
	public List<GuildRankAward> queryAwards() {
		return guildRankRewardDAO.queryAwards();
	}

	@Override
	public void grantRankAward() {
		List<Guild> guilds = guildDAO.queryGuildRank(0);
		for(int rank=1;rank<=3&&rank<guilds.size();rank++){
			Guild g = guilds.get(rank-1);
			
			List<GuildMember> mems = guildMemberDAO.queryGuildMembers(g.getGuildId());
			List<Integer> userIds = new ArrayList<Integer>();
			for(GuildMember gm : mems){
				userIds.add(gm.getUserId());
			}
			
			List<Goods> goodses = new ArrayList<Goods>();
			List<GuildRankAward> rankAward = GameCache.getGuildRankAwards(rank);
			for(GuildRankAward gra : rankAward){
				Goods goods = Goods.createGoods(gra.getGoodsId(), gra.getType(), gra.getNum(), gra.getLevel());
				goodses.add(goods);
			}
			
			Mail mail = Mail.createMail(0, SystemConstant.MAIL_TYPE_公会奖励, "",rank+"",goodses);
			GuildMailEvent event = new GuildMailEvent(userIds, mail);
			TimerController.submitGameEvent(event);
		}
	}
	
}
