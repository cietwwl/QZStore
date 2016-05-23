package com.ks.db.cfg;

import java.util.List;

import org.apache.commons.jexl2.Expression;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.util.ScriptManager;

/**
 * 任务具体行为配置表
 * @author hanjie.l
 *
 */
@DBBeanSet(tablename="t_task_action_setting", imports={"com.ks.util.JSONUtil", "org.codehaus.jackson.type.TypeReference", "java.util.List"}, createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class TaskActionSetting {
	/**主键id*/
	@DBFieldSet(dbfname="id")
	private int id;
	/**目标值*/
	@DBFieldSet(dbfname="goalValue")
	private int goalValue;
	/**感兴趣的事件*/
	@DBFieldSet(dbfname="event")
	private String event;
	/**任务筛选条件*/
	@DBFieldSet(dbfname="eventCondition", parseJavaField="rs.getString(\"eventCondition\")")
	private Expression eventCondition;
	/**执行一个方法获取变化值(优先级一)*/
	@DBFieldSet(dbfname="prepareMethod")
	private String prepareMethod;
	/**方法参数*/
	@DBFieldSet(dbfname="methodParams", parseJavaField="JSONUtil.toObject(rs.getString(\"methodParams\"), new TypeReference<List<String>>(){})")
	private List<String> methodParams;
	/**取事件中的值作为变化值(优先级二)*/
	@DBFieldSet(dbfname="field")
	private String field;
	/**收到事件后默认变化值(优先级三)*/
	@DBFieldSet(dbfname="dealautValue")
	private int dealautValue = 1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Expression getEventCondition() {
		return eventCondition;
	}

	public void setEventCondition(String eventCondition) {
		if(eventCondition != null && !eventCondition.trim().equals("")){
			this.eventCondition = ScriptManager.createExpression(eventCondition);
		}
	}

	public List<String> getMethodParams() {
		return methodParams;
	}

	public void setMethodParams(List<String> methodParams) {
		this.methodParams = methodParams;
	}

	public int getGoalValue() {
		return goalValue;
	}

	public void setGoalValue(int goalValue) {
		this.goalValue = goalValue;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getPrepareMethod() {
		return prepareMethod;
	}

	public void setPrepareMethod(String prepareMethod) {
		this.prepareMethod = prepareMethod;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public int getDealautValue() {
		return dealautValue;
	}

	public void setDealautValue(int dealautValue) {
		this.dealautValue = dealautValue;
	}
}
