package com.ks.logic.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ks.constant.SystemConstant;
import com.ks.db.cfg.Achieve;
import com.ks.db.cfg.AchieveAward;
import com.ks.db.model.User;
import com.ks.db.model.UserAchieve;
import com.ks.exceptions.GameException;
import com.ks.logic.cache.GameCache;
import com.ks.logic.event.AchieveEvent;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.UserAchieveService;
import com.ks.object.ItemEffects;
import com.ks.protocol.vo.goods.GainGameAwardVO;
import com.ks.timer.TimerController;

public class UserAchieveServiceImpl extends BaseService implements
		UserAchieveService {

	@Override
	public List<UserAchieve> queryUserAchieve(int userId) {
		return userAchieveDAO.queryUserAchieves(userId);
	}

	@Override
	public void addAchieveNum(int userId, int achieveType, int assId, int num) {
		if(num<=0){
			return;
		}
		List<UserAchieve> updateUserAchieve = new ArrayList<UserAchieve>();
		UserAchieve currAchieve = userAchieveDAO.queryCurrAchieve(userId, achieveType, assId);
		if(currAchieve == null){
			Achieve a = GameCache.getFristAchieve(achieveType, assId);
			currAchieve = createNewAchieve(userId,a,0);
		}
		if(currAchieve.getState() == SystemConstant.ACHIEVE_STATE_已完成){
			Achieve a = GameCache.getNextAchieve(currAchieve.getAchieveId());
			if(a == null){
				return;
			}
			currAchieve = createNewAchieve(userId, a,currAchieve.getNum());
		}
		
		Achieve a = GameCache.getAchieve(currAchieve.getAchieveId());
		num = updateAchieve(num, currAchieve, a);
		updateUserAchieve.add(currAchieve);
		
		while(num>0){
			Achieve aa = GameCache.getNextAchieve(currAchieve.getAchieveId());
			if(aa == null){
				break;
			}
			currAchieve = createNewAchieve(userId,  aa,currAchieve.getNum());
			
			num = updateAchieve(num, currAchieve, aa);
			updateUserAchieve.add(currAchieve);
		}
		
		if(updateUserAchieve.size()>0){
			AchieveEvent event = new AchieveEvent(userId, updateUserAchieve);
			TimerController.submitGameEvent(event);
		}
	}
	/**
	 * 修改成就
	 * @param num 数量
	 * @param currAchieve 当前成就
	 * @param a 成就
	 * @return 剩余数量
	 */
	private int updateAchieve(int num, UserAchieve currAchieve, Achieve a) {
		currAchieve.setNum(currAchieve.getNum()+ num);
		if(currAchieve.getNum()>=a.getNum()){
			currAchieve.setState(SystemConstant.ACHIEVE_STATE_已完成);
			num = currAchieve.getNum() - a.getNum();
			currAchieve.setNum(a.getNum());
		}else{
			num = 0;
		}
		userAchieveDAO.updateUserAchieve(currAchieve);
		return num;
	}
	/**
	 * 创建成就
	 * @param userId 用户编号
	 * @param a 成就
	 * @param lastNum 最后一个成就的数量
	 * @return 创建的成就
	 */
	private UserAchieve createNewAchieve(int userId,  Achieve a,int lastNum) {
		UserAchieve currAchieve;
		currAchieve = new UserAchieve();
		currAchieve.setUserId(userId);
		currAchieve.setAchieveId(a.getAchieveId());
		currAchieve.setAssId(a.getAssId());
		currAchieve.setAchieveType(a.getType());
		currAchieve.setNum(lastNum);
		currAchieve.setState(SystemConstant.ACHIEVE_STATE_未完成);
		
		userAchieveDAO.addUserAchieve(currAchieve);
		return currAchieve;
	}

	@Override
	public GainGameAwardVO gainAchieveAward(int userId, int achieveId) {   //TODO
		UserAchieve achieve = userAchieveDAO.queryUserAchieve(userId,achieveId);
		if(achieve == null){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		if(achieve.getState()!=SystemConstant.ACHIEVE_STATE_已完成){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		User user = userService.getOnlineUser(userId);
		List<AchieveAward> awards = GameCache.getAchieveAward(achieveId);
		ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_成就奖励);
		for(AchieveAward award : awards){
			effects.addItem(award.getType(), award.getGoodsId(), award.getNum(), award.getLevel());
		}
		int code = effectService.validAdds(user, effects);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
		GainGameAwardVO aaVO = effectService.addGainGameAwardVo(user, effects);
		
		achieve.setState(SystemConstant.ACHIEVE_STATE_已领取);
		userAchieveDAO.updateUserAchieve(achieve);
		
		return aaVO;
	}
	
}
