package com.ks.table;
public final class DropTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.Drop>{
public static DropTable instance;
public static final String TABLE_NAME="t_drop";
public static final String MONSTERID="monsterId";
public static final String DROPITEMS="dropItems";

public static final String J_MONSTERID="monsterId";
public static final String J_DROPITEMS="dropItems";

public DropTable(){
mapper=new DBRowMapper_Drop();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.Drop bean, String fname){
if(MONSTERID.equals(fname)){
return bean.getMonsterId();
}
if(DROPITEMS.equals(fname)){
return bean.getDropItems();
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
bean.setMonsterId(rs.getInt("monsterId"));
bean.setDropItems(rs.getString("dropItems"));
return bean;
}
}
}
