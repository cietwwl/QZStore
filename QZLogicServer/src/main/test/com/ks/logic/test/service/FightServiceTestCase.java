package com.ks.logic.test.service;

import java.util.ArrayList;

import org.junit.Test;

import com.ks.db.model.Goods;
import com.ks.db.model.Mail;
import com.ks.logic.service.FightService;
import com.ks.logic.service.ServiceFactory;
import com.ks.logic.test.BaseTestCase;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.fight.MoveVO;
import com.ks.protocol.vo.fight.PointVO;

public class FightServiceTestCase extends BaseTestCase {
	
	private static final FightService service = ServiceFactory.getService(FightService.class);
	@Test
	public void testMove(){
		MoveVO vo = MessageFactory.getMessage(MoveVO.class);
		vo.setFightId(0);
		vo.setPoint(MessageFactory.getMessage(PointVO.class));
		vo.getPoint().setX(8);
		vo.getPoint().setY(3);
		service.move(319, vo);
	}
	@Test
	public void testGainFight(){
		service.sweep(323, 71001003, 10);
	}
	@Test
	public void testIntoZone(){
		Mail mail = new Mail();
		mail.setType(1);
		mail.setContext("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
		mail.setTitle("一二三四五六七八九十一二三四五六");
		mail.setUserId(323);
		mail.setGoodsList(new ArrayList<Goods>());
		
		Goods g = new Goods();
		g.setType(1);
		g.setGoodsId(1001111);
		g.setLevel(1);
		g.setNum(1);
		
		mail.getGoodsList().add(g);
		
		g = new Goods();
		g.setType(2);
		g.setGoodsId(0);
		g.setLevel(0);
		g.setNum(5000);
		
		mail.getGoodsList().add(g);
		
//		ServiceFactory.getService(MailService.class).sendMail(mail);
//		ServiceFactory.getService(MailService.class).sendMail(mail);
//		ServiceFactory.getService(MailService.class).sendMail(mail);
	}
}
