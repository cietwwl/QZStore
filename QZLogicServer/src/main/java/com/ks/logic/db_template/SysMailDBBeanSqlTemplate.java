package com.ks.logic.db_template;
public final class SysMailDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.SysMail>{
public SysMailDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.SysMail.class;
mapper = new com.ks.table.SysMailTable.DBRowMapper_SysMail();
sqlMap.put("addSysMail","insert t_sys_mail (`id`,`partner`,`sendType`,`endId`,`uids`,`title`,`content`,`items`,`startTime`,`endTime`,`time`) values (?,?,?,?,?,?,?,?,?,?,?)");
sqlMap.put("deleteSysMail","delete from t_sys_mail where `id`=?");
sqlMap.put("querySysMails","select * from t_sys_mail");
paramMethodMap.put("addSysMail", new DynamicInsert_addSysMail());
paramMethodMap.put("deleteSysMail", new DynamicDelete_deleteSysMail());
paramMethodMap.put("querySysMails", new DynamicSelect_querySysMails());
}
public final class DynamicInsert_addSysMail implements com.ks.access.DBBeanParamMethod<com.ks.db.model.SysMail>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.SysMail bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
list.add(bean.getPartner());
list.add(bean.getSendType());
list.add(bean.getEndId());
list.add(bean.getUids());
list.add(bean.getTitle());
list.add(bean.getContent());
list.add(bean.getItems());
list.add(bean.getStartTime());
list.add(bean.getEndTime());
list.add(bean.getTime());
return list;
}
}
public final class DynamicDelete_deleteSysMail implements com.ks.access.DBBeanParamMethod<com.ks.db.model.SysMail>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.SysMail bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
return list;
}
}
public final class DynamicSelect_querySysMails implements com.ks.access.DBBeanParamMethod<com.ks.db.model.SysMail>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.SysMail bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}