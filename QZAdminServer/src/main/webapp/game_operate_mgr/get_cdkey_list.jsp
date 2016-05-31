<%@page import="com.game.service.GameCdKeyService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	out.write(GameCdKeyService.getCdkeyList(request).toString());
	out.flush();
%>