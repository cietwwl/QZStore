package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.object.Privileges;

@DBBeanSet(tablename="t_vip_config", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class VipConfig implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**vip等级*/
	@DBFieldSet(dbfname="n_vipLevel")
	private int vipLevel;
	/**充值钻石数量*/
	@DBFieldSet(dbfname="n_money")
	private int money;
	/**特权*/
	@DBFieldSet(dbfname="n_privileges")
	private String privileges;
	
	private Privileges vipPrivileges;
	
	public int getVipLevel(){
		return vipLevel;
	}
	public void setVipLevel(int viplevel){
		this.vipLevel = viplevel;
	}
	public String getPrivileges(){
		return privileges;
	}
	public void setPrivileges(String privileges){
		this.privileges = privileges;
	}
	public int getMoney(){
		return money;
	}
	public void setMoney(int money){
		this.money = money;
	}
	public Privileges getVipPrivilege(){
		if(vipPrivileges != null){
			return vipPrivileges.copy();
		}
		return new Privileges();
	}
	public void setVipPrivileges(Privileges privileges){
		this.vipPrivileges = privileges;
	}

}
