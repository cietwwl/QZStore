package com.ks.logic.service;

import java.util.List;

import com.ks.db.cfg.Signin;
import com.ks.db.cfg.SumSignin;

public interface SigninService{
	/**
	 * 查询所有签到奖励
	 * @return
	 */
	public List<Signin> querySignins();
	/**
	 * 查询所有累计签到奖励
	 * @return
	 */
	public List<SumSignin> querySumSignins();
}
