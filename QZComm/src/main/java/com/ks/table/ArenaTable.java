package com.ks.table;
public final class ArenaTable extends com.ks.access.DBBeanTable<com.ks.db.model.Arena>{
public static ArenaTable instance;
public static final String TABLE_NAME="t_arena";
public static final String USERID="user_id";
public static final String WINCOUNT="win_count";
public static final String CREATETIME="create_time";
public static final String UPDATETIME="update_time";
public static final String VALOUR="valour";
public static final String STREAKWIN="streak_win";
public static final String MAXWINSTREAK="max_win_streak";
public static final String SHOPPING="shopping";
public static final String ISFIRST="is_first";
public static final String CDTIME="cd_time";

public static final String J_USERID="userId";
public static final String J_WINCOUNT="winCount";
public static final String J_CREATETIME="createTime";
public static final String J_UPDATETIME="updateTime";
public static final String J_VALOUR="valour";
public static final String J_STREAKWIN="streakWin";
public static final String J_MAXWINSTREAK="maxWinStreak";
public static final String J_SHOPPING="shopping";
public static final String J_ISFIRST="isFirst";
public static final String J_CDTIME="cdTime";

public ArenaTable(){
mapper=new DBRowMapper_Arena();
}
@Override
public Object getDBFieldValue(com.ks.db.model.Arena bean, String fname){
if(USERID.equals(fname)){
return bean.getUserId();
}
if(WINCOUNT.equals(fname)){
return bean.getWinCount();
}
if(CREATETIME.equals(fname)){
return bean.getCreateTime();
}
if(UPDATETIME.equals(fname)){
return bean.getUpdateTime();
}
if(VALOUR.equals(fname)){
return bean.getValour();
}
if(STREAKWIN.equals(fname)){
return bean.getStreakWin();
}
if(MAXWINSTREAK.equals(fname)){
return bean.getMaxWinStreak();
}
if(SHOPPING.equals(fname)){
return bean.getShopping();
}
if(ISFIRST.equals(fname)){
return bean.getIsFirst();
}
if(CDTIME.equals(fname)){
return bean.getCdTime();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.model.Arena.class;
}
public final static class DBRowMapper_Arena implements com.ks.access.mapper.RowMapper<com.ks.db.model.Arena>{
@Override
public com.ks.db.model.Arena rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.Arena bean = new com.ks.db.model.Arena();
bean.setUserId(rs.getInt("user_id"));
bean.setWinCount(rs.getInt("win_count"));
bean.setCreateTime(rs.getTimestamp("create_time"));
bean.setUpdateTime(rs.getTimestamp("update_time"));
bean.setValour(rs.getInt("valour"));
bean.setStreakWin(rs.getInt("streak_win"));
bean.setMaxWinStreak(rs.getInt("max_win_streak"));
bean.setShopping(rs.getString("shopping"));
bean.setIsFirst(rs.getInt("is_first"));
bean.setCdTime(rs.getTimestamp("cd_time"));
return bean;
}
}
}
