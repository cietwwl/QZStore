<%@page import="com.game.constant.WebConstant"%>
<%@page import="com.web.obj.UserGroup"%>
<%@page import="com.web.db.game.GameServerInfo"%>
<%@page import="com.ks.constant.SystemConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="createInfo">
	<table style="width: 750px;">
		<tr>
			<td align="right">类型：</td>
			<td align="left">
				<select id="code_type" style="margin-left: 0px;" onchange="changeType();">
					<option value="1">普通( 1 → 1 )</option>
					<option value="2">通用( 1 → N )</option>
				</select>
			</td>
			<td><span style="margin-left: 10px;" id="act"><input id="activited" type="checkbox" style="vertical-align: middle;"><label for="activited" style="margin-left: 5px;vertical-align: middle;" >生成并激活</label></span></td>
		</tr>
		<tr>
			<td align="right">名称：</td>
			<td align="left"><input type="text" id="code_name" style="width: 150px;"></td>
			<td style="height:20px;width:200px;text-align:left;">　描　述：</td>
		</tr>
		<tr>
			<td align="right">生成码：</td>
			<td align="left"><input type="text" id="init_code" value="1d2e" style="width: 150px;"></td>
			<th rowspan="2">
				<textarea rows="2" cols="80" id="code_desc" style="resize:none;"></textarea>
			</th>
		</tr>
		<tr>
			<td align="right">兑换数量：</td>
			<td align="left"><input type="text" id="code_num" value="1" style="width: 150px;" onkeyup="limitValue(value)"></td>
		</tr>
		<tr>
			<td style="height:20px;width:200px;text-align:right;">物品:</td>
			<th colspan="2">
				<table id="rewards_table" style="display:none"></table>
			</th>
		</tr>
		<tr>
			<th colspan="3" align="center">
				<input id="submit_generate" class="button orange small" type="button" value="生成" onclick="submit();"/>
				<input class="button orange small" type="button" value="重置" onclick="reset()" style="margin-left: 50px;margin-top: 20px;" >
			</th>
		</tr>
	</table>
