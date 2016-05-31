<%@page import="com.cache.GameServerCache"%>
<%@page import="com.game.constant.WebConstant"%>
<%@page import="com.web.obj.UserGroup"%>
<%@page import="com.web.db.game.GameServerInfo"%>
<%@page import="com.ks.constant.SystemConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="server_select_div" style="display:none;">
	<table>
		<tr>
			<td style="text-align:left;padding:1px;">
				<input type="checkbox" id="allServerSel" style="float:left;margin-top:2px;margin-right:2px;" onclick="selAllServer();"/>
				<span style="float:left;">全选</span>
			</td>
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
			<td style="text-align:left;vertical-align: middle;padding:1px;width:100px;">
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
			<td style="width:80px;"></td>
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
<div id="confirm_send_div" style="display:none;"></div>
<div id="items_select_div" style="display:none;">
	<div style="height:20px;padding:5px;">
		<span style="float:left;">
			物品类型:
			<select id="itemType" onchange="addItemDialog();">
				<option value="<%=SystemConstant.ITEM_TYPE_CURRENCY%>">货币</option>
			<%
				for(int index=0; index < SystemConstant.ITEM_EFFECT_TYPES.length; index++){
			%>
					<option value="<%=SystemConstant.ITEM_EFFECT_TYPES[index]%>"><%=SystemConstant.ITEM_EFFECTS_TYPE_NAMES[index]%></option>
			<%
				}
			%>
			</select>
		</span>
		<span style="float:left;margin-left:5px;">
			<select id="searchType">
				<option value="1">物品名称</option>
				<option value="2">物品ID</option>
			</select>
		</span>
		<span style="float:left;margin-left:5px;margin-top:-3px;">
			<input type="text" id="searchValue"/>
		</span>
		<input style="float:left;margin-left:5px;margin-top:-5px;" type="button" value="查询" onclick="searchItem();"/>
	</div>
	<% 
		for(int gtype : SystemConstant.ITEM_EFFECT_TYPES){
	%>
		<table id="allItems<%=gtype %>" itemType="<%=gtype %>"></table>
	<%
		}
	%>
	<table id="allItems<%=SystemConstant.ITEM_TYPE_CURRENCY %>" itemType="<%=SystemConstant.ITEM_TYPE_CURRENCY %>"></table>
</div>
<div id="mail_div">
	<table style="width:750px;line-height:10px;">
	 	<tr>
	 		<td align="right"><input style="width:60px;text-align:center;color: red;" type="button" onclick="addServer();" value=" 服务器: "/></td>
			<td align="left">
				<%
					GameServerInfo server = (GameServerInfo)session.getAttribute("selserver");
				%>
				<div id="send_server_div" style="width:600px;float:left;padding:5px;">
					<input type="text" id="selservers" value="<%=server.getId()%>" style="display:none;" />
					<span id="selservername">
					<%=server.getServerName() %>
					</span>
				</div>
			</td>
	 	</tr>
	 	<tr>
	 		<td style="height:20px;width:200px;text-align:right;" align="right"><b style="margin-left:5px;margin-top:-5px;">渠道:</b></td>
			<td align="left">
	 		<%@include file="/jsp/select_partner.jsp" %><b style="margin-left:5px;margin-top:-5px;">类型:</b>
			<select id="sendType" onchange="selectType();" style="padding: 2px;">
				<option value="1" selected="selected">指定玩家</option>
				<option value="3">指定时间段(注册/登录)</option>
				<option value="4">当前注册</option>
				<option value="5">长期全服</option>
			</select>
	 		<b style="margin-left:5px;margin-top:-5px;">时间：</b>
	 		<input id="selTime" style="width:260px" disabled="disabled" onclick="changeTime();"/>
			</td>
	 	</tr>
		<tr>
			<td align="right"><input id="addPlayer" style="width:60px;text-align:center;" type="button" onclick="resetPlayers(1);" value="玩家账号:"></td>
			<td align="left"><input type="text" id="openids" style="width:640px;" onclick="addPlayers();"></td>
		</tr>
		<tr>
			<td align="right"><input id="resetPlayer" style="width:60px;text-align:center;" type="button" onclick="resetPlayers(2);" value="玩家昵称:"/></td>
			<td align="left"><input type="text" id="nicknames" style="width:640px;" onclick="addPlayers();"></td>
		</tr>
		<tr>
			<td style="height:20px;width:200px;text-align:right;"><b style="margin-left:5px;margin-top:-5px;">标题:</b></td>
			<td><input type="text" id="mailTitle" style="width:500px;"/></td>
		</tr>
		<tr>
			<td style="height:20px;width:200px;text-align:right;"><b style="margin-left:5px;margin-top:-5px;">邮件内容:</b></td>
			<td>
				<textarea id="mailContent" cols="109" rows="3" style="resize:none;margin:0px;"></textarea>
			</td>
		</tr>
		<tr>
			<td style="height:20px;width:200px;text-align:right;"><b style="margin-left:5px;margin-top:-5px;">物品:</b></td>
			<td>
				<table id="senditems" style="display:none"></table>
			</td>
		</tr>
		<tr>
			<td style="height:20px;width:300px;text-align:right;"></td>
			<td style="text-align:center;">
				<span id="submit_apply">
				<input class="button orange small" type="button" value="申请" onclick="checkSendMail();"/>
				<input class="button orange small" type="button" value="重置" onclick="reset();" style="margin-left: 50px;margin-top: 20px;">
				</span>
			</td>
		</tr>
	</table>   
