package com.ks.table;
import com.ks.util.StringUtil;
public final class HeroTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.Hero>{
public static HeroTable instance;
public static final String TABLE_NAME="t_hero";
public static final String HEROID="hero_id";
public static final String CARDID="card_id";
public static final String NAME="name";
public static final String QUALITY="quality";
public static final String RAREDEGREE="rare_degree";
public static final String COST="cost";
public static final String ELE="ele";
public static final String ABILITY="ability";
public static final String MAXLEVEL="max_level";
public static final String HP="hp";
public static final String HPUP="hp_up";
public static final String ATK="atk";
public static final String ATKUP="atk_up";
public static final String ATKCOUNT="atk_count";
public static final String ATKMODE="atk_mode";
public static final String MOVEMODE="move_mode";
public static final String CRITRATE="crit_rate";
public static final String CRITHIT="crit_hit";
public static final String DODGERATE="dodge_rate";
public static final String SKILLID="skill_id";
public static final String CAPSKILLID="cap_skill_id";
public static final String PASSIVESKILLSTR="passive_skills";
public static final String SELLPRICE="sell_price";
public static final String GIVEEXP="give_exp";
public static final String BLOCKRATE="block_rate";
public static final String BLOCKHIT="block_hit";
public static final String BREAKGROUP="breakGroup";
public static final String BREAKATTRGROUP="breakAttrGroup";

public static final String J_HEROID="heroId";
public static final String J_CARDID="cardId";
public static final String J_NAME="name";
public static final String J_QUALITY="quality";
public static final String J_RAREDEGREE="rareDegree";
public static final String J_COST="cost";
public static final String J_ELE="ele";
public static final String J_ABILITY="ability";
public static final String J_MAXLEVEL="maxLevel";
public static final String J_HP="hp";
public static final String J_HPUP="hpUp";
public static final String J_ATK="atk";
public static final String J_ATKUP="atkUp";
public static final String J_ATKCOUNT="atkCount";
public static final String J_ATKMODE="atkMode";
public static final String J_MOVEMODE="moveMode";
public static final String J_CRITRATE="critRate";
public static final String J_CRITHIT="critHit";
public static final String J_DODGERATE="dodgeRate";
public static final String J_SKILLID="skillId";
public static final String J_CAPSKILLID="capSkillId";
public static final String J_PASSIVESKILLSTR="passiveSkillStr";
public static final String J_SELLPRICE="sellPrice";
public static final String J_GIVEEXP="giveExp";
public static final String J_BLOCKRATE="blockRate";
public static final String J_BLOCKHIT="blockHit";
public static final String J_BREAKGROUP="breakGroup";
public static final String J_BREAKATTRGROUP="breakAttrGroup";

public HeroTable(){
mapper=new DBRowMapper_Hero();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.Hero bean, String fname){
if(HEROID.equals(fname)){
return bean.getHeroId();
}
if(CARDID.equals(fname)){
return bean.getCardId();
}
if(NAME.equals(fname)){
return bean.getName();
}
if(QUALITY.equals(fname)){
return bean.getQuality();
}
if(RAREDEGREE.equals(fname)){
return bean.getRareDegree();
}
if(COST.equals(fname)){
return bean.getCost();
}
if(ELE.equals(fname)){
return bean.getEle();
}
if(ABILITY.equals(fname)){
return bean.getAbility();
}
if(MAXLEVEL.equals(fname)){
return bean.getMaxLevel();
}
if(HP.equals(fname)){
return bean.getHp();
}
if(HPUP.equals(fname)){
return bean.getHpUp();
}
if(ATK.equals(fname)){
return bean.getAtk();
}
if(ATKUP.equals(fname)){
return bean.getAtkUp();
}
if(ATKCOUNT.equals(fname)){
return bean.getAtkCount();
}
if(ATKMODE.equals(fname)){
return bean.getAtkMode();
}
if(MOVEMODE.equals(fname)){
return bean.getMoveMode();
}
if(CRITRATE.equals(fname)){
return bean.getCritRate();
}
if(CRITHIT.equals(fname)){
return bean.getCritHit();
}
if(DODGERATE.equals(fname)){
return bean.getDodgeRate();
}
if(SKILLID.equals(fname)){
return bean.getSkillId();
}
if(CAPSKILLID.equals(fname)){
return bean.getCapSkillId();
}
if(PASSIVESKILLSTR.equals(fname)){
return bean.getPassiveSkillStr();
}
if(SELLPRICE.equals(fname)){
return bean.getSellPrice();
}
if(GIVEEXP.equals(fname)){
return bean.getGiveExp();
}
if(BLOCKRATE.equals(fname)){
return bean.getBlockRate();
}
if(BLOCKHIT.equals(fname)){
return bean.getBlockHit();
}
if(BREAKGROUP.equals(fname)){
return bean.getBreakGroup();
}
if(BREAKATTRGROUP.equals(fname)){
return bean.getBreakAttrGroup();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.Hero.class;
}
public final static class DBRowMapper_Hero implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.Hero>{
@Override
public com.ks.db.cfg.Hero rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.Hero bean = new com.ks.db.cfg.Hero();
bean.setHeroId(rs.getInt("hero_id"));
bean.setCardId(rs.getInt("card_id"));
bean.setName(rs.getString("name"));
bean.setQuality(rs.getInt("quality"));
bean.setRareDegree(rs.getInt("rare_degree"));
bean.setCost(rs.getInt("cost"));
bean.setEle(rs.getInt("ele"));
bean.setAbility(rs.getInt("ability"));
bean.setMaxLevel(rs.getInt("max_level"));
bean.setHp(rs.getDouble("hp"));
bean.setHpUp(rs.getDouble("hp_up"));
bean.setAtk(rs.getDouble("atk"));
bean.setAtkUp(rs.getDouble("atk_up"));
bean.setAtkCount(rs.getInt("atk_count"));
bean.setAtkMode(rs.getString("atk_mode"));
bean.setMoveMode(rs.getString("move_mode"));
bean.setCritRate(rs.getInt("crit_rate"));
bean.setCritHit(rs.getInt("crit_hit"));
bean.setDodgeRate(rs.getInt("dodge_rate"));
bean.setSkillId(rs.getInt("skill_id"));
bean.setCapSkillId(rs.getInt("cap_skill_id"));
bean.setPassiveSkillStr(rs.getString("passive_skills"));
bean.setSellPrice(rs.getInt("sell_price"));
bean.setGiveExp(rs.getInt("give_exp"));
bean.setBlockRate(rs.getInt("block_rate"));
bean.setBlockHit(rs.getInt("block_hit"));
bean.setBreakGroup(rs.getInt("breakGroup"));
bean.setBreakAttrGroup(rs.getInt("breakAttrGroup"));
return bean;
}
}
}
