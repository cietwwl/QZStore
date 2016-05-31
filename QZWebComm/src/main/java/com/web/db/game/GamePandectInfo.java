package com.web.db.game;

import com.db.bean.BaseBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 数据总览
 *
 */
@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper=true)
@Data
public class GamePandectInfo extends BaseBean{
	private String serverId;    //服务器id
	private int dayCountRegisterNum;   //每日累计注册人数
	private int dayCountActiveNum;  //每日累计活跃人数
	private long dayCountRecharge; //每日累计充值
	private int time;   //查询时间
	
}
