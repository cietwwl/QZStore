package com.ks.protocol.vo.task;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.vo.goods.GainAwardVO;
/**
 * 名望任务领取奖励VO
 * @author hanjie.l
 *
 */
public class RenownTaskRewardVO extends Message{

	private static final long serialVersionUID = -6241933675584266710L;
	
	@FieldDesc(desc="名望任务信息")
	private UserRenownTaskInfoVO renownTaskInfoVO;
	
	@FieldDesc(desc="获得物品VO")
	GainAwardVO gainAwardVO;

	public UserRenownTaskInfoVO getRenownTaskInfoVO() {
		return renownTaskInfoVO;
	}

	public void setRenownTaskInfoVO(UserRenownTaskInfoVO renownTaskInfoVO) {
		this.renownTaskInfoVO = renownTaskInfoVO;
	}

	public GainAwardVO getGainAwardVO() {
		return gainAwardVO;
	}

	public void setGainAwardVO(GainAwardVO gainAwardVO) {
		this.gainAwardVO = gainAwardVO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
