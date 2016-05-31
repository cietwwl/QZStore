<%@page import="com.game.service.SysRequestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	out.write(SysRequestService.requestSave(request).toString());
	out.flush();
%>