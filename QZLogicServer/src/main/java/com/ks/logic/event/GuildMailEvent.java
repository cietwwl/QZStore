package com.ks.logic.event;

import java.util.List;

import com.ks.db.model.Mail;
import com.ks.event.GameEvent;
import com.ks.logic.service.MailService;
import com.ks.logic.service.ServiceFactory;

public class GuildMailEvent extends GameEvent {
	private List<Integer> userIds;
	private Mail mail;
	
	public GuildMailEvent(List<Integer> userIds, Mail mail) {
		super();
		this.userIds = userIds;
		this.mail = mail;
	}
	@Override
	public void runEvent() {
		MailService service = ServiceFactory.getService(MailService.class);
		for(int userId : userIds){
			Mail m = Mail.createMail(userId, mail.getType(), mail.getTitle(), mail.getContext(), mail.getGoodsList());
			service.sendMail(userId, m, true);
		}
	}

}
