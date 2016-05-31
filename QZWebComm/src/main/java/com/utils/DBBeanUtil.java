package com.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBFieldSet;
import com.ks.access.mapper.RowMapper;

/**
 * QZ-DB工具类
 *
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class DBBeanUtil {
	
	public static String getUpdateData(Object obj, String tablename, String... cfs) throws Exception{
		StringBuffer sb = new StringBuffer();
		sb.append("update ").append(tablename).append(" set ");
		List<Field> fields = getDBFields(obj);
		for(Field field : fields){
			field.setAccessible(true);
			sb.append(getFieldName(field.getName())).append("=").append(getFieldSqlValue(obj, field)).append(",");
		}
		sb.setLength(sb.length() - 1);
		if(cfs.length > 0){
			sb.append(" where ");
			for(String cf : cfs){
				sb.append(cf).append("=").append(getFieldSqlValue(obj, getDBField(obj, cf)));
			}
		}
		return sb.toString();
	}
	public static String getDeleteData(String tablename, Map<String, Object> params) throws Exception{
		StringBuffer sb = new StringBuffer();
		sb.append("delete from ").append(tablename);
		if(!params.isEmpty()){
			sb.append(" where ");
			for(Map.Entry<String, Object> entry : params.entrySet()){
				sb.append(entry.getKey()).append("=").append(StringUtil.getSqlValue(entry.getValue()));
			}
		}
		return sb.toString();
	}
	public static String getInsertData(Object obj, String tablename) throws Exception{
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("insert ").append(tablename).append("(");
		List<Field> fields = getDBFields(obj);
		for(Field field : fields){
			field.setAccessible(true);
			sb.append(getFieldName(field)).append(",");
			params.add(getFieldSqlValue(obj, field));
		}
		sb.setLength(sb.length() - 1);
		sb.append(") values (");
		for(int i = 0; i < params.size(); i++){
			sb.append(params.get(i)).append(",");
		}
		sb.setLength(sb.length() - 1);
		sb.append(")");
		return sb.toString();
	}
	
	public static <T>T read(Object obj, ResultSet result) throws Exception{
		RowMapper mapper = DBBeanRowMapperManager.getRowMapper(obj.getClass());
		if(mapper != null){
			obj = mapper.rowMapper(result);
		}else{
			ResultSetMetaData data = result.getMetaData();
			List<Field> fields = getDBFields(obj);
			for(int i = 1; i <= data.getColumnCount(); i++){
				String cname = data.getColumnName(i);
				Field field = getDBField(fields, cname);
				if(field != null){
					field.setAccessible(true);
					Object value = result.getObject(cname);
					if(value != null){
						Type type = field.getGenericType();
						if(type == int.class){
							field.set(obj, ((Number)value).intValue());
						}else if(type == long.class){
							field.set(obj, ((Number)value).longValue());
						}else if(type == double.class){
							field.set(obj, ((Number)value).doubleValue());
						}else if(type == float.class){
							field.set(obj, ((Number)value).floatValue());
						}else if(type == boolean.class){
							field.set(obj, (Boolean)value);
						}else{
							field.set(obj, value);
						}
					}
				}
			}
		}
		return (T)obj;
	}
	
	public static Field getDBField(Object obj, String name) throws Exception{
		List<Field> fields = getDBFields(obj);
		for(Field field : fields){
			DBFieldSet fieldSet = field.getAnnotation(DBFieldSet.class);
			if(fieldSet.dbfname().equals(name)){
				return field;
			}
		}
		return null;
	}
	
	public static Field getDBField(List<Field> fields, String name) throws Exception{
		for(Field field : fields){
			DBFieldSet fieldSet = field.getAnnotation(DBFieldSet.class);
			if(fieldSet.dbfname().equals(name)){
				return field;
			}
		}
		return null;
	}
	
	public static List<Field> getDBFields(Object obj) throws Exception{
		Class clazz = obj.getClass();
		List<Field> list = getDBFields(clazz);
		return list;
	}
	
	public static List<Field> getDBFields(Class clazz) throws Exception{
		List<Field> list = new ArrayList<Field>();
		while(clazz != Object.class){
			Field[] fields = clazz.getDeclaredFields();
			for(Field field : fields){
				if(field.isAnnotationPresent(DBFieldSet.class)){
					list.add(field);
				}
			}
			clazz = clazz.getSuperclass();
		}
		return list;
	}
	
	public static String getFieldName(Field field){
		return getFieldName(field.getName());
	}
	
	public static String getFieldName(String fieldname){
		return fieldname;
	}
	
	public static String getFieldSqlValue(Object obj, Field field) throws Exception{
		Object object = field.get(obj);
		return StringUtil.getSqlValue(object);
	}
	
	public static JSONObject toJson(Object obj) throws Exception{
		JSONObject json = JSONUtil.parseSimpleJSON(obj, obj.getClass());
		return json;
	}
}
