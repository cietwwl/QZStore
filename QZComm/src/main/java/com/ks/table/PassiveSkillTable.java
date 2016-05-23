package com.ks.table;
import com.ks.util.StringUtil;
public final class PassiveSkillTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.PassiveSkill>{
public static PassiveSkillTable instance;
public static final String TABLE_NAME="t_passive_skill";
public static final String PASSIVESKILLID="passive_skill_id";
public static final String NAME="name";
public static final String CD="cd";
public static final String ACTIVATION="activation";
public static final String TAKEEFFECT="take_effect";
public static final String ARG0="arg0";
public static final String ARG1="arg1";
public static final String RESSTATE="res_state";

public static final String J_PASSIVESKILLID="passiveSkillId";
public static final String J_NAME="name";
public static final String J_CD="cd";
public static final String J_ACTIVATION="activation";
public static final String J_TAKEEFFECT="takeEffect";
public static final String J_ARG0="arg0";
public static final String J_ARG1="arg1";
public static final String J_RESSTATE="resState";

public PassiveSkillTable(){
mapper=new DBRowMapper_PassiveSkill();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.PassiveSkill bean, String fname){
if(PASSIVESKILLID.equals(fname)){
return bean.getPassiveSkillId();
}
if(NAME.equals(fname)){
return bean.getName();
}
if(CD.equals(fname)){
return bean.getCd();
}
if(ACTIVATION.equals(fname)){
return bean.getActivation();
}
if(TAKEEFFECT.equals(fname)){
return bean.getTakeEffect();
}
if(ARG0.equals(fname)){
return bean.getArg0();
}
if(ARG1.equals(fname)){
return bean.getArg1();
}
if(RESSTATE.equals(fname)){
return bean.getResState();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.PassiveSkill.class;
}
public final static class DBRowMapper_PassiveSkill implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.PassiveSkill>{
@Override
public com.ks.db.cfg.PassiveSkill rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.PassiveSkill bean = new com.ks.db.cfg.PassiveSkill();
bean.setPassiveSkillId(rs.getInt("passive_skill_id"));
bean.setName(rs.getString("name"));
bean.setCd(rs.getInt("cd"));
bean.setActivation(rs.getInt("activation"));
bean.setTakeEffect(StringUtil.stringToList1(rs.getString("take_effect")));
bean.setArg0(StringUtil.stringToList1(rs.getString("arg0")));
bean.setArg1(StringUtil.stringToList1(rs.getString("arg1")));
bean.setResState(rs.getInt("res_state"));
return bean;
}
}
}
