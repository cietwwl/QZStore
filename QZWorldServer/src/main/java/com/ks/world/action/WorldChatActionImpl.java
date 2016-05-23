package com.ks.world.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.ks.action.game.GameServerAction;
import com.ks.action.world.WorldChatAction;
import com.ks.exceptions.GameException;
import com.ks.protocol.vo.Head;
import com.ks.protocol.vo.chat.ChatMessageVO;
import com.ks.rpc.RPCKernel;
import com.ks.rpc.ServerInfo;
import com.ks.util.XyTimeUtil;
import com.ks.world.kernel.OnlineBattleManager;
import com.ks.world.kernel.OnlineBattleManager.OnlineBattle;
import com.ks.world.kernel.PlayerStaticInfo;
import com.ks.world.kernel.WorldServerCache;

public class WorldChatActionImpl implements WorldChatAction {
	
	private static final Queue<ChatMessageVO> messages = new LinkedBlockingQueue<>(30);
	
	@Override
	public void chat(int sendUserId, Head head,ChatMessageVO chatMessage, int ... targetIds) {
		
		//世界频道聊天
		if(chatMessage.getType() == 1){
			PlayerStaticInfo staticInfo = WorldServerCache.getPlayerStaticInfoByUserId(sendUserId);
			if(staticInfo != null && staticInfo.getBanChatTime() > XyTimeUtil.getNowSecond()){
				throw new GameException(GameException.CODE_您已被禁言, "");
			}
			while(!messages.offer(chatMessage)){
				messages.poll();
			}
			WorldServerCache.getServerInfoLock().lock();
			try{
				for(ServerInfo info : WorldServerCache.gainAllGameServer()){
					GameServerAction action = RPCKernel.getRemoteByServerId(info.getServerId(), GameServerAction.class);
					action.sendChatChannelMessage(chatMessage.getAssId(), head, chatMessage);
				}
			}finally{
				WorldServerCache.getServerInfoLock().unlock();
			}
		//私聊
		}else if(chatMessage.getType() == 2){
			PlayerStaticInfo staticInfo = WorldServerCache.getPlayerStaticInfoByUserId(chatMessage.getAssId());
			if(staticInfo==null){
				throw new GameException(GameException.CODE_对方不在线, "");
			}
			GameServerAction action = RPCKernel.getRemoteByServerId(staticInfo.getGameServerId(), GameServerAction.class);
			action.sendMessage(staticInfo.getSessionId(), head, chatMessage);
		//指定战斗聊天
		}else if(chatMessage.getType() == 3){
			OnlineBattle ob = OnlineBattleManager.getManager().getOnlineBattleByUserId(sendUserId);
			if(ob != null){
				Map<String, List<String>> sessionIdsMap = new HashMap<String, List<String>>();
				for(int uid : ob.getViewers()){
					PlayerStaticInfo staticInfo = WorldServerCache.getPlayerStaticInfoByUserId(uid);
					if(staticInfo != null){
						List<String> sessionIds = sessionIdsMap.get(staticInfo.getGameServerId());
						if(sessionIds == null){
							sessionIds = new ArrayList<String>();
							sessionIdsMap.put(staticInfo.getGameServerId(), sessionIds);
						}
						sessionIds.add(staticInfo.getSessionId());
					}
				}
				if(!sessionIdsMap.isEmpty()){
					for(Map.Entry<String, List<String>> entry : sessionIdsMap.entrySet()){
						GameServerAction action = RPCKernel.getRemoteByServerId(entry.getKey(), GameServerAction.class);
						action.sendMessage(entry.getValue(), head, chatMessage);
					}
				}
			}
		}
	}

	@Override
	public Queue<ChatMessageVO> gainChatMessages() {
		return messages;
	}

	@Override
	public void banChat(int userId, int banTime) {
		PlayerStaticInfo staticInfo = WorldServerCache.getPlayerStaticInfoByUserId(userId);
		if(staticInfo != null){
			staticInfo.setBanChatTime(banTime);
		}
	}

}
