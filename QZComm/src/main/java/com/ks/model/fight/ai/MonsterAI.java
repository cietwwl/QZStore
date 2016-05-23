package com.ks.model.fight.ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.ks.constant.SystemConstant;
import com.ks.db.cfg.Hero;
import com.ks.model.fight.AttackModel;
import com.ks.model.fight.FightBuff;
import com.ks.model.fight.FightModel;
import com.ks.model.fight.Grid;
import com.ks.model.fight.Point;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.fight.MoveVO;
import com.ks.protocol.vo.fight.PointVO;

public class MonsterAI extends BaseAI {
	private static final long serialVersionUID = 1L;

	public MonsterAI(List<FightModel> attackers, List<FightModel> defenders,
			Map<Point, Grid> grids) {
		super(attackers, defenders, grids);
		List<FightModel> fms = new ArrayList<FightModel>();
		for(FightModel fm : attackers){
			fms.add(fm);
		}
		Collections.shuffle(fms);
		this.attackers = fms;
	}

	@Override
	public MoveVO run() {
		
		List<Point> ps = new ArrayList<Point>();//可行走的点
		for(Grid g : grids.values()){
			if(g.getFightId()==0){
				ps.add(g.getCoor());
			}else{
				for(FightModel atk : attackers){
					if(atk.getFightId() == g.getFightId()){
						if(!g.getCoor().equals(atk.getGridCoors().get(0))){
							ps.add(g.getCoor());
						}
					}
				}
			}
		}
		boolean target = false;//是否有人有目标
		List<FightModel> tfms = new ArrayList<FightModel>();
		List<FightModel> noTarget = new ArrayList<FightModel>();
		outer:
		for(FightModel atk : attackers){
			if(!FightBuff.canMove(atk)){
				continue;
			}
			if(thereGoals(atk, atk.getGridCoors())){//有目标
				tfms.add(atk);
				target = true;
				continue outer;
			}
			noTarget.add(atk);
			for(Point p : ps){//没有可攻击目标寻找攻击目标
				List<Point> path = new ArrayList<Point>();
				int dir = gainPath(p, path, atk.getGridCoors().get(0));
				if(dir!=-1){
					boolean flag = checkPoint(atk, p, path, dir,grids,attackers);
					if(!flag){
						continue;
					}
					
					List<Point> pp = new ArrayList<Point>();
					if(atk.getGridCoors().size()>1){
						for(int i=0;i<atk.getGridCoors().size();i++){
							Point o = new Point(p.getX(), p.getY());
							if(i==1){
								o.setX(o.getX()+1);
							}else if(i==2){
								o.setY(o.getY()+1);
							}else if(i==3){
								o.setY(o.getY()+1);
								o.setX(o.getX()+1);
							}
							pp.add(o);
						}
					}else{
						pp.add(p);
					}
					
					if(thereGoals(atk, pp)){//找到目标
						return createMoveVO(atk.getFightId(), p);
					}
				}
			}
		}
		if(target){//有人有目标
			MoveVO vo = atkMaxCount(ps, tfms);
			if(vo==null){
				vo = atkRestraint(ps, tfms);
				if(vo==null){
					vo = atkMinHp(ps, tfms);
				}
			}
			if(vo!=null){
				return vo;
			}
		}
		for(int i=2;i<20;i++){
			MoveVO vo = gainSortPath(ps,i,noTarget);
			if(vo!=null){
				return vo;
			}
		}
		return MessageFactory.getMessage(MoveVO.class);
	}

