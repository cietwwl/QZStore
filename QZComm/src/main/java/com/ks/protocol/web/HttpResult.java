package com.ks.protocol.web;

import java.io.Serializable;

public class HttpResult implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int code;
	private String tip;
	private Object data;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
