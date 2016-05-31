package com.cache;

import java.util.concurrent.LinkedBlockingQueue;

import com.game.action.EActionPool;
import com.game.action.GameMailAction;
import com.web.db.game.GameMailInfo;

/**
 * 待发送邮件缓存
 *
 */
public class GameMailCache {
	private static LinkedBlockingQueue<GameMailInfo> mailQueue = new LinkedBlockingQueue<GameMailInfo>();
	public static void init() throws Exception{
		new MailThead().start();
	}
	public static void addMail(GameMailInfo mail) throws Exception{
		mailQueue.put(mail);
	}
	public static class MailThead extends Thread{
		@Override
		public void run() {
			while(true){
				if(mailQueue.isEmpty()){
					try{
						sleep(100);
					}catch(Exception e){
						e.printStackTrace();
					}
				}else{
					GameMailInfo mail = null;
					try{
						mail = mailQueue.take();
						if(mail.isState(1)){
							EActionPool.addAction(new GameMailAction(mail));
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}
	}
}
