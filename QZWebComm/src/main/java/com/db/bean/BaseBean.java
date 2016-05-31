package com.db.bean;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import net.sf.json.JSONObject;

import com.utils.JSONUtil;
import com.utils.StringUtil;

@SuppressWarnings({"rawtypes", "serial"})
@Data
public abstract class BaseBean implements Serializable {
	private int id;
	
	public String getUpdateData() throws Exception{
		StringBuffer sb = new StringBuffer();
		sb.append("update ").append(getTableName()).append(" set ");
		List<Field> fields = getFields();
		for(Field field : fields){
			field.setAccessible(true);
			sb.append(getFieldName(field.getName())).append("=").append(getSqlValue(field)).append(",");
		}
		sb.setLength(sb.length() - 1);
		sb.append(" where n_id=").append(id);
		return sb.toString();
	}
	public String getDeleteData(){
		StringBuffer sb = new StringBuffer();
		sb.append("delete from ").append(getTableName());
		if(id != -1){
			sb.append(" where n_id=").append(id);
		}
		return sb.toString();
	}
	public String getInsertData() throws Exception{
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("insert ").append(getTableName()).append("(");
		List<Field> fields = getFields();
		for(Field field : fields){
			field.setAccessible(true);
			sb.append(getFieldName(field)).append(",");
			params.add(getSqlValue(field));
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
	
	public String getTableName(){
		return "t_" + this.getClass().getSimpleName().toLowerCase();
	}
	
	public void read(ResultSet result) throws Exception{
		ResultSetMetaData data = result.getMetaData();
		for(int i = 1; i <= data.getColumnCount(); i++){
			String cname = data.getColumnLabel(i);
			String fname = cname.substring(2);
			Field field = getField(fname);
			if(field != null){
				field.setAccessible(true);
				Object value = result.getObject(cname);
				if(value != null){
					if(value instanceof Number){
						field.set(this, ((Number)value).intValue());
					}else{
						field.set(this, value);
					}
				}
			}
		}
	}
	
	public Field getField(String name) throws Exception{
		List<Field> fields = getFields();
		for(Field field : fields){
			if(field.getName().equals(name)){
				return field;
			}
		}
		return null;
	}
	
	public List<Field> getFields() throws Exception{
		List<Field> list = new ArrayList<Field>();
		Class clazz = this.getClass();
		while(clazz != Object.class){
			Field[] fields = clazz.getDeclaredFields();
			for(Field field : fields){
				list.add(field);
			}
			clazz = clazz.getSuperclass();
		}
		return list;
	}
	
	public String getFieldName(Field field){
		return getFieldName(field.getName());
	}
	
	public String getFieldName(String fieldname){
		return "n_" + fieldname;
	}
	
	public String getSqlValue(Field field) throws Exception{
		Object object = field.get(this);
		return StringUtil.getSqlValue(object);
	}
	
	public JSONObject toJson() throws Exception{
		JSONObject json = JSONUtil.parseSimpleJSON(this, getClass());
		return json;
	}
}
