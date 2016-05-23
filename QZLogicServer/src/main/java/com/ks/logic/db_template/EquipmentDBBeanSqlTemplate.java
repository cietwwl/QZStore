package com.ks.logic.db_template;
public final class EquipmentDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.Equipment>{
public EquipmentDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.Equipment.class;
mapper = new com.ks.table.EquipmentTable.DBRowMapper_Equipment();
sqlMap.put("queryEquipment","select * from t_equipment");
paramMethodMap.put("queryEquipment", new DynamicSelect_queryEquipment());
}
public final class DynamicSelect_queryEquipment implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.Equipment>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.Equipment bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}