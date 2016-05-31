package com.http.message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Data;

import com.utils.URLCoder;

@Data
public class CommonHttpRequest {
	public final static String METHOD_GET = "GET";
	public final static String METHOD_POST = "POST";
	public final static String CODE_UTF_8 = "utf-8";
	private String url;
	private String method;
	private boolean encode = false;
	private int timeout = 3000;
	private String code = CODE_UTF_8;
	protected List<CommonHttpRequestParam> params = new ArrayList<CommonHttpRequestParam>();
	public CommonHttpRequest(String url, String method){
		this.url = url;
		this.method = method;
	}
	public void addParam(CommonHttpRequestParam param){
		params.add(param);
	}
	public void addParam(String name, Object value){
		if(value != null){
			CommonHttpRequestParam param = new CommonHttpRequestParam(name, value);
			addParam(param);
		}
	}
	public void sortParams(){
		Collections.sort(params);
	}
	public String getEncodeParamString() throws Exception{
		StringBuffer sb = new StringBuffer();
		for(CommonHttpRequestParam param : params){
			sb.append(param.name).append("=").append(URLCoder.encode(param.value.toString(), "UTF-8")).append("&");
		}
		if(sb.length() > 0){
			return sb.substring(0, sb.length() - 1);
		}
		return "";
	}
	public String getParamString(){
		StringBuffer sb = new StringBuffer();
		for(CommonHttpRequestParam param : params){
			sb.append(param.name).append("=").append(param.value).append("&");
		}
		if(sb.length() > 0){
			return sb.substring(0, sb.length() - 1);
		}
		return "";
	}
	public void finish() throws Exception{
	}
	@Data
	public static class CommonHttpRequestParam implements Comparable<CommonHttpRequestParam>{
		public String name;
		public Object value;
		public CommonHttpRequestParam(String name, Object value){
			this.name = name;
			this.value = value;
		}
		@Override
		public int compareTo(CommonHttpRequestParam param) {
			return name.compareTo(param.name);
		}
	}
}
