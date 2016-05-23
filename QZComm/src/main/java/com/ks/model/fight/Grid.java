package com.ks.model.fight;

import java.io.Serializable;

import com.ks.constant.SystemConstant;
/**
 * 格子
 * @author ks
 */
public class Grid implements Serializable {
	private static final long serialVersionUID = 1L;
	/**格子坐标*/
	private Point coor;
	/**格子物品*/
	private int gridItem;
	/**在上面的战魂*/
	private int fightId;
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
	public Point getCoor() {
		return coor;
	}
	public void setCoor(Point coor) {
		this.coor = coor;
	}

	/**
	 * 随机道具
	 * @return 随机的道具
	 */
	public static final int randomItem(){
		return SystemConstant.FIGHT_GRID_ITEMS[(int) (Math.random() * SystemConstant.FIGHT_GRID_ITEMS.length)];
	}
	/**
	 * 是否为道具
	 * @param itemId
	 * @return
	 */
	public static final boolean isItem(int itemId){
		for(int item : SystemConstant.FIGHT_GRID_ITEMS){
			if(item == itemId){
				return true;
			}
		}
		return false;
	}
	
	
}
