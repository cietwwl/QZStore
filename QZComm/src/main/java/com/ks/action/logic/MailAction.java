package com.ks.action.logic;

import java.util.List;

import com.ks.protocol.vo.goods.GainAwardVO;
import com.ks.protocol.vo.mail.MailVO;

public interface MailAction {
	/**
	 * 查询邮件
	 * @param userId 用户编号
	 * @return 用户的所有邮件
	 */
	List<MailVO> queryMail(int userId);
	/**
	 * 查看邮件
	 * @param userId 用户编号
	 * @param mailId 邮件编号
	 */
	void viewMail(int userId,int mailId);
	/**
	 * 收取附件
	 * @param userId 用户编号
	 * @param mailId 邮件编号
	 */
	GainAwardVO collectAdjunct(int userId,int mailId);
	/**
	 * 删除邮件
	 * @param userId
	 * @param mailId
	 */
	void deleteMail(int userId,int mailId);
}
