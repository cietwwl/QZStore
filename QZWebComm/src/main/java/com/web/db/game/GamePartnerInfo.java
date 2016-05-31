package com.web.db.game;

import com.db.bean.BaseBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 渠道
 *
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuppressWarnings("serial")
public class GamePartnerInfo extends BaseBean{
	private String name;  //名称
	private String payUrl = "";   //正式地址
	private String payDebugUrl = "";  //测试地址
	private String callbackUrl = ""; //回调地址
	private String privateKey = "";  //私钥
	private String publicKey = "";  //公钥
	
}
