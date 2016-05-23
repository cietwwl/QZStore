package com.ks.protocol.vo.fight;

import com.ks.model.fight.Grid;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.MessageFactory;

public class GridVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="格子坐标")
	private PointVO coor;
	@FieldDesc(desc="格子物品")
	private int gridItem;
	@FieldDesc(desc="在上面的战魂")
	private int fightId;
	
	public void init(Grid o){
		this.coor = MessageFactory.getMessage(PointVO.class);
		coor.init(o.getCoor());
		this.gridItem = o.getGridItem();
		this.fightId = o.getFightId();
	}
	
	public PointVO getCoor() {
		return coor;
	}
	public void setCoor(PointVO coor) {
		this.coor = coor;
	}
	public int getGridItem() {
		return gridItem;
	}
	public void setGridItem(int gridItem) {
		this.gridItem = gridItem;
	}
	public int getFightId() {
		return fightId;
	}
	public void setFightId(int fightId) {
		this.fightId = fightId;
	}
	
}
