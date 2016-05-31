package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

import lombok.Data;

/**
 * 公会成员
 *
 */
@Data
@DBBeanSet(tablename="t_guild_member", primaryKey={"user_id"})
public class GuildMember implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**用户编号*/
	@DBFieldSet(dbfname="user_id")
	private int userId;
	/**公会编号*/
	@DBFieldSet(dbfname="guild_id")
	private int guildId;
	/**玩家名*/
	@DBFieldSet(dbfname="player_name")
	private String playerName;
	/**等级*/
	@DBFieldSet(dbfname="level")
	private int level;
	/**属性*/
	@DBFieldSet(dbfname="property")
	private int property;
	/**贡献*/
	@DBFieldSet(dbfname="devote")
	private int devote;
	/**今日贡献*/
	@DBFieldSet(dbfname="today_devote")
	private int todayDevote;
	/**创建时间*/
	@DBFieldSet(dbfname="create_time")
	private Date createTime = new Date();
	/**修改时间*/
	@DBFieldSet(dbfname="update_time")
	private Date updateTime = new Date();
	
	public static final GuildMember createGuildMember(int userId,int guildId,String playerName,int level,int property){
		GuildMember member = new GuildMember();
		member.setUserId(userId);
		member.setPlayerName(playerName);
		member.setGuildId(guildId);
		member.setProperty(property);
		member.setLevel(level);
		return member;
	}
}
