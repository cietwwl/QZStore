package com.ks.logic.db_template;
public final class EquipmentUpRateDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.EquipmentUpRate>{
public EquipmentUpRateDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.EquipmentUpRate.class;
mapper = new com.ks.table.EquipmentUpRateTable.DBRowMapper_EquipmentUpRate();
sqlMap.put("queryEquipmentUpRate","select * from t_equipment_up_rate");
paramMethodMap.put("queryEquipmentUpRate", new DynamicSelect_queryEquipmentUpRate());
}
public final class DynamicSelect_queryEquipmentUpRate implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.EquipmentUpRate>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.EquipmentUpRate bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}