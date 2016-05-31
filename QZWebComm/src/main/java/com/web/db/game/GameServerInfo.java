package com.web.db.game;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.db.bean.BaseBean;
import com.db.util.ConnParam;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper=true)
@Data
public class GameServerInfo extends BaseBean {
	/** 服务器ID */
	private String serverId;
	/** 区服编号 */
	private int serverNo;
	/** 服务器名称 */
	private String serverName;
	/** 登陆服端口 */
	private int port;
	/** 登陆服Ip */
	private String ip;
	/** 中心服务器ip */
	private String worldIp;
	/** 中心服务器端口 */
	private int worldPort;
	/** 描述 */
	private String desc;
	/** 状态 (-1: 关闭， 0: 即将开区, 1: 维护，2: 正常, 3: 推荐,  4:火爆) */
	private int status;
	/** 1: 推荐 ， 0: 不推荐 */
	private int recommend;
	/** 开服时间 */
	private Date startTime;
	/** 维护开始时间 */
	private Date maintainStartTime;
	/** 维护结束时间 */
	private Date maintainEndTime;
	/** 维护显示信息 */
	private String maintainMsg;
	/** 连续登陆周期，作为连续登陆活动使用*/
	private int continueLoginCycle;
	
	private String mainDBUrl;
	private String mainDBUsername;
	private String mainDBPassword;
	private String configDBUrl;
	private String configDBUsername;
	private String configDBPassword;
	private String adminUrl;
	private String adminCheck;
	private boolean defaultSelect;
	private int type;//服务器类型(0为测试,1为正式)
	private int merge;
	private int state;   //连接状态
	private int stateTime;   //连接状态更新时间
	private String rechargeUrl = "";
	
	public ConnParam getMainConnParam(){
		ConnParam param = new ConnParam();
		param.setUrl(mainDBUrl);
		param.setUsername(mainDBUsername);
		param.setPassword(mainDBPassword);
		return param;
	}
	
	public ConnParam getConfigConnParam(){
		ConnParam param = new ConnParam();
		param.setUrl(configDBUrl);
		param.setUsername(configDBUsername);
		param.setPassword(configDBPassword);
		return param;
	}
}
