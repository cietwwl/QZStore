package com.ks.logic.db_template;
public final class UserHeroMapDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.UserHeroMap>{
public UserHeroMapDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.UserHeroMap.class;
mapper = new com.ks.table.UserHeroMapTable.DBRowMapper_UserHeroMap();
}
}