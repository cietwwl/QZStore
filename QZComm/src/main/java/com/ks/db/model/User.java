package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import lombok.Data;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.cache.JedisFieldSet;
import com.ks.object.Privileges;

/**
 * 用户
 * 
 * @author ks
 * 
 */
@Data
@DBBeanSet(tablename="t_user", primaryKey={"user_id"})
public final class User implements Serializable {
	private static final long serialVersionUID = -4899178985355267811L;
	
	/** 用户编号 */
	@DBFieldSet(dbfname="user_id")
	@JedisFieldSet()
	private int userId;
	/** 用户名 */
	@DBFieldSet(dbfname="username")
	@JedisFieldSet()
	private String username;
	/** 合作方编号 */
	@DBFieldSet(dbfname="partner")
	@JedisFieldSet()
	private int partner;
	/** 玩家名 */
	@DBFieldSet(dbfname="player_name")
	@JedisFieldSet()
	private String playerName;
	/** 等级 */
	@DBFieldSet(dbfname="level")
	@JedisFieldSet()
	private int level;
	/** 经验 */
	@DBFieldSet(dbfname="exp")
	@JedisFieldSet()
	private int exp;
	/** 经验池上限增加量 */
	@DBFieldSet(dbfname="add_exp_pool")
	@JedisFieldSet()
	private int addExpPool;
	/** 体力 */
	@DBFieldSet(dbfname="stamina")
	@JedisFieldSet()
	private int stamina;
	/** 金币 */
	@DBFieldSet(dbfname="gold")
	@JedisFieldSet()
	private int gold;
	/** 钻石 */
	@DBFieldSet(dbfname="diamond")
	@JedisFieldSet()
	private int diamond;
	/** 灵气 */
	@DBFieldSet(dbfname="gp")
	@JedisFieldSet()
	private int gp;
	/** 英雄容量 */
	@DBFieldSet(dbfname="hero_capacity")
	@JedisFieldSet()
	private int heroCapacity;
	/** 战斗编号 */
	@DBFieldSet(dbfname="fight_id")
	@JedisFieldSet()
	private String fightId = "";
	/**累计充值*/
	@DBFieldSet(dbfname="charge_diamond")
	@JedisFieldSet()
	private int chargeDiamond;
	/** 最后恢复体力时间 */
	@DBFieldSet(dbfname="last_regain_stamina_time")
	@JedisFieldSet()
	private Date lastRegainStaminaTime=new Date();
	/** 最后登录时间 */
	@DBFieldSet(dbfname="last_login_time")
	@JedisFieldSet()
	private Date lastLoginTime=new Date();
	/** 创建时间 */
	@DBFieldSet(dbfname="create_time")
	@JedisFieldSet()
	private Date createTime=new Date();
	/** 修改时间 */
	@DBFieldSet(dbfname="update_time")
	@JedisFieldSet()
	private Date updateTime=new Date();
	/**英雄经验池*/
	@DBFieldSet(dbfname="hero_exp_pool")
	@JedisFieldSet()
	private int heroExpPool;
	/**装备容量*/
	@DBFieldSet(dbfname="equipment_capacity")
	@JedisFieldSet()
	private int equipmentCapacity;
	/**武魂容量*/
	@DBFieldSet(dbfname="eternal_capacity")
	@JedisFieldSet()
	private int eternalCapacity;
	/**剧情步骤*/
	@DBFieldSet(dbfname="plot_step")
	@JedisFieldSet()
	private int plotStep;
	/**新手步骤*/
	@DBFieldSet(dbfname="guide_step")
	@JedisFieldSet()
	private int guideStep;
	/**功能解锁*/
	@DBFieldSet(dbfname="fun_unlock")
	@JedisFieldSet()
	private int funUnlock;
	/**石板*/
	@DBFieldSet(dbfname="slate")
	@JedisFieldSet()
	private int slate;
	/** 当前英雄数量 */
	@JedisFieldSet()
	private int heroSize;
	/**当前装备数量*/
	@JedisFieldSet()
	private int equipmentSize;
	/**名望*/
	@DBFieldSet(dbfname="fame")
	@JedisFieldSet()
	private int fame;
	/**是否改过名，一个玩家只有一次免费改名的机会,之后要收费*/
	@DBFieldSet(dbfname="renamed")
	@JedisFieldSet()
	private boolean renamed;
	/**是否在线*/
	@DBFieldSet(dbfname="online")
	@JedisFieldSet()
	private int online;  
	/**首次在线时长*/
	@DBFieldSet(dbfname="firstOnlineTime")
	@JedisFieldSet()
	private int firstOnlineTime;
	/**每日在线时长*/
	@DBFieldSet(dbfname="dailyOnlineTime")
	@JedisFieldSet()
	private int dailyOnlineTime;
	/**禁言时间*/
	@DBFieldSet(dbfname="banChatTime")
	@JedisFieldSet()
	private int banChatTime; 
	/**封号时间*/
	@DBFieldSet(dbfname="banLoginTime")
	@JedisFieldSet()
	private int banLoginTime;  
	/**最新访问时间*/
	@DBFieldSet(dbfname="accessTime")
	@JedisFieldSet()
	private int accessTime;
	/**战斗力*/
	@DBFieldSet(dbfname="fighting")
	@JedisFieldSet()
	private int fighting;
	/**vip等级*/
	@DBFieldSet(dbfname="vip")
	@JedisFieldSet()
	private int vip;
	
	/**占用道具格子数量*/
	private int propSize;
	/**武魂数量*/
	private int eternalSize;
	
	/**玩家特权*/
	private Privileges privileges;
	/**用户道具*/
	private Map<Integer,UserProp> props;
	/**用户装备*/
	private Map<Integer, UserEquipment> equips;
	/**用户伙伴*/
	private Map<Integer, UserHero> heros;
	/**用户武魂*/
	private Map<Integer, UserEternal> eternals;
	/**用户任务*/
	private Map<String, UserTask> tasks;
	/**用户邮件*/
	private Map<Integer, Mail> mails;
	/***/
	private UserStat stat;
	
}
