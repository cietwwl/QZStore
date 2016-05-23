package com.ks.logic.db_template;
public final class TaskBoxRewardDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.TaskBoxReward>{
public TaskBoxRewardDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.TaskBoxReward.class;
mapper = new com.ks.table.TaskBoxRewardTable.DBRowMapper_TaskBoxReward();
sqlMap.put("queryTaskBoxRewards","select * from t_task_box_reward");
paramMethodMap.put("queryTaskBoxRewards", new DynamicSelect_queryTaskBoxRewards());
}
public final class DynamicSelect_queryTaskBoxRewards implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.TaskBoxReward>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.TaskBoxReward bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}