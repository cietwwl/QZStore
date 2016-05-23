package com.ks.protocol.sub;


/**
 * 好友
 * @author ks
 */
public interface FriendCMD {
	/**获得好友*/
	short GAIN_FRIENDS = 1;
	/**获得好友请求*/
	short GAIN_FRIEND_APPLY = 2;
	/**申请好友*/
	short APPLY_FRIEND = 3;
	/**同意申请*/
	short AGREE_APPLY = 4;
	/**删除申请*/
	short DELETE_APPLY = 5;
	/**删除好友*/
	short DELETE_FRIEND = 6;
	/**赠送体力*/
	short GIVING_STAMINA= 7;
	/**收取体力*/
	short COLLECT_STAMINA = 8;
	/**获得推荐好友*/
	short GAIN_FRIEND_RECO = 9;
	/**刷新推荐好友*/
	short REF_FRIEND_RECO = 10;
	/**获得好友申请*/
	short GAIN_APPLY_FRIEND = 11;
	/**战斗好友*/
	short GET_BATTLE_FRIEND = 12;
	/**战斗好友*/
	short RECEIVE_HIRE_GP = 13;
	/**获得好友体力*/
	short GAIN_GIVING_STAMINA = 14;
}
