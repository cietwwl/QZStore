<%@page import="com.game.constant.WebConstant"%>
<%@page import="com.web.obj.UserGroup"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search_div">
	<table>
		<tr style="text-align: center;">
			<td><b style="padding:2px;margin: 0px;">服务器</b></td>
			<td><b style="padding:2px;margin: 10px;">状　态</b></td>
			<td><b style="padding:2px;margin: 10px;">订　单</b></td>
			<td><b style="padding:2px;margin: 10px;">账　号</b></td>
			<td><b style="padding:2px;margin: 10px;">时　间</b></td>
		</tr>
		<tr>
			<td>
				<%@include file="/jsp/select_server.jsp"%>
			</td>
			<td>
				<select id="send_state" style="padding:2px;margin-left:5px;">
					<option value="-1" selected="selected">全部</option>
					<option value="0">未发货</option>
					<option value="1">已发货</option>
				</select>
			</td>
			<td><input id="bill" style="width:100px;margin-left:5px;" /></td>
			<td><input id="username" style="width:80px;margin-left:5px;" /></td>
			<td><span id="slt_span"></span></td>
			<td><input style="margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="查询" onclick="search();"/></td>
		</tr>
	</table>
</div>
<table id="recharge_table"></table>
<table id="send_goods_div"  style="display:none;">
	<tr>
		<td align="right">订单ID:</td>
		<td align="left" style="padding:2px;margin-left:5px;margin-top:-5px;"><input type="text" id="billId" style="width: 220px;" disabled="disabled"/></td>
	</tr>
</table>
<script type="text/javascript">
<%
UserGroup userGroup = (UserGroup)session.getAttribute("userGroup");
%>
var jurBillResend = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_BILL_RESEND)%>;
var datas;
function dispose(){
	$("#search_div").remove();
	$("#recharge_table").remove();
	$("#send_goods_div").remove();
	datas = null;
}
function ready(){
	$("#slt_span").html("<input id='begin' style='margin-left:5px;'/> 至 <input id='end' style='margin-left:5px;'/>");
	$("#begin").datepicker({ 
      	minDate: new Date(openTime * 1000), 
      	maxDate: new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate" ,(new Date)); 
	$("#end").datepicker({ 
      	minDate: new Date(openTime * 1000), 
      	maxDate: new Date(),
	    hideIfNoPrevNext: true,  // 当设置了最小日期\最大日期，且符合条件时隐藏导航按钮
	}).datepicker("setDate" ,(new Date)); 
	
	var bus = [];
	if(jurBillResend){
		bus = [{name: '发货', bclass: 'accept', onpress:batchResend}];
	}
	var showBox = jurBillResend;
	$("#recharge_table").flexigrid({
		url : 'game_operate_mgr/get_recharge_list.jsp',
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
	        checkbox : true,
	        hide : !showBox
		},{
   	 		display : 'ID',
	        name : 'id',
	        width : 50,
	        align : 'center'
		},{display : '订单编号',
	        name : 'bill',
	        width : 200,
	        align : 'center'
		},{display : '服务器',
			name : 'serverName',
	        width : 80,
	        align : 'center'
		},{display : '渠道',
			name : 'partnerName',
	        width : 80,
	        align : 'center'
		},{display : '账号',
			name : 'username',
	        width : 80,
	        align : 'center'
		},{display : '昵称',
			name : 'playerName',
	        width : 80,
	        align : 'center'
		},{display : '金额',
			name : 'money',
	        width : 60,
	        align : 'center'
		},{display : '已发货',
			name : 'completeTime',
	        width : 35,
	        align : 'center',
	        customValue:whether
		},{display : '操作',
			name : 'id',
	        width : 100,
	        align : 'center',
	        customValue:function(id, idx, value){
	        	if(jurBillResend){
	        		return "<a href='javascript:resend(" + value + ");'>重新发货</a>";
	        	}
	        	return "";
	        }
		},{display : '等级',
			name : 'level',
	        width : 40,
	        align : 'center',
	        hide : true
		},{display : '请求时间',
			name : 'time',
	        width : 130,
	        align : 'center',
	        customValue:getTimeStr
		},{display : '确认时间',
			name : 'confirmTime',
	        width : 130,
	        align : 'center',
	        customValue:getTimeStr
		},{display : '发货时间',
			name : 'completeTime',
	        width : 130,
	        align : 'center',
	        customValue:getTimeStr
		}],
		buttons: bus,
		usepager : true,
	    title : '充值管理',
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
   	 	showToggleBtn : showBox,
   	 	onSuccess : function(obj){
   	 		showError(datas);
	    }
	});
	search();
}
function resend(id){
	send("," + id);
}
function batchResend(){
	var ids = "";
	$("input[name='id']:checked").each(function(){
		ids += "," + $(this).val();
	});
	send(ids);
}
function send(ids){
	if(ids.length <= 1){
		alert("请选择订单");
		return;
	}
	ids = ids.substring(1, ids.length);
	$("#billId").val(ids);
	$("#send_goods_div").dialog({
		title:'发货',
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		buttons:{
			"取消" : function(){
				$(this).dialog("close");
			},
			"确定" : function(){
				$.ajax({
					url:"game_operate_mgr/url_bill_resend.jsp",
					data:{ids:ids},
					type:"post",
					dataType:"json",
					cache:false,
					success:function(response){
						if(!showError(response)){
							$("#send_goods_div").dialog("close");
							alert("发货成功!");
							$("#recharge_table").flexReload();
						}
					}
				});
				$("#send_goods_div").dialog("close");
			}
		}
	});
}
function search(){
	$("#recharge_table").flexOptions({
		params : [
		          {name:"serverId", value:$("#sid").val()},
		          {name:"sendState", value:$("#send_state").val()},
		          {name:'bill', value:$("#bill").val()},
		          {name:'username', value:$("#username").val()},
		          {name:'begintime', value:$("#begin").val()},
		          {name:'endtime', value:$("#end").val()}
		         ],
		newp:1
	});
	$("#recharge_table").flexReload();
}

</script>
<%

%>