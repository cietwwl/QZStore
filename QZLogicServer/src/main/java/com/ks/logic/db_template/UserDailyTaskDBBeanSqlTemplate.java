package com.ks.logic.db_template;
public final class UserDailyTaskDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.UserDailyTask>{
public UserDailyTaskDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.UserDailyTask.class;
mapper = new com.ks.table.UserDailyTaskTable.DBRowMapper_UserDailyTask();
sqlMap.put("getUserDailyTask","select * from t_user_daily_task where `userId`=? limit 1");
sqlMap.put("updateUserDailyTask","update t_user_daily_task set `activeValue`=?,`lastRefreshTime`=?,`rewardedBox`=?,`userId`=?,`tasktype`=?,`currentTask`=?,`finishedTaskIds`=?,`rewardedTaskIds`=?,`hasDisTinctIds`=? where `userId`=?");
sqlMap.put("addUserDailyTask","insert t_user_daily_task (`activeValue`,`lastRefreshTime`,`rewardedBox`,`userId`,`tasktype`,`currentTask`,`finishedTaskIds`,`rewardedTaskIds`,`hasDisTinctIds`) values (?,?,?,?,?,?,?,?,?)");
paramMethodMap.put("getUserDailyTask", new DynamicSelect_getUserDailyTask());
paramMethodMap.put("updateUserDailyTask", new DynamicUpdata_updateUserDailyTask());
paramMethodMap.put("addUserDailyTask", new DynamicInsert_addUserDailyTask());
}
public final class DynamicSelect_getUserDailyTask implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserDailyTask>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserDailyTask bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
public final class DynamicUpdata_updateUserDailyTask implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserDailyTask>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserDailyTask bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getActiveValue());
list.add(bean.getLastRefreshTime());
list.add(bean.getRewardedBox());
list.add(bean.getUserId());
list.add(bean.getTaskType());
list.add(bean.getCurrentTask());
list.add(bean.getFinishedTaskIds());
list.add(bean.getRewardedTaskIds());
list.add(bean.getHasDisTinctIds());
list.add(bean.getUserId());
return list;
}
}
public final class DynamicInsert_addUserDailyTask implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserDailyTask>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserDailyTask bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getActiveValue());
list.add(bean.getLastRefreshTime());
list.add(bean.getRewardedBox());
list.add(bean.getUserId());
list.add(bean.getTaskType());
list.add(bean.getCurrentTask());
list.add(bean.getFinishedTaskIds());
list.add(bean.getRewardedTaskIds());
list.add(bean.getHasDisTinctIds());
return list;
}
}
}