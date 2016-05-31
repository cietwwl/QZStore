<%@page import="com.cache.GameServerCache"%>
<%@page import="com.web.db.game.GameServerInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,com.web.db.bean.*" pageEncoding="UTF-8"%>
<div id="server_select_div" style="display:none;">
	<table>
		<tr>
			<td style="text-align:left;padding:3px;">
				<input type="checkbox" id="allServerSel" style="float:left;margin-top:2px;margin-right:2px;" onchange="selAllServer();"/>
				<span style="float:left;">全选</span>
			</td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<%
			List<GameServerInfo> servers = GameServerCache.getGameServers();
			for(int index = 0; index < servers.size();){
				if(index % 5 == 0){
					int cols = 0;
		%>
		<tr>
		<%
					while(cols < 5){
						if(servers.size() > index){
							GameServerInfo server = servers.get(index);
		%>
			<td style="text-align:left;vertical-align: middle;padding:3px;width:100px;">
				<input type="checkbox" name="server" value="<%=server.getId()%>" sname="<%=server.getServerName()%>" style="float:left;margin-top:2px;margin-right:2px;"/>
				<% String val = server.getServerName();
				   if(val.getBytes("gbk").length > 12){
				   		String nval = "";
				   		for(int i = 0; i < val.length(); i++){
				   			String va = val.substring(i, i + 1);
				   			if(nval.getBytes("gbk").length + va.getBytes("gbk").length <= 12){
				   				nval += va;
				   			}else{
				   				break;
				   			}
				   		}
				   		val = nval;
				   }%>
				<span style="float:left;"><%=val%></span>
			</td>
		<%
						}else{
		%>
			<td></td>
		<%
						}
						index++;
						cols++;
					}
		%>
		</tr>
		<%
				}
			}
		%>
	</table>
</div>
<div id="notice_div">
	<table style="width:800px;line-height:20px;">
		<tr>
	 		<td style="height:20px;width:200px;text-align:right;">服务器:</td>
	 		<td>
				<%
					GameServerInfo server = (GameServerInfo)session.getAttribute("selserver");
				%>
				<div id="send_server_div" style="width:300px;float:left;padding:5px;">
					<input type="text" id="selservers" value="<%=server.getId()%>" style="display:none;" />
					<span id="selservername">
					<%=server.getServerName() %>
					</span>
				</div>
				<input type="button" onclick="addServer();" value="选择"/>
			</td>
	 	</tr>
	 	<tr>
			<td style="height:20px;width:200px;text-align:right;">间隔(秒):</td>
			<td>
				<input type="text" id="secondNum" width="100" value="30"/>
			</td>
		</tr>
		<tr>
			<td style="height:20px;width:200px;text-align:right;">次数:</td>
			<td>
				<input type="text" id="sendNum" width="100" value="10"/>
			</td>
		</tr>
		<tr>
			<td style="height:20px;width:200px;text-align:right;">颜色:</td>
			<td>
				<select id="colorId" >
					<option value="1">白色</option>
					<option value="2">绿色</option>
					<option value="3">蓝色</option>
					<option value="4">紫色</option>
					<option value="5">橙色</option>
					<option value="6" selected="selected">金色</option>
				</select>
			</td>
		</tr>
	 	<tr>
			<td style="height:20px;width:200px;text-align:right;">内容:</td>
			<td>
				<textarea style="resize:none" id="content" rows="5" cols="80" ></textarea>
			</td>
		</tr>
		<tr>
			<td style="height:20px;width:300px;text-align:right;"></td>
			<td style="text-align:center;">
				<input type="button" value="发送" onclick="publishNotice();"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="重置" onclick="resetNotice()"/>
			</td>
		</tr>
	</table>
</div>
<script type="text/javascript">
function dispose(){
	$("#server_select_div").remove();
	$("#content").remove();
	$("#colorId").remove();
	$("#secondNum").remove();
	$("#sendNum").remove();
}
function addServer(){
	servers = $("#selservers").val().trim();
	serverids = servers.split(";");
	$("input[name=server]").each(function(index, obj){
		$(obj).attr("checked", false);
		for(i = 0; i < serverids.length; i++){
			if(serverids[i] == $(obj).val()){
				$(obj).attr("checked", true);
				break;
			}
		}
	});
	$("#server_select_div").dialog({
		title:'选择服务器',
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		width:500,
		buttons:{
			"取消":function(){
				$(this).dialog("close");
			},
			"确定":function(){
				ids = "";
				snames = "";
				$("input[name=server]:checked").each(function(index, obj){
					ids += $(obj).val() + ";";
					snames += $(obj).attr("sname") + ";";
				});
				if(ids.length > 0){
					ids = ids.substring(0, ids.length - 1);
				}
				if(snames.length > 0){
					snames = snames.substring(0, snames.length - 1);
				}
				$("#selservers").val(ids);
				$("#selservername").html(snames);
				$(this).dialog("close");
			}
		}
	});
}
function selAllServer(){
	selAll = false;
	if($("#allServerSel").attr("checked"))
		selAll = true;
	$("input[name=server]").each(function(index, obj){
		$(obj).attr("checked", selAll);
	});
}
function resetNotice(){
	$("#content").val("");
	$("#colorId").val(6);
	$("#secondNum").val(30);
	$("#sendNum").val(10);
}
function publishNotice(){
	var servers = $("#selservers").val();
	var content = $("#content").val();
	var colorId = $("#colorId").val();
	var secondNum = $("#secondNum").val();
	var sendNum = $("#sendNum").val();
	if(servers.length == 0 || content.length == 0){
		alert("服务器和内容不能为空!");
		return;
	}
	if(secondNum < 30){
		alert("发送间隔不能小于30秒!");
		return;
	}
	if(content.length > 100){
		alert("发送内容不能超过100个字");
		return;
	}
	$.ajax({url:"game_operate_mgr/url_notice_send.jsp",
			data:{servers:servers,
				content:content,
				colorId:colorId,
				secondNum:secondNum,
				sendNum:sendNum},
			type:"post",
			dataType:"json",
			cache:false,
			success:function(response){
				if(response.code == 0){
					alert("发送成功!");
				}
				showError(response);
			}
	});
}
</script>