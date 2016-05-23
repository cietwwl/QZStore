package com.ks.table;
public final class TaskBoxRewardTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.TaskBoxReward>{
public static TaskBoxRewardTable instance;
public static final String TABLE_NAME="t_task_box_reward";
public static final String ID="id";
public static final String ACTIVE="active";
public static final String GOODSID="goods_id";
public static final String TYPE="type";
public static final String NUM="num";
public static final String LEVEL="level";

public static final String J_ID="id";
public static final String J_ACTIVE="active";
public static final String J_GOODSID="goodsId";
public static final String J_TYPE="type";
public static final String J_NUM="num";
public static final String J_LEVEL="level";

public TaskBoxRewardTable(){
mapper=new DBRowMapper_TaskBoxReward();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.TaskBoxReward bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(ACTIVE.equals(fname)){
return bean.getActive();
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
return com.ks.db.cfg.TaskBoxReward.class;
}
public final static class DBRowMapper_TaskBoxReward implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.TaskBoxReward>{
@Override
public com.ks.db.cfg.TaskBoxReward rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.TaskBoxReward bean = new com.ks.db.cfg.TaskBoxReward();
bean.setId(rs.getInt("id"));
bean.setActive(rs.getInt("active"));
bean.setGoodsId(rs.getInt("goods_id"));
bean.setType(rs.getInt("type"));
bean.setNum(rs.getInt("num"));
bean.setLevel(rs.getInt("level"));
return bean;
}
}
}
