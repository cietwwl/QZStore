package com.ks.protocol.vo.fight;

import java.util.List;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 弹射
 * @author ks
 */
public class CatapultVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="弹射的人")
	private int fightId;
	@FieldDesc(desc="当前所在点")
	private PointVO currPoint;
	@FieldDesc(desc="受伤的对象")
	private List<CatapultHurtVO> hurts;
	public int getFightId() {
		return fightId;
	}
	public void setFightId(int fightId) {
		this.fightId = fightId;
	}
	public PointVO getCurrPoint() {
		return currPoint;
	}
	public void setCurrPoint(PointVO currPoint) {
		this.currPoint = currPoint;
	}
	public List<CatapultHurtVO> getHurts() {
		return hurts;
	}
	public void setHurts(List<CatapultHurtVO> hurts) {
		this.hurts = hurts;
	}
	
}
