package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.object.ConditionParams;

@DBBeanSet(tablename="t_common_reward", createDeleteSql=false, createSelectSql=false, createInsertSql=false, createUpdateSql=false)
public class CommonRewardConfig implements Serializable{
	private static final long serialVersionUID = 1L;
	/**自增长id*/
	@DBFieldSet(dbfname="n_id")
	private int id;
	/**说明*/
	@DBFieldSet(dbfname="n_tips")
	private String tips;
	/**获得方式*/
	@DBFieldSet(dbfname="n_gain")
	private int gain;
	/**是否重置*/
	@DBFieldSet(dbfname="n_reset")
	private int reset;
	/**类型*/
	@DBFieldSet(dbfname="n_type")
	private int type;
	/**分组*/
	@DBFieldSet(dbfname="n_group")
	private int group;
	/**条件*/
	@DBFieldSet(dbfname="n_conditions")
	private String conditions;
	/**道具*/
	@DBFieldSet(dbfname="n_items")
	private String items;
	private ConditionParams conditionParams;
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getTips(){
		return tips;
	}
	public void setTips(String tips){
		this.tips = tips;
	}
	public int getGain(){
		return gain;
	}
	public void setGain(int gain){
		this.gain = gain;
	}
	public int getReset(){
		return reset;
	}
	public void setReset(int reset){
		this.reset = reset;
	}
	public int getType(){
		return type;
	}
	public void setType(int type){
		this.type = type;
	}
	public int getGroup(){
		return group;
	}
	public void setGroup(int group){
		this.group = group;
	}
	public String getConditions(){
		return conditions;
	}
	public void setConditions(String conditions){
		this.conditions = conditions;
		initConditionParams();
	}
	public String getItems(){
		return items;
	}
	public void setItems(String items){
		this.items = items;
	}
	public void initConditionParams(){
		conditionParams = new ConditionParams(conditions);
	}
	public ConditionParams getConditionParams(){
		return conditionParams;
	}
}
