package com.ks.table;
public final class AchieveTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.Achieve>{
public static AchieveTable instance;
public static final String TABLE_NAME="t_achieve";
public static final String ACHIEVEID="achieve_id";
public static final String NAME="name";
public static final String TYPE="type";
public static final String ASSID="ass_id";
public static final String NUM="num";

public static final String J_ACHIEVEID="achieveId";
public static final String J_NAME="name";
public static final String J_TYPE="type";
public static final String J_ASSID="assId";
public static final String J_NUM="num";

public AchieveTable(){
mapper=new DBRowMapper_Achieve();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.Achieve bean, String fname){
if(ACHIEVEID.equals(fname)){
return bean.getAchieveId();
}
if(NAME.equals(fname)){
return bean.getName();
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
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.Achieve.class;
}
public final static class DBRowMapper_Achieve implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.Achieve>{
@Override
public com.ks.db.cfg.Achieve rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.Achieve bean = new com.ks.db.cfg.Achieve();
bean.setAchieveId(rs.getInt("achieve_id"));
bean.setName(rs.getString("name"));
bean.setType(rs.getInt("type"));
bean.setAssId(rs.getInt("ass_id"));
bean.setNum(rs.getInt("num"));
return bean;
}
}
}
