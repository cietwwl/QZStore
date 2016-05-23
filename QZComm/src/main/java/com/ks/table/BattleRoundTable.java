package com.ks.table;
import com.ks.util.StringUtil;
public final class BattleRoundTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.BattleRound>{
public static BattleRoundTable instance;
public static final String TABLE_NAME="t_zone_battle_round";
public static final String BATTLEID="battle_id";
public static final String ROUNDID="round_id";
public static final String MONSTERS="monsters";
public static final String BOSSROUND="boss_round";

public static final String J_BATTLEID="battleId";
public static final String J_ROUNDID="roundId";
public static final String J_MONSTERS="monsters";
public static final String J_BOSSROUND="bossRound";

public BattleRoundTable(){
mapper=new DBRowMapper_BattleRound();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.BattleRound bean, String fname){
if(BATTLEID.equals(fname)){
return bean.getBattleId();
}
if(ROUNDID.equals(fname)){
return bean.getRoundId();
}
if(MONSTERS.equals(fname)){
return bean.getMonsters();
}
if(BOSSROUND.equals(fname)){
return bean.isBossRound();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.BattleRound.class;
}
public final static class DBRowMapper_BattleRound implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.BattleRound>{
@Override
public com.ks.db.cfg.BattleRound rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.BattleRound bean = new com.ks.db.cfg.BattleRound();
bean.setBattleId(rs.getInt("battle_id"));
bean.setRoundId(rs.getInt("round_id"));
bean.setMonsters(StringUtil.stringToList1(rs.getString("monsters")));
bean.setBossRound(rs.getBoolean("boss_round"));
return bean;
}
}
}
