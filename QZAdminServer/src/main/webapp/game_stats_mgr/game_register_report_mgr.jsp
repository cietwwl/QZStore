<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search_div" style="display:table;padding:5px;">
	<span style="float: left;">
		<span id="slt_span" style="margin-left:5px;margin-top:-5px;"></span>
		<input style="margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="查询" onclick="search();"/>
		<span style="float:top;color:red;margin-left:10px;margin-top:-5px;" id="select_tip"></span>
	</span>
</div>
<div id="register_tip" style="display:table;padding:5px;"></div>
<div id="register_div" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
<table id="register_table" style="display:none"></table>
<!-- 创角统计  -->
<script type="text/javascript">
var p;
var datas;
var report;
var limitDay = 14;
function dispose(){
	$("#search_div").remove();
	$("#register_tip").remove();
	$("#register_div").remove();
	$("#register_table").remove();
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
	}).datepicker("setDate" , new Date(new Date().getTime() - daytime)); 
	$("#end").datepicker({
		minDate : new Date(openTime * 1000),
		maxDate : new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate", new Date());
	
	$("#register_table").flexigrid({
   	    url : 'game_stats_mgr/get_register_report.jsp',
   	    dataType : 'json',
   	    preProcess : function(data){
   	    	datas = data;
   	 		initReport(p, data);
   	    	return data;
   	    },
   	    colModel : [{display : '日期',
   	        name : 'time',
   	        width : 100,
   	        align : 'center',
   	        customValue : getDateChinaStr
   		}, {display : '创角数',
	        name : 'createAmount',
	        width : 90,
	        align : 'center'
        }, {display : '新增数',
	        name : 'addAmount',
	        width : 90,
	        align : 'center'
        }, {display : '创角率',
	        name : 'createPercent',
	        width : 90,
	        align : 'center',
	   	    customValue : format
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
	report = new Highcharts.Chart({
		chart:{
			renderTo:'register_div',
			type: 'spline'
		},
        title: {
            text: '创角统计',
            x: -20 //center
        },
        xAxis: {
        	title: {
                text: '单位(小时) '
            },
            categories: ['01:00', '02:00', '03:00', '04:00', '05:00', '06:00',
                         '07:00', '08:00', '09:00', '10:00', '11:00', '12:00',
                         '13:00', '14:00', '15:00', '16:00', '17:00', '18:00',
                         '19:00', '20:00', '21:00', '22:00', '23:00', '24:00']
        },
        yAxis: {
        	min : 0,
        	allowDecimals : false,
            title: {
                text: '注册数 （人）'
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
            	return '<b>' + this.series.name + '</b> ' + this.x + '<br>注册数  : ' + this.y + '人';
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
	search();
	$("#select_tip").html("时间查询范围限制在 " + limitDay + " 天内！");
}
function search(){
	this.p = {};
	this.p.begin = $("#begin").datepicker("getDate");
	this.p.end = $("#end").datepicker("getDate");
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
	$("#register_table").flexOptions({
		params:[{name:'begin', value:$("#begin").val()},
		        {name:'end', value:$("#end").val()}],
		newp:1
	});
	$("#register_table").flexReload();
}
function initReport(param, data){
	current = new Date();
	var begin = param.begin.getTime();
	var end = param.end.getTime() + daytime;
	if(end > new Date().getTime()){
		end = new Date().getTime();
	}
	for(var i = begin; i <= end; i += daytime){
		if(i > end){
			i = end;
		}
		var second = i / 1000;
		for(var j = 0; j < data.rows.length; j++){
			var row = data.rows[j];
			if(row.time == second){
				report.addSeries({name:getDateChinaStr(0, 0, second), data:row.data});
				break;
			}
		}
	}
	report.hideLoading();
	$("#register_tip").html("<b>当前用户总数：</b>" + data.totalRegister + "（人）　　　　　");
}
function format(i, idx, value){
	var amount1 = datas.rows[i].createAmount;
	var amount2 = datas.rows[i].addAmount;
	if(amount1 != 0 && amount2 != 0){
		var percent = amount1 / amount2 * 100;
	    return  percent.toFixed(2) + "%";
	}
	return "0%";
}
</script>
