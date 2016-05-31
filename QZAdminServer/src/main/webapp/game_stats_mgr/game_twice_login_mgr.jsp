<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search_div" style="display:table;padding:5px;">
	<span style="float: left;">
		<span id="slt_span" style="margin-left:5px;margin-top:-5px;"></span>
		<input style="margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="查询" onclick="search();"/>
		<span style="float:top;color:red;margin-left:10px;margin-top:-5px;" id="select_tip"></span>
	</span>
</div>
<div id="twice_login_div" style="min-width: 400px; height: 450px; margin: 0 auto;"></div>
<table id='twice_login_table' style="display: none"> </table>
<!-- 二次登录统计  -->
<script type="text/javascript">
var datas;
var report;
var limitDay = 30;
function dispose(){
	$("#search_div").remove();
	$("#twice_login_div").remove();
	$("#twice_login_table").remove();
	report = null;
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

	$("#twice_login_table").flexigrid({
   	    url : 'game_stats_mgr/get_twice_login_list.jsp',
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
   		}, {display : '二次登录数',
   	        name : 'twiceNum',
   	        width : 80,
   	        align : 'center'
   		}, {display : '新增用户数',
   	        name : 'newUser',
   	        width : 80,
   	        align : 'center'
   		}, {display : '二次登录率',
   	        name : 'twiceRate',
   	        width : 80,
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
			renderTo:'twice_login_div',
			type: 'spline',
		},
        title: {
            text: '二次登录统计表',
            x: -20 //center
        },
        xAxis: {
        	categories : []
        },
        yAxis: {
        	min : 0,
            title: {
                text: '百分比'
            }, plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }], labels : {
            	formatter : function(){
            		return this.value + " %";
           		}
            }
        },
        tooltip: {
            formatter : function(){
            	return '<b>' + getDateChinaStr(0, 0, this.series.options.data[this.x].time / 1000) + '</b><br> '  + this.series.name + '：' + this.y + '%';
            }
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        credits:{enabled:false},
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
		report.series[j].destroy();
	}
	report.showLoading();
	$("#twice_login_table").flexOptions({
		params:[{name:'begin', value:$("#begin").val()},
		        {name:'end', value:$("#end").val()}],
		newp:1
	});
	$("#twice_login_table").flexReload();
}
function initReport(data){
	var array=[];
	for(var i = 0; i < data.length; i++){
		var row = data[i];
		if(row.newUser > 0 && row.twiceNum > 0){
			var twiceRate = row.twiceNum / row.newUser * 100;
			array.push({name:getDateChinaStr(0, 0, row.time), time:row.time * 1000, y:twiceRate.toFixed(2) / 1});
		}else{
			array.push({name:getDateChinaStr(0, 0, row.time), time:row.time * 1000, y:0});
		}
	}
	report.addSeries({name:'二次登录率', data:array});
	report.hideLoading();
}
function format(i, idx, value){
	var amount1 = datas.rows[i].twiceNum;
	var amount2 = datas.rows[i].newUser;
	if(amount1 != 0 && amount2 != 0){
		var percent = amount1 / amount2 * 100;
	    return  percent.toFixed(2) + " %";
	}
	return "0 %";
}
</script>