<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search_div" style="display:table;">
	<span style="float:left;">
		<span id="slt_span" style="margin-left:5px;margin-top:-5px;"></span>
		<input style="margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="查询" onclick="search();"/>
	</span>
</div>
<table id="recharge_rank_table" style="display:none"></table>
<!-- 充值排名统计  -->
<script type="text/javascript">
var datas;
var limitDay = 365;
function dispose(){
	$("#search_div").remove();
	$("#recharge_rank_table").remove();
	datas = null;
}
function ready(){
	$("#slt_span").html("<input id='begin' />　至　 <input id='end' />");
	$("#begin").datepicker({
	    firstDay: 2,          
	  	maxDate: new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate", new Date()); 
	$("#end").datepicker({
	    firstDay: 2,   
	  	maxDate: new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate", new Date()); 
	
	$("#recharge_rank_table").flexigrid({
		url : 'game_stats_mgr/get_recharge_rank_list.jsp',
   	    dataType : 'json',
   		 preProcess : function(data){
	    	datas = data;
	    	return data;
	    },
   	 	colModel : [{display : '排名',
	        name : 'rank',
	        width : 100,
	        align : 'center'
   	 	},{display : '渠道',
	        name : 'partnerName',
	        width : 100,
	        align : 'center'
   	 	},{display : '账号',
	        name : 'username',
	        width : 100,
	        align : 'center'
   	 	},{display : '名称',
   	 		name : 'playerName',
   	 		width : 120,
   	 		align : 'center'
   	 	},{display : '充值总额',
   	 		name : 'totalMoney',
   	 		width : 100,
   	 		align : 'center'
   	 	},{display : '充值次数',
   	 		name : 'num',
   	 		width : 60,
   	 		align : 'center'
   	 	},{display : '服区',
	        name : 'serverId',
	        width : 100,
	        align : 'center'
   	 	}],
		usepager : true,
	    title : '充值排名统计',
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
	search();
}
function search(){
	var begin = $("#begin").datepicker("getDate");
	var end = $("#end").datepicker("getDate");
	if(end.getTime() < begin.getTime()){
		alert("结束日期不能小于开始日期");
		return;
	}else if(begin.getTime() + (limitDay - 1) * daytime < end.getTime()){
		alert("数据查询量太大，查询时间请不要超过" + limitDay + "天！");
		return;
	}
	$("#recharge_rank_table").flexOptions({
		params : [{name:'begintime', value:$("#begin").val()},
		          {name:'endtime', value:$("#end").val()}
		         ],
		newp : 1
	});
	$("#recharge_rank_table").flexReload();
}
</script>