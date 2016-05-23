package com.ks.logic.db_template;
public final class MailDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.Mail>{
public MailDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.Mail.class;
mapper = new com.ks.table.MailTable.DBRowMapper_Mail();
sqlMap.put("queryMails","select * from $tablename where `user_id`=? order by mail_id desc");
sqlMap.put("updateMail","update $tablename set `mail_id`=?,`user_id`=?,`type`=?,`title`=?,`context`=?,`state`=?,`goods`=?,`create_time`=?,`update_time`=? where `user_id`=? and `mail_id`=?");
sqlMap.put("deleteMail","delete from $tablename where `user_id`=? and `mail_id`=?");
sqlMap.put("addMail","insert $tablename (`mail_id`,`user_id`,`type`,`title`,`context`,`state`,`goods`,`create_time`,`update_time`) values (?,?,?,?,?,?,?,?,?)");
paramMethodMap.put("queryMails", new DynamicSelect_queryMails());
paramMethodMap.put("updateMail", new DynamicUpdata_updateMail());
paramMethodMap.put("deleteMail", new DynamicDelete_deleteMail());
paramMethodMap.put("addMail", new DynamicInsert_addMail());
}
public final class DynamicSelect_queryMails implements com.ks.access.DBBeanParamMethod<com.ks.db.model.Mail>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.Mail bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
public final class DynamicUpdata_updateMail implements com.ks.access.DBBeanParamMethod<com.ks.db.model.Mail>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.Mail bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getMailId());
list.add(bean.getUserId());
list.add(bean.getType());
list.add(bean.getTitle());
list.add(bean.getContext());
list.add(bean.getState());
list.add(bean.getGoodses());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getUserId());
list.add(bean.getMailId());
return list;
}
}
public final class DynamicDelete_deleteMail implements com.ks.access.DBBeanParamMethod<com.ks.db.model.Mail>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.Mail bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getMailId());
return list;
}
}
public final class DynamicInsert_addMail implements com.ks.access.DBBeanParamMethod<com.ks.db.model.Mail>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.Mail bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getMailId());
list.add(bean.getUserId());
list.add(bean.getType());
list.add(bean.getTitle());
list.add(bean.getContext());
list.add(bean.getState());
list.add(bean.getGoodses());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
return list;
}
}
}