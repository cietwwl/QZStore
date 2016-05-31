<%@page import="com.game.service.SysMenuService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	out.write(SysMenuService.getMenuList(request).toString());
	out.flush();
%>