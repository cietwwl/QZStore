package com.ks.logic.db_template;
import com.ks.util.JSONUtil;
import org.codehaus.jackson.type.TypeReference;
import java.util.List;
import com.ks.model.task.constant.TaskType;
public final class TaskSettingDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.TaskSetting>{
public TaskSettingDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.TaskSetting.class;
mapper = new com.ks.table.TaskSettingTable.DBRowMapper_TaskSetting();
sqlMap.put("queryTaskSettings","select * from t_task_setting");
paramMethodMap.put("queryTaskSettings", new DynamicSelect_queryTaskSettings());
}
public final class DynamicSelect_queryTaskSettings implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.TaskSetting>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.TaskSetting bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}