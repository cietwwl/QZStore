package com.ks.table;
import com.ks.util.StringUtils;
import com.ks.model.task.constant.TaskType;
public final class UserRenownTaskTable extends com.ks.access.DBBeanTable<com.ks.db.model.UserRenownTask>{
public static UserRenownTaskTable instance;
public static final String TABLE_NAME="t_user_renown_task";
public static final String USERID="userId";
public static final String TASKTYPE="tasktype";
public static final String CURRENTTASK="currentTask";
public static final String FINISHEDTASKIDS="finishedTaskIds";
public static final String REWARDEDTASKIDS="rewardedTaskIds";
public static final String HASDISTINCTIDS="hasDisTinctIds";

public static final String J_USERID="userId";
public static final String J_TASKTYPE="taskType";
public static final String J_CURRENTTASK="currentTask";
public static final String J_FINISHEDTASKIDS="finishedTaskIds";
public static final String J_REWARDEDTASKIDS="rewardedTaskIds";
public static final String J_HASDISTINCTIDS="hasDisTinctIds";

public UserRenownTaskTable(){
mapper=new DBRowMapper_UserRenownTask();
}
@Override
public Object getDBFieldValue(com.ks.db.model.UserRenownTask bean, String fname){
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
return com.ks.db.model.UserRenownTask.class;
}
public final static class DBRowMapper_UserRenownTask implements com.ks.access.mapper.RowMapper<com.ks.db.model.UserRenownTask>{
@Override
public com.ks.db.model.UserRenownTask rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.UserRenownTask bean = new com.ks.db.model.UserRenownTask();
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
