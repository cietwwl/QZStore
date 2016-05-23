package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
/**
 * 探索奖励
 * @author ks
 */
@DBBeanSet(tablename="t_explore_award", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class ExploreAward implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@DBFieldSet(dbfname="array_id")
	private int arrayId;
	/**物品编号*/
	@DBFieldSet(dbfname="goods_id")
	private int goodsId;
	/**类型*/
	@DBFieldSet(dbfname="type")
	private int type;
	/**数量*/
	@DBFieldSet(dbfname="num")
	private int num;
	/**等级*/
	@DBFieldSet(dbfname="level")
	private int level;
	/**概率*/
	@DBFieldSet(dbfname="rate")
	private int rate;
	public int getArrayId() {
		return arrayId;
	}
	public void setArrayId(int arrayId) {
		this.arrayId = arrayId;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	
}
