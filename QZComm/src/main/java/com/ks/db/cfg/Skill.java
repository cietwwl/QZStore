package com.ks.db.cfg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.constant.SystemConstant;
import com.ks.model.fight.FightModel;
import com.ks.model.fight.Point;
import com.ks.model.fight.ai.BaseAI;
import com.ks.model.skill.AbstractSkill;
/**
 * 技能
 * @author ks
 */
@DBBeanSet(tablename="t_skill", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class Skill extends AbstractSkill implements Serializable {
	private static final long serialVersionUID = 1L;
	/**技能编号*/
	@DBFieldSet(dbfname="skill_id")
	private int skillId;
	/**等级*/
	@DBFieldSet(dbfname="lv")
	private int lv;
	/**名称*/
	@DBFieldSet(dbfname="name")
	private String name;
	/**是否延迟释放*/
	@DBFieldSet(dbfname="delay")
	private boolean delay;
	/**cd*/
	@DBFieldSet(dbfname="cd")
	private int cd;
	/**技能效果*/
	private List<SkillEffect> effects;
	
	/**
	 * 获得技能升级概率
	 * @param skillLevel 技能等级
	 * @return 升级概率
	 */
	public static final double getLevelUpRate(int skillLevel){
		return SystemConstant.SKILL_LEVEL_UP_RATE[skillLevel-1];
	}
	
	/**
	 * 获得受影响的模型
	 * @param attackers 攻击方
	 * @param defenders 防守方
	 * @param releaseModel 释放者
	 * @param effect 释放的技能
	 * @param attack 
	 * @return 获得影响的模型
	 */
	public static List<FightModel> gainImpactModel(List<FightModel> attackers,
			List<FightModel> defenders, FightModel releaseModel, SkillEffect effect, boolean attack,FightModel tarFm) {
		List<FightModel> fms = new ArrayList<FightModel>();
		List<FightModel> useFm = null;
		if((effect.getTarget() & SystemConstant.SKILL_TARGET_自身)!=0){
			fms.add(releaseModel);
		}
		if((effect.getTarget() & SystemConstant.SKILL_TARGET_队友)!=0){
			for(FightModel fm : attackers){
				if(fm.getState() != SystemConstant.FIGHT_MODEL_STATE_死亡 && fm.getFightId() != releaseModel.getFightId()){
					fms.add(fm);
				}
			}
		}
		if((effect.getTarget()&SystemConstant.SKILL_TARGET_敌方群体)!=0){
			if(defenders!=null){
				for(FightModel fm : defenders){
					if(fm.getState() != SystemConstant.FIGHT_MODEL_STATE_死亡){
						fms.add(fm);
					}
				}	
			}	
		}else if(((effect.getTarget()&SystemConstant.SKILL_TARGET_敌方目标)!=0)){
			if(tarFm!=null){
				fms.add(tarFm);
			}
		}
		if((effect.getTarget()&SystemConstant.SKILL_TARGET_火)!=0){
			addEleFIghtModel(fms, useFm, SystemConstant.FIGHT_ELE_FIRE);
		}
		if((effect.getTarget()&SystemConstant.SKILL_TARGET_木)!=0){
			addEleFIghtModel(fms, useFm, SystemConstant.FIGHT_ELE_WOOD);
		}
		if((effect.getTarget()&SystemConstant.SKILL_TARGET_水)!=0){
			addEleFIghtModel(fms, useFm, SystemConstant.FIGHT_ELE_WATER);
		}
		if((effect.getTarget()&SystemConstant.SKILL_TARGET_光)!=0){
			addEleFIghtModel(fms, useFm, SystemConstant.FIGHT_ELE_LIGHT);
		}
		if((effect.getTarget()&SystemConstant.SKILL_TARGET_暗)!=0){
			addEleFIghtModel(fms, useFm, SystemConstant.FIGHT_ELE_DARK);
		}
		if(useFm == null){
			useFm = fms;
		}
		if((effect.getTarget()&SystemConstant.SKILL_TARGET_是否受范围影响)!=0){
			useFm = findModels(useFm, effect, releaseModel.getGridCoors(), attack);
		}
		
		if(effect.getRandom()!=0&&useFm.size()>effect.getRandom()){
			List<FightModel> fs = new ArrayList<FightModel>();
			for(int i=0;i<effect.getRandom();i++){
				fs.add(useFm.remove((int)(Math.random()*useFm.size())));
			}
			useFm = fs;
		}
		
		return useFm;
	}

	private static void addEleFIghtModel(List<FightModel> fms,
			List<FightModel> useFm, int ele) {
		if(useFm == null){
			useFm = new ArrayList<FightModel>();
		}
		for(FightModel fm : fms){
			if(fm.getEle()==ele){
				useFm.add(fm);
			}
		}
	}
	/**
	 * 查找受影响的攻击模型
	 * @param models 攻击模型
	 * @param effect 技能 
	 * @param fms 受影响的集合
	 * @param attack 
	 * @param point 中点
	 */
	private static List<FightModel> findModels(List<FightModel> models,
			SkillEffect effect,
			List<Point> gridCoors, boolean attack) {
		List<FightModel> fms = new ArrayList<FightModel>();
		String skillRange = effect.getRange();
		if(!attack){
			skillRange = Hero.getDetAtkModel(effect.getRange());
		}
		for(int i=0;i<8;i++){
			List<Point> ps = BaseAI.gainDirPoint(gridCoors, i);
			for(Point point : ps){
				
				int num = Integer.parseInt(String.valueOf(skillRange.charAt(i)));
				List<Point> points = new ArrayList<Point>();
				for(int x=0;x<num;x++){
					Point p = null;
					int index = x+1;
					switch (i) {
					case SystemConstant.FIGHT_ATK_MODE_DIR_左上:
						p = new Point(point.getX()-index, point.getY()-index);
						break;
//					case UserConstant.FIGHT_ATK_MODE_DIR_上:
//						p = new Point(point.getX(), point.getY()-index);
//						break;
					case SystemConstant.FIGHT_ATK_MODE_DIR_右上:
						p = new Point(point.getX()+index, point.getY()-index);
						break;
					case SystemConstant.FIGHT_ATK_MODE_DIR_右:
						p = new Point(point.getX()+index*2, point.getY());
						break;
					case SystemConstant.FIGHT_ATK_MODE_DIR_右下:
						p = new Point(point.getX()+index, point.getY()+index);
						break;
//					case UserConstant.FIGHT_ATK_MODE_DIR_下:
//						p = new Point(point.getX(), point.getY()+index);
//						break;
					case SystemConstant.FIGHT_ATK_MODE_DIR_左下:
						p = new Point(point.getX()-index, point.getY()+index);
						break;
					case SystemConstant.FIGHT_ATK_MODE_DIR_左:
						p = new Point(point.getX()-index*2, point.getY());
						break;
					default:
						break;
					}
					points.add(p);
				}
				
				for(FightModel fm : models){
					if(fm.getState() == SystemConstant.FIGHT_MODEL_STATE_正常){
						for(Point p : fm.getGridCoors()){
							if(points.indexOf(p)!=-1){
								fms.add(fm);
							}
						}
					}
				}
			}
		}
		return fms;
	}
	
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isDelay() {
		return delay;
	}
	public void setDelay(boolean delay) {
		this.delay = delay;
	}
	public int getCd() {
		return cd;
	}
	public void setCd(int cd) {
		this.cd = cd;
	}
	public List<SkillEffect> getEffects() {
		return effects;
	}
	public void setEffects(List<SkillEffect> effects) {
		this.effects = effects;
	}
}
