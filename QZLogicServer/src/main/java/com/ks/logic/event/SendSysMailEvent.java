package com.ks.logic.event;

import java.util.List;

import com.ks.action.world.WorldUserAction;
import com.ks.app.Application;
import com.ks.db.model.SysMail;
import com.ks.db.model.User;
import com.ks.event.GameEvent;
import com.ks.logic.service.MailService;
import com.ks.logic.service.ServiceFactory;
import com.ks.logic.service.UserService;
import com.ks.manager.ClientLockManager;
import com.ks.rpc.RPCKernel;
import com.ks.util.LockKeyUtil;

/**
 * 发送系统邮件事件
 *
 */
public class SendSysMailEvent extends GameEvent{
	private SysMail sysMail;
	
	public SendSysMailEvent(SysMail mail){
		this.sysMail = mail;
	}

	@Override
	public void runEvent() throws Exception {
		MailService mailService = ServiceFactory.getService(MailService.class);
		UserService userService = ServiceFactory.getService(UserService.class);
		WorldUserAction action = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, WorldUserAction.class);
		List<Integer> onlineIds = action.getOnlineUserIds();
		for(Integer userId : onlineIds){
			User user = userService.queryCacheUser(userId);
			if(user != null){
				ClientLockManager.lock(LockKeyUtil.getUserLockKey(user.getUserId()));
				try{
					mailService.sendSysMail(user, sysMail);
				}finally{
					ClientLockManager.unlockThreadLock();
				}
			}
		}
	}

}
