package com.ks.logic.dao.cfg;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameCfgDAOTemplate;
import com.ks.db.cfg.Fame;
import com.ks.db.cfg.FameAward;
import com.ks.db.cfg.FameBuff;

public class FameDAO extends GameCfgDAOTemplate {

	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryFame", dbbean=Fame.class)})
	public List<Fame> queryFame(){
		String sql = DBBeanRowMapperManager.getDynamicSql(Fame.class, "queryFame");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(Fame.class));
	}
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryFameBuff", dbbean=FameBuff.class)})
	public List<FameBuff> queryFameBuff(){
		String sql = DBBeanRowMapperManager.getDynamicSql(FameBuff.class, "queryFameBuff");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(FameBuff.class));
	}
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryFameAward", dbbean=FameAward.class)})
	public List<FameAward> queryFameAward(){
		String sql = DBBeanRowMapperManager.getDynamicSql(FameAward.class, "queryFameAward");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(FameAward.class));
	}
}
