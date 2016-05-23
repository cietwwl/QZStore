package com.ks.table;
public final class SlateLoggerTable extends com.ks.access.DBBeanTable<com.ks.db.log.SlateLogger>{
public static SlateLoggerTable instance;
public static final String TABLE_NAME="t_slate_logger";
public static final String ID="id";
public static final String USERID="user_id";
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
public static final String J_LOGGERTYPE="loggerType";
public static final String J_TYPE="type";
public static final String J_ASSID="assId";
public static final String J_NUM="num";
public static final String J_DESCRIPTION="description";
public static final String J_CREATETIME="createTime";
public static final String J_ORIGINALAMOUNT="originalAmount";
public static final String J_SURPLUSAMOUNT="surplusAmount";

public SlateLoggerTable(){
mapper=new DBRowMapper_SlateLogger();
}
@Override
public Object getDBFieldValue(com.ks.db.log.SlateLogger bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(USERID.equals(fname)){
return bean.getUserId();
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
return com.ks.db.log.SlateLogger.class;
}
public final static class DBRowMapper_SlateLogger implements com.ks.access.mapper.RowMapper<com.ks.db.log.SlateLogger>{
@Override
public com.ks.db.log.SlateLogger rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.log.SlateLogger bean = new com.ks.db.log.SlateLogger();
bean.setId(rs.getInt("id"));
bean.setUserId(rs.getInt("user_id"));
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
