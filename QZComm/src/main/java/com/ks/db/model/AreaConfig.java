package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

import lombok.Data;
/**
 * 大区配置
 * @author ks
 */
@Data
@DBBeanSet(tablename="t_area_config", primaryKey={"id"})
public class AreaConfig implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**编号*/
	@DBFieldSet(dbfname="id")
	private int id;
	/**值*/
	@DBFieldSet(dbfname="value")
	private int value;
	/**创建时间*/
	@DBFieldSet(dbfname="create_time")
	private Date createTime = new Date();
	/**修改时间*/
	@DBFieldSet(dbfname="update_time")
	private Date updateTime = new Date();
	
}
