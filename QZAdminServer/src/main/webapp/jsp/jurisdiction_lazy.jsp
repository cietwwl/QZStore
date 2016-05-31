<%@page import="net.sf.json.JSONObject"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
	JSONObject resp = new JSONObject();
	resp.put("code", -1);
	resp.put("tip", "权限不足！");
	out.write(resp.toString());
	out.flush();
%>
