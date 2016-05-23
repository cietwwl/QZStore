package com.ks.protocol.vo.mall;

import com.ks.db.cfg.MallGoods;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;

public class MallGoodsVO extends Message {
	
	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="商城编号")
	private int mallId;
	@FieldDesc(desc="物品编号")
	private int goodsId;
	@FieldDesc(desc="类型")
	private int type;
	@FieldDesc(desc="数量")
	private int num;
	@FieldDesc(desc="等级")
	private int level;
	
	public void init(MallGoods o){
		this.mallId = o.getMallId();
		this.goodsId = o.getGoodsId();
		this.type = o.getType();
		this.num = o.getNum();
		this.level = o.getLevel();
	}

	public int getMallId() {
		return mallId;
	}
	public void setMallId(int mallId) {
		this.mallId = mallId;
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
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	
}
