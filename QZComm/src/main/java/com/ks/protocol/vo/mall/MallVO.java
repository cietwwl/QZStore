package com.ks.protocol.vo.mall;

import java.util.ArrayList;
import java.util.List;

import com.ks.db.cfg.Mall;
import com.ks.db.cfg.MallGoods;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.MessageFactory;
/**
 * 商城
 * @author ks
 */
public abstract class MallVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="编号")
	private int id;
	@FieldDesc(desc="类型")
	private int type;
	@FieldDesc(desc="vip")
	private int vip;
	@FieldDesc(desc="状态")
	private int state;
	@FieldDesc(desc="金钱类型")
	private int moneyType;
	@FieldDesc(desc="原价")
	private int originalMoney;
	@FieldDesc(desc="金钱数量")
	private int money;
	@FieldDesc(desc="购买次数")
	private int buyCount;
	@FieldDesc(desc="下架时间")
	private long shelvesTime;
	@FieldDesc(desc="物品")
	private List<MallGoodsVO> goods;
	@FieldDesc(desc="终身限购次数")
	private int toleCount;
	
	public void init(Mall o){
		this.id = o.getId();
		this.type = o.getType();
		this.vip = o.getVip();
		this.state = o.getState();
		this.moneyType = o.getMoneyType();
		this.originalMoney = o.getOriginalMoney();
		this.money = o.getMoney();
		this.buyCount = o.getBuyCount();
		this.shelvesTime = o.getShelvesTime()==null?-1:o.getShelvesTime().getTime();
		this.goods = new ArrayList<MallGoodsVO>();
		this.toleCount = o.getToleCount();
		for(MallGoods g : o.getGoodses()){
			MallGoodsVO vo = MessageFactory.getMessage(MallGoodsVO.class);
			vo.init(g);
			goods.add(vo);
		}
		this.toleCount = o.getToleCount();
	}

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
	public long getShelvesTime() {
		return shelvesTime;
	}
	public void setShelvesTime(long shelvesTime) {
		this.shelvesTime = shelvesTime;
	}

	public List<MallGoodsVO> getGoods() {
		return goods;
	}

	public void setGoods(List<MallGoodsVO> goods) {
		this.goods = goods;
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

	public int getToleCount() {
		return toleCount;
	}

	public void setToleCount(int toleCount) {
		this.toleCount = toleCount;
	}
	
}
