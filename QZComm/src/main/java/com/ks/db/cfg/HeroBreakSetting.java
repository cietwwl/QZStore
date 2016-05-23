package com.ks.db.cfg;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.db.model.Goods;

/**
 * 英雄突破消耗基础表
 * @author hanjie.l
 *
 */
@DBBeanSet(tablename="t_hero_break_setting", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class HeroBreakSetting {
	/**组id*/
	@DBFieldSet(dbfname="groupId")
	private int groupId;
	/**突破等级*/
	@DBFieldSet(dbfname="breakLevel")
	private int breakLevel;
	/**灵元槽位*/
	@DBFieldSet(dbfname="slot")
	private int slot;
	/**激活需要英雄等级*/
	@DBFieldSet(dbfname="needLevel")
	private int needLevel;
	/**消耗物品类型*/
	@DBFieldSet(dbfname="type")
	private int type;
	/**消耗物品id*/
	@DBFieldSet(dbfname="goods_id")
	private int goods_id;
	/**消耗物品数量*/
	@DBFieldSet(dbfname="num")
	private int num;
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getBreakLevel() {
		return breakLevel;
	}
	public void setBreakLevel(int breakLevel) {
		this.breakLevel = breakLevel;
	}
	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}
	public int getNeedLevel() {
		return needLevel;
	}
	public void setNeedLevel(int needLevel) {
		this.needLevel = needLevel;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
//	/**
//	 * 获取消耗物品
//	 * @return
//	 */
//	public Goods getCostGoods(){
//		return Goods.createGoods(goods_id, type, num, 0);
//	}
}
