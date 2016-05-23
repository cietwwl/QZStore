package com.ks.model.user;

import java.io.Serializable;
/**
 * 商城购买
 * @author ks
 */
public class AssStat implements Serializable {
	private static final long serialVersionUID = 1L;
	/**编号*/
	private int assId;
	/**数量*/
	private int num;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getAssId() {
		return assId;
	}
	public void setAssId(int assId) {
		this.assId = assId;
	}
	
}
