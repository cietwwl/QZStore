package com.cache;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.db.util.ConnUtil;
import com.web.db.game.GamePartnerInfo;

/**
 * 渠道缓存
 *
 */
public class GamePartnerCache{
	private static Map<Integer, GamePartnerInfo> partnerMap = new HashMap<Integer, GamePartnerInfo>();
	
	public static void load(){
		try{
			synchronized(partnerMap){
				List<GamePartnerInfo> partners = new ArrayList<GamePartnerInfo>();
				Connection conn = ConnUtil.getConnection();
				try{
					Statement stat = conn.createStatement();
					try{
						ResultSet rest = stat.executeQuery("select * from " + new GamePartnerInfo().getTableName());
						if(rest.next()){
							GamePartnerInfo info = new GamePartnerInfo();
							info.read(rest);
							partners.add(info);
						}
					}finally{
						stat.close();
					}
				}finally{
					conn.close();
				}
				partnerMap.clear();
				for(GamePartnerInfo info : partners){
					partnerMap.put(info.getId(), info);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static List<GamePartnerInfo> getPartners(){
		List<GamePartnerInfo> infos = new ArrayList<GamePartnerInfo>();
		infos.addAll(partnerMap.values());
		return infos;
	}
	
	/**
	 * 获取渠道名称
	 * @param id
	 * @return
	 */
	public static String getPartnerName(int id){
		GamePartnerInfo info = partnerMap.get(id);
		if(info == null){
			return String.valueOf(id);
		}
		return info.getName();
	}
	
	/**
	 * 是否可回调
	 * @param removeAddr
	 * @return
	 */
	public static boolean hasCallback(String removeAddr){
		for(GamePartnerInfo info : partnerMap.values()){
			if(info.equals(removeAddr)){
				return true;
			}
		}
		return false;
	}
	
	public static Map<Integer, String> getPartnerMap(){
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(GamePartnerInfo info : partnerMap.values()){
			map.put(info.getId(), info.getName());
		}
		return map;
	}
	
}
