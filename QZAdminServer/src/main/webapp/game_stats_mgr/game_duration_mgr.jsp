<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search_div" style="display:table;padding:5px;">
	<span style="float: left;">
		<span id="slt_span" style="margin-left:5px;margin-top:-5px;"></span>
		<input style="margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="查询" onclick="search();"/>
		<span style="float:top;color:red;margin-left:10px;margin-top:-5px;" id="select_tip"></span>
	</span>	
</div>
<div id="duration_div2" style="min-width: 400px; height: 300px; margin: 0 auto;"></div>
<table id="duration_table2" style="display: none"></table>
<div id="duration_div1" style="min-width: 400px; height: 450px; margin: 0 auto;"></div>
<table id="duration_table1" style="display: none"></table>
<!-- 在线时长统计  -->
<script type="text/javascript">
var datas;
var data2;
var report1;
var report2;
var limitDay = 14;
var ays = [60,30,15,10,5,1,0];
var ays1 = ['durationNum0','durationNum1','durationNum2','durationNum3','durationNum4','durationNum5','durationNum6'];
var ays2 = ["60分钟以上","30-60分钟","15-30分钟","10-15分钟","5-10分钟","1-5分钟","1分钟以下"];
function dispose(){
	$("#search_div").remove();
	$("#duration_div1").remove();
	$("#duration_div2").remove();
	$("#duration_table1").remove();
	$("#duration_table2").remove();
	datas = null;
	datas1 = null;
	report1 = null;
	report2 = null;
	ays = [];
	ays1 = [];
	ays2 = [];
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

	$("#duration_table1").flexigrid({
   	    url : 'game_stats_mgr/get_duration_list.jsp',
   	    dataType : 'json',
   	    preProcess : function(data){
   	    	datas = data;
   	 		initReport(data.rows);
   	    	return data;
   	    },
   	    colModel : [{display : '日期',
   	        name : 'time',
   	        width : 100,
   	        align : 'center',
   	        customValue : getDateChinaStr
   		}, {display : ays2[6],
   	        name : ays1[6],
   	        width : 80,
   	        align : 'center',
   	     	customValue : formatPercent2
   		}, {display : ays2[5],
   	        name : ays1[5],
   	        width : 80,
   	        align : 'center',
   	     	customValue : formatPercent2
   		}, {display : ays2[4],
   	        name : ays1[4],
   	        width : 80,
   	        align : 'center',
   	     	customValue : formatPercent2
   		}, {display : ays2[3],
   	        name : ays1[3],
   	        width : 80,
   	        align : 'center',
   	     	customValue : formatPercent2
   		}, {display : ays2[2],
   	        name : ays1[2],
   	        width : 80,
   	        align : 'center',
   	     	customValue : formatPercent2
   		}, {display : ays2[1],
   	        name : ays1[1],
   	        width : 80,
   	        align : 'center',
   	     	customValue : formatPercent2
   		}, {display : ays2[0],
   	        name : ays1[0],
   	        width : 80,
   	        align : 'center',
   	     	customValue : formatPercent2
   		}, {display : '总人数',
   	        name : 'totalNum',
   	        width : 60,
   	        align : 'center',
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
	$("#duration_table2").flexigrid({
   	    dataType : 'json',
   	    colModel : [{display : '每日在线时长',
   	        name : 'timeName',
   	        width : 100,
   	        align : 'center'
   		}, {display : '百分比',
   	        name : 'percent',
   	        width : 80,
   	        align : 'center',
   	     	customValue : formatPercent1
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
   	    height : 200,
   	    page: 1,
   	    total: 1,
   	    resizable: false,
   	    autoload: false,
   	    procmsg:'加载中，請稍後…',
   	    singleSelect:true,
   	 	showToggleBtn:false
   	});
	Highcharts.setOptions({  
        global: {  
            useUTC: false  
        }  
    });
	report1 = new Highcharts.Chart({
		chart:{
			renderTo:'duration_div1',
			type: 'spline'
		},
        title: {
            text: '每日在线时长统计(当日数据非实时)',
            x: -20 
        },
        xAxis: {
            categories: []
        },
        yAxis: {
        	min : 0,
        	allowDecimals : false,
            title: {
                text: '用户数（人） '
            },
            minPadding: 0,
            maxPadding: 0,
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
        	formatter : function(){
            	return '<b>' + this.series.options.data[this.x].name + '</b> <br><b>' + this.series.name + '人数 : </b>' + this.y + '人';
            }
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        credits:{enabled:false}
    });
	report2 = new Highcharts.Chart({
		chart:{
			renderTo:'duration_div2',
			plotBackgroundColor:null,
			plotBorderWidth:null,
			plotShadow:false
		},
        title: {
            text: '每日在线时长统计'
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
        	name:'每日在线时长比例'
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
	}else if(begin.getTime() + 13 * daytime < end.getTime()){
		alert("查询时间请不要超过" + limitDay + "天！");
		return;
	}
	for(j = report1.series.length - 1; j >= 0; j--){
		report1.series[j].destroy();
	}
	for(j = report2.series.length - 1; j >= 0 ; j--){
		report2.series[j].setData([]);
	}
	report1.showLoading();
	report2.showLoading();
	$("#duration_table1").flexOptions({
		params:[{name:'begin', value:$("#begin").val()},
		        {name:'end', value:$("#end").val()}],
		newp:1
	});
	$("#duration_table1").flexReload();
}
function initReport(data){
	data2 = {};
	var array2 = [];
	var total = 0;
	for(var k = 0; k < ays.length; k++){
		var row2 = {};
		row2.timeName = ays2[k];
		row2.curNum = 0;
		var str = ays2[k];
		var array=[];
		for(var i = 0; i < data.length; i++){
			var row = data[i];
			var val = 0;
			if(k == 0){
				val = row.durationNum0;
			}else if(k == 1){
				val = row.durationNum1;
			}else if(k == 2){
				val = row.durationNum2;
			}else if(k == 3){
				val = row.durationNum3;
			}else if(k == 4){
				val = row.durationNum4;
			}else if(k == 5){
				val = row.durationNum5;
			}else if(k == 6){
				val = row.durationNum6;
			}
			array.push({name:getDateChinaStr(0, 0, row.time), time:row.time * 1000, y:val});
			row2.curNum += val;
			total += val;
		}
		report1.addSeries({name:str, data:array});
		array2.push(row2);
	}
	report1.hideLoading();
	data2.total = array2.length;
	data2.page = 1;
	data2.rows = [];
	var vals = [];
	for(var i = 0; i < array2.length; i++){
		var row = array2[i];
		row.totalNum = total;
		vals.push([row.timeName, row.curNum]);
		data2.rows[array2.length - i - 1] = row;
	}
	report2.series[0].setData(vals);
	report2.hideLoading();
	$("#duration_table2").flexAddData(data2);
	$("#duration_table1").flexReload();
}
function formatPercent1(i, idx, value){
	if(data2){
		var amount1 = data2.rows[i].curNum;
		var amount2 = data2.rows[i].totalNum;
		if(amount1 > 0 && amount2 > 0){
			var percent = amount1 / amount2 * 100;
		    return  "" + percent.toFixed(2) + " %";
		}
	}
	return "0 %";
}
function formatPercent2(i, idx, value){
	if(value > 0){
		var amount = datas.rows[i].totalNum;
		if(amount > 0){
			var percent = value / amount * 100;
		    return value + "（" + percent.toFixed(2) + "%）";
		}
	}
	return "0（0%）";
}
</script>