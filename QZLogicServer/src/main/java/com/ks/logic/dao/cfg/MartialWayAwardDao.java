package com.ks.logic.dao.cfg;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameCfgDAOTemplate;
import com.ks.db.cfg.MartialWayAward;
import com.ks.db.cfg.MartialWayAwardExp;
/**
 * 武道大会奖励dao
 * @author hanjie.l
 *
 */
public class MartialWayAwardDao extends GameCfgDAOTemplate{

	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryMartialWayAwardExp", dbbean=MartialWayAwardExp.class)})
	public List<MartialWayAwardExp> queryMartialWayAwardExp(){
		String sql = DBBeanRowMapperManager.getDynamicSql(MartialWayAwardExp.class, "queryMartialWayAwardExp");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(MartialWayAwardExp.class));
	}

	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryMartialWayAwards", dbbean=MartialWayAward.class)})
	public List<MartialWayAward> queryMartialWayAwards(){
		String sql = DBBeanRowMapperManager.getDynamicSql(MartialWayAward.class, "queryMartialWayAwards");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(MartialWayAward.class));
}

}
