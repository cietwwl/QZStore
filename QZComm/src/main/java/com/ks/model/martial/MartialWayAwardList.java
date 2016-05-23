package com.ks.model.martial;

import java.io.Serializable;
import java.util.List;

import com.ks.db.model.Goods;

public class MartialWayAwardList implements Serializable {
	private static final long serialVersionUID = 1L;
	private int minRank;
	private int maxRank;
	private List<Goods> goodses;
	public int getMinRank() {
		return minRank;
	}
	public void setMinRank(int minRank) {
		this.minRank = minRank;
	}
	public int getMaxRank() {
		return maxRank;
	}
	public void setMaxRank(int maxRank) {
		this.maxRank = maxRank;
	}
	public List<Goods> getGoodses() {
		return goodses;
	}
	public void setGoodses(List<Goods> goodses) {
		this.goodses = goodses;
	}
	
	
}
