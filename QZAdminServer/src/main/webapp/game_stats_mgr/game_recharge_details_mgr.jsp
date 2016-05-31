<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search_div" style="display:table;">
	<span style="float:left;margin-left:5px;margin-top:-5px;">
		<%@include file="/jsp/select_partner.jsp" %>
		<select id="select_user" onchange="onChange()" style="padding: 2px;">
			<option value="0" selected="selected">全服玩家</option>
			<option value="1">玩家帐号</option>
			<option value="2">玩家昵称</option>
		</select>
		<input id="search_input" style="margin-left:5px;margin-top:-5px;" >
		<span id="slt_span" style="margin-left:5px;margin-top:-5px;"></span>
		<input style="margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="查询" onclick="search();"/>
	</span>
	<span style="float:top;color:red;margin-left:10px;margin-top:-5px;" id="select_tip"></span>
</div>
<table id="recharge_details_table" style="display:none"></table>
<!-- 充值明细  -->
<script type="text/javascript">
var datas;
var limitDay = 30;
function dispose(){
	$("#search_div").remove();
	$("#recharge_details_table").remove();
	datas = null;
}
function ready(){
	$("#slt_span").html("<input id='begin' />　至　 <input id='end' />");
	$("#begin").datepicker({
	  	minDate: new Date(openTime * 1000),  
	  	maxDate: new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate" , new Date(new Date().getTime() - 1 * daytime)); 
	$("#end").datepicker({
	  	minDate: new Date(openTime * 1000),    
	  	maxDate: new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate" ,new Date); 
	
	$("#recharge_details_table").flexigrid({
		url : 'game_stats_mgr/get_recharge_details_list.jsp',
   	    dataType : 'json',
   		 preProcess : function(data){
	    	datas = data;
	    	return data;
	    },
   	 	colModel : [{display : '渠道',
	        name : 'partnerName',
	        width : 80,
	        align : 'center'
   	 	},{display : '名称',
   	 		name : 'goodsName',
   	 		width : 80,
   	 		align : 'center'
   	 	},{display : '金额',
   	 		name : 'rechargeMoney',
   	 		width : 80,
   	 		align : 'center'
   	 	},{display : '玩家帐号',
   	 		name : 'username',
   	 		width : 120,
   	 		align : 'center'
   	 	},{display : '玩家昵称',
   	 		name : 'playername',
   	 		width : 120,
   	 		align : 'center'
   	 	},{display : '充值时间',
   	 		name : 'time',
   	 		width : 150,
   	 		align : 'center',
	        customValue:getTimeStr
   	 	}],
		usepager : true,
	    title : '充值明细',
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
 		onSuccess : function(obj){
	 		showError(datas);
	    }
	});
	onChange();
	search();
	$("#select_tip").html("时间查询范围限制在 " + limitDay + " 天内！");
}
function search(){
	begin = $("#begin").datepicker("getDate");
	end = $("#end").datepicker("getDate");
	if(end.getTime() < begin.getTime()){
		alert("结束日期不能小于开始日期");
		return;
	}else if(begin.getTime() + (limitDay - 1) * daytime < end.getTime()){
		alert("查询时间请不要超过" + limitDay + "天！");
		return;
	}
	$("#recharge_details_table").flexOptions({
		params:[{name:'begin', value:$("#begin").val()},
		          {name:'end', value:$("#end").val()},
		          {name:'partner', value:$("#partner").val()},
		          {name:'userType', value:$("#select_user").val()},
		          {name:'userValue', value:$("#search_input").val()}],
		newp:1
	});
	$("#recharge_details_table").flexReload();
}
function onChange(){
	var val = $("#select_user").val();
	if(val == 0){
		$("#search_input").hide();
	}else{
		$("#search_input").show();
	}
}



</script>