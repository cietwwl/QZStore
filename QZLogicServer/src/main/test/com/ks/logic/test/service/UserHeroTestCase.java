package com.ks.logic.test.service;

import org.junit.Test;

import com.ks.db.model.User;
import com.ks.logic.service.ServiceFactory;
import com.ks.logic.service.UserHeroService;
import com.ks.logic.service.UserService;
import com.ks.logic.test.BaseTestCase;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.login.RegisterVO;

public class UserHeroTestCase extends BaseTestCase {
	private static final UserHeroService service = ServiceFactory
			.getService(UserHeroService.class);

	@Test
	public void testStartExplore() {
		service.startExplore(71, 1, 2, 15);
	}

	@Test
	public void testRegister() {
		UserService us = ServiceFactory.getService(UserService.class);
		for (int i = 1; i <= 10; i++) {
			RegisterVO vo = MessageFactory.getMessage(RegisterVO.class);
			vo.setPlayerName("test" + i);
			vo.setUsername("test" + i);
			vo.setPartner(1);
			us.userRegister(vo);
		}
	}
	
	@Test
	public void testAddHeros() {
		UserService us = ServiceFactory.getService(UserService.class);
		int[] heroIds = new int[] { 
				90001,
				90002,
				90003,
				90004,
				90005,
				90006,
				90007,
				90008,
				90009,
				90010,
				90011,
				90012,
				90013,
				90014,
				90015,
				90016,
				90017,
				90018,
				90019,
				90020,
				90021,
				90022,
				90023,
				90024,
				90025,
				90026,
				90027,
				90028,
				90029,
				90030,
				90031,
				90032,
				90033,
				90034,
				90035,
				90036,
				90037,
				90038,
				90039,
				90040,
				82001,
				82002,
				82003,
				82004,
				82005,
				82006,
				82007,
				82008,
				82009,
				82010,
				82011,
				82012,
				82013,
				82014,
				82015,
				82016,
				82017,
				82018,
				82019,
				82020,
				82021,
				82022,
				82023,
				82024,
				82025,
				82026,
				82027,
				82028,
				82029,
				82030,
				82031,
				82032,
				82033,
				82034,
				82035,
				82036,
				82037,
				82038,
				82039,
				82040


		};
		
		int[] userIds = new int[]{40,41};
		for(int userId : userIds){
			us.gainUserInfo(userId);
			User user = us.getOnlineUser(userId);
			for (int heroId : heroIds) {
//				service.addUserHero(user, heroId, 1, 2, "");
			}
		}
	}
}
