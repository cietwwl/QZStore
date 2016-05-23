package com.ks.logic.db_template;
import com.ks.util.StringUtil;
public final class HeroDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.Hero>{
public HeroDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.Hero.class;
mapper = new com.ks.table.HeroTable.DBRowMapper_Hero();
sqlMap.put("queryHeros","select * from t_hero");
paramMethodMap.put("queryHeros", new DynamicSelect_queryHeros());
}
public final class DynamicSelect_queryHeros implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.Hero>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.Hero bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}