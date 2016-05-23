package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

import org.codehaus.jackson.type.TypeReference;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.cache.JedisFieldSet;
import com.ks.db.cfg.EternalSkill;
import com.ks.util.JSONUtil;
/**
 * 用户武魂
 * @author ks
 */
@DBBeanSet(tablename_prefix="t_user_eternal_", primaryKey="user_eternal_id")
@Data
public class UserEternal implements Serializable {
	private static final long serialVersionUID = 1L;
	/**用户武魂编号*/
	@DBFieldSet(dbfname="user_eternal_id")
	private int userEternalId;
	/**用户编号*/
	@DBFieldSet(dbfname="user_id")
	private int userId;
	/**武魂编号*/
	@DBFieldSet(dbfname="eternal_id")
	private int eternalId;
	/**是否在使用中*/
	@DBFieldSet(dbfname="use")
	private boolean use;
	/**创建时间*/
	@DBFieldSet(dbfname="create_time")
	private Date createTime = new Date();
	/**修改时间*/
	@DBFieldSet(dbfname="update_time")
	private Date updateTime = new Date();
	/**属性效果*/
	@DBFieldSet(dbfname="property_skill")
	private String propertySkills;
	/**是否更新*/
	@JedisFieldSet()
	private boolean update = false;
	
	private List<EternalSkill> propertySkillList;
	private void initPropertySkillList(){
		propertySkillList = JSONUtil.toObject(propertySkills, new TypeReference<List<EternalSkill>>(){});
	}
	private void initPropertySkills(){
		propertySkills = JSONUtil.toJson(propertySkillList);
	}
	
	public String getPropertySkills() {
		initPropertySkills();
		return propertySkills;
	}
	public void setPropertySkills(String propertySkills) {
		this.propertySkills = propertySkills;
		initPropertySkillList();
	}
	public static final UserEternal  createUserEternal(int userId, int eternalId) {
		UserEternal ue = new UserEternal();
		ue.userId = userId;
		ue.eternalId = eternalId;
		return ue;
	}
	
	
}
