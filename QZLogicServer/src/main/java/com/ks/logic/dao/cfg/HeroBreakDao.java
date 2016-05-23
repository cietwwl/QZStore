package com.ks.logic.dao.cfg;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameCfgDAOTemplate;
import com.ks.db.cfg.HeroBreakAttrSetting;
import com.ks.db.cfg.HeroBreakSetting;
/**
 * 英雄突破dao
 * @author hanjie.l
 *
 */
public class HeroBreakDao extends GameCfgDAOTemplate{
	
	public static final String HEROBREAK_FIELDS = " groupId, breakLevel, slot, needLevel, type, goods_id, num ";

	public static final String HEROBREAK_ATTR_FIELDS = " groupId, breakLevel, slot, hp, atk ";
	
	/**
	 * 查询所有突破消耗数据
	 * @return
	 */
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryHeroBreakSettings", dbbean=HeroBreakSetting.class)})
	public List<HeroBreakSetting> queryHeroBreakSettings(){
		String sql = DBBeanRowMapperManager.getDynamicSql(HeroBreakSetting.class, "queryHeroBreakSettings");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(HeroBreakSetting.class));
	}
	
	/**
	 * 查询所有突破属性增加数据
	 * @return
	 */
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryHeroBreakAttrSettings", dbbean=HeroBreakAttrSetting.class)})
	public List<HeroBreakAttrSetting> queryHeroBreakAttrSettings(){
		String sql = DBBeanRowMapperManager.getDynamicSql(HeroBreakAttrSetting.class, "queryHeroBreakAttrSettings");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(HeroBreakAttrSetting.class));
	}
	
	
}
