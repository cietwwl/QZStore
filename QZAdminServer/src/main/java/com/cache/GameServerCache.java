package com.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.game.service.GameServerService;
import com.web.db.game.GameServerInfo;

/**
 * 游戏服务器缓存
 *
 */
public class GameServerCache{
	private static List<GameServerInfo> servers;
	private static Map<String, GameServerInfo> serverCache;
	
	public static void load(){
		try{
			servers = GameServerService.getGameServers();
			serverCache = new HashMap<String, GameServerInfo>();
			for(GameServerInfo info : servers){
				serverCache.put(info.getServerId(), info);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static GameServerInfo getGameServerInfo(String serverId){
		return serverCache.get(serverId);
	}
	
	public static GameServerInfo getGameServerInfo(int id){
		for(GameServerInfo info : serverCache.values()){
			if(info.getId() == id){
				return info;
			}
		}
		return null;
	}
	
	public static String getServerName(String serverId){
		GameServerInfo info = getGameServerInfo(serverId);
		if(info == null){
			return serverId;
		}
		return info.getServerName();
	}
	
	public static List<GameServerInfo> getGameServers(){
		return servers;
	}
	
	public static void initDefaultServer(HttpSession session){
		GameServerInfo target = null;
		for(int i = 0; i < servers.size(); i++){
			GameServerInfo server = servers.get(i);
			if(i == 0 || server.isDefaultSelect()){
				target = server;
			}
		}
		session.setAttribute("selserver", target);
	}
	
}
