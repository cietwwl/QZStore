package com.ks.logic.db_template;
public final class HeroBreakSettingDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.HeroBreakSetting>{
public HeroBreakSettingDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.HeroBreakSetting.class;
mapper = new com.ks.table.HeroBreakSettingTable.DBRowMapper_HeroBreakSetting();
sqlMap.put("queryHeroBreakSettings","select * from t_hero_break_setting");
paramMethodMap.put("queryHeroBreakSettings", new DynamicSelect_queryHeroBreakSettings());
}
public final class DynamicSelect_queryHeroBreakSettings implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.HeroBreakSetting>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.HeroBreakSetting bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}