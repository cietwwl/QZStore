package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
/**
 * 公会排名奖励
 * @author ks
 */
@DBBeanSet(tablename="t_guild_rank_award", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class GuildRankAward implements Serializable{
	private static final long serialVersionUID = 1L;
	/**排名*/
	@DBFieldSet(dbfname="rank")
	private int rank;
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
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
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
	
}
