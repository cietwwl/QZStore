<%@page import="com.game.service.GameItemService"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	out.write(GameItemService.getItemList(request, session).toString());
	out.flush();
%>