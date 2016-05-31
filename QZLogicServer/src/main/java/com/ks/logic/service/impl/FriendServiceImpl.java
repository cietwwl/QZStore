package com.ks.logic.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ks.access.SQLOpt;
import com.ks.action.world.WorldServerAction;
import com.ks.action.world.WorldUserAction;
import com.ks.app.Application;
import com.ks.constant.SystemConstant;
import com.ks.db.model.Friend;
import com.ks.db.model.FriendApply;
import com.ks.db.model.FriendReco;
import com.ks.db.model.User;
import com.ks.db.model.UserStat;
import com.ks.event.GameEvent;
import com.ks.exceptions.GameException;
import com.ks.logic.event.AgreeFriendEvent;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.FriendService;
import com.ks.model.user.UserBaseinfo;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.FriendCMD;
import com.ks.protocol.vo.Head;
import com.ks.protocol.vo.friend.FriendApplyVO;
import com.ks.protocol.vo.friend.FriendRecoVO;
import com.ks.protocol.vo.friend.FriendVO;
import com.ks.protocol.vo.user.UserBaseinfoVO;
import com.ks.rpc.RPCKernel;
import com.ks.table.UserStatTable;
import com.ks.timer.TimerController;
import com.ks.util.MathUtil;

public class FriendServiceImpl extends BaseService implements FriendService {

	/*********************************************************friend data********************************************************************/
	public void updateFriendData(Friend friend){
		friendDAO.updateFriend(friend);
		friendDAO.updateFriendCache(friend);
	}
	public void deleteFriendData(int userId, int friendId){
		friendDAO.deleteFriend(userId, friendId);
		friendDAO.delFriendCache(userId, friendId);
	}
	public void addFriendData(Friend friend){
		friendDAO.addFriend(friend);
		friendDAO.addFriendCache(friend);
	}
	public Map<Integer, Friend> friendListToMap(Collection<Friend> collection){
		Map<Integer, Friend> map = new HashMap<Integer, Friend>();
		for(Friend friend : collection){
			map.put(friend.getFriendId(), friend);
		}
		return map;
	}
	/**
	 * 加载好友
	 * @param user
	 */
	public Map<Integer, Friend> loadFriendToCache(int userId){
		List<Friend> list =  loadDBFriend(userId);
		Map<Integer, Friend> map = friendListToMap(list);
		friendDAO.setFriendsCache(userId, map);
		return map;
	}
	/**
	 * 加载好友
	 * @param user
	 */
	private List<Friend> loadDBFriend(int userId){
		List<Friend> list = friendDAO.queryFriends(userId);
		return list;
	}
	public Collection<Friend> getFriendDatas(int userId){
		Map<Integer, Friend> map = friendDAO.queryFriendsCache(userId);
		if(map == null){
			map = loadFriendToCache(userId);
		}
		return map.values();
	}
	public Friend getFriendData(int userId, int friendId){
		Map<Integer, Friend> map = friendDAO.queryFriendsCache(userId);	
		if(map == null){
			map = loadFriendToCache(userId);
		}
		return map.get(friendId);
	}
	
	/*********************************************************friend apply data********************************************************************/
	public void deleteFriendApplyData(int userId, int applyUserId){
		friendDAO.deleteFriendApply(userId, applyUserId);
		friendDAO.delFriendApplyCache(userId, applyUserId);
	}
	public void addFriendApplyData(FriendApply apply){
		friendDAO.addFriendApply(apply);
		friendDAO.addFriendApplyCache(apply);
	}
	public Map<Integer, FriendApply> friendApplyListToMap(Collection<FriendApply> collection){
		Map<Integer, FriendApply> map = new HashMap<Integer, FriendApply>();
		for(FriendApply apply : collection){
			map.put(apply.getApplyUserId(), apply);
		}
		return map;
	}
	/**
	 * 加载好友
	 * @param user
	 */
	public Map<Integer, FriendApply> loadFriendApplyToCache(int userId){
		List<FriendApply> list =  loadDBFriendApply(userId);
		Map<Integer, FriendApply> map = friendApplyListToMap(list);
		friendDAO.setFriendApplysCache(userId, map);
		return map;
	}
	/**
	 * 加载好友
	 * @param user
	 */
	private List<FriendApply> loadDBFriendApply(int userId){
		List<FriendApply> list = friendDAO.queryFriendApplys(userId);
		return list;
	}
	public Collection<FriendApply> getFriendApplyDatas(int userId){
		Map<Integer, FriendApply> map = friendDAO.queryFriendApplysCache(userId);
		if(map == null){
			map = loadFriendApplyToCache(userId);
		}
		return map.values();
	}
	public FriendApply getFriendApplyData(int userId, int applyUserId){
		Map<Integer, FriendApply> map = friendDAO.queryFriendApplysCache(userId);
		if(map == null){
			map = loadFriendApplyToCache(userId);
		}
		return map.get(applyUserId);
	}
	
