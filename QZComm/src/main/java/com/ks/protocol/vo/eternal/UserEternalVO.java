package com.ks.protocol.vo.eternal;

import java.util.ArrayList;
import java.util.List;

import com.ks.db.cfg.EternalSkill;
import com.ks.db.model.UserEternal;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.MessageFactory;

public class UserEternalVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="用户武魂编号")
	private int userEternalId;
	@FieldDesc(desc="武魂编号")
	private int eternalId;
	@FieldDesc(desc="是否在使用中", rename="isuse")
	private boolean use;
	@FieldDesc(desc="属性效果")
	private List<EaternalSkillVO> propertySkills;
	public List<EaternalSkillVO> getPropertySkills() {
		return propertySkills;
	}

	public void setPropertySkills(List<EaternalSkillVO> propertySkills) {
		this.propertySkills = propertySkills;
	}

	public void init(UserEternal o){
		this.userEternalId = o.getUserEternalId();
		this.eternalId = o.getEternalId();
		this.use = o.isUse();
		if(this.propertySkills==null){
			this.propertySkills=new ArrayList<EaternalSkillVO>();
			if(!o.getPropertySkills().isEmpty()){
				for (EternalSkill es:o.getPropertySkillList()) {
					EaternalSkillVO vo=MessageFactory.getMessage(EaternalSkillVO.class);
					vo.init(es);
					this.propertySkills.add(vo);
				}
			}
		}
	}

	public int getUserEternalId() {
		return userEternalId;
	}
	public void setUserEternalId(int userEternalId) {
		this.userEternalId = userEternalId;
	}
	public int getEternalId() {
		return eternalId;
	}
	public void setEternalId(int eternalId) {
		this.eternalId = eternalId;
	}
	public boolean isUse() {
		return use;
	}
	public void setUse(boolean use) {
		this.use = use;
	}
}
