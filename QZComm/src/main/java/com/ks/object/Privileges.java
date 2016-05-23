package com.ks.object;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.ks.util.XyStringUtil;

public class Privileges {
	private Map<Integer, Privilege> privilegeMap = new ConcurrentHashMap<Integer, Privilege>();
	
	public Privileges(){}
	public Privileges(String value)throws Exception{
		List<String> strs = XyStringUtil.parseListByString(value, XyStringUtil.SPLIT_AND);
		for(String str : strs){
			List<String> its = XyStringUtil.parseListByString(str, XyStringUtil.SPLIT_EQUAL);
			if(its.size() >= 2){
				int type = Integer.parseInt(its.get(0));
				privilegeMap.put(type, new Privilege(type, its.get(1)));
			}
		}
	}
	
	public Privilege getPrivilege(int type){
		return privilegeMap.get(type);
	}
	public Map<Integer, Privilege> getPrivilegeMap(){
		return privilegeMap;
	}
	public void addPrivilege(Privilege privilege){
		Privilege old = privilegeMap.get(privilege.getType());
		if(old == null){
			privilegeMap.put(privilege.getType(), privilege);
		}else{
			old.merge(privilege);
		}
	}
	
	public void merge(Privileges privileges){
		Map<Integer, Privilege> map = privileges.getPrivilegeMap();
		for(Integer key : map.keySet()){
			Privilege privilege = getPrivilege(key);
			if(privilege != null){
				privilege.merge(map.get(key));
			}else{
				privilegeMap.put(key, map.get(key));
			}
		}
	}
	
//	/**
//	 * 获取差值
//	 */
//	public int getSurplus(int type, Privileges olds){
//		return getValueInt(type) - olds.getValueInt(type);
//	}
	public int getValueInt(int type){
		Privilege privilege = privilegeMap.get(type);
		if(privilege != null && privilege.getValueString().length() > 0){
			return privilege.getValueInt();
		}
		return 0;
	}
	public Privileges copy(){
		Privileges privileges = new Privileges();
		for(Privilege privilege : privilegeMap.values()){
			privileges.addPrivilege(privilege);
		}
		return privileges;
	}
}
