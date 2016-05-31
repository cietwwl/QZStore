<%@page import="com.cache.GameServerCache"%>
<%@page import="com.web.db.game.GameServerInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<select id="sid" style="padding:2px;margin-left:0px;">
	<option value="" selected="selected">全部</option>
	<%
	List<GameServerInfo> servers = GameServerCache.getGameServers();
   	for(GameServerInfo server : servers){
   	%>
   		<option value="<%=server.getServerId()%>"><%=server.getServerName() %></option>
   	<%
   	}
   	%>
</select>