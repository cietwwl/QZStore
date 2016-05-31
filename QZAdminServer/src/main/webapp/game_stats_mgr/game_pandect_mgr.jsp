<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search_div" style="display:table;padding:5px;">
	<span style="float: left;">
		<span id="slt_span" style="margin-left:5px;margin-top:-5px;"></span>
		<input style="margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="查询" onclick="search();"/>
		<span style="float:top;color:red;margin-left:10px;margin-top:-5px;" id="select_tip"></span>
	</span>
</div>
<div id="pandect_tip" style="display:table;padding:5px;"></div>
<div id="pandect_div" style="min-width: 400px; height: 450px; margin: 0 auto;"></div>
<table id="pandect_table" style="display:none"></table>
<!-- 数据总览  -->
<script type="text/javascript">
var p;
var datas;
var report;
var limitDay = 14;
function dispose(){
	$("#search_div").remove();
	$("#pandect_tip").remove();
	$("#pandect_div").remove();
	$("#pandect_table").remove();
	datas = null;
	report = null;
	p = null;
}
function ready(){
	$("#slt_span").html("<input id='begin' />　至　 <input id='end' />");
	$("#begin").datepicker({ 
      	minDate: new Date(openTime * 1000),  
      	maxDate: new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate" ,new Date(new Date().getTime() - 6 * daytime)); 
	$("#end").datepicker({ 
      	minDate: new Date(openTime * 1000),   
      	maxDate: new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate" ,(new Date));

	$("#pandect_table").flexigrid({
   	    url : 'game_stats_mgr/get_pandect_list.jsp',
   	    dataType : 'json',
   	    preProcess : function(data){
   	    	datas = data;
   	 		initReport(p, data.rows);
   	    	return data;
   	    },
   	    colModel : [{display : '日期',
   	        name : 'time',
   	        width : 100,
   	        align : 'center',
   	        customValue : getDateChinaStr
   		}, {display : '每日新增用户',
	        name : 'dayCountRegisterNum',
	        width : 90,
	        align : 'center'
        }, {display : '每日活跃用户',
	        name : 'dayCountActiveNum',
	        width : 90,
	        align : 'center'
        }, {display : '每日充值总额',
	        name : 'dayCountRecharge',
	        width : 90,
	        align : 'center'
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

	var begin = $("#begin").datepicker("getDate");
	var end = $("#end").datepicker("getDate");
	var size = (end.getTime() - begin.getTime()) / daytime + 1;
	report = new Highcharts.Chart({
		chart:{
			renderTo:'pandect_div',
			type: 'spline',
		},
        title: {
            text: '数据总览',
            x: -20,
        },
        xAxis: {
        	categories : []
        },
        yAxis: {
        	min : 0,
        	allowDecimals : false,
            title: {
                text: '用户数 （人）',
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            formatter : function(){
            	var val1 = "";
            	for(i = 0; i < report.series.length; i++){
           			var serie = report.series[i];
           			if(serie.name == this.series.name){
           				val1 = getDateChinaStr(0,0,serie.options.data[this.x].time / 1000)
           				break;
           			}
           		}
            	var val2 = "";
            	if(this.series.name == "每日新增用户"){
            		val2 = "新增用户 ";
            	}else if(this.series.name == "每日活跃用户"){
            		val2 = "活跃用户";
            	}
            	return '<b>' + val1 + '</b><br> ' + val2 + ' : ' + this.y + "（人）";
            }
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0,
        },
        credits:{enabled:false},
    });
	search();
	$("#select_tip").html("时间查询范围限制在 " + limitDay + " 天内！");
}
function search(){
	p = {};
	p.begin = $("#begin").datepicker("getDate");
	p.end = $("#end").datepicker("getDate");
	if(p.end.getTime() < p.begin.getTime()){
		alert("结束日期不能小于开始日期");
		return;
	}else if(p.begin.getTime() + (limitDay - 1) * daytime < p.end.getTime()){
		alert("查询时间请不要超过" + limitDay + "天！");
		return;
	}
	for(j = report.series.length - 1; j >= 0 ; j--){
		report.series[j].destroy();
	}
	report.showLoading();
	$("#pandect_table").flexOptions({
		params:[{name:'begin', value:$("#begin").val()},
		        {name:'end', value:$("#end").val()}],
		newp:1
	});
	$("#pandect_table").flexReload();
}
function initReport(param, data){
	var current = new Date();
	var begin = param.begin.getTime();
	var end = param.end.getTime() + daytime;
	var array1 = [];
	var array2 = [];
	var addNum = 0;
	var activeNum = 0;
	var rechargeNum = 0;
	for(var i = begin; i < end; i += daytime){
		var second = i / 1000;
		var str = getDateChinaStr(0, 0, second);
		var add = true;
		for(var j = 0; j < data.length; j++){
			if(data[j].time == second){
				array1.push({name:str, time:i, y:data[j].dayCountRegisterNum});
				array2.push({name:str, time:i, y:data[j].dayCountActiveNum});
				addNum += data[j].dayCountRegisterNum;
				activeNum += data[j].dayCountActiveNum;
				rechargeNum += data[j].dayCountRecharge;
				add = false;
				break;
			}
		}
		if(add && i <= current.getTime()){
			array1.push({name:str, time:i, y:0});
			array2.push({name:str, time:i, y:0});
		}
	}
	report.addSeries({name:"每日新增用户", data:array1});
	report.addSeries({name:"每日活跃用户", data:array2});
	report.hideLoading();
	$("#pandect_tip").html("　<b>新增总数：</b>" + addNum + "（人）　　　　<b>活跃总数：</b>" + activeNum + "（人）　　　　<b>充值总数：</b>" + rechargeNum + "（元）");
}
</script>