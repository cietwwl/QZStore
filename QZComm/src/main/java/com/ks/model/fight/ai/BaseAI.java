package com.ks.model.fight.ai;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.ks.constant.SystemConstant;
import com.ks.model.fight.AttackModel;
import com.ks.model.fight.FightBuff;
import com.ks.model.fight.FightModel;
import com.ks.model.fight.Grid;
import com.ks.model.fight.Point;
import com.ks.protocol.vo.fight.MoveVO;
/**
 * 
 * @author ks
 */
public abstract class BaseAI implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**攻击方*/
	protected List<FightModel> attackers;
	/**防守方*/
	protected List<FightModel> defenders;
	/**战场中的格子*/
	protected Map<Point,Grid> grids;
	
	public BaseAI(List<FightModel> attackers, List<FightModel> defenders,
			Map<Point, Grid> grids) {
		super();
		this.attackers = attackers;
		this.defenders = defenders;
		this.grids = grids;
	}
	public abstract MoveVO run();
	
	/**
	 * 获得路径
	 * @param p 要移动到的点
	 * @param path 路径
	 * @param fp 当前所在点
	 * @return 方向
	 */
	public static int gainPath(Point p, List<Point> path, Point fp) {
		int dir = -1;
		if(fp.getX()>p.getX()){
			if(fp.getY() == p.getY()){
				for(int i=2;i<=fp.getX()-p.getX();i+=2){
					Point pp = new Point(fp.getX()-i, fp.getY());
					path.add(pp);
					if(pp.equals(p)){
						dir = SystemConstant.FIGHT_ATK_MODE_DIR_左;
						break;
					}
				}
			}else if(fp.getY() > p.getY()){
				for(int i=1;i<=fp.getX()-p.getX();i++){
					Point pp = new Point(fp.getX()-i, fp.getY()-i);
					path.add(pp);
					if(pp.equals(p)){
						dir = SystemConstant.FIGHT_ATK_MODE_DIR_左上;
						break;
					}
				}
			}else{
				for(int i=1;i<=fp.getX()-p.getX();i++){
					Point pp = new Point(fp.getX()-i, fp.getY()+i);
					path.add(pp);
					if(pp.equals(p)){
						dir = SystemConstant.FIGHT_ATK_MODE_DIR_左下;
						break;
					}
				}
			}
		}else if(fp.getX()<p.getX()){
			if(fp.getY() == p.getY()){
				for(int i=2;i<=p.getX()-fp.getX();i+=2){
					Point pp = new Point(fp.getX()+i, fp.getY());
					path.add(pp);
					if(pp.equals(p)){
						dir = SystemConstant.FIGHT_ATK_MODE_DIR_右;
						break;
					}
				}
			}else if(fp.getY() < p.getY()){
				for(int i=1;i<=p.getX()-fp.getX();i++){
					Point pp = new Point(fp.getX()+i, fp.getY()+i);
					path.add(pp);
					if(pp.equals(p)){
						dir = SystemConstant.FIGHT_ATK_MODE_DIR_右下;
						break;
					}
				}
			}else{
				for(int i=1;i<=p.getX()-fp.getX();i++){
					Point pp = new Point(fp.getX()+i, fp.getY()-i);
					path.add(pp);
					if(pp.equals(p)){
						dir = SystemConstant.FIGHT_ATK_MODE_DIR_右上;
						break;
					}
				}
			}
		}else{
//			if(fp.getY()>p.getY()){
//				for(int i=1;i<=fp.getY()-p.getY();i++){
//					Point pp = new Point(fp.getX(), fp.getY()-i);
//					path.add(pp);
//					if(pp.equals(p)){
//						dir = UserConstant.FIGHT_ATK_MODE_DIR_上;
//						break;
//					}
//				}
//			}else{
//				for(int i=1;i<=p.getY()-fp.getY();i++){
//					Point pp = new Point(fp.getX(), fp.getY()+i);
//					path.add(pp);
//					if(pp.equals(p)){
//						dir = UserConstant.FIGHT_ATK_MODE_DIR_下;
//						break;
//					}
//				}
//			}
		}
		return dir;
	}
	
	/**
	 * 获得可攻击的点
	 * @param point 源点
	 * @param points 集合
	 * @param dir 方向
	 * @param num 攻击距离
	 */
	public static List<Point> getFightPointPoint(Point point, int dir,int num) {
		List<Point> ps = new ArrayList<Point>();
		for(int i=1;i<=num;i++){
			switch (dir) {
			case SystemConstant.FIGHT_ATK_MODE_DIR_左上:
				ps.add(new Point(point.getX()-i, point.getY()-i));
				break;
	//		case UserConstant.FIGHT_ATK_MODE_DIR_上:
	//			return new Point(point.getX(), point.getY()-1);
			case SystemConstant.FIGHT_ATK_MODE_DIR_右上:
				ps.add(new Point(point.getX()+i, point.getY()-i));
				break;
			case SystemConstant.FIGHT_ATK_MODE_DIR_右:
				ps.add(new Point(point.getX()+2*i, point.getY()));
				break;
			case SystemConstant.FIGHT_ATK_MODE_DIR_右下:
				ps.add(new Point(point.getX()+i, point.getY()+i));
				break;
	//		case UserConstant.FIGHT_ATK_MODE_DIR_下:
	//			return new Point(point.getX(), point.getY()+1);
			case SystemConstant.FIGHT_ATK_MODE_DIR_左下:
				ps.add(new Point(point.getX()-i, point.getY()+i));
				break;
			case SystemConstant.FIGHT_ATK_MODE_DIR_左:
				ps.add(new Point(point.getX()-2*i, point.getY()));
				break;
			default:
				break;
			}
		}
		return ps;
	}
	
	
	
	/**
	 * 获得被攻击者
	 * @param grids 格子
	 * @param attackers 攻击者集合
	 * @param defenders 被攻击者集合
	 * @param queue 队列
	 * @param gridCoors 攻击者所在格子
	 * @param atkMode 攻击者攻击模型
	 * @param atkFightId 攻击者战斗编号
	 */
	public static void gainAttackeders(Map<Point,Grid> grids,
			List<FightModel> attackers, List<FightModel> defenders,
			Queue<List<AttackModel>> queue, List<Point> gridCoors,
			FightModel atk) {
		List<AttackModel> ams = new ArrayList<AttackModel>();
		for(int i=0;i<8;i++){
			if(atk.getAttMode().charAt(i) != SystemConstant.FIGHT_MODE_不能移动){
				int num = Integer.parseInt(String.valueOf(atk.getAttMode().charAt(i)));
				List<Point> ps = gainDirPoint(gridCoors, i);
				for(Point point : ps){
						List<Point> ppps = BaseAI.getFightPointPoint(point, i,num);
						for(Point p : ppps){
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
												AttackModel am = new AttackModel();
												am.setAttackFightId(atk.getFightId());
												am.setDefendFightId(a.getFightId());
												ams.add(am);
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
		if(ams.size()!=0){
			queue.add(ams);
		}
	}
	/**
	 * 获得方向上面的点
	 * @param gridCoors 格子
	 * @param dir 方向
	 * @return 点
	 */
	public static List<Point> gainDirPoint(List<Point> gridCoors, int dir) {
		List<Point> ps;
		if(gridCoors.size()>1){
			ps = new ArrayList<Point>();
			switch (dir) {
			case SystemConstant.FIGHT_ATK_MODE_DIR_左上:
				ps.add(gridCoors.get(0));
				break;
//			case UserConstant.FIGHT_ATK_MODE_DIR_上:
//				ps.add(gridCoors.get(0));
//				ps.add(gridCoors.get(1));
//				break;
			case SystemConstant.FIGHT_ATK_MODE_DIR_右上:
				ps.add(gridCoors.get(1));
				break;
			case SystemConstant.FIGHT_ATK_MODE_DIR_右:
				ps.add(gridCoors.get(1));
				ps.add(gridCoors.get(3));
				break;
			case SystemConstant.FIGHT_ATK_MODE_DIR_右下:
				ps.add(gridCoors.get(3));
				break;
//			case UserConstant.FIGHT_ATK_MODE_DIR_下:
//				ps.add(gridCoors.get(2));
//				ps.add(gridCoors.get(3));
//				break;
			case SystemConstant.FIGHT_ATK_MODE_DIR_左下:
				ps.add(gridCoors.get(2));
				break;
			case SystemConstant.FIGHT_ATK_MODE_DIR_左:
				ps.add(gridCoors.get(1));
				ps.add(gridCoors.get(3));
				break;
			default:
				break;
			}
		}else{
			ps = gridCoors;
		}
		return ps;
	}
	/**
	 * 获得攻击模型
	 * @param fightId 战斗编号
	 * @param fms 模型集合
	 * @return 战斗模型
	 */
	public static FightModel getFightModel(int fightId,List<FightModel> fms){
		for(FightModel fm : fms){
			if(fightId == fm.getFightId()){
				return fm;
			}
		}
		return null;
	}
	
	/**
	 * 验证点是否可用
	 * @param atk 攻击者
	 * @param p 目标点
	 * @param path 路径
	 * @param dir 方向
	 * @param grids 格子
	 * @param attackers 攻击者集合
	 * @return 是否可用
	 */
	public static boolean checkPoint(FightModel atk, Point p,
			List<Point> path, int dir,Map<Point,Grid> grids,List<FightModel> attackers) {
		int num = Integer.parseInt(String.valueOf(atk.getMoveMode().charAt(dir)));
		
		if(path.size()>num){
			return false;
		}else{
			if(atk.getMoveMode().charAt(dir) == SystemConstant.FIGHT_MODE_不能移动){
				return false;
			}
		}
		Grid g = grids.get(p);
		if(g.getFightId()!=0){
			if(g.getFightId()!=atk.getFightId()){
				return false;
			}
		}
		for(Point o : path){
			Grid grid = grids.get(o);
			if(grid.getFightId()!=atk.getFightId()){
				if(grid.getFightId()!=0){
					boolean flag = false;
					for(FightModel fm :attackers){
						if(fm.getFightId()==grid.getFightId()){
							flag = true;
							break;
						}
					}
					if(FightBuff.hasBuff(atk, SystemConstant.SKILL_EFFECT_ID_飞行)){
						flag = true;
					}
					if(!flag){
						return flag;
					}
				}else if(grid.getGridItem() == SystemConstant.FIGHT_GRID_ITEM_障碍物){
					if(!FightBuff.hasBuff(atk, SystemConstant.SKILL_EFFECT_ID_飞行)){
						return false;
					}
				}
			}
		}
		
		if(atk.getGridCoors().size()>1){
			if(p.getX()+1>4){
				return false;
			}else if(p.getY()+1>4){
				return false;
			}
			for(int i=1;i<4;i++){
				Point point = null;
				switch (i) {
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
				Grid grid = grids.get(point);
				if(grid!=null){
					if(grid.getFightId()!=atk.getFightId()){
						if(grid.getFightId()!=0){
							return false;
						}
						if(grid.getGridItem() == SystemConstant.FIGHT_GRID_ITEM_障碍物){
							if(!FightBuff.hasBuff(atk, SystemConstant.SKILL_EFFECT_ID_飞行)){
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}
	
}
