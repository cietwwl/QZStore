package com.ks.protocol.vo.fight;

import java.util.ArrayList;
import java.util.List;

import com.ks.model.fight.FightModel;
import com.ks.model.fight.Point;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.MessageFactory;
/**
 * 替补上阵
 * @author ks
 */
public class SubFightBattleVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="战斗编号")
	private int fightId;
	@FieldDesc(desc="坐标")
	private List<PointVO> points;
	
	public void init(FightModel fm){
		this.fightId = fm.getFightId();
		points = new ArrayList<PointVO>();
		for(Point p : fm.getGridCoors()){
			PointVO vo = MessageFactory.getMessage(PointVO.class);
			vo.init(p);
			points.add(vo);
		}
	}
	
	public int getFightId() {
		return fightId;
	}
	public void setFightId(int fightId) {
		this.fightId = fightId;
	}
	public List<PointVO> getPoints() {
		return points;
	}
	public void setPoints(List<PointVO> points) {
		this.points = points;
	}
	
	
}
