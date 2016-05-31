<%@page import="com.cache.GameServerCache"%>
<%@page import="com.web.db.game.GameServerInfo"%>
<%@page import="com.web.obj.UserGroup"%>
<%@page import="com.game.constant.WebConstant"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search_div" style="display:table;">
	<span style="float:left;">
		<b style="margin-left:2px;margin-top:-5px;">服务器:</b>
		<select id="serverId" style="margin-left:2px;margin-top:-5px;padding:2px;">
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
	    <b style="margin-left:2px;margin-top:-5px;">状态:</b>
		<select id="state" style="margin-left:2px;margin-top:-5px;padding:2px;">
			<option value="-1">全部</option>
			<option value="0" selected="selected">未审核</option>
			<option value="1">通过</option>
			<option value="2">拒绝</option>
		</select>
		<input style="margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="查询" onclick="search();"/>
	</span>
</div>
<div id='mail_div' style="display:table;"></div>
<div id="mail_tip" style="display:none;"></div>
<script type="text/javascript">
<%
UserGroup userGroup = (UserGroup)session.getAttribute("userGroup");
%>
var jurAudMail = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_AUDITING_MAIL_APPLY)%>;
var jurDelMail = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_DELETE_MAIL_APPLY)%>;
var jurFluMail = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_FLUSH_MAIL_STATE)%>;
var datas;
var del = {name: '删除', bclass: 'ban', onpress : function(){handle("", 2, true);}};
var aud = {name: '审核', bclass: 'accept', onpress : function(){handle("", 1, true);}};
var flu = {name: '刷新发放状态', bclass: 'bflush', onpress : function(){handle("", 3, true);}};
var val1 = "<table><tr><td align='right'>邮件ID:</td><td align='left' style='padding:2px;'><input id='mailIds' style='width:220px;' disabled='disabled'/></td></tr><tr><td></td>";
var val2 = val1 + "<td align='center' style='padding:5px;'><span><input type='radio' name='state' value='1' style='margin-left:20px;margin-top:5px;' checked='checked'>通过<input type='radio' name='state' value='2' style='margin-left:20px;margin-top:5px;'>拒绝</span></td></tr></table>"
var val3 = val1 + "<td align='center' style='padding:5px;color: red;'>确定删除以上邮件吗?</td></tr></table>";
var val4 = val1 + "<td align='center' style='padding:5px;color: red;'>确定刷新以上邮件的发放状态吗?</td></tr></table>";
function dispose(){
	$("#search_div").remove();
	$("#mail_div").remove();
	$("#mail_tip").remove();
	del = null;
	aud = null;
	flu = null;
	val1 = null;
	val2 = null;
	val3 = null;
	val4 = null;
	datas = null;
	mailJur = 0;
}
function ready(){
	search();
}
function search(){
	$("#mail_table").remove();
	$("#mail_div").html("<table id='mail_table'></table>");
	bus = [];
	if(jurDelMail){
		bus.push(del);
	}
	var state = $("#state").val();
	if(state == 0 && jurAudMail){
		bus.push(aud);
	}
	if(state != 2 && jurFluMail){
		bus.push(flu);
	}
	var showBox = jurDelMail || jurAudMail || jurFluMail;
	$("#mail_table").flexigrid({
		url : 'game_operate_mgr/get_mail_list.jsp',
   	    dataType : 'json',
   		rowId : 'id',
   		preProcess : function(data){
   			datas = data;
	    	return data;
	    },
   	 	colModel : [{
   	 		display : '',
	        name : 'id',
	        width : 40,
	        align : 'center',
	        checkbox:true,
	        hide : !showBox
		},{display : '邮件ID',
	        name : 'id',
	        width : 60,
	        align : 'center'
		},{display : '服务器',
			name : 'serverName',
	        width : 90,
	        align : 'center'
		},{display : '渠道',
			name : 'partnerName',
	        width : 100,
	        align : 'center'
		},{display : '申请人',
			name : 'username',
	        width : 90,
	        align : 'center'
		},{display : '状态',
			name : 'state',
	        width : 60,
	        align : 'center',
	        customValue:getStateHandlerLink
		},{display : '发放',
			name : 'send',
	        width : 30,
	        align : 'center',
	        customValue:function(i, idx, send){
	        	if(send == "true"){
	        		return "是";
	        	}else{
	        		return "否";
	        	}
	        }
		},{display : '邮件名称',
	        name : 'title',
	        width : 100,
	        align : 'center'
		},{display : '类型',
			name : 'sendType',
	        width : 80,
	        align : 'center',
	        customValue:function(i, idx, sendType){
	        	return getMailSendTypeName(Number(sendType));
	        }
		},{display : '待发送账号',
			name : 'openids',
	        width : 100,
	        align : 'center'
		},{display : '待发送物品',
			name : 'items',
	        width : 200,
	        align : 'center'
		},{display : '邮件内容',
			name : 'items',
	        width : 200,
	        align : 'center'
		},{display : '申请时间',
			name : 'createTime',
	        width : 120,
	        align : 'center',
	        customValue:getTimeStr
		}],
		buttons : bus,
   	    usepager : true,
   	    title : '邮件列表',
   	    useRp : false,
   	    rp : tableRp,
   	    width : tableWidth,
   	    height : tableHeight,
   	    page: 1,
   	    total: 1,
   	    resizable : false,
   	    autoload : false,
   	    procmsg : '加载中，請稍後…',
   	    singleSelect : true,
   	 	showToggleBtn : showBox,
   	 	onSuccess : function(obj){
   	 		showError(datas);
	    }
	});
	$("#mail_table").flexOptions({
		params : [
		          {name:'state',value:$("#state").val()},
		          {name:'serverId',value:$("#serverId").val()}
		          ],
		newp:1
	});
	$("#mail_table").flexReload();
}
function getStateHandlerLink(i, idx, state){
	var data = datas.rows[i];
	if(state == 0){
		if(jurAudMail){
			return "<a href='javascript:handle(" + data.id + ", 1, false)'>未处理</a>";
		}else{
			return "未处理";
		}
	}else if(state == 1){
		return "通过";
	}else if(state == 2){
		return "拒绝";
	}
}
function handle(ids, type, batch){
	if(batch){
		$("input[name='id']:checked").each(function(){
			ids += "," + $(this).val();
		});
		if(ids.length <= 0){
			alert("请选择邮件");
			return;
		}
		ids = ids.substring(1, ids.length);
	}
	var title = "";
	var url = "";
	var data = {ids : ids};
	if(type == 1){
		$("#mail_tip").html(val2);
		title = "审核";
		url = "game_operate_mgr/url_sysmail_auditing.jsp"
	}else if(type == 2){
		$("#mail_tip").html(val3);
		title = "删除邮件";
		url = "game_operate_mgr/url_sysmail_delete.jsp";
	}else if(type == 3){
		$("#mail_tip").html(val4);
		title = "刷新邮件发放状态";
		url = "game_operate_mgr/url_sysmail_flush.jsp";
	}
	$("#mailIds").val(ids);
	$("#mail_tip").dialog({
		title : title,
		resizable : false,
		modal : true,
		autoOpen : true,
		draggable : true,
		buttons : {
			"取消" : function(){
				$(this).dialog("close");
			},
			"确定" : function(){
				data.state = $("input[name=state]:checked").val();
				$.ajax({
					url : url,
					data : data,
					type : "post",
					dataType : "json",
					cache : false,
					success:function(response){
						$("#mail_tip").dialog("close");
						if(!showError(response)){
							if(type == 1){
								alert("审核成功!");
								$("#mail_table").flexReload();
							}else if(type == 2){
								alert("删除邮件成功!");
								search();
							}else if(type == 3){
								alert("　　　　　　　　刷新成功 ! \r\n\r\n若状态未改变，请检查对应服务器是否正常开启");
								$("#mail_table").flexReload();
							}
						}
					}
				});
			}
		}
	});
}
</script>