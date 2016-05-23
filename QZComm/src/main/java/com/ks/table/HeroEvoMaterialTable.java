package com.ks.table;
public final class HeroEvoMaterialTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.HeroEvoMaterial>{
public static HeroEvoMaterialTable instance;
public static final String TABLE_NAME="t_hero_evo_material";
public static final String EVOID="evo_id";
public static final String TYPE="type";
public static final String ASSID="ass_id";
public static final String NUM="num";

public static final String J_EVOID="evoId";
public static final String J_TYPE="type";
public static final String J_ASSID="assId";
public static final String J_NUM="num";

public HeroEvoMaterialTable(){
mapper=new DBRowMapper_HeroEvoMaterial();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.HeroEvoMaterial bean, String fname){
if(EVOID.equals(fname)){
return bean.getEvoId();
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
return com.ks.db.cfg.HeroEvoMaterial.class;
}
public final static class DBRowMapper_HeroEvoMaterial implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.HeroEvoMaterial>{
@Override
public com.ks.db.cfg.HeroEvoMaterial rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.HeroEvoMaterial bean = new com.ks.db.cfg.HeroEvoMaterial();
bean.setEvoId(rs.getInt("evo_id"));
bean.setType(rs.getInt("type"));
bean.setAssId(rs.getInt("ass_id"));
bean.setNum(rs.getInt("num"));
return bean;
}
}
}
