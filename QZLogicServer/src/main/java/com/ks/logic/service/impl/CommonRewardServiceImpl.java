package com.ks.logic.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.ks.access.SQLOpt;
import com.ks.constant.SystemConstant;
import com.ks.db.cfg.CommonRewardConfig;
import com.ks.db.model.User;
import com.ks.db.model.UserRecord;
import com.ks.exceptions.GameException;
import com.ks.logic.cache.GameCache;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.CommonRewardService;
import com.ks.object.CommonReward;
import com.ks.object.ItemEffects;
import com.ks.protocol.vo.goods.GainAwardVO;
import com.ks.table.UserRecordTable;

public class CommonRewardServiceImpl extends BaseService implements CommonRewardService {
	
	@Override
	public List<CommonRewardConfig> queryCommonRewardConfigs(){
		return commonRewardDao.queryCommonRewardConfigs();
	}
	
	@Override
	public GainAwardVO receiveReward(User user, int id){
		CommonRewardConfig config = GameCache.getCommonRewardConfig(id);
		if(config == null){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		UserRecord record = userDAO.getUserRecord(user.getUserId());
		CommonReward reward = record.getCommonReward(id);
		if(reward == null){
			if(validGain(record, config) || conditionService.validCondition(user, config.getConditionParams()) != GameException.CODE_正常){
				throw new GameException(GameException.CODE_参数错误, "");
			}
			reward = new CommonReward(config.getId(), 0);
			record.addCommonReward(reward);
		}else if(reward.getState() == 1){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_领取通用奖励);
		effects.appendStrs(config.getItems());
		int code = effectService.validAdds(user, effects);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
		return effectService.addGainAwardVo(user, effects);
	}
	
	/**
	 * 校验获得方式
	 */
	private boolean validGain(UserRecord record, CommonRewardConfig config){
		if(config.getGain() == 1){
			Set<Integer> ids = record.getCommonRewardIds();
			for(Integer id : ids){
				CommonRewardConfig old = GameCache.getCommonRewardConfig(id);
				if(old != null && old.getType() == config.getType()){
					return false;
				}
			}
			return true;
		}else if(config.getGain() == 2){
			Set<Integer> ids = record.getCommonRewardIds();
			CommonRewardConfig max = null;
			for(Integer id : ids){
				CommonRewardConfig old = GameCache.getCommonRewardConfig(id);
				if(old != null && old.getType() == config.getType()){
					if(max == null || max.getGroup() < old.getGroup()){
						max = old;
					}
				}
			}
			if(max == null){
				return config.getGroup() == 1;
			}else{
				return config.getGroup() > max.getGroup();
			}
		}else if(config.getGain() == 3){
			return record.getCommonReward(config.getId()) == null;
		}
		return false;
	}
	
	public void autoGainReward(User user, int type){
		List<CommonRewardConfig> list = GameCache.getCommonRewardConfigs(type);
		if(list.isEmpty()){
			UserRecord record = userDAO.getUserRecord(user.getUserId());
			CommonRewardConfig max = null;
			boolean check = true;
			List<CommonRewardConfig> adds = new ArrayList<>();
			for(CommonRewardConfig config : list){
				if(conditionService.validCondition(user, config.getConditionParams()) == GameException.CODE_正常){
					if(config.getGain() == 1){
						if(!validGain(record, config)){
							return;
						}
						adds.add(config);
						break;
					}else if(config.getGain() == 2){
						if(check){
							Set<Integer> ids = record.getCommonRewardIds();
							for(Integer id : ids){
								CommonRewardConfig old = GameCache.getCommonRewardConfig(id);
								if(old != null && old.getType() == config.getType() && max.getGroup() < old.getGroup()){
									max = old;
								}
							}
							check = false;
						}
						if(max != null){
							if(max.getGroup() >= config.getGroup()){
								continue;
							}
							adds.add(config);
							break;
						}
					}else if(config.getGain() == 3){
						if(validGain(record, config)){
							continue;
						}
						adds.add(config);
					}
				}
			}
			if(!adds.isEmpty()){
				ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_自动获得通用奖励);
				for(CommonRewardConfig config : adds){
					effects.appendStrs(config.getItems());
				}
				int code = effectService.validAdds(user, effects);
				if(code == GameException.CODE_正常){
					for(CommonRewardConfig config : adds){
						record.addCommonReward(new CommonReward(config.getId(), 1));
					}
					record.initCommonRewards();
					SQLOpt opt = new SQLOpt();
					opt.putFieldOpt(UserRecordTable.COMMONREWARDS, SQLOpt.EQUAL);
					userDAO.updateUserRecord(record, opt);
					effectService.addIncome(user, effects, null);
				}
			}
		}
	}
	
	public void resetReward(int userId, int type){
		List<Integer> types = new ArrayList<>();
		types.add(type);
		resetRewards(userId, types);
	}
	
	private void resetRewards(int userId, List<Integer> types){
		UserRecord record = userDAO.getUserRecord(userId);
		boolean remove = false;
		Set<Integer> ids = record.getCommonRewardIds();
		for(Integer id : ids){
			CommonRewardConfig config = GameCache.getCommonRewardConfig(id);
			if(config != null  && types.contains(config.getType()) && config.getReset() == 1){
				 record.delCommonReward(id);
				 remove = true;
			}
		}
		if(remove){
			record.initCommonRewards();
			SQLOpt opt = new SQLOpt();
			opt.putFieldOpt(UserRecordTable.COMMONREWARDS, SQLOpt.EQUAL);
			userDAO.updateUserRecord(record, opt);
		}
	}

}
