package com.ks.logic.dao;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetInsertSqlSet;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.DBBeanSetUpdateSqlSet;
import com.ks.access.GameDAOTemplate;
import com.ks.db.model.UserExplore;
import com.ks.table.UserExploreTable;
/**
 * 用户探索dao
 * @author hanjie.l
 *
 */
public class ExploreDAO extends GameDAOTemplate {

	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryUserExplores", dbbean=UserExplore.class, wheres={UserExploreTable.USERID})})
	public List<UserExplore> queryUserExplores(int userId){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserExplore.class, "queryUserExplores");
		 return queryForList(sql, DBBeanRowMapperManager.getRowMapper(UserExplore.class), userId);
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryUserExplore", dbbean=UserExplore.class, wheres={UserExploreTable.USERID, UserExploreTable.EXPLOREID})})
	public UserExplore queryUserExplore(int userId,int exploreId){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserExplore.class, "queryUserExplore");
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(UserExplore.class), userId, exploreId);
	}
	
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addUserExplore", dbbean=UserExplore.class)})
	public void addUserExplore(UserExplore ue){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserExplore.class, "addUserExplore");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserExplore.class, "addUserExplore", ue);
		saveOrUpdate(sql, params.toArray());
		
	}
	
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateUserExplore", dbbean=UserExplore.class, wheres={UserExploreTable.USERID, UserExploreTable.EXPLOREID})})
	public void updateUserExplore(UserExplore ue){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserExplore.class, "updateUserExplore");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserExplore.class, "updateUserExplore", ue);
		saveOrUpdate(sql, params.toArray());
	}
}
