package com.ks.logic.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetDeleteSqlSet;
import com.ks.access.DBBeanSetInsertSqlSet;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameDAOTemplate;
import com.ks.cache.JedisNoLoadException;
import com.ks.db.model.SysMail;
import com.ks.table.SysMailTable;
import com.ks.util.JSONUtil;

public class SysMailDAO extends GameDAOTemplate{
	
	private static final String SYS_MAIL = "SYS_MAIL";
	private static final String LOAD = "LOAD";
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="querySysMails", dbbean=SysMail.class)})
	public List<SysMail> querySysMails(){
		String sql = DBBeanRowMapperManager.getDynamicSql(SysMail.class, "querySysMails");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(SysMail.class));
	}
	
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addSysMail", dbbean=SysMail.class)})
	public void addSysMail(SysMail mail){
		String sql = DBBeanRowMapperManager.getDynamicSql(SysMail.class, "addSysMail");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(SysMail.class, "addSysMail", mail);
		int id = insertAndReturnId(sql, INT_KEY, params.toArray());
		mail.setId(id);
	}
	
	@DBBeanSetSqlSetList(deletes={@DBBeanSetDeleteSqlSet(name="deleteSysMail", dbbean=SysMail.class, wheres={SysMailTable.ID})})
	public void deleteSysMail(int id){
		String sql = DBBeanRowMapperManager.getDynamicSql(SysMail.class, "deleteSysMail");
		saveOrUpdate(sql, id);
	}
	
	/*******************************************************sys_mail cache********************************************************************/
	
	public static class MailMapMapper{
		public static Map<Integer, SysMail> rowMapper(Map<String, String> map) {
			Map<Integer, SysMail> result = new HashMap<Integer, SysMail>();
			for(Map.Entry<String, String> entry : map.entrySet()){
				if(!entry.getKey().equals(LOAD)){
					SysMail bean = JSONUtil.toObject(entry.getValue(), SysMail.class);
					result.put(bean.getId(), bean);
				}
			}
			return result;
		}
	}
	
	public static class MailObjMapper{
		public static Map<String, String> objMapper(Map<Integer, SysMail> map) {
			Map<String, String> result = new HashMap<String, String>();
			for(Map.Entry<Integer, SysMail> entry : map.entrySet()){
				result.put(entry.getKey().toString(), JSONUtil.toJson(entry.getValue()));
			}
			return result;
		}
	}
	
	public String toString(int mailId){
		return String.valueOf(mailId);
	}
	/**
	 * 删除系统邮件缓存
	 */
	public void delSysMailCache(int mailId){
		if(exists(SYS_MAIL)){
			hdel(SYS_MAIL, toString(mailId));
		}
	}
	
	/**
	 * 查询系统邮件
	 */
	public Map<Integer, SysMail> querySysMailsCache(){
		Map<String, String> map = hgetAll(SYS_MAIL);
		if(isLoad(map)){
			return MailMapMapper.rowMapper(map);
		}
		return null;
	}
	/**
	 * 查询系统邮件
	 */
	public SysMail querySysMailCache(int mailId) throws JedisNoLoadException{
		String str = hget(SYS_MAIL, String.valueOf(mailId));
		if(str != null){
			return JSONUtil.toObject(str, SysMail.class);
		}else if(!isLoad(SYS_MAIL)){
			throw new JedisNoLoadException();
		}
		return null;
	}
	
	/**
	 * 添加缓存邮件
	 */
	public void addSysMailCache(SysMail mail){
		if(!isLoad(SYS_MAIL)){
			hset(SYS_MAIL, LOAD, LOAD);
		}
		hset(SYS_MAIL, toString(mail.getId()), JSONUtil.toJson(mail));
	}

	/**
	 * 设置邮件缓存
	 */
	public void setSysMailsCache(int partner, Map<Integer, SysMail> mailmap){
		setCacheSign();
		try{
			if(!mailmap.isEmpty()){
				hmset(SYS_MAIL, MailObjMapper.objMapper(mailmap));
			}
			hset(SYS_MAIL, LOAD, LOAD);
		}finally{
			clearCacheSign();
		}
	}
	
	/**
	 * 清理邮件缓存
	 */
	public void clearSysMailCache(){
		setCacheSign();
		try{
			del(SYS_MAIL);
		}finally{
			clearCacheSign();
		}
	}
}
