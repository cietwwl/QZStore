<%@page import="com.game.constant.WebConstant"%>
<%@page import="com.web.obj.UserGroup"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="cdkey_tip_div" style="display:none;">
	<table style="width: 250px;">
		<tr>
			<td align="right"><b style="margin-left: 5px;margin-top: 5px;">CDKey：</b></td>
			<td align="left" style="padding:2px;"><input type="text" id="cdkeyIds" disabled="disabled" style="margin-left: 5px;margin-top: 5px;width: 200px;"></td>
		</tr>
		<tr>
			<th colspan="2" align="center" style="padding:2px;">
				<div id="cdkey_tip"></div>
			</th>
		</tr>
	</table>
</div>
<div id="search_div">
	<span>
		<b>激活状态：</b>
		<select id="activated" style="padding:2px;margin-left:5px;">
			<option value="-1" selected="selected">不选择</option>
			<option value="0">未激活</option>
			<option value="1">已激活</option>
		</select>
		<b style="padding:2px;margin-left:5px;">兑换状态：</b>
		<select id="convert" style="padding:2px;margin-left:5px;">
			<option value="-1" selected="selected">不选择</option>
			<option value="0">未兑换</option>
			<option value="1">已兑换</option>
		</select>
		<b style="margin-left:5px;margin-top:-5px;">生成码:</b><input type="text" id="code" style="margin-left:5px;margin-top:-5px;">
		<input style="margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="查询" onclick="search();"/>
		<input style="margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="下载" onclick="downCdKey();" id="down_cdkey"/>
	</span>
</div>
<table id="cdkey_table"></table>
<div id="download_tip_div" style="display:none;"></div>
<script type="text/javascript">
<%
UserGroup userGroup = (UserGroup)session.getAttribute("userGroup");
%>
var jurGenCdkey = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_GENERATE_CDKEY)%>;
var jurDelCdkey = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_DELETE_CDKEY)%>;
var jurDowCdkey = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_DOWNLOAD_CDKEY)%>;
var datas;
function dispose(){
	$("#cdkey_table").remove();
	$("#download_tip_div").remove();
	$("#cdkey_tip_div").remove();
	datas = null;
}
function ready(){
	var bus = [];
	if(jurGenCdkey){
		bus.push({name: '激活', bclass: 'accept', onpress : function(){tipDialog(1, getSelIds());}});
	}
	if(jurDelCdkey){
		bus.push({name: '删除', bclass: 'delete', onpress : function(){tipDialog(2, getSelIds())}});
	}
	if(!jurDowCdkey){
		$("#down_cdkey").hide();
	}
	var showBox = jurGenCdkey || jurDelCdkey;
	$("#cdkey_table").flexigrid({
		url : 'game_operate_mgr/get_cdkey_list.jsp',
   	    dataType : 'json',
   		rowId : 'id',
   		preProcess : function(data){
   			datas = data;
	    	return data;
	    },
   	 	colModel : [{
   	 		display : '',
	        name : 'id',
	        width : 30,
	        align : 'center',
	        checkbox: true,
	        hide : !showBox
		},{display : 'ID',
	        name : 'id',
	        width : 60,
	        align : 'center'
		},{display : '类型',
			name : 'type',
	        width : 30,
	        align : 'center',
	        customValue:function(i, idx, value){
	        	if(value == 1){
	        		return "普通";
	        	}
	        	return "通用";
	        }
		},{display : '生成码',
			name : 'code',
	        width : 60,
	        align : 'center'
		},{display : 'cdkey',
			name : 'cdkey',
	        width : 250,
	        align : 'center'
		},{display : '激活',
			name : 'activated',
	        width : 30,
	        align : 'center',
	        customValue:function(i, idx, value){
	        	if(value == 1){
	        		return "是";
	        	}
	        	return "否";
	        }
		},{display : '可兑换次数',
			name : 'totalNum',
	        width : 60,
	        align : 'center'
		},{display : '已兑换次数',
			name : 'convertNum',
	        width : 60,
	        align : 'center'
		},{display : '奖励',
			name : 'rewards',
	        width : 100,
	        align : 'center'
		},{display : '生成者',
			name : 'creator',
	        width : 60,
	        align : 'center'
		},{display : '生成时间',
	        name : 'createTime',
	        width : 120,
	        align : 'center',
	        customValue : getTimeStr
		}],
		buttons : bus,
		usepager : true,
	    title : 'CdKey管理',
	    useRp : true,
	    rp : tableRp,
	    width : tableWidth,
	    height : tableHeight,
	    page: 1,
	    total: 1,
	    resizable: false,
	    autoload: false,
	    procmsg:'加载中，請稍後…',
	    singleSelect : true,
   	 	showToggleBtn : showBox,
 		onSuccess : function(obj){
	 		showError(datas);
	    }
	});
	search();
}
function search(){
	$("#cdkey_table").flexOptions({
		params : [{name:'convert', value:$("#convert").val()},
		          {name:'activated', value:$("#activated").val()},
		          {name:'code', value:$("#code").val()}
		         ],
		newp:1
	});
	$("#cdkey_table").flexReload();
}
function getSelIds(){
	var ids = "";
	$("input[name='id']:checked").each(function(){
		ids += "," + $(this).val();
	});
	if(ids.length > 0){
		return ids.substring(1, ids.length);
	}
	return "";
}

function tipDialog(type, ids){
	if(ids.length <= 0){
		alert("请选择cdkey");
		return;
	}
	$("#cdkeyIds").val(ids);
	var title = "";
	var url = "";
	if(type == 1){
		$("#cdkey_tip").html("<br><b style='color:red;'>确定激活以上cdkey吗？</b>");
		title = "激活CdKey";
		url = "game_operate_mgr/url_cdkey_activated.jsp";
	}else{
		$("#cdkey_tip").html("<br><b style='color:red;'>删除cdkey会删除兑换记录！<br>是否确定删除以上cdkey？</b>");
		title = "删除CdKey";
		url = "game_operate_mgr/url_cdkey_delete.jsp";
	}
	$("#cdkey_tip_div").dialog({
		title: title,
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		buttons:{
			"取消" : function(){
				$(this).dialog("close");
			},
			"确定" : function(){
				$.ajax({url: url,
					data:{ids : ids},
					type:"post",
					dataType:"json",
					cache:false,
					success:function(response){
						if(!showError(response)){
							$("#cdkey_tip_div").dialog("close");
							if(type == 1){
								alert("激活CdKey成功!");
							}else{
								alert("删除CdKey成功!");
							}
							$("#cdkey_table").flexReload();
						}
					}
				});
			}
		}
	});
}

function downCdKey(){
	$("#download_tip_div").html("<br><br><b style='color:red;'>确定下载当前条件下的数据？</b>")
	$("#download_tip_div").dialog({
		title:'下载cdkey数据表',
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		buttons:{
			"取消" : function(){
				$(this).dialog("close");
			},
			"确定" : function(){
				var p = {};
				var form = $("<form>");  
				form.attr('style','display:none');
				form.attr('target','');  
				form.attr('method','post');  
				form.attr('action','game_operate_mgr/download_game_cdkey.jsp');
				var input1 = $("<input type='text' name='code' value='" + $("#code").val() + "'>");
				form.append(input1);
				var input2 = $("<input type='text' name='activated' value='" + $("#activated").val() + "'>");
				form.append(input2); 
				var input3 = $("<input type='text' name='convert' value='" + $("#convert").val() + "'>");
				form.append(input3);
				$('body').append(form); 
				form.submit(); 
				form.remove();
				$(this).dialog("close");
			}
		}
	});
}
</script>