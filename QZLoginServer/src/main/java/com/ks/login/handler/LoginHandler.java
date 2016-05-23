package com.ks.login.handler;

import com.ks.action.world.LockAction;
import com.ks.action.world.LoginAction;
import com.ks.app.Application;
import com.ks.handler.GameHandler;
import com.ks.manager.ClientLockManager;
import com.ks.protocol.MainCmd;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.SubCmd;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.LoginCMD;
import com.ks.protocol.vo.Head;
import com.ks.protocol.vo.login.LoginResultVO;
import com.ks.protocol.vo.login.LoginVO;
import com.ks.protocol.vo.login.RegisterVO;
import com.ks.rpc.RPCKernel;

/**
 * 登录
 * @author ks
 *
 */
@MainCmd(mainCmd=MainCMD.LOGIN)
public final class LoginHandler {
	/**
	 * 登录
	 * @param gameHandler
	 * @param loginVO
	 */
	@SubCmd(subCmd=LoginCMD.USER_LOGIN,args={"login"})
	public void login(GameHandler gameHandler,LoginVO loginVO) throws Exception{
		LockAction lockAction = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, LockAction.class);
		long lockId = lockAction.lockUserKey(loginVO.getPartner(), loginVO.getUsername());
		try{
			try{
				LoginAction login = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, LoginAction.class);
				LoginResultVO vo = login.userLogin(loginVO);
				
				Head head = MessageFactory.getMessage(Head.class);
				head.init(MainCMD.LOGIN, LoginCMD.USER_LOGIN);
				
				if(vo.getUserId()!=0){
					head.setSessionId(vo.getSessionId());
					gameHandler.setState(2);
				}
				Application.sendMessage(gameHandler.getChannel(), head, vo);
			}finally{
				ClientLockManager.unlockThreadLock();
			}
		}finally{
			lockAction.unlockKey(lockId);
		}
	}
	/**
	 * 用户注册
	 * @param handler
	 * @param register 注册信息
	 */
	@SubCmd(subCmd=LoginCMD.USER_REGISTER,args={"register"})
	public void userRegister(GameHandler handler,RegisterVO register){
		LoginAction login = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, LoginAction.class);
		login.userRegister(register);
		
		Head head = MessageFactory.getMessage(Head.class);
		head.init(MainCMD.LOGIN, LoginCMD.USER_REGISTER);
		Application.sendMessage(handler.getChannel(), head);
	}
}
