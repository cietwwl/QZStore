<%@page import="com.game.service.GamePartnerService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	out.write(GamePartnerService.partnerSave(request).toString());
	out.flush();
%>