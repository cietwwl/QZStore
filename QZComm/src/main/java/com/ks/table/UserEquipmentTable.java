package com.ks.table;
public final class UserEquipmentTable extends com.ks.access.DBBeanTable<com.ks.db.model.UserEquipment>{
public static UserEquipmentTable instance;
public static final String TABLE_NAME_PREFIX="t_user_equipment_";
public static final String USEREQUIPMENTID="user_equipment_id";
public static final String USERID="user_id";
public static final String EQUIPMENTID="equipment_id";
public static final String LEVEL="level";
public static final String USERHEROID="user_hero_id";
public static final String UPDATETIME="update_time";
public static final String SKILLS="equipment_skill";
public static final String ADDATK="add_atk";

public static final String J_USEREQUIPMENTID="userEquipmentId";
public static final String J_USERID="userId";
public static final String J_EQUIPMENTID="equipmentId";
public static final String J_LEVEL="level";
public static final String J_USERHEROID="userHeroId";
public static final String J_UPDATETIME="updateTime";
public static final String J_SKILLS="skills";
public static final String J_ADDATK="addAtk";

public static String getTableName(int index){return TABLE_NAME_PREFIX + (index % 10);}
public UserEquipmentTable(){
mapper=new DBRowMapper_UserEquipment();
}
@Override
public Object getDBFieldValue(com.ks.db.model.UserEquipment bean, String fname){
if(USEREQUIPMENTID.equals(fname)){
return bean.getUserEquipmentId();
}
if(USERID.equals(fname)){
return bean.getUserId();
}
if(EQUIPMENTID.equals(fname)){
return bean.getEquipmentId();
}
if(LEVEL.equals(fname)){
return bean.getLevel();
}
if(USERHEROID.equals(fname)){
return bean.getUserHeroId();
}
if(UPDATETIME.equals(fname)){
return bean.getUpdateTime();
}
if(SKILLS.equals(fname)){
return bean.getSkills();
}
if(ADDATK.equals(fname)){
return bean.getAddAtk();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.model.UserEquipment.class;
}
public final static class DBRowMapper_UserEquipment implements com.ks.access.mapper.RowMapper<com.ks.db.model.UserEquipment>{
@Override
public com.ks.db.model.UserEquipment rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.UserEquipment bean = new com.ks.db.model.UserEquipment();
bean.setUserEquipmentId(rs.getInt("user_equipment_id"));
bean.setUserId(rs.getInt("user_id"));
bean.setEquipmentId(rs.getInt("equipment_id"));
bean.setLevel(rs.getInt("level"));
bean.setUserHeroId(rs.getInt("user_hero_id"));
bean.setUpdateTime(rs.getTimestamp("update_time"));
bean.setSkills(rs.getString("equipment_skill"));
bean.setAddAtk(rs.getDouble("add_atk"));
return bean;
}
}
}
