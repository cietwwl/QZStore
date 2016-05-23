package com.ks.db.cfg;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.db.model.Goods;
/**
 * 活跃度宝箱奖励
 * @author hanjie.l
 *
 */
@DBBeanSet(tablename="t_task_box_reward", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class TaskBoxReward extends Goods{
	private static final long serialVersionUID = -1107930489629340336L;
	/**主键id*/
	@DBFieldSet(dbfname="id")
	private int id;
	/**需要活跃度*/
	@DBFieldSet(dbfname="active")
	private int active;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
}
