<%@page import="com.game.service.DownloadService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	out.clear();
	out = pageContext.pushBody();
	DownloadService.downloadKeep(request, response);
%>