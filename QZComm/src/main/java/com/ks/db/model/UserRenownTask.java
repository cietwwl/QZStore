package com.ks.db.model;

import com.ks.access.DBBeanSet;
import com.ks.model.task.constant.TaskType;
/**
 * 用户名望任务
 * @author hanjie.l
 *
 */
@DBBeanSet(imports={"com.ks.util.StringUtils", "com.ks.model.task.constant.TaskType"}, tablename="t_user_renown_task", primaryKey={"userId"})
public class UserRenownTask extends UserTask{
	
	@Override
	public void init(int userId){
		this.userId = userId;
		setTaskType(TaskType.RENOWN_TASK.toString());
	}

}
