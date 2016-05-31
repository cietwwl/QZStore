<%@page import="com.game.service.GameMailService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	out.write(GameMailService.sysmailApply(request, session).toString());
	out.flush();
%>