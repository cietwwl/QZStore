package com.ks.logic.dao.cfg;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameCfgDAOTemplate;
import com.ks.db.cfg.Achieve;
import com.ks.db.cfg.AchieveAward;
import com.ks.table.AchieveTable;

public class AchieveDAO extends GameCfgDAOTemplate {

	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryAchieves", dbbean=Achieve.class, oderby=AchieveTable.ACHIEVEID + " asc")})
	public List<Achieve> queryAchieves(){
		String sql = DBBeanRowMapperManager.getDynamicSql(Achieve.class, "queryAchieves");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(Achieve.class));
	}
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryAchieveAwards", dbbean=AchieveAward.class)})
	public List<AchieveAward> queryAchieveAwards(){
		String sql = DBBeanRowMapperManager.getDynamicSql(AchieveAward.class, "queryAchieveAwards");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(AchieveAward.class));
		
	}
}
