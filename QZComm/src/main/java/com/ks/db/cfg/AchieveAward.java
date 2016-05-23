package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
/**
 * 成就奖励
 * @author ks
 */
@DBBeanSet(tablename="t_achieve_award", createDeleteSql=false, createSelectSql=false, createInsertSql=false, createUpdateSql=false)
public class AchieveAward implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**成就编号*/
	@DBFieldSet(dbfname="achieve_id")
	private int achieveId;
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
	public int getAchieveId() {
		return achieveId;
	}
	public void setAchieveId(int achieveId) {
		this.achieveId = achieveId;
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
