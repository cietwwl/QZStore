package com.ks.logic.service;

import java.util.List;

import com.ks.db.cfg.Fame;
import com.ks.db.cfg.FameAward;
import com.ks.db.cfg.FameBuff;

public interface FameService {
	/**
	 * 查询名望
	 * @return
	 */
	List<Fame> queryFame();
	/**
	 * 查询名望BUFF
	 * @return
	 */
	List<FameBuff> queryFameBuff();
	/**
	 * 查询名望奖励
	 * @return
	 */
	List<FameAward> queryFameAward();
}
