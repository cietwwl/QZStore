package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.constant.SystemConstant;
import com.ks.model.user.UserBaseinfo;

import lombok.Data;
/**
 * 公会
 * @author ks
 */
@Data
@DBBeanSet(tablename="t_guild", primaryKey={"guild_id"})
public class Guild implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**公会编号*/
	@DBFieldSet(dbfname="guild_id")
	private int guildId;
	/**公会名称*/
	@DBFieldSet(dbfname="name")
	private String name;
	/**会长编号*/
	@DBFieldSet(dbfname="cdr_user_id")
	private int cdrUserId;
	/**成员数量*/
	@DBFieldSet(dbfname="member_num")
	private int memberNum;
	/**经验*/
	@DBFieldSet(dbfname="exp")
	private int exp;
	/**技能点*/
	@DBFieldSet(dbfname="skill_point")
	private int skillPoint;
	/**状态*/
	@DBFieldSet(dbfname="state")
	private int state;
	/**创建时间*/
	@DBFieldSet(dbfname="create_time")
	private Date createTime = new Date();
	/**修改时间*/
	@DBFieldSet(dbfname="update_time")
	private Date updateTime = new Date();
	/**会长基本信息*/
	private UserBaseinfo cdrBaseInfo;
	/**
	 * 获得公会等级
	 * @return 公会等级
	 */
	public int getGuildLevel(){
		for(int i = 0; i < SystemConstant.GUILD_LEVEL_EXP.length; i++){
			if(exp < SystemConstant.GUILD_LEVEL_EXP[i]){
				return i+1;
			}
		}
		return SystemConstant.GUILD_LEVEL_EXP.length;
	}
}
