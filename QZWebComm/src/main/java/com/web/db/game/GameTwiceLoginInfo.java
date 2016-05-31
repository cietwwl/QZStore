package com.web.db.game;

import com.db.bean.BaseBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper=true)
@Data
public class GameTwiceLoginInfo extends BaseBean{
	private String serverId;  //服务器id
	private int twiceLoginNum;//二次登录数
	private int newNum;//新增人数
	private int time;  //查询时间
}
