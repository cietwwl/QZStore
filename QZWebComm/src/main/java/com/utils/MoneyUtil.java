package com.utils;

import net.sf.json.JSONObject;

public class MoneyUtil {
	public static JSONObject createMoneyJson(int type, int id, String name, int quality){
		JSONObject json = new JSONObject();
		json.put("itemType", type);
		json.put("name", name);
		json.put("quality", quality);
		json.put("jobId", 0);
		json.put("id", id);
		json.put("usedLevel", 1);
		return json;
	}
}
