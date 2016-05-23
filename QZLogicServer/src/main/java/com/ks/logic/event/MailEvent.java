package com.ks.logic.event;

import com.ks.action.world.WorldServerAction;
import com.ks.app.Application;
import com.ks.db.model.Mail;
import com.ks.event.GameEvent;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.MailCMD;
import com.ks.protocol.vo.Head;
import com.ks.protocol.vo.mail.MailVO;
import com.ks.rpc.RPCKernel;

public class MailEvent extends GameEvent {
	
	private int userId;
	private Mail mail;
	public MailEvent(int userId,Mail mail) {
		super();
		this.userId = userId;
		this.mail = mail;
	}

	@Override
	public void runEvent() {
		Head head = MessageFactory.getMessage(Head.class);
		head.init(MainCMD.MAIL, MailCMD.NEW_MAIL);
		WorldServerAction action = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, WorldServerAction.class);
		MailVO vo = MessageFactory.getMessage(MailVO.class);
		vo.init(mail);
		action.sendMessage(userId, head,vo);
	}
}
