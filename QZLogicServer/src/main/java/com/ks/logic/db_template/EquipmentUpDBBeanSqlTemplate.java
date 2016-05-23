package com.ks.logic.db_template;
public final class EquipmentUpDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.EquipmentUp>{
public EquipmentUpDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.EquipmentUp.class;
mapper = new com.ks.table.EquipmentUpTable.DBRowMapper_EquipmentUp();
sqlMap.put("queryEquipmentUp","select * from t_equipment_up");
paramMethodMap.put("queryEquipmentUp", new DynamicSelect_queryEquipmentUp());
}
public final class DynamicSelect_queryEquipmentUp implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.EquipmentUp>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.EquipmentUp bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}