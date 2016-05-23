package com.ks.table;
import com.ks.util.JSONUtil;
import org.codehaus.jackson.type.TypeReference;
import java.util.List;
public final class TaskActionSettingTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.TaskActionSetting>{
public static TaskActionSettingTable instance;
public static final String TABLE_NAME="t_task_action_setting";
public static final String ID="id";
public static final String GOALVALUE="goalValue";
public static final String EVENT="event";
public static final String EVENTCONDITION="eventCondition";
public static final String PREPAREMETHOD="prepareMethod";
public static final String METHODPARAMS="methodParams";
public static final String FIELD="field";
public static final String DEALAUTVALUE="dealautValue";

public static final String J_ID="id";
public static final String J_GOALVALUE="goalValue";
public static final String J_EVENT="event";
public static final String J_EVENTCONDITION="eventCondition";
public static final String J_PREPAREMETHOD="prepareMethod";
public static final String J_METHODPARAMS="methodParams";
public static final String J_FIELD="field";
public static final String J_DEALAUTVALUE="dealautValue";

public TaskActionSettingTable(){
mapper=new DBRowMapper_TaskActionSetting();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.TaskActionSetting bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(GOALVALUE.equals(fname)){
return bean.getGoalValue();
}
if(EVENT.equals(fname)){
return bean.getEvent();
}
if(EVENTCONDITION.equals(fname)){
return bean.getEventCondition();
}
if(PREPAREMETHOD.equals(fname)){
return bean.getPrepareMethod();
}
if(METHODPARAMS.equals(fname)){
return bean.getMethodParams();
}
if(FIELD.equals(fname)){
return bean.getField();
}
if(DEALAUTVALUE.equals(fname)){
return bean.getDealautValue();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.TaskActionSetting.class;
}
public final static class DBRowMapper_TaskActionSetting implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.TaskActionSetting>{
@Override
public com.ks.db.cfg.TaskActionSetting rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.TaskActionSetting bean = new com.ks.db.cfg.TaskActionSetting();
bean.setId(rs.getInt("id"));
bean.setGoalValue(rs.getInt("goalValue"));
bean.setEvent(rs.getString("event"));
bean.setEventCondition(rs.getString("eventCondition"));
bean.setPrepareMethod(rs.getString("prepareMethod"));
bean.setMethodParams(JSONUtil.toObject(rs.getString("methodParams"), new TypeReference<List<String>>(){}));
bean.setField(rs.getString("field"));
bean.setDealautValue(rs.getInt("dealautValue"));
return bean;
}
}
}
