package com.ks.logic.dao.cfg;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameCfgDAOTemplate;
import com.ks.db.cfg.UserRule;
/**
 * 用户规则
 * @author ks
 */
public class UserRuleDAO extends GameCfgDAOTemplate {

	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryUserRule", dbbean=UserRule.class)})
	public List<UserRule> queryUserRule(){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserRule.class, "queryUserRule");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(UserRule.class));
	}
}
