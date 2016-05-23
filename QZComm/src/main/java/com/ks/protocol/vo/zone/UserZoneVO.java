package com.ks.protocol.vo.zone;

import java.util.List;

import com.ks.db.model.UserZone;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 用户副本
 * @author ks
 */
public class UserZoneVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="战场编号")
	private int zoneId;
	@FieldDesc(desc="是否通过")
	private int currBattle;
	@FieldDesc(desc="获得奖励的星数")
	private List<Integer> gainAwardStar;
	
	public void init(UserZone o){
		this.zoneId = o.getZoneId();
		this.currBattle = o.getCurrBattle();
		this.gainAwardStar = o.getGainAwardStarList();
	}
	public int getZoneId() {
		return zoneId;
	}
	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}
	public int getCurrBattle() {
		return currBattle;
	}
	public void setCurrBattle(int currBattle) {
		this.currBattle = currBattle;
	}
	public List<Integer> getGainAwardStar() {
		return gainAwardStar;
	}
	public void setGainAwardStar(List<Integer> gainAwardStar) {
		this.gainAwardStar = gainAwardStar;
	}
	
}
