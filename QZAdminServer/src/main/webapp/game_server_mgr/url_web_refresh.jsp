<%@page import="com.game.service.GameWebService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	out.write(GameWebService.webRefresh(request).toString());
	out.flush();
%>