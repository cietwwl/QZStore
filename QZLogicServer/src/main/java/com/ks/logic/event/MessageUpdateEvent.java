package com.ks.logic.event;

import com.ks.action.world.WorldServerAction;
import com.ks.app.Application;
import com.ks.event.GameEvent;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.Head;
import com.ks.rpc.RPCKernel;

/**
 * 消息推送
 * @author ks
 *
 */
public class MessageUpdateEvent extends GameEvent {

	private int userId;
	private short mainCmd;
	private short subCmd;
	private Object message;
	
	public MessageUpdateEvent(int userId, short mainCmd, short subCmd,
			Object message) {
		super();
		this.userId = userId;
		this.mainCmd = mainCmd;
		this.subCmd = subCmd;
		this.message = message;
	}

	@Override
	public void runEvent() throws Exception {
		Head head = MessageFactory.getMessage(Head.class);
		head.init(mainCmd, subCmd);
		WorldServerAction action = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, WorldServerAction.class);
		action.sendMessage(userId, head, message);
	}

}
