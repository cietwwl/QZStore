package com.web.db.game;

import com.db.bean.BaseBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 持续在线
 *
 */
@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper=true)
@Data
public class GameDurationInfo extends BaseBean{
	private String serverId = "";   //服务器id
	private String durationNums = "";  //持续在线人数
	private int totalNum; //总人数
	private int time;  //查询时间
	
}
