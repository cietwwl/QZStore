<%@page import="com.game.service.GameLogService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	out.write(GameLogService.getGameStaminaLogList(request, session).toString());
	out.flush();
%>