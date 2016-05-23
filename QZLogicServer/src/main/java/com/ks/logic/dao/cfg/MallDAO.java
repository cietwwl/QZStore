package com.ks.logic.dao.cfg;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameCfgDAOTemplate;
import com.ks.db.cfg.Mall;
import com.ks.db.cfg.MallGoods;
import com.ks.db.cfg.PayGoods;

public class MallDAO extends GameCfgDAOTemplate {

	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryAllMall", dbbean=Mall.class)})
	public List<Mall> queryAllMall(){
		String sql = DBBeanRowMapperManager.getDynamicSql(Mall.class, "queryAllMall");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(Mall.class));
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryAllMallGoods", dbbean=MallGoods.class)})
	public List<MallGoods> queryAllMallGoods(){
		String sql = DBBeanRowMapperManager.getDynamicSql(MallGoods.class, "queryAllMallGoods");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(MallGoods.class));
	}

	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryPayGoodses", dbbean=PayGoods.class)})
	public List<PayGoods> queryPayGoodses(){
		String sql = DBBeanRowMapperManager.getDynamicSql(PayGoods.class, "queryPayGoodses");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(PayGoods.class));
	}
}
