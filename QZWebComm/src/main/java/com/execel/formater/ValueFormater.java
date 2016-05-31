package com.execel.formater;

import java.lang.reflect.Field;

import lombok.Data;

@Data
public class ValueFormater {
	private String hname;
	private String fname;
	
	public ValueFormater(String hname, String fname) {
		super();
		this.hname = hname;
		this.fname = fname;
	}

	public String format(Object obj) throws Exception{
		Field field = getField(obj, fname);
		if(field != null){
			field.setAccessible(true);
			Object value = field.get(obj);
			if(value != null){
				return value.toString();
			}
		}
		return "";
	}
	
	@SuppressWarnings("rawtypes")
	public Field getField(Object obj, String fieldname){
		Field field = null;
		Class clazz = obj.getClass();
		while(clazz != Class.class){
			try {
				field = clazz.getDeclaredField(fname);
				break;
			} catch (SecurityException e) {
			} catch (NoSuchFieldException e) {
			}
			clazz = clazz.getSuperclass();
		}
		return field;
	}
}
