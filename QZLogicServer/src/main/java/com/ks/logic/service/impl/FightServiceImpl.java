package com.ks.logic.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.UUID;

import com.ks.access.SQLOpt;
import com.ks.action.world.WorldFightAction;
import com.ks.app.Application;
import com.ks.constant.SystemConstant;
import com.ks.db.cfg.ActivityZone;
import com.ks.db.cfg.BattleRound;
import com.ks.db.cfg.Equipment;
import com.ks.db.cfg.Eternal;
import com.ks.db.cfg.EternalEffect;
import com.ks.db.cfg.EternalSkill;
import com.ks.db.cfg.FameBuff;
import com.ks.db.cfg.Hero;
import com.ks.db.cfg.Monster;
import com.ks.db.cfg.MonsterAtkMode;
import com.ks.db.cfg.PassiveSkill;
import com.ks.db.cfg.Skill;
import com.ks.db.cfg.SkillEffect;
import com.ks.db.cfg.Zone;
import com.ks.db.cfg.ZoneBattle;
import com.ks.db.log.ZoneBattleLogger;
import com.ks.db.model.AgainstRequst;
import com.ks.db.model.Arena;
import com.ks.db.model.ArenaLogger;
import com.ks.db.model.EquipmentSkill;
import com.ks.db.model.User;
import com.ks.db.model.UserBuff;
import com.ks.db.model.UserEquipment;
import com.ks.db.model.UserEternal;
import com.ks.db.model.UserHero;
import com.ks.db.model.UserProp;
import com.ks.db.model.UserStat;
import com.ks.db.model.UserTeam;
import com.ks.db.model.UserZone;
import com.ks.db.model.UserZoneBattle;
import com.ks.event.GameEvent;
import com.ks.exceptions.GameException;
import com.ks.logic.cache.GameCache;
import com.ks.logic.event.ComputeFightingEvent;
import com.ks.logic.event.GameLoggerEvent;
import com.ks.logic.event.task.MartialWayFightEvent;
import com.ks.logic.event.task.PassBattleEvent;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.FightService;
import com.ks.model.fight.AttackModel;
import com.ks.model.fight.Battle;
import com.ks.model.fight.FightAtkMode;
import com.ks.model.fight.FightAttr;
import com.ks.model.fight.FightBuff;
import com.ks.model.fight.FightModel;
import com.ks.model.fight.FightSkill;
import com.ks.model.fight.Grid;
import com.ks.model.fight.Point;
import com.ks.model.fight.ai.BaseAI;
import com.ks.model.martial.BattleMap;
import com.ks.model.martial.MartialWay;
import com.ks.model.skill.AbstractSkill;
import com.ks.model.user.AssStat;
import com.ks.model.user.UserBaseinfo;
import com.ks.object.DropEffect;
import com.ks.object.ItemEffect;
import com.ks.object.ItemEffects;
import com.ks.object.Reward;
import com.ks.object.ValidObject;
import com.ks.protocol.Message;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.FightCMD;
import com.ks.protocol.vo.Head;
import com.ks.protocol.vo.arena.ArenaFightAwardVO;
import com.ks.protocol.vo.fight.AttackRoundVO;
import com.ks.protocol.vo.fight.AttackVO;
import com.ks.protocol.vo.fight.AttackedVO;
import com.ks.protocol.vo.fight.CatapultHurtVO;
import com.ks.protocol.vo.fight.CatapultVO;
import com.ks.protocol.vo.fight.DropVO;
import com.ks.protocol.vo.fight.FightModelVO;
import com.ks.protocol.vo.fight.FightResultVO;
import com.ks.protocol.vo.fight.FightVO;
import com.ks.protocol.vo.fight.ModeRotationVO;
import com.ks.protocol.vo.fight.MoveVO;
import com.ks.protocol.vo.fight.PointVO;
import com.ks.protocol.vo.fight.SubFightBattleVO;
import com.ks.protocol.vo.fight.SubHurtVO;
import com.ks.protocol.vo.fight.SweepAwardVO;
import com.ks.protocol.vo.fight.SweepVO;
import com.ks.protocol.vo.fight.prop.FightPropAffectVO;
import com.ks.protocol.vo.fight.prop.FightPropRefVO;
import com.ks.protocol.vo.fight.skill.AffectederVO;
import com.ks.protocol.vo.fight.skill.FightBuffAffectVO;
import com.ks.protocol.vo.fight.skill.FightBuffVO;
import com.ks.protocol.vo.fight.skill.ReleaseSkillVO;
import com.ks.protocol.vo.martial.MartialWayFightAwardVO;
import com.ks.rpc.RPCKernel;
import com.ks.table.ArenaTable;
import com.ks.table.UserStatTable;
import com.ks.table.UserTable;
import com.ks.timer.TimerController;
import com.ks.util.DateUtil;
import com.ks.util.MathUtil;

public class FightServiceImpl extends BaseService implements FightService {
	@Override
	public void computeFightingEvent(int userId){
		ComputeFightingEvent event = new ComputeFightingEvent(userId);
		TimerController.submitGameEvent(event);
	}
	@Override
	public void computeFighting(int userId){
		User user = userService.queryCacheUser(userId);
		if(user != null){
			UserTeam userTeam = userTeamService.queryUserTeam(userId);
			if(userTeam != null){
				Battle battle = createBattle(userTeam.getUserId(), 
						0,
						SystemConstant.FIGHT_TYPE_TEST,
						SystemConstant.FIGHT_AI_MONSTER_AI,
						SystemConstant.FIGHT_AI_MONSTER_AI,0,0,"",null);
				initHeros(battle, userTeam ,true, user);
				List<FightModel> attackers=battle.getAttackers();
				int fighting = MathUtil.getFighting(attackers);
				if(user.getFighting() != fighting){
					user.setFighting(fighting);
					Map<String, String> hash = new HashMap<String, String>();
					hash.put(UserTable.J_FIGHTING, String.valueOf(fighting));
					userService.updateUser(user, hash, false);
				}
			}
			if(user.getLevel() >= SystemConstant.ARENA_OPEN_LEVEL){
				userDAO.updateFighting(user.getFighting(), user.getUserId());
			}
		}
	}
	@Override
	public List<AttackRoundVO> move(int userId, MoveVO moveVO) {
		User user = userService.getOnlineUser(userId);
		Battle battle = fightDAO.getBattle(user.getFightId());
		if(battle == null){
			throw new GameException(GameException.CODE_战斗已结束, "not battle");
		}
		if(battle.isEnd()){
			return null;
		}
		List<AttackRoundVO> rounds = move(userId, battle, moveVO);
		
		if(battle.isOnlineFight()){
			return null;
		}else{
			fightDAO.updateBattle(battle);
			return rounds;
		}
	}
	private List<AttackRoundVO> move(int userId,final Battle battle,MoveVO moveVO){
		if(userId != battle.getShotUserId()){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		final List<AttackRoundVO> rounds = new ArrayList<AttackRoundVO>();
		AttackRoundVO round = move0(userId, battle, moveVO);
		
		round.setMove(moveVO);
		rounds.add(round);
		
		round = endFighting(battle,round);
		while(round!=null){
			rounds.add(round);
			round = endFighting(battle,round);
		}
		
		if(battle.isOnlineFight()){
			List<Integer> userIds = new ArrayList<Integer>();
			if(battle.getAttackUserId()!=0){
				userIds.add(battle.getAttackUserId());
			}
			if(battle.getDefenderUserId()!=0){
				userIds.add(battle.getDefenderUserId());
			}
			
			int leftCount = 0;
			for(FightModel fm : battle.getAttackers()){
				if(fm.getState()!= SystemConstant.FIGHT_MODEL_STATE_死亡){
					leftCount+=1;
				}
			}
			boolean left = false;
			if(leftCount == 0){
				left = true;
			}else {
				leftCount = 0;
				for(FightModel fm : battle.getDefenders()){
					if(fm.getState()!= SystemConstant.FIGHT_MODEL_STATE_死亡){
						leftCount+=1;
					}
				}
				if(leftCount == 0){
					left = true;
				}
			}
			if(!left?(battle.getMaxRound()!=0?battle.getMaxRound()<=battle.getRound():false):true){
			}else{
				fightDAO.updateBattle(battle);
			}
			final boolean f =left;
			GameEvent event = new GameEvent() {
				@Override
				public void runEvent() throws Exception {
					WorldFightAction action = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, WorldFightAction.class);
					
					Head head = MessageFactory.getMessage(Head.class);
					head.init(MainCMD.FIGHT, FightCMD.MOVE);
					
					action.onlineFightAction(battle.getBattleId(), battle.getShotUserId(), head, rounds, !f?(battle.getMaxRound()!=0?battle.getMaxRound()<=battle.getRound():false):true);
				}
			};
			
			TimerController.submitGameEvent(event);
			
			
		}
		
		return rounds;
	}
	private AttackRoundVO endFighting(Battle battle,AttackRoundVO round) {
		List<FightModel> attackers = null;//攻击方
		List<FightModel> defenders = null;//防守方
		if(battle.getShotUserId() == battle.getAttackUserId()){
			attackers = battle.getAttackers();
			defenders = battle.getDefenders();
		}else{
			defenders = battle.getAttackers();
			attackers = battle.getDefenders();
		}
		

		if(battle.isEnd()){//结束战斗
			finishFightRound(battle,round);
		}
		
		if(!battle.isEnd()){
			String fightAI = battle.getShotUserId()==battle.getAttackUserId()?battle.getAttackAI():battle.getDefendAI();
			if(fightAI!=null){
				
				for(FightModel atk : attackers){
					if(checkSkillRelease(atk)){
						AttackRoundVO r = AttackRoundVO.create();
						r.setNextShotUserId(battle.getShotUserId());
						
						FightAtkMode atkModel = atk.getAtkMode().peek();
						Skill skill = GameCache.getSkill(atkModel.getSkill().getSkillId(), atkModel.getSkill().getSkillLv());
						r.getRelSkill().add(releaseSkill(attackers, defenders, atk, atkModel.getSkill(), skill, battle,r,null));
						return r;
					}
				}
				
				BaseAI ai = Battle.createFightAI(fightAI,attackers, defenders,battle.getGrids());
				
				MoveVO moveVO = ai.run();
				AttackRoundVO r = move0(battle.getShotUserId(), battle, moveVO);
				r.setMove(moveVO);
				
				return r;
			}
		}
		return null;
	}
	/**
	 * 结束战场回合
	 * @param battle 战场
	 * @param round 上一回合
	 */
	private void finishFightRound(Battle battle, AttackRoundVO round) {
		
		int leftCount = 0;
		for(FightModel fm : battle.getAttackers()){
			if(fm.getState()!= SystemConstant.FIGHT_MODEL_STATE_死亡){
				leftCount+=1;
			}
		}
		boolean attWin = leftCount != 0;
		
		if(battle.getBattleType() == SystemConstant.FIGHT_TYPE_ZONE){
			zoneFightFinish(battle, round, attWin);
		}
		if(battle.getBattleType() == SystemConstant.FIGHT_TYPE_MARTIAL_WAY){
			martialWayFinish(battle,round,0);
		}
        if(battle.getBattleType() == SystemConstant.FIGHT_TYPE_PVP){
        	arenaPVPFinish(battle, round);
		}
	}
	/**
	 * PVP结束(竞技场)
	 */
	private void arenaPVPFinish(Battle battle, AttackRoundVO round){
		if(!battle.getBattleMessage().containsKey(battle.getAttackUserId())){
			boolean attWin;
			if(battle.getRound()>=battle.getMaxRound()){
				attWin=false;
			}else{
				int leftCount = 0;
				for(FightModel fm : battle.getAttackers()){
					if(fm.getState()!= SystemConstant.FIGHT_MODEL_STATE_死亡){
						leftCount+=1;
					}
				}
				attWin = leftCount != 0;
			}
			SQLOpt opt = new SQLOpt();
			int userId=battle.getAttackUserId();
			User user=userService.getOnlineUser(userId);
			UserStat stat = userService.getUserStat(userId);
			if(stat.getArenaCount() < 1){
				throw new GameException(GameException.CODE_挑战次数不足, "");
			}
			Arena arena = arenaDAO.queryMyArena(userId);
			ArenaLogger al=new ArenaLogger();
			if(attWin){
				opt.putFieldOpt(ArenaTable.WINCOUNT, SQLOpt.EQUAL);
				opt.putFieldOpt(ArenaTable.VALOUR, SQLOpt.EQUAL);
				arena.setWinCount(arena.getWinCount()+1);
				arenaDAO.updateTodayWins(arena.getWinCount(),userId);
				arena.setStreakWin(arena.getStreakWin()+1);
				arena.setValour(arena.getValour() + SystemConstant.ARENA_WIN_AWARD_VALOUR);
				if(arena.getStreakWin()>arena.getMaxWinStreak()){
					opt.putFieldOpt(ArenaTable.MAXWINSTREAK, SQLOpt.EQUAL);
					arena.setMaxWinStreak(arena.getStreakWin());
					arenaDAO.updateTodayMaxWins(arena.getMaxWinStreak(), userId);
				}
				int exp = GameCache.getArenaExpAward(user.getLevel());
				effectService.addIncome(user, SystemConstant.ITEM_EFFECT_TYPE_EXP, exp, null, false, SystemConstant.LOGGER_APPROACH_竞技场获得);
				al.setWinLos(1);
			}else{
				arena.setStreakWin(0);
				al.setWinLos(0);
			}
			UserBaseinfo info = userService.getUserBaseInfo(userId);
			info.setStreakWin(arena.getStreakWin());
			info.setTodayMaxWins(arena.getMaxWinStreak());
			info.setTodayWins(arena.getWinCount());
			userDAO.updateUserBaseinfo(info);
			opt.putFieldOpt(ArenaTable.STREAKWIN, SQLOpt.EQUAL);
			opt.putFieldOpt(ArenaTable.CDTIME, SQLOpt.EQUAL);
			arena.setCdTime(new Date(System.currentTimeMillis()+10*60*1000L));
			if(arena.getIsFirst()==0){
				opt.putFieldOpt(ArenaTable.ISFIRST, SQLOpt.EQUAL);
				arena.setIsFirst(1);
			}
			arenaDAO.updateArena(arena, opt);
			SQLOpt statOpt = new SQLOpt();
			statOpt.putFieldOpt(UserStatTable.ARENACOUNT, SQLOpt.EQUAL);
			stat.setArenaCount(stat.getArenaCount() - 1);
			userService.updateUserStat(stat, statOpt);
			UserBaseinfo defUser=null;
			int capId=0;
			if(battle.getDefenderUserId()>0){
				defUser=userService.getUserBaseInfo(battle.getDefenderUserId());
				capId=defUser.getHeroId();
			}else{
				defUser=new UserBaseinfo();
				defUser.setUserId(battle.getDefenderUserId());
				defUser.setLevel(15);
				defUser.setPlayerName("npc"+Math.abs(battle.getDefenderUserId()));
				switch (battle.getDefenderUserId()) {
				case -1:
					//				capId=1001005;  //TODO
					capId=82024;
					break;
				case -2:
					//				capId=1001054;
					capId=82024;
					break;
				case -3:
					//				capId=1001064;
					capId=82028;
					break;
				default:
					break;
				}
			}

			ArenaFightAwardVO vo = MessageFactory.getMessage(ArenaFightAwardVO.class);
			if(attWin){
				vo.setExp(GameCache.getArenaExpAward(user.getLevel()));
				vo.setValour(SystemConstant.ARENA_WIN_AWARD_VALOUR);
			}
			vo.setStreakWin(arena.getStreakWin());

			vo.setWin(attWin);

			battle.getBattleMessage().put(battle.getAttackUserId(), vo);

			al.setCapId(capId);
			al.setUserName(user.getPlayerName());
			al.setUserId(userId);
			al.setMatchLevel(defUser.getLevel());
			al.setMatchUserId(defUser.getUserId());
			al.setMatchUserName(defUser.getPlayerName());
			al.setType(SystemConstant.ARENA_LOGGER_TYPE_竞技场);
			arenaService.addArenaLogger(al);
		}
	}
	
