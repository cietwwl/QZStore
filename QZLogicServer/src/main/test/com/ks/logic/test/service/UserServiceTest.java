package com.ks.logic.test.service;

import org.junit.Test;

import com.ks.db.model.User;
import com.ks.logic.service.MallService;
import com.ks.logic.service.ServiceFactory;
import com.ks.logic.service.UserEquipmentService;
import com.ks.logic.service.UserService;
import com.ks.logic.test.BaseTestCase;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.login.RegisterVO;

public class UserServiceTest extends BaseTestCase {
	private static UserService service;

	UserService getService() {
		if (service == null) {
			service = ServiceFactory.getService(UserService.class);
		}
		return service;
	}

	@Test
	public void testRegister() throws InterruptedException {
		RegisterVO register = MessageFactory.getMessage(RegisterVO.class);
		for (int i = 0; i < 3000; i++) {
			register.setUsername("test" + i);
			register.setPartner(1);
			register.setPlayerName("test" + i);
			getService().userRegister(register);
		}
	}

	@Test
	public void testGainUserInfo() {
		getService().gainUserInfo(291);
	}
	
	@Test
	public void testAddGold(){
		User user = getService().getOnlineUser(25);
//		getService().incrementSlate(user, 100000, 1, "");
	}
	
	@Test
	public void testLogout() {
//		getService().logout(41);
		ServiceFactory.getService(MallService.class).createBlackMarketGoods();
	}
	@Test
	public void cc(){
		UserEquipmentService ser = ServiceFactory.getService(UserEquipmentService.class);
		int userId = 41;
		getService().gainUserInfo(userId);
		User user = getService().getOnlineUser(userId);
		
		int[] eqs = new int[]{3010015,3010016,3010017,3020011,3020012,3020013};
		for(int i=0;i<5;i++){
//			for(int eq : eqs)
//				ser.addEquipment(user, eq, 1, 1, "");
		}
		
//		UserEternalService es = ServiceFactory.getService(UserEternalService.class);
//		int[] ess = new int[]{5010001,5010002,5010003,5010004,5010005,5010006};
//		for(int i=0;i<5;i++){
//			for(int eq : ess)
//					es.addEternal(user, eq, 1, "");
//		}
//		
//		getService().incrementHeroExpPool(user, 30000, 1, "");
//		
//		UserEternalService userEternalService = ServiceFactory.getService(UserEternalService.class);
//		
//		EternalSmelting esss = userEternalService.gainEternalSmelting(user.getUserId()).get(0);
//		esss.setVal(30000);
//		new UserPropDAO().updateEternalSmelting(esss);
		
		
		
//		UserHeroService ue = ServiceFactory.getService(UserHeroService.class);
//		ue.addUserHero(user,90001, 1, 1,"");
//		ue.addUserHero(user,90002, 1,1, "");
//		ue.addUserHero(user,90003, 1,1, "");
//		ue.addUserHero(user,90004, 1,1, "");
//		ue.addUserHero(user,90005, 1,1, "");
//		ue.addUserHero(user,90006, 1,1, "");
//		ue.addUserHero(user,90007, 1,1, "");
//		ue.addUserHero(user,90008, 1,1, "");
//		ue.addUserHero(user,90009, 1,1, "");
	}
}