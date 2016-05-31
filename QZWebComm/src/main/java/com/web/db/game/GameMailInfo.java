package com.web.db.game;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.db.bean.BaseBean;
import com.utils.TimeUtil;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper=true)
@Data
public class GameMailInfo extends BaseBean {
	private int partner;//渠道编号
	private String title;//标题 
	private String content;//内容
	private String items;//道具
	private int sendType = 1;//类型
	private String uids = "";//玩家ids
	private String openids = "";//玩家账号
	private int createTime = TimeUtil.getNowSecond();//创建时间
	private int state;//状态(0未审核,1审核通过,2为拒绝)
	private int uid;//申请帐号id
	private String username;//申请人
	private String serverId;//服务器id
	private boolean send;//是否发送 
	private String times = "";  //期限邮件时间
	public boolean isState(int state){
		return this.state == state;
	}
}
