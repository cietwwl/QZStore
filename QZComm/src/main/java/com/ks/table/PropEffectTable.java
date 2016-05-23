package com.ks.table;
public final class PropEffectTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.PropEffect>{
public static PropEffectTable instance;
public static final String TABLE_NAME="t_prop_effect";
public static final String PROPID="prop_id";
public static final String EFFECTID="effect_id";
public static final String VAL="val";
public static final String CD="cd";

public static final String J_PROPID="propId";
public static final String J_EFFECTID="effectId";
public static final String J_VAL="val";
public static final String J_CD="cd";

public PropEffectTable(){
mapper=new DBRowMapper_PropEffect();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.PropEffect bean, String fname){
if(PROPID.equals(fname)){
return bean.getPropId();
}
if(EFFECTID.equals(fname)){
return bean.getEffectId();
}
if(VAL.equals(fname)){
return bean.getVal();
}
if(CD.equals(fname)){
return bean.getCd();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.PropEffect.class;
}
public final static class DBRowMapper_PropEffect implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.PropEffect>{
@Override
public com.ks.db.cfg.PropEffect rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.PropEffect bean = new com.ks.db.cfg.PropEffect();
bean.setPropId(rs.getInt("prop_id"));
bean.setEffectId(rs.getInt("effect_id"));
bean.setVal(rs.getInt("val"));
bean.setCd(rs.getInt("cd"));
return bean;
}
}
}