	/*********************************************************friend reco data********************************************************************/
	public void updateFriendRecoData(FriendReco reco){
		friendDAO.updateFriendReco(reco);
		friendDAO.updateFriendCache(reco);
	}
	public void addFriendRecoData(FriendReco reco){
		friendDAO.addFriendReco(reco);
		friendDAO.setFriendRecoCache(reco, false);
	}
	/**
	 * 加载好友推荐
	 * @param user
	 */
	public FriendReco loadFriendRecoToCache(int userId){
		FriendReco reco =  loadDBFriendReco(userId);
		friendDAO.setFriendRecoCache(reco, true);
		return reco;
	}
	
	/**
	 * 加载好友推荐
	 * @param user
	 */
	private FriendReco loadDBFriendReco(int userId){
		FriendReco reco = friendDAO.queryFriendReco(userId);
		return reco;
	}
	
	public FriendReco getFriendRecoData(int userId){
		FriendReco reco = friendDAO.queryFriendRecoCache(userId);
		if(reco == null){
			reco = loadFriendRecoToCache(userId);
		}
		return reco;
	}
	
	
	/*****************************************************************logic*****************************************************************************/
	@Override
	public List<FriendVO> gainFriends(int userId) {
		Collection<Friend> friends = getFriendDatas(userId);
		List<Integer> userIds = new ArrayList<Integer>();
		for(Friend f : friends){
			userIds.add(f.getFriendId());
		}
		List<UserBaseinfo> infos = userService.getUserBaseInfo(userIds);
		
		List<FriendVO> vos = new ArrayList<FriendVO>();
		for(Friend f : friends){
			FriendVO vo = MessageFactory.getMessage(FriendVO.class);
			vo.setState(f.getState());
			vo.setFriendlyDegrees(f.getFriendlyDegrees());
			vo.setLastRefTime(f.getLastRefTime().getTime());
			vo.setUseCount(f.getUseCount());
			for(UserBaseinfo ubi : infos){
				if(ubi.getUserId() == f.getFriendId()){
					UserBaseinfoVO ubiVO = MessageFactory.getMessage(UserBaseinfoVO.class);
					ubiVO.init(ubi);
					vo.setInfo(ubiVO);
					break;
				}
			}
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public List<FriendApplyVO> gainFriendApply(int userId) {
		Collection<FriendApply> applys = getFriendApplyDatas(userId);
		
		List<Integer> userIds = new ArrayList<Integer>();
		for(FriendApply fa : applys){
			userIds.add(fa.getApplyUserId());
		}
		
		List<UserBaseinfo> infos = userService.getUserBaseInfo(userIds);
		
		List<FriendApplyVO> vos  = new ArrayList<FriendApplyVO>(); 
		for(UserBaseinfo info : infos){
			
			FriendApplyVO fa = MessageFactory.getMessage(FriendApplyVO.class);
			
			UserBaseinfoVO vo = MessageFactory.getMessage(UserBaseinfoVO.class);
			vo.init(info);
			for(FriendApply f : applys){
				if(info.getUserId() == f.getApplyUserId()){
					fa.setTime(f.getCreateTime().getTime());
					break;
				}
			}
			
			fa.setInfos(vo);
			vos.add(fa);
		}
		return vos;
	}

	@Override
	public void applyFriend(int userId, String playerName) { 
		User user = userService.getOnlineUser(userId);
		User targetUser = userDAO.findUserByPlayerName(playerName);
		if(targetUser == null){
			throw new GameException(GameException.CODE_用户不存在, "");
		}else if(userId == targetUser.getUserId()){
			throw new GameException(GameException.CODE_该功能不支持对自己操作, "");
		}else{
			targetUser = userService.getUser(targetUser.getUserId(), targetUser);
			if(targetUser.getLevel() < SystemConstant.FRIEND_OPEN_LEVEL){
				throw new GameException(GameException.CODE_对方功能未开放, "");
			}
			int count = friendDAO.queryFriendCount(targetUser.getUserId());
			if(count >= privilegeService.getPrivilegesValue(targetUser, SystemConstant.PRIVILEGE_TYPE_MAX_FRIEND_NUMBER)){
				throw new GameException(GameException.CODE_对方好友已满, "");
			}
			Friend friend = getFriendData(userId, targetUser.getUserId());
			if(friend != null){
				throw new GameException(GameException.CODE_已成为好友, "");
			}
			FriendApply apply = getFriendApplyData(targetUser.getUserId(), userId);
			if(apply != null){
				throw new GameException(GameException.CODE_已申请过该玩家, "");
			}
			FriendApply targetApply = getFriendApplyData(userId, targetUser.getUserId());
			if(targetApply != null){
				agree(user, targetUser);
			}else{
				apply = new FriendApply();
				apply.setUserId(targetUser.getUserId());
				apply.setApplyUserId(userId);
				addFriendApplyData(apply);
				
				Head head = MessageFactory.getMessage(Head.class);
				head.init(MainCMD.FRIEND, FriendCMD.GAIN_APPLY_FRIEND);
				
				UserBaseinfoVO userBaseinfoVO = MessageFactory.getMessage(UserBaseinfoVO.class);
				UserBaseinfo info = userService.getUserBaseInfo(userId);
				userBaseinfoVO.init(info);
				
				FriendApplyVO friendApplyVO = MessageFactory.getMessage(FriendApplyVO.class);
				friendApplyVO.setTime(System.currentTimeMillis());
				friendApplyVO.setInfos(userBaseinfoVO);
				
				WorldServerAction action = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, WorldServerAction.class);
				action.sendMessage(targetUser.getUserId(), head, friendApplyVO);
			}
		}
	}

	@Override
	public FriendVO agreeApply(int userId, int applyUserId) {
		if(userId == applyUserId){
			throw new GameException(GameException.CODE_该功能不支持对自己操作, "");
		}else{
			FriendApply apply = getFriendApplyData(userId, applyUserId);
			if(apply == null){
				throw new GameException(GameException.CODE_申请不存在, "");
			}
			Friend friend = getFriendData(userId, applyUserId);
			if(friend != null){
				throw new GameException(GameException.CODE_已成为好友, "");
			}else{
				User user = userService.getOnlineUser(userId);
				int count = friendDAO.queryFriendCount(userId);
				if(count >= privilegeService.getPrivilegesValue(user, SystemConstant.PRIVILEGE_TYPE_MAX_FRIEND_NUMBER)){
					throw new GameException(GameException.CODE_好友已满, "");
				}
				User target = userService.getUser(applyUserId);
				count = friendDAO.queryFriendCount(applyUserId);
				if(count >= privilegeService.getPrivilegesValue(target, SystemConstant.PRIVILEGE_TYPE_MAX_FRIEND_NUMBER)){
					throw new GameException(GameException.CODE_对方好友已满, "");
				}
				agree(user, target);
			}
		}
		FriendVO vo = MessageFactory.getMessage(FriendVO.class);
		vo.setState(0);
		UserBaseinfoVO info = MessageFactory.getMessage(UserBaseinfoVO.class);
		info.init(userService.getUserBaseInfo(applyUserId));
		vo.setInfo(info);
		return vo;
	}
	
	/**
	 * 同意申请
	 */
	private void agree(User user, User target){
		addFriend(user, target, true); //自己(true为删除对方申请)
		addFriend(target, user, false);  //对方
	}
	/**
	 * 添加好友
	 */
	private void addFriend(User user, User target, boolean agree){
		Friend friend = new Friend();
		friend.setUserId(user.getUserId());
		friend.setFriendId(target.getUserId());
		addFriendData(friend);
		if(agree){
			deleteFriendApplyData(user.getUserId(), target.getUserId());
		}
		AgreeFriendEvent event2 = new AgreeFriendEvent(friend);
		TimerController.submitGameEvent(event2);
	}

	@Override
	public void deleteFriend(int userId, int friendId) {
		deleteFriendData(userId, friendId);
		deleteFriendData(friendId, userId);
	}

	@Override
	public void givingStamina(final int userId, List<Integer> friendIds) {
		if(!friendIds.isEmpty()){ 
			boolean update = false;
			UserStat stat = userService.getUserStat(userId);
			for(final int friendId : friendIds){
				Friend friend = getFriendData(friendId, userId);
				if(friend != null && stat.getGivingFriend().indexOf(friendId) == -1){
					update = true;
					stat.getGivingFriendList().add(friendId);
					friend.setState(friend.getState() + 1);
					updateFriendData(friend);
					TimerController.submitGameEvent(new GameEvent() {
						@Override
						public void runEvent() throws Exception {
							Head head = MessageFactory.getMessage(Head.class);
							head.init(MainCMD.FRIEND, FriendCMD.GAIN_GIVING_STAMINA);
							WorldServerAction action = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, WorldServerAction.class);
							action.sendMessage(friendId, head, userId);
						}
					});
				}
			}
			if(update){
				SQLOpt opt = new SQLOpt();
				opt.putFieldOpt(UserStatTable.GIVINGFRIEND, SQLOpt.EQUAL);
				userService.updateUserStat(stat, opt);
			}
		}
	}

