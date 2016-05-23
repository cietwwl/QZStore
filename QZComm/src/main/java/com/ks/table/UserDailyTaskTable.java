package com.ks.table;
public final class UserDailyTaskTable extends com.ks.access.DBBeanTable<com.ks.db.model.UserDailyTask>{
public static UserDailyTaskTable instance;
public static final String TABLE_NAME="t_user_daily_task";
public static final String ACTIVEVALUE="activeValue";
public static final String LASTREFRESHTIME="lastRefreshTime";
public static final String REWARDEDBOX="rewardedBox";
public static final String USERID="userId";
public static final String TASKTYPE="tasktype";
public static final String CURRENTTASK="currentTask";
public static final String FINISHEDTASKIDS="finishedTaskIds";
public static final String REWARDEDTASKIDS="rewardedTaskIds";
public static final String HASDISTINCTIDS="hasDisTinctIds";

public static final String J_ACTIVEVALUE="activeValue";
public static final String J_LASTREFRESHTIME="lastRefreshTime";
public static final String J_REWARDEDBOX="rewardedBox";
public static final String J_USERID="userId";
public static final String J_TASKTYPE="taskType";
public static final String J_CURRENTTASK="currentTask";
public static final String J_FINISHEDTASKIDS="finishedTaskIds";
public static final String J_REWARDEDTASKIDS="rewardedTaskIds";
public static final String J_HASDISTINCTIDS="hasDisTinctIds";

public UserDailyTaskTable(){
mapper=new DBRowMapper_UserDailyTask();
}
@Override
public Object getDBFieldValue(com.ks.db.model.UserDailyTask bean, String fname){
if(ACTIVEVALUE.equals(fname)){
return bean.getActiveValue();
}
if(LASTREFRESHTIME.equals(fname)){
return bean.getLastRefreshTime();
}
if(REWARDEDBOX.equals(fname)){
return bean.getRewardedBox();
}
if(USERID.equals(fname)){
return bean.getUserId();
}
if(TASKTYPE.equals(fname)){
return bean.getTaskType();
}
if(CURRENTTASK.equals(fname)){
return bean.getCurrentTask();
}
if(FINISHEDTASKIDS.equals(fname)){
return bean.getFinishedTaskIds();
}
if(REWARDEDTASKIDS.equals(fname)){
return bean.getRewardedTaskIds();
}
if(HASDISTINCTIDS.equals(fname)){
return bean.getHasDisTinctIds();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.model.UserDailyTask.class;
}
public final static class DBRowMapper_UserDailyTask implements com.ks.access.mapper.RowMapper<com.ks.db.model.UserDailyTask>{
@Override
public com.ks.db.model.UserDailyTask rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.UserDailyTask bean = new com.ks.db.model.UserDailyTask();
bean.setActiveValue(rs.getInt("activeValue"));
bean.setLastRefreshTime(rs.getTimestamp("lastRefreshTime"));
bean.setRewardedBox(rs.getString("rewardedBox"));
bean.setUserId(rs.getInt("userId"));
bean.setTaskType(rs.getString("tasktype"));
bean.setCurrentTask(rs.getString("currentTask"));
bean.setFinishedTaskIds(rs.getString("finishedTaskIds"));
bean.setRewardedTaskIds(rs.getString("rewardedTaskIds"));
bean.setHasDisTinctIds(rs.getString("hasDisTinctIds"));
return bean;
}
}
}
