package com.game.constant;

import java.util.Properties;

import com.utils.PropertiesUtil;

/**
 * 常数
 *
 */
public class GameConstant {
	
	/**访问间隔时间*/
	public final static int ACCESS_TIME = 5 * 60;
	/**key*/
	public static String MONEY_KEY;
	/**人民币折算成钻石*/
	public static int MONEY_TO_GOLD;
	
	public static void init(String path){
		try{
			Properties properties = PropertiesUtil.read(path);
			MONEY_KEY = PropertiesUtil.getValue(properties, "key");
			MONEY_TO_GOLD = PropertiesUtil.getValueInt(properties, "money_gold");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
