package com.ks.logic.test.service;

import org.junit.Test;

import com.ks.logic.service.ArenaService;
import com.ks.logic.service.MallService;
import com.ks.logic.service.ServiceFactory;
import com.ks.logic.test.BaseTestCase;

public class ArenaServiceTestCase extends BaseTestCase {
	
	private static final ArenaService service = ServiceFactory.getService(ArenaService.class);
	@Test
	public void testPlayArena(){
		service.refRival(272, false);
	}
	@Test
	public void testAward(){
//		new ArenaActionImpl().arenaAward();
		
		ServiceFactory.getService(MallService.class).refreshBlackMarket(762);
	}
}
