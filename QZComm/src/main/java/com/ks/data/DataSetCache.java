package com.ks.data;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务端向客户端推送的数据
 * @author zck
 *
 */
public class DataSetCache {
	private static ThreadLocal<Map<String, DataSet>> datas = new ThreadLocal<Map<String, DataSet>>();
	private static IDataSetHandler handler;
	
	public static void init(IDataSetHandler handler){
		DataSetCache.handler = handler;
	}
	
	public static DataSet getDataSet(String key){
		Map<String, DataSet> map = datas.get();
		if(map == null){
			map = new HashMap<String, DataSet>(); 
			datas.set(map);
		}
		DataSet set = map.get(key);
		if(set == null){
			set = new DataSet();
			map.put(key, set);
		}
		return set;
	}
	
	public static Map<String, DataSet> getThreadData(){
		return datas.get();
	}
	
	public static void clearThreadData(){
		datas.remove();
	}
	
	public static void flushThreadData(){
		handler.flushThreadData();
	}
	
}
