package com.ks.game.handler;

import java.util.List;

import com.ks.app.Application;
import com.ks.game.model.Player;
import com.ks.handler.GameHandler;
import com.ks.manager.ClientLockManager;
import com.ks.protocol.MainCmd;
import com.ks.protocol.SubCmd;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.MailCMD;
import com.ks.protocol.vo.mail.MailVO;
import com.ks.util.LockKeyUtil;

/**
 * 邮件
 * @author ks
 */
@MainCmd(mainCmd=MainCMD.MAIL)
public class MailHandler extends ActionAdapter {
	
	/**
	 * 查询邮件
	 * @param handler
	 */
	@SubCmd(subCmd=MailCMD.QUERY_MAIL)
	public void queryMail(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			List<MailVO> mails = mailAction().queryMail(player.getUserId());
			Application.sendMessage(handler.getChannel(), handler.getHead(), mails);
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 查看邮件
	 * @param handler
	 * @param mailId 邮件编号
	 */
	@SubCmd(subCmd=MailCMD.VIEW_MAIL,args="int")
	public void viewMail(GameHandler handler,int mailId){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			mailAction().viewMail(player.getUserId(),mailId);
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 查看邮件
	 * @param handler
	 * @param mailId 邮件编号
	 */
	@SubCmd(subCmd=MailCMD.DELETE_MAIL,args="int")
	public void deleteMail(GameHandler handler,int mailId){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			mailAction().deleteMail(player.getUserId(),mailId);
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 收取邮件
	 * @param handler
	 * @param mailId 邮件编号
	 */
	@SubCmd(subCmd=MailCMD.COLLECT_ADJUNCT,args="int")
	public void collectAdjunct(GameHandler handler,int mailId){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), 
					handler.getHead(), 
					mailAction().collectAdjunct(player.getUserId(),mailId));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	
}
