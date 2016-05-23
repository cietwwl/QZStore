package com.ks.logic.db_template;
public final class GuildRankAwardDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.GuildRankAward>{
public GuildRankAwardDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.GuildRankAward.class;
mapper = new com.ks.table.GuildRankAwardTable.DBRowMapper_GuildRankAward();
sqlMap.put("queryAwards","select * from t_guild_rank_award");
paramMethodMap.put("queryAwards", new DynamicSelect_queryAwards());
}
public final class DynamicSelect_queryAwards implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.GuildRankAward>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.GuildRankAward bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}