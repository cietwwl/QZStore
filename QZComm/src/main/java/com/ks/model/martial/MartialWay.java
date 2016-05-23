package com.ks.model.martial;

import java.io.Serializable;
import java.util.Date;

import com.ks.cache.JedisFieldSet;

/**
 * 武道会
 *
 */
public class MartialWay implements Serializable {
	private static final long serialVersionUID = 1L;
	/**用户编号*/
	@JedisFieldSet()
	private int userId;
	/**积分*/
	@JedisFieldSet()
	private short score;
	/**胜场*/
	@JedisFieldSet()
	private short winCount;
	/**连胜*/
	@JedisFieldSet()
	private short winStreak;
	/**最后胜利时间*/
	@JedisFieldSet()
	private Date lastWinTime;

	private static final BattleMap[] maps;
	
	private static int[][] getHinder(String hinder) {
		if(hinder==null||"".equals(hinder)){
			return new int[][]{};
		}
		String[] hin = hinder.split("_");
		int[][] is = new int[hin.length][3];
		int i=0;
		for(String str : hin){
			String[] ss = str.split(",");
			is[i][0]=Integer.parseInt(ss[0]);
			is[i][1]=Integer.parseInt(ss[1]);
			is[i][2]=Integer.parseInt(ss[2]);
			i++;
		}
		return is;
	}
	
	static{
		maps = new BattleMap[]{
				new BattleMap("mu", getHinder("")),
				new BattleMap("huo", getHinder("")),
				new BattleMap("zhan", getHinder("")),
				new BattleMap("an", getHinder("")),
		};
	}
	
	public static BattleMap randomBattleMap(){
		return maps[(int) (Math.random()*maps.length)];
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public short getScore() {
		return score;
	}
	public void setScore(short score) {
		this.score = score;
	}
	public short getWinCount() {
		return winCount;
	}
	public void setWinCount(short winCount) {
		this.winCount = winCount;
	}
	public short getWinStreak() {
		return winStreak;
	}
	public void setWinStreak(short winStreak) {
		this.winStreak = winStreak;
	}
	public Date getLastWinTime() {
		return lastWinTime;
	}
	public void setLastWinTime(Date lastWinTime) {
		this.lastWinTime = lastWinTime;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MartialWay other = (MartialWay) obj;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	
}
