//package com.ks.db.constant;
//
//import java.io.Serializable;
//
//import com.ks.access.DBBeanSet;
//import com.ks.access.DBFieldSet;
//
///**
// * 常数
// *
// */
//@DBBeanSet(tablename="t_constant", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
//public class ConstantConfig implements Serializable{
//	private static final long serialVersionUID = 1L;
//	
//	/**字段名称*/
//	@DBFieldSet(dbfname="n_name")
//	private String name = "";  
//	/**字段值*/
//	@DBFieldSet(dbfname="n_value")
//	private int value;  
//	/**提示说明*/
//	@DBFieldSet(dbfname="n_tips")
//	private String tips = "";   
//	
//	public String getName(){
//		return name;
//	}
//	public int getValue(){
//		return value;
//	}
//	public String getTips(){
//		return tips;
//	}
//}
