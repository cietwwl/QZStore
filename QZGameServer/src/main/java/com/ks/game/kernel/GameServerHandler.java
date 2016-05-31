package com.ks.game.kernel;

import java.nio.ByteOrder;

import org.jboss.netty.buffer.HeapChannelBufferFactory;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.MessageEvent;

import com.ks.action.world.WorldFightAction;
import com.ks.app.Application;
import com.ks.app.GameWorkExecutor;
import com.ks.game.handler.ActionAdapter;
import com.ks.game.model.Player;
import com.ks.handler.GameHandler;
import com.ks.manager.ClientLockManager;
import com.ks.manager.PlayerManager;
import com.ks.protocol.GameWorker;
import com.ks.protocol.Subpackage;
import com.ks.protocol.Subpackage.SubpackageExcutor;
import com.ks.protocol.codec.message.obj.MessageObject;
import com.ks.rpc.RPCKernel;
import com.ks.util.LockKeyUtil;

public class GameServerHandler extends GameHandler {
	
	@Override
	public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		if(this.player != null){
			WorldFightAction action = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, WorldFightAction.class);
			action.hostingFight(player.getUserId());
			if(player.getChatChannelId()!=0){
				PlayerManager.leaveChatChannel(player.getChatChannelId(), channel);
			}
		}
		super.channelClosed(ctx, e);
	}

	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		this.channel = e.getChannel();
		this.channel.getConfig().setBufferFactory(HeapChannelBufferFactory.getInstance(ByteOrder.LITTLE_ENDIAN));
		subpackage = new Subpackage(this);
		subpackage.setEndExcutor(new SubpackageEndExcutor());
		super.channelConnected(ctx, e);
	}

	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
		GameWorker worker = new GameWorker(subpackage, (MessageObject) e.getMessage());
		GameWorkExecutor.execute(worker);
		super.messageReceived(ctx, e);
	}
	
	private static class SubpackageEndExcutor extends SubpackageExcutor{
		public void done(GameHandler handler){
			Player player = handler.getPlayer();
			if(player != null){
				if(handler.getHead().getGuideId() > 0){
					ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
					try{
						ActionAdapter.playerAction().updateGuideStep(player.getUserId(), handler.getHead().getGuideId());
					}finally{
						ClientLockManager.unlockThreadLock();
					}
				}
			}
		}
	}
}
