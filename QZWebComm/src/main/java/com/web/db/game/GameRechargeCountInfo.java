package com.web.db.game;

import com.db.bean.BaseBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper=true)
@Data
public class GameRechargeCountInfo extends BaseBean {
	private int time;
	private int rechargeAmount;
	private int newRechargeAmount;
	private int rechargeAmount7;
	private int newRechargeAmount7;
	private int rechargeAmount30;
	private int newRechargeAmount30;
	private int totalRechargeAmount;
	private String serverId;
	private int type;
}
