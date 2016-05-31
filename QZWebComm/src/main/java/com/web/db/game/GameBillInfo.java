package com.web.db.game;

import com.db.bean.BaseBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 游戏订单
 *
 */
@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper=true)
@Data
public class GameBillInfo extends BaseBean{
	/**平台编号*/
	private int partner;
	/**服务器id*/
	private String serverId;
	/**玩家id*/
	private int userId;
	/**帐号名*/
	private String username;
	/**玩家昵称*/
	private String playerName;
	/**玩家等级*/
	private int level;
	/**支付商品编号*/
	private int payGoodsId;
	/**订单编号*/
	private String bill;
	/**订单状态(0初始,1确认,2完成)*/
	private int state;
	/**订单创建时间*/
	private int time;
	/**确认订单时间*/
	private int confirmTime;
	/**发货时间*/
	private int completeTime;
	/**商品价格*/
	private int money; 
	/**购物凭证（iap）*/
	private String receiptDatas = "";
	
	public boolean isConfirm(){
		return confirmTime > 0;
	}
	
	public boolean isComplete(){
		return completeTime > 0;
	}
}
