package com.ks.logic.dao.cfg;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameCfgDAOTemplate;
import com.ks.db.cfg.Signin;
import com.ks.db.cfg.SumSignin;

public class SigninDAO extends GameCfgDAOTemplate {
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="querySignins", dbbean=Signin.class)})
	public List<Signin> querySignins(){
		String sql = DBBeanRowMapperManager.getDynamicSql(Signin.class, "querySignins");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(Signin.class));
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="querySumSignins", dbbean=SumSignin.class)})
	public List<SumSignin> querySumSignins(){
		String sql = DBBeanRowMapperManager.getDynamicSql(SumSignin.class, "querySumSignins");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(SumSignin.class));
	}
}
