package com.ks.table;
public final class ExpLoggerTable extends com.ks.access.DBBeanTable<com.ks.db.log.ExpLogger>{
public static ExpLoggerTable instance;
public static final String TABLE_NAME="t_exp_logger";
public static final String ID="id";
public static final String USERID="user_id";
public static final String PLAYERNAME="playername";
public static final String LOGGERTYPE="logger_type";
public static final String TYPE="type";
public static final String ASSID="ass_id";
public static final String NUM="num";
public static final String DESCRIPTION="description";
public static final String CREATETIME="create_time";
public static final String ORIGINALAMOUNT="originalAmount";
public static final String SURPLUSAMOUNT="surplusAmount";

public static final String J_ID="id";
public static final String J_USERID="userId";
public static final String J_PLAYERNAME="playername";
public static final String J_LOGGERTYPE="loggerType";
public static final String J_TYPE="type";
public static final String J_ASSID="assId";
public static final String J_NUM="num";
public static final String J_DESCRIPTION="description";
public static final String J_CREATETIME="createTime";
public static final String J_ORIGINALAMOUNT="originalAmount";
public static final String J_SURPLUSAMOUNT="surplusAmount";

public ExpLoggerTable(){
mapper=new DBRowMapper_ExpLogger();
}
@Override
public Object getDBFieldValue(com.ks.db.log.ExpLogger bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(USERID.equals(fname)){
return bean.getUserId();
}
if(PLAYERNAME.equals(fname)){
return bean.getPlayername();
}
if(LOGGERTYPE.equals(fname)){
return bean.getLoggerType();
}
if(TYPE.equals(fname)){
return bean.getType();
}
if(ASSID.equals(fname)){
return bean.getAssId();
}
if(NUM.equals(fname)){
return bean.getNum();
}
if(DESCRIPTION.equals(fname)){
return bean.getDescription();
}
if(CREATETIME.equals(fname)){
return bean.getCreateTime();
}
if(ORIGINALAMOUNT.equals(fname)){
return bean.getOriginalAmount();
}
if(SURPLUSAMOUNT.equals(fname)){
return bean.getSurplusAmount();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.log.ExpLogger.class;
}
public final static class DBRowMapper_ExpLogger implements com.ks.access.mapper.RowMapper<com.ks.db.log.ExpLogger>{
@Override
public com.ks.db.log.ExpLogger rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.log.ExpLogger bean = new com.ks.db.log.ExpLogger();
bean.setId(rs.getInt("id"));
bean.setUserId(rs.getInt("user_id"));
bean.setPlayername(rs.getString("playername"));
bean.setLoggerType(rs.getInt("logger_type"));
bean.setType(rs.getInt("type"));
bean.setAssId(rs.getInt("ass_id"));
bean.setNum(rs.getInt("num"));
bean.setDescription(rs.getString("description"));
bean.setCreateTime(rs.getTimestamp("create_time"));
bean.setOriginalAmount(rs.getInt("originalAmount"));
bean.setSurplusAmount(rs.getInt("surplusAmount"));
return bean;
}
}
}