	private void martialWayFinish(Battle battle, AttackRoundVO round,int giveUpUser) {
		boolean attWin;
		boolean defWin;
		if(giveUpUser!=0){
			attWin=battle.getAttackUserId()!=giveUpUser;
			defWin=battle.getDefenderUserId()!=giveUpUser;
			battle.setGiveUpFight(true);
		}else{
			if(battle.getRound()>=battle.getMaxRound()){
				attWin=false;
				defWin=false;
			}else{
				int leftCount = 0;
				for(FightModel fm : battle.getAttackers()){
					if(fm.getState()!= SystemConstant.FIGHT_MODEL_STATE_死亡){
						leftCount+=1;
					}
				}
				attWin = leftCount != 0;
				
				leftCount = 0;
				for(FightModel fm : battle.getDefenders()){
					if(fm.getState()!= SystemConstant.FIGHT_MODEL_STATE_死亡){
						leftCount+=1;
					}
				}
				
				defWin = leftCount != 0;
			}
		}
		MartialWay attWay = martialWayDAO.getMartialWay(battle.getAttackUserId());
		MartialWay defWay = martialWayDAO.getMartialWay(battle.getDefenderUserId());
		calScore(attWin, attWay, defWay,battle);
		calScore(defWin, defWay, attWay,battle);
		martialWayService.updateMartialWay(attWay);
		martialWayService.updateMartialWay(defWay);
		
		fightDAO.updateBattle(battle);
	}
	private void calScore(boolean attWin, MartialWay attWay, MartialWay defWay,Battle battle) {
		boolean firstWin = false;
		ArenaLogger al=new ArenaLogger();
		User user=userService.getUser(attWay.getUserId());
		int score = 0;
		int exp=0;
		if(attWin){
			attWay.setWinStreak((short) (attWay.getWinStreak()+1));
			attWay.setWinCount((short) (attWay.getWinCount()+1));
			score = SystemConstant.MARTIAL_WAY_WIN_SCORE;
					int i= getWinScore(attWay, defWay);
					int j = (attWay.getWinStreak()-1)*5>50?50:(attWay.getWinStreak()-1)*5;
					score+=i+j;	
			firstWin = DateUtil.isBeforeToDay(attWay.getLastWinTime());
			if(firstWin){
				score*=2;
				attWay.setLastWinTime(new Date());
			}
			attWay.setScore((short) (attWay.getScore()+score));
			al.setWinLos(1);
			exp=GameCache.getMartialWayExpAward(user.getLevel());
			ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_武道大会);
			effects.appendItem(SystemConstant.ITEM_EFFECT_TYPE_EXP, 0, exp, 0);
			effectService.addIncome(user, effects, null);
		}else{
			score= SystemConstant.MARTIAL_WAY_LOSE_SCORE;
			attWay.setScore((short) (attWay.getScore()+score));
			attWay.setWinStreak((short) 0);
			al.setWinLos(0);
		}
		al.setType(SystemConstant.ARENA_LOGGER_TYPE_武道大会);
		UserBaseinfo attInfo = userService.getUserBaseInfo(attWay.getUserId());
		UserBaseinfo defInfo = userService.getUserBaseInfo(defWay.getUserId());
		al.setUserId(attWay.getUserId());
		al.setCapId(defInfo.getHeroId());
		al.setMatchLevel(defInfo.getLevel());
		al.setMatchUserId(defInfo.getUserId());
		al.setMatchUserName(defInfo.getPlayerName());
		al.setUserName(attInfo.getPlayerName());
		arenaService.addArenaLogger(al);
		MartialWayFightAwardVO vo = MessageFactory.getMessage(MartialWayFightAwardVO.class);
		vo.setScore(score);
		vo.setFirstWin(firstWin);
		vo.setExp(exp);
		vo.setWin(attWin);
		if(attWay.getWinStreak()!=0){
			vo.setWinStreak(attWay.getWinStreak()-1);
		}
		battle.getBattleMessage().put(attWay.getUserId(), vo);
	}
	private short getWinScore(MartialWay attWay, MartialWay defWay) {
		int cc = attWay.getScore()-defWay.getScore();
		if(cc<=-100){//TODO
			return 5;
		}else if(cc<=-201){
			return 10;
		}else if(cc<=-301){
			return 15;
		}
		return 0;
	}
	private void zoneFightFinish(Battle battle, AttackRoundVO round,
			boolean attWin) {
		if(attWin){
			battle.setShotUserId(battle.getAttackUserId());
			round.setNextShotUserId(battle.getAttackUserId());
			ZoneBattle zoneBattle = GameCache.getZoneBattle(battle.getZoneBattleId());
			BattleRound nextRound = GameCache.getBattleRound(battle.getZoneBattleId(), battle.getBattleRoundId()+1);
			if(!battle.isDis()&&nextRound!=null){//没有乱入怪物
				int random = (int) (Math.random()*10000);
				if(zoneBattle.getDisRate()>random){//乱入怪物
					battle.setDis(true);
					battle.getDefenders().clear();
					List<Grid> canUseGrid = new ArrayList<Grid>();
					for(Grid g : battle.getGrids().values()){
						if(g.getGridItem() == 0 && g.getFightId() == 0){
							canUseGrid.add(g);
						}
					}
					
					FightModel fm = createMonsterModel(battle.getDefenderUserId(), 1000, zoneBattle.getDisMonster().get((int) (zoneBattle.getDisMonster().size()*Math.random())));
					Grid grid = canUseGrid.get((int) (canUseGrid.size()*Math.random()));
					grid.setFightId(fm.getFightId());
					
					fm.getGridCoors().add(grid.getCoor());
					battle.getDefenders().add(fm);
					
					FightModelVO vo = MessageFactory.getMessage(FightModelVO.class);
					vo.init(fm);
					
					round.setDisMonster(vo);
					return;
				}
			}
			if(nextRound != null){
				battle.setBattleRoundId(battle.getBattleRoundId()+1);
				battle.setDis(false);
				battle.setShotUserId(battle.getAttackUserId());
				battle.setAttackAI(null);
				
				boolean lastRound = false;//是否为最后一回合
				int fightId = 100;
				if(nextRound.isBossRound()){//这一波怪为最后一波怪
					lastRound = true;
					int deadPos = -1;
					FightModel disFm = null;
					for(FightModel fm : battle.getAttackers()){
						if(fm.getState() == SystemConstant.FIGHT_MODEL_STATE_正常){
							for(Point p : fm.getGridCoors()){
								Grid grid = battle.getGrids().get(p);
								grid.setFightId(0);
							}
							fm.getGridCoors().clear();
						}
					}
					for(FightModel fm : battle.getAttackers()){
						int pos = fm.getTeamPos();
						if(fm.getState() == SystemConstant.FIGHT_MODEL_STATE_正常){
							if(pos == 4){
								if(deadPos != -1){
									pos = deadPos;
								}else{
									disFm = fm;
									continue;
								}
							}
							Point p = createAtkPos(pos);
							
							Grid grid = battle.getGrids().get(p);
							grid.setFightId(fm.getFightId());
							fm.getGridCoors().add(p);
							
						}else{
							if(disFm!=null){
								Point p;
								
								if(pos==3){
									p = new Point(3, 4);
								}else{
									p = new Point(4, 2+pos);
								}
								Grid grid = battle.getGrids().get(p);
								grid.setFightId(disFm.getFightId());
								disFm.getGridCoors().add(p);
								
								disFm = null;
							}else{
								deadPos = fm.getTeamPos();
							}
						}
					}
				}
				List<Grid> canUseGrid = new ArrayList<Grid>();
				for(Grid g : battle.getGrids().values()){
					g.setGridItem(0);
					if(g.getGridItem() == 0 && g.getFightId() == 0){
						canUseGrid.add(g);
					}
				}
				battle.getDefenders().clear();
				int i = 0;
				for(int monsterId : nextRound.getMonsters()){
					if(monsterId == 0){
						i++;
						continue;
					}
					FightModel fm = createMonsterModel(battle.getDefenderUserId(), fightId, monsterId);
					Grid grid;
					if(lastRound){
						Point p = null;
						p = createDefPos(i);
						i++;
						grid = battle.getGrids().get(p);
					}else{
						grid = canUseGrid.remove((int) (Math.random()*canUseGrid.size()));
					}
					grid.setFightId(fightId);
					fm.getGridCoors().add(grid.getCoor());
					battle.getDefenders().add(fm);
					
					fightId++;
				}
				
				if(!lastRound){
					int random = (int) (Math.random() * SystemConstant.PERCENT_BASE_DOUBLE);
					if(zoneBattle.getSlateRate()>random){
						if(canUseGrid.size() > 0){
							Grid g = canUseGrid.remove((int) (Math.random()*canUseGrid.size()));
							g.setGridItem(SystemConstant.FIGHT_GRID_ITEM_石板);
						}
					}
				}else{
					for(int[] is : zoneBattle.getHinder()){
						Point p = new Point(is[0], is[1]);
						Grid g = battle.getGrids().get(p);
						if(g!=null){
							g.setGridItem(is[2]);
						}
					}
				}
				
				FightVO vo = MessageFactory.getMessage(FightVO.class);
				vo.init(battle);
				round.setNextFight(vo);
			}
		}
	}
	private Point createDefPos(int pos) {
		Point p = null;
		switch (pos) {
		case 3:
			p = new Point(8, 1);
			break;
		case 2:
			p = new Point(6, 1);
			break;
		case 1:
			p = new Point(5, 2);
			break;
		case 0:
			p = new Point(6, 3);
			break;
		case 4:
			p = new Point(5, 4);
			break;
		default:
			break;
		}
		return p;
	}
	private Point createAtkPos(int pos) {
		Point p = null;
		switch (pos) {
		case 0:
			p = new Point(11, 2);
			break;
		case 1:
			p = new Point(12, 3);
			break;
		case 2:
			p = new Point(11, 4);
			break;
		case 3:
			p = new Point(9, 4);
			break;
		default:
			break;
		}
		return p;
	}
	private AttackRoundVO move0(int userId, Battle battle, MoveVO moveVO) {
		AttackRoundVO round = AttackRoundVO.create();
		List<Point> path = new ArrayList<Point>();//路径
		if(moveVO.getFightId()!=0){
			Point targetPoint = new Point(moveVO.getPoint().getX(), moveVO.getPoint().getY());
			Grid targetGrid = battle.getGrids().get(targetPoint);
			if(targetGrid == null){
				throw new GameException(GameException.CODE_参数错误, "");
			}
			
			//移动方的所有队员
			List<FightModel> fms = null;
			if(userId == battle.getAttackUserId()){
				fms = battle.getAttackers();
			}else{
				fms = battle.getDefenders();
			}
			//移动者
			FightModel fm = null;
			for(FightModel f : fms){
				if(f.getFightId() == moveVO.getFightId()){
					fm = f;
					break;
				}
			}
			//移动对象已死或被眩晕
			if(fm == null || !FightBuff.canMove(fm)){
				throw new GameException(GameException.CODE_参数错误, "");
			}
			//当前所在格子
			Point curtPoint = fm.getGridCoors().get(0);
			
			//计算移动的方向，并将移动路径存放在path中
			int dir = BaseAI.gainPath(targetPoint, path, curtPoint);
			
			List<FightModel> attackers = null;//攻击方
			List<FightModel> defenders = null;//防守方
			if(battle.getShotUserId() == battle.getAttackUserId()){
				attackers = battle.getAttackers();
				defenders = battle.getDefenders();
			}else{
				defenders = battle.getAttackers();
				attackers = battle.getDefenders();
			}
			
			if(targetGrid.getFightId()!=0&&targetGrid.getFightId()!=moveVO.getFightId()){
				
				FightModel catModel = BaseAI.getFightModel(targetGrid.getFightId(), attackers);
				if(catModel==null){
					throw new GameException(GameException.CODE_参数错误, "");
				}
				
				execCatapult(battle, moveVO.getFightId(), catModel,attackers, defenders, round,dir);//处理弹射
			}
			
			if(dir==-1){
				throw new GameException(GameException.CODE_参数错误, "");
			}
			if(!BaseAI.checkPoint(fm, curtPoint, path, dir, battle.getGrids(),attackers)){
				throw new GameException(GameException.CODE_参数错误, "");
			}
			
			for(Point o : fm.getGridCoors()){
				Grid grid = battle.getGrids().get(o);
				grid.setFightId(0);
			}
			
			for(int i=0;i<fm.getGridCoors().size();i++){
				Point o = new Point(targetPoint.getX(), targetPoint.getY());
				if(i==1){
					o.setX(o.getX()+1);
				}else if(i==2){
					o.setY(o.getY()+1);
				}else if(i==3){
					o.setY(o.getY()+1);
					o.setX(o.getX()+1);
				}
				Grid grid = battle.getGrids().get(o);
				grid.setFightId(fm.getFightId());
				fm.getGridCoors().set(i, o);
			}
		}
		fighting(battle,moveVO.getFightId(),round,path.size());
		return round;
	}
	
	/**
	 * 战斗
	 * @param battle
	 * @param moveFightId 
	 */
	private AttackRoundVO fighting(Battle battle, int moveFightId,AttackRoundVO round,int moveDistance) {
		List<FightModel> attackers = null;//攻击方
		List<FightModel> defenders = null;//防守方
		if(battle.getShotUserId() == battle.getAttackUserId()){
			attackers = battle.getAttackers();
			defenders = battle.getDefenders();
		}else{
			defenders = battle.getAttackers();
			attackers = battle.getDefenders();
		}
		
		refBattleProp(battle, round);//刷新战场道具
		
		execBattleProp(battle, round);//处理战场道具
		
		for(FightModel atk : attackers){//释放延迟技能和被动技能
			if(atk.isReadySkill()){
				FightAtkMode atkModel = atk.getAtkMode().peek();
				Skill skill = GameCache.getSkill(atkModel.getSkill().getSkillId(), atkModel.getSkill().getSkillLv());
				round.getRelSkill().add(releaseSkill(attackers, defenders, atk,atkModel.getSkill(),skill,battle,round,null));
				atk.setReadySkill(false);
				
				int leftCount = 0;
				for(FightModel fm : defenders){
					if(fm.getState()!=SystemConstant.FIGHT_MODEL_STATE_死亡){
						leftCount+=1;
					}
				}
				if(leftCount==0){//结束战斗
					finishFightRound(battle,round);
					return round;
				}
			}
			if(!canReleaseSkill(atk)){
				continue;
			}
			if(atk.getState() == SystemConstant.FIGHT_MODEL_STATE_正常){
				List<ReleaseSkillVO> vos = checkResPassIveSkill(battle, moveFightId, round, moveDistance, attackers,
						defenders, atk,0,0,null,0);
				round.getRelSkill().addAll(vos);
			}
		}
		
		Queue<List<AttackModel>> queue = new LinkedList<List<AttackModel>>();
		
		for(FightModel attack : attackers){
			if(FightBuff.canFight(attack)){
				BaseAI.gainAttackeders(battle.getGrids(), attackers,
						defenders, queue, attack.getGridCoors(),
						attack);
			}
		}
		
		for(FightModel f : attackers){
			int count = 0;
			for(List<AttackModel> ams : queue){
				for(AttackModel am : ams){
					if(am.getAttackFightId() == f.getFightId()){
						count++;
					}
				}
			}
			List<ReleaseSkillVO> vos = checkResPassIveSkill(battle, moveFightId, round, moveDistance, attackers,
					defenders, f,0,0,null,count);
			round.getRelSkill().addAll(vos);
		}
		
		
		List<AttackModel> ams = queue.poll();
		while(ams!=null){
			while(ams.size()!=0){
				AttackModel am = ams.remove(0);
				FightModel def = BaseAI.getFightModel(am.getDefendFightId(), defenders);
				if(def.getState() == SystemConstant.FIGHT_MODEL_STATE_死亡){
					continue;
				}
				
				AttackedVO attacked = MessageFactory.getMessage(AttackedVO.class);
				
				round.getAttackeds().add(attacked);
				
				attacked.setAttackederId(def.getFightId());
				attacked.setAttacks(new ArrayList<AttackVO>());
				attacked.setDrops(new ArrayList<DropVO>());
				attacked.setRelSkill(new ArrayList<ReleaseSkillVO>());
				
				List<AttackModel> attModels = new ArrayList<AttackModel>();
				attModels.add(am);
				
				Iterator<AttackModel> amsIt = ams.iterator();
				while(amsIt.hasNext()){
					AttackModel a = amsIt.next();
					if(a.getDefendFightId()==am.getDefendFightId()){
						amsIt.remove();
						attModels.add(a);
					}
				}
				
				Iterator<List<AttackModel>> amlIt = queue.iterator();
				while(amlIt.hasNext()){
					List<AttackModel> list = amlIt.next();
					Iterator<AttackModel> amIt = list.iterator();
					while(amIt.hasNext()){
						AttackModel a = amIt.next();
						if(a.getDefendFightId()==am.getDefendFightId()){
							amIt.remove();
							attModels.add(a);
						}
					}
					if(list.size() == 0){
						amlIt.remove();
					}
				}
				
				int batterCount = 0;
				List<FightModel> ats = new ArrayList<FightModel>();
				
				for(AttackModel a : attModels){//获得合击次数
					FightModel at = BaseAI.getFightModel(a.getAttackFightId(), attackers);
					batterCount+=at.getRealAtkCount();
					ats.add(at);
				}
				int c = attModels.size()>1?batterCount:0;
				
				attacked.setBatterCount(batterCount);
				int totalHurt =0;
				for(FightModel at : ats){
					at.setNotHurtRound(-1);
					AttackVO attack = MessageFactory.getMessage(AttackVO.class);
					
					attacked.getAttacks().add(attack);
					
					List<ReleaseSkillVO> vos = checkResPassIveSkill(battle, moveFightId, round, moveDistance, attackers,
							defenders, at,c,0,def,0);
					
					attack.setRelSkill(vos);
					
					double random = Math.random();
					int attackType = SystemConstant.FIGHT_TYPE_普通攻击;
					
					double critRate = at.getRealCritRate();//自身暴击率
					double dodgeRate = def.getRealDodgeRate();//对方躲闪率
					double blockRate = def.getRealBlockRate();
					if(critRate>random){
						attackType = SystemConstant.FIGHT_TYPE_暴击;
					}else if((critRate+blockRate)>random){
						attackType = SystemConstant.FIGHT_TYPE_格挡;
					}else if((critRate+dodgeRate+blockRate)>random){
						attackType = SystemConstant.FIGHT_TYPE_闪避;
					}
					attack.setAttackerId(at.getFightId());
					double hurt = 0;
					int absorbHurt = 0;
					if(attackType != SystemConstant.FIGHT_TYPE_闪避){
						
						if(batterCount==at.getRealAtkCount()){
							batterCount=1;
						}
						
						int atk = at.getRealAtk();
						attack.setAtk(atk);
						hurt = atk//攻击力
								*at.getRealAtkCount()//攻击次数
								*getBatterAddition(batterCount);//连击加成
						double restraint = Hero.getRestraint(at.getEle(), at.getEleLv(),def.getEle(), def.getEleLv());
						if(!canRestraint(def)){
							restraint=restraint>1?1:restraint;
						}
						
						hurt *=restraint;//属性加成
						
						hurt = calReduceHurt((int)hurt,def,at, attack, null, null, null);//减少伤害
						
						if(attackType == SystemConstant.FIGHT_TYPE_暴击){
							hurt *= at.getRealCrithurt();
						}else if(attackType == SystemConstant.FIGHT_TYPE_格挡){
							hurt *= def.getRealBlockhurt();
						}
						
						hurt = getLastHurt(hurt,at);
						
						List<SubHurtVO> subHurts = calSputtering(battle,at,defenders,hurt,def,round);
						attack.setSubHurts(subHurts);
						
						absorbHurt = calAbsorb((int)hurt,def, attack, null, null, null);
						
						hurt -= absorbHurt;
						
					}
					
					
					
					attack.setHurtType(attackType);
					attack.setHurt((int)hurt);
					attack.setAbsorbHurt(absorbHurt);
					
					totalHurt+=hurt;
					
				}
				
				List<ReleaseSkillVO> vos = buckleBlood(def, totalHurt,battle,round,defenders,attackers);
				attacked.getRelSkill().addAll(vos);
				
				attacked.setSurHp(def.getHp());
				
				if(def.getHp()<=0){
					execDeadFightModel(battle, round, def);
					
					
					if(battle.getBattleType() == SystemConstant.FIGHT_TYPE_ZONE){
						if(def.isNpc()){
							List<DropVO> drops = gainMonsterDrop(battle, def);
							attacked.setDrops(drops);
						}
					}
				}else{
					List<ReleaseSkillVO> vs = checkResPassIveSkill(battle, moveFightId, round, 0, defenders,attackers, def, 0,batterCount, null, 0);
					attacked.getRelSkill().addAll(vs);
				}
			}
			ams = queue.poll();
		}
		
		List<ModeRotationVO> rotations = new ArrayList<>();
		int nextShotUserId = battle.getShotUserId()==battle.getAttackUserId()?battle.getDefenderUserId():battle.getAttackUserId();
		calFightBuff(battle, defenders, round);//计算战斗buff
		for(FightModel fm : attackers){
			fm.nextRound(nextShotUserId);
		}
		for(FightModel fm : defenders){
			fm.nextRound(nextShotUserId);
			ModeRotationVO r = fm.nextAtkRound(nextShotUserId);
			if(r != null){
				rotations.add(r);
			}
		}
//		execBuffs(defenders);
		if(battle.getShotUserId() == battle.getDefenderUserId()){
			battle.setRound(battle.getRound()+1);
		}
		
		round.setRotations(rotations);
		
		battle.setShotUserId(nextShotUserId);
		
		round.setNextShotUserId(battle.getShotUserId());
		return round;
	}
	/**
	 * 计算溅射伤害
	 * @param at
	 * @param hurt
	 * @return
	 */
	private List<SubHurtVO> calSputtering(Battle battle,FightModel at, List<FightModel> defs,double hurt,FightModel def,AttackRoundVO round) {
		List<SubHurtVO> list = new ArrayList<SubHurtVO>();
		for(FightBuff buff : at.getBuffs()){
			if(buff.getEffectId() == SystemConstant.SKILL_EFFECT_ID_溅射){
				if((buff.getCons() & 0b1)!=0){
						List<Point> points = BaseAI.getFightPointPoint(at.getGridCoors().get(0), SystemConstant.FIGHT_ATK_MODE_DIR_左上, 1);
						execSubHurt(battle, at, defs, hurt, def, round, list,
								points);
				}
				if((buff.getCons() & 0b100)!=0){
					List<Point> points = BaseAI.getFightPointPoint(at.getGridCoors().get(0), SystemConstant.FIGHT_ATK_MODE_DIR_右上, 1);
					execSubHurt(battle, at, defs, hurt, def, round, list,
							points);
				}
				if((buff.getCons() & 0b1000)!=0){
					List<Point> points = BaseAI.getFightPointPoint(at.getGridCoors().get(0), SystemConstant.FIGHT_ATK_MODE_DIR_右, 1);
					execSubHurt(battle, at, defs, hurt, def, round, list,
							points);
				}
				if((buff.getCons() & 0b10000)!=0){
					List<Point> points = BaseAI.getFightPointPoint(at.getGridCoors().get(0), SystemConstant.FIGHT_ATK_MODE_DIR_右下, 1);
					execSubHurt(battle, at, defs, hurt, def, round, list,
							points);
				}
				if((buff.getCons() & 0b1000000)!=0){
					List<Point> points = BaseAI.getFightPointPoint(at.getGridCoors().get(0), SystemConstant.FIGHT_ATK_MODE_DIR_左下, 1);
					execSubHurt(battle, at, defs, hurt, def, round, list,
							points);
				}
				if((buff.getCons() & 0b10000000)!=0){
					List<Point> points = BaseAI.getFightPointPoint(at.getGridCoors().get(0), SystemConstant.FIGHT_ATK_MODE_DIR_左, 1);
					execSubHurt(battle, at, defs, hurt, def, round, list,
							points);
				}
			}else if(buff.getEffectId() == SystemConstant.SKILL_EFFECT_ID_穿刺){
				int dir = BaseAI.gainPath(at.getGridCoors().get(0), new ArrayList<Point>(), def.getGridCoors().get(0));
				List<Point> points = BaseAI.getFightPointPoint(def.getGridCoors().get(0), dir, buff.getCons());
				execSubHurt(battle, at, defs, hurt, def, round, list,
						points);
			}
		}
		
		return list;
	}
	private void execSubHurt(Battle battle, FightModel at,
			List<FightModel> defs, double hurt, FightModel def,
			AttackRoundVO round, List<SubHurtVO> list, List<Point> points) {
		for(Point p : points){
			Grid g = battle.getGrids().get(p);
			if(g!=null){
				if(g.getFightId()!=0){
					FightModel fm  = BaseAI.getFightModel(g.getFightId(), defs);
					if(fm!=null&&fm.getState() != SystemConstant.FIGHT_MODEL_STATE_死亡&&fm!=def){
						SubHurtVO vo = MessageFactory.getMessage(SubHurtVO.class);
						int h = calReduceHurt((int)hurt, fm, at, null, null, vo, null);
						int absorbHurt = calAbsorb((int)h,fm, null, null, vo, null);
						fm.setHp(fm.getHp()-h);
						vo.setDefFightId(fm.getFightId());
						vo.setAbsorbHurt(absorbHurt);
						vo.setHurt(h);
						if(fm.getHp()<=0){
							execDeadFightModel(battle, round, def);
							if(battle.getBattleType() == SystemConstant.FIGHT_TYPE_ZONE){
								if(def.isNpc()){
									List<DropVO> drops = gainMonsterDrop(battle, def);
									vo.setDrops(drops);
								}
						}
						vo.setSurHp(fm.getHp());
						list.add(vo);
					}
				}
			}
		}
}
	}
	/**
	 * 获得最终伤害
	 * @param hurt
	 * @param at
	 * @return
	 */
	private double getLastHurt(double hurt, FightModel at) {
		for(FightBuff buff : at.getBuffs()){
			if(buff.getEffectId() == SystemConstant.SKILL_EFFECT_ID_造成伤害变更){
				hurt*=(1+(buff.getScore()/SystemConstant.PERCENT_BASE_DOUBLE));
			}
		}
		return hurt;
	}

	/**
	 * 检查是否放被动技能
	 * @param battle 战场
	 * @param round 回合
	 * @param moveDistance 移动步数
	 * @param attackers 攻击方
	 * @param defenders 防守方
	 * @param atk 是否技能者
	 */
	private List<ReleaseSkillVO> checkResPassIveSkill(Battle battle, int moveFightId, AttackRoundVO round,
			int moveDistance, List<FightModel> attackers,
			List<FightModel> defenders, FightModel atk,int batterCount,int batterCounted,FightModel def,int sameTimeAtkTar) {
		List<ReleaseSkillVO> rsVO = new ArrayList<ReleaseSkillVO>();
		if(atk.getHp()<=0){
			return rsVO;
		}
		for(FightSkill fs : atk.getPassiveSkills()){
			if(!battle.isEnd()){
				PassiveSkill ps = GameCache.getPassiveSkill(fs.getSkillId());
				
				if(!canReleaseSkill(atk)){
					if(ps.getResState()==0){
						continue;
					}
				}
				
				if(ps.getCd() <=fs.getCurrRound()){
					boolean flag = true;
					for(int i=0;i<ps.getTakeEffect().size();i++){
						boolean b = false;
						switch (ps.getTakeEffect().get(i)) {
						case 1://1.	自身血量低于百分之X%。
							if(atk==null){
								break;
							}
							if((int)((double)atk.getHp()/(double)atk.getMaxHp()*SystemConstant.PERCENT_BASE_DOUBLE)<ps.getArg0().get(i)){
								b=true;
							}
							break;
						case 2://2.	其他队友血量低于百分之X%。
							if(attackers==null){
								break;
							}
							for(FightModel fm : attackers){
	//							if(fm.getHp() <= 0 &&fm.getFightId() !=atk.getFightId()){
	//								continue;
	//							}
								if(fm.getHp() <= 0){
									continue;
								}
								if((int)((double)fm.getHp()/(double)fm.getMaxHp()*SystemConstant.PERCENT_BASE_DOUBLE)<ps.getArg0().get(i)){
									b=true;
								}
							}
							break;
						case 3://3.	自身周边X格范围内存在的敌人少于X，或者达到X。
							if(atk==null){
								break;
							}
							if(atk.getState() == SystemConstant.FIGHT_MODEL_STATE_死亡){
								break;
							}
							b = checkAroundCount(battle, attackers, atk, ps, i);
							break;
						case 4://4.	自身周边X格范围内存在的队友少于X，或者达到X。
							if(atk==null){
								break;
							}
							if(atk.getState() == SystemConstant.FIGHT_MODEL_STATE_死亡){
								break;
							}
							b = checkAroundCount(battle, defenders, atk, ps, i);
							break;
						case 11://11.	被合击数大于等于X。
							if(batterCounted>=ps.getArg0().get(i)){
								b=true;
							}
							break;
						case 5://5.	合击数大于等于X。
							if(batterCount>=ps.getArg0().get(i)){
								b=true;
							}
							break;
						case 6://6.	移动的距离达到X。
							if((moveFightId == 0 || moveFightId == atk.getFightId()) && moveDistance==ps.getArg0().get(i)){
								b=true;
							}
							break;
						case 8://8.	同时攻击的目标小于等于X。
							
							if(sameTimeAtkTar<=ps.getArg0().get(i)&&sameTimeAtkTar>0){
								b=true;
							}
							break;
						case 9://9.	X回合没有造成伤害。
							if(atk==null){
								break;
							}
							if(atk.getNotHurtRound()>=ps.getArg0().get(i)){
								b=true;
							}
							break;
						case 10://10.	攻击目标血量低于百分之X%。
							
							if(def==null){
								break;
							}
							
							if(def.getHp()/def.getMaxHp()*SystemConstant.PERCENT_BASE_DOUBLE<ps.getArg0().get(i)){
								b=true;
							}
							break;
						
						case 12://12.	战场上敌人数量少于X，或者达到X。
							if(defenders==null){
								break;
							}
							int count = 0;
							for(FightModel fm : defenders){
								if(fm.getState() != SystemConstant.FIGHT_MODEL_STATE_死亡){
									count++;
								}
							}
							if(count<=ps.getArg0().get(i)){
								b=true;
							}
							break;
						case 13://13.	战场上己方角色数量少于X，或者达到X。
							if(attackers==null){
								break;
							}
							int c=0;
							for(FightModel fm : attackers){
								if(fm.getState() != SystemConstant.FIGHT_MODEL_STATE_死亡){
									c++;
								}
							}
							if(c<=ps.getArg0().get(i)){
								b=true;
							}
							break;
						default:
							break;
						}
						if(!b){
							flag = false;
							break;
						}
					}
					
					if(flag){//可以释放技能
						
						if(fs.getSkillType() == 1){
							for(FightModel fm : attackers){
								for(FightSkill f : fm.getPassiveSkills()){
									if(f.getSkillType() == 1)
										f.release(battle.getShotUserId());
								}
							}
						}
						rsVO.add(releaseSkill(attackers, defenders, atk,fs, ps, battle,round,null));
					}	
				}
			}
		}
		return rsVO;
	}
	/**
	 * 扣血
	 * @param def
	 * @param hurt
	 */
	private List<ReleaseSkillVO> buckleBlood(FightModel def, double hurt,Battle battle,AttackRoundVO round,List<FightModel> attackers,List<FightModel>defenders) {
		def.setHp(def.getHp()-(int)hurt);
		List<ReleaseSkillVO>vos = new ArrayList<ReleaseSkillVO>();
		for(FightModel fm : attackers){
			vos.addAll(checkResPassIveSkill(battle, 0, round, 0,attackers, defenders, fm,0,0,null,0));
		}
		return vos;
	}
	/**
	 * 检查周围的人数
	 * @param battle
	 * @param fms
	 * @param fm
	 * @param ps
	 * @param i
	 * @return
	 */
	private boolean checkAroundCount(Battle battle, List<FightModel> fms,
			FightModel fm, PassiveSkill ps, int i) {
		int count=0;
		for(int j = 0;j<8;j++){
			List<Point> points = BaseAI.getFightPointPoint(fm.getGridCoors().get(0), j, ps.getArg0().get(i));
			for(Point p : points){
				Grid g = battle.getGrids().get(p);
				if(g!=null){
					if(g.getFightId()!=0){
						if(BaseAI.getFightModel(g.getFightId(), fms)==null){
							count++;
						}
					}
				}
			}
		}
		
		if(count<ps.getArg1().get(i)){
			return true;
		}
		return false;
	}
	/**
	 * 是否受属性影响
	 * @param def
	 * @return
	 */
	private boolean canRestraint(FightModel def) {
		for(EternalEffect ee : def.getEternalEffects()){
			if(ee.getEffectType() == SystemConstant.ETERNAL_EFFECT_TYPE_免疫对克制属性的百分比伤害){
				return false;
			}
		}
		return true;
	}
	/**
	 * 处理弹射
	 * @param battle
	 * @param moveFightId
	 * @param catModel 
	 * @param attackers
	 * @param defenders
	 * @param round
	 */
	private void execCatapult(Battle battle, int moveFightId,
			FightModel catModel, List<FightModel> attackers, List<FightModel> defenders,
			AttackRoundVO round,int dir) {
		FightModel model = BaseAI.getFightModel(moveFightId, attackers);
		if(!FightBuff.hasBuff(model, SystemConstant.SKILL_EFFECT_ID_弹射)&&(!FightBuff.hasBuff(model, SystemConstant.SKILL_EFFECT_ID_穿透弹射))){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		
		Point cuPoint = catModel.getGridCoors().get(0);
		
		FightModel fm = catModel;
		if(fm!=null){
			Point lastPoint = fm.getGridCoors().get(0);
			List<FightModel> attackedModel = new ArrayList<>();
			int index = 0;
			Point currPoint = BaseAI.getFightPointPoint(fm.getGridCoors().get(0), dir, 1).get(0);
			boolean gainPoint = true;
			while(index < 3){
				if(gainPoint)
					currPoint = BaseAI.getFightPointPoint(lastPoint, dir, 1).get(0);
				Grid grid = battle.getGrids().get(currPoint);
				if(grid==null){
					currPoint = lastPoint;
					break;
				}
				if(FightBuff.hasBuff(model, SystemConstant.SKILL_EFFECT_ID_弹射)){
					FightModel gridModel = null;
					if(grid.getFightId()!=0){
						gridModel = BaseAI.getFightModel(grid.getFightId(), defenders);
						if(gridModel !=null){
							attackedModel.add(gridModel);
							currPoint= lastPoint ;
							break;
						}else{
							currPoint= lastPoint ;
							break;
						}
					}else{
						if(grid==null||grid.getGridItem() == SystemConstant.FIGHT_GRID_ITEM_障碍物){
							currPoint= lastPoint ;
							break;
						}
					}
				}else{
					FightModel gridModel = null;
					if(grid.getFightId()!=0){
						gridModel = BaseAI.getFightModel(grid.getFightId(), defenders);
						if(gridModel !=null){
							attackedModel.add(gridModel);
							currPoint = BaseAI.getFightPointPoint(currPoint, dir, 1).get(0);
							gainPoint = false;
							continue;
						}else{
							if(attackedModel.size()>1){
								FightModel m = attackedModel.get(0);
								attackedModel.clear();
								attackedModel.add(m);
							}
							currPoint= lastPoint ;
							break;
						}
					}else{
						if(grid==null||grid.getGridItem() == SystemConstant.FIGHT_GRID_ITEM_障碍物){
							if(attackedModel.size()>1){
								FightModel m = attackedModel.get(0);
								attackedModel.clear();
								attackedModel.add(m);
							}
							currPoint= lastPoint ;
							break;
						}else{
							if(attackedModel.size()>0){
								break;
							}
						}
					}
				}
				lastPoint = currPoint;
				index ++;
			}
			CatapultVO c = MessageFactory.getMessage(CatapultVO.class);
			round.getCatapult().add(c);
			c.setHurts(new ArrayList<CatapultHurtVO>());
			c.setFightId(fm.getFightId());
			if(currPoint!=null){
				PointVO vo = MessageFactory.getMessage(PointVO.class);
				vo.init(currPoint);
				c.setCurrPoint(vo);
				
				for(Point o : fm.getGridCoors()){
					Grid grid = battle.getGrids().get(o);
					grid.setFightId(0);
				}
				
				for(int i=0;i<fm.getGridCoors().size();i++){
					Point o = new Point(currPoint.getX(), currPoint.getY());
					Grid grid = battle.getGrids().get(o);
					grid.setFightId(fm.getFightId());
					fm.getGridCoors().set(i, o);
				}
				
			}
			
			if(attackedModel.size()>0){
				int atk = fm.getRealAtk();
				for(FightModel def : attackedModel){
					
					CatapultHurtVO ch = MessageFactory.getMessage(CatapultHurtVO.class);
					c.getHurts().add(ch);
					ch.setDrops(new ArrayList<DropVO>());
					ch.setFightId(def.getFightId());
					ch.setHurt(atk);
					
					def.setHp( def.getHp()-atk);
					if(def.getHp()<=0){
						execDeadFightModel(battle, round, def);
						if(battle.getBattleType() == SystemConstant.FIGHT_TYPE_ZONE){
							if(def.isNpc()){
								List<DropVO> drops = gainMonsterDrop(battle, def);
								ch.setDrops(drops);
							}
						}
					}
				}
			}
		}
		
		if(cuPoint.equals(fm.getGridCoors().get(0))){
			throw new GameException(GameException.CODE_参数错误, "");
		}
	}
	/**
	 * 计算战场BUFF
	 * @param battle
	 * @param defenders
	 * @param round
	 */
	private void calFightBuff(Battle battle, List<FightModel> defenders,
			AttackRoundVO round) {
		for(FightModel def : defenders){//计算回血BUFF
			for(FightBuff buff : def.getBuffs()){
					switch (buff.getEffectId()) {
					case SystemConstant.SKILL_EFFECT_ID_持续恢复:
					case SystemConstant.SKILL_EFFECT_ID_GRID_ITEM_泉水:
						int val = def.getMaxHp()*buff.getScore()/100+buff.getCons();
						int hp = def.getHp()+val;
						hp = hp>def.getMaxHp()?def.getMaxHp():hp;
						def.setHp(hp);
						
						FightBuffAffectVO bfa = FightBuffAffectVO.create(def.getFightId(),buff.getEffectId(), AffectederVO.TYPE_RECOVER, val, 0,def.getHp());
						round.getBuffAffects().add(bfa);
						break;
					default:
						break;
					}
				}
		}
		
		for(FightModel def : defenders){//计算伤害BUFF	
			for(FightBuff buff : def.getBuffs()){
					switch (buff.getEffectId()) {
					case SystemConstant.SKILL_EFFECT_ID_持续伤害:
					case SystemConstant.SKILL_EFFECT_ID_GRID_ITEM_陷阱:
						int hurt = (int) (buff.getCons()+def.getMaxHp()*buff.getScore()/SystemConstant.PERCENT_BASE_DOUBLE);
						FightBuffAffectVO bfa = FightBuffAffectVO.create(def.getFightId(),buff.getEffectId(), AffectederVO.TYPE_HURT, hurt, 0,def.getHp());
						hurt = calReduceHurt(buff.getCons(), def, null, null, null, null, bfa);
						int absorbHurt = calAbsorb(hurt,def, null, null, null, bfa);
						hurt -= absorbHurt;
						bfa.setAbsorbHurt(absorbHurt);
						List<ReleaseSkillVO> vos = buckleBlood(def, hurt,battle,round,defenders,battle.getAttackers()==defenders?battle.getDefenders():battle.getAttackers());
						
						bfa.getRelSkill().addAll(vos);
						
						if(def.getHp()<=0){
							execDeadFightModel(battle, round, def);
							if(battle.getBattleType() == SystemConstant.FIGHT_TYPE_ZONE){
								if(def.isNpc()){
									List<DropVO> drops = gainMonsterDrop(battle, def);
									bfa.setDrops(drops);
								}
							}
						}
						
						round.getBuffAffects().add(bfa);
						
						break;
					default:
						break;
					}
			}
		}
	}
	
	/**
	 * 处理战场道具
	 * @param battle
	 * @param round
	 */
	private void execBattleProp(Battle battle, AttackRoundVO round) {
		if(battle.getBattleType() == SystemConstant.FIGHT_TYPE_ZONE){
			for(Grid g : battle.getGrids().values()){
				List<FightModel> fms;
				if(battle.isAttacker(g.getFightId())){
					fms = battle.getAttackers();
				}else{
					fms = battle.getDefenders();
				}
				FightModel fm = BaseAI.getFightModel(g.getFightId(), fms);
				
				if(g.getFightId() !=0 ){
					switch (g.getGridItem()) {
					case SystemConstant.FIGHT_GRID_ITEM_石板:
						if(battle.isAttacker(g.getFightId())){
							battle.setSlate(battle.getSlate()+1);
						}
						g.setGridItem(0);
						break;
					case SystemConstant.FIGHT_GRID_ITEM_红心:
						List<FightPropAffectVO> affects = round.getAffects();
						
						if(FightBuff.hasBuff(fm, SystemConstant.SKILL_EFFECT_ID_道具效果扩散)){
							for(FightModel m : fms){
								if(m.getState()!= SystemConstant.FIGHT_MODEL_STATE_死亡){
									execHeart(g, affects, m);
								}
							}
						}else{
							execHeart(g, affects, fm);
						}
						round.setAffects(affects);
						g.setGridItem(0);
						break;
					case SystemConstant.FIGHT_GRID_ITEM_敏捷  :
					case SystemConstant.FIGHT_GRID_ITEM_暴击  :
					case SystemConstant.FIGHT_GRID_ITEM_双倍  :
					case SystemConstant.FIGHT_GRID_ITEM_减伤  :
						affects = round.getAffects();
						if(FightBuff.hasBuff(fm, SystemConstant.SKILL_EFFECT_ID_道具效果扩散)){
							for(FightModel m : fms){
								if(m.getState()!= SystemConstant.FIGHT_MODEL_STATE_死亡){
									execItemBuff(battle, g, affects, m);
								}
							}
						}else{
							execItemBuff(battle, g, affects, fm);
						}
						round.setAffects(affects);
						g.setGridItem(0);
						
						break;
						
					case SystemConstant.FIGHT_GRID_ITEM_陷阱  :
						if(immuneTrap(fm)){
							break;
						}
					case SystemConstant.FIGHT_GRID_ITEM_据点  :
					case SystemConstant.FIGHT_GRID_ITEM_泉水  :
						affects = round.getAffects();
						
						execItemBuff(battle, g, affects, fm);
						
						round.setAffects(affects);
						
						break;
						
					default:
						break;
					}
				}
			}
		}
	}
	/**
	 * 是否免疫陷阱
	 * @param fm
	 * @return
	 */
	private boolean immuneTrap(FightModel fm) {
		for(EternalEffect ee : fm.getEternalEffects()){
			if(ee.getEffectType() == SystemConstant.ETERNAL_EFFECT_TYPE_免疫陷阱){
				return true;
			}
		}
		return false;
	}
	/**
	 * 刷新战场道具
	 * @param battle
	 * @param round
	 */
	private void refBattleProp(Battle battle, AttackRoundVO round) {
		if(battle.getBattleType() == SystemConstant.FIGHT_TYPE_ZONE){
			if(GameCache.getBattleRound(battle.getZoneBattleId(), battle.getBattleRoundId()+1)!=null){
				ZoneBattle zoneBattle = GameCache.getZoneBattle(battle.getZoneBattleId());
				List<Grid> canUseGrid = new ArrayList<Grid>();
				
					int random = (int) (Math.random() * 10000);
					if(zoneBattle.getItemRate()>random){
						
						for(Grid g : battle.getGrids().values()){
							if(Grid.isItem(g.getGridItem() )){
								g.setGridItem(0);
							}
							if(g.getGridItem() == 0 && g.getFightId() == 0){
								canUseGrid.add(g);
							}
						}
						
						if(canUseGrid.size() > 0){
							
							int propId = Grid.randomItem();
							
							Grid g = canUseGrid.remove((int) (Math.random()*canUseGrid.size()));
							g.setGridItem(propId);
							
							FightPropRefVO ref = MessageFactory.getMessage(FightPropRefVO.class);
							ref.setPropId(propId);
							PointVO coor = MessageFactory.getMessage(PointVO.class);
							coor.init(g.getCoor());
							ref.setCoor(coor);
							
							round.getPropRefs().add(ref);
					}
				}
			}
		}
	}
	/**
	 * 处理道具buff
	 * @param g
	 * @param affects
	 * @param m
	 */
	private void execItemBuff(Battle battle, Grid g, List<FightPropAffectVO> affects,
			FightModel m) {
		int value = 0;
		int round = 2;
		switch (g.getGridItem()) {
		case SystemConstant.FIGHT_GRID_ITEM_敏捷  :
			value = (int) (0.1*SystemConstant.PERCENT_BASE_DOUBLE);
			break;
		case SystemConstant.FIGHT_GRID_ITEM_暴击  :
			value = (int) (0.2*SystemConstant.PERCENT_BASE_DOUBLE);
			break;
		case SystemConstant.FIGHT_GRID_ITEM_双倍  :
			value = (int) SystemConstant.PERCENT_BASE_DOUBLE;
			break;
		case SystemConstant.FIGHT_GRID_ITEM_减伤  :
			value = (int) (0.3*SystemConstant.PERCENT_BASE_DOUBLE);
			break;
		
		/////////////////////障碍物影响////////////////////////
		case SystemConstant.FIGHT_GRID_ITEM_陷阱  :
			value = (int) (0.1*SystemConstant.PERCENT_BASE_DOUBLE);
			round = 1;
			break;
		case SystemConstant.FIGHT_GRID_ITEM_据点  :
			value = (int) (0.2*SystemConstant.PERCENT_BASE_DOUBLE);
			round = 1;
			break;
		case SystemConstant.FIGHT_GRID_ITEM_泉水  :
			value = (int) (0.08*SystemConstant.PERCENT_BASE_DOUBLE);
			round = 1;
			break;
		default:
			break;
		}
		FightBuff buff = new FightBuff();
		buff.setScore(value);
		buff.setEffectId(g.getGridItem());
		buff.setRound(round);
		addBuff(battle, buff, m, "");
		
		FightPropAffectVO fp = MessageFactory.getMessage(FightPropAffectVO.class);
		fp.setFightId(m.getFightId());
		fp.setFightPropId(g.getGridItem());
		fp.setValue(value);
		affects.add(fp);
	}

//	/**
//	 * 处理buff
//	 * @param defenders
//	 */
//	private void execBuffs(List<FightModel> fms) {
//		for(FightModel fm : fms){
//			Iterator<FightBuff> it = fm.getBuffs().iterator();
//			while(it.hasNext()){
//				FightBuff fb = it.next();
//				if(fb.getRound() != 0){
//					fb.setRound(fb.getRound()-1);
//					if(fb.getRound() == 0){
//						execMaxHpBuffRem(fm, fb);
//						it.remove();
//					}
//				}
//			}
//		}
//	}
//	/**
//	 * 处理增加血量上限buff消失
//	 * @param fm
//	 * @param fb
//	 */
//	private void execMaxHpBuffRem(FightModel fm, FightBuff fb) {
//		if(fb.getEffectId() == SystemConstant.SKILL_EFFECT_ID_生命变更){
//			fm.setMaxHp(fm.getMaxHp()-(int) (fm.getBaseHp()*fb.getScore()/SystemConstant.PERCENT_BASE_DOUBLE));
//			fm.setMaxHp(fm.getMaxHp()-fb.getCons());
//			fm.setHp(fm.getHp()-(int) (fm.getBaseHp()*fb.getScore()/SystemConstant.PERCENT_BASE_DOUBLE)-fb.getCons());
//			if(fm.getHp()<1){
//				fm.setHp(1);
//			}
//		}
//	}
	/**
	 * 获得怪物掉落
	 * @param battle 战场
	 * @param def 怪物
	 * @return 掉落列表
	 */
	private List<DropVO> gainMonsterDrop(Battle battle, FightModel def) {
		Monster monster = GameCache.getMonster(def.getAssId());
		List<DropVO> drops = new ArrayList<DropVO>();
		List<ItemEffect> items = getDropItems(monster.getDrops());
		battle.getDrops().addAll(items);
		for(ItemEffect item : items){
			DropVO vo = MessageFactory.getMessage(DropVO.class);
			vo.init(item.getType(), item.getId(), item.getValue1());
			drops.add(vo);
		}
		return drops;
	}
	/**
	 * 处理死亡模型
	 * @param battle
	 * @param round
	 * @param def
	 */
	private void execDeadFightModel(Battle battle, AttackRoundVO round,
			FightModel def) {
		def.setHp(0);
		def.setState(SystemConstant.FIGHT_MODEL_STATE_死亡);
		
		FightModel subAtt = battle.isAttacker(def.getFightId())?battle.getAttSub():battle.getDefSub();
		
		int subAttFightId = subAtt!=null?subAtt.getFightId():0;
		
		for(Point p : def.getGridCoors()){
			Grid g = battle.getGrids().get(p);
			g.setFightId(subAttFightId);
			if(subAtt!=null){
				subAtt.getGridCoors().add(p);
			}
		}
		
		def.getGridCoors().clear();
		
		if(subAtt!=null){//添加替补
			if(battle.isAttacker(def.getFightId())){
				battle.setAttSub(null);
				battle.getAttackers().add(subAtt);
			}else{
				battle.setDefSub(null);
				battle.getDefenders().add(subAtt);
			}
			
			SubFightBattleVO sf = MessageFactory.getMessage(SubFightBattleVO.class);
			sf.init(subAtt);
			round.setSubFightBattleVO(sf);
		}
	}
	private int calAbsorb(int hurt, FightModel def, AttackVO avo, AffectederVO afvo, SubHurtVO hvo, FightBuffAffectVO fvo) {
		int calAbsorb = 0;
		Iterator<FightBuff> it = def.getBuffs().iterator();
		while(it.hasNext()){
			FightBuff fb = it.next();
			if(fb.getEffectId() == SystemConstant.SKILL_EFFECT_ID_护盾){
				if(fb.getCons()>hurt){
					fb.setCons(fb.getCons()-hurt);
					calAbsorb += hurt;
					break;
				}else{
					calAbsorb += fb.getCons();
					it.remove();
					break;
				}
			}
		}
		if(calAbsorb > 0){
			if(avo != null){
				avo.addAtkEffectId(SystemConstant.SKILL_EFFECT_ID_护盾);
			}else if(afvo != null){
				afvo.addAtkEffectId(SystemConstant.SKILL_EFFECT_ID_护盾);
			}else if(hvo != null){
				hvo.addAtkEffectId(SystemConstant.SKILL_EFFECT_ID_护盾);
			}else if(fvo != null){
				fvo.addAtkEffectId(SystemConstant.SKILL_EFFECT_ID_护盾);
			}
		}
		return calAbsorb;
	}

	/**
	 * 是否免疫debuff
	 * @param fm
	 * @return
	 */
	private boolean immuneDebuff(FightModel fm) {
		for(EternalEffect ee : fm.getEternalEffects()){
			if(ee.getEffectType() == SystemConstant.ETERNAL_EFFECT_TYPE_免疫debuff){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 是否免疫技能伤害
	 * @param fm
	 * @return
	 */
	private boolean immuneSkillHurt(FightModel fm) {
		for(EternalEffect ee : fm.getEternalEffects()){
			if(ee.getEffectType() == SystemConstant.ETERNAL_EFFECT_TYPE_免疫敌方技能伤害){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 处理红心
	 * @param g 格子
	 * @param affects 影响
	 * @param m 影响的英雄
	 */
	private void execHeart(Grid g, List<FightPropAffectVO> affects, FightModel m) {
		int hp = (int) (m.getMaxHp()*0.15);
		m.setHp(m.getHp()+hp);
		if(m.getHp()>m.getMaxHp()){
			m.setHp(m.getMaxHp());
		}
		FightPropAffectVO fp = MessageFactory.getMessage(FightPropAffectVO.class);
		fp.setFightId(m.getFightId());
		fp.setFightPropId(g.getGridItem());
		fp.setValue(hp);
		affects.add(fp);
	}
	private double getBatterAddition(int batterCount){
		if(batterCount > SystemConstant.FIGHT_ATTACK_ADDITION.length){
			batterCount = SystemConstant.FIGHT_ATTACK_ADDITION.length;
		}
		return SystemConstant.FIGHT_ATTACK_ADDITION[batterCount-1]/100d;
	}
	private FightModel createMonsterModel(int userId, int fightId, int monsterId) {
		Monster monster = GameCache.getMonster(monsterId);
		
		FightModel fm = new FightModel();
		fm.setFightId(fightId);
		fm.setNpc(true);
		fm.setAssId(monster.getMonsterId());
		fm.setState(SystemConstant.FIGHT_MODEL_STATE_正常);
		fm.setAbility(monster.getAbility());
		fm.setAtk(monster.getAtk());
		fm.setAtkCount(monster.getAtkCount());
		fm.setHp(monster.getHp());
		
		fm.setMaxHp(monster.getHp());
		
		fm.setCritRate(monster.getCritRate()/SystemConstant.PERCENT_BASE_DOUBLE);
		fm.setCrithurt(monster.getCritHit()/SystemConstant.PERCENT_BASE_DOUBLE);
		fm.setDodgeRate(monster.getDodgeRate()/SystemConstant.PERCENT_BASE_DOUBLE);
		fm.setEle(monster.getEle());
		fm.setEleLv(monster.getEleLv());
		fm.setAtkMode(new LinkedList<FightAtkMode>());
		fm.setBuffs(new ArrayList<FightBuff>());
		
		fm.setGridCoors(new ArrayList<Point>());
		for(MonsterAtkMode mam : monster.getModes()){
			FightAtkMode fam = new FightAtkMode();
			fam.setAtkMode(mam.getAtkMode());
			fam.setMoveMode(mam.getMoveMode());
			fam.setId(mam.getId());
			fam.setCd(mam.getCd());
			fm.getAtkMode().add(fam);
			if(mam.getSkillId()!=0){
				FightSkill fs = new FightSkill();
				fs.setSkillId(mam.getSkillId());
				fs.setSkillLv(1);
				fs.setCurrRound(-1);
				fs.setShotUserId(userId);
				fam.setSkill(fs);
			}
			
		}
		
		if(monster.getCapSkillId()!=0){
			FightSkill fs = new FightSkill();
			fs.setSkillId(monster.getCapSkillId());
			fs.setSkillLv(1);
			fs.setCurrRound(-1);
			fs.setShotUserId(userId);
			fm.getPassiveSkills().add(fs);
		}
		return fm;
	}
	
	private FightModel createHeroModel(int userId, int fightId, UserHero uh,boolean atk) {
		initHeroModel(uh, userId, fightId, atk);
		return uh.getModel();
	}
	
	/**
	 * 计算总属性
	 * @param uh
	 */
	public void computeFightModelAttr(FightModel fm){
		fm.setMaxHp(fm.getRealMaxHp());
		fm.setHp(fm.getMaxHp());
//		System.err.println("computeFightModelAttr start");
		fm.getRealAtk();
		fm.getRealAtkCount();
		fm.getRealBlockhurt();
		fm.getRealBlockRate();
		fm.getRealCrithurt();
		fm.getRealCritRate();
		fm.getRealDodgeRate();
		fm.getRealMaxHp();
//		System.err.println("computeFightModelAttr end");
	}
	
	/**
	 * 初始化角色战斗对象
	 * @param uh
	 */
	public void initHeroModel(UserHero uh, int userId, int fightId, boolean atk){
		Hero hero = GameCache.getHero(uh.getHeroId());
		FightModel fm = new FightModel();
		fm.setFightId(fightId);
		fm.setAtkSign(atk);
		uh.setModel(fm);
		initHeroAttr(userId, uh, hero, atk);
		initHeroBuffs(uh, hero, fm.getAtkMode().peek());
		for(int passiveSkillId : hero.getPassiveSkills()){
			FightSkill fs = new FightSkill();
			fs.setSkillId(passiveSkillId);
			fs.setSkillLv(1);
			fs.setCurrRound(1000);
			fs.setShotUserId(userId);
			fm.getPassiveSkills().add(fs);
		}
		int skillNum = fm.getSkillNum();
		if(hero.getCapSkillId()!=0){
			skillNum+=1;
		}
		if(hero.getSkillId()!=0){
			skillNum+=1;
		}
		skillNum+=hero.getPassiveSkills().size();
		fm.setSkillNum(skillNum);
	}
	
	/**
	 * 处理名望
	 */
	private void initFameBuffs(List<FightModel> models, List<FameBuff> fbs){
		if(fbs!=null){
			for(FightModel fm : models){
				for(FameBuff fb : fbs){
					if(fb.getEffectId() == SystemConstant.SKILL_EFFECT_ID_生命变更){
						FightBuff buff = new FightBuff();
						buff.setEffectId(SystemConstant.SKILL_EFFECT_ID_血量上限);
						buff.setCons(fb.getCons());
						buff.setScore(fb.getScore());
						fm.getBuffs().add(buff);
					}else{
						FightBuff buff = new FightBuff();
						buff.setEffectId(fb.getEffectId());
						buff.setCons(fb.getCons());
						buff.setScore(fb.getScore());
						fm.getBuffs().add(buff);
					}
				}
			}
		}
	}
	
	/**
	 * 处理队长技能
	 * @param models
	 * @param Declaration
	 */
	private void initCalSkill(List<FightModel> models, PassiveSkill capSkill){
		if(capSkill!=null){
			for(FightModel fm : models){
				FightSkill fs = new FightSkill();
				fs.setSkillId(capSkill.getSkillId());
				fs.setSkillLv(1);
				fs.setSkillType(1);
				fs.setCurrRound(100);
				fm.getPassiveSkills().add(fs);
			}
		}
	}
	
	/**
	 * 处理永久被动技能
	 * @param uh
	 */
	private void dealHeroPermanentPassiveSkills(List<FightModel> models, boolean attack){
		for(FightModel fm : models){
			Iterator<FightSkill> it = fm.getPassiveSkills().iterator();
			while(it.hasNext()){
				FightSkill fs = it.next();
				PassiveSkill ps = GameCache.getPassiveSkill(fs.getSkillId());
				if(ps==null){
					throw new GameException(GameException.CODE_参数错误, "not skillId:"+fs.getSkillId());	
				}
				if(ps.getTakeEffect().get(0)==7){
					for(SkillEffect se : ps.getEffects()){
						List<FightModel> fms = Skill.gainImpactModel(models, null, fm, se, attack, fm);
						for(FightModel f : fms){
							if(se.getEffectId() == SystemConstant.SKILL_EFFECT_ID_生命变更){
								FightBuff buff = new FightBuff();
								buff.setEffectId(SystemConstant.SKILL_EFFECT_ID_血量上限);
								buff.setScore(se.getScore());
								buff.setCons(se.getCons());
								f.getBuffs().add(buff);
							}else{
								FightBuff buff = new FightBuff();
								buff.setEffectId(se.getEffectId());
								buff.setScore(se.getScore());
								buff.setCons(se.getCons());
								f.getBuffs().add(buff);
							}
						}
					}
					it.remove();
				}
			}
		}
	}
	
	/**
	 * 初始化角色属性
	 * @param uh
	 * @param hero
	 */
	private void initHeroAttr(int userId, UserHero uh, Hero hero, boolean atk){
		FightModel fm = uh.getModel();
		FightAttr breakFightAttr = heroBreakService.getBreakFightAttr(uh);
		fm.setNpc(false);
		fm.setAssId(uh.getHeroId());
		fm.setState(SystemConstant.FIGHT_MODEL_STATE_正常);
		fm.setAbility(hero.getAbility());
		
		//攻击力
		fm.setAtk(hero.getTotalAtk(uh.getLevel()) + breakFightAttr.getAtk());
		fm.setAtkCount(hero.getAtkCount());
		//血量
		fm.setHp(hero.getTotalHp(uh.getLevel()) + breakFightAttr.getHp());
		fm.setMaxHp(fm.getHp());
		fm.setBaseHp(fm.getHp());
		//暴击率
		fm.setCritRate((hero.getCritRate() + breakFightAttr.getCritRate())/SystemConstant.PERCENT_BASE_DOUBLE);
		//暴击伤害
		fm.setCrithurt((hero.getCritHit() + breakFightAttr.getCritHit())/SystemConstant.PERCENT_BASE_DOUBLE);
		//闪躲率
		fm.setDodgeRate((hero.getDodgeRate() + breakFightAttr.getDodgeRate())/SystemConstant.PERCENT_BASE_DOUBLE);
		fm.setEle(hero.getEle());
		fm.setEleLv(uh.getEleLevel());
		fm.setCatapult(hero.getCatapult());
		fm.setBlockRate(hero.getBlockRate());
		fm.setBlockHit(hero.getBlockHit()/SystemConstant.PERCENT_BASE_DOUBLE);
		
		fm.setAtkMode(new LinkedList<FightAtkMode>());
		fm.setGridCoors(new ArrayList<Point>());
		fm.setBuffs(new ArrayList<FightBuff>());
		fm.setQuality(hero.getQuality());

		FightAtkMode fam = new FightAtkMode();
		if(atk){
			fam.setAtkMode(hero.getAtkMode());
			fam.setMoveMode(hero.getMoveMode());
		}else{
			fam.setAtkMode(Hero.getDetAtkModel(hero.getAtkMode()));
			fam.setMoveMode(Hero.getDetAtkModel(hero.getMoveMode()));
		}
		fam.setId(1);
		fm.getAtkMode().add(fam);
		if(hero.getSkillId()!=0){
			FightSkill fs = new FightSkill();
			fs.setSkillId(hero.getSkillId());
			fs.setSkillLv(uh.getSkillLevel());
			fs.setShotUserId(userId);
			if(!atk){
				fs.setCurrRound(-1);
			}
			fam.setSkill(fs);
		}
	}
	
	/**
	 * 初始化伙伴buff
	 */
	private void initHeroBuffs(UserHero uh, Hero hero, FightAtkMode fam){
		if(uh.getUserId() > 0){
			initHeroEquipBuffs(uh);
			initHeroEternalBuffs(uh, hero, fam);
		}
	}
	
	
	/**
	 * 初始化武魂BUFF
	 * @param uh
	 */
	private void initHeroEternalBuffs(UserHero uh, Hero hero, FightAtkMode fam){
		FightModel fm = uh.getModel();
		int skillNum = execEternal(uh, hero, fm, fam);
		fm.setSkillNum(fm.getSkillNum() + skillNum);
	}
	
	/**
	 * 初始化伙伴装备BUFF
	 * @param uh
	 */
	private void initHeroEquipBuffs(UserHero uh){
		FightModel fm = uh.getModel();
		User user = userService.getUser(uh.getUserId());
		Set<UserEquipment> equs = userEquipmentService.getUserEquipmentByHero(user, uh.getId());
		//初始化装备属性
		if(!equs.isEmpty()){
			double equiHp = 0;
			double equiAtk = 0;
			for(UserEquipment eq : equs){
				Equipment e = GameCache.getEquipment(eq.getEquipmentId());
				equiHp += (e.getHp()+(eq.getLevel()-1)*e.getHpUp()) * (1 + eq.getAddAtk()/SystemConstant.PERCENT_BASE_DOUBLE);
				equiAtk +=(e.getAtk()+(eq.getLevel()-1)*e.getAtkUp()) * (1 + eq.getAddAtk()/SystemConstant.PERCENT_BASE_DOUBLE);
				if(!eq.getSkills().isEmpty()){ //附加属性技能
					addEquipmentProperty(fm,eq.getSkillList());
					fm.setSkillNum(fm.getSkillNum() + eq.getSkillList().size());
				}
			}
			if(equiHp != 0){
				FightBuff fb=new FightBuff();
				fb.setType(SystemConstant.SKILL_EFFECT_TYPE_EQUIP);
				fb.setEffectId(SystemConstant.SKILL_EFFECT_ID_血量上限);
				fb.setScore((int)equiHp);
				fm.getBuffs().add(fb);
			}
			if(equiAtk != 0){
				FightBuff fb=new FightBuff();
				fb.setType(SystemConstant.SKILL_EFFECT_TYPE_EQUIP);
				fb.setEffectId(SystemConstant.SKILL_EFFECT_ID_攻击变更);
				fb.setScore((int)equiAtk);
				fm.getBuffs().add(fb);
			}
		}
	}
	
	/**
	 * 初始化装备附加属性技能
	 * @param fm
	 * @param skills
	 */
	private void addEquipmentProperty(FightModel fm, List<EquipmentSkill> skills){
		FightBuff fb=null;
		for (EquipmentSkill es:skills) {
			switch (es.getEquipmentSkillId()) {
			case SystemConstant.EQUIPMENT_PROPERTY_SKILLTYPE_增加攻击力:
				fb=new FightBuff();
				fb.setEffectId(SystemConstant.SKILL_EFFECT_ID_攻击变更);
				fb.setScore((int)(es.getSkillValue()*SystemConstant.PERCENT_BASE_DOUBLE));
				fm.getBuffs().add(fb);
				break;
			case SystemConstant.EQUIPMENT_PROPERTY_SKILLTYPE_增加血上限:
				fb=new FightBuff();
				fb.setEffectId(SystemConstant.SKILL_EFFECT_ID_血量上限);
				fb.setScore((int)(es.getSkillValue()*SystemConstant.PERCENT_BASE_DOUBLE));
				fm.getBuffs().add(fb);
				break;
			case SystemConstant.EQUIPMENT_PROPERTY_SKILLTYPE_格挡率:
				 fb=new FightBuff();
				 fb.setEffectId(SystemConstant.SKILL_EFFECT_ID_格挡率);
				 fb.setScore((int)(es.getSkillValue()*SystemConstant.PERCENT_BASE_DOUBLE));
				 fm.getBuffs().add(fb);	
				break;
			case SystemConstant.EQUIPMENT_PROPERTY_SKILLTYPE_格挡伤害:
				 fb=new FightBuff();
				 fb.setEffectId(SystemConstant.SKILL_EFFECT_ID_格挡伤害);
				 fb.setScore((int)(es.getSkillValue()*SystemConstant.PERCENT_BASE_DOUBLE));
				 fm.getBuffs().add(fb);	
				break;
			case SystemConstant.EQUIPMENT_PROPERTY_SKILLTYPE_增加暴击率:	
				 fb=new FightBuff();
				 fb.setEffectId(SystemConstant.SKILL_EFFECT_ID_暴击率变更);
				 fb.setScore((int)(es.getSkillValue()*SystemConstant.PERCENT_BASE_DOUBLE));
				 fm.getBuffs().add(fb);
				break;
			case SystemConstant.EQUIPMENT_PROPERTY_SKILLTYPE_暴击伤害:
				 fb=new FightBuff();
				 fb.setEffectId(SystemConstant.SKILL_EFFECT_ID_暴击伤害变更);
				 fb.setScore((int)(es.getSkillValue()*SystemConstant.PERCENT_BASE_DOUBLE));
				 fm.getBuffs().add(fb);
				break;
			case SystemConstant.EQUIPMENT_PROPERTY_SKILLTYPE_增加闪避率:	
				 fb=new FightBuff();
				 fb.setEffectId(SystemConstant.SKILL_EFFECT_ID_闪避率变更);
				 fb.setScore((int)(es.getSkillValue()*SystemConstant.PERCENT_BASE_DOUBLE));
				 fm.getBuffs().add(fb);
				break;
			default:
				break;
			}
		}	
		
	}
	//初始化武魂属性
	private int execEternal(UserHero uh, Hero hero, FightModel fm,
			FightAtkMode fam) {
		UserEternal ue = userEternalDAO.queryUserEternal(uh.getEternal(), uh.getUserId());
		int skillNum = fm.getSkillNum();
		if(ue!=null){
			Eternal eternal=GameCache.getEternal(ue.getEternalId());
			if(eternal.getSkillId()>0){
				FightSkill fs = new FightSkill();
				fs.setSkillId(eternal.getSkillId());
				fs.setSkillLv(1);
				fs.setCurrRound(1000);
				fm.getPassiveSkills().add(fs); //武魂的被动技能
				skillNum += 1;
			}
			FightBuff buff = null;
			FightBuff nbuff = null;
			if(!ue.getPropertySkills().isEmpty()){
				skillNum += ue.getPropertySkillList().size();
				for (EternalSkill sk:ue.getPropertySkillList()) {
					switch (sk.getEternalSkillId()) {
					case SystemConstant.ETERNAL_PROPERTY_EFFECT_TYPE_增加攻击值:
						fm.setAtk(fm.getAtk()+(int)sk.getSkillValue());
						break;
					case SystemConstant.ETERNAL_PROPERTY_EFFECT_TYPE_增加生命值:
						fm.setBaseHp((int) (fm.getBaseHp()+sk.getSkillValue()));
						break;
					case SystemConstant.ETERNAL_PROPERTY_EFFECT_TYPE_增加装备生命值得百分比:
						buff = fm.getFightBuff(SystemConstant.SKILL_EFFECT_TYPE_EQUIP, SystemConstant.SKILL_EFFECT_ID_血量上限);
						if(buff != null){
							nbuff = new FightBuff();
							nbuff.setEffectId(SystemConstant.SKILL_EFFECT_ID_血量上限);
							nbuff.setScore((int)(buff.getScore() * sk.getSkillValue()));
							nbuff.setRound(0);
							fm.getBuffs().add(nbuff);
						}
						break;
					case SystemConstant.ETERNAL_PROPERTY_EFFECT_TYPE_增加装备攻击力百分比:
						buff = fm.getFightBuff(SystemConstant.SKILL_EFFECT_TYPE_EQUIP, SystemConstant.SKILL_EFFECT_ID_攻击变更);
						if(buff != null){
							nbuff = new FightBuff();
							nbuff.setEffectId(SystemConstant.SKILL_EFFECT_ID_攻击变更);
							nbuff.setScore((int)(buff.getScore() * sk.getSkillValue()));
							nbuff.setRound(0);
							fm.getBuffs().add(nbuff);
						}
						break;
					case SystemConstant.ETERNAL_PROPERTY_EFFECT_TYPE_增加左上方攻击方向:
					case SystemConstant.ETERNAL_PROPERTY_EFFECT_TYPE_增加右上方攻击方向:
					case SystemConstant.ETERNAL_PROPERTY_EFFECT_TYPE_增加右方攻击方向:
					case SystemConstant.ETERNAL_PROPERTY_EFFECT_TYPE_增加右下方攻击方向:
					case SystemConstant.ETERNAL_PROPERTY_EFFECT_TYPE_增加左下方攻击方向:
					case SystemConstant.ETERNAL_PROPERTY_EFFECT_TYPE_增加左方攻击方向:
						StringBuilder sb = new StringBuilder(fm.getAtkMode().peek().getAtkMode());
						if(sb.charAt(sk.getEternalSkillId() - SystemConstant.ETERNAL_PROPERTY_EFFECT_TYPE_增加左上方攻击方向) == SystemConstant.FIGHT_MODE_不能移动){
							sb.setCharAt(sk.getEternalSkillId() - SystemConstant.ETERNAL_PROPERTY_EFFECT_TYPE_增加左上方攻击方向 , SystemConstant.FIGHT_MODE_移动一格);
						}
						fm.getAtkMode().peek().setAtkMode(sb.toString());
						break;
					case SystemConstant.ETERNAL_PROPERTY_EFFECT_TYPE_增加移动范围:
						StringBuilder newMoveMode = new StringBuilder();
						for(int i=0;i<fm.getMoveMode().length();i++){
							char c = (char) (fam.getMoveMode().charAt(i)+sk.getSkillValue());
							newMoveMode.append(c);
						}
						fam.setMoveMode(newMoveMode.toString());
						break;
					default:
						fm.getPropertySkills().add(sk);
						break;
					}
				}
				
			}
		}
		return skillNum;
	}
	@Override
	public Battle startZoneFight(int userId, int battleId) {
		User user = userService.getOnlineUser(userId);
//		UserRule rule = GameCache.getUserRule(user.getLevel());
//		if (user.getHeroExpPool() >= rule.getExpPool() + user.getAddExpPool()) {
//			throw new GameException(GameException.CODE_伙伴经验池已满, "伙伴经验池已满");
//		}
		Battle battle = createBattle(userId, 0, SystemConstant.FIGHT_TYPE_ZONE, null, SystemConstant.FIGHT_AI_MONSTER_AI,battleId,0,"",null);
		UserTeam userTeam = userTeamService.queryUserTeam(userId);
		
		initHeros(battle, userTeam,true,user);
		initMonsters(battleId, 1,battle);
		
		battle.setBuffs(new ArrayList<UserBuff>());
		List<UserBuff> buffs = userBuffService.gainUserBuffs(userId);
		for(UserBuff ub : buffs){
			switch (ub.getEffectId()) {
			case SystemConstant.PROP_EFFECT_ID_经验加成:
			case SystemConstant.PROP_EFFECT_ID_金钱加成:
				ub.setCd(ub.getCd()-1);
				battle.getBuffs().add(ub);
				if(ub.getCd()<=0){
					userBuffDAO.deleteUserBuff(userId, ub.getEffectId());
				}else{
					userBuffDAO.updateUserBuff(ub);
				}
				break;
			default:
				break;
			}
		}
		
		return battle;
	}
	
	private void initMonsters(int battleId, int roundId,Battle battle) {
		int fightId = 100;
		BattleRound battleRound = GameCache.getBattleRound(battleId, roundId);
		int i=0;
		for(int monsterId : battleRound.getMonsters()){
			if(monsterId == 0){
				i++;
				continue;
			}
			FightModel fm = createMonsterModel(battle.getDefenderUserId(), fightId, monsterId);
			Point p=createDefPos(i);
			i++;
			Grid grid = battle.getGrids().get(p);
			grid.setFightId(fightId);
			fm.getGridCoors().add(p);
			battle.getDefenders().add(fm);
			
			fightId++;
		}
		
		List<Grid> canUseGrid = new ArrayList<Grid>();
		for(Grid g : battle.getGrids().values()){
			if(g.getGridItem() == 0 && g.getFightId() == 0){
				canUseGrid.add(g);
			}
		}
		ZoneBattle zoneBattle = GameCache.getZoneBattle(battle.getZoneBattleId());
		int random = (int) (Math.random() * SystemConstant.PERCENT_BASE_DOUBLE);
		if(zoneBattle.getSlateRate()>random){
			if(canUseGrid.size() > 0){
				Grid g = canUseGrid.get((int) (Math.random()*canUseGrid.size()));
				g.setGridItem(SystemConstant.FIGHT_GRID_ITEM_石板);
				canUseGrid.remove(g);
			}
		}
		
		
		for(FightModel fm : battle.getDefenders()){
			Iterator<FightSkill> it = fm.getPassiveSkills().iterator();
			while(it.hasNext()){
				FightSkill fs = it.next();
				PassiveSkill ps = GameCache.getPassiveSkill(fs.getSkillId());
				if(ps==null){
					throw new GameException(GameException.CODE_参数错误, "not skillId:"+fs.getSkillId());	
				}
				if(ps.getTakeEffect().get(0)==7){
					for(SkillEffect se : ps.getEffects()){
						List<FightModel> fms = Skill.gainImpactModel(battle.getDefenders(), null, fm, se, false, fm);
						for(FightModel f : fms){
							if(se.getEffectId() == SystemConstant.SKILL_EFFECT_ID_生命变更){
								fm.setMaxHp(fm.getMaxHp()+(int) (fm.getBaseHp()*se.getScore()/SystemConstant.PERCENT_BASE_DOUBLE));
								fm.setMaxHp(fm.getMaxHp()+se.getCons());
								fm.setHp(fm.getMaxHp());
							}else{
								FightBuff buff = new FightBuff();
								buff.setEffectId(se.getEffectId());
								buff.setScore(se.getScore());
								buff.setCons(se.getCons());
								buff.setShotUserId(battle.getDefenderUserId());
								f.getBuffs().add(buff);
							}
						}
					}
					it.remove();
				}
			}
		}
		
	}
	@Override
	public FightResultVO gainFightAward(int userId) {  
		User user = userService.getOnlineUser(userId);
		Battle battle = fightDAO.getBattle(user.getFightId());
		if(battle == null){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		if(battle.getBattleType() != SystemConstant.FIGHT_TYPE_ZONE){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		for(FightModel fm : battle.getDefenders()){
			if(fm.getState() == SystemConstant.FIGHT_MODEL_STATE_正常){
				throw new GameException(GameException.CODE_参数错误, "");
			}
		}
		
		BattleRound nextRound = GameCache.getBattleRound(battle.getZoneBattleId(), battle.getBattleRoundId()+1);
		if(nextRound!=null){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		
		ZoneBattle zoneBattle = GameCache.getZoneBattle(battle.getZoneBattleId());
		ActivityZone az = GameCache.getActivityZone(zoneBattle.getZoneId());
		
		userService.checkStamina(user);
		effectService.delIncome(user, SystemConstant.ITEM_EFFECT_TYPE_STAMINA, 0, zoneBattle.getSp(), SystemConstant.LOGGER_APPROACH_战斗消耗);
		if(az!=null){
			if(az.getNum()>0){
				UserStat stat = userService.getUserStat(userId);
				AssStat as = null;
				for(AssStat a : stat.getActivityZoneCountList()){
					if(a.getAssId() == zoneBattle.getZoneId()){
						as = a;
						break;
					}
				}
				if(as==null){
					as = new AssStat();
					as.setAssId(zoneBattle.getZoneId());
					stat.getActivityZoneCountList().add(as);
				}
				as.setNum(as.getNum()+1);
				
				SQLOpt opt = new SQLOpt();
				opt.putFieldOpt(UserStatTable.ACTIVITYZONECOUNT, SQLOpt.EQUAL);
				userService.updateUserStat(stat, opt);
			}
		}
		
		int star = 1;
		if(!battle.isRevive()){
			star=3;
			for(FightModel fm : battle.getAttackers()){
				if(fm.getState()== SystemConstant.FIGHT_MODEL_STATE_死亡){
					star-=1;
				}
			}
			star=star<1?1:star;
		}
		
		UserZoneBattle userZoneBattle = userZoneService.getUserZoneBattle(userId, zoneBattle.getZoneId(), zoneBattle.getBattleId());
		if(userZoneBattle==null){
			userZoneBattle = new UserZoneBattle();
			userZoneBattle.setUserId(userId);
			userZoneBattle.setZoneBattleId(zoneBattle.getBattleId());
			userZoneBattle.setZoneId(zoneBattle.getZoneId());
			userZoneBattle.setLastChallengeTime(new Date());
			
			userZoneService.addUserZoneBattle(userZoneBattle);
		}
		if(DateUtil.isBeforeToDay(userZoneBattle.getLastChallengeTime())){
			userZoneBattle.setChallengeCount(0);
		}
		userZoneBattle.setChallengeCount(userZoneBattle.getChallengeCount()+1);
		userZoneBattle.setPassCount(userZoneBattle.getPassCount()+1);
		if(star>userZoneBattle.getStar()){
			userZoneBattle.setStar(star);
		}
		userZoneService.updateUserZoneBattle(userZoneBattle);
		/**处理奖励*/
		ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_副本获得);
		ItemEffects dropEffects = new ItemEffects(SystemConstant.LOGGER_APPROACH_副本掉落);
		int goldAddition = getBattleAddition(battle, SystemConstant.SKILL_EFFECT_ID_金钱增加, SystemConstant.PROP_EFFECT_ID_金钱加成) + 1;
		int expAddition = getBattleAddition(battle, SystemConstant.SKILL_EFFECT_ID_经验增加, SystemConstant.PROP_EFFECT_ID_经验加成) + 1;
		Reward rewards = addFightRewards(effects, userZoneBattle, goldAddition, expAddition);
		Reward drops = addDropRewards(user, battle, battle.getDrops(), dropEffects, new ValidObject(), goldAddition, expAddition);
		effectService.addIncome(user, effects, null);
		effectService.addIncome(user, dropEffects, null);
		
		fightDAO.deleteBattle(user.getFightId());
		Map<String,String> hash = new HashMap<>();
		hash.put(UserTable.J_FIGHTID, "");
		userService.updateUser(user, hash, false);
		Zone zone = GameCache.getZone(zoneBattle.getZoneId());
		if(zone != null){
			if(zone.getType() == SystemConstant.ZONE_TYPE_TRIALS){
				userService.addTrialsCountNumber(user, zoneBattle.getZoneId(), 1);
			}else{
				UserZone userZone = userZoneService.getUserZone(userId,zoneBattle.getZoneId());
				if(userZone == null){
					userZone = new UserZone();
					userZone.setUserId(userId);
					userZone.setZoneId(zone.getZoneId());
					userZone.setZoneType(zone.getType());
					userZone.setGainAwardStarList(new ArrayList<Integer>());
					userZoneService.addUserZone(userZone);
				}
				if(userZone.getCurrBattle() < zoneBattle.getBattleId()){
					userZone.setCurrBattle(zoneBattle.getBattleId());
					userZoneService.updateUserZone(userZone);
				}
			}
		}
		FightResultVO vo = MessageFactory.getMessage(FightResultVO.class);
		vo.setStar(star);
		vo.setRewards(rewards.getItemEffects());
		vo.setDrops(drops.getItemEffects());
		//抛出通过关卡事件
		PassBattleEvent event = PassBattleEvent.valueOf(user, 1, zoneBattle.getBattleId(), 1, zone.getType());
		TimerController.submitGameEvent(event);
		ZoneBattleLogger logger = new ZoneBattleLogger(userId, zone.getZoneId(), battle.getZoneBattleId());
		logger.setState(3);
		logger.setBattleNum(1);
		TimerController.submitGameEvent(new GameLoggerEvent(SystemConstant.LOG_EVENT_TYPE_BATTLE, logger));
		return vo;
	}
	
	/**
	 * 获取战斗加成
	 */
	public int getBattleAddition(Battle battle, int seId, int peId){
		int addition = 0;
		if(battle != null){
			List<FightModel> mlist = battle.getAttackers();
			if(mlist != null){
				for(FightModel fm : mlist){
					FightBuff target = null;
					for(FightBuff buff : fm.getBuffs()){
						if(buff.getEffectId() == seId && buff.getScore() > 0){
							if(target == null || target.getScore() < buff.getScore()){
								target = buff;
							}
						}
					}
					if(target != null){
						addition += target.getScore();
					}
				}
			}
			List<UserBuff> ulist = battle.getBuffs();
			if(ulist != null){
				for(UserBuff buff : battle.getBuffs()){
					if(buff.getEffectId() == seId){
						addition += buff.getVal();
					}
				}
			}
		}
		return addition;
	}
	
	@Override
	public int giveUpFight(final int userId) {
		User user = userService.getOnlineUser(userId);
		final Battle battle = fightDAO.getBattle(user.getFightId());
		if(battle == null){
			throw new GameException(GameException.CODE_战斗已结束, "");
		}
       if(battle.getBattleType() == SystemConstant.FIGHT_TYPE_PVP){  //放弃战斗记录战斗日志
    	   if(!battle.getBattleMessage().containsKey(battle.getAttackUserId())){
    		   SQLOpt opt = new SQLOpt();
    		   Arena arena=arenaDAO.queryMyArena(userId);
    		   arena.setCdTime(new Date(System.currentTimeMillis()+10*60*1000L));
    		   arena.setStreakWin(0);
    		   UserBaseinfo info = userService.getUserBaseInfo(userId);
    		   info.setStreakWin(arena.getStreakWin());
    		   if(arena.getIsFirst()==0){
    			   opt.putFieldOpt(ArenaTable.ISFIRST, SQLOpt.EQUAL);
    			   arena.setIsFirst(1);
    		   }
    		   opt.putFieldOpt(ArenaTable.CDTIME, SQLOpt.EQUAL);
    		   opt.putFieldOpt(ArenaTable.STREAKWIN, SQLOpt.EQUAL);
    		   arenaDAO.updateArena(arena, opt);
    		   userDAO.updateUserBaseinfo(info);
    		   UserStat stat = userService.getUserStat(userId);
    		   stat.setArenaCount(stat.getArenaCount() - 1);
    		   SQLOpt statOpt = new SQLOpt();
    		   statOpt.putFieldOpt(UserStatTable.ARENACOUNT, SQLOpt.EQUAL);
    		   userService.updateUserStat(stat, statOpt);
    		   ArenaLogger al=new ArenaLogger();
    		   int capId=0;
    		   UserBaseinfo defUser=null;
    		   if(battle.getDefenderUserId()>0){
    			   defUser=userService.getUserBaseInfo(battle.getDefenderUserId());
    			   capId=defUser.getHeroId();
    		   }else{
    			   defUser=new UserBaseinfo();
    			   defUser.setUserId(battle.getDefenderUserId());
    			   defUser.setLevel(15);
    			   defUser.setPlayerName("npc"+Math.abs(battle.getDefenderUserId()));
    			   switch (battle.getDefenderUserId()) {
    			   case -1:
    				   //					capId=1001005;  //TODO
    				   capId=82024;
    				   break;
    			   case -2:
    				   //					capId=1001054;
    				   capId=82024;
    				   break;
    			   case -3:
    				   //					capId=1001064;
    				   capId=82028;
    				   break;
    			   default:
    				   break;
    			   }
    		   }
    		   al.setCapId(capId);
    		   al.setUserName(user.getPlayerName());
    		   al.setUserId(userId);
    		   al.setMatchLevel(defUser.getLevel());
    		   al.setMatchUserId(defUser.getUserId());
    		   al.setMatchUserName(defUser.getPlayerName());
    		   al.setType(SystemConstant.ARENA_LOGGER_TYPE_竞技场);
    		   al.setWinLos(0);
    		   arenaService.addArenaLogger(al);
    	   }
			fightDAO.deleteBattle(user.getFightId());
			Map<String,String> hash = new HashMap<>();
			hash.put(UserTable.J_FIGHTID, "");
			if(battle.getAttackUserId()!=0){
				userService.updateUser(user, hash, false);
			}
		}
		if(battle.isOnlineFight()){
			
			if(battle.getBattleType() == SystemConstant.FIGHT_TYPE_MARTIAL_WAY){
				martialWayFinish(battle, null, userId);
			}
			
			GameEvent event = new GameEvent() {
				@Override
				public void runEvent() throws Exception {
					WorldFightAction action = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, WorldFightAction.class);
					action.giveUpFight(battle.getBattleId(), userId);
				}
			};
			
			TimerController.submitGameEvent(event);
			
			return 0;
		}else{
			if(!battle.isEnd()){
				ZoneBattle zbat = GameCache.getZoneBattle(battle.getZoneBattleId());
				if(zbat != null){
					ZoneBattleLogger logger = new ZoneBattleLogger(userId, zbat.getZoneId(), battle.getZoneBattleId());
					logger.setState(2);
					TimerController.submitGameEvent(new GameLoggerEvent(SystemConstant.LOG_EVENT_TYPE_BATTLE, logger));
				}
			}
			fightDAO.deleteBattle(user.getFightId());
			Map<String,String> hash = new HashMap<>();
			hash.put(UserTable.J_FIGHTID, "");
			if(battle.getAttackUserId()!=0){
				userService.updateUser(user, hash, false);
			}
		}
		
		return userId;
	}
	@Override
	public FightVO gainFight(int userId) {
		User user = userService.getOnlineUser(userId);
		Battle battle = fightDAO.getBattle(user.getFightId());
		if(battle==null || battle.getBattleMessage().containsKey(battle.getAttackUserId())){
			user.setFightId("");
			Map<String,String> hash = new HashMap<>();
			hash.put(UserTable.J_FIGHTID, "");
//			userDAO.updateUserCache(userId, hash);
			userService.updateUser(user, hash, false);
			return null;
		}
		
		if(battle.isOnlineFight()){
			if(battle.isEnd()&&battle.getBattleMessage().size()==0){
					user.setFightId("");
					Map<String,String> hash = new HashMap<>();
					hash.put(UserTable.J_FIGHTID, "");
//					userDAO.updateUserCache(userId, hash);
					userService.updateUser(user, hash, false);
					fightDAO.deleteBattle(battle.getBattleId());
					return null;
			}
			if(!(battle.isEnd()&&battle.getBattleMessage().size()!=0)){
				WorldFightAction action = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, WorldFightAction.class);
				if(!action.ready(battle.getBattleId(),userId)){
					user.setFightId("");
					Map<String,String> hash = new HashMap<>();
					hash.put(UserTable.J_FIGHTID, "");
//					userDAO.updateUserCache(userId, hash);
					userService.updateUser(user, hash, false);
					fightDAO.deleteBattle(battle.getBattleId());
					return null;
				}
			}
		}
		
		FightVO vo = MessageFactory.getMessage(FightVO.class);
		vo.init(battle);
		return vo;
	}
	@Override
	public AttackRoundVO releaseSkill(int userId, int fightId) {
		User user = userService.getOnlineUser(userId);
		Battle battle = fightDAO.getBattle(user.getFightId());
		if(battle == null){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		if(userId != battle.getShotUserId()){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		List<FightModel> attackers = null;//攻击方
		List<FightModel> defenders = null;//防守方
		if(battle.getShotUserId() == battle.getAttackUserId()){
			attackers = battle.getAttackers();
			defenders = battle.getDefenders();
		}else{
			defenders = battle.getAttackers();
			attackers = battle.getDefenders();
		}
		
		FightModel releaseModel = null;
		for(FightModel fm : attackers){
			if(fm.getFightId() == fightId){
				releaseModel = fm;
				break;
			}
		}
		
		if(releaseModel == null){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		if(!checkSkillRelease(releaseModel)){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		
		FightAtkMode atkModel = releaseModel.getAtkMode().peek();
		
		Skill skill = GameCache.getSkill(atkModel.getSkill().getSkillId(), atkModel.getSkill().getSkillLv());
		boolean left = false;
		atkModel.getSkill().setCurrRound(-1);
		AttackRoundVO round = AttackRoundVO.create();
		round.setNextShotUserId(battle.getShotUserId());
		if(skill.isDelay()){
			releaseModel.setReadySkill(true);
			ReleaseSkillVO rsVO = ReleaseSkillVO.create();
			rsVO.setFightId(fightId);
			rsVO.setSkillLevel(skill.getLv());
			rsVO.setSkillId(skill.getSkillId());
			rsVO.setType(1);
			rsVO.setAtk(releaseModel.getAtk());
			round.getRelSkill().add(rsVO);
		}else{
			round.getRelSkill().add(releaseSkill(attackers, defenders, releaseModel, atkModel.getSkill(), skill,battle,round,null));
			
			if(battle.isEnd()){//结束战斗
				left = true;
				finishFightRound(battle,round);
			}
			
		}
		fightDAO.updateBattle(battle);
		if(battle.isOnlineFight()){
			WorldFightAction action = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, WorldFightAction.class);
			List<Integer> userIds = new ArrayList<Integer>();
			if(battle.getAttackUserId()!=0){
				userIds.add(battle.getAttackUserId());
			}
			if(battle.getDefenderUserId()!=0){
				userIds.add(battle.getDefenderUserId());
			}
			
			Head head = MessageFactory.getMessage(Head.class);
			head.init(MainCMD.FIGHT, FightCMD.RELEASE_SKILL);
			action.onlineFightAction(battle.getBattleId(), battle.getShotUserId(), head, round, left);
			return null;
		}else{
			return round;
		}
		
	}
	/**
	 * 检查技能是否能释放
	 * @param releaseModel 释放者
	 * @return true为能释放
	 */
	private boolean checkSkillRelease(FightModel releaseModel) {
		
		FightAtkMode atkModel = releaseModel.getAtkMode().peek();
		if(atkModel.getSkill() == null){
			return false;
		}
		Skill skill = GameCache.getSkill(atkModel.getSkill().getSkillId(), atkModel.getSkill().getSkillLv());
		
		if(skill.getCd()>atkModel.getSkill().getCurrRound()){
			return false;
		}
		
		if(releaseModel.getState() != SystemConstant.FIGHT_MODEL_STATE_正常){
			return false;
		}
		return canReleaseSkill(releaseModel);
	}
	/**
	 * 是不是能释放技能
	 * @param releaseModel
	 * @return
	 */
	private boolean canReleaseSkill(FightModel releaseModel) {
		for(FightBuff buff : releaseModel.getBuffs()){
			if(buff.getEffectId() == SystemConstant.SKILL_EFFECT_ID_沉默){
				return false;
			}
			if(buff.getEffectId() == SystemConstant.SKILL_EFFECT_ID_眩晕){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 释放技能
	 * @param attackers 攻击方
	 * @param defenders 防守方
	 * @param releaseModel 释放者
	 */
	private ReleaseSkillVO releaseSkill( List<FightModel> attackers,
			List<FightModel> defenders, FightModel releaseModel,FightSkill fs, AbstractSkill skill, Battle battle,AttackRoundVO round,FightModel tarFm) {
		fs.release(battle.getShotUserId());
		boolean attack = battle.getBattleType() == SystemConstant.FIGHT_TYPE_ZONE?true:battle.getShotUserId()==battle.getAttackUserId();
		
		ReleaseSkillVO rsVO = MessageFactory.getMessage(ReleaseSkillVO.class);
		rsVO.setSkillLevel(skill.getLv());
		rsVO.setSkillId(skill.getSkillId());
		rsVO.setFightId(releaseModel.getFightId());
		rsVO.setAffs(new ArrayList<AffectederVO>());
		rsVO.setAtk(releaseModel.getAtk());
		String uuid = UUID.randomUUID().toString();
		for(SkillEffect e : skill.getEffects()){
			List<FightModel> fms = Skill.gainImpactModel(attackers, defenders,releaseModel, e,attack,tarFm);
			switch (e.getEffectId()) {
			case SystemConstant.SKILL_EFFECT_ID_即时伤害:
				execHurtEffect(battle, releaseModel, round, fms, rsVO, e, uuid);
				break;
			case SystemConstant.SKILL_EFFECT_ID_即时恢复:
				execAddHpEffect(battle, fms, rsVO, e, uuid);
				break;
			case SystemConstant.SKILL_EFFECT_ID_护盾:
				execShieldWallEffect(battle, releaseModel, fms, rsVO, e, uuid);
				break;
			case SystemConstant.SKILL_EFFECT_ID_持续伤害:
				execIndirectHurtEffect(battle, releaseModel, fms, rsVO, e, uuid);
				break;
			case SystemConstant.SKILL_EFFECT_ID_攻击变更:
			case SystemConstant.SKILL_EFFECT_ID_暴击率变更:
			case SystemConstant.SKILL_EFFECT_ID_闪避率变更:
			case SystemConstant.SKILL_EFFECT_ID_移动力提升:
			case SystemConstant.SKILL_EFFECT_ID_飞行:
			case SystemConstant.SKILL_EFFECT_ID_减伤:
			case SystemConstant.SKILL_EFFECT_ID_攻击次数变更:
			case SystemConstant.SKILL_EFFECT_ID_持续恢复:
			case SystemConstant.SKILL_EFFECT_ID_攻击范围提升:
			case SystemConstant.SKILL_EFFECT_ID_缴械:
			case SystemConstant.SKILL_EFFECT_ID_沉默:
			case SystemConstant.SKILL_EFFECT_ID_眩晕:
			case SystemConstant.SKILL_EFFECT_ID_格挡效果变更:
			case SystemConstant.SKILL_EFFECT_ID_造成伤害变更:
			case SystemConstant.SKILL_EFFECT_ID_弹射:
			case SystemConstant.SKILL_EFFECT_ID_穿透弹射:
			case SystemConstant.SKILL_EFFECT_ID_道具效果扩散:
			case SystemConstant.SKILL_EFFECT_ID_溅射:
			case SystemConstant.SKILL_EFFECT_ID_暴击伤害变更:
			case SystemConstant.SKILL_EFFECT_ID_生命变更:
			case SystemConstant.SKILL_EFFECT_ID_格挡率变更:
			case SystemConstant.SKILL_EFFECT_ID_穿刺:
				execBuffEffect(battle, fms, rsVO, e, uuid);
				break;
			case SystemConstant.SKILL_EFFECT_ID_击退:
				execFendOff(battle, releaseModel, fms, rsVO, e, uuid);
				break;
			default:
				break;
			}
		}
//		round.getRelSkill().add(rsVO);
		return rsVO;
	}
	/**
	 * 处理间接伤害效果
	 * @param releaseModel
	 * @param fms
	 * @param rsVO
	 * @param e
	 */
	private void execIndirectHurtEffect(Battle battle, FightModel releaseModel,
			List<FightModel> fms, ReleaseSkillVO rsVO, SkillEffect e, String uuid) {
		FightBuff buf = new FightBuff();
		buf.setId(e.getId());
		buf.setEffectId(e.getEffectId());
		buf.setCons((int) (e.getCons()+releaseModel.getRealAtk()*e.getScore()/SystemConstant.PERCENT_BASE_DOUBLE));
		buf.setRound(e.getRound());
		buf.setState(e.getState());
		
		for(FightModel fm : fms){
			if(fm.getHp() <= 0){
				continue;
			}
			addBuff(battle, buf, fm, "");
//			if(addBuff(battle, buf, fm, "")){
			
				AffectederVO affVO = AffectederVO.create();
				affVO.setFightId(fm.getFightId());
				affVO.setSurHp(fm.getHp());
				
				FightBuffVO fbVO = MessageFactory.getMessage(FightBuffVO.class);
				fbVO.init(buf);
				
				affVO.setBuff(fbVO);
				
				rsVO.getAffs().add(affVO);
//			}
		}
	}
	
	/**
	 * 处理盾墙效果
	 * @param releaseModel
	 * @param fms
	 * @param rsVO
	 * @param e
	 */
	private void execShieldWallEffect(Battle battle, FightModel releaseModel,
			List<FightModel> fms, ReleaseSkillVO rsVO, SkillEffect e, String uuid) {
		FightBuff buf = new FightBuff();
		buf.setUuid(uuid);
		buf.setId(e.getId());
		buf.setEffectId(e.getEffectId());
		buf.setCons((int) (e.getCons()+releaseModel.getMaxHp()*e.getScore()/SystemConstant.PERCENT_BASE_DOUBLE));
		buf.setRound(e.getRound());
		for(FightModel fm : fms){
			if(fm.getHp() <= 0){
				continue;
			}
			addBuff(battle, buf, fm, uuid);
//			if(addBuff(battle, buf, fm, uuid)){
			
				AffectederVO affVO = AffectederVO.create();
				affVO.setFightId(fm.getFightId());
				affVO.setSurHp(fm.getHp());
				
				FightBuffVO fbVO = MessageFactory.getMessage(FightBuffVO.class);
				fbVO.init(buf);
				
				affVO.setBuff(fbVO);
				
				rsVO.getAffs().add(affVO);
//			}
		}
	}
	/**
	 * 处理加血效果
	 * @param fms
	 * @param rsVO
	 * @param e
	 */
	private void execAddHpEffect(Battle battle, List<FightModel> fms, ReleaseSkillVO rsVO,
			SkillEffect e, String uuid) {
		for(FightModel fm : fms){
			if(fm.getHp() <= 0){
				continue;
			}
			int recHp = (int) (fm.getMaxHp()*e.getScore()/SystemConstant.PERCENT_BASE_DOUBLE+e.getCons());
			int hp = fm.getHp() + recHp;
			hp=hp>fm.getMaxHp()?fm.getMaxHp():hp;
			fm.setHp(hp);
			
			AffectederVO affVO = AffectederVO.create();
			affVO.setFightId(fm.getFightId());
			affVO.setType(AffectederVO.TYPE_RECOVER);
			affVO.setVal(recHp);
			affVO.setSurHp(fm.getHp());
			
			rsVO.getAffs().add(affVO);
		}
	}
	/**
	 * 处理击退效果
	 * @param releaseModel
	 * @param battle
	 * @param fms
	 * @param rsVO
	 * @param e
	 */
	private void execFendOff(Battle battle, FightModel releaseModel,
			List<FightModel> fms, ReleaseSkillVO rsVO, SkillEffect e, String uuid) {
		for(FightModel fm :fms){
			if(fm.getHp() <= 0){
				continue;
			}
			if(fm.getGridCoors().size()==1){
				int dir = gainDir(fm.getGridCoors().get(0), releaseModel.getGridCoors());
				if(dir != -1){
					Point p = fm.getGridCoors().get(0);
					for(int i=1;i<=e.getCons();i++){
						Point point = null;
						switch (dir) {
						case SystemConstant.FIGHT_ATK_MODE_DIR_左上:
							point = new Point(p.getX()-1, p.getY()-1);
							break;
//						case UserConstant.FIGHT_ATK_MODE_DIR_上:
//							point = new Point(p.getX(), p.getY()-i);
//							break;
						case SystemConstant.FIGHT_ATK_MODE_DIR_右上:
							point = new Point(p.getX()+1, p.getY()-1);
							break;
						case SystemConstant.FIGHT_ATK_MODE_DIR_右:
							point = new Point(p.getX()+2, p.getY());
							break;
						case SystemConstant.FIGHT_ATK_MODE_DIR_右下:
							point = new Point(p.getX()+1, p.getY()+1);
							break;
//						case UserConstant.FIGHT_ATK_MODE_DIR_下:
//							point = new Point(p.getX(), p.getY()+i);
//							break;
						case SystemConstant.FIGHT_ATK_MODE_DIR_左下:
							point = new Point(p.getX()-1, p.getY()+1);
							break;
						case SystemConstant.FIGHT_ATK_MODE_DIR_左:
							point = new Point(p.getX()-2, p.getY());
							break;
						default:
							break;
						}
						Grid g = battle.getGrids().get(point);
						if(g==null){
							break;
						}
						if(g.getGridItem()!=0||g.getFightId()!=0){
							break;
						}
						p=point;
					}
					if(!p.equals(fm.getGridCoors().get(0))){
						for(Point point : fm.getGridCoors()){
							Grid grid = battle.getGrids().get(point);
							grid.setFightId(0);
						}
						Grid grid = battle.getGrids().get(p);
						grid.setFightId(fm.getFightId());
						fm.getGridCoors().clear();
						fm.getGridCoors().add(p);
						
						AffectederVO affVO = AffectederVO.create();
						affVO.setFightId(fm.getFightId());
						affVO.setSurHp(fm.getHp());
						
						PointVO pvo = MessageFactory.getMessage(PointVO.class);
						pvo.init(p);
						affVO.getCoors().add(pvo);
						
						rsVO.getAffs().add(affVO);
					}
				}
			}
		}
	}
	/**
	 * 处理buff效果
	 * @param fms
	 * @param rsVO
	 * @param e
	 */
	private void execBuffEffect(Battle battle, List<FightModel> fms, ReleaseSkillVO rsVO,
			SkillEffect e, String uuid) {
		for(FightModel fm : fms){
			if(fm.getState()!= SystemConstant.FIGHT_MODEL_STATE_正常){
				continue;
			}
			if(immuneDebuff(fm)){
				if(e.getEffectId() == SystemConstant.SKILL_EFFECT_ID_持续伤害||
						((e.getEffectId() == SystemConstant.SKILL_EFFECT_ID_攻击变更)&&(e.getCons()<0||e.getScore()<0))||
						(e.getEffectId() == SystemConstant.SKILL_EFFECT_ID_攻击次数变更&&(e.getCons()<0||e.getScore()<0))||
						e.getEffectId() == SystemConstant.SKILL_EFFECT_ID_沉默||
						e.getEffectId() == SystemConstant.SKILL_EFFECT_ID_眩晕||
						((e.getEffectId() == SystemConstant.SKILL_EFFECT_ID_暴击率变更)&&(e.getCons()<0||e.getScore()<0))||
						((e.getEffectId() == SystemConstant.SKILL_EFFECT_ID_闪避率变更)&&(e.getCons()<0||e.getScore()<0))||
						((e.getEffectId() == SystemConstant.SKILL_EFFECT_ID_移动力提升)&&(e.getCons()<0||e.getScore()<0))||
						((e.getEffectId() == SystemConstant.SKILL_EFFECT_ID_格挡效果变更)&&(e.getCons()<0||e.getScore()<0))||
						((e.getEffectId() == SystemConstant.SKILL_EFFECT_ID_造成伤害变更)&&(e.getCons()<0||e.getScore()<0))||
						((e.getEffectId() == SystemConstant.SKILL_EFFECT_ID_暴击伤害变更)&&(e.getCons()<0||e.getScore()<0))||
						((e.getEffectId() == SystemConstant.SKILL_EFFECT_ID_格挡率变更)&&(e.getCons()<0||e.getScore()<0))
						){
					continue;
				}
			}
			FightBuff buff = new FightBuff();
			buff.setUuid(uuid);
			buff.setId(e.getId());
			buff.setEffectId(e.getEffectId());
			buff.setCons(e.getCons());
			buff.setScore(e.getScore());
			buff.setRound(e.getRound());
			buff.setState(e.getState());
			
			addBuff(battle, buff, fm, uuid);
//			if(addBuff(battle, buff, fm, uuid)){
			
				AffectederVO affVO = AffectederVO.create();
				affVO.setFightId(fm.getFightId());
				affVO.setSurHp(fm.getHp());
				
				FightBuffVO fbVO = MessageFactory.getMessage(FightBuffVO.class);
				fbVO.init(buff);
				
				affVO.setBuff(fbVO);
				
				rsVO.getAffs().add(affVO);
//			}
		}
	}
	/**
	 * 处理直接造成伤害效果
	 * @param releaseModel 是否模型
	 * @param battle 战场
	 * @param round 回合
	 * @param fms 受影响的人
	 * @param rsVO 
	 * @param e 效果
	 */
	private void execHurtEffect(Battle battle, FightModel releaseModel,
			AttackRoundVO round, List<FightModel> fms, ReleaseSkillVO rsVO,
			SkillEffect e, String uuid) {
		int resAtk = releaseModel.getRealAtk();
		for(FightModel fm : fms){
			if(fm.getState()!= SystemConstant.FIGHT_MODEL_STATE_正常){
				continue;
			}
			AffectederVO affVO = AffectederVO.create();
			int hurt = (int) (resAtk*e.getScore()/SystemConstant.PERCENT_BASE_DOUBLE+e.getCons());
//			hurt = (int) (hurt*Hero.getRestraint(releaseModel.getEle(), releaseModel.getEleLv(),fm.getEle(), fm.getEleLv()));//属性加成;
			double restraint = Hero.getRestraint(releaseModel.getEle(), releaseModel.getEleLv(),fm.getEle(), fm.getEleLv());
			if(!canRestraint(fm)){
				restraint=restraint>1?1:restraint;
			}
			hurt = (int) (hurt*restraint);
			hurt = calReduceHurt(hurt,fm,releaseModel, null, affVO, null, null);//计算减少伤害
			if(immuneSkillHurt(fm)){
				hurt = 0;
			}
			int absorbHurt = calAbsorb(hurt,fm, null, affVO, null, null);//计算吸收伤害
			hurt -= absorbHurt;
			List<ReleaseSkillVO> vos = buckleBlood(fm, hurt,battle,round,
					battle.getAttackers().indexOf(fm)==-1?battle.getDefenders():battle.getAttackers(),
						battle.getAttackers().indexOf(fm)==-1?battle.getAttackers():battle.getDefenders());
			
			
			affVO.setFightId(fm.getFightId());
			affVO.setType(AffectederVO.TYPE_HURT);
			affVO.setVal(hurt);
			affVO.setSurHp(fm.getHp());
			affVO.setAbsorbHurt(absorbHurt);
			affVO.getRelSkill().addAll(vos);
			if(fm.getHp()<=0){
				execDeadFightModel(battle, round, fm);
				if(battle.getBattleType() == SystemConstant.FIGHT_TYPE_ZONE){
					if(fm.isNpc()){
						List<DropVO> drops = gainMonsterDrop(battle, fm);
						affVO.setDrops(drops);
					}
				}
			}
			rsVO.getAffs().add(affVO);
		}
	}
	/**
	 * 获得路径
	 * @param p 要移动到的点
	 * @param fps 当前所在点
	 * @return 方向
	 */
	private int gainDir(Point p,List<Point> fps){
		int dir = -1;
		
		for(int i=0;i<8;i++){
			List<Point> ps = BaseAI.gainDirPoint(fps, i);
			for(Point point : ps){
				List<Point> pos = BaseAI.getFightPointPoint(point, i,1);
				if(pos.size()>0){
					if(p.equals(pos.get(0))){
						return i;
					}
				}
			}
		}
		
		return dir;
	}
	
	/**
	 * 计算减少伤害
	 * @param hurt 伤害
	 * @param def 防守方
	 * @return 最终伤害值
	 */
	private int calReduceHurt(int hurt, FightModel def,FightModel atk, AttackVO avo, AffectederVO afvo, SubHurtVO hvo, FightBuffAffectVO fvo) {
		double score = 0;
		for(FightBuff buff : def.getBuffs()){
			switch (buff.getEffectId()) {
			case SystemConstant.SKILL_EFFECT_ID_GRID_ITEM_减伤:
			case SystemConstant.SKILL_EFFECT_ID_GRID_ITEM_据点:
				score += buff.getScore();
				if(avo != null){
					avo.addAtkEffectId(buff.getEffectId());
				}else if(afvo != null){
					afvo.addAtkEffectId(buff.getEffectId());
				}else if(hvo != null){
					hvo.addAtkEffectId(buff.getEffectId());
				}else if(fvo != null){
					fvo.addAtkEffectId(buff.getEffectId());
				}
				break;
			case SystemConstant.SKILL_EFFECT_ID_减伤:
				if(atk==null){
					if(buff.getCons()==0){
						score += buff.getScore();
					}
				}else if(buff.getCons()==0||atk.getEle() == buff.getCons()){
					score += buff.getScore();
				}
				if(avo != null){
					avo.addAtkEffectId(buff.getEffectId());
				}else if(afvo != null){
					afvo.addAtkEffectId(buff.getEffectId());
				}else if(hvo != null){
					hvo.addAtkEffectId(buff.getEffectId());
				}else if(fvo != null){
					fvo.addAtkEffectId(buff.getEffectId());
				}
				break;
			default:
				break;
			}
		}
		hurt -= (int)(hurt*score/SystemConstant.PERCENT_BASE_DOUBLE);
		return hurt;
	}
	/**
	 * 增加buff
	 * @param buff 要增加的buff
	 * @param fm 增加到的英雄
	 */
	private boolean addBuff(Battle battle, FightBuff buff, FightModel fm, String uuid) {
		Iterator<FightBuff> it = fm.getBuffs().iterator();
		
		int state = buff.getState();
		if(state != SystemConstant.FIGHT_BUFF_STATE_边缘){
			boolean hasStrong = false;
			for(FightBuff fb : fm.getBuffs()){
				if(fb.getState() == SystemConstant.FIGHT_BUFF_STATE_强){
					hasStrong = true;
					break;
				}
			}
			if(hasStrong){
				return false;
			}
			while(it.hasNext()){
				FightBuff fb = it.next();
				if(!uuid.equals(fb.getUuid())){
					switch (state) {
					case SystemConstant.FIGHT_BUFF_STATE_强:
					case SystemConstant.FIGHT_BUFF_STATE_普通:
						if(fb.getState() == SystemConstant.FIGHT_BUFF_STATE_普通){
							fm.execMaxHpBuffRem(buff);
							it.remove();
						}
						break;
					default:
						break;
					}
				}
			}
		}
		buff.setShotUserId(battle.getShotUserId());
		fm.getBuffs().add(buff);
		
		if(buff.getEffectId() == SystemConstant.SKILL_EFFECT_ID_生命变更){
			fm.setMaxHp(fm.getMaxHp()+(int) (fm.getBaseHp()*buff.getScore()/SystemConstant.PERCENT_BASE_DOUBLE));
			fm.setMaxHp(fm.getMaxHp()+buff.getCons());
			fm.setHp(fm.getHp()+(int) (fm.getBaseHp()*buff.getScore()/SystemConstant.PERCENT_BASE_DOUBLE)+buff.getCons());
		}else if(buff.getEffectId() == SystemConstant.SKILL_EFFECT_ID_护盾){
			buff.setCons(buff.getCons() + (int)(fm.getMaxHp()*buff.getScore()/SystemConstant.PERCENT_BASE_DOUBLE));
			buff.setScore(0);
		}
		return true;
	}
	
	@Override
	public Battle startArenaFight(UserTeam attTeam, UserTeam defTeam) {
		Battle battle = createBattle(attTeam.getUserId(), 
				defTeam.getUserId(),
				SystemConstant.FIGHT_TYPE_PVP,
				SystemConstant.FIGHT_AI_MONSTER_AI,
				SystemConstant.FIGHT_AI_MONSTER_AI,0,0,"",null);
		
		initHeros(battle, attTeam,true,userService.getOnlineUser(attTeam.getUserId()));
		initHeros(battle, defTeam,false,userService.getOnlineUser(defTeam.getUserId()));
		return battle;
	}
	private Battle createBattle(int attUserId, int defUserId,int battleType,String attAI,String defAI, int battleId,int maxRound,String mapId,int[][] hands) {
		Battle battle = new Battle();
		battle.setAttackUserId(attUserId);
		battle.setDefenderUserId(defUserId);
		battle.setShotUserId(attUserId);
		battle.setAttackAI(attAI);
		battle.setDefendAI(defAI);
		battle.setWidth(8);
		battle.setHeight(4);
		battle.setMaxRound(maxRound);
		battle.setBattleId(UUID.randomUUID().toString());
		battle.setBattleType(battleType);
		battle.setMapId(mapId);
		
		battle.setZoneBattleId(battleId);
		battle.setBattleRoundId(1);
		
		battle.setAttackers(new ArrayList<FightModel>());
		battle.setDefenders(new ArrayList<FightModel>());
		battle.setGrids(new HashMap<Point, Grid>());
		battle.setDrops(new ArrayList<ItemEffect>());
		
		for(int x=1;x<=battle.getWidth();x++){
			for(int y=1;y<=battle.getHeight();y++){
				int c = y%2==0?1:2;
				Point coor = new Point( (x-1)*2+c,y);
				Grid g = new Grid();
				g.setCoor(coor);
				battle.getGrids().put(coor, g);
			}
		}
		if(hands!=null){
			for(int[] is : hands){
				Point p = new Point(is[0], is[1]);
				Grid g = battle.getGrids().get(p);
				if(g!=null){
					g.setGridItem(is[2]);
				}
			}
		}
		return battle;
	}
	
	
	
	/**
	 * 初始化英雄
	 * @param battle 战场
	 * @param userTeam 用户队伍
	 * @param attack 是否为攻击方
	 * @param user 
	 */
	private void initHeros(Battle battle, UserTeam userTeam,boolean attack, User user){
		FightModel ffm =  null;
		int fightId = attack?1:100;
		PassiveSkill capSkill = null;
		List<FameBuff> fbs = null;
		if(user!=null){
			fbs = GameCache.getFameBuffs(user.getFame());
		}
		for(int i=0;i<4;i++){
			int userHeroId = userTeam.getHeroList().get(i);
			if(userHeroId!=0){
				int pos = userTeam.getPosList().get(i);
				UserHero userHero=null;
				Hero hero =null;
				if(userTeam.getUserId()<0){
					userHero=new UserHero();
					userHero.setEleLevel(1);
					userHero.setHeroId(userHeroId);
					userHero.setLevel(1);
					hero = GameCache.getHero(userHeroId);
				}else{
					userHero = userHeroService.getUserHero(user, userHeroId);
					hero = GameCache.getHero(userHero.getHeroId());
				}
				FightModel fm = createHeroModel(userTeam.getUserId(), fightId, userHero,attack);
				
				fm.setTeamPos(pos);
				if(i==0){
					if(hero.getCapSkillId()!=0){
						capSkill = GameCache.getPassiveSkill(hero.getCapSkillId());
					}
				}
				Point p = null;
				if(attack){
					p = createAtkPos(pos);
					if(pos == 3 && ffm!=null){
						Grid grid = battle.getGrids().get(p);
						grid.setFightId(ffm.getFightId());
						fm.getGridCoors().add(p);
						battle.getAttackers().add(ffm);
						battle.setAttSub(fm);
					}else{
						Grid grid = battle.getGrids().get(p);
						grid.setFightId(fightId);
						fm.getGridCoors().add(p);
						
						battle.getAttackers().add(fm);
					}
				}else{
					p = createDefPos(pos);
					Grid grid = battle.getGrids().get(p);
					grid.setFightId(fightId);
					fm.getGridCoors().add(p);
					
					battle.getDefenders().add(fm);
				}
				fightId++;
			}
		}
		List<FightModel> models;
		if(attack){
			models = battle.getAttackers();
		}else{
			models = battle.getDefenders();
		}
		
		if(battle.getBattleType() != SystemConstant.FIGHT_TYPE_TEST){
			initCalSkill(models, capSkill);
		}
		initFameBuffs(models, fbs);
		dealHeroPermanentPassiveSkills(models, attack);
		for(FightModel fm : models){
			computeFightModelAttr(fm);
		}
	}

	@Override
	public List<AttackRoundVO> execFightAI(Battle battle) {
		List<FightModel> attackers = null;//攻击方
		List<FightModel> defenders = null;//防守方
		if(battle.getShotUserId() == battle.getAttackUserId()){
			attackers = battle.getAttackers();
			defenders = battle.getDefenders();
		}else{
			defenders = battle.getAttackers();
			attackers = battle.getDefenders();
		}
		
		String fightAI = SystemConstant.FIGHT_AI_MONSTER_AI;
		BaseAI ai = Battle.createFightAI(fightAI,attackers, defenders,battle.getGrids());
		MoveVO moveVO = ai.run();
		return move(battle.getShotUserId(), battle, moveVO);
	}
	@Override
	public List<AttackRoundVO> hosting(int userId) {  //TODO 此功能不存在
		User user = userService.getOnlineUser(userId);
//		VIPState vip = GameCache.getVIPState(User.getVIPLevel(user.getChargeDiamond()));
//		if(!vip.isZoneHosting()){
//			throw new GameException(GameException.CODE_参数错误, "");
//		}
		Battle battle = fightDAO.getBattle(user.getFightId());
		if(battle == null){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		List<FightModel> attackers = null;//攻击方
		List<FightModel> defenders = null;//防守方
		if(battle.getShotUserId() == battle.getAttackUserId()){
			attackers = battle.getAttackers();
			defenders = battle.getDefenders();
		}else{
			defenders = battle.getAttackers();
			attackers = battle.getDefenders();
		}
		
		String fightAI = SystemConstant.FIGHT_AI_MONSTER_AI;
		
		List<AttackRoundVO> rounds = new ArrayList<AttackRoundVO>();
		AttackRoundVO round = null;
		boolean releasSkillSign = false;
		for(FightModel atk : attackers){
			if(checkSkillRelease(atk)){
				AttackRoundVO r = AttackRoundVO.create();
				r.setNextShotUserId(battle.getShotUserId());
				
				FightAtkMode atkModel = atk.getAtkMode().peek();
				Skill skill = GameCache.getSkill(atkModel.getSkill().getSkillId(), atkModel.getSkill().getSkillLv());
				
				round = r;
				
				round.getRelSkill().add(releaseSkill(attackers, defenders, atk, atkModel.getSkill(), skill, battle,r,null));
				releasSkillSign = true;
				break;
			}
		}
		if(round == null){
			BaseAI ai = Battle.createFightAI(fightAI,attackers, defenders,battle.getGrids());
			
			MoveVO moveVO = ai.run();
			rounds = move(battle.getShotUserId(), battle, moveVO);
			
			fightDAO.updateBattle(battle);
			return rounds;
		}
		rounds.add(round);
		round = endFighting(battle,round);
		if(!releasSkillSign){
			while(round!=null){
				rounds.add(round);
				round = endFighting(battle,round);
			}
		}
		
		fightDAO.updateBattle(battle);
//		if(releasSkillSign){//回调release_skill接口
//			MessageUpdateEvent event = new MessageUpdateEvent(userId, MainCMD.FIGHT, FightCMD.RELEASE_SKILL, rounds.get(0));
//			TimerController.submitGameEvent(event);
//		}else{
			return rounds;
//		}
//		return new ArrayList<AttackRoundVO>();
	}
	
	
	
	@Override
	public Battle startOnlinePVPFight(int attUserId, int defUserId,int battleType,int maxRound) {
		
		User attUser = userService.getOnlineUser(attUserId);
		User defUser = userService.getOnlineUser(defUserId);
		
		if(!"".equals(attUser.getFightId())&&attUser.getFightId()!=null){
			fightDAO.deleteBattle(attUser.getFightId());
		}
		if(!"".equals(defUser.getFightId())&&defUser.getFightId()!=null){
			fightDAO.deleteBattle(defUser.getFightId());
		}
		if(battleType == SystemConstant.FIGHT_TYPE_MARTIAL_WAY){
			UserStat stat = userService.getUserStat(defUserId);
			if(!stat.hasMartialWayNum()){
				throw new GameException(GameException.CODE_对方挑战次数不足, "");
			}
			stat = userService.getUserStat(attUserId);
			if(!stat.hasMartialWayNum()){
				throw new GameException(GameException.CODE_挑战次数不足, "");
			}
		}
		UserTeam attTeam=userTeamService.queryUserTeam(attUserId);
		UserTeam defTeam = userTeamService.queryUserTeam(defUserId);
		
		BattleMap map = MartialWay.randomBattleMap();
		Battle battle = createBattle(attTeam.getUserId(), 
				defTeam.getUserId(),
				battleType,
				null,
				null,0,maxRound,map.getMapId(),map.getHinder());
		
		initHeros(battle, attTeam,true,attUser);
		initHeros(battle, defTeam,false,defUser);
		
		List<Integer> userIds = new ArrayList<Integer>();
		if(battle.getAttackUserId()!=0){
			userIds.add(battle.getAttackUserId());
		}
		if(battle.getDefenderUserId()!=0){
			userIds.add(battle.getDefenderUserId());
		}
		
		Map<String,String> hash = new HashMap<>();
		hash.put(UserTable.J_FIGHTID, battle.getBattleId());
		userService.updateUser(attUser, hash, false);
		userService.updateUser(defUser, hash, false);
		
		fightDAO.updateBattle(battle);
		
		if(battleType == SystemConstant.FIGHT_TYPE_MARTIAL_WAY){
			List<Integer> list = new ArrayList<Integer>();
			list.add(attUserId);
			list.add(defUserId);
			martialWayService.mathSucee(list);
			
			//增加累计武道大会次数
			userService.increMartialwayFightCount(attUserId, 1);
			//抛出武道会战斗事件
			MartialWayFightEvent event1 = MartialWayFightEvent.valueOf(attUser);
			TimerController.submitGameEvent(event1);

			//增加累计武道大会次数
			userService.increMartialwayFightCount(defUserId, 1);
			//抛出武道会战斗事件
			MartialWayFightEvent event2 = MartialWayFightEvent.valueOf(defUser);
			TimerController.submitGameEvent(event2);
		}
		
		return battle;
	}
	@Override
	public void checkFight(int userId) {
		User user = userService.getOnlineUser(userId);
		if(!"".equals(user.getFightId())){
			Battle battle = fightDAO.getBattle(user.getFightId());
			if(battle != null){
				if(battle.getBattleType() == SystemConstant.FIGHT_TYPE_ONLINE_PVP){
					giveUpFight(userId);
				}
			}else{
				Map<String,String> hash = new HashMap<>();
				hash.put(UserTable.J_FIGHTID, "");
				userService.updateUser(user, hash, false);
			}
		}
	}
	@Override
	public void againstFight(int userId, int againstUserId) {
		AgainstRequst userRequst = null;
		AgainstRequst againstRequst = null;
		if(userId > againstUserId){
			userRequst = againstRequstDAO.queryAgainstRequstLock(userId);
			againstRequst = againstRequstDAO.queryAgainstRequstLock(againstUserId);
		}else{
			againstRequst = againstRequstDAO.queryAgainstRequstLock(againstUserId);
			userRequst = againstRequstDAO.queryAgainstRequstLock(userId);
		}
		User user = userService.getOnlineUser(userId);
		User againstUser = userService.getOnlineUser(userId);
		if(!"".equals(user.getFightId())&&user.getFightId() != null){
			throw new GameException(GameException.CODE_正在战斗中, "");
		}
		if(!"".equals(againstUser.getFightId())&&againstUser.getFightId() != null){
			throw new GameException(GameException.CODE_正在战斗中, "");
		}
		if(userRequst.getAgainstUserId() != 0){
			if(userRequst.getAgainstTime().getTime()+30*1000L>System.currentTimeMillis()){
				throw new GameException(GameException.CODE_正在请求战斗, "");
			}
		}
		if(againstRequst.getAgainstUserId() != 0){
			if(againstRequst.getAgainstTime().getTime()+30*1000L>System.currentTimeMillis()){
				throw new GameException(GameException.CODE_对方正忙, "");
			}
		}
		userRequst.setAgainstUserId(againstUserId);
		userRequst.setAgainstType(SystemConstant.FIGHT_AGAINST_TYPE_发起者);
		userRequst.setAgainstTime(new Date());
		againstRequstDAO.updateAgainstRequst(userRequst);
		
		againstRequst.setAgainstUserId(userId);
		againstRequst.setAgainstType(SystemConstant.FIGHT_AGAINST_TYPE_接受者);
		againstRequst.setAgainstTime(new Date());
		againstRequstDAO.updateAgainstRequst(againstRequst);
		
		WorldFightAction wfa = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, WorldFightAction.class);
		wfa.againstFight(userId, againstUserId, userService.viewUser(userId));
	}
	@Override
	public void cancelFight(int userId) {
		AgainstRequst userRequst = againstRequstDAO.queryAgainstRequst(userId);
		if(userRequst.getAgainstUserId()==0||userRequst.getAgainstTime().getTime()+30*1000L<System.currentTimeMillis()){
			return;
		}
		int againstUserId = userRequst.getAgainstUserId();
		AgainstRequst againstRequst = null;
		if(userId > againstUserId){
			userRequst = againstRequstDAO.queryAgainstRequstLock(userId);
			againstRequst = againstRequstDAO.queryAgainstRequstLock(againstUserId);
		}else{
			againstRequst = againstRequstDAO.queryAgainstRequstLock(againstUserId);
			userRequst = againstRequstDAO.queryAgainstRequstLock(userId);
		}
		userRequst.setAgainstUserId(0);
		userRequst.setAgainstType(0);
		againstRequstDAO.updateAgainstRequst(userRequst);
		
		againstRequst.setAgainstUserId(0);
		againstRequst.setAgainstType(0);
		againstRequstDAO.updateAgainstRequst(againstRequst);
		
		WorldFightAction wfa = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, WorldFightAction.class);
		wfa.cancelFight(againstUserId);
	}
	@Override
	public FightVO fightRevive(int userId) {
		User user = userService.getOnlineUser(userId);
		Battle battle = fightDAO.getBattle(user.getFightId());
		if(battle == null){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		if(battle.getBattleType() != SystemConstant.FIGHT_TYPE_ZONE){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		effectService.delIncome(user, SystemConstant.ITEM_EFFECT_TYPE_PROP, SystemConstant.PROP_ID_复活药水, 1, SystemConstant.LOGGER_APPROACH_战场复活);
		
		
		for(Grid grid : battle.getGrids().values()){
			grid.setGridItem(0);
		}
		
		//清除怪物战场位置
		for(FightModel def : battle.getDefenders()){
			if(def.getState() == SystemConstant.FIGHT_MODEL_STATE_正常){
				for(Point p : def.getGridCoors()){
					Grid grid = battle.getGrids().get(p);
					grid.setFightId(0);
				}
				def.getGridCoors().clear();
				FightAtkMode model = def.getAtkMode().element();
				model.setRound(0);
				if(model.getSkill()!=null){
					model.getSkill().setCurrRound(0);
				}
			}
		}
		
		//重置战场怪物位置
		int i=0;
		for(FightModel def : battle.getDefenders()){
			if(def.getState() == SystemConstant.FIGHT_MODEL_STATE_正常){
				Grid grid;
				
				Point p = createDefPos(i);
				grid = battle.getGrids().get(p);
				grid.setFightId(def.getFightId());
				def.getGridCoors().add(grid.getCoor());
			}
			i++;
		}
		
		List<FightModel> attackers = new ArrayList<FightModel>();
		for(FightModel fm : battle.getAttackers()){
			attackers.add(fm);
		}
		battle.getAttackers().clear();
		battle.setAttSub(null);
		UserTeam userTeam = userTeamService.queryUserTeam(userId);
		initHeros(battle, userTeam,true,user);
		for(FightModel f : attackers){
			if(battle.getAttSub()!=null){
				if(f.getFightId() == battle.getAttSub().getFightId()){
					FightSkill fs = battle.getAttSub().getAtkMode().peek().getSkill();
					if(fs != null){
						FightSkill ffs = f.getAtkMode().peek().getSkill();
						fs.setCurrRound(ffs.getCurrRound());
					}
					break;
				}
			}
			for(FightModel fm : battle.getAttackers()){
				if(f.getFightId() == fm.getFightId()){
					FightSkill fs = fm.getAtkMode().peek().getSkill();
					if(fs != null){
						FightSkill ffs = f.getAtkMode().peek().getSkill();
						fs.setCurrRound(ffs.getCurrRound());
					}
					break;
				}
			}
		}
		
		battle.setShotUserId(battle.getAttackUserId());
		fightDAO.updateBattle(battle);
		
		FightVO vo = MessageFactory.getMessage(FightVO.class);
		vo.init(battle);
		return vo;
	}
	@Override
	public List<AttackRoundVO> execFightAI(int userId,boolean flag) {
		User user = userService.getUser(userId);
		Battle battle = fightDAO.getBattle(user.getFightId());
		if(flag){
			if(battle!=null){
				battle.setAttackAI(SystemConstant.FIGHT_AI_MONSTER_AI);
				battle.setDefendAI(SystemConstant.FIGHT_AI_MONSTER_AI);
			}else{
				throw new GameException(GameException.CODE_参数错误, "");
			}
		}
		return execFightAI(battle);
	}
	@Override
	public Battle startArneaPK(UserTeam attTeam, UserTeam defTeam) {
		Battle battle = createBattle(attTeam.getUserId(), defTeam.getUserId(), SystemConstant.FIGHT_TYPE_PVP, null, SystemConstant.FIGHT_AI_MONSTER_AI,0,30,"",null);
		initHeros(battle, attTeam,true,userService.getOnlineUser(attTeam.getUserId()));
		if(defTeam.getUserId()!=-100){
			initHeros(battle, defTeam,false, userService.getUser(defTeam.getUserId()));
		}
		return battle;
	}
	@Override
	public Message getFightRes(int userId) {
		User user = userService.getOnlineUser(userId);
		Battle battle = fightDAO.getBattle(user.getFightId());
		return getBattleMessage(userId,battle);
	}
	private Message getBattleMessage(int userId,Battle battle) {
		if(battle!=null&&battle.isEnd()){
			User user = userService.queryCacheUser(userId);
			Message m = battle.getBattleMessage().remove(userId);
			Map<String,String> hash = new HashMap<>();
//			hash.put("fightId", "");
			hash.put(UserTable.J_FIGHTID, "");
//			userDAO.updateUserCache(userId, hash);
			userService.updateUser(user, hash, false);
			if(battle.getBattleMessage().size()==0){
				fightDAO.deleteBattle(battle.getBattleId());
			}else{
				fightDAO.updateBattle(battle);
			}
			return m;
		}
		return null;
	}
	@Override
	public SweepAwardVO sweep(int userId, int battleId, int count) { 
		User user = userService.getOnlineUser(userId);
		if(count != 1 && count != 3 && count != 10){
			throw new GameException(GameException.CODE_参数错误, "");
		}else if(count == 10 && privilegeService.getPrivilegesValue(user, SystemConstant.PRIVILEGE_TYPE_OPEN_TEN_SWEEP) <= 0){
			throw new GameException(GameException.CODE_权限不足, "");
		}
		ZoneBattle battle = GameCache.getZoneBattle(battleId);
		Zone zone = GameCache.getZone(battle.getZoneId());
		UserZoneBattle userZoneBattle = null;
		if(battle.getBattleType() != SystemConstant.ZONE_TOLLGATE_TYPE_BOSS){
			throw new GameException(GameException.CODE_参数错误, "");
		}else{
			userZoneBattle = userZoneService.getUserZoneBattle(userId, battle.getZoneId(), battle.getBattleId());
			if(userZoneBattle == null || userZoneBattle.getStar() != 3){
				throw new GameException(GameException.CODE_参数错误, "");
			}else if(DateUtil.isBeforeToDay(userZoneBattle.getLastChallengeTime())){
				userZoneBattle.setChallengeCount(0);
			}
			if(zone.getType() == SystemConstant.ZONE_TYPE_ELITE){
				if(userZoneBattle.getChallengeCount() + count > 3){
					throw new GameException(GameException.CODE_参数错误, "");
				}
			}
		}
		ItemEffects removes = new ItemEffects(SystemConstant.LOGGER_APPROACH_扫荡消耗);
		removes.appendItem(SystemConstant.ITEM_EFFECT_TYPE_STAMINA, 0, battle.getSp() * count, 0);
		int propAmount = userPropService.getPropAmount(user, SystemConstant.PROP_ID_扫荡券);
		if(propAmount <= 0){
			removes.appendItem(SystemConstant.ITEM_EFFECT_TYPE_DIAMOND, 0, SystemConstant.ZONE_SWEEP_PRICE * count, 0);
		}else{
			int amount = count - propAmount;
			if(amount > 0){
				removes.appendItem(SystemConstant.ITEM_EFFECT_TYPE_DIAMOND, 0, SystemConstant.ZONE_SWEEP_PRICE * amount, 0);
				if(propAmount > 0){
					removes.appendItem(SystemConstant.ITEM_EFFECT_TYPE_PROP, SystemConstant.PROP_ID_扫荡券, propAmount, 0);
				}
			}else{
				removes.appendItem(SystemConstant.ITEM_EFFECT_TYPE_PROP, SystemConstant.PROP_ID_扫荡券, count, 0);
			}
		}
		int code = effectService.validDels(user, removes);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
		userZoneBattle.setChallengeCount(userZoneBattle.getChallengeCount()+count);
		ValidObject obj = new ValidObject();
		ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_扫荡获得);
		SweepAwardVO sweeps = MessageFactory.getMessage(SweepAwardVO.class);
		for(int i = 0; i < count; i++){
			int round = 1;
			BattleRound nextRound = GameCache.getBattleRound(battle.getBattleId(), round);
			List<ItemEffect> drops = null;
			while(nextRound!=null){
				for(int monsterId : nextRound.getMonsters()){
					Monster monster = GameCache.getMonster(monsterId);
					if(monster != null){
						drops = getDropItems(monster.getDrops());
					}
				}
				round++;
				nextRound = GameCache.getBattleRound(battle.getBattleId(), round);
			}
			Reward rewards = addFightRewards(effects, userZoneBattle, 1, 1);
			Reward dropRrewards = addDropRewards(user, null, drops, effects, obj, 1, 1);
			SweepVO vo = MessageFactory.getMessage(SweepVO.class);
			vo.setRewards(rewards.getItemEffects());
			vo.setDrops(dropRrewards.getItemEffects());
			sweeps.addSweep(vo);
		}
		userZoneDAO.updateUserZoneBattle(userZoneBattle);  
		effectService.delIncome(user, removes);
		effectService.addIncome(user, effects, null);
		//抛出通过关卡事件
		PassBattleEvent event = PassBattleEvent.valueOf(user, 2, battleId, count, zone.getType());
		TimerController.submitGameEvent(event);
		ZoneBattleLogger logger = new ZoneBattleLogger(userId, zone.getZoneId(), battleId);
		logger.setState(3);
		logger.setBattleNum(count);
		TimerController.submitGameEvent(new GameLoggerEvent(SystemConstant.LOG_EVENT_TYPE_BATTLE, logger));
		return sweeps;
	}
	@Override
	public FightVO watch(int userId, String fightId){
		Battle battle = fightDAO.getBattle(fightId);
		if(battle == null){
			throw new GameException(GameException.CODE_战斗已结束, "");
		}
		WorldFightAction action = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, WorldFightAction.class);
		action.watch(userId, fightId);
		FightVO fightVO = MessageFactory.getMessage(FightVO.class);
		fightVO.init(battle);
		return fightVO;
	}
	@Override
	public Battle getBattle(int userId) {
		User user = userService.getOnlineUser(userId);
		Battle battle = fightDAO.getBattle(user.getFightId());
		return battle;
	}
	
	/**
	 * 副本奖励
	 */
	private Reward addFightRewards(ItemEffects effects, UserZoneBattle userZoneBattle, int goldAddition, int expAddition){
		Reward rewards = new Reward();
		if(userZoneBattle != null){
			ZoneBattle zoneBattle = GameCache.getZoneBattle(userZoneBattle.getZoneBattleId());
			if(zoneBattle != null){
				int gold = zoneBattle.getGold() * goldAddition;
				int exp = zoneBattle.getExp() * expAddition;
				if(userZoneBattle.getPassCount() == 1){
					gold = zoneBattle.getFirstGold() * goldAddition;
					exp = zoneBattle.getFirstExp() * expAddition;
				}
				effects.appendItem(SystemConstant.ITEM_EFFECT_TYPE_GOLD, 0, gold, 0);
				rewards.addItemEffect(SystemConstant.ITEM_EFFECT_TYPE_GOLD, 0, gold, 0);
				effects.appendItem(SystemConstant.ITEM_EFFECT_TYPE_EXP, 0, exp, 0);
				rewards.addItemEffect(SystemConstant.ITEM_EFFECT_TYPE_EXP, 0, exp, 0);
			}
		}
		return rewards;
	}
	
	/**
	 * 掉落奖励
	 */
	private Reward addDropRewards(User user, Battle battle, List<ItemEffect> items, ItemEffects dropEffects, ValidObject obj, int goldAddition, int expAddition){
		Reward dropReward = new Reward();
		if(items != null){
			int code = GameException.CODE_正常;
			for(ItemEffect effect : items){
				try{
					if(effect.getValue1() > 0){
						if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_HERO){
							code = effectService.validSize(user, obj.getHeroSize() + effect.getValue1(), 0, 0, 0);
							if(code == GameException.CODE_正常){
								obj.setHeroSize(obj.getHeroSize() + effect.getValue1());
							}
						}else if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_PROP){
							UserProp prop = userPropService.getUserPropByPropId(user, effect.getId());
							if(prop == null){
								code = effectService.validSize(user, 0, 0, 0, obj.getPropSize() + 1);
								if(code == GameException.CODE_正常){
									obj.setPropSize(obj.getPropSize() + 1);
								}
							}
						}else if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_ETERNAL){
							code = effectService.validSize(user, 0, obj.getEternalSize() + effect.getValue1(), 0, 0);
							if(code == GameException.CODE_正常){
								obj.setEternalSize(obj.getEternalSize() + effect.getValue1());
							}
						}else if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_EQUIPMENT){
							code = effectService.validSize(user, 0, 0, obj.getEquipSize() + effect.getValue1(), 0);
							if(code == GameException.CODE_正常){
								obj.setEquipSize(obj.getEquipSize() + effect.getValue1());
							}
						}
						if(code == GameException.CODE_正常){
							int value = effect.getValue1();
							int value2 = effect.getValue2();
							if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_EXP){
								value *= expAddition;
							}else if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_GOLD){
								value *= goldAddition;
							}else if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_HERO
									|| effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_EQUIPMENT){
								value2 = value2 <= 0 ? 1 : value2;
							}
							dropEffects.appendItem(effect.getType(), effect.getId(), value, value2);
							dropReward.addItemEffect(effect.getType(), effect.getId(), value, value2);
						}
					}
				}catch(Exception e){}
			}
		}
		if(battle != null){
			if(battle.getSlate() > 0){
				dropEffects.appendItem(SystemConstant.ITEM_EFFECT_TYPE_SLATE, 0, battle.getSlate(), 0);
				dropReward.addItemEffect(SystemConstant.ITEM_EFFECT_TYPE_SLATE, 0, battle.getSlate(), 0);
			}
		}
		return dropReward;
	}
	
	private List<ItemEffect> getDropItems(List<DropEffect> drops){
		List<ItemEffect> list = new ArrayList<>();
		if(drops != null){
			for(DropEffect drop : drops){
				if(drop.isDrop()){
					List<Integer> types = new ArrayList<>();
					List<ItemEffect> plist = new ArrayList<>();
					int amount = drop.getAmount();
					int probability = 0;
					List<ItemEffect> items = drop.getItems();  //不要修改items
					for(ItemEffect effect : items){
						if(!types.contains(effect.getType())){
							if(effect.getProbability() == SystemConstant.PERCENT_BASE_INT){
								list.add(effectService.createEffect(effect.getType(), effect.getId(), effect.getValue1(), effect.getValue2(), effect.getLogSubType()));
								types.add(effect.getType());
								if(amount > 0){
									amount--;
									if(amount == 0){
										break;
									}
								}
							}else{
								plist.add(effect);
								probability += effect.getProbability();
							}
						}
					}
					if(amount > 0){
						for(int i = 0; i < amount; i++){
							if(probability > 0){
								int random = MathUtil.nextInt(probability);
								Iterator<ItemEffect> it = plist.iterator();
								while(it.hasNext()){
									ItemEffect effect = it.next();
									if(random < effect.getProbability()){
										it.remove();
										probability -= effect.getProbability();
										if(types.contains(effect.getType())){
											random -= effect.getProbability();
										}else{
											list.add(effectService.createEffect(effect.getType(), effect.getId(), effect.getValue1(), effect.getValue2(), effect.getLogSubType()));
											types.add(effect.getType());
											break;
										}
									}else{
										random -= effect.getProbability();
									}
								}
							}
						}
					}else if(amount == -1){
						for(ItemEffect effect : plist){
							int random = MathUtil.nextInt(SystemConstant.PERCENT_BASE_INT);
							if(random < effect.getProbability()){
								if(!types.contains(effect.getType())){
									list.add(effectService.createEffect(effect.getType(), effect.getId(), effect.getValue1(), effect.getValue2(), effect.getLogSubType()));
									types.add(effect.getType());
								}
							}
						}
					}
				}
			}
		}
		return effectService.mergeEffect(list, 1);
	}
	
}