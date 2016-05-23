package com.ks.logic.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ks.data.DataSet;
import com.ks.data.DataSetCache;
import com.ks.data.IDataSetHandler;
import com.ks.db.model.User;
import com.ks.db.model.UserEquipment;
import com.ks.db.model.UserEternal;
import com.ks.db.model.UserHero;
import com.ks.db.model.UserProp;
import com.ks.db.model.UserRecord;
import com.ks.db.model.UserStat;
import com.ks.logic.event.DataUpdateEvent;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.DataService;
import com.ks.timer.TimerController;

public class DataServiceImpl extends BaseService implements DataService, IDataSetHandler {

	private final static String SET_KEY = "set_";
	
	@Override
	public void updateUser(User user) {
		String key = SET_KEY + user.getUserId();
		DataSet set = DataSetCache.getDataSet(key);
		set.setUserId(user.getUserId());
		set.setUser(user);
	}

	@Override
	public void updateUserStat(UserStat stat) {
		String key = SET_KEY + stat.getUserId();
		DataSet set = DataSetCache.getDataSet(key);
		set.setUserId(stat.getUserId());
		set.setUserStat(stat);
	}

	@Override
	public void updateProp(int userId, UserProp... prop) {
		List<UserProp> list = new ArrayList<UserProp>();
		for(UserProp p : prop){
			list.add(p);
		}
		updateProps(userId, list);
	}

	@Override
	public void updateProps(int userId, List<UserProp> props) {
		String key = SET_KEY + userId;
		DataSet set = DataSetCache.getDataSet(key);
		set.setUserId(userId);
		List<UserProp> list = set.getProps();
		if(list == null){
			list = new ArrayList<UserProp>();
			set.setProps(list);
		}
		list.addAll(props);
	}

	@Override
	public void updateEquip(int userId, UserEquipment... equip) {
		List<UserEquipment> list = new ArrayList<UserEquipment>();
		for(UserEquipment e : equip){
			list.add(e);
		}
		updateEquips(userId, list);
	}

	@Override
	public void updateEquips(int userId, List<UserEquipment> equips) {
		String key = SET_KEY + userId;
		DataSet set = DataSetCache.getDataSet(key);
		set.setUserId(userId);
		List<UserEquipment> list = set.getEquips();
		if(list == null){
			list = new ArrayList<UserEquipment>();
			set.setEquips(list);
		}
		list.addAll(equips);
	}
	@Override
	public void deleteEquip(int userId, int... id) {
		List<Integer> ids = new ArrayList<Integer>();
		for(int i : id){
			ids.add(i);
		}
		deleteEquips(userId, ids);
	}
	
	@Override
	public void deleteEquips(int userId, List<Integer> ids){
		String key = SET_KEY + userId;
		DataSet set = DataSetCache.getDataSet(key);
		set.setUserId(userId);
		List<Integer> list = set.getDeleteEquipIds();
		if(list == null){
			list = new ArrayList<Integer>();
			set.setDeleteEquipIds(list);
		}
		list.addAll(ids);
	}

	@Override
	public void updateEternal(int userId, UserEternal... eternal) {
		List<UserEternal> list = new ArrayList<UserEternal>();
		for(UserEternal e : eternal){
			list.add(e);
		}
		updateEternals(userId, list);
	}

	@Override
	public void updateEternals(int userId, List<UserEternal> eternals) {
		String key = SET_KEY + userId;
		DataSet set = DataSetCache.getDataSet(key);
		set.setUserId(userId);
		List<UserEternal> list = set.getEternals();
		if(list == null){
			list = new ArrayList<UserEternal>();
			set.setEternals(list);
		}
		list.addAll(eternals);
	}
	
	@Override
	public void deleteEternal(int userId, int... id) {
		List<Integer> ids = new ArrayList<Integer>();
		for(int i : id){
			ids.add(i);
		}
		deleteEternals(userId, ids);
	}
	
	@Override
	public void deleteEternals(int userId, List<Integer> ids){
		String key = SET_KEY + userId;
		DataSet set = DataSetCache.getDataSet(key);
		set.setUserId(userId);
		List<Integer> list = set.getDeleteEternalIds();
		if(list == null){
			list = new ArrayList<Integer>();
			set.setDeleteEternalIds(list);
		}
		list.addAll(ids);
	}

	@Override
	public void updateHero(int userId, UserHero... hero) {
		List<UserHero> list = new ArrayList<UserHero>();
		for(UserHero h : hero){
			list.add(h);
		}
		updateHeros(userId, list);
	}

	@Override
	public void updateHeros(int userId, List<UserHero> heros) {
		String key = SET_KEY + userId;
		DataSet set = DataSetCache.getDataSet(key);
		set.setUserId(userId);
		List<UserHero> list = set.getHeros();
		if(list == null){
			list = new ArrayList<UserHero>();
			set.setHeros(list);
		}
		list.addAll(heros);
	}
	
	@Override
	public void deleteHero(int userId, int... id) {
		List<Integer> ids = new ArrayList<Integer>();
		for(int i : id){
			ids.add(i);
		}
		deleteHeros(userId, ids);
	}
	
	@Override
	public void deleteHeros(int userId, List<Integer> ids){
		String key = SET_KEY + userId;
		DataSet set = DataSetCache.getDataSet(key);
		set.setUserId(userId);
		List<Integer> list = set.getDeleteHeroIds();
		if(list == null){
			list = new ArrayList<Integer>();
			set.setDeleteHeroIds(list);
		}
		list.addAll(ids);
	}
	
	public void flushThreadData(){
		Map<String, DataSet> map = DataSetCache.getThreadData();
		if(map != null){
			for(DataSet set : map.values()){
				DataUpdateEvent event = new DataUpdateEvent(set);
				TimerController.submitGameEvent(event);
			}
		}
	}
	
	@Override
	public void updateUserRecord(UserRecord userRecord){
		String key = SET_KEY + userRecord.getId();
		DataSet set = DataSetCache.getDataSet(key);
		if(set.getUserId() != userRecord.getId()){
			set.setUserId(userRecord.getId());
		}
		set.setUserRecord(userRecord);
	}

}
