package com.ks.db.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.model.task.constant.TaskType;
import com.ks.util.StringUtils;
import com.ks.util.XyTimeUtil;
/**
 * 日常任务
 * @author hanjie.l
 *
 */
@DBBeanSet(tablename="t_user_daily_task", primaryKey="userId")
@EqualsAndHashCode(callSuper=true)
@Data
public class UserDailyTask extends UserTask{
	/**活跃度*/
	@DBFieldSet(dbfname="activeValue")
	private int activeValue;
	/**上次刷新时间*/
	@DBFieldSet(dbfname="lastRefreshTime")
	private Date lastRefreshTime = new Date();
	/**已领取的宝箱奖励*/
	@DBFieldSet(dbfname="rewardedBox")
	private String rewardedBox;
	
	private Set<Integer> rewardedBoxList;
	
	private void initRewardBoxList(){
		rewardedBoxList = StringUtils.stringToSet(rewardedBox);
	}
	private void initRewardBoxs(){
		rewardedBox = StringUtils.setToString(rewardedBoxList);
	}

	@Override
	public void init(int userId){
		this.userId = userId;
		setTaskType(TaskType.DAILY_TASK.toString());
		setRewardedBoxList(new HashSet<Integer>());
		this.lastRefreshTime = new Date();
	}
	
	/**
	 * 清除原有数据
	 */
	public void clear(){
		this.activeValue = 0;
		setCurrentTaskMap(new ConcurrentHashMap<Integer, Map<Integer, Integer>>());
		setFinishedTaskIdList(new HashSet<Integer>());
		setRewardedTaskIdList(new HashSet<Integer>());
		setRewardedBoxList(new HashSet<Integer>());
		setHasDisTinctIdList(new HashSet<Integer>());
		this.lastRefreshTime = new Date();
	}
	
	/**
	 * 是否需要重置
	 * @return
	 */
	public boolean needReset(){
		Date zero = XyTimeUtil.getDate(0, 0, 0);
		return XyTimeUtil.before(lastRefreshTime, zero);
	}

	public Date getLastRefreshTime() {
		return lastRefreshTime;
	}

	public void setLastRefreshTime(Date lastRefreshTime) {
		this.lastRefreshTime = lastRefreshTime;
	}

	public int getActiveValue() {
		return activeValue;
	}

	public void setActiveValue(int activeValue) {
		this.activeValue = activeValue;
	}
	
	public String getRewardedBox() {
		initRewardBoxs();
		return rewardedBox;
	}

	public void setRewardedBox(String rewardedBox) {
		this.rewardedBox = rewardedBox;
		initRewardBoxList();
	}

	/**
	 * 增加活跃度值
	 * @param value
	 */
	public void addActiveValue(int value){
		this.activeValue += value;
	}
	
	/**
	 * 添加已领宝箱记录
	 * @param active
	 */
	public void addRewardedBox(int active){
		this.rewardedBoxList.add(active);
	}
	
	/**
	 * 是否已领取活跃度宝箱
	 * @param active
	 */
	public boolean isReceieveBox(int active){
		return this.rewardedBoxList.contains(active);
	}
}
