package com.ks.db.cfg;

import java.io.Serializable;
import java.util.List;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
/**
 * 英雄关联
 * @author ks
 */
@DBBeanSet(tablename="t_hero_relation", imports={"com.ks.util.StringUtil"}, createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class HeroRelation implements Serializable {
	private static final long serialVersionUID = 1L;
	/**关联英雄*/
	@DBFieldSet(dbfname="ass_hero", parseJavaField="StringUtil.stringToList(rs.getString(\"ass_hero\"))")
	private List<Integer> assHero;
	/**技能编号*/
	@DBFieldSet(dbfname="skill_id")
	private int skillId;
	public List<Integer> getAssHero() {
		return assHero;
	}
	public void setAssHero(List<Integer> assHero) {
		this.assHero = assHero;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
}
