package com.cache;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.game.service.SysUserService;
import com.security.MD5;
import com.web.db.bean.SysUserGroupInfo;
import com.web.db.bean.SysUserInfo;
import com.web.obj.UserGroup;

/**
 * 用户/分组缓存
 *
 */
public class SysUserCache {
	private static List<SysUserGroupInfo> groupInfos;
	private static Map<Integer, UserGroup> groupMap = new ConcurrentHashMap<Integer, UserGroup>();
	private static Map<String, SysUserInfo> userMap = new ConcurrentHashMap<String, SysUserInfo>();
	
	public static void load(){
		loadUser();
		loadGroup();
	}
	
	public static void loadGroup(){
		try{
			groupInfos = SysUserService.getUserGroupInfos();
			groupMap = new ConcurrentHashMap<Integer, UserGroup>();
			for(SysUserGroupInfo info : groupInfos){
				UserGroup group = new UserGroup(info);
				groupMap.put(group.getId(), group);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void loadUser(){
		try{
			List<SysUserInfo> list = SysUserService.getUserInfos();
			for(SysUserInfo info : list){
				userMap.put(info.getUsername(), info);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static UserGroup getUserGroup(int id){
		return groupMap.get(id);
	}
	
	public static List<SysUserGroupInfo> getUserGroupInfos(){
		return groupInfos;
	}
	
	public static SysUserInfo getSysUserInfo(String username, String password){
		SysUserInfo info = userMap.get(username);
		if(info != null && info.getPassword().equals(MD5.encode(password))){
			return info;
		}
		return null;
	}
}