</div>
<div id="mail_tip_div" style="display:none;"></div>
<script type="text/javascript">
<%
UserGroup userGroup = (UserGroup)session.getAttribute("userGroup");
%>
var jurAppMail = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_SUBMIT_MAIL_APPLY)%>;
var colModelObject = {
		'colModel1' : [ 
		    {display:'选择',name : 'heroId',width:40,align : 'center',customValue:getAllItemCheckBox},
		    {display : '英雄ID',name : 'heroId',width : 80,align : 'center'},
		    {display : '名称',name : 'name',width : 120,align : 'left'},
		    {display : '星级',name : 'quality',width : 60,align : 'center',customValue:getStarName},
		    {display : '最高等级',name : 'maxLevel',width : 60,align : 'center'}
		 ],
		 'colModel4' : [ 
	    	{display:'选择',name : 'propId',width:40,align : 'center',customValue:getAllItemCheckBox},
		    {display : '道具ID',name : 'propId',width : 80,align : 'center'},
		    {display : '名称',name : 'name',width : 120,align : 'left'}
	     ],
		 'colModel6' : [ 
			{display:'选择',name : 'equipmentId',width:40,align : 'center',customValue:getAllItemCheckBox},
	    	{display : '装备ID',name : 'equipmentId',width : 80,align : 'center'},
		    {display : '名称',name : 'name',width : 120,align : 'left'},
		    {display : '部位',name : 'type',width : 60,align : 'center',customValue:getPartName},
		    {display : '星级',name : 'quality',width : 60,align : 'center',customValue:getStarName}
	     ],
		 'colModel7' : [ 
	    	{display:'选择',name : 'eternalId',width:40,align : 'center',customValue:getAllItemCheckBox},
	    	{display : '名称',name : 'name',width : 120,align : 'left'},
		    {display : '星级',name : 'quality',width : 60,align : 'center',customValue:getStarName}
	     ],
		 'colModel1001' : [ 
	        {display:'选择',name : 'id',width:40,align : 'center',customValue:getAllItemCheckBox},
	        {display : '名称',name : 'name',width : 540,align : 'center'}
	     ]
	};
