package com.ks.logic.action;

import java.util.List;

import com.ks.action.logic.MailAction;
import com.ks.logic.service.MailService;
import com.ks.logic.service.ServiceFactory;
import com.ks.protocol.vo.goods.GainAwardVO;
import com.ks.protocol.vo.mail.MailVO;

public class MailActionImpl implements MailAction {
	
	private static final MailService mailService = ServiceFactory.getService(MailService.class);
	
	@Override
	public List<MailVO> queryMail(int userId) {
		return mailService.queryMail(userId);
	}

	@Override
	public void viewMail(int userId, int mailId) {
		mailService.viewMail(userId, mailId);
	}

	@Override
	public GainAwardVO collectAdjunct(int userId, int mailId) {
		return mailService.collectAdjunct(userId, mailId);
	}

	@Override
	public void deleteMail(int userId, int mailId) {
		mailService.deleteMail(userId, mailId);
	}

}
