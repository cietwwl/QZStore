<%@page import="com.game.service.SysUserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	out.write(SysUserService.getUserList(request, session).toString());
	out.flush();
%>