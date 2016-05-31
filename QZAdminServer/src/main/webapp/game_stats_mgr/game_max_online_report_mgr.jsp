<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search_div" style="display:table;padding:5px;">
	<span style="float: left;">
		<span id="slt_span" style="margin-left:5px;margin-top:-5px;"></span>
		<input style="margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="查询" onclick="search();"/>
		<input style="margin-left:5px;margin-top:-5px;display: none;" type="button" class="button orange small" value="下载" style="display:none;" onclick="openDownloadDialog();"/>
		<span style="float:top;color:red;margin-left:10px;margin-top:-5px;" id="select_tip"></span>
	</span>
</div>
<div id="download_div" style="display:none;">
	<table>
		<tr>
			<td align="right" style="padding:2px;width:110px;">开始日期:</td>
			<td align="left" style="padding:2px;"><input id="downbegin" /></td>
		</tr>
		<tr>
			<td align="right" style="padding:2px;">结束日期:</td>
			<td align="left" style="padding:2px;"><input id="downend" /></td>
		</tr>
	</table>
</div>
<div id="max_online_div" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
<table id="max_online_table" style="display: none"></table>
<!-- 最高在线统计  -->
<script type="text/javascript">
var p;
var datas;
var limitDay = 14;
function dispose(){
	$("#search_div").remove();
	$("#download_div").remove();
	$("#max_online_div").remove();
	$("#max_online_table").remove();
	datas = null;
	p = null;
}
function ready(){
	$("#slt_span").html("<input id='begin' />　至　 <input id='end' />");
	$("#begin").datepicker({ 
      	minDate: new Date(openTime * 1000),  
      	maxDate: new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate" , new Date(new Date().getTime() - 1 * daytime)); 
	$("#end").datepicker({ 
      	minDate: new Date(openTime * 1000),   
      	maxDate: new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate" ,(new Date));
	
	$("#downbegin").datepicker({ 
      	minDate: new Date(openTime * 1000),   
      	maxDate: new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate" ,(new Date)); 
	$("#downend").datepicker({ 
      	minDate: new Date(openTime * 1000),  
      	maxDate: new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate" ,(new Date)); 
	
	$("#max_online_table").flexigrid({
   	    url : 'game_stats_mgr/get_max_online_report.jsp',
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
   		}, {display : '最高在线',
   	        name : 'maxOnline',
   	        width : 100,
   	        align : 'center',
   		}, {display : '达到时间',
   	        name : 'maxOnlineTime',
   	        width : 100,
   	        align : 'center',
   	        customValue : getTimeStr2
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
			renderTo:'max_online_div',
			type: 'spline'
		},
        title: {
            text: '最高在线统计表（三分钟统计一次）',
            x: -20 //center
        },
        xAxis: {
            categories: []
        },
        yAxis: {
        	min : 0,
        	allowDecimals : false,
            title: {
                text: '在线数（人） '
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
            	return '<b>' + this.series.options.data[this.x].name + '</b> ' + getTimeStr1(0, 0, this.series.options.data[this.x].time / 1000) + '<br>最高人数 : ' + this.y + '人';
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
	$("#max_online_table").flexOptions({
		params:[{name:'type', value:2},
		        {name:'begin', value:$("#begin").val()},
		        {name:'end', value:$("#end").val()}],
		newp:1
	});
	$("#max_online_table").flexReload();
}
function initReport(param, data){
	var now = new Date().getTime() / 1000;
	var begin = param.begin.getTime();
	var end = param.end.getTime();
	var array=[];
	for(var i = begin; i <= end; i += daytime){
		var add = true;
		var second = i / 1000;
		for(var j = 0; j < data.length; j++){
			var row = data[j];
			if(row.time == second){
				array.push({name:getDateChinaStr(0, 0, row.time), time:row.maxOnlineTime * 1000, y:row.maxOnline});
				add = false;
				break;
			}
		}
		if(add && i <= now){
			array.push({name:getDateChinaStr(0, 0, i / 1000), time:i, y:0});
		}
	}
	report.addSeries({name:"最高在线", data:array});
	report.hideLoading();
}
function openDownloadDialog(){
	$("#downbegin").datepicker("setDate", $("#begin").datepicker("getDate"));
	$("#downend").datepicker("setDate", $("#end").datepicker("getDate"));
	$("#download_div").dialog({
		title:'下载在线数据报表',
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		buttons:{
			"取消" : function(){
				$(this).dialog("close");
			},
			"确定" : function(){
				var p = {};
				p.begin = $("#downbegin").datepicker("getDate");
				p.end = $("#downend").datepicker("getDate");
				if(p.end.getTime() < p.begin.getTime()){
					alert("结束日期不能小于开始日期");
					return;
				}
				var form = $("<form>");  
				form.attr('style','display:none');
				form.attr('target','');  
				form.attr('method','post');  
				form.attr('action','game_stats_mgr/download_max_online_report.jsp');
				var input1 = $("<input type='text' name='begin' value='" + $("#downbegin").val() + "'>");
				form.append(input1);
				var input2 = $("<input type='text' name='end' value='" + $("#downend").val() + "'>");
				form.append(input2);
				$('body').append(form); 
				form.submit();  
				form.remove();
				$(this).dialog("close");
			}
		}
	});
}
</script>