	@Override
	public void collectStamina(int userId, List<Integer> friendIds) {  
		User user = userService.getOnlineUser(userId);
		int state = 0;
		for(int friendId : friendIds){
			Friend friend = getFriendData(userId, friendId);
			if(friend != null && friend.getState() > 0){
				state += friend.getState();
				friend.setState(0);
				updateFriendData(friend);
			}
		}
		if(state > 0){
			effectService.addIncome(user, SystemConstant.ITEM_EFFECT_TYPE_STAMINA, state * 6, null, false, SystemConstant.LOGGER_APPROACH_好友赠送);
		}else{
			throw new GameException(GameException.CODE_参数错误, "");
		}
	}

	@Override
	public void deleteApply(int userId, List<Integer> applyUserIds) {
		for(int applyUserId : applyUserIds){
			deleteFriendApplyData(userId, applyUserId);
		}
	}

	@Override
	public FriendRecoVO gainFriendReco(int userId) {
		FriendReco fr = getFriendRecoData(userId);
		if(fr == null){
			fr = new FriendReco();
			fr.setUserId(userId);
			fr.setRecoFriendList(new ArrayList<Integer>());
			fr.setUpdateTime(new Date());
			addFriendRecoData(fr);
			refFriendReco(fr);
		}
		FriendRecoVO vo = createRecoVO(fr);
		return vo;
	}

