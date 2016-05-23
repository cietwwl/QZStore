package com.ks.protocol.vo.task;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 日常任务VO
 * @author hanjie.l
 *
 */
public class UserRenownTaskInfoVO extends Message{

	private static final long serialVersionUID = -4301796537571583908L;
	
	@FieldDesc(desc="任务信息")
	private UserTaskInfoVO userTaskInfoVO;

	public UserTaskInfoVO getUserTaskInfoVO() {
		return userTaskInfoVO;
	}

	public void setUserTaskInfoVO(UserTaskInfoVO userTaskInfoVO) {
		this.userTaskInfoVO = userTaskInfoVO;
	}
}
