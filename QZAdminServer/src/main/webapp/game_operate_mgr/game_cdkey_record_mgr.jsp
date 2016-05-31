<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search_div" style="display:table;padding:5px;">
	<span>
		<%@include file="/jsp/select_server.jsp"%>
		<b style="margin-left: 5px;margin-top: -5px;">CDKEY：</b><input id="cdkey" style="margin-left: 5px;margin-top: -5px;">
		<b style="margin-left: 5px;margin-top: -5px;">帐号：</b><input id="openid" style="margin-left: 5px;margin-top: -5px;">
		<input id="selTime" type="checkbox" style="margin-left: 5px;vertical-align: middle;" onclick="showTime();"><label for="selTime" style="margin-left: 2px;"><b>时间</b></label>
		<span id="slt_span" style="margin-left:5px;margin-top:-5px;"></span>
		<input style="margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="查询" onclick="search();"/>
	</span>
</div>
<table id="cdkey_table" ></table>
<script type="text/javascript">
var datas;
function dispose(){
	$("#search_div").remove();
	$("#cdkey_table").remove();
	datas = null;
}
function ready(){
	$("#slt_span").html("<input id='begin' />　至　 <input id='end' />");
	$("#begin").datepicker({ 
      	minDate: new Date(openTime * 1000), 
      	maxDate: new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate" ,new Date()); 
	$("#end").datepicker({ 
      	minDate: new Date(openTime * 1000), 
      	maxDate: new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate" ,new Date());
	$("#slt_span").hide();
	$("#cdkey_table").flexigrid({
	    url : 'game_operate_mgr/get_cdkey_record_list.jsp',
	    dataType : 'json',
	    preProcess : function(data){
	    	datas = data;
	    	return data;
	    },
	    colModel : [{display : '兑换码id',
       	        name : 'cdkeyId',
       	        width : 80,
       	        align : 'center'
	   		}, {display : '兑换码',
    	        name : 'cdkey',
    	        width : 250,
    	        align : 'center'
	        },  { display : '区服',
    	        name : 'serverName',
    	        width : 90,
    	        align : 'center'
	        }, {display : '渠道',
	        	name : 'partnerName',
    	        width : 80,
    	        align : 'center'
	        }, {display : '帐号',
	        	name : 'openid',
    	        width : 80,
    	        align : 'center'
	        }, {display : '昵称',
	        	name : 'nickname',
    	        width : 80,
    	        align : 'center'
	        }, {display : '兑换时间',
    	        name : 'convertTime',
    	        width : 120,
    	        sortable : true,
    	        align : 'center',
    	        customValue : getTimeStr
	        }],
   	    usepager : true,
   	    title : 'CDKEY兑换记录',
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
   	 	showToggleBtn : true,
 		onSuccess : function(obj){
	 		showError(datas);
	    }
	});
	search();
}
function search(){
	var begin = $("#begin").datepicker("getDate");
	var end = $("#end").datepicker("getDate");
	if(end.getTime() < begin.getTime()){
		alert("结束日期不能小于开始日期");
		return;
	}
	var selTime = $("#selTime").attr("checked") ? 1 : 0;
	$("#cdkey_table").flexOptions({
		params:[{name:'sid', value:$("#sid").val()},
		        {name:'cdkey', value:$("#cdkey").val()},
		        {name:'openid', value:$("#openid").val()},
		        {name:'selTime', value: selTime},
		        {name:'begin', value:$("#begin").val()},
		        {name:'end', value:$("#end").val()}],
		newp:1
	});
	$("#cdkey_table").flexReload();
}
function showTime(){
	if($("#selTime").attr("checked")){
		$("#slt_span").show();
	}else{
		$("#slt_span").hide();
	}
}
</script>