package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

/**
 * @author fengpeng E-mail:fengpeng_15@163.com
 * @version 创建时间：2015年4月8日 上午11:37:49
 * 类说明
 */
@DBBeanSet(tablename="t_equipment_up_rate", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class EquipmentUpRate implements Serializable {
	private static final long serialVersionUID = 1L;
	/**等级*/
	@DBFieldSet(dbfname="level")
	private int level;
	/**成功概率*/
	@DBFieldSet(dbfname="success_rate")
	private double successRate;
	/**大成功概率*/
	@DBFieldSet(dbfname="max_success_rate")
	private double maxSuccessRate;
	/**超成功概率*/
	@DBFieldSet(dbfname="super_success_rate")
	private double superSuccessRate;
	/**失败概率*/
	@DBFieldSet(dbfname="lose_rate")
	private double loseRate;
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public double getSuccessRate() {
		return successRate;
	}
	public void setSuccessRate(double successRate) {
		this.successRate = successRate;
	}
	public double getMaxSuccessRate() {
		return maxSuccessRate;
	}
	public void setMaxSuccessRate(double maxSuccessRate) {
		this.maxSuccessRate = maxSuccessRate;
	}
	public double getSuperSuccessRate() {
		return superSuccessRate;
	}
	public void setSuperSuccessRate(double superSuccessRate) {
		this.superSuccessRate = superSuccessRate;
	}
	public double getLoseRate() {
		return loseRate;
	}
	public void setLoseRate(double loseRate) {
		this.loseRate = loseRate;
	}
	

}
