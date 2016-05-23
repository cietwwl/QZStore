package com.ks.db.cfg;

import java.io.Serializable;
import java.util.List;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
/**
 * 英雄进化
 * @author ks
 */
@DBBeanSet(tablename="t_hero_evo", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class HeroEvo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**进化编号*/
	@DBFieldSet(dbfname="evo_id")
	private int evoId;
	/**要进化的英雄编号*/
	@DBFieldSet(dbfname="hero_id")
	private int heroId;
	/**进化后的英雄编号*/
	@DBFieldSet(dbfname="evo_hero_id")
	private int evoHeroId;
	/**合成材料*/
	private List<HeroEvoMaterial> materials;
	public int getEvoId() {
		return evoId;
	}
	public void setEvoId(int evoId) {
		this.evoId = evoId;
	}
	public int getHeroId() {
		return heroId;
	}
	public void setHeroId(int heroId) {
		this.heroId = heroId;
	}
	public int getEvoHeroId() {
		return evoHeroId;
	}
	public void setEvoHeroId(int evoHeroId) {
		this.evoHeroId = evoHeroId;
	}
	public List<HeroEvoMaterial> getMaterials() {
		return materials;
	}
	public void setMaterials(List<HeroEvoMaterial> materials) {
		this.materials = materials;
	}
	
}
