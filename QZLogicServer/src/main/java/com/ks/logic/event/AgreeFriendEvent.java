package com.ks.logic.event;

import com.ks.action.world.WorldServerAction;
import com.ks.app.Application;
import com.ks.db.model.Friend;
import com.ks.event.GameEvent;
import com.ks.logic.service.ServiceFactory;
import com.ks.logic.service.UserService;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.FriendCMD;
import com.ks.protocol.vo.Head;
import com.ks.protocol.vo.friend.FriendVO;
import com.ks.protocol.vo.user.UserBaseinfoVO;
import com.ks.rpc.RPCKernel;

public class AgreeFriendEvent extends GameEvent {
	
	private static final UserService userService = ServiceFactory.getService(UserService.class);
	
	private Friend friend;
	
	public AgreeFriendEvent(Friend friend) {
		super();
		this.friend = friend;
	}

	@Override
	public void runEvent() {
		Head head = MessageFactory.getMessage(Head.class);
		head.init(MainCMD.FRIEND, FriendCMD.AGREE_APPLY);
		
		FriendVO vo = MessageFactory.getMessage(FriendVO.class);
		vo.setState(0);
		
		UserBaseinfoVO info = MessageFactory.getMessage(UserBaseinfoVO.class);
		info.init(userService.getUserBaseInfo(friend.getFriendId()));
		vo.setInfo(info);
		
		WorldServerAction action = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, WorldServerAction.class);
		action.sendMessage(friend.getUserId(), head, vo);
	}

}
