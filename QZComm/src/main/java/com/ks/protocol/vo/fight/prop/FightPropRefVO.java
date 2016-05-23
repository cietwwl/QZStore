package com.ks.protocol.vo.fight.prop;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.vo.fight.PointVO;
/**
 * 战斗道具刷新
 * @author ks
 */
public class FightPropRefVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="道具编号")
	private int propId;
	@FieldDesc(desc="格子坐标")
	private PointVO coor;
	public int getPropId() {
		return propId;
	}
	public void setPropId(int propId) {
		this.propId = propId;
	}
	public PointVO getCoor() {
		return coor;
	}
	public void setCoor(PointVO coor) {
		this.coor = coor;
	}
	
}
