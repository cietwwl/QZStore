//package com.ks.logic.dao;
//
//import java.util.List;
//
//import com.ks.access.DBBeanRowMapperManager;
//import com.ks.access.DBBeanSetInsertSqlSet;
//import com.ks.access.DBBeanSetSelectSqlSet;
//import com.ks.access.DBBeanSetSqlSetList;
//import com.ks.access.GameDAOTemplate;
//import com.ks.db.model.UserHeroMap;
//import com.ks.table.UserHeroMapTable;
//
//public class UserHeroMapDAO extends GameDAOTemplate {
//	
//	private static final String getTableName(int userId){
//		return "t_user_hero_map_"+(userId%10);
//	}
//	
//	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryAllHeroMap", dbbean=UserHeroMap.class, fields={UserHeroMapTable.HEROID}, wheres={UserHeroMapTable.USERID})})
//	public List<Integer> queryAllHeroMap(int userId){
//		String sql = DBBeanRowMapperManager.getDynamicSql(UserHeroMap.class, "queryAllHeroMap", getTableName(userId));
//		return queryForList(sql, INT_ROW_MAPPER, userId);
//	}
//	
//	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryUserHeroMap", dbbean=UserHeroMap.class, wheres={UserHeroMapTable.USERID, UserHeroMapTable.HEROID})})
//	public UserHeroMap queryUserHeroMap(int userId,int heroId){
//		String sql = DBBeanRowMapperManager.getDynamicSql(UserHeroMap.class, "queryUserHeroMap", getTableName(userId));
//		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(UserHeroMap.class), userId,heroId);
//	}
//	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addUserHeroMap", dbbean=UserHeroMap.class)})
//	public void addUserHeroMap(UserHeroMap heroMap){
//		String sql = DBBeanRowMapperManager.getDynamicSql(UserHeroMap.class, "addUserHeroMap", getTableName(heroMap.getUserId()));
//		List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserHeroMap.class, "addUserHeroMap", heroMap);
//		saveOrUpdate(sql, params.toArray());
//	}
//}
