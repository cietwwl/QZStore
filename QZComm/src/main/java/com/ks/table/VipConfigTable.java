package com.ks.table;
public final class VipConfigTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.VipConfig>{
public static VipConfigTable instance;
public static final String TABLE_NAME="t_vip_config";
public static final String VIPLEVEL="n_vipLevel";
public static final String MONEY="n_money";
public static final String PRIVILEGES="n_privileges";

public static final String J_VIPLEVEL="vipLevel";
public static final String J_MONEY="money";
public static final String J_PRIVILEGES="privileges";

public VipConfigTable(){
mapper=new DBRowMapper_VipConfig();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.VipConfig bean, String fname){
if(VIPLEVEL.equals(fname)){
return bean.getVipLevel();
}
if(MONEY.equals(fname)){
return bean.getMoney();
}
if(PRIVILEGES.equals(fname)){
return bean.getPrivileges();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.VipConfig.class;
}
public final static class DBRowMapper_VipConfig implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.VipConfig>{
@Override
public com.ks.db.cfg.VipConfig rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.VipConfig bean = new com.ks.db.cfg.VipConfig();
bean.setVipLevel(rs.getInt("n_vipLevel"));
bean.setMoney(rs.getInt("n_money"));
bean.setPrivileges(rs.getString("n_privileges"));
return bean;
}
}
}
