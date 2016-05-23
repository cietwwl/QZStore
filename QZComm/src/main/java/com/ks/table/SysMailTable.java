package com.ks.table;
public final class SysMailTable extends com.ks.access.DBBeanTable<com.ks.db.model.SysMail>{
public static SysMailTable instance;
public static final String TABLE_NAME="t_sys_mail";
public static final String ID="id";
public static final String PARTNER="partner";
public static final String SENDTYPE="sendType";
public static final String ENDID="endId";
public static final String UIDS="uids";
public static final String TITLE="title";
public static final String CONTENT="content";
public static final String ITEMS="items";
public static final String STARTTIME="startTime";
public static final String ENDTIME="endTime";
public static final String TIME="time";

public static final String J_ID="id";
public static final String J_PARTNER="partner";
public static final String J_SENDTYPE="sendType";
public static final String J_ENDID="endId";
public static final String J_UIDS="uids";
public static final String J_TITLE="title";
public static final String J_CONTENT="content";
public static final String J_ITEMS="items";
public static final String J_STARTTIME="startTime";
public static final String J_ENDTIME="endTime";
public static final String J_TIME="time";

public SysMailTable(){
mapper=new DBRowMapper_SysMail();
}
@Override
public Object getDBFieldValue(com.ks.db.model.SysMail bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(PARTNER.equals(fname)){
return bean.getPartner();
}
if(SENDTYPE.equals(fname)){
return bean.getSendType();
}
if(ENDID.equals(fname)){
return bean.getEndId();
}
if(UIDS.equals(fname)){
return bean.getUids();
}
if(TITLE.equals(fname)){
return bean.getTitle();
}
if(CONTENT.equals(fname)){
return bean.getContent();
}
if(ITEMS.equals(fname)){
return bean.getItems();
}
if(STARTTIME.equals(fname)){
return bean.getStartTime();
}
if(ENDTIME.equals(fname)){
return bean.getEndTime();
}
if(TIME.equals(fname)){
return bean.getTime();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.model.SysMail.class;
}
public final static class DBRowMapper_SysMail implements com.ks.access.mapper.RowMapper<com.ks.db.model.SysMail>{
@Override
public com.ks.db.model.SysMail rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.SysMail bean = new com.ks.db.model.SysMail();
bean.setId(rs.getInt("id"));
bean.setPartner(rs.getInt("partner"));
bean.setSendType(rs.getInt("sendType"));
bean.setEndId(rs.getInt("endId"));
bean.setUids(rs.getString("uids"));
bean.setTitle(rs.getString("title"));
bean.setContent(rs.getString("content"));
bean.setItems(rs.getString("items"));
bean.setStartTime(rs.getInt("startTime"));
bean.setEndTime(rs.getInt("endTime"));
bean.setTime(rs.getInt("time"));
return bean;
}
}
}
