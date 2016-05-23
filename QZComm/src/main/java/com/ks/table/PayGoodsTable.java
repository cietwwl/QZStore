package com.ks.table;
public final class PayGoodsTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.PayGoods>{
public static PayGoodsTable instance;
public static final String TABLE_NAME="t_pay_goods";
public static final String ID="id";
public static final String MONEY="money";
public static final String TYPE="type";
public static final String NAME="name";
public static final String ICON="icon";
public static final String TASKICON="taskIcon";
public static final String ITEMS="items";
public static final String FIRSTITEMS="firstItems";
public static final String EXTRAITEMS="extraItems";
public static final String GAINDAY="gainDay";
public static final String BUYCD="buyCD";

public static final String J_ID="id";
public static final String J_MONEY="money";
public static final String J_TYPE="type";
public static final String J_NAME="name";
public static final String J_ICON="icon";
public static final String J_TASKICON="taskIcon";
public static final String J_ITEMS="items";
public static final String J_FIRSTITEMS="firstItems";
public static final String J_EXTRAITEMS="extraItems";
public static final String J_GAINDAY="gainDay";
public static final String J_BUYCD="buyCD";

public PayGoodsTable(){
mapper=new DBRowMapper_PayGoods();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.PayGoods bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(MONEY.equals(fname)){
return bean.getMoney();
}
if(TYPE.equals(fname)){
return bean.getType();
}
if(NAME.equals(fname)){
return bean.getName();
}
if(ICON.equals(fname)){
return bean.getIcon();
}
if(TASKICON.equals(fname)){
return bean.getTaskIcon();
}
if(ITEMS.equals(fname)){
return bean.getItems();
}
if(FIRSTITEMS.equals(fname)){
return bean.getFirstItems();
}
if(EXTRAITEMS.equals(fname)){
return bean.getExtraItems();
}
if(GAINDAY.equals(fname)){
return bean.getGainDay();
}
if(BUYCD.equals(fname)){
return bean.getBuyCD();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.PayGoods.class;
}
public final static class DBRowMapper_PayGoods implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.PayGoods>{
@Override
public com.ks.db.cfg.PayGoods rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.PayGoods bean = new com.ks.db.cfg.PayGoods();
bean.setId(rs.getInt("id"));
bean.setMoney(rs.getInt("money"));
bean.setType(rs.getInt("type"));
bean.setName(rs.getString("name"));
bean.setIcon(rs.getString("icon"));
bean.setTaskIcon(rs.getString("taskIcon"));
bean.setItems(rs.getString("items"));
bean.setFirstItems(rs.getString("firstItems"));
bean.setExtraItems(rs.getString("extraItems"));
bean.setGainDay(rs.getInt("gainDay"));
bean.setBuyCD(rs.getInt("buyCD"));
return bean;
}
}
}
