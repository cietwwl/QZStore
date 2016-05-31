package com.utils;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.utils.TimeUtil.DATE_FORMATER;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONUtil {
	
	public static JSONObject parseDBJsonObject(Object object, List<Field> fields) throws Exception{
		JSONObject json = new JSONObject();
		for(Field f : fields){
			f.setAccessible(true);
			String fname = f.getName();
			Object value = f.get(object);
			if(value instanceof Date){
				value = TimeUtil.formatDate((Date)value, TimeUtil.DATE_FORMATER.yyyy_MM_dd_HH_mm_ss);
			}
			json.put(fname, value);
		}
		return json;
	}
	
	@SuppressWarnings("rawtypes")
	public static JSONArray  parseSimpleJSONArray(Collection collection, Class clazz) throws Exception{
		JSONArray array = new JSONArray();
		for(Object obj : collection){
			array.add(parseSimpleJSON(obj, clazz));
		}
		return array;
	}
	
	@SuppressWarnings("rawtypes")
	public static JSONObject parseSimpleJSON(Object object, Class clazz) throws Exception{
		JSONObject json = new JSONObject();
		while(clazz != Object.class){
			Field[] fields = clazz.getDeclaredFields();
			for(Field f : fields){
				f.setAccessible(true);
				String fname = f.getName();
				Object value = f.get(object);
				if(value instanceof Date){
					value = TimeUtil.formatDate((Date)value, TimeUtil.DATE_FORMATER.yyyy_MM_dd_HH_mm_ss);
				}
				json.put(fname, value);
			}
			clazz = clazz.getSuperclass();
		}
		return json;
	}
	
	@SuppressWarnings("rawtypes")
	public static JSONArray  parseSimpleJSONArray(Collection collection, String[] fnames) throws Exception{
		JSONArray array = new JSONArray();
		for(Object obj : collection){
			array.add(parseSimpleJSON(obj, fnames));
		}
		return array;
	}
	
	@SuppressWarnings("rawtypes")
	public static JSONObject parseSimpleJSON(Object object, String[] fnames) throws Exception{
		JSONObject json = new JSONObject();
		for(String fname : fnames){
			Class clazz = object.getClass();
			Field f = null;
			while(clazz != Object.class){
				try{
					f = clazz.getDeclaredField(fname);
				}catch(Exception e){
					clazz = clazz.getSuperclass();
				}
				if(f != null){
					break;
				}
			}
			f.setAccessible(true);
			if(f.getGenericType() == Date.class){
				Date date = (Date)f.get(object);
				if(date != null){
					json.put(fname, TimeUtil.formatDate(date, DATE_FORMATER.yyyy_MM_dd_HH_mm_ss));
				}else{
					json.put(fname, "");
				}
			}else{
				json.put(fname, f.get(object));
			}
		}
		return json;
	}
	
	public static JSONObject parseJSON(String str) throws Exception{
		JSONObject json = JSONObject.fromObject(str);
		return json;
	}
	
	public static JSONArray parseJSONArray(String str) throws Exception{
		JSONArray array = JSONArray.fromObject(str);
		return array;
	}
	
	@SuppressWarnings("rawtypes")
	public static Object parseObject(JSONObject json, Class clazz){
		return JSONObject.toBean(json, clazz);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List parseList(JSONArray array, Class clazz){
		Collection collection = JSONArray.toCollection(array, clazz);
		List list = new ArrayList();
		for(Object o : collection){
			list.add(o);
		}
		return list;
	}
}
