package com.ks.model.user;

import java.io.Serializable;

import lombok.Data;

import com.ks.cache.JedisFieldSet;

@Data
public class UserBaseinfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/**用户编号*/
	@JedisFieldSet()
	private int userId;
	/**等级*/
	@JedisFieldSet()
	private int level;
	/**玩家名称*/
	@JedisFieldSet()
	private String playerName;
	/**竞技场等级*/
	//private int arenaRank;
	/**英雄编号*/
	@JedisFieldSet()
	private int heroId;
	/**今天胜场*/
	@JedisFieldSet()
	private int todayWins;
	/**今天最大连胜场次*/
	@JedisFieldSet()
	private int todayMaxWins;
	/**战斗力*/
	@JedisFieldSet()
	private int fighting;
	/**当前连胜场次*/
	@JedisFieldSet()
	private int streakWin;
	/**累计充值*/
	@JedisFieldSet()
	private int chargeDiamond;
	/**是否在线*/
	@JedisFieldSet()
	private boolean online;
	/**所属公会*/
	@JedisFieldSet()
	private String guildName = "";
	/**vip等级*/
	private int vip;
	
}
