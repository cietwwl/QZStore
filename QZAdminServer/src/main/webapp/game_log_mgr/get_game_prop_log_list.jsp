<%@page import="com.game.service.GameLogService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	out.write(GameLogService.getGamePropLogList(request, session).toString());
	out.flush();
%>