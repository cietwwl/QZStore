package com.web.obj;

import lombok.Data;
import net.sf.json.JSONObject;

@Data
public class ParamError {
	private int error;
	private String fieldName = "";
	private int code;
	private String tips = "";
	
	public void addError(String fieldName, int code, String tips){
		this.fieldName = fieldName;
		this.code = code;
		this.tips = tips;
		this.error = 1;
	}
	
	public boolean isSuccess(){
		return error == 0;
	}
	
	public JSONObject getErrorData(){
		if(code == 0){
			code = -1;
			tips = "参数错误";
		}
		JSONObject resp = new JSONObject();
		resp.put("code", code);
		resp.put("tip", tips);
		return resp;
	}
	
	public JSONObject getServerError(){
		JSONObject resp = new JSONObject();
		resp.put("code", -1);
		resp.put("tip", "服务器不存在");
		return resp;
	}
	
	public JSONObject getUserError(){
		JSONObject resp = new JSONObject();
		resp.put("code", -1);
		resp.put("tip", "用户不存在");
		return resp;
	}

}