	private FriendRecoVO createRecoVO(FriendReco fr) {
		FriendRecoVO vo = MessageFactory.getMessage(FriendRecoVO.class);
		vo.setUpdateTime(fr.getUpdateTime().getTime());
		vo.setRecoFriends(new ArrayList<UserBaseinfoVO>());
		List<UserBaseinfo> infos = userService.getUserBaseInfo(fr.getRecoFriendList());
		for(UserBaseinfo info : infos){
			UserBaseinfoVO ivo = MessageFactory.getMessage(UserBaseinfoVO.class);
			ivo.init(info);
			vo.getRecoFriends().add(ivo);
		}
		return vo;
	}
	public void refFriendReco(FriendReco reco) {
		int userId = reco.getUserId();
		User user = userService.getOnlineUser(userId);
		List<Integer> ids = new ArrayList<>();
		Collection<Friend> friends = getFriendDatas(userId);
		for(Friend friend : friends){
			ids.add(friend.getFriendId());
		}
		List<Integer> olds = reco.getRecoFriendList();
		if(olds != null && !olds.isEmpty()){
			ids.addAll(olds);
		}
		ids.add(user.getUserId());
		WorldUserAction action = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, WorldUserAction.class);
		List<Integer> list = action.getOnlineUserIds();
		List<Integer> userIds = new ArrayList<>();
		for(Integer uid : list){
			User other = userService.queryCacheUser(userId);
			if(other != null && !ids.contains(uid) && other.getLevel() >= SystemConstant.FRIEND_OPEN_LEVEL){
				userIds.add(uid);
			}
		}
		if(userIds.size() > 3){
			List<Integer> newIds = new ArrayList<>();
			int size = userIds.size();
			for(int i = 0; i < 3; i++){
				int random = MathUtil.nextInt(size);
				int oId = userIds.get(random);
				while(newIds.contains(random)){
					random = MathUtil.nextInt(size);
					oId = userIds.get(random);
				}
				newIds.add(oId);
			}
			userIds = newIds;
		}else{
			int level = user.getLevel();
			if(user.getLevel() - SystemConstant.FRIEND_RECO_LEVEL_FLOAT < SystemConstant.FRIEND_OPEN_LEVEL){
				level = SystemConstant.FRIEND_OPEN_LEVEL + SystemConstant.FRIEND_RECO_LEVEL_FLOAT;
			}
			List<Integer> newIds = userDAO.gainUserLevel(level, ids.size() + 3);
			int size = 3 - userIds.size();
			for(int i = 0; i < size; i++){
				Iterator<Integer> it = newIds.iterator();
				while(it.hasNext()){
					int id = it.next();
					it.remove();
					if(!userIds.contains(id) && !ids.contains(id)){
						userIds.add(id);
						break;
					}
				}
			}
			
		}
		if(userIds.size() < 3){
			int addSize = 3 - userIds.size();
			ids.addAll(userIds);
			int level = user.getLevel();
			List<Integer> uids = null;
			while(addSize > 0){
				uids = userDAO.queryRecoIds(ids, level, addSize);
				userIds.addAll(uids);
				addSize -= uids.size();
				if(addSize > 0){
					level -= 20;
					if(level < SystemConstant.FRIEND_OPEN_LEVEL){
						break;
					}
					ids.addAll(uids);
				}
			}
		}
		reco.setRecoFriendList(userIds);
		reco.setUpdateTime(new Date());
		updateFriendRecoData(reco);
	}
	
	@Override
	public FriendRecoVO refFriendReco(int userId) {
		User user = userService.getOnlineUser(userId);
		if(user.getLevel() < SystemConstant.FRIEND_OPEN_LEVEL){
			throw new GameException(GameException.CODE_功能未开放, "");
		}
		FriendReco reco = getFriendRecoData(userId);
		refFriendReco(reco);
		return createRecoVO(reco);
	}


	@Override
	public List<UserBaseinfoVO> getBattleFriend(int userId) {
		User user = userService.getOnlineUser(userId);
		List<Integer> userIds = userDAO.gainUserLevel(user.getLevel(),5);
		Iterator<Integer> it = userIds.iterator();
		while(it.hasNext()){
			int uid = it.next();
			if(uid == userId){
				it.remove();
			}
		}
		List<UserBaseinfo> info = userService.getUserBaseInfo(userIds);
		List<UserBaseinfoVO> vos = new ArrayList<UserBaseinfoVO>();
		for(UserBaseinfo ubi : info){
			UserBaseinfoVO vo = MessageFactory.getMessage(UserBaseinfoVO.class);
			vo.init(ubi);
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public int receiveHireGp(int userId) {   
//		UserStat stat = userStatDAO.queryUserStat(userId);
		UserStat stat = userService.getUserStat(userId);
		if(stat.getHireGp() == 0){
			return 0;
		}
		User user = userService.getOnlineUser(userId);
		effectService.addIncome(user, SystemConstant.ITEM_EFFECT_TYPE_GP, stat.getHireGp(), null, false, SystemConstant.LOGGER_APPROACH_领取雇佣GP);
		
		SQLOpt opt = new SQLOpt();
		opt.putFieldOpt(UserStatTable.HIREGP, SQLOpt.EQUAL);
//		userStatDAO.updateUserStat(opt, stat);
		userService.updateUserStat(stat, opt);
		
		return stat.getHireGp();
	}
	
}
