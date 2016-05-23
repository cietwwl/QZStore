package com.ks.logic.db_template;
public final class UserEquipmentDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.UserEquipment>{
public UserEquipmentDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.UserEquipment.class;
mapper = new com.ks.table.UserEquipmentTable.DBRowMapper_UserEquipment();
sqlMap.put("updateUserEquipments","update $tablename set `user_equipment_id`=?,`user_id`=?,`equipment_id`=?,`level`=?,`user_hero_id`=?,`update_time`=?,`equipment_skill`=?,`add_atk`=? where `user_id`=? and `user_equipment_id`=?");
sqlMap.put("updateUserEquipment","update $tablename set `user_equipment_id`=?,`user_id`=?,`equipment_id`=?,`level`=?,`user_hero_id`=?,`update_time`=?,`equipment_skill`=?,`add_atk`=? where `user_id`=? and `user_equipment_id`=?");
sqlMap.put("addUserEquipment","insert $tablename (`user_equipment_id`,`user_id`,`equipment_id`,`level`,`user_hero_id`,`update_time`,`equipment_skill`,`add_atk`) values (?,?,?,?,?,?,?,?)");
sqlMap.put("queryAllUserEquipment","select * from $tablename where `user_id`=?");
sqlMap.put("deleteUserEquipment","delete from $tablename where `user_equipment_id`=? and `user_id`=?");
paramMethodMap.put("updateUserEquipments", new DynamicUpdata_updateUserEquipments());
paramMethodMap.put("updateUserEquipment", new DynamicUpdata_updateUserEquipment());
paramMethodMap.put("addUserEquipment", new DynamicInsert_addUserEquipment());
paramMethodMap.put("queryAllUserEquipment", new DynamicSelect_queryAllUserEquipment());
paramMethodMap.put("deleteUserEquipment", new DynamicDelete_deleteUserEquipment());
}
public final class DynamicUpdata_updateUserEquipments implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserEquipment>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserEquipment bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserEquipmentId());
list.add(bean.getUserId());
list.add(bean.getEquipmentId());
list.add(bean.getLevel());
list.add(bean.getUserHeroId());
list.add(bean.getUpdateTime());
list.add(bean.getSkills());
list.add(bean.getAddAtk());
list.add(bean.getUserId());
list.add(bean.getUserEquipmentId());
return list;
}
}
public final class DynamicUpdata_updateUserEquipment implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserEquipment>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserEquipment bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserEquipmentId());
list.add(bean.getUserId());
list.add(bean.getEquipmentId());
list.add(bean.getLevel());
list.add(bean.getUserHeroId());
list.add(bean.getUpdateTime());
list.add(bean.getSkills());
list.add(bean.getAddAtk());
list.add(bean.getUserId());
list.add(bean.getUserEquipmentId());
return list;
}
}
public final class DynamicInsert_addUserEquipment implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserEquipment>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserEquipment bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserEquipmentId());
list.add(bean.getUserId());
list.add(bean.getEquipmentId());
list.add(bean.getLevel());
list.add(bean.getUserHeroId());
list.add(bean.getUpdateTime());
list.add(bean.getSkills());
list.add(bean.getAddAtk());
return list;
}
}
public final class DynamicSelect_queryAllUserEquipment implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserEquipment>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserEquipment bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
public final class DynamicDelete_deleteUserEquipment implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserEquipment>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserEquipment bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserEquipmentId());
list.add(bean.getUserId());
return list;
}
}
}