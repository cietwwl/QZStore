package com.ks.logic.service;

import java.util.List;

import com.ks.db.cfg.Drop;
import com.ks.db.cfg.Monster;
import com.ks.db.cfg.MonsterAtkMode;

/**
 * 怪物服务
 * @author ks
 */
public interface MonsterService {
	/**
	 * 查询所有怪物
	 * @return 所有怪物
	 */
	List<Monster> queryMonster();
	/**
	 * 查询怪物攻击方式
	 * @return 怪物攻击方式
	 */
	List<MonsterAtkMode> queryMonsterAtkMode();
	/**
	 * 查询掉落
	 * @return
	 */
	List<Drop> queryDrops();
}
