package com.ks.table;
public final class PropTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.Prop>{
public static PropTable instance;
public static final String TABLE_NAME="t_prop";
public static final String PROPID="prop_id";
public static final String NAME="name";
public static final String TYPE="type";
public static final String USE="use";
public static final String SELL="sell";
public static final String SELLPRICE="sell_price";
public static final String EXPENDITEMS="expendItems";
public static final String GAINITEMS="gainItems";

public static final String J_PROPID="propId";
public static final String J_NAME="name";
public static final String J_TYPE="type";
public static final String J_USE="use";
public static final String J_SELL="sell";
public static final String J_SELLPRICE="sellPrice";
public static final String J_EXPENDITEMS="expendItems";
public static final String J_GAINITEMS="gainItems";

public PropTable(){
mapper=new DBRowMapper_Prop();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.Prop bean, String fname){
if(PROPID.equals(fname)){
return bean.getPropId();
}
if(NAME.equals(fname)){
return bean.getName();
}
if(TYPE.equals(fname)){
return bean.getType();
}
if(USE.equals(fname)){
return bean.isUse();
}
if(SELL.equals(fname)){
return bean.isSell();
}
if(SELLPRICE.equals(fname)){
return bean.getSellPrice();
}
if(EXPENDITEMS.equals(fname)){
return bean.getExpendItems();
}
if(GAINITEMS.equals(fname)){
return bean.getGainItems();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.Prop.class;
}
public final static class DBRowMapper_Prop implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.Prop>{
@Override
public com.ks.db.cfg.Prop rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.Prop bean = new com.ks.db.cfg.Prop();
bean.setPropId(rs.getInt("prop_id"));
bean.setName(rs.getString("name"));
bean.setType(rs.getInt("type"));
bean.setUse(rs.getBoolean("use"));
bean.setSell(rs.getBoolean("sell"));
bean.setSellPrice(rs.getInt("sell_price"));
bean.setExpendItems(rs.getString("expendItems"));
bean.setGainItems(rs.getString("gainItems"));
return bean;
}
}
}
