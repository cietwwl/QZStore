package com.cache;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.game.service.SysRequestService;
import com.web.db.bean.SysRequestInfo;

/**
 * 请求缓存
 *
 */
public class SysRequestCache {
	private static Map<String, SysRequestInfo> reqMap = new ConcurrentHashMap<String, SysRequestInfo>();
	
	public static synchronized void load(){
		try{
			List<SysRequestInfo> list = SysRequestService.getRequests();
			reqMap = new ConcurrentHashMap<String, SysRequestInfo>();
			for(SysRequestInfo req : list){
				reqMap.put(req.getUrl(), req);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static SysRequestInfo getRequestByUrl(String url){
		return reqMap.get(url);
	}
}
