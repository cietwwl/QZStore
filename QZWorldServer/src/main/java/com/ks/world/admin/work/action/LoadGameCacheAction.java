package com.ks.world.admin.work.action;

import java.util.List;
import java.util.Map;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;

import com.ks.action.logic.AdminAction;
import com.ks.exceptions.GameException;
import com.ks.protocol.web.HttpResult;
import com.ks.rpc.RPCKernel;
import com.ks.rpc.ServerInfo;
import com.ks.world.admin.AdminWorkAction;
import com.ks.world.kernel.WorldServerCache;

/**
 * 加载游戏配置缓存
 *
 */
public class LoadGameCacheAction extends AdminWorkAction {

	@Override
	public HttpResult done(ChannelHandlerContext ctx, MessageEvent e, Map<String, List<String>> parammaps, HttpResult result) {
		List<ServerInfo> infos = WorldServerCache.getLogicServerInfos();
		for(ServerInfo info : infos){
			AdminAction adminAction = RPCKernel.getRemoteByServerId(info.getServerId(), AdminAction.class);
			if(adminAction != null){
				result = adminAction.loadGameCache(result);
			}else{
				result.setCode(GameException.CODE_系统错误);
			}
			if(result.getCode() != GameException.CODE_正常){
				break;
			}
		}
		return result;
	}

}
