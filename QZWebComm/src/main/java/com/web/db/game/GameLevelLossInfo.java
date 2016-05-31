package com.web.db.game;

import com.db.bean.BaseBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper=true)
@Data
public class GameLevelLossInfo extends BaseBean {
	private int time;
	private String serverId;//服务器ID
	private int level;//等级
	private int levelAmount;//等级人数
	private int reachLevelAmount;//到达该等级人数
	private int registAmount;//注册人数
	private int lossAmount;//流失人数(今日未登录人数)
}
