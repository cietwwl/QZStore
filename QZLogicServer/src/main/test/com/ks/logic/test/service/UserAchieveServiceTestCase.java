package com.ks.logic.test.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.ks.constant.SystemConstant;
import com.ks.logic.test.BaseTestCase;
import com.ks.model.fight.FightAtkMode;
import com.ks.model.fight.FightBuff;
import com.ks.model.fight.FightModel;
import com.ks.model.fight.Grid;
import com.ks.model.fight.Point;
import com.ks.model.fight.ai.MonsterAI;

public class UserAchieveServiceTestCase extends BaseTestCase {
	
//	private static final UserAchieveService service = ServiceFactory.getService(UserAchieveService.class);
	
	@Test
	public void testAddAchieveNum(){
		Map<Point,Grid> map = new HashMap<Point, Grid>();
		for(int x=1;x<=8;x++){
			for(int y=1;y<=4;y++){
				int c = y%2==0?1:2;
				Point coor = new Point( (x-1)*2+c,y);
				Grid g = new Grid();
				g.setCoor(coor);
				map.put(coor, g);
			}
		}
		List<FightModel> attackers = new ArrayList<FightModel>();
		List<FightModel>  defenders = new ArrayList<FightModel>();
		
		FightModel fm = new FightModel();
		fm.setFightId(1);
		fm.setNpc(false);
		fm.setAssId(1);
		fm.setState(SystemConstant.FIGHT_MODEL_STATE_正常);
		fm.setAbility(0);
		fm.setAtk(100);
		fm.setAtkCount(100);
		fm.setHp(100);
		
		fm.setMaxHp(fm.getHp());
		
		fm.setCritRate(0.1);
		fm.setCrithurt(0.1);
		fm.setDodgeRate(0.1);
		fm.setEle(1);
		fm.setEleLv(1);
		fm.setAtkMode(new LinkedList<FightAtkMode>());
		
		fm.setGridCoors(new ArrayList<Point>());
		fm.setBuffs(new ArrayList<FightBuff>());
		
		FightAtkMode fam = new FightAtkMode();
		fam.setAtkMode("10010010");
		fam.setId(1);
		fm.getAtkMode().add(fam);
		
		fm.setGridCoors(new ArrayList<Point>());
		
		Point p = new Point(16,1);
		fm.getGridCoors().add(p);
		
		Grid g = map.get(p);
		g.setFightId(1);
		
		attackers.add(fm);
		
		
		fm = new FightModel();
		fm.setFightId(2);
		fm.setNpc(false);
		fm.setAssId(1);
		fm.setState(SystemConstant.FIGHT_MODEL_STATE_正常);
		fm.setAbility(0);
		fm.setAtk(100);
		fm.setAtkCount(100);
		fm.setHp(100);
		
		fm.setMaxHp(fm.getHp());
		
		fm.setCritRate(0.1);
		fm.setCrithurt(0.1);
		fm.setDodgeRate(0.1);
		fm.setEle(1);
		fm.setEleLv(1);
		fm.setAtkMode(new LinkedList<FightAtkMode>());
		
		fm.setGridCoors(new ArrayList<Point>());
		fm.setBuffs(new ArrayList<FightBuff>());
		
		fam = new FightAtkMode();
		fam.setAtkMode("10010010");
		fam.setId(1);
		fm.getAtkMode().add(fam);
		
		fm.setGridCoors(new ArrayList<Point>());
		
		p = new Point(1,4);
		fm.getGridCoors().add(p);
		
		g = map.get(p);
		g.setFightId(2);
		defenders.add(fm);
		
		long start = System.currentTimeMillis();
		for( int i =0 ; i < 100;i++){
			new MonsterAI(attackers, defenders, map).run();
		}
		System.out.println(System.currentTimeMillis()-start);
	}
}
