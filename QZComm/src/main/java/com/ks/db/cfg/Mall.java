package com.ks.db.cfg;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
/**
 * 商城
 * @author ks
 */
@DBBeanSet(tablename="t_mall", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class Mall implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**编号*/
	@DBFieldSet(dbfname="id")
	private int id;
	/**类型*/
	@DBFieldSet(dbfname="type")
	private int type;
	/**vip*/
	@DBFieldSet(dbfname="vip")
	private int vip;
	/**状态*/
	@DBFieldSet(dbfname="state")
	private int state;
	/**金钱类型*/
	@DBFieldSet(dbfname="money_type")
	private int moneyType;
	/**原价*/
	@DBFieldSet(dbfname="original_money")
	private int originalMoney;
	/**金钱数量*/
	@DBFieldSet(dbfname="money")
	private int money;
	/**购买次数*/
	@DBFieldSet(dbfname="buy_count")
	private int buyCount;
	/**池子编号*/
	@DBFieldSet(dbfname="pool_id")
	private int poolId;
	/**上架时间*/
	@DBFieldSet(dbfname="putaway_time")
	private Date putawayTime;
	/**下架时间*/
	@DBFieldSet(dbfname="shelves_time")
	private Date shelvesTime;
	/**商城物品*/
	private List<MallGoods> goodses;
	/**终身限购次数*/
	@DBFieldSet(dbfname="tole_count")
	private int toleCount;
	/**出现概率*/
	@DBFieldSet(dbfname="rate")
	private int rate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getMoneyType() {
		return moneyType;
	}
	public void setMoneyType(int moneyType) {
		this.moneyType = moneyType;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}
	public Date getShelvesTime() {
		return shelvesTime;
	}
	public void setShelvesTime(Date shelvesTime) {
		this.shelvesTime = shelvesTime;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getVip() {
		return vip;
	}
	public void setVip(int vip) {
		this.vip = vip;
	}
	public int getOriginalMoney() {
		return originalMoney;
	}
	public void setOriginalMoney(int originalMoney) {
		this.originalMoney = originalMoney;
	}
	public Date getPutawayTime() {
		return putawayTime;
	}
	public void setPutawayTime(Date putawayTime) {
		this.putawayTime = putawayTime;
	}
	public List<MallGoods> getGoodses() {
		return goodses;
	}
	public void setGoodses(List<MallGoods> goodses) {
		this.goodses = goodses;
	}
	public int getPoolId() {
		return poolId;
	}
	public void setPoolId(int poolId) {
		this.poolId = poolId;
	}
	public int getToleCount() {
		return toleCount;
	}
	public void setToleCount(int toleCount) {
		this.toleCount = toleCount;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	
}
