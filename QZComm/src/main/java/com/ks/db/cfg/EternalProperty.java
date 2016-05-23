package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

/**
 * @author fengpeng E-mail:fengpeng_15@163.com
 * @version 创建时间：2015年4月8日 下午4:43:46
 * 类说明
 */
@DBBeanSet(tablename="t_eternal_property", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class EternalProperty implements Serializable {
	private static final long serialVersionUID = 1L;
	/**品质*/
	@DBFieldSet(dbfname="quality")
	private int quality;
	/**技能类型*/
	@DBFieldSet(dbfname="skill_type")
	private int skillType;
	/**出现该技能的概率*/
	@DBFieldSet(dbfname="skill_rate")
	private double skillRate;
	/**随机数的起始数*/
	@DBFieldSet(dbfname="start_num")
	private double startNum;
	/**随机数的结尾数*/
	@DBFieldSet(dbfname="end_num")
	private double endNum;
	/**攻击方向*/
	@DBFieldSet(dbfname="atk_mode")
	private String atkMode;
	/**类型*/
	@DBFieldSet(dbfname="type")
	private int type;
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public int getSkillType() {
		return skillType;
	}
	public void setSkillType(int skillType) {
		this.skillType = skillType;
	}
	public double getSkillRate() {
		return skillRate;
	}
	public void setSkillRate(double skillRate) {
		this.skillRate = skillRate;
	}
	public double getStartNum() {
		return startNum;
	}
	public void setStartNum(double startNum) {
		this.startNum = startNum;
	}
	public double getEndNum() {
		return endNum;
	}
	public void setEndNum(double endNum) {
		this.endNum = endNum;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getAtkMode() {
		return atkMode;
	}
	public void setAtkMode(String atkMode) {
		this.atkMode = atkMode;
	}
	

}
