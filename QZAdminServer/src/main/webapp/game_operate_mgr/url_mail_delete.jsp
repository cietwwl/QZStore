<%@page import="com.game.service.GameMailService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	out.write(GameMailService.mailDelete(request).toString());
	out.flush();
%>