package com.ks.table;
public final class GuildRankAwardTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.GuildRankAward>{
public static GuildRankAwardTable instance;
public static final String TABLE_NAME="t_guild_rank_award";
public static final String RANK="rank";
public static final String GOODSID="goods_id";
public static final String TYPE="type";
public static final String NUM="num";
public static final String LEVEL="level";

public static final String J_RANK="rank";
public static final String J_GOODSID="goodsId";
public static final String J_TYPE="type";
public static final String J_NUM="num";
public static final String J_LEVEL="level";

public GuildRankAwardTable(){
mapper=new DBRowMapper_GuildRankAward();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.GuildRankAward bean, String fname){
if(RANK.equals(fname)){
return bean.getRank();
}
if(GOODSID.equals(fname)){
return bean.getGoodsId();
}
if(TYPE.equals(fname)){
return bean.getType();
}
if(NUM.equals(fname)){
return bean.getNum();
}
if(LEVEL.equals(fname)){
return bean.getLevel();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.GuildRankAward.class;
}
public final static class DBRowMapper_GuildRankAward implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.GuildRankAward>{
@Override
public com.ks.db.cfg.GuildRankAward rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.GuildRankAward bean = new com.ks.db.cfg.GuildRankAward();
bean.setRank(rs.getInt("rank"));
bean.setGoodsId(rs.getInt("goods_id"));
bean.setType(rs.getInt("type"));
bean.setNum(rs.getInt("num"));
bean.setLevel(rs.getInt("level"));
return bean;
}
}
}
