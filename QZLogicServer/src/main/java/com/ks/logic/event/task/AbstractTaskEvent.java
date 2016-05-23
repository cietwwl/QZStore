package com.ks.logic.event.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ks.action.world.WorldServerAction;
import com.ks.app.Application;
import com.ks.db.model.User;
import com.ks.event.GameEvent;
import com.ks.logger.LoggerFactory;
import com.ks.logic.service.ServiceFactory;
import com.ks.logic.service.TaskService;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.TaskCMD;
import com.ks.protocol.vo.Head;
import com.ks.protocol.vo.task.UserTaskInfoVO;
import com.ks.rpc.RPCKernel;
/**
 * 任务事件抽象类
 * @author hanjie.l
 *
 */
public abstract class AbstractTaskEvent extends GameEvent{
	
	private static final Logger LOGGER = LoggerFactory.get(AbstractTaskEvent.class);
	
	/**
	 * 玩家
	 */
	protected User user;
	
	/**
	 * 事件上下文(用于保存事件传递的参数)
	 */
	protected Map<String, Object> eventContext = new HashMap<String, Object>();
	
	/**
	 * 必须传递user
	 * @param user
	 */
	public AbstractTaskEvent(User user) {
		this.sync = true;
		this.user = user;
	}
	
	/**
	 * 获取玩家对象
	 * @return
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 获取上下文
	 * @return
	 */
	public Map<String, Object> getContext() {
		return eventContext;
	}
	
	/**
	 * 获取事件名
	 * @return
	 */
	public abstract String getEventName();
	
	/**
	 * 改事件是否可能产生新的任务<br>
	 * 例如:人物升级事件，声望等级变化事件，vip等级提升事件，有可能会带来新的任务
	 * @return
	 */
	public abstract boolean mayBringNewTask();

	@Override
	public void runEvent() throws Exception {
		
		try {
			TaskService service = ServiceFactory.getService(TaskService.class);
			List<UserTaskInfoVO> userTaskInfoVOList = service.handlerEvent(this);
			
			//向客户端推送
			if(userTaskInfoVOList != null && !userTaskInfoVOList.isEmpty()){
				Head head = MessageFactory.getMessage(Head.class);
				head.init(MainCMD.TASK, TaskCMD.REFRESH_TASK);
				WorldServerAction action = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, WorldServerAction.class);
				action.sendMessage(user.getUserId(), head, userTaskInfoVOList);
			}
		} catch (Exception e) {
			LOGGER.error("任务事件处理异常");
			throw e;
		}
	}

}
