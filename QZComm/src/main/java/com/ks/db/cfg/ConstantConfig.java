package com.ks.db.cfg;

import java.io.Serializable;

import lombok.Data;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

@Data
@DBBeanSet(tablename="t_constant", createDeleteSql=false, createSelectSql=false, createInsertSql=false, createUpdateSql=false)
public class ConstantConfig implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@DBFieldSet(dbfname="n_id")
	private int id;
	@DBFieldSet(dbfname="n_module")
	private String module;
	@DBFieldSet(dbfname="n_name")
	private String name;
	@DBFieldSet(dbfname="n_value")
	private int value;
	@DBFieldSet(dbfname="n_tips")
	private String tips;

}
