package com.ks.protocol.vo.fight;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 移动VO
 * @author ks
 */
public class MoveVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="战斗编号")
	private int fightId;
	@FieldDesc(desc="点")
	private PointVO point;
	public int getFightId() {
		return fightId;
	}
	public void setFightId(int fightId) {
		this.fightId = fightId;
	}
	public PointVO getPoint() {
		return point;
	}
	public void setPoint(PointVO point) {
		this.point = point;
	}
}