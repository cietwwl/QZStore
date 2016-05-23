package com.ks.protocol.vo.guild;

import com.ks.db.model.GuildSkill;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 公会技能
 * @author ks
 */
public abstract class GuildSkillVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="技能编号")
	private int skillId;
	@FieldDesc(desc="gp点")
	private int gp;
	public void init(GuildSkill o){
		this.skillId = o.getSkillId();
		this.gp = o.getGp();
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public int getGp() {
		return gp;
	}
	public void setGp(int gp) {
		this.gp = gp;
	}
	
}
