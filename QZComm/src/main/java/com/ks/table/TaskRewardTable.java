package com.ks.table;
public final class TaskRewardTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.TaskReward>{
public static TaskRewardTable instance;
public static final String TABLE_NAME="t_task_reward";
public static final String ID="id";
public static final String TASKID="taskId";
public static final String GOODSID="goods_id";
public static final String TYPE="type";
public static final String NUM="num";
public static final String LEVEL="level";

public static final String J_ID="id";
public static final String J_TASKID="taskId";
public static final String J_GOODSID="goodsId";
public static final String J_TYPE="type";
public static final String J_NUM="num";
public static final String J_LEVEL="level";

public TaskRewardTable(){
mapper=new DBRowMapper_TaskReward();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.TaskReward bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(TASKID.equals(fname)){
return bean.getTaskId();
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
return com.ks.db.cfg.TaskReward.class;
}
public final static class DBRowMapper_TaskReward implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.TaskReward>{
@Override
public com.ks.db.cfg.TaskReward rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.TaskReward bean = new com.ks.db.cfg.TaskReward();
bean.setId(rs.getInt("id"));
bean.setTaskId(rs.getInt("taskId"));
bean.setGoodsId(rs.getInt("goods_id"));
bean.setType(rs.getInt("type"));
bean.setNum(rs.getInt("num"));
bean.setLevel(rs.getInt("level"));
return bean;
}
}
}
