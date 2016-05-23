package com.ks.logic.service.impl;

import java.util.List;

import com.ks.db.cfg.Signin;
import com.ks.db.cfg.SumSignin;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.SigninService;

public class SigninServiceImpl extends BaseService implements SigninService {

	@Override
	public List<Signin> querySignins() {
		return signinDAO.querySignins();
	}

	@Override
	public List<SumSignin> querySumSignins() {
		return signinDAO.querySumSignins();
	}

}
