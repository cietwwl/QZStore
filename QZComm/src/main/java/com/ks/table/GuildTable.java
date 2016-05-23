package com.ks.table;
public final class GuildTable extends com.ks.access.DBBeanTable<com.ks.db.model.Guild>{
public static GuildTable instance;
public static final String TABLE_NAME="t_guild";
public static final String GUILDID="guild_id";
public static final String NAME="name";
public static final String CDRUSERID="cdr_user_id";
public static final String MEMBERNUM="member_num";
public static final String EXP="exp";
public static final String SKILLPOINT="skill_point";
public static final String STATE="state";
public static final String CREATETIME="create_time";
public static final String UPDATETIME="update_time";

public static final String J_GUILDID="guildId";
public static final String J_NAME="name";
public static final String J_CDRUSERID="cdrUserId";
public static final String J_MEMBERNUM="memberNum";
public static final String J_EXP="exp";
public static final String J_SKILLPOINT="skillPoint";
public static final String J_STATE="state";
public static final String J_CREATETIME="createTime";
public static final String J_UPDATETIME="updateTime";

public GuildTable(){
mapper=new DBRowMapper_Guild();
}
@Override
public Object getDBFieldValue(com.ks.db.model.Guild bean, String fname){
if(GUILDID.equals(fname)){
return bean.getGuildId();
}
if(NAME.equals(fname)){
return bean.getName();
}
if(CDRUSERID.equals(fname)){
return bean.getCdrUserId();
}
if(MEMBERNUM.equals(fname)){
return bean.getMemberNum();
}
if(EXP.equals(fname)){
return bean.getExp();
}
if(SKILLPOINT.equals(fname)){
return bean.getSkillPoint();
}
if(STATE.equals(fname)){
return bean.getState();
}
if(CREATETIME.equals(fname)){
return bean.getCreateTime();
}
if(UPDATETIME.equals(fname)){
return bean.getUpdateTime();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.model.Guild.class;
}
public final static class DBRowMapper_Guild implements com.ks.access.mapper.RowMapper<com.ks.db.model.Guild>{
@Override
public com.ks.db.model.Guild rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.Guild bean = new com.ks.db.model.Guild();
bean.setGuildId(rs.getInt("guild_id"));
bean.setName(rs.getString("name"));
bean.setCdrUserId(rs.getInt("cdr_user_id"));
bean.setMemberNum(rs.getInt("member_num"));
bean.setExp(rs.getInt("exp"));
bean.setSkillPoint(rs.getInt("skill_point"));
bean.setState(rs.getInt("state"));
bean.setCreateTime(rs.getTimestamp("create_time"));
bean.setUpdateTime(rs.getTimestamp("update_time"));
return bean;
}
}
}
