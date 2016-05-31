package com.ks.logic.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ks.constant.SystemConstant;
import com.ks.db.cfg.Hero;
import com.ks.db.cfg.UserRule;
import com.ks.db.model.User;
import com.ks.db.model.UserHero;
import com.ks.db.model.UserTeam;
import com.ks.exceptions.GameException;
import com.ks.logic.cache.GameCache;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.UserTeamService;
import com.ks.model.user.UserBaseinfo;
import com.ks.protocol.vo.user.UserTeamVO;
import com.ks.util.CheckUtil;

public class UserTeamServiceImpl extends BaseService implements UserTeamService {
	
	/*******************************************************user team data*********************************************************/
	public void updateUserTeamData(UserTeam team){
		userTeamDAO.updateUserTeam(team);
		userTeamDAO.updateUserTeamCache(team);
	}
	
	public void addUserTeamData(UserTeam team){
		userTeamDAO.addUserTeam(team);
		userTeamDAO.setUserTeamCache(team, false);
	}
	
	/**
	 * 加载用户统计
	 * @param user
	 */
	public UserTeam loadUserTeamToCache(int userId){
		UserTeam team = loadDBUserTeamData(userId);
		userTeamDAO.setUserTeamCache(team, true);
		return team;
	}
	
	/**
	 * 加载用户统计
	 * @param user
	 */
	private UserTeam loadDBUserTeamData(int userId){
		UserTeam team = userTeamDAO.queryUserTeam(userId);
		return team;
	}
	
	public UserTeam getUserTeamData(int userId){
		UserTeam team = userTeamDAO.queryUserTeamCache(userId);
		if(team == null){
			team = loadUserTeamToCache(userId);
		}
		return team;
	}
	
	@Override
	public UserTeam queryUserTeam(int userId) {
		UserTeam userTeam = getUserTeamData(userId);
		if(userTeam == null){
			User user = userService.getUser(userId);
			userTeam = new UserTeam();
			userTeam.setUserId(userId);
			userTeam.setHeroList(new ArrayList<Integer>());
			userTeam.setPosList(new ArrayList<Integer>());
			List<UserHero> heros = userHeroService.getUserHeros(user);
			for(int i=0;i<4;i++){
				UserHero uh = null;
				if(i==0 && !heros.isEmpty()){
					uh = heros.get(i);
					userTeam.getHeroList().add(uh.getId());
				}else{
					userTeam.getHeroList().add(0);
				}
				userTeam.getPosList().add(i);
			}
			addUserTeamData(userTeam);
		}
		return userTeam;
	}

	@Override
	public void updateUserTeam(int userId, UserTeamVO vo) {
		User user = userService.getOnlineUser(userId);
		UserTeam userTeam = getUserTeamData(userId);
		
		for(int heroId : vo.getHeros()){
			if(heroId!=0){
				int count = 0;
				for(int x : vo.getHeros()){
					if(heroId==x){
						count++;
					}
				}
				if(count>1){
				}
			}
		}
		
		if(CheckUtil.isRepeatlist(vo.getPos())){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		if(vo.getHeros().size()!=4||vo.getPos().size() != 4){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		for(int pos : vo.getPos()){
			if(pos>3||pos<0){
				throw new GameException(GameException.CODE_参数错误, "");
			}
		}
		
		int cost = 0;
		for(int i=0;i<4;i++){
			int heroId = vo.getHeros().get(i);
			if(heroId!=0){
				UserHero uh = userHeroService.getUserHero(user, heroId);
				Hero hero = GameCache.getHero(uh.getHeroId());
				if((uh.getState() & SystemConstant.EXPLORE_STATE_EXPLORE)!=0){
					throw new GameException(GameException.CODE_参数错误, "");
				}
				cost += hero.getCost();
			}
		}
		UserRule rule = GameCache.getUserRule(user.getLevel());
		if(rule.getCost()<cost){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		
		userTeam.setHeroList(vo.getHeros());
		userTeam.setPosList(vo.getPos());
		updateUserTeamData(userTeam);
		
		UserHero userHero = userHeroService.getUserHero(user, userTeam.getHeroList().get(0));
		
		UserBaseinfo baseinfo = userService.getUserBaseInfo(user.getUserId());
		baseinfo.setHeroId(userHero.getHeroId());
		//更新战斗力
		fightService.computeFightingEvent(user.getUserId());
		baseinfo.setFighting(user.getFighting());
		userDAO.updateUserBaseinfo(baseinfo);
		

	}
	
	

}
