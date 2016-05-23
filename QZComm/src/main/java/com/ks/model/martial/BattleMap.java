package com.ks.model.martial;

import java.io.Serializable;

public class BattleMap implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String mapId;
	private int[][] hinder;
	
	public BattleMap(String mapId, int[][] hinder) {
		super();
		this.mapId = mapId;
		this.hinder = hinder;
	}
	public String getMapId() {
		return mapId;
	}
	public void setMapId(String mapId) {
		this.mapId = mapId;
	}
	public int[][] getHinder() {
		return hinder;
	}
	public void setHinder(int[][] hinder) {
		this.hinder = hinder;
	}
	
	
}
