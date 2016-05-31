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

@Data
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
}
