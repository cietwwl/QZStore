<%@page import="com.game.service.GameStatsService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	out.write(GameStatsService.getMaxOnlineReport(request, session).toString());
	out.flush();
%>