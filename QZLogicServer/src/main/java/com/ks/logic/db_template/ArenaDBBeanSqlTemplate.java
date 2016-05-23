package com.ks.logic.db_template;
public final class ArenaDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.Arena>{
public ArenaDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.Arena.class;
mapper = new com.ks.table.ArenaTable.DBRowMapper_Arena();
sqlMap.put("updateArena","update t_arena set $fieldname where `user_id`=?");
sqlMap.put("queryMyArena","select * from t_arena where `user_id`=?");
sqlMap.put("addArena","insert t_arena (`user_id`,`win_count`,`create_time`,`update_time`,`valour`,`streak_win`,`max_win_streak`,`shopping`,`is_first`,`cd_time`) values (?,?,?,?,?,?,?,?,?,?)");
sqlMap.put("refArenaShopping","update t_arena set `shopping`=? where `user_id`=?");
sqlMap.put("queryLockArena","select * from t_arena where `user_id`=? for update");
sqlMap.put("queryRankArena","select * from t_arena");
paramMethodMap.put("updateArena", new DynamicUpdata_updateArena());
paramMethodMap.put("queryMyArena", new DynamicSelect_queryMyArena());
paramMethodMap.put("addArena", new DynamicInsert_addArena());
paramMethodMap.put("refArenaShopping", new DynamicUpdata_refArenaShopping());
paramMethodMap.put("queryLockArena", new DynamicSelect_queryLockArena());
paramMethodMap.put("queryRankArena", new DynamicSelect_queryRankArena());
}
public final class DynamicUpdata_updateArena implements com.ks.access.DBBeanParamMethod<com.ks.db.model.Arena>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.Arena bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
public final class DynamicSelect_queryMyArena implements com.ks.access.DBBeanParamMethod<com.ks.db.model.Arena>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.Arena bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
public final class DynamicInsert_addArena implements com.ks.access.DBBeanParamMethod<com.ks.db.model.Arena>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.Arena bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getWinCount());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getValour());
list.add(bean.getStreakWin());
list.add(bean.getMaxWinStreak());
list.add(bean.getShopping());
list.add(bean.getIsFirst());
list.add(bean.getCdTime());
return list;
}
}
public final class DynamicUpdata_refArenaShopping implements com.ks.access.DBBeanParamMethod<com.ks.db.model.Arena>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.Arena bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getShopping());
list.add(bean.getUserId());
return list;
}
}
public final class DynamicSelect_queryLockArena implements com.ks.access.DBBeanParamMethod<com.ks.db.model.Arena>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.Arena bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
public final class DynamicSelect_queryRankArena implements com.ks.access.DBBeanParamMethod<com.ks.db.model.Arena>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.Arena bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}