package com.ks.table;
import com.ks.util.StringUtil;
public final class HeroRelationTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.HeroRelation>{
public static HeroRelationTable instance;
public static final String TABLE_NAME="t_hero_relation";
public static final String ASSHERO="ass_hero";
public static final String SKILLID="skill_id";

public static final String J_ASSHERO="assHero";
public static final String J_SKILLID="skillId";

public HeroRelationTable(){
mapper=new DBRowMapper_HeroRelation();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.HeroRelation bean, String fname){
if(ASSHERO.equals(fname)){
return bean.getAssHero();
}
if(SKILLID.equals(fname)){
return bean.getSkillId();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.HeroRelation.class;
}
public final static class DBRowMapper_HeroRelation implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.HeroRelation>{
@Override
public com.ks.db.cfg.HeroRelation rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.HeroRelation bean = new com.ks.db.cfg.HeroRelation();
bean.setAssHero(StringUtil.stringToList(rs.getString("ass_hero")));
bean.setSkillId(rs.getInt("skill_id"));
return bean;
}
}
}
