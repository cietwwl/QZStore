package com.ks.db.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.util.StringUtil;
/**
 * 用户副本
 * @author ks
 */
@DBBeanSet(primaryKey={"user_id", "zone_id"})
@Data
public class UserZone implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**用户编号*/
	@DBFieldSet(dbfname="user_id")
	private int userId;
	/**战场编号*/
	@DBFieldSet(dbfname="zone_id")
	private int zoneId;
	/**副本类型*/
	@DBFieldSet(dbfname="zone_type")
	private int zoneType;
	/**是否通过*/
	@DBFieldSet(dbfname="curr_battle")
	private int currBattle;
	/**获得奖励的星数*/
	@DBFieldSet(dbfname="gain_award_star")
	private String gainAwardStar;
	/**创建时间*/
	@DBFieldSet(dbfname="create_time")
	private Date createTime = new Date();
	/**修改时间*/
	@DBFieldSet(dbfname="update_time")
	private Date updateTime = new Date();
	
	@JsonIgnore
	private List<Integer> gainAwardStarList = new ArrayList<>();
	private void initGainAwardStarList(){
		gainAwardStarList = StringUtil.stringToList(gainAwardStar);
	}
	private void initGainAwardStars(){
		gainAwardStar = StringUtil.listToString(gainAwardStarList);
	}
	public String getGainAwardStar() {
		initGainAwardStars();
		return gainAwardStar;
	}
	public void setGainAwardStar(String gainAwardStar) {
		this.gainAwardStar = gainAwardStar;
		initGainAwardStarList();
	}
}
