package com.ks.world.action;

import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.locks.Lock;

import org.apache.log4j.Logger;

import com.ks.action.game.GameServerAction;
import com.ks.action.logic.AdminAction;
import com.ks.action.logic.PlayerAction;
import com.ks.action.world.WorldServerAction;
import com.ks.app.Application;
import com.ks.game.model.Player;
import com.ks.game.model.PlayerModel;
import com.ks.logger.LoggerFactory;
import com.ks.protocol.vo.Head;
import com.ks.rpc.RPCKernel;
import com.ks.rpc.ServerInfo;
import com.ks.rpc.client.ClientRPCHandler;
import com.ks.rpc.client.RPCClient;
import com.ks.world.kernel.PlayerStaticInfo;
import com.ks.world.kernel.WorldServerCache;
/**
 * 世界服务器处理,处理服务器间的一些初始化,连接问题
 * @author ks
 *
 */
public final class WorldServerActionImpl implements
		WorldServerAction {
	private static final Logger logger = LoggerFactory.get(WorldServerAction.class);
	@Override
	public void gameServerConnected(final String host,final  int port,final  String rpcHost,
			final int rpcPort,final String serverId) throws Exception {
		WorldServerCache.serverLock();
		try{
			logger.info("game server connected……");
			clearGameServerPlayers(serverId);
			ServerInfo serverInfo = new ServerInfo(host, port,serverId);
			WorldServerCache.addGameServerInfo(serverInfo);
			
			RPCClient client = new RPCClient(new InetSocketAddress(rpcHost,
					rpcPort), serverId, Application.GAME_SERVER);
			RPCKernel.addRPCClient(client);
			
			Map<String,Class<?>> map = Application.RPC_CLIENT_MAPPER.get(Application.GAME_SERVER);
			for(Map.Entry<String, Class<?>> e : map.entrySet()){
				RPCKernel.addServerIDRemote(serverId,
						e.getValue(), Proxy.newProxyInstance(e.getValue().
								getClassLoader(), new Class<?>[]{e.getValue()}, 
								new ClientRPCHandler(e.getKey(), RPCKernel.FLAG_ID, 
										0,serverId)));
			}
			RPCKernel.getRemoteByServerId(serverInfo.getServerId(),GameServerAction.class).
			addLogicServerRPC(WorldServerCache.getLogicServerInfos(),serverId);
		}finally{
			WorldServerCache.serverUnlock();
		}
	}

	private void clearGameServerPlayers(final String serverId) {
		logger.info("clear "+serverId + " players...");
		ServerInfo serverInfo = WorldServerCache.removeGameServerInfo(serverId);
		if(serverInfo!=null){
			List<PlayerStaticInfo> staticInfos = WorldServerCache.getServerPlayers(serverId);
			synchronized (serverInfo) {
				for(PlayerStaticInfo info : staticInfos){
					PlayerModel model = PlayerModel.create(info.getPartner(), info.getUsername());
					Lock lock = WorldServerCache.getPlayerLock(model);
					lock.lock();
					try{
						if(info.getUserId()!=0){
							Player player = new Player();
							player.setUserId(info.getUserId());
							player.setPartner(info.getPartner());
							player.setUsername(info.getUsername());
							player.setSessionId(info.getSessionId());
							WorldServerCache.removePlayerStaticInfo(info.getUserId(), info.getPartner(), info.getUsername());
							PlayerAction action = RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, PlayerAction.class);
							action.logout(player.getUserId());
						}
					}catch(Exception e){
						logger.error("", e);
						continue;
					}finally{
						lock.unlock();
					}
				}
				staticInfos.clear();
			}
		}
	}

	@Override
	public void logicServerConndeted(final String host, final int port,final String serverId) throws Exception {
		WorldServerCache.serverLock();
		try{
			logger.info("logic server connected……");
			final ServerInfo logicServerInfo = new ServerInfo(host, port,serverId);
			int oldSize = WorldServerCache.getLogicServerInfos().size();
			WorldServerCache.addLogicServerInfo(logicServerInfo);
			WorldServerCache.processGameServer(new com.ks.world.kernel.GameServerProcess() {
				@Override
				public void process(List<ServerInfo> serveInfos) throws Exception {
					for(ServerInfo serverInfo : serveInfos){
						try{
							RPCKernel.getRemoteByServerId(serverInfo.getServerId(), GameServerAction.class).addLogicServerRPC(logicServerInfo);
						}catch(Exception e){
							continue;
						}
					}
				}
			});
			
			RPCClient client = new RPCClient(new InetSocketAddress(host,
					port), logicServerInfo.getServerId(), Application.LOGIC_SERVER);
			RPCKernel.addRPCClient(client);
			Map<String,Class<?>> map = Application.RPC_CLIENT_MAPPER.get(Application.GAME_SERVER);
			for(Map.Entry<String, Class<?>> e : map.entrySet()){
				RPCKernel.addServerIDRemote( logicServerInfo.getServerId(),
						e.getValue(), Proxy.newProxyInstance(e.getValue().
								getClassLoader(), new Class<?>[]{e.getValue()}, 
								new ClientRPCHandler(e.getKey(), RPCKernel.FLAG_ID, 
										0,logicServerInfo.getServerId())));
			}
			Map<String,Class<?>> lMap = Application.RPC_CLIENT_MAPPER.get(Application.LOGIC_SERVER);
			if(lMap != null){
				for(Entry<String, Class<?>> entry : lMap.entrySet()){
					if(entry.getKey().equals("AdminAction")){
						RPCKernel.addServerIDRemote(serverId, entry.getValue(), 
								Proxy.newProxyInstance(entry.getValue().getClassLoader(), new Class<?>[]{entry.getValue()}, 
										new ClientRPCHandler(entry.getKey(), RPCKernel.FLAG_ID, 0, serverId)));
					}
				}
			}
			if(oldSize == 0){
				RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, AdminAction.class).initLogicCache();
			}
		}finally{
			WorldServerCache.serverUnlock();
		}
	}

	@Override
	public void sendMessage(int userId, Head head, Object... args) {
		PlayerStaticInfo info = WorldServerCache.getPlayerStaticInfoByUserId(userId);
		if(info!=null){
			GameServerAction action = RPCKernel.getRemoteByServerId(info.getGameServerId(), GameServerAction.class);
			action.sendMessage(info.getSessionId(), head, args);
		}
	}

	@Override
	public void sendMessage(List<Integer> userIds, Head head, Object... args) {
		Map<String,List<PlayerStaticInfo>> map = new HashMap<String, List<PlayerStaticInfo>>();
		for(int userId : userIds){
			PlayerStaticInfo info = WorldServerCache.getPlayerStaticInfoByUserId(userId);
			if(info!=null){
				List<PlayerStaticInfo> l = map.get(info.getGameServerId());
				if(l==null){
					l=new ArrayList<PlayerStaticInfo>();
					map.put(info.getGameServerId(), l);
				}
				l.add(info);
			}
		}
		
		for(String serverId : map.keySet()){
			List<PlayerStaticInfo> l = map.get(serverId);
			List<String> sessionIds = new ArrayList<String>();
			for(PlayerStaticInfo psi : l){
				sessionIds.add(psi.getSessionId());
			}
			GameServerAction action = RPCKernel.getRemoteByServerId(serverId, GameServerAction.class);
			action.sendMessage(sessionIds, head, args);
		}
	}

}