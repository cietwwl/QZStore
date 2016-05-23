package com.ks.action.logic;

import java.util.List;

import com.ks.protocol.vo.user.UserBuffVO;

public interface UserBuffAction {
	/**
	 * 获得用户buff
	 * @param userId 用户编号
	 * @return 用户buff
	 */
	List<UserBuffVO> gainUserBuffs(int userId);
}
