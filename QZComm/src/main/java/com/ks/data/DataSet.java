package com.ks.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.ks.db.model.User;
import com.ks.db.model.UserEquipment;
import com.ks.db.model.UserEternal;
import com.ks.db.model.UserHero;
import com.ks.db.model.UserProp;
import com.ks.db.model.UserRecord;
import com.ks.db.model.UserStat;

public class DataSet implements Serializable{
	private static final long serialVersionUID = 1L;
	private int userId;
	private User user;
	private UserStat userStat;
	private UserRecord userRecord;
	private List<UserHero> heros = new ArrayList<UserHero>();
	private List<UserProp> props = new ArrayList<UserProp>();
	private List<UserEquipment> equips = new ArrayList<UserEquipment>();
	private List<UserEternal> eternals = new ArrayList<UserEternal>();
	
	private List<Integer> deleteHeroIds = new ArrayList<Integer>();
	private List<Integer> deleteEquipIds = new ArrayList<Integer>();
	private List<Integer> deleteEternalIds = new ArrayList<Integer>();
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserStat getUserStat() {
		return userStat;
	}
	public void setUserStat(UserStat userStat) {
		this.userStat = userStat;
	}
	public UserRecord getUserRecord() {
		return userRecord;
	}
	public void setUserRecord(UserRecord userRecord) {
		this.userRecord = userRecord;
	}
	public List<UserHero> getHeros() {
		return heros;
	}
	public void setHeros(List<UserHero> heros) {
		this.heros = heros;
	}
	public List<UserProp> getProps() {
		return props;
	}
	public void setProps(List<UserProp> props) {
		this.props = props;
	}
	public List<UserEquipment> getEquips() {
		return equips;
	}
	public void setEquips(List<UserEquipment> equips) {
		this.equips = equips;
	}
	public List<UserEternal> getEternals() {
		return eternals;
	}
	public void setEternals(List<UserEternal> eternals) {
		this.eternals = eternals;
	}
	public List<Integer> getDeleteHeroIds() {
		return deleteHeroIds;
	}
	public void setDeleteHeroIds(List<Integer> deleteHeroIds) {
		this.deleteHeroIds = deleteHeroIds;
	}
	public List<Integer> getDeleteEquipIds() {
		return deleteEquipIds;
	}
	public void setDeleteEquipIds(List<Integer> deleteEquipIds) {
		this.deleteEquipIds = deleteEquipIds;
	}
	public List<Integer> getDeleteEternalIds() {
		return deleteEternalIds;
	}
	public void setDeleteEternalIds(List<Integer> deleteEternalIds) {
		this.deleteEternalIds = deleteEternalIds;
	}
}
