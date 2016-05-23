package com.ks.table;
import com.ks.util.JSONUtil;
import org.codehaus.jackson.type.TypeReference;
import java.util.List;
import com.ks.model.task.constant.TaskType;
public final class TaskSettingTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.TaskSetting>{
public static TaskSettingTable instance;
public static final String TABLE_NAME="t_task_setting";
public static final String ID="id";
public static final String TASKTYPE="taskType";
public static final String LEADTASKID="leadTaskId";
public static final String TASKACTIONLIST="taskActionList";
public static final String NEEDPLAYERLEVEL="needPlayerLevel";
public static final String NEEDFAME="needFame";
public static final String REWARDACTIVE="rewardActive";
public static final String DISTINCTID="distinctId";
public static final String CONDITIONS="conditions";

public static final String J_ID="id";
public static final String J_TASKTYPE="taskType";
public static final String J_LEADTASKID="leadTaskId";
public static final String J_TASKACTIONLIST="taskActionList";
public static final String J_NEEDPLAYERLEVEL="needPlayerLevel";
public static final String J_NEEDFAME="needFame";
public static final String J_REWARDACTIVE="rewardActive";
public static final String J_DISTINCTID="distinctId";
public static final String J_CONDITIONS="conditions";

public TaskSettingTable(){
mapper=new DBRowMapper_TaskSetting();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.TaskSetting bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(TASKTYPE.equals(fname)){
return bean.getTaskType();
}
if(LEADTASKID.equals(fname)){
return bean.getLeadTaskId();
}
if(TASKACTIONLIST.equals(fname)){
return bean.getTaskActionList();
}
if(NEEDPLAYERLEVEL.equals(fname)){
return bean.getNeedPlayerLevel();
}
if(NEEDFAME.equals(fname)){
return bean.getNeedFame();
}
if(REWARDACTIVE.equals(fname)){
return bean.getRewardActive();
}
if(DISTINCTID.equals(fname)){
return bean.getDistinctId();
}
if(CONDITIONS.equals(fname)){
return bean.getConditions();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.TaskSetting.class;
}
public final static class DBRowMapper_TaskSetting implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.TaskSetting>{
@Override
public com.ks.db.cfg.TaskSetting rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.TaskSetting bean = new com.ks.db.cfg.TaskSetting();
bean.setId(rs.getInt("id"));
bean.setTaskType(TaskType.valueOf(rs.getString("taskType")));
bean.setLeadTaskId(rs.getInt("leadTaskId"));
bean.setTaskActionList(JSONUtil.toObject(rs.getString("taskActionList"), new TypeReference<List<Integer>>(){}));
bean.setNeedPlayerLevel(rs.getInt("needPlayerLevel"));
bean.setNeedFame(rs.getInt("needFame"));
bean.setRewardActive(rs.getInt("rewardActive"));
bean.setDistinctId(rs.getInt("distinctId"));
bean.setConditions(rs.getString("conditions"));
return bean;
}
}
}
