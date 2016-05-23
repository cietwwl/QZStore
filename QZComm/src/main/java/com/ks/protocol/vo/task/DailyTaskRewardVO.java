package com.ks.protocol.vo.task;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.vo.goods.GainAwardVO;

/**
 * 领取日常奖励VO
 * @author hanjie.l
 *
 */
public class DailyTaskRewardVO extends Message{

	private static final long serialVersionUID = -3577296769875447909L;
	
	@FieldDesc(desc="日常任务信息")
	UserDailyTaskInfoVO dailyTaskInfoVO;
	
	@FieldDesc(desc="获得物品VO")
	GainAwardVO gainAwardVO;

	public UserDailyTaskInfoVO getDailyTaskInfoVO() {
		return dailyTaskInfoVO;
	}

	public void setDailyTaskInfoVO(UserDailyTaskInfoVO dailyTaskInfoVO) {
		this.dailyTaskInfoVO = dailyTaskInfoVO;
	}

	public GainAwardVO getGainAwardVO() {
		return gainAwardVO;
	}

	public void setGainAwardVO(GainAwardVO gainAwardVO) {
		this.gainAwardVO = gainAwardVO;
	}
}
