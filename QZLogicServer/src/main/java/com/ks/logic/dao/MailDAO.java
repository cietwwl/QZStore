package com.ks.logic.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetDeleteSqlSet;
import com.ks.access.DBBeanSetInsertSqlSet;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.DBBeanSetUpdateSqlSet;
import com.ks.access.GameDAOTemplate;
import com.ks.cache.JedisNoLoadException;
import com.ks.constant.SystemConstant;
import com.ks.db.model.Mail;
import com.ks.table.MailTable;
import com.ks.util.JSONUtil;
/**
 * 邮件dao
 * @author ks
 */
public class MailDAO extends GameDAOTemplate {

	private static final String MAIL = "MAIL_";
	private static final String LOAD = "LOAD";
	
	private static final String getTableName(int userId){
		return "t_mail_"+(userId%10);
	}
	
	public static final String getMailSetKey(int userId){
		return MAIL + userId;
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryMails", dbbean=Mail.class, wheres={MailTable.USERID}, oderby=MailTable.MAILID + " desc")})
	public List<Mail> queryMails(int userId){
		String sql = DBBeanRowMapperManager.getDynamicSql(Mail.class, "queryMails", getTableName(userId));
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(Mail.class), userId);
	}
//	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryMail", dbbean=Mail.class, wheres={MailTable.USERID, MailTable.MAILID})})
//	public Mail queryMail(int userId, int mailId){
//		String sql = DBBeanRowMapperManager.getDynamicSql(Mail.class, "queryMail", getTableName(userId));
//		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(Mail.class), userId, mailId);
//	}
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateMail", dbbean=Mail.class, wheres={MailTable.USERID, MailTable.MAILID})})
	public void updateMail(Mail mail){
		mail.setUpdateTime(new Date());
		String sql = DBBeanRowMapperManager.getDynamicSql(Mail.class, "updateMail", getTableName(mail.getUserId()));
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(Mail.class, "updateMail", mail);
		saveOrUpdate(sql, params.toArray());
	}
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addMail", dbbean=Mail.class)})
	public void addMail(Mail mail){
		String sql = DBBeanRowMapperManager.getDynamicSql(Mail.class, "addMail", getTableName(mail.getUserId()));
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(Mail.class, "addMail", mail);
		int id = insertAndReturnId(sql, INT_KEY, params.toArray());
		mail.setMailId(id);
	}
	@DBBeanSetSqlSetList(deletes={@DBBeanSetDeleteSqlSet(name="deleteMail", dbbean=Mail.class, wheres={MailTable.USERID, MailTable.MAILID})})
	public void deleteMail(int userId, int mailId){
		String sql = DBBeanRowMapperManager.getDynamicSql(Mail.class, "deleteMail", getTableName(userId));
		saveOrUpdate(sql, userId, mailId);
	}
	
	/*******************************************************mail cache********************************************************************/
	public static class MailMapMapper{
		public static Map<Integer, Mail> rowMapper(Map<String, String> map) {
			Map<Integer, Mail> result = new HashMap<Integer, Mail>();
			for(Map.Entry<String, String> entry : map.entrySet()){
				if(!entry.getKey().equals(LOAD)){
					Mail bean = JSONUtil.toObject(entry.getValue(), Mail.class);
					result.put(bean.getMailId(), bean);
				}
			}
			return result;
		}
	}
	
	public static class MailObjMapper{
		public static Map<String, String> objMapper(Map<Integer, Mail> map) {
			Map<String, String> result = new HashMap<String, String>();
			for(Map.Entry<Integer, Mail> entry : map.entrySet()){
				result.put(entry.getKey().toString(), JSONUtil.toJson(entry.getValue()));
			}
			return result;
		}
	}
	/**
	 * 删除邮件缓存
	 * @param userId
	 * @param mailId
	 */
	public void delMailCache(int userId, int mailId){
		String setKey = getMailSetKey(userId);
		hdel(setKey, String.valueOf(mailId));
	}
	/**
	 * 查询缓存邮件
	 */
	public Map<Integer, Mail> queryMailsCache(int userId){
		String setKey = getMailSetKey(userId);
		Map<String, String> map = hgetAll(setKey);
		if(isLoad(map)){
			expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
			return MailMapMapper.rowMapper(map);
		}
		return null;
	}
	/**
	 * 查询缓存邮件
	 */
	public Mail queryMailCache(int userId, int mailId) throws JedisNoLoadException{
		String setKey = getMailSetKey(userId);
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
		String str = hget(setKey, String.valueOf(mailId));
		if(str != null){
			return JSONUtil.toObject(str, Mail.class);
		}else if(!isLoad(setKey)){
			throw new JedisNoLoadException();
		}
		return null;
	}
	
	/**
	 * 添加缓存邮件
	 */
	public void addMailCache(Mail mail){
		String setKey = getMailSetKey(mail.getUserId());
		hset(setKey, String.valueOf(mail.getMailId()), JSONUtil.toJson(mail));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}

	/**
	 * 添加好友到缓存
	 */
	public void setMailsCache(int userId, Map<Integer, Mail> mailmap){
		setCacheSign();
		try{
			String setKey = getMailSetKey(userId);
			del(setKey);
			if(!mailmap.isEmpty()){
				hmset(setKey, MailObjMapper.objMapper(mailmap));
			}
			hset(setKey, LOAD, LOAD);
			expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
		}finally{
			clearCacheSign();
		}
	}
	
	/**
	 * 更新邮件缓存
	 */
	public void updateMailCache(Mail mail){
		String setKey = getMailSetKey(mail.getUserId());
		hset(setKey, String.valueOf(mail.getMailId()), JSONUtil.toJson(mail));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}
	/**
	 * 清理邮件缓存
	 */
	public void clearMailsCache(int userId){
		del(getMailSetKey(userId));
	}
}
