package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

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
	@JsonIgnore
	private List<Integer> resperList;
	private void initResperList(){
		resperList = StringUtil.stringToList(resper);
	}
	private void initRespers(){
		resper = StringUtil.listToString(resperList);
	}
	public String getResper() {
		initRespers();
		return resper;
	}
	public void setResper(String resper) {
		this.resper = resper;
		initResperList();
	}
	
}
