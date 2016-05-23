package com.ks.protocol.vo.zone;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;

/**
 * 试炼副本vo
 *
 */
@EqualsAndHashCode(callSuper=true)
@Data
public class TrialsZoneVO extends Message{
	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="副本编号")
	private int zoneId;
	@FieldDesc(desc="副本战斗编号")
	private List<Integer> zoneBattleIds;
	@FieldDesc(desc="剩余挑战次数")
	private int number;
	@FieldDesc(desc="剩余免费刷新次数")
	private int freeRefreshNum;
	@FieldDesc(desc="剩余钻石刷新次数")
	private int diamondRefreshNum;
	@FieldDesc(desc="已挑战过的副本")
	private List<Integer> challengeIds;
	
	public void init(int zoneId, List<Integer> ids, int number, int freeRefreshNum, int diamondRefreshNum, List<Integer> challengeIds){
		this.zoneId = zoneId;
		this.zoneBattleIds = ids;
		this.number = number;
		this.freeRefreshNum = freeRefreshNum;
		this.diamondRefreshNum = diamondRefreshNum;
		this.challengeIds = challengeIds;
	}
}
