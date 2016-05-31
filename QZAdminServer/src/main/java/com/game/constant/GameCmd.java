package com.game.constant;

/**
 * 指令
 *
 */
public class GameCmd{
	/**后台充值*/
	public final static String CMD_ADMIN_RECHARGE = "RechargeDiamondAction";
	/**发送邮件*/
	public final static String CMD_SEND_MAIL = "SendSysMailAction";
	/**禁言/封号*/
	public final static String CMD_PLAYER_BAN = "BanAccountAction";
	/**发布公告*/
	public final static String CMD_PUBLISH_NOTICE = "SendAfficheAction";
	/**充值*/
	public final static String CMD_PAY_GOODS = "PayAction";
	/**聊天监控*/
	public final static String CMD_MONITOR_CHAT = "MonitorChatAction";
	/**删除游戏邮件*/
	public final static String CMD_MAIL_DELETE = "DeleteSysMailAction";
	/**添加道具*/
	public final static String CMD_ADD_ITEMS_ACTION = "AddItemsAction";
	
}
