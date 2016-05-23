package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.util.StringUtil;
/**
 * 弹劾
 * @author ks
 */
@DBBeanSet(tablename="t_guild_accuse", primaryKey="guild_id")
@Data
public class GuildAccuse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**公会编号*/
	@DBFieldSet(dbfname="guild_id")
	private int guildId;
	/**发起人*/
	@DBFieldSet(dbfname="originator")
	private int originator;
	/**玩家名*/
	@DBFieldSet(dbfname="player_name")
	private String playerName;
	/**响应人*/
	@DBFieldSet(dbfname="resper")
	private String resper;
	/**创建时间*/
	@DBFieldSet(dbfname="create_time")
	private Date createTime = new Date();
	/**修改时间*/
	@DBFieldSet(dbfname="update_time")
	private Date updateTime = new Date();
	private List<Integer> resperList;
	private void initResperList(){
		resperList = StringUtil.stringToList(resper);
	}
	private void initRespers(){
		resper = StringUtil.listToString(resperList);
	}
	public int getGuildId() {
		return guildId;
	}
	public void setGuildId(int guildId) {
		this.guildId = guildId;
	}
	public int getOriginator() {
		return originator;
	}
	public void setOriginator(int originator) {
		this.originator = originator;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getResper() {
		initRespers();
		return resper;
	}
	public void setResper(String resper) {
		this.resper = resper;
		initResperList();
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
