package com.ks.db.cfg;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.db.model.Goods;
/**
 * 任务奖励
 * @author hanjie.l
 *
 */
@DBBeanSet(tablename="t_task_reward", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class TaskReward extends Goods{
	private static final long serialVersionUID = 8701032284477580507L;
	/**主键id*/
	@DBFieldSet(dbfname="id")
	private int id;
	/**任务id {@link TaskSetting#getId()} */
	@DBFieldSet(dbfname="taskId")
	private int taskId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
}
