package com.ks.logic.dao;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetInsertSqlSet;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.DBBeanSetUpdateSqlSet;
import com.ks.access.GameDAOTemplate;
import com.ks.cache.JedisBeanManager;
import com.ks.constant.SystemConstant;
import com.ks.db.model.UserGuideStep;
import com.ks.table.UserGuideStepTable;
import com.ks.util.XyTimeUtil;

/**
 * 用户引导
 *
 */
public class UserGuideStepDAO extends GameDAOTemplate{

	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryUserGuideStep", dbbean=UserGuideStep.class, wheres={UserGuideStepTable.ID})})
	public UserGuideStep queryUserGuideStep(int userId){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserGuideStep.class, "queryUserGuideStep");
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(UserGuideStep.class), userId);
	}
	
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addUserGuideStep", dbbean=UserGuideStep.class)})
	public void addUserGuideStep(UserGuideStep step){
		int now = XyTimeUtil.getNowSecond();
		step.setUpdateTime(now);
		step.setCreateTime(now);
		String sql = DBBeanRowMapperManager.getDynamicSql(UserGuideStep.class, "addUserGuideStep");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserGuideStep.class, "addUserGuideStep", step);
		saveOrUpdate(sql, params.toArray());
	}
	
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateUserGuideStep", dbbean=UserGuideStep.class, wheres={UserGuideStepTable.ID})})
	public void updateUserGuideStep(UserGuideStep step) {
		step.setUpdateTime(XyTimeUtil.getNowSecond());
		String sql = DBBeanRowMapperManager.getDynamicSql(UserGuideStep.class, "updateUserGuideStep");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserGuideStep.class, "updateUserGuideStep", step);
		saveOrUpdate(sql, params.toArray());
	}
	
	/*****************************************cache **************************************/

	private static final String USER_GUIDE = "USER_GUIDE_";
	
	private static final String getUserGuideStepSetKey(int userId){
		return USER_GUIDE + userId;
	}
	
	/**
	 * 查询缓存
	 */
	public UserGuideStep queryUserGuideStepsCache(int userId){
		String setKey = getUserGuideStepSetKey(userId);
		return hgetAll(setKey, JedisBeanManager.getRowMapper(UserGuideStep.class));
	}
	
	/**
	 * 添加缓存
	 */
	public void setUserGuideStepCache(UserGuideStep userGuideStep){
		String setKey = getUserGuideStepSetKey(userGuideStep.getId());
		hmset(setKey, JedisBeanManager.getObjMapper(UserGuideStep.class).objectToMap(userGuideStep));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}
}
