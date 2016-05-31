<%@page import="com.web.obj.UserGroup"%>
<%@page import="com.game.constant.WebConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="delete_mail_div" style="display:none;">
	<table>
		<tr>
			<td align="right">邮件ID:</td>
			<td align="left" style="padding:2px;"><input type="text" id="dmailId" disabled="disabled"/></td>
		</tr>
		<tr>
			<td align="right"></td>
			<td align="left" style="padding:2px;">确定删除以上选中的邮件吗?</td>
		</tr>
	</table>
</div>
<div id="search_div" style="display:table;">
	<span style="float:left;">
		类型:
		<select id="sendType" style="padding:2px;margin-left:5px;margin-top:-5px;">
			<option value="0" selected="selected">全部</option>
			<option value="1">指定玩家</option>
			<option value="3">指定时间段(注册/登录)</option>
			<option value="4">当前注册</option>
			<option value="5">长期全服</option>
		</select>
		<input style="margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="查询" onclick="searchMails();"/>
	</span>
</div>
<table id="mail_table"></table>
<script type="text/javascript">
<%
UserGroup userGroup = (UserGroup)session.getAttribute("userGroup");
%>
var jurDelSysMail = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_DELETE_SYSMAIL)%>;
var datas;
function dispose(){
	$("#mail_table").remove();
	$("#search_div").remove();
	$("#delete_mail_div").remove();
}
function ready(){
	var bus = [];
	if(jurDelSysMail){
		bus = [{name:"删除",bclass:'delete',onpress:batchDeleteMail}];
	}
	var showBox = jurDelSysMail;
	$("#mail_table").flexigrid({
		url : 'game_operate_mgr/get_game_mail_list.jsp',
   	    dataType : 'json',
   		rowId : 'id',
   		preProcess : function(data){
   			datas = data;
	    	return data;
	    },
   	 	colModel : [{
   	 		display : '',
	        name : 'id',
	        width : 50,
	        align : 'center',
	        checkbox:true,
	        hide : !showBox
		},{display : '邮件ID',
	        name : 'id',
	        width : 50,
	        align : 'center'
		},{display : '邮件名称',
	        name : 'title',
	        width : 80,
	        align : 'center'
		},{display : '待发送物品列表',
			name : 'items',
	        width : 200,
	        align : 'center'
		},{display : '渠道',
			name : 'partnerName',
	        width : 80,
	        align : 'center'
		},{display : '类型',
			name : 'sendType',
	        width : 80,
	        align : 'center',
	        customValue:function(i, idx, sendType){
	        	return getMailSendTypeName(Number(sendType));
	        }
		},{display : '待发送玩家id列表',
			name : 'uids',
	        width : 100,
	        align : 'center'
		},{display : '生成时间',
			name : 'time',
	        width : 120,
	        align : 'center',
	        customValue:getTimeStr
		}],
		buttons : bus,
		usepager : true,
	    title : '邮件列表',
	    useRp : true,
	    rp : tableRp,
	    width : tableWidth,
	    height : tableHeight,
	    page: 1,
	    total: 1,
	    resizable: false,
	    autoload: false,
	    procmsg:'加载中，請稍後…',
	    singleSelect:true,
   	 	showToggleBtn : showBox,
 		onSuccess : function(obj){
	 		showError(datas);
	    }
	});
	searchMails();
}
function searchMails(){
	var params = [];
	params.push({name:'sendType',value:$("#sendType").val()});
	$("#mail_table").flexOptions({
		params:params,
		newp:1
	});
	$("#mail_table").flexReload();
}
function batchDeleteMail(){
	var ids = "";
	var serverId = "";
	$("input[name='id']:checked").each(function(){
		var m = getMail($(this).val());
		serverId = m.sid;
		ids += "_" + $(this).val();
	});
	if(ids.length <= 0){
		alert("请选择邮件");
		return;
	}
	ids = ids.substring(1, ids.length);
	$("#dmailId").val(ids);
	$("#delete_mail_div").dialog({
		title:'删除游戏邮件',
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		buttons:{
			"取消" : function(){
				$(this).dialog("close");
			},
			"确定" : function(){
				$.ajax({url:"game_operate_mgr/url_mail_delete.jsp",
					data:{
						ids:ids,
						serverId:serverId
						},
					type:"post",
					dataType:"json",
					cache:false,
					success:function(response){
						if(!showError(response)){
							$("#delete_mail_div").dialog("close");
							alert("删除邮件成功!");
							searchMails();
						}
					}
				});
			}
		}
	});
}
function getMail(id){
	if(datas){
		for(i = 0; i < datas.rows.length; i++){
			if(datas.rows[i].id == id){
				return datas.rows[i];
			}
		}
	}
	return null;
}
</script>