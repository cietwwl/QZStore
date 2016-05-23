package com.ks.protocol.vo.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.ks.model.user.UserBaseinfo;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 用户基础信息
 * @author ks
 */
@EqualsAndHashCode(callSuper=true)
@Data
public abstract class UserBaseinfoVO extends Message {

	private static final long serialVersionUID = 1L;
	private int userId;
	@FieldDesc(desc="等级")
	private int level;
	@FieldDesc(desc="玩家名称")
	private String playerName;
	@FieldDesc(desc="英雄编号")
	private int heroId;
	@FieldDesc(desc="今天胜场")
	private int todayWins;
	@FieldDesc(desc="今天最大连胜场次")
	private int todayMaxWins;
	@FieldDesc(desc="竞技场战斗力")
	private int fighting;
	@FieldDesc(desc="当前连胜场次")
	private int streakWin;
	@FieldDesc(desc="累计充值")
	private int chargeDiamond;
	@FieldDesc(desc="是否在线")
	private boolean online;
	@FieldDesc(desc="公会名称")
	private String guildName = "";
	@FieldDesc(desc="vip等级")
	private int vip;
	public void init(UserBaseinfo o){
		this.level = o.getLevel();
		this.playerName = o.getPlayerName();
		this.fighting = o.getFighting();
		this.heroId = o.getHeroId();
		this.userId = o.getUserId();
		this.todayMaxWins=o.getTodayMaxWins();
		this.todayWins=o.getTodayWins();
		this.streakWin=o.getStreakWin();
		this.chargeDiamond = o.getChargeDiamond();
		this.online = o.isOnline();
		this.guildName = o.getGuildName();
		this.vip = o.getVip();
	}
	
}
