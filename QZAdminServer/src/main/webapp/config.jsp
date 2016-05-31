<%@page import="com.cache.SysMenuCache"%>
<%@page import="com.web.db.bean.SysMenuInfo"%>
<%@page import="com.web.db.game.GameServerInfo"%>
<%@page import="java.util.List"%>
<%@page import="com.cache.GameServerCache"%>
<%@page import="com.cache.SysUserCache"%>
<%@page import="com.web.obj.UserGroup"%>
<%@page import="com.web.db.bean.SysUserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	SysUserInfo user = (SysUserInfo)session.getAttribute("user");
	if(user == null){
		response.sendRedirect("index.jsp");
		return ;
	}
	UserGroup group = (UserGroup)session.getAttribute("userGroup");
	if(group == null){
		group = SysUserCache.getUserGroup(user.getUserGroupId());
		if(group == null){
			response.sendRedirect("index.jsp");
			return ;
		}
		session.setAttribute("userGroup", group);
	}
	GameServerInfo selserver = (GameServerInfo)session.getAttribute("selserver");
	if(selserver == null){
		GameServerCache.initDefaultServer(session);
	}
	List<GameServerInfo> servers = GameServerCache.getGameServers();
	List<SysMenuInfo> menus = SysMenuCache.getMenus(group);
	String mainCcs = null;
	int rat = Integer.parseInt((String)session.getAttribute("rat"));
	if(rat == 1){
		mainCcs = "css/admin/basic1.css?version=1.1";
	}else if(rat == 2){
		mainCcs = "css/admin/basic.css?version=1.1";
	}else{
		mainCcs = "css/admin/basic2.css?version=1.1";
	}
%>