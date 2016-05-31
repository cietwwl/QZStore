<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search_div" style="display:table;padding:5px;">
	<span style="float:left;">
		<span id="slt_span" style="margin-left:5px;margin-top:-5px;"></span>
		<select id="select_instance" style="margin-left:5px;margin-top:-5px;padding: 2px;">
			<option value="1">闯关</option>
			<option value="2">挑战</option>
			<option value="3">试练</option>
		</select>
		<input style="margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="查询" onclick="search();"/>
		<span style="float:top;color:red;margin-left:10px;margin-top:-5px;" id="select_tip"></span>
	</span>
</div>
<table id="battle_loss_div" ></table>
<!-- 关卡流失统计  -->
<script type="text/javascript">
var limitDay = 30;
var datas;
function dispose(){
	$("#search_div").remove();
	$("#battle_loss_div").remove();
	datas = null;
}
function ready(){
	$("#slt_span").html("<input id='begin' />　至　 <input id='end' />");
	$("#begin").datepicker({ 
      	minDate: new Date(openTime * 1000), 
      	maxDate: new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate" ,new Date()); 
	$("#end").datepicker({ 
      	minDate: new Date(openTime * 1000), 
      	maxDate: new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate" ,new Date());
	
	$("#battle_loss_div").flexigrid({
	    url : 'game_stats_mgr/get_battle_loss_list.jsp',
	    dataType : 'json',
	    preProcess : function(data){
	    	datas = data;
	    	return data;
	    },
	    colModel : [{display : '关卡id',
       	        name : 'battleId',
       	        width : 70,
       	        align : 'center'
	   		}, {display : '章节id',
    	        name : 'zoneId',
    	        width : 50,
    	        align : 'center'
	        },  { display : '名称',
    	        name : 'name',
    	        width : 90,
    	        align : 'center'
	        }, {display : '首通人数',
	        	name : 'firstNum',
    	        width : 50,
    	        align : 'center'
	        }, {display : '闯关人数',
	        	name : 'countNum',
    	        width : 50,
    	        align : 'center'
	        }, {display : '战斗中流失人数',
	        	name : 'battleLossNum',
    	        width : 80,
    	        align : 'center'
	        }, {display : '战斗结束流失人数',
    	        name : 'battleEndLossNum',
    	        width : 90,
    	        sortable : true,
    	        align : 'center'
	        }, {display : '首通率',
    	        name : 'finishPassRate',
    	        width : 50,
    	        sortable : true,
    	        align : 'center',
        	    customValue : firstPass
	        }, {display : '战斗中流失率',
    	        name : 'battleLossRate',
    	        width : 80,
    	        sortable : true,
    	        align : 'center',
    	        customValue : battleLoss
	        }, {display : '战斗结束流失率',
    	        name : 'BattleEndLossRate',
    	        width : 90,
    	        sortable : true,
    	        align : 'center',
    	        customValue : endLoss
	        }, {display : '战斗总流失',
    	        name : 'battleLoss',
    	        width : 60,
    	        sortable : true,
    	        align : 'center',
    	        customValue : countLoss
	        }],
   	    usepager : true,
   	    title : '关卡流失统计',
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
	search();
	$("#select_tip").html("时间查询范围限制在 " + limitDay + " 天内！");
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
	$("#battle_loss_div").flexOptions({
		params:[{name:'type', value:$("#select_instance").val()},
		        {name:'begin', value:$("#begin").val()},
		        {name:'end', value:$("#end").val()}],
		newp:1
	});
	$("#battle_loss_div").flexReload();
}
function firstPass(i, idx, value){
	var amount1 = datas.rows[i].firstNum;
	var amount2 = datas.rows[i].countNum;
	if(amount1 > 0 && amount2 > 0){
		var percent = amount1 / amount2 * 100;
	    return percent.toFixed(2) + " %";
	}
	return "0%";
}
function battleLoss(i, idx, value){
	var amount1 = datas.rows[i].battleLossNum;
	var amount2 = datas.rows[i].countNum;
	if(amount1 > 0 && amount2 > 0){
		var percent = amount1 / amount2 * 100;
	    return percent.toFixed(2) + " %";
	}
	return "0%";
}
function endLoss(i, idx, value){
	var amount1 = datas.rows[i].battleEndLossNum;
	var amount2 = datas.rows[i].countNum;
	if(amount1 > 0 && amount2 > 0){
		var percent = amount1 / amount2 * 100;
	    return percent.toFixed(2) + " %";
	}
	return "0%";
}
function countLoss(i, idx, value){
	var amount1 = datas.rows[i].battleLossNum + datas.rows[i].battleEndLossNum;
	var amount2 = datas.rows[i].countNum;
	if(amount1 > 0 && amount2 > 0){
		var percent = amount1 / amount2 * 100;
	    return percent.toFixed(2) + " %";
	}
	return "0%";
}
</script>