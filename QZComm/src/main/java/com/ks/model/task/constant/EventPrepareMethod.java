package com.ks.model.task.constant;

public interface EventPrepareMethod {
	
	/**
	 * 获取玩家等级(队伍等级)
	 * 
	 */
	String GET_PLAYERLEVEL = "GET_PLAYERLEVEL";
	
	/**
	 * 是否通过指定关卡
	 */
	String ISPASS_BATTLE = "ISPASS_BATTLE";
	
	/**
	 * 是否通关整个指定章节
	 */
	String ISPASS_ZONE = "ISPASS_ZONE";
	
	/**
	 * 查询指定章节获取的星星
	 */
	String GET_ZONE_STAR = "GET_ZONE_STAR";
	
	/**
	 * 获取拥有X品质(星)以上的伙伴数量
	 */
	String GET_HERO_BYQUALITY = "GET_HERO_BYQUALITY";
	
	/**
	 * 获取今日装备提升等级之和
	 */
	String TODAY_EQUIP_LEVELUP_TIMES = "TODAY_EQUIP_LEVELUP_TIMES";
	
	/**
	 * 获取今日英雄提升等级之和
	 */
	String TODAY_HERO_LEVELUP_TIMES = "TODAY_HERO_LEVELUP_TIMES";
	
	/**
	 * 获取累计装备提升等级之和
	 */
	String EQUIP_LEVELUP_TIMES = "EQUIP_LEVELUP_TIMES";
	
	/**
	 * 获取累计英雄提升等级之和
	 */
	String HERO_LEVELUP_TIMES = "HERO_LEVELUP_TIMES";
	
	
	/**
	 * 获取累计竞技场挑战次数
	 */
	String ARENAFIGHT_COUNT = "ARENAFIGHT_COUNT";
	
	/**
	 * 累计武道大会挑战次数
	 */
	String MARTIALWAY_FIGHTCOUNT = "MARTIALWAY_FIGHTCOUNT";
	
	/**
	 * 累计获得道具数量
	 */
	String ADDITEM_COUNT = "ADDITEM_COUNT";
	
	/**
	 * 是否为周期卡用户
	 */
	String IS_CYCLECARDUSER = "IS_CYCLECARDUSER";
	
	/**
	 * 是否为VIP用户
	 */
	String IS_VIPUSER = "IS_VIPUSER";

}
