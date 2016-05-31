<%@page import="com.web.obj.UserGroup"%>
<%@page import="com.game.constant.WebConstant"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="server_dialog" style="display:none;">
	<input type="text" id="sid" value="0" style="display:none;" />
	<table>
		<tr>
			<td align="right">服务器ID:</td>
			<td align="left"><input type="text" id="serverId"/></td>
			<td align="left">&nbsp;</td>
			<td align="right">区服编号:</td>
			<td align="left"><input type="text" id="serverNo"/></td>
		</tr>
		<tr>
			<td align="right">默认:</td>
			<td align="left">
				<input type="checkbox" id="defaultSelect" />
			</td>
			<td align="left">&nbsp;</td>
			<td align="right">推荐:</td>
			<td align="left">
				<select id="recommond">
					<option value="1">是 </option>
					<option value="0">否</option>
				</select>
			</td>
		</tr>
		<tr>
			<td align="right">类型:</td>
			<td align="left">
				<select id="type">
					<option value="0">测试服</option>
					<option value="1">正式服</option>
				</select>
			</td>
			<td align="left">&nbsp;</td>
			<td align="right">合服:</td>
			<td align="left">
				<select id="merge">
					<option value="0">否</option>
					<option value="1">是</option>
				</select>
			</td>
		</tr>
		<tr>
			<td align="right">服务器名称:</td>
			<td align="left"><input type="text" id="serverName"/></td>
			<td align="left">&nbsp;</td>
			<td align="right">开服时间:</td>
			<td align="left"><input type="text" id="startTime" onclick="changeOpenTime();"></td>
		</tr>
		<tr>
			<td align="right">描述:</td>
			<td align="left"><input type="text" id="desc"/></td>
			<td align="left">&nbsp;</td>
			<td align="right">状态:</td>
			<td align="left">
				<select id="status">
					<option value="-1">关闭</option>
					<option value="0">即将开区</option>
					<option value="1">维护</option>
					<option value="2">正常</option>
					<option value="3">推荐</option>
					<option value="4">火爆</option>
				</select>
			</td>
		</tr>
		<tr>
			<td align="right">维护时间:</td>
			<td align="left" colspan="6"><input type="text" id="maintainTime" style="width:360px" onclick="changeMaintainTime();"></td>
		</tr>
		<tr>
			<td align="right">维护显示信息 :</td>
			<td align="left" colspan="6"><input type="text" style="width:360px"  id="maintainMsg"/></td>
		</tr>
		<tr>
			<td align="right">登陆服IP:</td>
			<td align="left"><input type="text" id="ip"/></td>
			<td align="left">&nbsp;</td>
			<td align="right">登陆服端口:</td>
			<td align="left"><input type="text" id="port"/></td>
		</tr>
		<tr>
			<td align="right">中心服务器IP:</td>
			<td align="left"><input type="text" id="worldIp"/></td>
			<td align="left">&nbsp;</td>
			<td align="right">中心服务器端口:</td>
			<td align="left"><input type="text" id="worldPort"/></td>
		</tr>
		<tr>
			<td align="right" style="width:100px">游戏数据库地址:</td>
			<td align="left" colspan="6"><input style="width:360px" type="text" id="mainDBUrl"/></td>
		</tr>
		<tr>
			<td align="right">数据库用户名:</td>
			<td align="left"><input type="text" id="mainDBUsername"/></td>
			<td align="left">&nbsp;</td>
			<td align="right">数据库密码:</td>
			<td align="left"><input type="text" id="mainDBPassword"/></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td align="right">配置库地址:</td>
			<td align="left" colspan="6"><input style="width:360px" type="text" id="configDBUrl"/></td>
		</tr>
		<tr>
			<td align="right">配置库用户名:</td>
			<td align="left"><input type="text" id="configDBUsername"/></td>
			<td align="left">&nbsp;</td>
			<td align="right">配置库密码:</td>
			<td align="left"><input type="text" id="configDBPassword"/></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td align="right">后台接口:</td>
			<td align="left"><input type="text" id="adminUrl"/></td>
			<td align="left">&nbsp;</td>
			<td align="right">后台校验码:</td>
			<td align="left"><input type="text" id="adminCheck"/></td>
		</tr>
		<tr>
			<td align="right">充值请求地址:</td>
			<td align="left" colspan="6"><input style="width:360px" type="text" id="rechargeUrl"/></td>
		</tr>
	</table>
