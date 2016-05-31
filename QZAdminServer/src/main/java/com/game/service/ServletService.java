package com.game.service;

import javax.servlet.http.HttpServletRequest;

import com.web.obj.ParamError;


/**
 * servlet逻辑类
 *
 */
public class ServletService {
	private static final Class<Short> SHORT = short.class;
	private static final Class<Integer> INT = int.class;
	private static final Class<Long> LONG = long.class;
	private static final Class<Float> FLOAT = float.class;
	private static final Class<Double> DOUBLE = double.class;
	private static final Class<Boolean> BOOLEAN = boolean.class;
	private static final Class<String> STRING = String.class;
	
	public static String getParentPath(HttpServletRequest request){
		return request.getServletPath().substring(1, request.getServletPath().lastIndexOf("/") + 1);
	}
	
	public static String getRemoteAddr(HttpServletRequest request){
		return request.getRemoteAddr();
	}
	
	@SuppressWarnings("unchecked")
	private static <T>T getParam(HttpServletRequest request, Class<T> type, String name, ParamError error){
		Object object = null;
		try{
			if(error.isSuccess()){
				String value = request.getParameter(name);
				if(value != null){
					value = value.trim();
					if(type.equals(SHORT)){
						object = Short.parseShort(value);
					}else if(type.equals(INT)){
						object = Integer.parseInt(value);
					}else if(type.equals(LONG)){
						object = Long.parseLong(value);
					}else if(type.equals(FLOAT)){
						object = Float.parseFloat(value);
					}else if(type.equals(DOUBLE)){
						object = Double.parseDouble(value);
					}else if(type.equals(BOOLEAN)){
						object = Boolean.parseBoolean(value);
					}else{
						object = value;
					}
				}else{
					throw new Exception();
				}
			}
		}catch(Exception e){
			error.addError(name, -1, "[ " + name + " ]参数错误！！！");
		}
		if(!error.isSuccess()){
			if(type.equals(BOOLEAN)){
				object = false;
			}else if(type.equals(STRING)){
				object = "";
			}else{
				object = 0;
			}
		}
		return (T) object;
	}
	
	public static int getParamInt(HttpServletRequest request, String name, ParamError error){
		return getParam(request, INT, name, error);
	}
	
	public static long getParamLong(HttpServletRequest request, String name, ParamError error){
		return getParam(request, LONG, name, error);
	}
	
	public static float getParamFloat(HttpServletRequest request, String name, ParamError error){
		return getParam(request, FLOAT, name, error);
	}
	
	public static double getParamDouble(HttpServletRequest request, String name, ParamError error){
		return getParam(request, DOUBLE, name, error);
	}
	
	public static boolean getParamBoolean(HttpServletRequest request, String name, ParamError error){
		return getParam(request, BOOLEAN, name, error);
	}
	
	public static String getParamString(HttpServletRequest request, String name, ParamError error){
		return getParam(request, STRING, name, error);
	}
}
