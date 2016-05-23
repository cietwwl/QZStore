package com.ks.protocol.main;
/**
 * 主命令
 * @author ks
 */
public interface MainCMD {
	/**异常码主命令*/
	short ERROR_CODE = 0;
	/**登录协议 主命令*/
	short LOGIN = 1;
	/**用户协议主命令*/
	short USER = 2;
	/**战斗*/
	short FIGHT = 3;
	/**用户英雄*/
	short USER_HERO = 4;
	/**用户队伍*/
	short USER_TEAM = 5;
	/**用户副本*/
	short USER_ZONE = 6;
	/**邮件*/
	short MAIL = 7;
	/**竞技场*/
	short ARENA = 8;
	/**公会*/
	short GUILD = 9;
	/**用户道具*/
	short USER_PROP =10;
	/**用户buff*/
	short USER_BUFF = 11;
	/**商城*/
	short MALL = 12;
	/**成就*/
	short ACHIEVE = 13;
	/**好友*/
	short FRIEND = 14;
	/**装备*/
	short EQUIPMENT = 15;
	/**武魂*/
	short ETERNAL = 16;
	/**武道大会*/
	short MARTIAL_WAY = 17;
	/**聊天*/
	short CHAT = 18;
	/**任务*/
	short TASK = 19;
	/**支付*/
	short PAY = 20;
	/**更新(服务端主动向客户端推送)*/
	short DATA = 1000;
}
