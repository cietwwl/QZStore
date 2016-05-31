<%@page import="com.game.service.SysJurisdictionService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	out.write(SysJurisdictionService.getJurisdictionList(request).toString());
	out.flush();
%>