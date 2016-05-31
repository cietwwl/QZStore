<%@page import="com.game.service.GamePlayerService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	out.write(GamePlayerService.banAccount(request, session).toString());
	out.flush();
%>