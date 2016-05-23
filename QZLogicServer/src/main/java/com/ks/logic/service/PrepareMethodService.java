package com.ks.logic.service;

import com.ks.logic.service.impl.PrepareMethodServiceImpl.PrepareMethodInvoker;

/**
 * 任务准备需要的方法
 * @author hanjie.l
 *
 */
public interface PrepareMethodService {
	
	/**
	 * 获取方法执行器
	 * @param method
	 * @return
	 */
	public PrepareMethodInvoker getPrepareInvoker(String method);

}