</div>
<div id="search_div" style="display:table;">
	<span>
		<input id="add_button" style="margin-top:-5px;margin-right:5px;text-align: center;" class="button orange small" type="button" value="添加服务器" onclick="showServerInfoDialog(0);"/>
		<input id="refresh_button" style="margin-top:-5px;margin-left:5px;margin-right:5px; text-align: center;" class="button white little" type="button" value="刷新区服列表" onclick="flushServers();"/>
		搜索：
		<select id="searchType" style="margin-left:5px;margin-top:-5px;text-align: center;padding:2px;">
			<option value="1">服务器ID</option>
			<option value="2">服务器名称</option>
		</select>
		<input type="text" id="searchValue" style="margin-left:5px;margin-top:-5px;">
		<input style="margin-left:5px;margin-top:-5px;text-align: center;" class="button orange small" type="button" value="查询" onclick="searchServer();"/>
	</span>
</div>
<table id="server_table"></table>
<div id="game_tip" style="display:none;"></div>
<div id="server_refresh" style="display: none;"><table id="refresh_table"></table></div>
<script type="text/javascript">
<%
UserGroup userGroup = (UserGroup)session.getAttribute("userGroup");
%>
var jurAddServer = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_ADD_SERVER)%>;
var jurDelServer = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_DELETE_SERVER)%>;
var jurModServer = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_MODIFY_SERVER)%>;
var jurStoServer = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_STOP_SERVER)%>;
var jurLoadCache = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_LOAD_GAME_CACHE)%>;
var jurRefServers = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_REFRESH_WEB_CACHE)%>;
var datas;
var pdatas;
function dispose(){
	$("#search_div").remove();
	$("#server_dialog").remove();
	$("#server_table").remove();
	$("#server_refresh").remove();
	$("#game_tip").remove();
	datas = null;
	pdatas = null;
}
function ready(){
	if(!jurAddServer){
		$("#add_button").hide();
	}
	if(!jurRefServers){
		$("#refresh_button").hide();
	}
	var showSel = jurAddServer || jurDelServer || jurModServer || jurStoServer || jurLoadCache
	$("#server_table").flexigrid({
		url : 'game_server_mgr/get_game_server_list.jsp',
   	    dataType : 'json',
   		preProcess : function(data){
   			datas = data;
	    	return data;
	    },
   	 	colModel : [{display : '服务器ID',
	        name : 'serverId',
	        width : 60,
	        align : 'center'
		},{display : '服务器名称',
	        name : 'serverName',
	        width : 80,
	        align : 'center'
		},{display : '类型',
	        name : 'type',
	        width : 50,
	        align : 'center',
	        customValue : function(i, idx, value){
	        	if(value >= 1){
	        		return "正式";
	        	}
	        	return "测试";
	        }
		},{display : '开服时间',
			name : 'startTime',
	        width : 120,
	        align : 'center',
	        hide : true,
		},{display : '推荐',
			name : 'recommend',
			width : 30,
			align : 'center',
			customValue : whether
		},{display : '合服',
			name : 'merge',
	        width : 30,
	        align : 'center',
	        customValue : whether
		},{display : '默认',
			name : 'defaultSelect',
	        width : 40,
	        align : 'center',
	        customValue:function(row, col, val){
	        	if(val == "true"){
	        		return "是";
	        	}else{
	        		return "否";
	        	}
	        }
		},{display : '后台状态',
			name : 'state',
			width : 60,
			align : 'center',
			customValue : function(row, col, val){
				if(val == 0){
					return "<img src='css/images/ban.png' style='cursor:pointer;float:left;' onmouseover='showFlushTip(event, true)' onmouseout='showFlushTip(event, false)' onclick='flushState(" + row +")'>不可用";
				}else{
					return "<img src='css/images/accept.png' style='cursor:pointer;float:left;' onmouseover='showFlushTip(event, true)' onmouseout='showFlushTip(event, false)' onclick='flushState(" + row +")'>可用";
				}
			}
		},{display : '操作',
			name : 'id',
	        width : 150,
	        align : 'center',
	        customValue : getHandleServerLink
		},{display : '数据库地址',
			name : 'mainDBUrl',
	        width : 200,
	        align : 'center',
	        hide : true
		},{display : '数据库用户名',
			name : 'mainDBUsername',
	        width : 70,
	        align : 'center',
	        hide : true
		},{display : '数据库密码',
			name : 'mainDBPassword',
	        width : 60,
	        align : 'center',
	        hide : true
		},{display : '配置库地址',
			name : 'configDBUrl',
	        width : 200,
	        align : 'center',
	        hide : true
		},{display : '配置库用户名',
			name : 'configDBUsername',
	        width : 70,
	        align : 'center',
	        hide : true
		},{display : '配置库密码',
			name : 'configDBPassword',
	        width : 60,
	        align : 'center',
	        hide : true
		},{display : '后台地址',
			name : 'adminUrl',
	        width : 160,
	        align : 'center'
		},{display : '后台检验码',
			name : 'adminCheck',
	        width : 80,
	        align : 'center',
	        hide : true
		}, {display : '充值地址',
			name : 'rechargeUrl',
			width : 160, 
			align : 'center'
		}], 
		usepager : true,
	    title : '游戏服务器列表',
	    useRp : false,
	    rp : tableRp,
	    width : tableWidth,
	    height : tableHeight,
	    page: 1,
	    total: 1,
	    resizable: false,
	    autoload: false,
	    procmsg:'加载中，請稍後…',
	    singleSelect:true,
   	 	showToggleBtn : showSel,
 		onSuccess : function(obj){
	 		showError(datas);
	    }
	});
	$("#refresh_table").flexigrid({
		 url : 'game_server_mgr/get_web_refresh_list.jsp',
		 dataType : 'json',
		 newp:1,
		 hide:true,
		 preProcess : function(data){
	    	pdatas = data;
	    	return data;
	    },
	 	colModel : [{display : '名称',
	        name : 'name',
	        width : 100,
	        align : 'center'
		},{display : '刷新地址',
			name : 'refUrl',
	        width : 350,
	        align : 'center',
	        customValue : function(i, idx, value){
	        	return "<span style='float:left;'>" + value + "<span>"
	        }
		},{display : '操作',
			name : 'id',
	        width : 100,
	        align : 'center',
	        customValue:function(i, idx, value){
	        	var val = "";
	        	if(jurRefPartner){
	        		val += "<a href='javascript:refresh(" + i + ");'>刷新</a>";
	        	}
	        	return val;
	        }
		}],
 		title : '服务器刷新（配置->Web管理）',
 		resizable: false,
 	    usepager : true,
 	    useRp : false,
 	    rp : 15,
 	    width : 580,
 	    height : 420,
 	    page: 1,
 	    total: 1,
 	    procmsg:'加载中，請稍後…',
 	    singleSelect:true,
 	 	autoload:false
	});
	searchServer();
}

