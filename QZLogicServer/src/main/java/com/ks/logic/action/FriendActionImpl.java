package com.ks.logic.action;

import java.util.List;

import com.ks.action.logic.FriendAction;
import com.ks.logic.service.FriendService;
import com.ks.logic.service.ServiceFactory;
import com.ks.protocol.vo.friend.FriendApplyVO;
import com.ks.protocol.vo.friend.FriendRecoVO;
import com.ks.protocol.vo.friend.FriendVO;
import com.ks.protocol.vo.user.UserBaseinfoVO;

public class FriendActionImpl implements FriendAction {
	
	private static final FriendService friendService = ServiceFactory.getService(FriendService.class);
	
	@Override
	public List<FriendVO> gainFriends(int userId) {
		return friendService.gainFriends(userId);
	}

	@Override
	public List<FriendApplyVO> gainFriendApply(int userId) {
		return friendService.gainFriendApply(userId);
	}

	@Override
	public void applyFriend(int userId, String playerName) {
		friendService.applyFriend(userId, playerName);
	}

	@Override
	public FriendVO agreeApply(int userId, int applyUserId) {
		return friendService.agreeApply(userId, applyUserId);
	}

	@Override
	public void deleteApply(int userId, List<Integer> applyUserId) {
		friendService.deleteApply(userId, applyUserId);
	}

	@Override
	public void deleteFriend(int userId, int friendId) {
		friendService.deleteFriend(userId, friendId);
	}

	@Override
	public void givingStamina(int userId, List<Integer> friendIds) {
		friendService.givingStamina(userId, friendIds);
	}

	@Override
	public void collectStamina(int userId, List<Integer> friendIds) {
		friendService.collectStamina(userId, friendIds);
	}

	@Override
	public FriendRecoVO gainFriendReco(int userId) {
		return friendService.gainFriendReco(userId);
	}

	@Override
	public FriendRecoVO refFriendReco(int userId) {
		return friendService.refFriendReco(userId);
	}

	@Override
	public List<UserBaseinfoVO> getBattleFriend(int userId) {
		return friendService.getBattleFriend(userId);
	}

	@Override
	public int receiveHireGp(int userId) {
		return friendService.receiveHireGp(userId);
	}

}
