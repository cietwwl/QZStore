package com.ks.logic.db_template;
import com.ks.util.JSONUtil;
import org.codehaus.jackson.type.TypeReference;
import java.util.List;
public final class TaskActionSettingDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.TaskActionSetting>{
public TaskActionSettingDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.TaskActionSetting.class;
mapper = new com.ks.table.TaskActionSettingTable.DBRowMapper_TaskActionSetting();
sqlMap.put("queryTaskActionSettings","select * from t_task_action_setting");
paramMethodMap.put("queryTaskActionSettings", new DynamicSelect_queryTaskActionSettings());
}
public final class DynamicSelect_queryTaskActionSettings implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.TaskActionSetting>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.TaskActionSetting bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}