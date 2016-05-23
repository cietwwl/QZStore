package com.ks.db.cfg;

import java.io.Serializable;

import lombok.Data;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

@Data
@DBBeanSet(tablename="t_pay_goods", createDeleteSql=false, createSelectSql=false, createInsertSql=false, createUpdateSql=false)
public class PayGoods implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**商品id*/
	@DBFieldSet(dbfname="id")
	private int id;
	/**商品价格*/
	@DBFieldSet(dbfname="money")
	private int money;
	/**商品类型(1钻石，2周期卡)*/
	@DBFieldSet(dbfname="type")
	private int type;
	/**商品名称*/
	@DBFieldSet(dbfname="name")
	private String name;
	/**商品图片*/
	@DBFieldSet(dbfname="icon")
	private String icon;
	/**任务图标*/
	@DBFieldSet(dbfname="taskIcon")
	private String taskIcon;
	/**获得物品*/
	@DBFieldSet(dbfname="items")
	private String items;
	/**首次额外获得*/
	@DBFieldSet(dbfname="firstItems")
	private String firstItems;
	/**额外获得*/
	@DBFieldSet(dbfname="extraItems")
	private String extraItems;
	/**返还天数*/
	@DBFieldSet(dbfname="gainDay")
	private int gainDay;
	/**购买CD*/
	@DBFieldSet(dbfname="buyCD")
	private int buyCD;
	
}
