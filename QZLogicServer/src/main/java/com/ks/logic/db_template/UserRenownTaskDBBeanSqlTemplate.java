package com.ks.logic.db_template;
import com.ks.util.StringUtils;
import com.ks.model.task.constant.TaskType;
public final class UserRenownTaskDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.UserRenownTask>{
public UserRenownTaskDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.UserRenownTask.class;
mapper = new com.ks.table.UserRenownTaskTable.DBRowMapper_UserRenownTask();
sqlMap.put("updateUserRenownTask","update t_user_renown_task set `userId`=?,`tasktype`=?,`currentTask`=?,`finishedTaskIds`=?,`rewardedTaskIds`=?,`hasDisTinctIds`=? where `userId`=?");
sqlMap.put("getUserRenownTask","select * from t_user_renown_task where `userId`=? limit 1");
sqlMap.put("addUserRenownTask","insert t_user_renown_task (`userId`,`tasktype`,`currentTask`,`finishedTaskIds`,`rewardedTaskIds`,`hasDisTinctIds`) values (?,?,?,?,?,?)");
paramMethodMap.put("updateUserRenownTask", new DynamicUpdata_updateUserRenownTask());
paramMethodMap.put("getUserRenownTask", new DynamicSelect_getUserRenownTask());
paramMethodMap.put("addUserRenownTask", new DynamicInsert_addUserRenownTask());
}
public final class DynamicUpdata_updateUserRenownTask implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserRenownTask>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserRenownTask bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
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
public final class DynamicSelect_getUserRenownTask implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserRenownTask>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserRenownTask bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
public final class DynamicInsert_addUserRenownTask implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserRenownTask>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserRenownTask bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
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