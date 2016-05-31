package com.web.db.game;

import com.db.bean.BaseBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)
@Data
@SuppressWarnings("serial")
public class GameRefreshInfo extends BaseBean{
	private String name = "";  //名称
	private String refUrl = "";  //刷新地址
	private int type;   //类型：1区服2渠道
}
