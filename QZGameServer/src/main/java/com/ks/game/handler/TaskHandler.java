package com.ks.game.handler;

import com.ks.app.Application;
import com.ks.game.model.Player;
import com.ks.handler.GameHandler;
import com.ks.manager.ClientLockManager;
import com.ks.protocol.MainCmd;
import com.ks.protocol.SubCmd;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.TaskCMD;
import com.ks.protocol.vo.task.DailyTaskRewardVO;
import com.ks.protocol.vo.task.RenownTaskRewardVO;
import com.ks.protocol.vo.task.UserDailyTaskInfoVO;
import com.ks.protocol.vo.task.UserRenownTaskInfoVO;
import com.ks.util.LockKeyUtil;
/**
 * 任务handler
 * @author hanjie.l
 *
 */
@MainCmd(mainCmd=MainCMD.TASK)
public class TaskHandler extends ActionAdapter{

	/**
	 * 查看日常任务
	 * @param handler
	 */
	@SubCmd(subCmd=TaskCMD.GET_DAILY_TASK_INFO)
	public void getDailyTaskInfo(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			UserDailyTaskInfoVO dailyTaskInfo = taskAction().getDailyTaskInfo(player.getUserId());
			Application.sendMessage(handler.getChannel(), handler.getHead(), dailyTaskInfo);
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 查看名望任务
	 * @param handler
	 */
	@SubCmd(subCmd=TaskCMD.GET_RENOWN_TASK_INFO)
	public void getRenownTaskInfo(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			UserRenownTaskInfoVO renownTaskInfo = taskAction().getRenownTaskInfo(player.getUserId());
			Application.sendMessage(handler.getChannel(), handler.getHead(), renownTaskInfo);
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 领取日常任务奖励
	 * @param handler
	 */
	@SubCmd(subCmd=TaskCMD.REWARD_DAILY_TASK, args={"int"})
	public void receiveDailyTaskReward(GameHandler handler, int taskId){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			DailyTaskRewardVO receieveDailyTaskReward = taskAction().receieveDailyTaskReward(player.getUserId(), taskId);
			Application.sendMessage(handler.getChannel(), handler.getHead(), receieveDailyTaskReward);
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 领取名望任务奖励
	 * @param handler
	 */
	@SubCmd(subCmd=TaskCMD.REWARD_RENOWN_TASK, args={"int"})
	public void receiveRenownTaskReward(GameHandler handler, int taskId){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			RenownTaskRewardVO receieveRenownTaskReward = taskAction().receieveRenownTaskReward(player.getUserId(), taskId);
			Application.sendMessage(handler.getChannel(), handler.getHead(), receieveRenownTaskReward);
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 领取日常活跃度宝箱奖励
	 * @param handler
	 */
	@SubCmd(subCmd=TaskCMD.REWARD_TASK_BOX, args={"int"})
	public void receiveDailyBoxReward(GameHandler handler, int active){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			DailyTaskRewardVO receieveDailyBoxReward = taskAction().receieveDailyBoxReward(player.getUserId(), active);
			Application.sendMessage(handler.getChannel(), handler.getHead(), receieveDailyBoxReward);
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
}
