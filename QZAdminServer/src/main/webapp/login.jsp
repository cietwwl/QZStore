<%@page import="com.cache.SysUserCache"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,com.web.db.bean.*,com.db.util.*,java.sql.*,com.utils.*" pageEncoding="UTF-8"%>
<%
	session.removeAttribute("user");
	session.removeAttribute("selserver");
	session.removeAttribute("userGroup");
	String rat = request.getParameter("rat");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	if(username != null && username.length() > 0 && password != null && password.length() > 0){
		SysUserInfo user = SysUserCache.getSysUserInfo(username, password);
		if(user == null){
			session.setAttribute("username", username);
			session.setAttribute("error", "用户名或密码错误!");
			response.sendRedirect("index.jsp");
		}else{
			session.setAttribute("user", user);
			session.setAttribute("rat", rat);
			response.sendRedirect("main.jsp");
		}
	}else{
		if(username != null || password != null){
			session.setAttribute("error", "用户名或密码错误!");
		}
		response.sendRedirect("index.jsp");
	}
%>