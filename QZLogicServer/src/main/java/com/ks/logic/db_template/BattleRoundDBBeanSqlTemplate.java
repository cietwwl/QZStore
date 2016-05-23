package com.ks.logic.db_template;
import com.ks.util.StringUtil;
public final class BattleRoundDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.BattleRound>{
public BattleRoundDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.BattleRound.class;
mapper = new com.ks.table.BattleRoundTable.DBRowMapper_BattleRound();
sqlMap.put("queryBattleRound","select * from t_zone_battle_round");
paramMethodMap.put("queryBattleRound", new DynamicSelect_queryBattleRound());
}
public final class DynamicSelect_queryBattleRound implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.BattleRound>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.BattleRound bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}