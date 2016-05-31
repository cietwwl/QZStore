<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search_div" style="display:table;">
	<span style="float:left;">
		<span id="slt_span" style="margin-left:5px;margin-top:-5px;"></span>
		<input style="margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="查找" onclick="search();"/>
		<input style="margin-left:5px;margin-top:-5px;display:none;" type="button" class="button orange small" value="下载" onclick="download();"/>
	</span>
</div>
<table id="regist_loss_table" style="display:none"></table>
<!-- 注册流失统计  -->
<script type="text/javascript">
var datas;
var limitDay = 31;
function dispose(){
	$("#search_div").remove();
	$("#regist_loss_table").remove();
	datas = null;
}
function ready(){
	$("#slt_span").html("<input id='begin' />　至　 <input id='end' />");
	var monthFirstDate = new Date();
	monthFirstDate.setDate(1);
	if(monthFirstDate.getTime() < openTime * 1000){
		monthFirstDate = new Date(openTime * 1000);
	}
	$("#begin").datepicker({
	  	minDate: new Date(openTime * 1000),    
	  	maxDate: new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate", monthFirstDate); 
	$( "#end" ).datepicker({
	  	minDate: new Date(openTime * 1000),  
	  	maxDate: new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate", new Date); 
	
	$("#regist_loss_table").flexigrid({
		url : 'game_stats_mgr/get_regist_loss_list.jsp',
   	    dataType : 'json',
   		 preProcess : function(data){
	    	datas = data;
	    	return data;
	    },
   	 	colModel : [
   	 	            {display : '日期',name : 'time',width : 100,align : 'center',customValue:getDateStr},
   	 	            {display : '新账号数',name : 'newAmount',width : 65,align : 'center'},
   	 	            {display : '请求创角人数',name : 'requestRegistAmount',width : 70,align : 'center'},
   	 	            {display : 'LOGING1流失率',name : 'requestRegistAmount',width : 85,align : 'center',
				        customValue:function(i, idx, value){
				        	if(datas.rows[i].newAmount > 0){
				        		return ((1 - value / datas.rows[i].newAmount) * 100).toFixed(1) + "%";
				        	}else{
				        		return "0%";
				        	}
				        }
   	 	            },
   	 	            {display : '新角色人数',name : 'registAmount', width : 65,align : 'center'},
   	 	            {display : '创角流失率',name : 'registAmount',width : 80,align : 'center',
				        customValue:function(i, idx, value){
				        	if(datas.rows[i].requestRegistAmount > 0){
				        		return ((1 - value / datas.rows[i].requestRegistAmount) * 100).toFixed(1) + "%";
				        	}else{
				        		return "0%";
				        	}
				        }
   	 	            },
   	 	            {display : '进入游戏玩家数',name : 'enterAmount',width : 85, align : 'center'},
   	 	            {display : 'LOGIN2流失率',name : 'enterAmount',width : 85,align : 'center',
				        customValue:function(i, idx, value){
				        	if(datas.rows[i].registAmount > 0){
				        		return ((1 - value / datas.rows[i].registAmount) * 100).toFixed(1) + "%";
				        	}else{
				        		return "0%";
				        	}
				        }
   	 	            },
   	 	            {display : '总流失率',name : 'enterAmount',width : 65,align : 'center',
				        customValue:function(i, idx, value){
				        	if(datas.rows[i].newAmount > 0){
				        		return ((1 - value/datas.rows[i].newAmount) * 100).toFixed(1) + "%";
				        	}else{
				        		return "0%";
				        	}
				        }
					}
   	 	],
		usepager : true,
	    title : '创角流失分析',
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
	$("#regist_loss_table").flexOptions({
		params : [{name:'begintime', value:$("#begin").val()},
		          {name:'endtime', value:$("#end").val()},
			     ],
		newp:1
	});
	$("#regist_loss_table").flexReload();
}

function download(){
	var form = $("<form>");  
	form.attr('style','display:none');
	form.attr('target','');  
	form.attr('method','post');  
	form.attr('action','game_stats_mgr/download_regist_loss.jsp');
	$('body').append(form); 
	form.submit();  
	form.remove();
	
}
</script>