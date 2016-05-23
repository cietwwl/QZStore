package com.ks.protocol;

import java.util.Date;

import org.apache.log4j.Logger;

import com.ks.app.Application;
import com.ks.constant.SystemConstant;
import com.ks.exceptions.GameException;
import com.ks.game.model.Player;
import com.ks.handler.GameHandler;
import com.ks.logger.LoggerFactory;
import com.ks.manager.PlayerManager;
import com.ks.protocol.codec.message.obj.MessageObject;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.ErrorCodeCMD;
import com.ks.protocol.sub.FightCMD;
import com.ks.protocol.sub.UserCMD;
import com.ks.protocol.vo.Head;

/**
 * 解包
 * 
 * @author ks
 * 
 */
public final class Subpackage {

	private static final Logger logger = LoggerFactory.get(Subpackage.class);
	/***/
	private GameHandler gameHandler;
	/** 数据区最大长度 */
	private static final short MAX_DATA_LENGTH = 1024;

	public Subpackage(GameHandler gameHandler) {
		super();
		this.gameHandler = gameHandler;
	}

	public void process(MessageObject obj){
		try {
				Head head = (Head) obj.getHead();
				checkHead(head);
				loggerInfo(head);
				startHandler();
				try {
					processBefor(head);
					Application.messageProcess.process(gameHandler, head,
							obj.getBuffers());
				} finally {
					endHandler();
				}
		} catch (Exception e) {
			Exception ex = e;
			while (ex.getCause() != null) {
				ex = (Exception) ex.getCause();
			}
			if (ex instanceof GameException) {
				GameException gameException = (GameException) ex;
				Head head = MessageFactory.getMessage(Head.class);
				head.init(MainCMD.ERROR_CODE, ErrorCodeCMD.GAME_ERROR);
				Application.sendMessage(gameHandler.getChannel(), head,
						gameException.getCode(), gameException.getMessage());
				logger.warn("game exception code : " + gameException.getCode()
						+ ",message : " + gameException.getMessage());
				return;
			} else {
				Head head = MessageFactory.getMessage(Head.class);
				head.init(MainCMD.ERROR_CODE, ErrorCodeCMD.APP_ERROR);
				Application.sendMessage(gameHandler.getChannel(), head,
						ex.getMessage()+"");
				logger.error("",ex);
			}
		}
	}

	private void endHandler() {
		if(gameHandler.getPlayer()!=null){
			gameHandler.getPlayer().unlock();
		}
	}

	private void startHandler() {
		if(gameHandler.getPlayer()!=null){
			gameHandler.getPlayer().lock();
			gameHandler.getPlayer().setLastMessageTime(new Date());
		}
	}

	private void loggerInfo(Head head) {
		logger.info(new StringBuilder()
				.append("【exec cmd : ")
				.append(head.getMainCmd()).append("-")
				.append(head.getSubCmd()).append("】").append('[')
				.append(gameHandler.getPlayer())
				.append('@')
				.append(gameHandler.getChannel().getRemoteAddress())
				.append("] "));
	}

	/**
	 * 消息处理之前
	 * 
	 * @param head
	 *            包头
	 */
	private void processBefor(Head head) {
		gameHandler.setHead(head);
		Player player = gameHandler.getPlayer();
		if (player != null) {
			short s = 1;
			s += player.getCheckVal();
			player.setCheckVal(s);
		}
	}

	/**
	 * 检查包头
	 * 
	 * @param head
	 *            包头
	 * @return 是否合法
	 */
	private void checkHead(Head head) {
		if (head.getLength() > MAX_DATA_LENGTH) {
			throw new GameException(GameException.CODE_协议异常, "");
		}
		if (Application.SERVER_TYPE == Application.GAME_SERVER) {
			Player player = PlayerManager.getOnlinePlayer(head.getSessionId());
			if (player == null) {
				throw new GameException(GameException.CODE_已经掉线, "");
			}
			if(head.getMainCmd()!=MainCMD.USER && head.getSubCmd() != UserCMD.USER_HEART){
				if(player.getAgainstUserId()!=0){
					if(player.getAgainstTime().getTime()+30*1000L > System.currentTimeMillis()){
						if(player.getAgainstType() == SystemConstant.FIGHT_AGAINST_TYPE_发起者){//发起者只能请求取消战斗
							if(head.getMainCmd()!=MainCMD.FIGHT && head.getSubCmd() != FightCMD.CANCEL_FIGHT){
								throw new GameException(GameException.CODE_正在请求战斗, "");
							}
						}else if(player.getAgainstType() == SystemConstant.FIGHT_AGAINST_TYPE_接受者){//接收者可以请求取消和同意战斗
							if((head.getMainCmd()!=MainCMD.FIGHT && head.getSubCmd() != FightCMD.CANCEL_FIGHT)||
									(head.getMainCmd()!=MainCMD.FIGHT &&head.getSubCmd() != FightCMD.AGREED_FIGHT)){
								throw new GameException(GameException.CODE_正在请求战斗, "");
							}
						}
					}
				}
			}
			player.setGameHandler(gameHandler);
			gameHandler.setPlayer(player);
		}
	}
}
