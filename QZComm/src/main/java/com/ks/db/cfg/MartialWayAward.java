package com.ks.db.cfg;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.db.model.Goods;
/**
 * 武道大会奖励
 * @author ks
 */
@DBBeanSet(tablename="t_martial_way_award", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class MartialWayAward extends Goods {
	private static final long serialVersionUID = 1L;
	
	@DBFieldSet(dbfname="min_rank")
	private int minRank;
	@DBFieldSet(dbfname="max_rank")
	private int maxRank;
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
//	public int getGoodsId() {
//		return goodsId;
//	}
//	public void setGoodsId(int goodsId) {
//		this.goodsId = goodsId;
//	}
//	public int getType() {
//		return type;
//	}
//	public void setType(int type) {
//		this.type = type;
//	}
//	public int getNum() {
//		return num;
//	}
//	public void setNum(int num) {
//		this.num = num;
//	}
//	public int getLevel() {
//		return level;
//	}
//	public void setLevel(int level) {
//		this.level = level;
//	}
	
	
}
