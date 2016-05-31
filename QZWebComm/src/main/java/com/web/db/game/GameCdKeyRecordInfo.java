package com.web.db.game;

import com.db.bean.BaseBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper=true)
@Data
public class GameCdKeyRecordInfo extends BaseBean{
	private int cdkeyId;  //CDkeyId
	private String cdkey;//CDkey
	private int partner;   //兑换渠道
	private String serverId = "";//兑换服区id
	private String openid = "";//兑换者帐号
	private String nickname = "";//兑换者名称
	private int convertTime;//兑换时间
	
}
