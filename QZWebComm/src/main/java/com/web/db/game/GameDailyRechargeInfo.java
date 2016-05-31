package com.web.db.game;

import com.db.bean.BaseBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper=true)
@Data
public class GameDailyRechargeInfo extends BaseBean {
	private String serverId;
	private String rechargeDatas = "";   //充值数据 partner_registAmount_rechargeAmount_rechargeMoney|平台编号_新注册人数_充值人数_充值金额
	private int time;  //查询时间
}
