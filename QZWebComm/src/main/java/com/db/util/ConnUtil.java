package com.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.db.bean.BaseBean;
import com.utils.PropertiesUtil;


public class ConnUtil {
	private static ConnParam param;
	
	public static void init(String config){
		try {
			Properties properties = PropertiesUtil.read(config);
			param = new ConnParam();
			param.read(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception{
		Class.forName(param.getDriver());
		Connection conn = DriverManager.getConnection(param.getUrl(), param.getUsername(), param.getPassword());
		return conn;
	}
	
	public static Connection getConnection(ConnParam param) throws Exception{
		Class.forName(param.getDriver());
		Connection conn = DriverManager.getConnection(param.getUrl(), param.getUsername(), param.getPassword());
		conn.setReadOnly(true);
		return conn;
	}
	
	public static void closeConnection(Connection conn) throws Exception{
		if(!conn.isClosed()){
			conn.close();
		}
	}
	
	public static void insert(Statement stmt, BaseBean bean) throws Exception{
		String sql = bean.getInsertData();
		stmt.executeUpdate(sql);
		String sql1 ="select LAST_INSERT_ID() ";
		ResultSet resultSet= stmt.executeQuery(sql1);
		resultSet.next(); 
		Long id = resultSet.getLong(1); 
		bean.setId(id.intValue());
	}
}
