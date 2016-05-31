package com.ks.world.admin.work.action;

import java.util.List;
import java.util.Map;
import java.util.Timer;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;

import com.ks.exceptions.GameException;
import com.ks.protocol.web.HttpResult;
import com.ks.world.admin.AdminWorkAction;
import com.ks.world.admin.HttpUtils;
import com.ks.world.task.AfficheTask;

/**
 * 发送公告
 *
 */
public class SendAfficheAction extends AdminWorkAction{
	private Timer timer = new Timer();
	private AfficheTask task;

	@Override
	public HttpResult done(ChannelHandlerContext ctx, MessageEvent e, Map<String, List<String>> parammaps, HttpResult result){
		int colorId = HttpUtils.getParamInt("colorId", parammaps);
		int interval = HttpUtils.getParamInt("interval", parammaps);//间隔秒数
		int cycleNum = HttpUtils.getParamInt("cycleNum", parammaps); //循环次数
		String contents = HttpUtils.getParam("contents", parammaps); //消息内容
		closeTask();
		if(cycleNum > 0 && interval > 0){
			task = new AfficheTask(cycleNum, colorId, contents);
			timer.scheduleAtFixedRate(task, 0, (long)interval * 1000);
		}
		result.setCode(GameException.CODE_正常);
		return result;
	}
	
	private void closeTask(){
		if(task != null){
			task.cancel();
		}
	}

}
