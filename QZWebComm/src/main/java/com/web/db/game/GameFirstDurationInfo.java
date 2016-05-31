package com.web.db.game;

import com.db.bean.BaseBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper=true)
@Data
public class GameFirstDurationInfo extends BaseBean{
	private String serverId;   //服务器id
	private String firstDurationNums = "";  // 首登时长人数
	private int totalNum;  //总人数
	private int time;  //查询时间
}
