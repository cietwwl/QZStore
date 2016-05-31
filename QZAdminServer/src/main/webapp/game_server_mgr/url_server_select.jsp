<%@page import="com.game.service.GameServerService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%
	out.write(GameServerService.serverSelect(request, session).toString());
	out.flush();
%>