</div>
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
<div id="search_tip_div" style="display:none;"></div>
<script type="text/javascript">
<%
UserGroup userGroup = (UserGroup)session.getAttribute("userGroup");
%>
var jurGenCdkey = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_GENERATE_CDKEY)%>;
var jurActCdkey = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_ACTIVITED_CDKEY)%>;
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
var datas;
var selitems = [];
var maxVal = 0;
function dispose(){
	$("#createInfo").remove();
	$("#items_select_div").remove();
	$("#search_tip_div").remove();
	colModelObject = null;
	datas = null;
	selitems = null;
	maxVal = null;
}
function ready(){
	if(!jurGenCdkey){
		$("#submit_generate").hide();
		if(!jurActCdkey){
			$("#act").hide();
			$("#activited").attr("checked", false);
		}
	}
	$("#rewards_table").flexigrid({
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
	        	customValue : getItemLevelInput
	   		},{display : '数量',
	   			name : 'id',
	       		width : 100,
	        	align : 'center',
	        	customValue : getItemNumberInput
	   		},{display : '操作',
	   			name : 'id',
	       		width : 50,
	        	sortable : true,
	        	align : 'center',
	        	customValue : getItemDelete
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
	 	    	datas = data;
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
	changeType();
}
function searchItemDialog(){
	d = $('#search_tip_div');
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
		width : 610,
		height : 650,  //使用auto会导致长列表第一次打开出现问题
		title:"物品列表",
		buttons:{
			"取消":function(){
				$(this).dialog("close");
			},
			"确定":function(){
				$("input[name='allitemcheckbox']:checked").each(function(i){
					id = $(this).val();
					for(i = 0; i < datas.rows.length; i++){
						if(datas.rows[i].id == id){
							selitem = datas.rows[i];
							selitems[selitems.length]=selitem;
							selitem.namount = 1;
							selitem.nlevel = 1;
							break;
						}
					}
				});
				data = {rows: selitems, page: 0, total: selitems.length};
				$("#rewards_table").flexAddData(data);
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
	$("#rewards_table").flexAddData(data);
}
function searchItem(){
	$("table[id^=allItems]").each(function(index, obj){
		$(obj).flexOptions({hide:true});
	});
	var itemType = $("#itemType").val();
	var searchType = $("#searchType").val();
	var searchValue = $("#searchValue").val();
	$("#allItems" + itemType).flexOptions({
		 params : [{name:'itemType', value: itemType},
			          {name:'searchType', value: searchType},
			          {name:'searchValue', value: searchValue},
			         ],
		 newp:1,
		 hide:false
	});
	$("#allItems" + itemType).flexReload();
}
function reset(){
	$("#code_type").val(1);
	$("#code_name").val("");
	$("#init_code").val("1d2e");
	$("#code_num").val(1);
	$("#code_desc").val("");
	$("#rewards_table").flexAddData({rows: [], page: 0, total: 0});
}
function submit(){
	var type = $("#code_type").val();
	if(type != 1 && type != 2){
		alert("cdkey类型错误，请检查类型 ！");
		return;
	}
	var name = $.trim($("#code_name").val());
	if(name.length <= 0){
		alert("cdkey名称不能为空!");
		return;
	}
	var code = $("#init_code").val();
	if(code.length == 0){
		alert("cdkey生成码不能为空!");
		return;
	}
	var num = $("#code_num").val();
	if(num <= 0){
		alert("cdkey生成数量不能小于1 !");
		return;
	}
	var rewards = "";
	for(i = 0; i < selitems.length; i++){
		amount = $("#itemAmount" + selitems[i].id).val();
		rewards = rewards + Math.abs(selitems[i].itemType) + "_" + selitems[i].id + "_" + amount + "_" + "0" + "|";
	}
	if(rewards.length <= 0){
		alert("cdkey礼包物品不能为空!");
		return;
	}else{
		rewards =  rewards.substr(0, rewards.length - 1);
	}
	var desc = $.trim($("#code_desc").val());
	var activited = $("#activited").attr("checked") ? 1 : 0;
	$.ajax({
		 url : "game_operate_mgr/url_cdkey_generate.jsp",
		 dataType : 'json',
		 data : {
			 activited : activited,
			 type : type,
			 code : code,
			 num : num,
			 name : name,
			 desc : desc,
			 rewards : rewards
		 },
		 cache : false,
		 type:"post",
		 success:function(response){
			 if(!showError(response)){
				 alert("生成成功，请联系管理员激活！");
				 reset();
			 }
		 }
	});
}
function changeType(){
	if($("#code_type").val() == 1){
		maxVal = 10000;
	}else{
		maxVal = 2147483647;
	}
	if($("#code_num").val() >= maxVal){
		$("#code_num").val(maxVal);
	}
	changeNumColor();
}
function changeNumColor(){
	if($("#code_num").val() >= maxVal){
		document.getElementById("code_num").style.color = 'red';
	}else{
		document.getElementById("code_num").style.color = 'black';
	}
}
function limitValue(value){
	if(isNaN(value) || value.indexOf(".") >= 0 || value.indexOf("-") >= 0){
		var strs = value.split("");
		for(var i = 0; i < strs.length; i ++){
			var val = strs[i];
			if(isNaN(val)){
				if(i > 0){
					value = value.substring(0, i);
				}else{
					value = "1";
				}
				break;
			}
		}
	}
	var zero = -1;
	if(value != 0 && value != ""){
		var strs = value.split("");
		for(var i = 0; i < strs.length; i++){
			if(strs[i] == 0 && (i == 0 || zero >= 0)){
				zero = i;
			}else if(zero != -1){
				zero++;
				if(zero >= strs.length){
					value = 1;
				}else{
					value = value.substring(zero, strs.length);
				}
				break;
			}
		}
		$("#code_num").val(value > maxVal ? maxVal : value);
		changeNumColor();
	}else{
		$("#code_num").val("");
	}
}
</script>