	private MoveVO gainSortPath(List<Point> ps,int forCount, List<FightModel> noTarget) {
		for(FightModel atk : noTarget){
			if(!FightBuff.canMove(atk)){
				continue;
			}
			
			List<Point> pps = getMovePoint(atk.getGridCoors().get(0), atk);
			
			for(Point rootPoint : pps){//没有可攻击目标寻找攻击目标
				List<Point> path = new ArrayList<Point>();
				int dir = gainPath(rootPoint, path, atk.getGridCoors().get(0));
				if(dir!=-1){
					if(!checkPoint(atk, rootPoint, path, dir,grids,attackers)){
						continue;
					}
					List<Point> closedPoints = new ArrayList<Point>();
					closedPoints.add(atk.getGridCoors().get(0));
					if(checkGainPoint(ps, rootPoint, atk, 2, forCount,closedPoints)){
						return createMoveVO(atk.getFightId(), rootPoint);
					}else{
						closedPoints.clear();
						closedPoints.add(atk.getGridCoors().get(0));
					}
				}
			}
		}
		return null;
	}
	private boolean checkGainPoint(List<Point> ps,Point currPath,FightModel atk,int currFor,int forCount, List<Point> closedPoints){
		
		List<Point> pps = getMovePoint(currPath, atk);
		
		for(Point point : pps){
			if(closedPoints.indexOf(point)!=-1){
				continue;
			}
			List<Point> path = new ArrayList<Point>();
			int dir = gainPath(point, path, currPath);
			if(dir!=-1){
				if(!checkPoint(atk, currPath, path, dir,grids,attackers)){
					continue;
				}
				closedPoints.add(point);
				if(currFor==forCount){
					List<Point> pp = new ArrayList<Point>();
					if(atk.getGridCoors().size()>1){
						for(int i=0;i<atk.getGridCoors().size();i++){
							Point o = new Point(point.getX(), point.getY());
							if(i==1){
								o.setX(o.getX()+1);
							}else if(i==2){
								o.setY(o.getY()+1);
							}else if(i==3){
								o.setY(o.getY()+1);
								o.setX(o.getX()+1);
							}
							pp.add(o);
						}
					}else{
						pp.add(point);
					}
					
					if(thereGoals(atk, pp)){//找到目标
						return true;
					}
				}else{
					if(checkGainPoint(ps, point, atk, currFor+1, forCount,closedPoints)){
						return true;
					}
				}
			}
		}
		return false;
	}

	private List<Point> getMovePoint(Point currPath, FightModel atk) {
		List<Point> pps = new ArrayList<Point>();
		
		for(int i=0;i<8;i++){
			
			char pos = atk.getMoveMode().charAt(i);
			if(pos != SystemConstant.FIGHT_MODE_不能移动){
				switch (i) {
				case SystemConstant.FIGHT_ATK_MODE_DIR_左上:
					if(pos == SystemConstant.FIGHT_MODE_移动一格){
						Point p = new Point(currPath.getX()-1, currPath.getY()-1);
						if(grids.get(p)!=null)
							pps.add(p);
					}else{
						for(int x=1;x<=4;x++){
							Point p = new Point(currPath.getX()-x, currPath.getY()-x);
							if(grids.get(p)!=null)
								pps.add(p);
						}
					}
					break;
				case SystemConstant.FIGHT_ATK_MODE_DIR_右上:
					if(pos == SystemConstant.FIGHT_MODE_移动一格){
						Point p = new Point(currPath.getX()+1, currPath.getY()-1);
						if(grids.get(p)!=null)
							pps.add(p);
					}else{
						for(int x=1;x<=4;x++){
							Point p = new Point(currPath.getX()+x, currPath.getY()-x);
							if(grids.get(p)!=null)
								pps.add(p);
						}
					}
					break;
				case SystemConstant.FIGHT_ATK_MODE_DIR_右:
					if(pos == SystemConstant.FIGHT_MODE_移动一格){
						Point p = new Point(currPath.getX()+2, currPath.getY());
						if(grids.get(p)!=null)
							pps.add(p);
					}else{
						for(int x=1;x<=8;x++){
							Point p = new Point(currPath.getX()+x*2, currPath.getY());
							if(grids.get(p)!=null)
								pps.add(p);
						}
					}
				
					break;
				case SystemConstant.FIGHT_ATK_MODE_DIR_右下:
					if(pos == SystemConstant.FIGHT_MODE_移动一格){
						Point p =  new Point(currPath.getX()+1, currPath.getY()+1);
						if(grids.get(p)!=null)
							pps.add(p);
					}else{
						for(int x=1;x<=4;x++){
							Point p = new Point(currPath.getX()+x, currPath.getY()+x);
							if(grids.get(p)!=null)
								pps.add(p);
						}
					}
					break;
				case SystemConstant.FIGHT_ATK_MODE_DIR_左下:
					if(pos == SystemConstant.FIGHT_MODE_移动一格){
						Point p =  new Point(currPath.getX()-1, currPath.getY()+1);
						if(grids.get(p)!=null)
							pps.add(p);
					}else{
						for(int x=1;x<=4;x++){
							Point p = new Point(currPath.getX()-x, currPath.getY()+x);
							if(grids.get(p)!=null)
								pps.add(p);
						}
					}
					break;
				case SystemConstant.FIGHT_ATK_MODE_DIR_左:
					if(pos == SystemConstant.FIGHT_MODE_移动一格){
						Point p =  new Point(currPath.getX()-2, currPath.getY());
						if(grids.get(p)!=null)
							pps.add(p);
					}else{
						for(int x=1;x<=8;x++){
							Point p = new Point(currPath.getX()-x*2, currPath.getY());
							if(grids.get(p)!=null)
								pps.add(p);
						}
					}
					break;
				default:
					break;
				}
			}
		}
		return pps;
	}
	
