package com.ks.logic.action;

import java.util.List;

import com.ks.action.logic.FightAction;
import com.ks.logic.service.FightService;
import com.ks.logic.service.ServiceFactory;
import com.ks.model.fight.Battle;
import com.ks.protocol.Message;
import com.ks.protocol.vo.fight.AttackRoundVO;
import com.ks.protocol.vo.fight.FightResultVO;
import com.ks.protocol.vo.fight.FightVO;
import com.ks.protocol.vo.fight.MoveVO;
import com.ks.protocol.vo.fight.SweepAwardVO;

public class FightActionImpl implements FightAction {
	
	private static final FightService service = ServiceFactory.getService(FightService.class);
	
	@Override
	public List<AttackRoundVO> move(int userId, MoveVO moveVO) {
		return service.move(userId, moveVO);
	}

	@Override
	public FightResultVO gainFightAward(int userId) {
		return service.gainFightAward(userId);
	}

	@Override
	public int giveUpFight(int userId) {
		return service.giveUpFight(userId);
	}

	@Override
	public AttackRoundVO releaseSkill(int userId, int fightId) {
		return service.releaseSkill(userId, fightId);
	}

	@Override
	public List<AttackRoundVO> hosting(int userId) {
		return service.hosting(userId);
	}

	@Override
	public FightVO gainFight(int userId) {
		return service.gainFight(userId);
	}

	@Override
	public Battle startOnlinePVPFight(int attUserId, int defUserId,int battleType,int maxRound) {
		return service.startOnlinePVPFight(attUserId, defUserId,battleType,maxRound);
	}

	@Override
	public void checkFight(int userId) {
		service.checkFight(userId);
	}

	@Override
	public void againstFight(int userId, int againstUserId) {
		service.againstFight(userId, againstUserId);
	}

	@Override
	public void cancelFight(int userId) {
		service.cancelFight(userId);
	}

	@Override
	public FightVO fightRevive(int userId) {
		return service.fightRevive(userId);
	}

	@Override
	public List<AttackRoundVO> execFightAI(int userId,boolean flag) {
		return service.execFightAI(userId,flag);
	}

	@Override
	public Message getFightRes(int userId) {
		return service.getFightRes(userId);
	}

	@Override
	public SweepAwardVO sweep(int userId, int battleId, int count) {
		return service.sweep(userId, battleId, count);
	}

	@Override
	public Battle getBattle(int userId) {
		return service.getBattle(userId);
	}
	
	@Override
	public FightVO watch(int userId, String fightId){
		return service.watch(userId, fightId);
	}

}
