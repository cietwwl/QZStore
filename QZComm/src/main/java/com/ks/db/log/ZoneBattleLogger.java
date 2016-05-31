package com.ks.db.log;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.util.XyTimeUtil;

import lombok.Data;

@Data
@DBBeanSet(tablename="t_zone_battle_logger", primaryKey={"id"})
public class ZoneBattleLogger implements Serializable{
	private static final long serialVersionUID = 1L;
	@DBFieldSet(dbfname="id")
	private int id;
	@DBFieldSet(dbfname="zoneId") 
	private int zoneId;  //章节id
	@DBFieldSet(dbfname="zoneBattleId")
	private int zoneBattleId;  //副本id
	@DBFieldSet(dbfname="userId")
	private int userId;  //玩家id
	@DBFieldSet(dbfname="firstState")
	private int firstState;  //第一个战斗状态（0初始，1通关，2失败）
	@DBFieldSet(dbfname="state") 
	private int state;   //当前挑战状态(0初始，1战斗中，2失败，3通关)
	@DBFieldSet(dbfname="battleNum")
	private int battleNum;  //通关次数
	@DBFieldSet(dbfname="createTime")
	private int createTime;  //创建时间
	@DBFieldSet(dbfname="updateTime")
	private int updateTime;  //更新时间
	
	public ZoneBattleLogger(){}
	
	public ZoneBattleLogger(int userId, int zoneId, int zoneBattleId){
		this.userId = userId;
		this.zoneId = zoneId;
		this.zoneBattleId = zoneBattleId;
		this.createTime = XyTimeUtil.getNowSecond();
	}

}
