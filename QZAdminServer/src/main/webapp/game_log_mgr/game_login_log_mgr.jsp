<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search_div" style="display:table;">
	<span style="float:left;">
		<select id="type" style="padding:2px;">
			<option value="0" selected="selected">全部</option>
			<option value="1">注册</option>
			<option value="2">登录</option>
			<option value="3">退出</option>
		</select>
		<span id="slt_span" style="margin-left:5px;margin-top:-5px;"></span>
		<select id="searchName" style="padding:2px;">
			<option value="openid" selected="selected">账号</option>
			<option value="nickname">昵称</option>
		</select>
		<input type="text" id="searchValue" style="margin-left:5px;margin-top:-5px;">
		<input style="margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="查询" onclick="searchLoginLog();"/>
	</span>
</div>
<table id="login_log_table"></table>
<!-- 登录日志  -->
<script type="text/javascript">
var datas;
function dispose(){
	$("#search_div").remove();
	$("#login_log_table").remove();
	datas = null;
}
function ready(){
	$("#slt_span").html("<input id='begin' />　至　 <input id='end' />");
	$("#begin").datepicker({ 
      	minDate: new Date(openTime * 1000),     
      	maxDate: new Date()
	}).datepicker("setDate" , getLastDate(new Date(), 1 * 24 * 60 * 60 * 1000)); 
	$("#end").datepicker({
      	minDate: new Date(openTime * 1000),     
      	maxDate: new Date()
	}).datepicker("setDate" ,(new Date)); 
	
	$("#login_log_table").flexigrid({
		url : 'game_log_mgr/get_game_login_log_list.jsp',
   	    dataType : 'json',
	    preProcess : function(data){
	    	datas = data;
	    	return data;
	    },
   	 	colModel : [{	
				display : '玩家ID',
				name : 'userId',
				width : 50,
				align : 'center'
			},{
				display : '玩家昵称',
				name : 'playername', 
				width : 120, 
				align : 'center'
			},{
				display : '操作',
				name : 'type',
				width : 100,
				align : 'center',
		      	customValue : function(i, idx, type){
			      	if(type == 1){
			      		return "注册";
			      	}else if(type == 2){
			      		return "登录";
			      	}else if(type == 3){
			      		return "退出";
			      	}
		      	}
			},{
				display : '时间',
				name : 'time', 
				width : 120,
				align : 'center',
				customValue : getTimeStr
			}
   	 	],
		usepager : true,
	    title : '登录日志',
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
 		onSuccess : function(obj){
	 		showError(datas);
	    }
	});
	searchLoginLog();
}
function searchLoginLog(){
	begin = $("#begin").datepicker("getDate");
	end = $("#end").datepicker("getDate");
	if(end.getTime() < begin.getTime()){
		alert("结束日期不能小于开始日期");
		return;
	}
	var params = [{name:'type',value:$("#type").val()},
	              {name:'searchName',value:$("#searchName").val()},
	              {name:'searchValue',value:$("#searchValue").val()},
	              {name:'moneyType',value:$("#moneyType").val()},
	              {name:'begintime',value:$("#begin").val()},
	              {name:'endtime',value:$("#end").val()}];
	$("#login_log_table").flexOptions({
		params:params,
		newp:1
	});
	$("#login_log_table").flexReload();
}

</script>