package com.ks.logic.test;

import org.junit.Before;

import com.ks.app.Application;
import com.ks.logic.kernel.QZLogicServerKernel;
import com.ks.logic.service.ServiceFactory;

/**
 * 
 * @author ks
 * 
 */
public class BaseTestCase {
	@Before
	public void init() throws Exception {
		Application application = new Application();
		application.init("QZLogicApplication.xml", application);
		QZLogicServerKernel.initDataSource();
		// ServiceFactory.initService();
		QZLogicServerKernel.initGameCache();
	}

	protected <T> T getService(Class<T> clazz) {
		return ServiceFactory.getService(clazz);
	}
}
