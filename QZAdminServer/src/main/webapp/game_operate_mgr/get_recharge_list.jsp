<%@page import="com.game.service.GameRechargeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	out.write(GameRechargeService.getRechargeList(request).toString());
	out.flush();
%>