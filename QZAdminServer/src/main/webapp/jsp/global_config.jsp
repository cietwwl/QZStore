<%@page import="com.cache.GamePartnerCache"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="com.utils.TimeUtil"%>
<%@page import="com.web.db.game.GameServerInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
    <%
    	GameServerInfo info = (GameServerInfo)session.getAttribute("selserver");
    %>
    openTime=<%=TimeUtil.getTime(info.getStartTime())%>;
    hourtime = 60 * 60 * 1000;
    daytime = 24 * hourtime;
    tableWidth = 1010;  //表格宽 
    tableHeight = 690;   //表格高
    tableRp = 25;  //表格默认一页显示行数
    partnerKey = [];
    partnerVal = [];
    window.onload = function(){
	    var rat = <%=session.getAttribute("rat")%>
    	if(rat == 1){
    	    tableWidth = 785;  //表格宽 
    	    tableHeight = 420;   //表格高
    	    tableRp = 15;  //表格默认一页显示行数
    	    //loadStyle("css/admin/basic1.css?version=1.1");
    	}else if(rat == 2){
    	    tableWidth = 910;  //表格宽 
    	    tableHeight = 550;   //表格高
    	    tableRp = 20;  //表格默认一页显示行数
    	   // loadStyle("css/admin/basic.css?version=1.1");
    	}else{
    	    tableWidth = 1150;  //表格宽 
    	    tableHeight = 690;   //表格高
    	    tableRp = 25;  //表格默认一页显示行数
    	    //loadStyle("css/admin/basic2.css?version=1.1");
    	}
    	initPartner();
    }
    function loadStyle(url){
    	var link = document.createElement("link");
    	link.rel = "stylesheet";
    	link.type = "text/css";
    	link.href = url;
    	document.getElementsByTagName("head")[0].appendChild(link);
    }
	function flush(){
		window.location.reload();
	}
	function initPartner(){
		var i = 0;
		<%
    		Map<Integer, String> partnerMap = GamePartnerCache.getPartnerMap();
			for(Entry<Integer, String> entry : partnerMap.entrySet()){
				%>
					partnerKey[i] = <%=entry.getKey()%>;
					partnerVal[i] = '<%=entry.getValue()%>';
					i++;
				<%
			}
		%>
	}
</script>