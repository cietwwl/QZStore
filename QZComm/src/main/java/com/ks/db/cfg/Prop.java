package com.ks.db.cfg;

import java.io.Serializable;
import java.util.List;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

/**
 * 道具
 * 
 * @author ks
 */
@DBBeanSet(tablename="t_prop", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class Prop implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 道具编号 */
	@DBFieldSet(dbfname="prop_id")
	private int propId;
	/** 道具名称 */
	@DBFieldSet(dbfname="name")
	private String name;
	/** 类型 */
	@DBFieldSet(dbfname="type")
	private int type;
	/** 是否可使用 */
	@DBFieldSet(dbfname="use")
	private boolean use;
	/** 可否出售 */
	@DBFieldSet(dbfname="sell")
	private boolean sell;
	/** 出售价格 */
	@DBFieldSet(dbfname="sell_price")
	private int sellPrice;
	/**消耗道具*/
	@DBFieldSet(dbfname="expendItems")
	private String expendItems;
	/**获得道具（个数#道具组）*/
	@DBFieldSet(dbfname="gainItems")
	private String gainItems;
	/** 道具效果 */
	private List<PropEffect> effects;

	public int getPropId() {
		return propId;
	}

	public void setPropId(int propId) {
		this.propId = propId;
	}

	public boolean isUse() {
		return use;
	}

	public void setUse(boolean use) {
		this.use = use;
	}

	public List<PropEffect> getEffects() {
		return effects;
	}

	public void setEffects(List<PropEffect> effects) {
		this.effects = effects;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean isSell() {
		return sell;
	}

	public void setSell(boolean sell) {
		this.sell = sell;
	}

	public int getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}
	public String getExpendItems(){
		return expendItems;
	}
	public void setExpendItems(String expendItems){
		this.expendItems = expendItems;
	}
	public String getGainItems(){
		return gainItems;
	}
	public void setGainItems(String gainItems){
		this.gainItems = gainItems;
	}

}
