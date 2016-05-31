<%@page import="com.game.service.GamePlayerService"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,com.web.db.bean.*,com.db.util.*,java.sql.*,com.utils.*"%>
<%
	out.write(GamePlayerService.getPlayerList(request, session).toString());
	out.flush();
%>
