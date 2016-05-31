package com.ks.exceptions;

import com.ks.protocol.FieldDesc;

/**
 * 游戏异常，错误码
 * @author ks.wu
 *
 */
public class GameException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="正常")
	public static final int CODE_正常 = 0;
	@FieldDesc(desc="协议异常")
	public static final int CODE_协议异常 = 1;
	@FieldDesc(desc="已经掉线")
	public static final int CODE_已经掉线 = 2;
	@FieldDesc(desc="心跳异常")
	public static final int CODE_心跳异常 = 3;
	@FieldDesc(desc="伙伴不存在")
	public static final int CODE_伙伴不存在 = 4;
	@FieldDesc(desc="伙伴背包空间不足")
	public static final int CODE_伙伴背包空间不足 = 5;
	@FieldDesc(desc="钻石不足")
	public static final int CODE_钻石不足 = 6;
	@FieldDesc(desc="灵值不足")
	public static final int CODE_GP不足 = 7;
	@FieldDesc(desc="等级不足")
	public static final int CODE_等级不足 = 8;
	@FieldDesc(desc="对手竞技场排名发生变化")
	public static final int CODE_对手竞技场排名发生变化 = 9;
	@FieldDesc(desc="对方挑战次数不足")
	public static final int CODE_对方挑战次数不足 = 10;
	@FieldDesc(desc="挑战次数不足")
	public static final int CODE_挑战次数不足 = 11;
	@FieldDesc(desc="权限不足")
	public static final int CODE_权限不足 = 12;
	@FieldDesc(desc="名称重复")
	public static final int CODE_名称重复 = 13;
	@FieldDesc(desc="公会不存在")
	public static final int CODE_公会不存在 = 14;
	@FieldDesc(desc="人数已满")
	public static final int CODE_人数已满 =15;
	@FieldDesc(desc="没有公会")
	public static final int CODE_没有公会 =16;
	@FieldDesc(desc="申请不存在")
	public static final int CODE_申请不存在 =17;
	@FieldDesc(desc="体力不足")
	public static final int CODE_体力不足 = 18;
	@FieldDesc(desc="商品已卖完")
	public static final int CODE_商品已卖完 = 19;
	@FieldDesc(desc="商品数量不足")
	public static final int CODE_商品数量不足 = 20;
	@FieldDesc(desc="购买时间已到")
	public static final int CODE_购买时间已到 = 21;
	@FieldDesc(desc="用户不存在")
	public static final int CODE_用户不存在 = 22;
	@FieldDesc(desc="玩家名重复")
	public static final int CODE_玩家名重复 = 23;
	@FieldDesc(desc="已申请过该玩家")
	public static final int CODE_已申请过该玩家 = 24;
	@FieldDesc(desc="好友已满")
	public static final int CODE_好友已满 = 25;
	@FieldDesc(desc="对方好友已满")
	public static final int CODE_对方好友已满 = 26;
	@FieldDesc(desc="正在请求战斗")
	public static final int CODE_正在请求战斗 = 27;
	@FieldDesc(desc="战斗已取消")
	public static final int CODE_战斗已取消 = 28;
	@FieldDesc(desc="正在战斗中")
	public static final int CODE_正在战斗中 = 29;
	@FieldDesc(desc="对方正忙")
	public static final int CODE_对方正忙 = 30;
	@FieldDesc(desc="对方不在线")
	public static final int CODE_对方不在线 = 31;
	@FieldDesc(desc="活动尚未开始或已过期")
	public static final int CODE_活动尚未开始或已过期 = 32;
	@FieldDesc(desc="装备背包空间不足")
	public static final int CODE_装备背包空间不足 = 33;
	@FieldDesc(desc="装备属性不匹配")
	public static final int CODE_装备属性不匹配 = 34;
	@FieldDesc(desc="装备等级不能大于玩家等级的2倍")
	public static final int CODE_装备等级不能大于玩家等级的2倍 = 35;
	@FieldDesc(desc="装备已经达到最大等级")
	public static final int CODE_装备已经达到最大等级 = 36;
	@FieldDesc(desc="可刷新次数不足")
	public static final int CODE_可刷新次数不足 = 37;
	@FieldDesc(desc="勇气点数不够")
	public static final int CODE_勇气点数不够 = 38;
	@FieldDesc(desc="该商品已经兑换完毕")
	public static final int CODE_该商品已经兑换完毕= 39;
	@FieldDesc(desc="战斗已结束")
	public static final int CODE_战斗已结束 = 40;
	@FieldDesc(desc="好友不存在或已被删除")
	public static final int CODE_好友不存在或已被删除 = 41;
	@FieldDesc(desc="配置表数据不存在")
	public static final int CODE_配置表数据不存在 = 42;
	@FieldDesc(desc="活跃度宝箱未开启")
	public static final int CODE_活跃度宝箱未开启 = 43;
	@FieldDesc(desc="宝箱已领取")
	public static final int CODE_宝箱已领取 = 44;
	@FieldDesc(desc="奖励已领取")
	public static final int CODE_奖励已领取 = 45;
	@FieldDesc(desc="任务未完成")
	public static final int CODE_任务未完成 = 46;
	@FieldDesc(desc="灵元点已激活")
	public static final int CODE_灵元点已激活 = 47;
	@FieldDesc(desc="伙伴等级不足")
	public static final int CODE_伙伴等级不足 = 48;
	@FieldDesc(desc="请先激活所有灵元点")
	public static final int CODE_请先激活所有灵元点 = 49;
	@FieldDesc(desc="突破已达到最高等级")
	public static final int CODE_突破已达到最高等级 = 50;
	@FieldDesc(desc="该名已被使用")
	public static final int CODE_该名已被使用 = 51;
	@FieldDesc(desc="邮件不存在")
	public static final int CODE_邮件不存在 = 52;
	@FieldDesc(desc="包含敏感词汇")
	public static final int CODE_包含敏感词汇 = 53;
	@FieldDesc(desc="您已被禁言")
	public static final int CODE_您已被禁言 = 54;
	@FieldDesc(desc="您已被封号")
	public static final int CODE_您已被封号 = 55;
	@FieldDesc(desc="参数错误")
	public static final int CODE_参数错误 = 56;
	@FieldDesc(desc="金币不足")
	public static final int CODE_金币不足 = 57;
	@FieldDesc(desc="上古石板不足")
	public static final int CODE_上古石板不足 = 58;
	@FieldDesc(desc="系统错误")
	public static final int CODE_系统错误 = 59;
	@FieldDesc(desc="道具不存在")
	public static final int CODE_道具不存在 = 60;
	@FieldDesc(desc="道具不足")
	public static final int CODE_道具不足 = 61;
	@FieldDesc(desc="玩家已经注册")
	public static final int CODE_玩家已经注册 = 62;
	@FieldDesc(desc="武魂不存在")
	public static final int CODE_武魂不存在 = 63;
	@FieldDesc(desc="装备不存在")
	public static final int CODE_装备不存在 = 64;
	@FieldDesc(desc="武魂背包空间不足")
	public static final int CODE_武魂背包空间不足 = 65;
	@FieldDesc(desc="可购买次数不足")
	public static final int CODE_可购买次数不足 = 66;
	@FieldDesc(desc="伙伴经验池经验不足")
	public static final int CODE_伙伴经验池经验不足 = 67;
	@FieldDesc(desc="已达到最高等级")
	public static final int CODE_已达到最高等级 = 68;
	@FieldDesc(desc="条件未达成")
	public static final int CODE_条件未达成 = 69;
	@FieldDesc(desc="未到开启时间")
	public static final int CODE_未到开启时间 = 70;
	@FieldDesc(desc="功能未开放")
	public static final int CODE_功能未开放 = 71;
	@FieldDesc(desc="对方功能未开放")
	public static final int CODE_对方功能未开放 = 72;
	@FieldDesc(desc="该功能不支持对自己操作")
	public static final int CODE_该功能不支持对自己操作 = 73;
	@FieldDesc(desc="创建订单异常")
	public static final int CODE_创建订单异常 = 74;
	@FieldDesc(desc="商品不存在")
	public static final int CODE_商品不存在 = 75;
	@FieldDesc(desc="补签次数不足")
	public static final int CODE_补签次数不足 = 76;
	@FieldDesc(desc="材料不足")
	public static final int CODE_材料不足 = 77;
	@FieldDesc(desc="不在战斗中")
	public static final int CODE_不在战斗中 = 78;
	@FieldDesc(desc="处于冷却CD中")
	public static final int CODE_处于冷却CD中 = 79;
	@FieldDesc(desc="道具背包空间不足")
	public static final int CODE_道具背包空间不足 = 80;
	@FieldDesc(desc="无法操作队伍中的伙伴")
	public static final int CODE_无法操作队伍中的伙伴 = 81;
	@FieldDesc(desc="装备使用中")
	public static final int CODE_装备使用中 = 82;
	@FieldDesc(desc="已成为好友")
	public static final int CODE_已成为好友 = 83;
	@FieldDesc(desc="伙伴使用中")
	public static final int CODE_伙伴使用中 = 84;

	@FieldDesc(desc="缓存加载失败")
	public static final int CODE_缓存加载失败 = 100000;
	@FieldDesc(desc="渠道或用户名不能为空")
	public static final int CODE_渠道或用户名不能为空 = 100001;
	@FieldDesc(desc="订单不存在")
	public static final int CODE_订单不存在 = 100002;
	@FieldDesc(desc="订单已发货")
	public static final int CODE_订单已发货 = 100003;
	@FieldDesc(desc="订单已处理")
	public static final int CODE_订单已处理 = 100004;
	@FieldDesc(desc="订单服务器不存在")
	public static final int CODE_订单服务器不存在 = 100005;
	@FieldDesc(desc="订单非法")
	public static final int CODE_订单非法 = 100006;
	@FieldDesc(desc="渠道不存在")
	public static final int CODE_渠道不存在 = 100007;
	
	/**错误码*/
	private int code;
	public GameException(){
		
	}
	public GameException(int code,String message){
		super(message);
		this.code=code;
	}

	public int getCode() {
		return code;
	}
}
