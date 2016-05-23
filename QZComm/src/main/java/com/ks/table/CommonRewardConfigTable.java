package com.ks.table;
public final class CommonRewardConfigTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.CommonRewardConfig>{
public static CommonRewardConfigTable instance;
public static final String TABLE_NAME="t_common_reward";
public static final String ID="n_id";
public static final String TIPS="n_tips";
public static final String GAIN="n_gain";
public static final String RESET="n_reset";
public static final String TYPE="n_type";
public static final String GROUP="n_group";
public static final String CONDITIONS="n_conditions";
public static final String ITEMS="n_items";

public static final String J_ID="id";
public static final String J_TIPS="tips";
public static final String J_GAIN="gain";
public static final String J_RESET="reset";
public static final String J_TYPE="type";
public static final String J_GROUP="group";
public static final String J_CONDITIONS="conditions";
public static final String J_ITEMS="items";

public CommonRewardConfigTable(){
mapper=new DBRowMapper_CommonRewardConfig();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.CommonRewardConfig bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(TIPS.equals(fname)){
return bean.getTips();
}
if(GAIN.equals(fname)){
return bean.getGain();
}
if(RESET.equals(fname)){
return bean.getReset();
}
if(TYPE.equals(fname)){
return bean.getType();
}
if(GROUP.equals(fname)){
return bean.getGroup();
}
if(CONDITIONS.equals(fname)){
return bean.getConditions();
}
if(ITEMS.equals(fname)){
return bean.getItems();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.CommonRewardConfig.class;
}
public final static class DBRowMapper_CommonRewardConfig implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.CommonRewardConfig>{
@Override
public com.ks.db.cfg.CommonRewardConfig rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.CommonRewardConfig bean = new com.ks.db.cfg.CommonRewardConfig();
bean.setId(rs.getInt("n_id"));
bean.setTips(rs.getString("n_tips"));
bean.setGain(rs.getInt("n_gain"));
bean.setReset(rs.getInt("n_reset"));
bean.setType(rs.getInt("n_type"));
bean.setGroup(rs.getInt("n_group"));
bean.setConditions(rs.getString("n_conditions"));
bean.setItems(rs.getString("n_items"));
return bean;
}
}
}
