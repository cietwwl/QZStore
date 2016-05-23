package com.ks.table;
public final class MailTable extends com.ks.access.DBBeanTable<com.ks.db.model.Mail>{
public static MailTable instance;
public static final String MAILID="mail_id";
public static final String USERID="user_id";
public static final String TYPE="type";
public static final String TITLE="title";
public static final String CONTEXT="context";
public static final String STATE="state";
public static final String GOODSES="goods";
public static final String CREATETIME="create_time";
public static final String UPDATETIME="update_time";

public static final String J_MAILID="mailId";
public static final String J_USERID="userId";
public static final String J_TYPE="type";
public static final String J_TITLE="title";
public static final String J_CONTEXT="context";
public static final String J_STATE="state";
public static final String J_GOODSES="goodses";
public static final String J_CREATETIME="createTime";
public static final String J_UPDATETIME="updateTime";

public MailTable(){
mapper=new DBRowMapper_Mail();
}
@Override
public Object getDBFieldValue(com.ks.db.model.Mail bean, String fname){
if(MAILID.equals(fname)){
return bean.getMailId();
}
if(USERID.equals(fname)){
return bean.getUserId();
}
if(TYPE.equals(fname)){
return bean.getType();
}
if(TITLE.equals(fname)){
return bean.getTitle();
}
if(CONTEXT.equals(fname)){
return bean.getContext();
}
if(STATE.equals(fname)){
return bean.getState();
}
if(GOODSES.equals(fname)){
return bean.getGoodses();
}
if(CREATETIME.equals(fname)){
return bean.getCreateTime();
}
if(UPDATETIME.equals(fname)){
return bean.getUpdateTime();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.model.Mail.class;
}
public final static class DBRowMapper_Mail implements com.ks.access.mapper.RowMapper<com.ks.db.model.Mail>{
@Override
public com.ks.db.model.Mail rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.Mail bean = new com.ks.db.model.Mail();
bean.setMailId(rs.getInt("mail_id"));
bean.setUserId(rs.getInt("user_id"));
bean.setType(rs.getInt("type"));
bean.setTitle(rs.getString("title"));
bean.setContext(rs.getString("context"));
bean.setState(rs.getInt("state"));
bean.setGoodses(rs.getString("goods"));
bean.setCreateTime(rs.getTimestamp("create_time"));
bean.setUpdateTime(rs.getTimestamp("update_time"));
return bean;
}
}
}
