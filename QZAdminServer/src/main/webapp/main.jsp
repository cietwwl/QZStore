<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="config.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Language" content="zh-cn" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="Robots" content="all" />
    <meta name="keywords" content="all" />
    <meta name="description" content="" />
    <meta name="author" content="slime" />
    <meta name=copyright content="2010" />
    <meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Cache-Control" content="no-cache" /> 
	<meta HTTP-EQUIV="Expires" CONTENT="0">
	<meta http-equiv="Cache" content="no-cache">
    <title>后管管理</title>
    <link rel="stylesheet" type="text/css" href='<%=mainCcs%>' />
    <link rel="stylesheet" type="text/css" href="css/themes/ui-lightness/jquery.ui.all.css" />
    <link rel="stylesheet" type="text/css" href="css/flexigrid.css?version=1.1">
    <link rel="stylesheet" type="text/css" href="css/button.css?version=1.0">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.8.2.custom.min.js"></script>
	<script type="text/javascript" src="js/flexigrid.js?version=1.1"></script>
	<script type="text/javascript" src="js/jquery.datepickercn.js"></script>
	<script type="text/javascript" src="js/highcharts.src.js"></script>
	<script type="text/javascript" src="js/exporting.js"></script>
	<script type="text/javascript" src="js/cmd.js?version=1.1"></script>
    <script type="text/javascript" src="js/common.js?version=1.0"></script>
    <%@include file="/jsp/global_config.jsp"%>
</head>
<body id="sl-index">
<div id="sl-wrap" class="ui-widget-content">
  <div id="sl-header" class="ui-widget-header">
        <h2 align="center" style="margin-bottom: 2px;margin-top: 2px;">管理后台-棋战</h2>
        <div style="margin-bottom: 2px;">
	 		<b>当前帐号：</b><a style="color:#2932E1"><%=user.getUsername() %></a>　
	 		<b style="margin-left: 20px;">登录时间：</b><a style="color:#2932E1"> <%=TimeUtil.formatDate(new Date(), TimeUtil.DATE_FORMATER.CHINA_yyyy_MM_dd_EN_HH_mm_ss) %></a>
	        <b style="margin-left: 30px;">当前服务器：</b>
	       	<select id="gameServer" onchange="changeGameServer();">
	       		<%
	       		for(int i = 0; i < servers.size(); i++){
	       			GameServerInfo server = servers.get(i);
	       			if((selserver == null && i == 0) || (selserver != null && selserver.getId() == server.getId())){
	       		%>
	           		<option value="<%=server.getId()%>" selected="selected"><%=server.getServerName() %></option>
	           	<%		
	       			}else{
	       		%>
	       			<option value="<%=server.getId()%>"><%=server.getServerName() %></option>
	       		<%
	       			}
	       		}
	       		%>
	       	</select>
        	<span><input id="checkState" type="checkbox" style="margin-left: 2px; margin-right: 2px;vertical-align: middle;" checked="checked"><label for="checkState" style="color: red;vertical-align: middle;">check</label></span>
	        <span style="float: right;margin-right: 30px;">
	 		<a style="margin-right:5px;color:#2932E1;" href="logout.jsp">退出</a>
	        <a style='margin-right:5px;color:#2932E1;' href="" onclick="flush();">刷新</a></span>
        </div>
  </div>
  <div id="sl-main-nav">
        <div id="sl-accordion">
        <%
	        for(SysMenuInfo menu : menus){
	        	if(menu.getParentId() == 0){
	    %>
	       		<h3><a href="#"><%=menu.getName()%></a></h3>
	       		<div>
	               <ol class="sl-selectable">
	               <%
	               	for(SysMenuInfo m : menus){
	               		if(m.getParentId() == menu.getId()){
	               %>
	               		<li class = "ui-widget-content" link="<%=m.getUrl() %>" name="<%=m.getName()%>"><%=m.getName()%></li>
	               <%
	               		}
	               	}
	               %>
	                </ol>
	            </div>
	       	<%
	        	}
	       	 }
	    %>
        </div>
  </div>
  <div id="sl-content">
      <div id="sl-tabs">
		<ul><li></li></ul>
     </div>
  </div>
  <div id="sl-footer" class="ui-widget-header">
      <p>Release 20160323</p>
  </div>
</div>
  </body>
</html>