	/**
	 * 攻击血量最少的
	 * @param ps 可走的点
	 * @param tfms 可攻击到目标的单位
	 * @return 移动的点
	 */
	private MoveVO atkMinHp(List<Point> ps, List<FightModel> tfms) {
		for(FightModel atk : tfms){
			Queue<List<AttackModel>> queue = new LinkedList<>();
			if(FightBuff.canFight(atk)){
				BaseAI.gainAttackeders(grids, attackers,
						defenders, queue, atk.getGridCoors(),
						atk);
			}
			int minHp = 0;
			List<AttackModel> atkModel = queue.peek();
			if(atkModel!=null){
				for(AttackModel a : atkModel){
					FightModel def = getFightModel(a.getDefendFightId(), defenders);
					if(minHp == 0){
						minHp = def.getHp();
					}
					minHp = def.getHp()<minHp?def.getHp():minHp;
				}
			}
			
			for(Point p : ps){
				List<Point> path = new ArrayList<Point>();
				int dir = gainPath(p, path, atk.getGridCoors().get(0));
				if(dir!=-1){
					boolean flag = checkPoint(atk, p, path, dir,grids,attackers);
					if(flag){//点可用
						List<Point> coorPoint = new ArrayList<Point>();
						for(int i=0;i<atk.getGridCoors().size();i++){
							Point point = null;
							switch (i) {
							case 0:
								point = new Point(p.getX(), p.getY());
								break;
							case 1:
								point = new Point(p.getX()+1, p.getY());
								break;
							case 2:
								point = new Point(p.getX(), p.getY()+1);
								break;
							case 3:
								point = new Point(p.getX()+1, p.getY()+1);
								break;
							default:
								break;
							}
							coorPoint.add(point);
						}
						
						Queue<List<AttackModel>> q = new LinkedList<>();
						BaseAI.gainAttackeders(grids, attackers,
								defenders, q, coorPoint,
								atk);
						
						List<AttackModel> atm = q.peek();
						if(atm!=null){
							for(AttackModel a : atm){
								FightModel def = getFightModel(a.getDefendFightId(), defenders);
								if(def.getHp()<minHp){
									return createMoveVO(atk.getFightId(), p);
								}
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * 攻击属性相克
	 * @param ps 可走的点
	 * @param tfms 可攻击到目标的单位
	 * @return 移动的点
	 */
	private MoveVO atkRestraint(List<Point> ps, List<FightModel> tfms) {
		for(FightModel atk : tfms){
			Queue<List<AttackModel>> queue = new LinkedList<>();
			if(FightBuff.canFight(atk)){
				BaseAI.gainAttackeders(grids, attackers,
						defenders, queue, atk.getGridCoors(),
						atk);
			}
			List<AttackModel> atkModel = queue.peek();
			if(atkModel!=null){
				if(restraint(atk, atkModel)){
					continue;
				}
			}
			
			for(Point p : ps){
				List<Point> path = new ArrayList<Point>();
				int dir = gainPath(p, path, atk.getGridCoors().get(0));
				if(dir!=-1){
					boolean flag = checkPoint(atk, p, path, dir,grids,attackers);
					if(flag){//点可用
						List<Point> coorPoint = new ArrayList<Point>();
						for(int i=0;i<atk.getGridCoors().size();i++){
							Point point = null;
							switch (i) {
							case 0:
								point = new Point(p.getX(), p.getY());
								break;
							case 1:
								point = new Point(p.getX()+1, p.getY());
								break;
							case 2:
								point = new Point(p.getX(), p.getY()+1);
								break;
							case 3:
								point = new Point(p.getX()+1, p.getY()+1);
								break;
							default:
								break;
							}
							coorPoint.add(point);
						}
						
						Queue<List<AttackModel>> q = new LinkedList<>();
						BaseAI.gainAttackeders(grids, attackers,
								defenders, q, coorPoint,
								atk);
						
						List<AttackModel> atm = q.peek();
						if(atm!=null){
							if(restraint(atk, atm)){
								return createMoveVO(atk.getFightId(), p);
							}
						}
					}
				}
			}
		}
		return null;
	}
	/**
	 * 是否克制
	 * @param atk 攻击者
	 * @param atkModel 被攻击模型
	 * @return 是否克制
	 */
	private boolean restraint(FightModel atk, List<AttackModel> atkModel) {
		for(AttackModel model : atkModel){
			FightModel def = getFightModel(model.getDefendFightId(), defenders);
			double restraint = Hero.getRestraint(atk.getEle(), atk.getEleLv(), def.getEle(), def.getEleLv());
			if(restraint>1){
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 攻击连击最多的目标
	 * @param ps 可走的点
	 * @param tfms 可攻击到目标的单位
	 * @return 移动的点
	 */
	private MoveVO atkMaxCount(List<Point> ps, List<FightModel> tfms) {
		Queue<List<AttackModel>> queue = new LinkedList<>();
		for(FightModel attack : tfms){
			if(FightBuff.canFight(attack)){
				BaseAI.gainAttackeders(grids, attackers,
						defenders, queue, attack.getGridCoors(),
						attack);
			}
		}
		int batter = 0;
		for(List<AttackModel> ams : queue){
			batter+=ams.size();
		}
		for(FightModel atk : tfms){
			for(Point p : ps){
				List<Point> path = new ArrayList<Point>();
				int dir = gainPath(p, path, atk.getGridCoors().get(0));
				if(dir!=-1){
					boolean flag = checkPoint(atk, p, path, dir,grids,attackers);
					if(flag){//点可用
						List<Point> coorPoint = new ArrayList<Point>();
						for(int i=0;i<atk.getGridCoors().size();i++){
							Point point = null;
							switch (i) {
							case 0:
								point = new Point(p.getX(), p.getY());
								break;
							case 1:
								point = new Point(p.getX()+1, p.getY());
								break;
							case 2:
								point = new Point(p.getX(), p.getY()+1);
								break;
							case 3:
								point = new Point(p.getX()+1, p.getY()+1);
								break;
							default:
								break;
							}
							coorPoint.add(point);
						}
						
						Queue<List<AttackModel>> q = new LinkedList<>();
						for(FightModel attack : attackers){
							if(FightBuff.canFight(attack)){
								if(attack.getFightId() == atk.getFightId()){
									BaseAI.gainAttackeders(grids, attackers,
											defenders, q, coorPoint,
											attack);
								}else{
									BaseAI.gainAttackeders(grids, attackers,
											defenders, q, attack.getGridCoors(),
											attack);
								}
							}
						}
						
						int count = 0;
						for(List<AttackModel> ams : q){
							count+=ams.size();
						}
						if(count > batter){
							return createMoveVO(atk.getFightId(), p);
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * 创建移动vo
	 * @param fightId 攻击者编号
	 * @param p 目标点
	 * @return 移动vo
	 */
	private MoveVO createMoveVO(int fightId, Point p) {
		MoveVO m = MessageFactory.getMessage(MoveVO.class);
		m.setFightId(fightId);
		PointVO pvo = MessageFactory.getMessage(PointVO.class);
		m.setPoint(pvo);
		pvo.init(p);
		return m;
	}
	/**
	 * 是否有目标
	 * @param atkModel 攻击者攻击模型
	 * @param gridCoors 攻击者所在格子
	 * @return 是否有目标
	 */
	private boolean thereGoals(FightModel atk,List<Point> gridCoors){
		for(int i=0;i<8;i++){
			if(atk.getAttMode().charAt(i) != SystemConstant.FIGHT_MODE_不能移动){
				int num = Integer.parseInt(String.valueOf(atk.getAttMode().charAt(i)));
				List<Point> ps = gainDirPoint(gridCoors, i);
				for(Point point : ps){
					List<Point> pps = BaseAI.getFightPointPoint(point, i,num);
					for(Point p : pps){
						Grid g = grids.get(p);
						if(g!=null){
							if(g.getFightId()!=0){
								boolean flag = true;
								for(FightModel a : attackers){
									if(a.getFightId()==g.getFightId()){
										flag = false;
										break;
									}
								}
								if(flag){
									for(FightModel a : defenders){
										if(a.getFightId()==g.getFightId()){
											if(a.getState() != SystemConstant.FIGHT_MODEL_STATE_死亡){
												return true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
}
