package com.web.db.game;

import com.db.bean.BaseBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * CDkey
 *
 */
@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper=true)
@Data
public class GameCdKeyInfo extends BaseBean {
	private int type;  //生成类型（1普通、2通用）
	private String name = "";//名称
	private String code; //生成码
	private String desc = "";//描述
	private String rewards = "";//奖励
	private String cdkey;//生成CDkey
	private String creator;//生成者
	private int createTime;	//生成时间
	private int activated;//是否已经激活(激活的cdkey才能使用)
	private int totalNum = 1;   //可兑换数量
	private int convertNum;//已兑换数量
}