function searchServer(){
	$("#server_table").flexOptions({
		params : [{name:'searchType', value:$("#searchType").val()},
		          {name:'searchValue', value:$("#searchValue").val()},
		         ],
		newp : 1
	});
	$("#server_table").flexReload();
}
function showServerInfoDialog(sid){
	if(sid != 0){
		var server = getServer(sid);
		title = "修改服务器";
		$("#sid").val(server.id);
		$("#serverId").val(server.serverId);
		$("#serverNo").val(server.serverNo);
		$("#type").val(server.type);
		if(server.defaultSelect){
			$("#defaultSelect").attr("checked", true);
		}else{
			$("#defaultSelect").attr("checked", false);
		}
		$("#serverName").val(server.serverName);
		$("#merge").val(server.merge);
		$("#mainDBUrl").val(server.mainDBUrl);
		$("#mainDBUsername").val(server.mainDBUsername);
		$("#mainDBPassword").val(server.mainDBPassword);
		$("#configDBUrl").val(server.configDBUrl);
		$("#configDBUsername").val(server.configDBUsername);
		$("#configDBPassword").val(server.configDBPassword);
		$("#adminUrl").val(server.adminUrl);
		$("#adminCheck").val(server.adminCheck);
		$("#recommond").val(server.recommond);
		$("#status").val(server.statue);
		$("#maintainMsg").val(server.maintainMsg);
		$("#ip").val(server.ip);
		$("#port").val(server.port);
		$("#worldIp").val(server.worldIp);
		$("#worldPort").val(server.worldPort);
		$("#desc").val(server.desc);
		$("#startTime").val(server.startTime);
		$("#rechargeUrl").val(server.rechargeUrl);
		if(server.maintainStartTime && server.maintainEndTime){
			$("#maintainTime").val(server.maintainStartTime + "--" + server.maintainEndTime);
		}else{
			$("#maintainTime").val('');
		}
	}else{
		var title = "添加服务器";
		$("#sid").val(0);
		$("#serverId").val('');
		$("#serverNo").val('');
		$("#serverName").val('');
		$("#merge").val('');
		$("#mainDBUrl").val('');
		$("#mainDBUsername").val('');
		$("#mainDBPassword").val('');
		$("#configDBUrl").val('');
		$("#configDBUsername").val('');
		$("#configDBPassword").val('');
		$("#adminUrl").val('');
		$("#adminCheck").val('');
		$("#recommond").val(1);
		$("#status").val(0);
		$("#maintainMsg").val('');
		$("#ip").val('');
		$("#port").val('');
		$("#worldIp").val('');
		$("#worldPort").val('');
		$("#desc").val('');
		$("#startTime").val(formatTime(new Date()));
		$("#maintainTime").val('');
		$("#rechargeUrl").val('');
	}
	$("#server_dialog").dialog({
		title : title,
		width:500,
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		buttons:{
			"取消" : function(){
				$(this).dialog("close");
			},
			"确定" : submitServer
		}
	});
}
function submitServer(){
	var data = {};
	var id = $("#sid").val();
	var url = 'game_server_mgr/url_server_add.jsp';
	var successTip = "添加服务器成功";
	if(id != 0){
		url = 'game_server_mgr/url_server_modify.jsp';
		successTip = "修改服务器成功";
		data.id = id;
	}
	data.serverId = $.trim($("#serverId").val());
	data.serverNo = $.trim($("#serverNo").val());
	data.type = $("#type").val();
	if($("#defaultSelect").attr("checked")){
		data.defaultSelect = true;
	}else{
		data.defaultSelect = false;
	}
	data.serverName = $.trim($("#serverName").val());
	data.merge = $("#merge").val();
	data.mainDBUrl = $.trim($("#mainDBUrl").val());
	data.mainDBUsername = $.trim($("#mainDBUsername").val());
	data.mainDBPassword = $.trim($("#mainDBPassword").val());
	data.configDBUrl = $.trim($("#configDBUrl").val());
	data.configDBUsername = $.trim($("#configDBUsername").val());
	data.configDBPassword = $.trim($("#configDBPassword").val());
	data.adminUrl = $.trim($("#adminUrl").val());
	data.adminCheck = $.trim( $("#adminCheck").val());
	data.startTime = $.trim($("#startTime").val());
	data.recommond = $("#recommond").val();
	data.status = $("#status").val();
	data.maintainTime = $.trim($("#maintainTime").val());
	data.maintainMsg = $("#maintainMsg").val();
	data.ip = $("#ip").val();
	data.port = $("#port").val();
	data.worldIp = $("#worldIp").val();
	data.worldPort = $("#worldPort").val();
	data.desc = $("#desc").val();
	data.rechargeUrl = $("#rechargeUrl").val();
	if(data.serverId.length == 0){
		alert("服务器ID不能为空");
		return ;
	}else if(data.serverName.length == 0){
		alert("服务器名称不能为空");
		return ;
	}else if(data.mainDBUrl.length == 0){
		alert("数据库地址不能为空");
		return ;
	}else if(data.mainDBUsername.length == 0){
		alert("数据库用户名不能为空");
		return ;
	}else if(data.configDBUrl.length == 0){
		alert("配置库地址不能为空");
		return ;
	}else if(data.configDBUsername.length == 0){
		alert("配置库用户名不能为空");
		return ;
	}else if(data.adminUrl.length == 0){
		alert("后台接口不能为空");
		return ;
	}else if(data.adminCheck.length == 0){
		alert("后台接口不能为空");
		return ;
	}else if(data.startTime.length == 0){
		alert("开服时间不能为空");
		return;
	}else if(data.rechargeUrl.length == 0){
		alert("充值请求地址不能为空");
		return;
	}
	$.ajax({
		 url : url,
		 dataType : 'json',
		 data : data,
		 cache : false,
		 type:"post",
		 success:function(response){
			 if(!showError(response)){
				 $("#server_dialog").dialog("close");
				 alert(successTip);
				 $("#server_table").flexReload();
			 }
		 }
	});
}
function getHandleServerLink(i, idx, sid){
	var val = "";
	if(jurDelServer){
		val += "<a href='javascript:showDeleteServerTip(" + sid + ")' style='margin-right:5px;'>删除</a>";
	}
	if(jurModServer){
		val += "<a href='javascript:showServerInfoDialog(" + sid + ")' style='margin-right:5px;'>修改</a>";
	}
	if(jurStoServer){
		val += "<a href='javascript:showStopServerTip(" + sid + ")' style='margin-right:5px;'>停服</a>";
	}
	if(jurLoadCache){
		val += "<a href='javascript:showloadGameCacheTip(" + sid + ")'>重载缓存</a>";;
	}
	return val;
}
function showDeleteServerTip(sid){
	var server = getServer(sid);
	if(server != null){
		var htmlText = "您确定要删除服务器[" + server.serverId + "](" + server.serverName + ")吗?";
		$("#game_tip").html(htmlText);
		$("#game_tip").dialog({
			title:'删除服务器',
			resizable:false,
			modal:true,
			autoOpen:true,
			draggable:true,
			buttons:{
				"取消" : function(){
					$(this).dialog("close");
				},
				"确定" : function(){
					deleteServer(server.id);
				}
			}
		});
	}
}
function getServer(sid){
	for(i = 0; i < datas.rows.length; i++){
		if(datas.rows[i].id == sid){
			return datas.rows[i];
		}
	}
}
function deleteServer(sid){
	var data = {};
	data.id = sid;
	$.ajax({
		 url : 'game_server_mgr/url_server_delete.jsp',
		 dataType : 'json',
		 data : data,
		 cache : false,
		 type:"post",
		 success:function(response){
			 if(!showError(response)){
				 var options = document.getElementById("gameServer").options;
				 for(var i = 0; i < options.length; i++){
					 if(response.did == options[i].value){
						 options.remove(i);
						 break;
					 }
				 }
				 $("#game_tip").dialog("close");
				 alert("删除服务器成功!");
				 $("#server_table").flexReload();
			 }
		 }
	});
}
function showloadGameCacheTip(sid){
	var server = getServer(sid);
	if(server != null){
		var htmlText = "您确定要重新加载[" + server.serverName + "]的游戏缓存吗?";
		$("#game_tip").html(htmlText);
		$("#game_tip").dialog({
			title:'重新加载游戏缓存',
			resizable:false,
			modal:true,
			autoOpen:true,
			draggable:true,
			buttons:{
				"取消" : function(){
					$(this).dialog("close");
				},
				"确定" : function(){
					loadGameCache(server.id);
					$(this).dialog("close");
				}
			}
		});
	}
}
function loadGameCache(sid){
	var data = {};
	data.id = sid;
	$.ajax({
		 url : 'game_server_mgr/url_game_cache_load.jsp',
		 dataType : 'json',
		 data : data,
		 cache : false,
		 type:"post",
		 success:function(response){
			 if(!showError(response)){
				alert(response.tip);
			 }
		 }
	});
}
function changeOpenTime(){
	var timeId = "openDate";
	timeOddDialog("game_tip", "开服时间设置", "开服时间", timeId, "startTime");
	pickerDate(timeId, new Date());
}
function changeMaintainTime(){
	var startId = "startDate";
	var endId = "endDate";
	timeDialog("game_tip", "服务器维护时间设置", startId, endId, "maintainTime");
	pickerMinDate(startId, getNextDate(0 * 24 * 60 * 60 * 1000));
	pickerMinDate(endId, getNextDate(0 * 24 * 60 * 60 * 1000));
}
function showStopServerTip(sid){
	var server = getServer(sid);
	if(server != null){
		var htmlText = "您确定要关闭[ " + server.serverName + " ]吗?";
		$("#game_tip").html(htmlText);
		$("#game_tip").dialog({
			title:'关闭游戏区服',
			resizable:false,
			modal:true,
			autoOpen:true,
			draggable:true,
			buttons:{
				"取消" : function(){
					$(this).dialog("close");
				},
				"确定" : function(){
					stopServer(server.id);
					$(this).dialog("close");
				}
			}
		});
	}
}
function stopServer(sid){
	var data = {};
	data.id = sid;
	$.ajax({
		 url : 'game_server_mgr/url_server_stop.jsp',
		 dataType : 'json',
		 data : data,
		 cache : false,
		 type:"post",
		 success:function(response){
			 if(!showError(response)){
				var server = response.server;
				if(server != null){
					for(i = 0; i < datas.rows.length; i++){
						if(datas.rows[i].serverId == server.serverId){
							datas.rows[i] = server;
							break;
						}
					}
					$("#server_table").flexAddData(datas);
				}
			 }
		 }
	});
}
function showFlushTip(event, show){
	tip = $("#flush_tip");
	if(show){
		tip.html("点击刷新");
		tip.css("position", "fixed");
		tip.css("left", event.clientX + 2);
		tip.css("top", event.clientY - 20);
		tip.show();
	}else{
		tip.hide();
	}
}
function flushState(row){
	d = $("#game_tip");
	var ser = datas.rows[row];
	d.html("是否确定刷新[ " + ser.serverName + " ]状态！！！");
	d.dialog({
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		title:"刷新服务器状态",
		buttons:{
			"取消":function(){
				$(this).dialog("close");
			},
			"确定":function(){
				var serverId = ser.serverId;
				$.ajax({url:"game_server_mgr/url_server_flush_state.jsp",
					data:{serverId:serverId},
					type:"post",
					dataType:"json",
					cache:false,
					success:function(response){
						$("#game_tip").dialog("close");
						if(!showError(response)){
							var server = response.server;
							if(server != null){
								for(i = 0; i < datas.rows.length; i++){
									if(datas.rows[i].serverId == server.serverId){
										datas.rows[i] = server;
										break;
									}
								}
								$("#server_table").flexAddData(datas);
							}
						}
					}
				});
			}
		}
	});
}
function flushServers(){
	$("#server_refresh").dialog({
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		width : 610,
		height : 650,  //使用auto会导致长列表第一次打开出现问题
		title:"刷新区服"
	});
	$("#refresh_table").flexOptions({
		 params : [{name:'type', value:1}],
		 newp:1,
		 hide:false
	});
	$("#refresh_table").flexReload();
}

function refresh(i){
	var row = pdatas.rows[i];
	d = $("#game_tip");
	d.html("<br><b>是否确定刷新 [ <span style='color:red;'>" + row.name + "</span> ] ！！！</b>");
	d.dialog({
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		title:"刷新区服",
		buttons:{
			"取消":function(){
				$(this).dialog("close");
			},
			"确定":function(){
				$.ajax({url:"game_server_mgr/url_web_refresh.jsp",
					data:{furl : row.refUrl},
					type:"post",
					dataType:"json",
					cache:false,
					success:function(response){
						$("#game_tip").dialog("close");
						if(!showError(response)){
							alert("刷新成功！");
						}
					}
				});
			}
		}
	});
}


</script>