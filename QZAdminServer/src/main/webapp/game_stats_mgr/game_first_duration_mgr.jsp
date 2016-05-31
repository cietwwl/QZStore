<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search_div" style="display:table;padding:5px;">
	<span style="float: left;">
		<span id="slt_span" style="margin-left:5px;margin-top:-5px;"></span>
		<input style="margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="查询" onclick="search();"/>
		<span style="float:top;color:red;margin-left:10px;margin-top:-5px;" id="select_tip"></span>
	</span>
</div>
<div id="first_duration_div" style="min-width: 400px; height: 450px; margin: 0 auto; "></div>
<table id="first_duration_table" style="display: none"></table>
<!-- 首登时长统计  -->
<script type="text/javascript">
var report;
var datas;
var limitDay = 30;
function dispose(){
	$("#search_div").remove();
	$("#first_duration_div").remove();
	$("#first_duration_table").remove();
	report = null;
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
	
	$("#first_duration_table").flexigrid({
   	    url : 'game_stats_mgr/get_first_duration_list.jsp',
   	    dataType : 'json',
   	    preProcess : function(data){
   	    	datas = data;
   	    	initReport(data.rows);
   	    	return data;
   	    },
   	    colModel : [{display : '首登时长',
   	        name : 'timeName',
   	        width : 100,
   	        align : 'center'
   		}, {display : '百分比',
   	        name : 'percent',
   	        width : 80,
   	        align : 'center',
   	     	customValue : formatKeep
   		}, {display : '人数',
   	        name : 'curNum',
   	        width : 80,
   	        align : 'center'
   		}, {display : '总人数',
   	        name : 'totalNum',
   	        width : 80,
   	        align : 'center'
   		}],
   	    usepager : false,
   	    title : '具体数据',
   	    useRp : false,
   	    rp : tableRp,
   	    width : tableWidth,
   	    height : 300,
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
	report = new Highcharts.Chart({
		chart:{
			renderTo:'first_duration_div',
			plotBackgroundColor:null,
			plotBorderWidth:null,
			plotShadow:false
		},
        title: {
            text: '首登时长统计'
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
        	name:'首登时长比例'
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
	for(j = report.series.length - 1; j >= 0 ; j--){
		report.series[j].setData([]);
	}
	report.showLoading();
	$("#first_duration_table").flexOptions({
		params:[{name:'begin', value:$("#begin").val()},
		        {name:'end', value:$("#end").val()}],
		newp:1
	});
	$("#first_duration_table").flexReload();
}
function initReport(data){
	var vals = [];
	for(var i = 0; i < data.length; i++){
		var row = data[i];
		vals.push([row.timeName, row.percent]);
	}
	report.series[0].setData(vals);
	report.hideLoading();
}
function formatKeep(i, idx, value){
	return value + " %";
}
</script>