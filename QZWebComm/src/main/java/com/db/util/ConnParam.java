package com.db.util;

import java.util.Properties;

import lombok.Data;


@Data
public class ConnParam {
	private String driver = "com.mysql.jdbc.Driver";
	private String url;
	private String username;
	private String password;
	public void read(Properties properties){
		this.driver = properties.getProperty("driver");
		this.url = properties.getProperty("url");
		this.username = properties.getProperty("username");
		this.password = properties.getProperty("password");
	}
}
