package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.cache.JedisFieldSet;
import com.ks.util.StringUtil;

/**
 * 用户队伍
 * @author ks
 */
@DBBeanSet(tablename="t_user_team", primaryKey="user_id")
@Data
public class UserTeam implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**用户编号*/
	@DBFieldSet(dbfname="user_id")
	@JedisFieldSet
	private int userId;
	/**英雄*/
	@DBFieldSet(dbfname="heros")
	@JedisFieldSet
	private String heros;
	/**位置*/
	@DBFieldSet(dbfname="pos")
	@JedisFieldSet
	private String pos;
	/**创建时间*/
	@DBFieldSet(dbfname="create_time")
	@JedisFieldSet
	private Date createTime = new Date();
	/**修改时间*/
	@DBFieldSet(dbfname="update_time")
	@JedisFieldSet
	private Date updateTime = new Date();
	
	private List<Integer> heroList;
	private List<Integer> posList;
	private void initHeroList(){
		heroList = StringUtil.stringToList1(heros);
	}
	private void initHeros(){
		heros = StringUtil.listToString(heroList);
	}
	private void initPosList(){
		posList = StringUtil.stringToList1(pos);
	}
	private void initPos(){
		pos = StringUtil.listToString(posList);
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getHeros() {
		initHeros();
		return heros;
	}
	public void setHeros(String heros) {
		this.heros = heros;
		initHeroList();
	}
	public String getPos() {
		initPos();
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
		initPosList();
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
