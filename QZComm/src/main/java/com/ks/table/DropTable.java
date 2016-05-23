package com.ks.table;
public final class DropTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.Drop>{
public static DropTable instance;
public static final String TABLE_NAME="t_drop";
public static final String MONSTERID="monster_id";
public static final String TYPE="type";
public static final String ASSID="ass_id";
public static final String NUM="num";
public static final String RATE="rate";

public static final String J_MONSTERID="monsterId";
public static final String J_TYPE="type";
public static final String J_ASSID="assId";
public static final String J_NUM="num";
public static final String J_RATE="rate";

public DropTable(){
mapper=new DBRowMapper_Drop();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.Drop bean, String fname){
if(MONSTERID.equals(fname)){
return bean.getMonsterId();
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
if(RATE.equals(fname)){
return bean.getRate();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.Drop.class;
}
public final static class DBRowMapper_Drop implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.Drop>{
@Override
public com.ks.db.cfg.Drop rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.Drop bean = new com.ks.db.cfg.Drop();
bean.setMonsterId(rs.getInt("monster_id"));
bean.setType(rs.getInt("type"));
bean.setAssId(rs.getInt("ass_id"));
bean.setNum(rs.getInt("num"));
bean.setRate(rs.getDouble("rate"));
return bean;
}
}
}
