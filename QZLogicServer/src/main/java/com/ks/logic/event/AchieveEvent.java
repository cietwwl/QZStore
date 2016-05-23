package com.ks.logic.event;

import java.util.ArrayList;
import java.util.List;

import com.ks.action.world.WorldServerAction;
import com.ks.app.Application;
import com.ks.db.model.UserAchieve;
import com.ks.event.GameEvent;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.AchieveCMD;
import com.ks.protocol.vo.Head;
import com.ks.protocol.vo.achieve.UserAchieveVO;
import com.ks.rpc.RPCKernel;

public class AchieveEvent extends GameEvent {
	/**用户编号*/
	private int userId;
	/**成就*/
	private List<UserAchieve> achieves;
	
	public AchieveEvent(int userId, List<UserAchieve> achieves) {
		super();
		this.userId = userId;
		this.achieves = achieves;
	}

	@Override
	public void runEvent() {
		List<UserAchieveVO> vos = new ArrayList<UserAchieveVO>();
		for(UserAchieve ua : achieves){
			UserAchieveVO vo = MessageFactory.getMessage(UserAchieveVO.class);
			vo.init(ua);
			vos.add(vo);
		}
		WorldServerAction action = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, WorldServerAction.class);
		Head head = MessageFactory.getMessage(Head.class);
		head.init(MainCMD.ACHIEVE,AchieveCMD.ACHIEVE_UPDATE);
		action.sendMessage(userId, head,vos);
	}

}
