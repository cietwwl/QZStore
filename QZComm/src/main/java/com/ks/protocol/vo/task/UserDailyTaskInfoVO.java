package com.ks.protocol.vo.task;

import java.util.List;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;

/**
 * 日常任务VO
 * @author hanjie.l
 *
 */
public class UserDailyTaskInfoVO extends Message{
	
	private static final long serialVersionUID = 6132705993350487723L;

	@FieldDesc(desc="活跃度")
	private int activeValue;
	
	@FieldDesc(desc="已领取的活跃度宝箱")
	private List<Integer> rewardedBox;
	
	@FieldDesc(desc="任务信息")
	private UserTaskInfoVO userTaskInfoVO;

	public int getActiveValue() {
		return activeValue;
	}

	public void setActiveValue(int activeValue) {
		this.activeValue = activeValue;
	}

	public UserTaskInfoVO getUserTaskInfoVO() {
		return userTaskInfoVO;
	}

	public void setUserTaskInfoVO(UserTaskInfoVO userTaskInfoVO) {
		this.userTaskInfoVO = userTaskInfoVO;
	}

	public List<Integer> getRewardedBox() {
		return rewardedBox;
	}

	public void setRewardedBox(List<Integer> rewardedBox) {
		this.rewardedBox = rewardedBox;
	}
	
}
