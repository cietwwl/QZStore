package com.ks.logic.service;

import java.util.List;

import com.ks.access.Transaction;
import com.ks.db.model.Mail;
import com.ks.db.model.SysMail;
import com.ks.db.model.User;
import com.ks.protocol.vo.goods.GainAwardVO;
import com.ks.protocol.vo.mail.MailVO;

/**
 * 
 * @author ks
 */
public interface MailService {
	
	/**
	 * 初始化邮件
	 */
	void initMails(int userId);
	
	/**
	 * 查询邮件
	 * @param userId 用户编号
	 * @return 用户的所有邮件
	 */
	@Transaction
	List<MailVO> queryMail(int userId);
	/**
	 * 查看邮件
	 * @param userId 用户编号
	 * @param mailId 邮件编号
	 */
	@Transaction
	void viewMail(int userId,int mailId);
	/**
	 * 收取附件
	 * @param userId 用户编号
	 * @param mailId 邮件编号
	 */
	@Transaction
	GainAwardVO collectAdjunct(int userId,int mailId);
	/**
	 * 发送邮件
	 * @param mail 邮件
	 */
	@Transaction
	void sendMail(int userId, Mail mail, boolean notice);
	
	/**
	 * 删除邮件
	 * @param userId
	 * @param mailId
	 */
	@Transaction
	void deleteMail(int userId,int mailId);

	
	/**
	 * 添加系统邮件
	 */
	@Transaction
	void addSysMail(SysMail sysMail);
	
	/**
	 * 删除系统邮件
	 */
	@Transaction
	void deleteSysMail(int id);
	
	/**
	 * 发送系统邮件
	 * @param userId
	 * @return
	 */
	@Transaction
	void sendSysMail(User user, SysMail sysMail);
	
	/**
	 * 初始化系统邮件缓存
	 */
	void initSysMallCache();
	
}
