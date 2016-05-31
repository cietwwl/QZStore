<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search_div" style="display:table;padding:5px;">
	<span style="float: left;">
		<span id="slt_span" style="margin-left:5px;margin-top:-5px;"></span>
		<select id="select_minute" style="margin-left:5px;margin-top:-5px;padding: 2px;">
			<option value="3">3分钟</option>
			<option value="9">9分钟</option>
			<option value="15" selected="selected">15分钟</option>
			<option value="30">30分钟</option>
			<option value="60">60分钟</option>
		</select>
		<input style="margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="查询" onclick="search();"/>
		<span style="float:top;color:red;margin-left:10px;margin-top:-5px;" id="select_tip"></span>
	</span>
</div>
<div id="online_div" style="min-width: 400px; height: 450px; margin: 0 auto;"></div>
<div id='online_table_div'></div>
<!-- 在线统计  -->
<script type="text/javascript">
var p;
var datas;
var report;
var limitTime = 3 * 60 * 1000;
var limitDay = 14;
function dispose(){
	$("#search_div").remove();
	$("#online_div").remove();
	$("#online_table_div").remove();
	datas = null;
	report = null;
	p = null;
}
function ready(){
	$("#slt_span").html("<input id='begin' />　至　 <input id='end' />");
	$( "#begin" ).datepicker({ 
      	minDate: new Date(openTime * 1000),    
      	maxDate: new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate" ,new Date(new Date().getTime() - 1 * daytime));
	$( "#end" ).datepicker({ 
      	minDate: new Date(openTime * 1000),  
      	maxDate: new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate" ,(new Date)); 
	
	Highcharts.setOptions({  
        global: {  
            useUTC: false  
        }  
    });
	var xAxis = {};
	xAxis.categories = [];
	xAxis.tickInterval = 20;
	xAxis.startOnTick = true;
	xAxis.labels = {
        // 标签位置
        align: 'center',
        // 标签格式化
        formatter: function(){
            return getHourTimeStr(new Date(this.value).getHours());
        }
    };
	var d = new Date();
	d.setHours(0);
	d.setMinutes(0);
	d.setSeconds(0);
	d.setMilliseconds(0);
	for(var i = d.getTime() + limitTime; i < d.getTime() + daytime; i += limitTime){
		xAxis.categories.push(i);
	}
	
	report = new Highcharts.Chart({
		chart:{
			renderTo:'online_div',
			type: 'spline',
		},
        title: {
            text: '在线统计表（三分钟统计一次）',
            x: -20 //center
        },
        xAxis: xAxis,
        yAxis: {
        	min : 0,
        	allowDecimals : false,
            title: {
                text: '用户数（人）'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            formatter : function(){
            	return '<b>' + this.series.name + '</b> ' + getTimeStr1(0,0,this.x/1000) + '<br>在线人数  : ' + this.y + '人';
            }
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0,
           	labelFormatter: function () {
           		var d1 = {y:0};
           		var time = 0;
           		for(i = 0; i < report.series.length; i++){
           			var serie = report.series[i];
           			if(serie.name == this.name){
           				for(j = 0; j < serie.options.data.length; j++){
           					if(serie.options.data[j].y > d1.y){
           						d1 = serie.options.data[j];
           						time = serie.options.data[j].time;
           					}
           				}
           			}
           		}
           		var val = "[00:00]";
           		if(time > 0){
           			val = "[" + getTimeStr3(0, 0, time / 1000) + "]";
           		}
           		return this.name + " 峰值" + val + "：" + d1.y;
    		}
        },
        plotOptions: {
            spline: {
                lineWidth: 2,//粗细：lineWidth  默认值为2
                fillOpacity: 0.1,
                 marker: {
                    enabled: false,
                    states: {
                        hover: {
                            enabled: true,
                            radius: 2
                        }
                    }
                },
                shadow: false
            }
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
	p.selectTime = $("#select_minute").val();
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
	$('#online_table_div').html('<table id="online_table" style="display: none"></table>');
	$.ajax({
		url:'game_stats_mgr/get_online_report.jsp',
		type:'post',
		dataType:'json',
		cache:false,
		data:{
			type : 1,
			begin:$("#begin").val(),
			end:$("#end").val(),
			selectTime:p.selectTime
		},
		success:function(data){
		 	if(!showError(data)){
				var reportData = data.data;
	   	 		initReport(p, reportData);
	   	 		var cols = [];
	   	 		for(var i = reportData.length - 1; i >= 0; i--){
	   	 			var row = reportData[i];
	   	   	 		cols.push({display : getDateChinaStr(0, 0, row.time), name : 't' + row.time, width : 100, align : 'center'});
	   	 		}
		   	 	datas = data;
		   	 	$("#online_table").flexigrid({
	   	 			dataType:'json',
	   	    	    colModel : cols,
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
	   	 		$("#online_table").flexAddData(data);
		 	}
		}
	});
}
function initReport(param, data){
	var now = new Date().getTime() / 1000;
	var second = limitTime / 1000;
	for(var i = 0; i < data.length; i++){
		var row = data[i];
		var array=[];
		var datas = row.data;
		var times = row.date;
		for(var j = row.time + second; j < row.time + (daytime / 1000); j += second){
			var add = true;
			for(var k = 0; k < times.length; k ++){
				if(times[k] == j){
					array.push({name:getDateChinaStr(0, 0, j), time:j * 1000, y:datas[k]})
					add = false;
					break;
				}
			}
			if(add && j < now){
				array.push({name:getDateChinaStr(0, 0, j), time:j * 1000, y:0})
			}
		}
		report.addSeries({name:getDateChinaStr(0, 0, row.time), data:array});
	}
	report.hideLoading();
}
</script>