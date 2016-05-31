<%@page import="com.cache.GamePartnerCache"%>
<%@page import="com.web.db.game.GamePartnerInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% List<GamePartnerInfo> partners = GamePartnerCache.getPartners(); %>
<select id="partner" style="margin-left:0px;padding:2px;">
	<option value='0' selected='selected'>全渠道</option>
	<%
		for(GamePartnerInfo info : partners){
			%>
				<option value='<%=info.getId()%>'><%=info.getName()%></option>
			<%
		}
	%>
</select>