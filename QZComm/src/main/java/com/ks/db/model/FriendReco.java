package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

import lombok.Data;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.cache.JedisBeanSet;
import com.ks.cache.JedisFieldSet;
import com.ks.util.StringUtil;
/**
 * 好友推荐
 * @author ks
 */
@DBBeanSet(tablename="t_friend_reco", primaryKey={"user_id"})
@JedisBeanSet
@Data
public class FriendReco implements Serializable {
	private static final long serialVersionUID = 1L;
	/**用户编号*/
	@DBFieldSet(dbfname="user_id")
	@JedisFieldSet
	private int userId;
	/**推荐好友*/
	@DBFieldSet(dbfname="reco_friends")
	@JedisFieldSet
	private String recoFriends;
	/**创建时间*/
	@DBFieldSet(dbfname="create_time")
	@JedisFieldSet
	private Date createTime = new Date();
	/**修改时间*/
	@DBFieldSet(dbfname="update_time")
	@JedisFieldSet
	private Date updateTime = new Date();
	/**推荐好友*/
	@JsonIgnore
	private List<Integer> recoFriendList;
	private void initRecoFriendList(){
		recoFriendList = StringUtil.stringToList(recoFriends);
	}
	private void initRecoFriends(){
		recoFriends = StringUtil.listToString(recoFriendList);
	}
	public String getRecoFriends() {
		initRecoFriends();
		return recoFriends;
	}
	public void setRecoFriends(String recoFriends) {
		this.recoFriends = recoFriends;
		initRecoFriendList();
	}
	
	
}
