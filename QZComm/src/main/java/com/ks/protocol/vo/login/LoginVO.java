package com.ks.protocol.vo.login;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 登录消息
 * @author ks
 *
 */
public class LoginVO extends Message {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="用户名")
	private String username;
	@FieldDesc(desc="合作方")
	private int partner;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPartner() {
		return partner;
	}
	public void setPartner(int partner) {
		this.partner = partner;
	}
	
}
