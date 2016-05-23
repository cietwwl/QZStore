package com.ks.logic.event;

import com.ks.action.world.WorldServerAction;
import com.ks.app.Application;
import com.ks.data.DataSet;
import com.ks.event.GameEvent;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.DataCmd;
import com.ks.protocol.vo.Head;
import com.ks.protocol.vo.data.DataSetVO;
import com.ks.rpc.RPCKernel;

/**
 * 装备更新
 * @author zck
 *
 */
public class DataUpdateEvent extends GameEvent {

	private DataSet set;
	
	public DataUpdateEvent(DataSet set){
		this.set = set;
	}
	
	@Override
	public void runEvent() throws Exception {
		Head head = MessageFactory.getMessage(Head.class);
		head.init(MainCMD.DATA, DataCmd.COMMON);
		WorldServerAction action = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, WorldServerAction.class);
		DataSetVO vo = MessageFactory.getMessage(DataSetVO.class);
		vo.init(set);
		action.sendMessage(set.getUserId(), head, vo);
	}

}
