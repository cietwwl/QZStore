package com.ks.protocol.sub;


public interface GuildCMD {
	/**创建公会*/
	short CREATE_GUILD = 1;
	/**获得公会信息*/
	short GAIN_GUILD_INFO=2;
	/**获得公会排名*/
	short GAIN_GUILD_RANK=3;
	/**加入公会*/
	short JOIN_GUILD=4;
	/**取消申请*/
	short CANCEL_GUILD_APPLY=5;
	/**退出公会*/
	short EXIT_GUILD=6;
	/**获得成员列表*/
	short GAIN_MEMBERS=7;
	/**审批申请*/
	short EXEC_APPLY=8;
	/**踢出成员*/
	short KICKED_OUT_MEMBER=9;
	/**改名*/
	short RENAME=10;
	/**更改会长*/
	short CHANGE_PRESIDENT=11;
	/**解散公会*/
	short DISSOLVE_GUILD=12;
	/**获得申请列表*/
	short GAIN_GUILD_APPLY=13;
	/**注入技能灵气*/
	short ADD_SKILL_GP=14;
	/**发起弹劾会长*/
	short INITIATE_ACCUSE_CRD = 15;
	/**响应弹劾会长*/
	short RESP_ACCUSE = 16;
}
