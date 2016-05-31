<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search_div" style="display:table;">
	<span style="float:left;">
		<span id="slt_span" style="margin-left:5px;margin-top:-5px;"></span>
		<input style="margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="查询" onclick="search();"/>
		<span style="float:top;color:red;margin-left:10px;margin-top:-5px;" id="select_tip"></span>
	</span>
</div>
<table id="recharge_summary_table" style="display:none"></table>
<!-- 充值总汇  -->
<script type="text/javascript">
var datas;
var limitDay = 30;
function dispose(){
	$("#search_div").remove();
	$("#recharge_summary_table").remove();
	datas = null;
}
function ready(){
	$("#slt_span").html("<input id='begin' />　至　 <input id='end' />");
	$("#begin").datepicker({
	  	minDate: new Date(openTime * 1000),   
	  	maxDate: new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate" , new Date(new Date().getTime() - 7 * daytime));
	$("#end").datepicker({
	  	minDate: new Date(openTime * 1000),   
	  	maxDate: new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate" ,new Date); 
	
	$("#recharge_summary_table").flexigrid({
		url : 'game_stats_mgr/get_recharge_summary.jsp',
   	    dataType : 'json',
   		 preProcess : function(data){
	    	datas = data;
	    	return data;
	    },
   	 	colModel : [{display : '渠道',
	        name : 'partnerName',
	        width : 80,
	        align : 'center'
   	 	},{display : '充值金额( J )',
   	 		name : 'rechargeMoney',
   	 		width : 80,
   	 		align : 'center'
   	 	},{display : '充值人数( R )',
   	 		name : 'rechargeAmount',
   	 		width : 80,
   	 		align : 'center'
   	 	},{display : '注册人数( Z )',
   	 		name : 'registAmount',
   	 		width : 80,
   	 		align : 'center'
   	 	},{display : 'ARPU值( J / R )',
   	 		name : 'ARPU',
   	 		width : 80,
   	 		align : 'center',
   	 		customValue:function(i, idx, value){
   	 			var amount1 = datas.rows[i].rechargeMoney;
   	 			var amount2 = datas.rows[i].rechargeAmount;
	   	 		if(amount1 > 0 && amount2 > 0){
	   	 			var val = amount1 / amount2;
	   	 			return val.toFixed(2);
	 			}else{
	 				return 0;
	 			}
	 		}
   	 	},{display : 'LTV值( J / Z )',
   	 		name : 'LTV',
   	 		width : 80,
   	 		align : 'center',
   	 		customValue:function(i, idx, value){
   	 			var amount1 = datas.rows[i].rechargeMoney;
	   	 		var amount2 = datas.rows[i].registAmount;
	   	 		if(amount1 > 0 && amount2 > 0){
	   	 			var val = amount1 / amount2;
	 				return val.toFixed(2);
	 			}else{
	 				return 0;
	 			}
	 		}
   	 	},{display : '付费率( R / Z )',
   	 		name : 'payRate',
   	 		width : 80,
   	 		align : 'center',
   	 		customValue:function(i, idx, value){
   	 			var amount1 = datas.rows[i].rechargeAmount;
   	 			var amount2 = datas.rows[i].registAmount;
	 			if(amount1 > 0 && amount2 > 0){
	   	 			var percent = amount1 / amount2 * 100;
	 				return percent.toFixed(2) + " %";
	 			}else{
	 				return 0 + " %";
	 			}
	 		}
   	 	}],
		usepager : false,
	    title : '充值总汇',
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
	$("#recharge_summary_table").flexOptions({
		params:[{name:'begintime', value:$("#begin").val()},
		          {name:'endtime', value:$("#end").val()}],
		newp:1
	});
	$("#recharge_summary_table").flexReload();
}

</script>