package com.ks.model.fight;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import lombok.Data;

import com.ks.constant.SystemConstant;
import com.ks.db.cfg.EternalEffect;
import com.ks.db.cfg.EternalSkill;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.fight.ModeRotationVO;
/**
 * 战斗模型
 * @author ks
 */
@Data
public class FightModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**战斗编号*/
	private int fightId;
	/**是否为NPC*/
	private boolean npc;
	/**对应编号*/
	private int assId;
	/**队伍位置*/
	private int teamPos;
	/**状态*/
	private int state;
	/**属性*/
	private int ele;
	/**能力*/
	private int ability;
	/**属性等级*/
	private int eleLv;
	/**攻击力*/
	private int atk;
	/**攻击次数*/
	private int atkCount;
	/**攻击模式*/
	private Queue<FightAtkMode> atkMode;
	/**生命*/
	private int hp;
	/**最大生命*/
	private int maxHp;
	/**基础血量*/
	private int baseHp;
	/**暴击率*/
	private double  critRate;
	/**暴击伤害*/
	private double  crithurt;
	/**躲避率*/
	private double dodgeRate;
	/**所在格子*/
	private List<Point> gridCoors;
	/**战斗buff*/
	private List<FightBuff> buffs;
	/**是否准备好释放技能*/
	private boolean readySkill;
	/**格挡率*/
	private int blockRate;
	/**格挡伤害*/
	private double blockHit ;
	/**弹射*/
	private byte catapult; 
	/**武魂效果*/
	private List<EternalEffect> eternalEffects = new ArrayList<EternalEffect>();
	/**战斗被动技能*/
	private List<FightSkill> passiveSkills=new ArrayList<>();
	/**武魂属性效果*/
	private List<EternalSkill> propertySkills =new ArrayList<EternalSkill>();
	/**装备提升的攻击力*/ 
	private int equipmentAddAtk;
	/**未造成伤害回合*/
	private int notHurtRound=-1;
	/**星级*/
	private int quality;
	/**技能数量*/
	private int skillNum;
	/**是否攻击方*/
	private boolean atkSign;
	/**
	 * 下一回合攻击模式(攻击点才需要调用)
	 * @param shortUserId
	 */
	public ModeRotationVO nextAtkRound(int shotUserId){
		FightAtkMode fam = getAtkMode().peek();
		ModeRotationVO r = null;
		if(fam.getCd()!=0){
			if(fam.getCd() <= fam.getRound()){//攻击模式轮换
				fam.setRound(0);
				getAtkMode().poll();
				getAtkMode().offer(fam);
				
				fam =  getAtkMode().peek();
				if(fam.getSkill() != null){
					fam.getSkill().setCurrRound(1000);
				}
				r = MessageFactory.getMessage(ModeRotationVO.class);
				r.setFightId(getFightId());
				r.setModeId(fam.getId());
			}
		}
		setNotHurtRound(getNotHurtRound()+1);
		return r;
	}
	/**
	 * 下一回合
	 * @param shotUserId
	 */
	public void nextRound(int shotUserId){

		FightAtkMode fam = getAtkMode().peek();
		fam.setRound(fam.getRound()+1);
		if(fam.getSkill() != null) {
			fam.getSkill().nextRound(shotUserId);
		}
		for(FightSkill fs : this.getPassiveSkills()){
			fs.nextRound(shotUserId);
		}
		Iterator<FightBuff> it = getBuffs().iterator();
		while(it.hasNext()){
			FightBuff fb = it.next();
			if(fb.getRound() != 0){
				fb.nextRound(shotUserId);
				if(fb.getRound() == 0){
					execMaxHpBuffRem(fb);
					it.remove();
				}
			}
		}
	}
	/**
	 * 处理增加血量上限buff消失
	 * @param fm
	 * @param fb
	 */
	public void execMaxHpBuffRem(FightBuff fb) {
		if(fb.getEffectId() == SystemConstant.SKILL_EFFECT_ID_生命变更){
			this.setMaxHp(this.getMaxHp()-(int) (this.getBaseHp()*fb.getScore()/SystemConstant.PERCENT_BASE_DOUBLE));
			this.setMaxHp(this.getMaxHp()-fb.getCons());
			this.setHp(this.getHp()-(int) (this.getBaseHp()*fb.getScore()/SystemConstant.PERCENT_BASE_DOUBLE)-fb.getCons());
			if(this.getHp()<1){
				this.setHp(1);
			}
		}
	}
	/**
	 * 获得攻击方向
	 */
	public String getAttMode(){
		StringBuilder bud = new StringBuilder(atkMode.peek().getAtkMode());
		for(FightBuff buff : buffs){
			if(buff.getEffectId() == SystemConstant.SKILL_EFFECT_ID_攻击范围提升){
				if((buff.getCons() &  0b10000000)!=0){
					if(atkSign){
						addAtkModel(bud, SystemConstant.FIGHT_ATK_MODE_DIR_左上);
					}else{
						addAtkModel(bud, SystemConstant.FIGHT_ATK_MODE_DIR_右上);
					}
				}
				if((buff.getCons() & 0b100000)!=0){
					if(atkSign){
						addAtkModel(bud, SystemConstant.FIGHT_ATK_MODE_DIR_右上);
					}else{
						addAtkModel(bud, SystemConstant.FIGHT_ATK_MODE_DIR_左上);
					}
				}
				if((buff.getCons() & 0b10000)!=0){
					if(atkSign){
						addAtkModel(bud, SystemConstant.FIGHT_ATK_MODE_DIR_右);
					}else{
						addAtkModel(bud, SystemConstant.FIGHT_ATK_MODE_DIR_左);
					}
				}
				if((buff.getCons() & 0b1000)!=0){
					if(atkSign){
						addAtkModel(bud, SystemConstant.FIGHT_ATK_MODE_DIR_右下);
					}else{
						addAtkModel(bud, SystemConstant.FIGHT_ATK_MODE_DIR_左下);
					}
				}
				if((buff.getCons() & 0b10)!=0){
					if(atkSign){
						addAtkModel(bud, SystemConstant.FIGHT_ATK_MODE_DIR_左下);
					}else{
						addAtkModel(bud, SystemConstant.FIGHT_ATK_MODE_DIR_右下);
					}
				}
				if((buff.getCons() & 0b1)!=0){
					if(atkSign){
						addAtkModel(bud, SystemConstant.FIGHT_ATK_MODE_DIR_左);
					}else{
						addAtkModel(bud, SystemConstant.FIGHT_ATK_MODE_DIR_右);
					}
				}
			}
		}
		return bud.toString();
	}
	private void addAtkModel(StringBuilder bud,int index) {
		if(bud.charAt(index) == SystemConstant.FIGHT_MODE_不能移动){
			bud.setCharAt(index, SystemConstant.FIGHT_MODE_移动一格);
		}
	}
	
	public String getMoveMode(){
		StringBuilder bud = new StringBuilder(atkMode.peek().getMoveMode());
		for(FightBuff buff : buffs){
			if(buff.getEffectId() == SystemConstant.SKILL_EFFECT_ID_移动力提升){
				for(int i=0;i<8;i++){
					int c = Integer.parseInt(bud.charAt(i)+"");
					if(c+buff.getCons()<10){
						int x = c+buff.getCons();
						if(x<0){
							x=0;
						}
						bud.setCharAt(i,String.valueOf(x).charAt(0));
					}else{
						bud.setCharAt(i, '9');
					}
				}
			}
		}
		return bud.toString();
	}
	
	/**
	 * 查找某类型的buff
	 * @param type
	 * @return
	 */
	public FightBuff getFightBuff(int type, int effectId){
		for(FightBuff buff : buffs){
			if(buff.getType() == type && buff.getEffectId() == effectId){
				return buff;
			}
		}
		return null;
	}
	
	/**
	 * 获得实际攻击力
	 * @param fm
	 * @return 攻击力
	 */
	public int getRealAtk(){
		int addCons=0;//增加攻击力实数
		int addScore=0;//增加攻击力分数
		for(FightBuff fb : this.getBuffs()){
			switch (fb.getEffectId()) {
			case SystemConstant.SKILL_EFFECT_ID_攻击变更:
			case SystemConstant.SKILL_EFFECT_ID_GRID_ITEM_双倍:
				addCons+=fb.getCons();
				addScore+=fb.getScore();
				break;
			default:
				break;
			}
		}
//		System.err.println("攻击:" + (atk+addCons) + "+" + (addScore/100) + "%");
		int ratk = (int) ((atk+addCons)+(atk+addCons)*addScore/SystemConstant.PERCENT_BASE_DOUBLE);
		ratk=ratk>0?ratk:1;//最小攻击力1点
		return ratk;
	}
	
	/**
	 * 获得实际最大血量
	 * @return
	 */
	public int getRealMaxHp(){
		int addCons=0;//增加攻击力实数
		int addScore=0;//增加攻击力分数
		for(FightBuff fb : this.getBuffs()){
			switch (fb.getEffectId()) {
			case SystemConstant.SKILL_EFFECT_ID_血量上限:
			case SystemConstant.SKILL_EFFECT_ID_生命变更:
				addCons+=fb.getCons();
				addScore+=fb.getScore();
				break;
			default:
				break;
			}
		}
//		System.err.println("生命:" + (baseHp+addCons) + "+" + (addScore/100) + "%");
		int rmaxHp = (int) ((baseHp+addCons)+(baseHp+addCons)*addScore/SystemConstant.PERCENT_BASE_DOUBLE);
		return rmaxHp;
	}
	
	/**
	 * 得到实际暴击率
	 * @return
	 */
	public double getRealCritRate(){
		double rcritRate = this.getCritRate();
		for(FightBuff buff : this.getBuffs()){
			if(buff.getEffectId() == SystemConstant.SKILL_EFFECT_ID_暴击率变更||buff.getEffectId() == SystemConstant.SKILL_EFFECT_ID_GRID_ITEM_暴击){
				rcritRate+=(buff.getScore()/SystemConstant.PERCENT_BASE_DOUBLE);
			}
		}
		for (EternalSkill es:getPropertySkills()) {
			if(es.getEternalSkillId() == SystemConstant.ETERNAL_PROPERTY_EFFECT_PROPERTY_暴击率){
				rcritRate+=es.getSkillValue();
			}
		}
//		System.err.println("暴击率:" + rcritRate);
		return rcritRate;
	}
	
	/**
	 * 获得实际暴击伤害
	 * @param at
	 * @return
	 */
	public double getRealCrithurt() {
		double rcrithurt = this.getCrithurt();
		for(FightBuff buff : this.getBuffs()){
			if(buff.getEffectId() == SystemConstant.SKILL_EFFECT_ID_暴击伤害变更){
				rcrithurt+=buff.getScore()/SystemConstant.PERCENT_BASE_DOUBLE;
			}
		}
		for (EternalSkill es:this.getPropertySkills()) {
			if(es.getEternalSkillId() == SystemConstant.ETERNAL_PROPERTY_EFFECT_PROPERTY_暴击伤害){
				rcrithurt+=es.getSkillValue();
			}
		}
//		System.err.println("暴击伤害:" + rcrithurt);
		return rcrithurt;
	}
	
	/**
	 * 获得实际躲闪率
	 * @param def 防守方
	 * @return 躲闪率
	 */
	public double getRealDodgeRate() {
		double rdodgeRate = this.getDodgeRate();
		for(FightBuff buff : this.getBuffs()){
			if(buff.getEffectId() == SystemConstant.SKILL_EFFECT_ID_闪避率变更||buff.getEffectId() == SystemConstant.SKILL_EFFECT_ID_GRID_ITEM_敏捷){
				rdodgeRate+=(buff.getScore()/SystemConstant.PERCENT_BASE_DOUBLE);
			}
		}
		for (EternalSkill es:this.getPropertySkills()) {
			if(es.getEternalSkillId() == SystemConstant.ETERNAL_PROPERTY_EFFECT_PROPERTY_闪避率){
				rdodgeRate+=es.getSkillValue();
			}
		}
//		System.err.println("躲闪率:" + rdodgeRate);
		return rdodgeRate;
	}
	
	/**
	 * 获得格挡概率
	 * @param def 
	 * @return 格挡概率
	 */
	public double getRealBlockRate() {
		double rblockRate = this.getBlockRate()/SystemConstant.PERCENT_BASE_DOUBLE;
		for(FightBuff buff : this.getBuffs()){
			if(buff.getEffectId() == SystemConstant.SKILL_EFFECT_ID_格挡效果变更){
				rblockRate+=(buff.getScore()/SystemConstant.PERCENT_BASE_DOUBLE);
			}
		}
		for (EternalSkill es:this.getPropertySkills()) {
			if(es.getEternalSkillId() == SystemConstant.ETERNAL_PROPERTY_EFFECT_PROPERTY_格挡率){
				rblockRate+=es.getSkillValue();
			}
		}
//		System.err.println("格挡概率:" + rblockRate);
		return rblockRate;
	}
	
	/**
	 * 获得格挡伤害
	 * @param at
	 * @return
	 */
	public double getRealBlockhurt() {
		double rblockhit = this.getBlockHit();
		for(FightBuff buff : this.getBuffs()){
			if(buff.getEffectId() == SystemConstant.SKILL_EFFECT_ID_格挡效果变更){
				rblockhit+=buff.getScore()/SystemConstant.PERCENT_BASE_DOUBLE;
			}
		}
		for (EternalSkill es:this.getPropertySkills()) {
			if(es.getEternalSkillId() == SystemConstant.ETERNAL_PROPERTY_EFFECT_PROPERTY_格挡效果){
				rblockhit+=es.getSkillValue();
			}
		}
//		System.err.println("格挡伤害:" + rblockhit);
		return 1-rblockhit<0.1?0.1:1-rblockhit;
	}
	
	/**
	 * 得到实际连击次数
	 * @return
	 */
	public int getRealAtkCount(){
		int ratkCount = this.getAtkCount();
		for(FightBuff buff : this.getBuffs()){
			if(buff.getEffectId() == SystemConstant.SKILL_EFFECT_ID_攻击次数变更){
				ratkCount+=buff.getCons();
			}
		}
//		System.err.println("连击次数:" + atkCount + "+" + (ratkCount - atkCount));
		return ratkCount;
	}
}
