package com.ks.protocol.vo.fight;

import com.ks.model.fight.Point;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 点
 * @author ks
 */
public class PointVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="x")
	private int x;
	@FieldDesc(desc="y")
	private int y;
	public void init(Point o){
		this.x = o.getX();
		this.y = o.getY();
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}
