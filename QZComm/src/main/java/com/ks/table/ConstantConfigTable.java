package com.ks.table;
public final class ConstantConfigTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.ConstantConfig>{
public static ConstantConfigTable instance;
public static final String TABLE_NAME="t_constant";
public static final String ID="n_id";
public static final String MODULE="n_module";
public static final String NAME="n_name";
public static final String VALUE="n_value";
public static final String TIPS="n_tips";

public static final String J_ID="id";
public static final String J_MODULE="module";
public static final String J_NAME="name";
public static final String J_VALUE="value";
public static final String J_TIPS="tips";

public ConstantConfigTable(){
mapper=new DBRowMapper_ConstantConfig();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.ConstantConfig bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(MODULE.equals(fname)){
return bean.getModule();
}
if(NAME.equals(fname)){
return bean.getName();
}
if(VALUE.equals(fname)){
return bean.getValue();
}
if(TIPS.equals(fname)){
return bean.getTips();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.ConstantConfig.class;
}
public final static class DBRowMapper_ConstantConfig implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.ConstantConfig>{
@Override
public com.ks.db.cfg.ConstantConfig rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.ConstantConfig bean = new com.ks.db.cfg.ConstantConfig();
bean.setId(rs.getInt("n_id"));
bean.setModule(rs.getString("n_module"));
bean.setName(rs.getString("n_name"));
bean.setValue(rs.getInt("n_value"));
bean.setTips(rs.getString("n_tips"));
return bean;
}
}
}
