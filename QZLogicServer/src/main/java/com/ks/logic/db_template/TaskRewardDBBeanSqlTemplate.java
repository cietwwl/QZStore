package com.ks.logic.db_template;
public final class TaskRewardDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.TaskReward>{
public TaskRewardDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.TaskReward.class;
mapper = new com.ks.table.TaskRewardTable.DBRowMapper_TaskReward();
sqlMap.put("queryTaskRewards","select * from t_task_reward");
paramMethodMap.put("queryTaskRewards", new DynamicSelect_queryTaskRewards());
}
public final class DynamicSelect_queryTaskRewards implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.TaskReward>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.TaskReward bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}