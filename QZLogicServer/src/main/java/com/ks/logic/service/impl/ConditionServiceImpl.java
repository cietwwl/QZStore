package com.ks.logic.service.impl;

import java.util.List;

import com.ks.constant.SystemConstant;
import com.ks.db.model.User;
import com.ks.exceptions.GameException;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.ConditionService;
import com.ks.object.ConditionParams;

public class ConditionServiceImpl extends BaseService implements ConditionService{

	@Override
	public int validCondition(User user, ConditionParams params) {
		if(params != null){
			boolean valid = false;
			List<Integer> types = params.getKeys();
			for(int type : types){
				if(type == SystemConstant.CONDITION_TYPE_USER_LEVEL){
					valid = user.getLevel() >= params.getParam(type);
				}else if(type == SystemConstant.CONDITION_TYPE_VIP_LEVEL){
					valid = user.getVip() >= params.getParam(type);
				}else if(type == SystemConstant.CONDITION_TYPE_APPOINT_VIP_LEVEL){
					valid = user.getVip() == params.getParam(type);
				}
				if(!valid){
					return GameException.CODE_条件未达成;
				}
			}
		}
		return GameException.CODE_正常;
	}

}
