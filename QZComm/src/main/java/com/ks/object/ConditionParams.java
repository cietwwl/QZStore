package com.ks.object;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ks.util.XyStringUtil;

public class ConditionParams {
	private Map<Integer, Integer> paramsMap;
	
	public ConditionParams(String str){
		paramsMap = XyStringUtil.parseMap(str, XyStringUtil.SPLIT_VERTICALLINE, XyStringUtil.SPLIT_UNDERLINE);
	}
	
	public List<Integer> getKeys(){
		List<Integer> list = new ArrayList<>();
		if(!paramsMap.isEmpty()){
			list.addAll(paramsMap.keySet());
		}
		return list;
	}
	
	public int getParam(int type){
		Integer value = paramsMap.get(type);
		if(value != null){
			return value;
		}
		return 0;
	}
	
	
}
