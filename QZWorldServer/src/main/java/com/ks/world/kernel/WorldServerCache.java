package com.ks.world.kernel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

import com.ks.action.logic.UserAction;
import com.ks.app.Application;
import com.ks.game.model.Player;
import com.ks.game.model.PlayerModel;
import com.ks.logger.LoggerFactory;
import com.ks.object.ChatMsg;
import com.ks.rpc.RPCKernel;
import com.ks.rpc.ServerInfo;
import com.ks.world.action.WorldFightActionImpl;
/**
 * 世界服务器缓存
 * @author ks
 *
 */
public final class WorldServerCache implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.get(WorldServerCache.class);
	
	private static List<ServerInfo> gameServerInfos = new ArrayList<ServerInfo>();
	private static final Lock serverInfoLock = new ReentrantLock();
	private static final Lock serverLock = new ReentrantLock();
	private static List<ServerInfo> logicServerInfos = new ArrayList<ServerInfo>();
	
	/**用户静态数据ID映射*/
	private static Map<Integer,PlayerStaticInfo> playerStaticInfoIdMap = new ConcurrentHashMap<>();
	/**用户静态数据用户名映射*/
	private static Map<PlayerModel,PlayerStaticInfo> playerStaticInfoNameMap = new ConcurrentHashMap<>();
	
	/**用户名锁映射*/
	private static final Map<PlayerModel , Lock> NAME_LOCK_MAP = new ConcurrentHashMap<>();
	/**名称锁*/
	private static final Lock NAME_LOCK = new ReentrantLock();
	/**聊天缓存*/
	private static final Map<Integer, List<ChatMsg>> charCache = new ConcurrentHashMap<>();
	
	public static void serverLock(){
		serverLock.lock();
	}
	public static void serverUnlock(){
		serverLock.unlock();
	}
	
	public static final Lock getPlayerLock(PlayerModel model){
		Lock lock = NAME_LOCK_MAP.get(model);
		if(lock==null){
			lock = newNameLock(model);
		}
		return lock;
	}
	
	private static final Lock newNameLock(PlayerModel model){
		NAME_LOCK.lock();
		try{
			Lock lock = NAME_LOCK_MAP.get(model);
			if(lock==null){
				lock = new ReentrantLock();
				NAME_LOCK_MAP.put(model, lock);
			}
			return lock;
		}finally{
			NAME_LOCK.unlock();
		}
	}
	/**
	 * 增加游戏服务器服务器
	 * @return
	 */
	public static void addGameServerInfo(ServerInfo serverInfo){
		serverInfoLock.lock();
		try{
			Iterator<ServerInfo> it = gameServerInfos.iterator();
			while(it.hasNext()){
				ServerInfo info = it.next();
				if(info.getServerId().equals(serverInfo.getServerId())
						&& info.getHost().equals(serverInfo.getHost())
						&& info.getPort() == serverInfo.getPort()){
					it.remove();
					break;
				}
			}
			gameServerInfos.add(serverInfo);
			Collections.sort(gameServerInfos,serverInfo);
		}finally{
			serverInfoLock.unlock();
		}
	}
	
	/**
	 * 添加逻辑服务器
	 */
	public static void addLogicServerInfo(ServerInfo serverInfo){
		synchronized (logicServerInfos) {
			Iterator<ServerInfo> it = logicServerInfos.iterator();
			while(it.hasNext()){
				ServerInfo info = it.next();
				if(info.getServerId().equals(serverInfo.getServerId())
						&& info.getHost().equals(serverInfo.getHost())
						&& info.getPort() == serverInfo.getPort()){
					it.remove();
					break;
				}
			}
			logicServerInfos.add(serverInfo);
		}
	}
	
	
	public static void incrementGameServerInfo(String serverId){
		serverInfoLock.lock();
		try{
			ServerInfo info = null;
			for(ServerInfo serverInfo : gameServerInfos){
				if(serverInfo.getServerId().equals(serverId)){
					info = serverInfo;
					info.setNum(info.getNum()+1);
					logger.info("游戏服务器："+info.getServerId()+"增加人数" + info.getNum());
					break;
				}
			}
			if(info!=null){
				Collections.sort(gameServerInfos,info);
			}
		}finally{
			serverInfoLock.unlock();
		}
	}
	
	/**
	 * 获得服务器中人数较少的服务器
	 * @return
	 */
	public static ServerInfo gainGameServerInfo(){
		serverInfoLock.lock();
		try{
			for(ServerInfo info : gameServerInfos){
				try{
					if(RPCKernel.getRPCClientById(info.getServerId()).canUse()){
						return info;
					}
				}catch(Exception e){
					continue;
				}
			}
			throw new RuntimeException("can't find can use game server");
		}finally{
			serverInfoLock.unlock();
		}
	}
	/**
	 * 减少游戏服务器人数
	 */
	public static void  decrementServerInfo(String serverId){
		serverInfoLock.lock();
		try{
			ServerInfo info = null;
			for(ServerInfo serverInfo : gameServerInfos){
				if(serverInfo.getServerId().equals(serverId)){
					info = serverInfo;
					serverInfo.setNum(serverInfo.getNum()-1);
					logger.info("游戏服务器："+serverId+"减少人数" + serverInfo.getNum());
					break;
				}
			}
			if(info!=null){
				Collections.sort(gameServerInfos,info);
			}
		}finally{
			serverInfoLock.unlock();
		}
	}
	
	/**
	 * 在线统计
	 */
	public static void onlineReport(int time){
		serverInfoLock.lock();
		try{
			for(ServerInfo serverInfo : gameServerInfos){
				UserAction action = RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, UserAction.class);
				if(action != null){
					action.onlineReport(serverInfo.getNum(), time);
				}
			}
		}finally{
			serverInfoLock.unlock();
		}
	}
	
	public static List<ServerInfo> getLogicServerInfos() {
		return logicServerInfos;
	}
	
	public static List<ServerInfo> getGameServerInfos(){
		return gameServerInfos;
	}
	
	public static final void processGameServer(GameServerProcess gameProcess) throws Exception{
		serverInfoLock.lock();
		try{
			gameProcess.process(gameServerInfos);
		}finally{
			serverInfoLock.unlock();
		}
	}
	/**
	 * 增加用户静态数据
	 * @param player 要增加的玩家
	 * @param gameServerId 玩家所在游戏服务器编号
	 */
	public static final void addPlayerStaticInfo(Player player,String gameServerId,String sessionId,String battleRoomId){
		PlayerStaticInfo playerInfo = new PlayerStaticInfo();
		playerInfo.setGameServerId(gameServerId);
		playerInfo.setUserId(player.getUserId());
		playerInfo.setUsername(player.getUsername());
		playerInfo.setPlayerName(player.getPlayerName());
		playerInfo.setPartner(player.getPartner());
		playerInfo.setSessionId(sessionId);
		playerInfo.setBattleRoomId(battleRoomId);
		playerStaticInfoIdMap.put(playerInfo.getUserId(), playerInfo);
		PlayerModel model = PlayerModel.create(player.getPartner(), player.getUsername());
		playerStaticInfoNameMap.put(model, playerInfo);
	}
	/**
	 * 删除玩家静态数据
	 * @param player 要删除的玩家
	 */
	public static final PlayerStaticInfo removePlayerStaticInfo(int userId, int partner, String username){
		new WorldFightActionImpl().hostingFight(userId);
		playerStaticInfoIdMap.remove(userId);
		PlayerModel model = PlayerModel.create(partner, username);
		return playerStaticInfoNameMap.remove(model);
	}
	/**
	 * 获得游戏服务器
	 * @param serverId 游戏服务器编号
	 * @return 游戏服务器信息
	 */
	public static final ServerInfo getGameServerInfo(String serverId){
		serverInfoLock.lock();
		try{
			ServerInfo info = null;
			for(ServerInfo si : gameServerInfos){
				if(si.getServerId().equals(serverId)){
					info = si;
					break;
				}
			}
			return info;
		}finally{
			serverInfoLock.unlock();
		}
	}
	/**
	 * 根据用户ID查找用户静态数据
	 * @param userId 用户编号
	 * @return 用户编号下的用户
	 */
	public static final PlayerStaticInfo getPlayerStaticInfoByUserId(int userId){
		return playerStaticInfoIdMap.get(userId);
	}
	
	/**
	 * 获取在线uids
	 */
	public static List<Integer> getOnlineUids(){
		List<Integer> list = new ArrayList<Integer>();
		list.addAll(playerStaticInfoIdMap.keySet());
		return list;
	}
	/**
	 * 根据用户名查找用户静态数据
	 * @param username 用户名
	 * @return 查找到的用户静态数据
	 */
	public static final PlayerStaticInfo getPlayerStaticInfoByUsername(PlayerModel model){
		return playerStaticInfoNameMap.get(model);
	}
	
	public static final ServerInfo removeLogicServerInfo(String serverId){
		serverInfoLock.lock();
		try{
			ServerInfo info = null;
			for(ServerInfo si : logicServerInfos){
				if(si.getServerId().equals(serverId)){
					info = si;
					break;
				}
			}
			if(info!=null){
				logicServerInfos.remove(info);
			}
			return info;
		}finally{
			serverInfoLock.unlock();
		}
	}
	
	/**
	 * 删除游戏服务器
	 * @param serverId 游戏服务器编号
	 * @return 游戏服务器信息
	 */
	public static final ServerInfo removeGameServerInfo(String serverId){
		serverInfoLock.lock();
		try{
			ServerInfo info = null;
			for(ServerInfo si : gameServerInfos){
				if(si.getServerId().equals(serverId)){
					info = si;
				}
			}
			if(info!=null){
				gameServerInfos.remove(info);
			}
			return info;
		}finally{
			serverInfoLock.unlock();
		}
	}
	
	/**
	 * 获得服务器中所有玩家
	 * @param serverId 服务器编号
	 * @return 这个服务器的所有玩家
	 */
	public static final List<PlayerStaticInfo> getServerPlayers(String serverId){
		List<PlayerStaticInfo> infos = new ArrayList<>();
		for(PlayerStaticInfo info : playerStaticInfoIdMap.values()){
			if(info.getGameServerId().equals(serverId)){
				infos.add(info);
			}
		}
		return infos;
	}
	
	public static List<ServerInfo> gainAllGameServer(){
		return gameServerInfos;
	}
	public static Lock getServerInfoLock(){
		return serverInfoLock;
	}

	public static void addChatMsg(ChatMsg msg){
		List<ChatMsg> msgs = charCache.get(msg.getType());
		if(msgs == null){
			msgs = new ArrayList<>();
			charCache.put(msg.getType(), msgs);
		}
		if(msgs.size() >= 100){
			msgs.remove(0);
		}
		msgs.add(msg);
	}
	public static List<ChatMsg> getChatMsgs(int type, int time){
		List<ChatMsg> list = new ArrayList<>();
		List<ChatMsg> msgs = charCache.get(type);
		if(msgs != null){
			for(ChatMsg msg : msgs){
				if(msg.getSenderTime() > time){
					list.add(msg);
				}
			}
		}
		return list;
	}
}
