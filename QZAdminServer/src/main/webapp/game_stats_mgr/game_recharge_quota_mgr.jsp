<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search_div" style="display:table;padding:5px;">
	<span style="float: left;">
		<span id="slt_span" style="margin-left:5px;margin-top:-5px;"></span>
		<input style="margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="查询" onclick="search();"/>
		<span style="float:top;color:red;margin-left:10px;margin-top:-5px;" id="select_tip"></span>
	</span>
</div>
<div id="recharge_quota_div1" style="min-width: 400px; height: 300px; margin: 0 auto;"></div>
<div id="recharge_quota_div2" style="min-width: 400px; height: 300px; margin: 0 auto;"></div>
<table id="recharge_quota_table" style="display: none"></table>
<!-- 充值额度统计 -->
<script type="text/javascript">
var report1;
var report2;
var datas;
var limitDay = 30;
function dispose(){
	$("#search_div").remove();
	$("#recharge_quota_div1").remove();
	$("#recharge_quota_div2").remove();
	$("#recharge_quota_table").remove();
	report1 = null;
	report2 = null;
	datas = null;
}
function ready(){
	$("#slt_span").html("<input id='begin' />　至　 <input id='end' />");
	$("#begin").datepicker({ 
      	minDate: new Date(openTime * 1000),  
      	maxDate: new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate" ,new Date(new Date().getTime() - 1 * daytime));
	$("#end").datepicker({ 
      	minDate: new Date(openTime * 1000),   
      	maxDate: new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate" ,(new Date));

	$("#recharge_quota_table").flexigrid({
   	    url : 'game_stats_mgr/get_recharge_quota_list.jsp',
   	    dataType : 'json',
   	    preProcess : function(data){
   	    	datas = data;
   	    	initReport(data.rows);
   	    	return data;
   	    },
   	    colModel : [{display : '充值额度',
   	        name : 'rechargeQuota',
   	        width : 100,
   	        align : 'center'
   		}, {display : '单笔充值达标人数',
   	        name : 'simpleNum',
   	        width : 120,
   	        align : 'center'
   		}, {display : '单笔充值达标比例',
   	        name : 'simplePercent',
   	        width : 120,
   	        align : 'center',
   	     	customValue : formatValue1
   		}, {display : '累计充值达标人数',
   	        name : 'countNum',
   	        width : 120,
   	        align : 'center'
   		}, {display : '累计充值达标比例',
   	        name : 'countPercent',
   	        width : 120,
   	        align : 'center',
   	     	customValue : formatValue2
   		}],
   	    usepager : false,
   	    title : '具体数据',
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
   	 	showToggleBtn:false,
 		onSuccess : function(obj){
	 		showError(datas);
	    }
   	});
	Highcharts.setOptions({  
        global: {  
            useUTC: false  
        }  
    });
	report1 = new Highcharts.Chart({
		chart:{
			renderTo:'recharge_quota_div1',
			plotBackgroundColor:null,
			plotBorderWidth:null,
			plotShadow:false
		},
        title: {
            text: '单笔充值额度统计'
        },
        tooltip: {
        	pointFormat: '{series.name}: <b>{point.percentage:.2f}%</b>'
        },
        plotOptions:{
        	pie:{
        		allowPointSelect:true,
        		cursor:'pointer',
        		dataLabels:{
        			enabled:true,
        			color:'#000000',
        			connectorColor:'#000000',
        			format: '<b>{point.name}</b>: {point.percentage:.2f} %'
        		}
        	}
        },
        series:[{
        	type:'pie',
        	name:'单次充值额度比例'
        }]
    });
	report2 = new Highcharts.Chart({
		chart:{
			renderTo:'recharge_quota_div2',
			plotBackgroundColor:null,
			plotBorderWidth:null,
			plotShadow:false
		},
        title: {
            text: '累计充值额度统计'
        },
        tooltip: {
        	pointFormat: '{series.name}: <b>{point.percentage:.2f}%</b>'
        },
        plotOptions:{
        	pie:{
        		allowPointSelect:true,
        		cursor:'pointer',
        		dataLabels:{
        			enabled:true,
        			color:'#000000',
        			connectorColor:'#000000',
        			format: '<b>{point.name}</b>: {point.percentage:.2f} %'
        		}
        	}
        },
        series:[{
        	type:'pie',
        	name:'累计充值额度比例'
        }]
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
	for(j = report1.series.length - 1; j >= 0 ; j--){
		report1.series[j].setData([]);
	}
	for(j = report2.series.length - 1; j >= 0; j--){
		report2.series[j].setData([]);
	}
	report1.showLoading();
	report2.showLoading();
	$("#recharge_quota_table").flexOptions({
		params:[{name:'begin', value:$("#begin").val()},
		        {name:'end', value:$("#end").val()}],
		newp:1
	});
	$("#recharge_quota_table").flexReload();
}
function initReport(data){
	var vals1 = [];
	var vals2 = [];
	for(var i = 0; i < data.length; i++){
		var row = data[i];
		if(row.simpleNum > 0 && row.simplePercent > 0){
			var percent1 = row.simpleNum / row.simplePercent;
			vals1.push([row.rechargeQuota, percent1]);
		}else{
			vals1.push([row.rechargeQuota, 0]);
		}
		if(row.countNum > 0 && row.countPercent > 0){
			var percent2 = row.countNum / row.countPercent;
			vals2.push([row.rechargeQuota, percent2]);
		}else{
			vals2.push([row.rechargeQuota, 0]);
		}
	}
	report1.series[0].setData(vals1);
	report2.series[0].setData(vals2);
	report1.hideLoading();
	report2.hideLoading();
}
function formatValue1(i, idx, value){
	var amount = datas.rows[i].simpleNum;
	if(amount > 0 && value > 0){
		var percent = amount / value * 100;
		return percent.toFixed(2) + " %";
	}
	return "0 %";
}
function formatValue2(i, idx, value){
	var amount = datas.rows[i].countNum;
	if(amount > 0 && value > 0){
		var percent = amount / value * 100;
		return percent.toFixed(2) + " %";
	}
	return "0 %";
}
</script>