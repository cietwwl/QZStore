<%@page import="com.game.service.GameServerService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	out.write(GameServerService.serverModify(request, session).toString());
	out.flush();
%>