package com.ks.logic.db_template;
public final class HeroBreakAttrSettingDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.HeroBreakAttrSetting>{
public HeroBreakAttrSettingDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.HeroBreakAttrSetting.class;
mapper = new com.ks.table.HeroBreakAttrSettingTable.DBRowMapper_HeroBreakAttrSetting();
sqlMap.put("queryHeroBreakAttrSettings","select * from t_hero_break_attr_setting");
paramMethodMap.put("queryHeroBreakAttrSettings", new DynamicSelect_queryHeroBreakAttrSettings());
}
public final class DynamicSelect_queryHeroBreakAttrSettings implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.HeroBreakAttrSetting>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.HeroBreakAttrSetting bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}