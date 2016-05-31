package com.ks.table;
import com.ks.util.StringUtil;
public final class ZoneBattleTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.ZoneBattle>{
public static ZoneBattleTable instance;
public static final String TABLE_NAME="t_zone_battle";
public static final String BATTLEID="battle_id";
public static final String ZONEID="zone_id";
public static final String BATTLETYPE="battle_type";
public static final String SP="sp";
public static final String EXP="exp";
public static final String FIRSTEXP="first_exp";
public static final String GOLD="gold";
public static final String FIRSTGOLD="first_exp";
public static final String PEVBATTLE="pev_battle";
public static final String NEXTBATTLE="next_battle";
public static final String DISRATE="dis_rate";
public static final String DISMONSTER="dis_monster";
public static final String ITEMRATE="item_rate";
public static final String SLATERATE="slate_rate";
public static final String HINDER="hinder";
public static final String GROUP="group";
public static final String SUBGROUP="subGroup";
public static final String CONDITIONS="conditions";
public static final String NAME="name";

public static final String J_BATTLEID="battleId";
public static final String J_ZONEID="zoneId";
public static final String J_BATTLETYPE="battleType";
public static final String J_SP="sp";
public static final String J_EXP="exp";
public static final String J_FIRSTEXP="firstExp";
public static final String J_GOLD="gold";
public static final String J_FIRSTGOLD="firstGold";
public static final String J_PEVBATTLE="pevBattle";
public static final String J_NEXTBATTLE="nextBattle";
public static final String J_DISRATE="disRate";
public static final String J_DISMONSTER="disMonster";
public static final String J_ITEMRATE="itemRate";
public static final String J_SLATERATE="slateRate";
public static final String J_HINDER="hinder";
public static final String J_GROUP="group";
public static final String J_SUBGROUP="subGroup";
public static final String J_CONDITIONS="conditions";
public static final String J_NAME="name";

public ZoneBattleTable(){
mapper=new DBRowMapper_ZoneBattle();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.ZoneBattle bean, String fname){
if(BATTLEID.equals(fname)){
return bean.getBattleId();
}
if(ZONEID.equals(fname)){
return bean.getZoneId();
}
if(BATTLETYPE.equals(fname)){
return bean.getBattleType();
}
if(SP.equals(fname)){
return bean.getSp();
}
if(EXP.equals(fname)){
return bean.getExp();
}
if(FIRSTEXP.equals(fname)){
return bean.getFirstExp();
}
if(GOLD.equals(fname)){
return bean.getGold();
}
if(FIRSTGOLD.equals(fname)){
return bean.getFirstGold();
}
if(PEVBATTLE.equals(fname)){
return bean.getPevBattle();
}
if(NEXTBATTLE.equals(fname)){
return bean.getNextBattle();
}
if(DISRATE.equals(fname)){
return bean.getDisRate();
}
if(DISMONSTER.equals(fname)){
return bean.getDisMonster();
}
if(ITEMRATE.equals(fname)){
return bean.getItemRate();
}
if(SLATERATE.equals(fname)){
return bean.getSlateRate();
}
if(HINDER.equals(fname)){
return bean.getHinder();
}
if(GROUP.equals(fname)){
return bean.getGroup();
}
if(SUBGROUP.equals(fname)){
return bean.getSubGroup();
}
if(CONDITIONS.equals(fname)){
return bean.getConditions();
}
if(NAME.equals(fname)){
return bean.getName();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.ZoneBattle.class;
}
public final static class DBRowMapper_ZoneBattle implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.ZoneBattle>{
@Override
public com.ks.db.cfg.ZoneBattle rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.ZoneBattle bean = new com.ks.db.cfg.ZoneBattle();
bean.setBattleId(rs.getInt("battle_id"));
bean.setZoneId(rs.getInt("zone_id"));
bean.setBattleType(rs.getInt("battle_type"));
bean.setSp(rs.getInt("sp"));
bean.setExp(rs.getInt("exp"));
bean.setFirstExp(rs.getInt("first_exp"));
bean.setGold(rs.getInt("gold"));
bean.setFirstGold(rs.getInt("first_exp"));
bean.setPevBattle(rs.getInt("pev_battle"));
bean.setNextBattle(rs.getInt("next_battle"));
bean.setDisRate(rs.getInt("dis_rate"));
bean.setDisMonster(StringUtil.stringToList(rs.getString("dis_monster")));
bean.setItemRate(rs.getInt("item_rate"));
bean.setSlateRate(rs.getInt("slate_rate"));
bean.setHinder(StringUtil.getHinder(rs.getString("hinder")));
bean.setGroup(rs.getInt("group"));
bean.setSubGroup(rs.getInt("subGroup"));
bean.setConditions(rs.getString("conditions"));
bean.setName(rs.getString("name"));
return bean;
}
}
}
