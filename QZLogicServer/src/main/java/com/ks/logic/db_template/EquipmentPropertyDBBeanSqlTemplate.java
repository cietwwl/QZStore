package com.ks.logic.db_template;
public final class EquipmentPropertyDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.EquipmentProperty>{
public EquipmentPropertyDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.EquipmentProperty.class;
mapper = new com.ks.table.EquipmentPropertyTable.DBRowMapper_EquipmentProperty();
sqlMap.put("queryEquipmentProperty","select * from t_equipment_property");
paramMethodMap.put("queryEquipmentProperty", new DynamicSelect_queryEquipmentProperty());
}
public final class DynamicSelect_queryEquipmentProperty implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.EquipmentProperty>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.EquipmentProperty bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}