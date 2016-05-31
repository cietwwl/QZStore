package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

import lombok.Data;
/**
 * 用户图鉴
 * @author ks
 */
@Data
@DBBeanSet(primaryKey={"user_id", "hero_id"})
public class UserHeroMap implements Serializable {
	private static final long serialVersionUID = 1L;
	/**用户编号*/
	@DBFieldSet(dbfname="user_id")
	private int userId;
	/**英雄编号*/
	@DBFieldSet(dbfname="hero_id")
	private int heroId;
	/**创建时间*/
	@DBFieldSet(dbfname="create_time")
	private Date createTime = new Date();
}
