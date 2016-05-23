package com.ks.db.cfg;

import java.io.Serializable;
import java.util.List;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.model.skill.AbstractSkill;
/**
 * 被动技能
 * @author ks
 */
@DBBeanSet(tablename="t_passive_skill", imports={"com.ks.util.StringUtil"}, createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class PassiveSkill extends AbstractSkill implements Serializable {
	private static final long serialVersionUID = 1L;
	/**被动技能*/
	@DBFieldSet(dbfname="passive_skill_id")
	private int passiveSkillId;
	/**名称*/
	@DBFieldSet(dbfname="name")
	private String name;
	/**cd*/
	@DBFieldSet(dbfname="cd")
	private int cd;
	/**激活条件*/
	@DBFieldSet(dbfname="activation")
	private int activation;
	/**生效条件*/
	@DBFieldSet(dbfname="take_effect", parseJavaField="StringUtil.stringToList1(rs.getString(\"take_effect\"))")
	private List<Integer> takeEffect;
	/**参数0*/
	@DBFieldSet(dbfname="arg0", parseJavaField="StringUtil.stringToList1(rs.getString(\"arg0\"))")
	private List<Integer> arg0;
	/**参数1*/
	@DBFieldSet(dbfname="arg1", parseJavaField="StringUtil.stringToList1(rs.getString(\"arg1\"))")
	private List<Integer> arg1;
	/**技能效果*/
	private List<SkillEffect> effects;
	/**释放状态*/
	@DBFieldSet(dbfname="res_state")
	private int resState;
	
	public int getPassiveSkillId() {
		return passiveSkillId;
	}
	public void setPassiveSkillId(int passiveSkillId) {
		this.passiveSkillId = passiveSkillId;
		this.setSkillId(passiveSkillId);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCd() {
		return cd;
	}
	public void setCd(int cd) {
		this.cd = cd;
	}
	public int getActivation() {
		return activation;
	}
	public void setActivation(int activation) {
		this.activation = activation;
	}
	public List<SkillEffect> getEffects() {
		return effects;
	}
	public void setEffects(List<SkillEffect> effects) {
		this.effects = effects;
	}
	public List<Integer> getTakeEffect() {
		return takeEffect;
	}
	public void setTakeEffect(List<Integer> takeEffect) {
		this.takeEffect = takeEffect;
	}
	public List<Integer> getArg0() {
		return arg0;
	}
	public void setArg0(List<Integer> arg0) {
		this.arg0 = arg0;
	}
	public List<Integer> getArg1() {
		return arg1;
	}
	public void setArg1(List<Integer> arg1) {
		this.arg1 = arg1;
	}
	public int getResState() {
		return resState;
	}
	public void setResState(int resState) {
		this.resState = resState;
	}
	
}
