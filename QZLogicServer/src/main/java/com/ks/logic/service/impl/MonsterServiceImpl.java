package com.ks.logic.service.impl;

import java.util.List;

import com.ks.db.cfg.Drop;
import com.ks.db.cfg.Monster;
import com.ks.db.cfg.MonsterAtkMode;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.MonsterService;

public class MonsterServiceImpl extends BaseService implements MonsterService {
	@Override
	public List<Monster> queryMonster() {
		return monsterDAO.queryMonster();
	}
	@Override
	public List<MonsterAtkMode> queryMonsterAtkMode() {
		return monsterDAO.queryMonsterAtkMode();
	}
	@Override
	public List<Drop> queryDrops() {
		return monsterDAO.queryDrops();
	}
}