var itemdatas;
var selitems=[];
function dispose(){
	$("#mail_div").remove();
	$("#items_select_div").remove();
	$("#confirm_send_div").remove();
	$("#server_select_div").remove();
	$("#mail_tip_div").remove();
	colModelObject = null;
	datas = null;
	selitems = null;
}
function ready(){
	if(!jurAppMail){
		$("#submit_apply").hide();
	}
	$("#senditems").flexigrid({
		 dataType : 'json',
		 getRowColor:function(row){
			 if(row){
 	    		return getQualityColor(row.quality);
			 }
 	     },
		 colModel : [ {display : '物品ID',
    	        name : 'id',
    	        width : 80,
    	        sortable : true,
    	        align : 'center'
	   		},{display : '名称',
	   			name : 'name',
 	       		width : 100,
 	        	align : 'center'
	   		},{display : '物品类型',
	   			name : 'itemType',
 	       		width : 60,
 	        	align : 'center',
 	        	customValue:function getValue(id, idx, value){
 	        		return getGoodsTypeName(value);
 	        	}
	   		},{display : '等级',
	   			name : 'level',
 	       		width : 100,
 	        	align : 'center',
 	        	customValue:getItemLevelInput
	   		},{display : '数量',
	   			name : 'id',
 	       		width : 100,
 	        	align : 'center',
 	        	customValue:getItemNumberInput
	   		},{display : '操作',
	   			name : 'id',
 	       		width : 50,
 	        	sortable : true,
 	        	align : 'center',
 	        	customValue:getItemDelete
	   		}],
	   		buttons : [
	   				{name: '添加', bclass: 'add', onpress : searchItemDialog}
	   				],
	   		title : '待发送物品',
	   		resizable: false,
    	    autoload: false,
    	    width:650
	});
	$('table[id^="allItems"]').each(function(index, obj){
		var itemType = $(obj).attr("itemType");
		$(obj).flexigrid({
			 url : 'game_operate_mgr/get_item_list.jsp',
			 dataType : 'json',
			 newp:1,
			 hide:true,
			 preProcess : function(data){
	 	    	itemdatas = data;
	 	    	return data;
	 	    },
		 	getRowColor:function(row){
	   	    	return getQualityColor(row.quality);
	   	    },
		 	colModel : colModelObject["colModel" + itemType],
	   		title : '物品列表',
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
	});
}
function searchItemDialog(){
	d = $('#mail_tip_div');
	d.attr("title", "查询道具");
	d.html("<table><tr><td>是否确认搜索[<td/><td><%GameServerInfo server1 = (GameServerInfo)session.getAttribute("selserver");%><%=server1.getServerName()%></td><td>]配置裤?<td/><tr/>");
	d.dialog({
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		title:d.attr("title"),
		buttons:{
			"取消":function(){
				$(this).dialog("close");
			},
			"确定":function(){
				addItemDialog();
				$(this).dialog("close");
			}
		}
	});
}

function addItemDialog(){
	$("#items_select_div").dialog({
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		title:"物品列表",
		width : 610,
		height : 650,  //使用auto会导致长列表第一次打开出现问题
		buttons:{
			"取消":function(){
				$(this).dialog("close");
			},
			"确定":function(){
				$("input[name='allitemcheckbox']:checked").each(function(i){
					id = $(this).val();
					for(i = 0; i < itemdatas.rows.length; i++){
						if(itemdatas.rows[i].id == id){
							selitem = itemdatas.rows[i];
							selitems[selitems.length]=selitem;
							selitem.namount = 1;
							selitem.nlevel = 1;
							break;
						}
					}
				});
				data = {rows: selitems, page: 0, total: selitems.length};
				$("#senditems").flexAddData(data);
				$(this).dialog("close");
			}
		},
	});
	searchItem();
}

function getAllItemCheckBox(i, idx, itemId, name){
	return "<input type='checkbox' name='allitemcheckbox' value='" + itemId + "'/>";
}
function getItemNumberInput(i, idx, itemId){
	return "<input type='text' style='width:60px;padding:0px' id='itemAmount" + itemId + "' value='" + selitems[i].namount + "' onchange='changeItemAmount(" + i + ", this.value);'/>";
}
function getItemLevelInput(i, idx, level){
	if(level != "undefined"){
		return "<input type='text' style='width:60px;padding:0px' id='itemLevel" + level + "' value='" + selitems[i].nlevel + "' onchange='changeItemLevel(" + i + ", this.value);'/>";
	}
	return "...";
}
function changeItemAmount(i, value){
	selitems[i].namount = value;
}
function changeItemLevel(i, value){
	selitems[i].nlevel = value;
}
function getItemDelete(i, idx, itemId){
	return "<a href='javascript:deleteItem(" + itemId + ")' >删除</a>";
}
function deleteItem(itemId){
	for(i = 0; i < selitems.length; i++){
		if(selitems[i].id == itemId){
			selitems.splice(i,1);
			break;
		}
	}
	data = {rows: selitems, page: 0, total: selitems.length};
	$("#senditems").flexAddData(data);
}
function checkSendMail(){
	var openids = $("#openids").val();
	var nicknames = $("#nicknames").val();
	var title = $("#mailTitle").val();
	var content = $("#mailContent").val();
	var sendType = $("#sendType").val();
	var servers = $("#selservers").val();
	var partner = $("#partner").val();
	var sTime = $("#selTime").val();
	if(servers.length <= 0){
		alert("请选择服务器!");
		return;
	}else if(title.length <= 0){
		alert("标题不能为空!");
		return;
	}else if(content.length <= 0){
		alert("内容不能为空!");
		return;
	}else{
		if(sendType == 1){//指定玩家
			if(openids.length <= 0 && nicknames.length <= 0){
				alert("请输入玩家账号或玩家昵称!");
				return ;
			}else if($("#partner").val() == 0){
				alert("指定玩家需选择渠道!");
				return ;
			}
			htmlText = "是否向<span style='color:red;font-weight:bold;'>指定玩家帐号</span>发送此邮件?";
		}else if(sendType == 3){//指定时间段(注册/登录)
			if(sTime.length <= 0){
				alert("请指定时间周期!");
				return;
			}
			htmlText = "是否向<span style='color:red;font-weight:bold;'>指定时间段的玩家</span>发送此邮件?";
		}else if(sendType == 4){//当前注册
			htmlText = "是否向<span style='color:red;font-weight:bold;'>当前已注册的玩家</span>发送此邮件?";
		}else if(sendType == 5){//全服
			htmlText = "是否向<span style='color:red;font-weight:bold;'>全服</span>发送此邮件?";
		}else{
			htmlText = "是否确定发送此邮件?";
		}
	}
	
	itemids = "";
	for(i = 0; i < selitems.length; i++){
		itemids = itemids + Math.abs(selitems[i].itemType) + "_" + selitems[i].id + "_" + selitems[i].nlevel + "_" + selitems[i].namount + "|";
	}
	if(itemids.length > 0){
		itemids =  itemids.substr(0, itemids.length - 1);
	}
	data = {};
	data.partner = partner;
	data.sendType = sendType;
	data.openids = openids;
	data.nicknames = nicknames;
	data.title = title;
	data.content = content;
	data.items = itemids;
	data.servers = servers;
	data.selTime = sTime;
	$("#confirm_send_div").html(htmlText);
	$("#confirm_send_div").dialog({
		title:'发送邮件',
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		buttons:{
			"取消":function(){
				$(this).dialog("close");
			},
			"确定":function(){
				sendMail(data);
				$(this).dialog("close");
			}
		}
	});
	
}
function sendMail(data){
	$.ajax({
		 url : 'game_operate_mgr/url_sysmail_apply.jsp',
		 dataType : 'json',
		 data : data,
		 cache : false,
		 type:"post",
		 success:function(response){
			 if(!showError(response)){
				alert("邮件已提交申请，请联系管理员审批!");
				$("#openids").val("");
				$("#nicknames").val("");
				$("#mailTitle").val("");
				$("#mailContent").val("");
				$("#selTime").val("");
				selitems=[];
				data = {rows: selitems, page: 0, total: selitems.length};
				$("#senditems").flexAddData(data);
			 }
		 }
	});
}
function searchItem(){
	params = getSearchParams();
	var itemType = getParamsVale(params, "itemType");
	$("table[id^=allItems]").each(function(index, obj){
		$(obj).flexOptions({hide:true});
	});
	$("#allItems" + itemType).flexOptions({
		 params : params,
		 newp:1,
		 hide:false
	});
	$("#allItems" + itemType).flexReload();
}
function getSearchParams(){
	return params = [
	   	          {name:'itemType', value:$("#itemType").val()},
		          {name:'searchType', value:$("#searchType").val()},
		          {name:'searchValue', value:$("#searchValue").val()},
		         ];
}
function getParamsVale(params, name){
	for(i = 0;i < params.length; i++){
		if(params[i].name == name){
			return params[i].value;
		}
	}
	return '';
}
function addServer(){
	servers = $("#selservers").val();
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
function changeTime(){
	var startId = "startDate";
	var endId = "endDate";
	timeDialog("mail_tip_div", "指定玩家注册/登录时间段", startId, endId, "selTime");
	pickerMinDate(startId, getNextDate(0 * 24 * 60 * 60 * 1000));
	pickerMinDate(endId, getNextDate(0 * 24 * 60 * 60 * 1000));
}
function selectType(){
	var value = $("#sendType").val();
	if(value == 1){
		$("#openids").removeAttr("disabled");
		$("#addPlayer").removeAttr("disabled");
		$("#nicknames").removeAttr("disabled");
		$("#resetPlayer").removeAttr("disabled");
		$("#selTime").val("");
		$("#selTime").attr("disabled","disabled");
	}else if(value == 3){
		$("#selTime").removeAttr("disabled");
		$("#selTime").val("");
		$("#openids").val("");
		$("#openids").attr("disabled","disabled");
		$("#addPlayer").attr("disabled","disabled");
		$("#nicknames").val("");
		$("#nicknames").attr("disabled","disabled");
		$("#resetPlayer").attr("disabled","disabled");
	}else if(value == 4 || value == 5){
		$("#selTime").val("");
		$("#selTime").attr("disabled","disabled");
		$("#openids").val("");
		$("#openids").attr("disabled","disabled");
		$("#addPlayer").attr("disabled","disabled");
		$("#nicknames").val("");
		$("#nicknames").attr("disabled","disabled");
		$("#resetPlayer").attr("disabled","disabled");
	}
}
function addPlayers(){
	d = $('#mail_tip_div');
	d.attr("title", "添加需要发送邮件的用户帐号或昵称");
	openIdText = "<table style='margin:auto;'><tr><td style='text-align:right;'>玩家帐号：<td/><td style='text-align:left;'><input id='addUser'><td/><tr/>";
	nicknameText = "<tr><td style='text-align:right;'>玩家昵称：<td/><td style='text-align:left;'><input id='addName'><tr/><td/><table>";
	d.html(openIdText + nicknameText);
	d.dialog({
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		title:d.attr("title"),
		buttons:{
			"取消":function(){
				$(this).dialog("close");
			},
			"确定":function(){
				var player1 = $("#addUser").val();
				if(player1.length > 0){
					var val1 = $("#openids").val();
					if(val1.length > 0){
						$("#openids").val(val1 + ";" + player1);
					}else{
						$("#openids").val(player1);
					}
				}
				var player2 = $("#addName").val();
				if(player2.length > 0){
					var val2 = $("#nicknames").val();
					if(val2.length > 0){
						$("#nicknames").val(val2 + ";" + player2);
					}else{
						$("#nicknames").val(player2);
					}
				}
				$(this).dialog("close");
			}
		}
	});
}
function resetPlayers(type){
	if(type == 1){
		$("#openids").val("");
		alert("清除已输入帐号！");
	}else{
		$("#nicknames").val("");
		alert("清除已输入昵称！");
	}
}
function reset(){
	$("#openids").val("");
	$("#nicknames").val("");
	$("#openids").removeAttr("disabled");
	$("#nicknames").removeAttr("disabled");
	$("#addPlayer").removeAttr("disabled");
	$("#resetPlayer").removeAttr("disabled");
	$("#selTime").val("");
	$("#selTime").attr("disabled","disabled");
	$("#mailTitle").val("");
	$("#mailContent").val("");
	$("#sendType").attr("value","1");
	$("#sendType").attr("selected","selected");
	$("#senditems").flexAddData({rows: [], page: 0, total: 0});
	alert("成功重置！！！！");
}
</script>