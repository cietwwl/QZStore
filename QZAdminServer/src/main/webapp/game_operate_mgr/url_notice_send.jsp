<%@page import="com.game.service.GameOtherService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	out.write(GameOtherService.noticeSend(request).toString());
	out.flush();
%>