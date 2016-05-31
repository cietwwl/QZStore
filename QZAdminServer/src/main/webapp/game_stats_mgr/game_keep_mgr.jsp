<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search_div" style="display:table;">
	<span style="float:left;">
		<select id="type" style="padding: 2px;">
			<option value="1">创角数</option>
			<option value="2">新账号数</option>
		</select>
		<span id="slt_span" style="margin-left:5px;margin-top:-5px;"></span>
		<input style="margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="查询" onclick="search();"/>
		<input style="margin-left:5px;margin-top:-5px;display:none;" type="button" class="button orange small" value="下载" onclick="download();"/>
	</span>
</div>
<table id="login_loss_list1" style="display:none"></table>
<table id="login_loss_list2" style="display:none"></table>
<!-- 留存统计  -->
<script type="text/javascript">
var datas;
function dispose(){
	$("#search_div").remove();
	$("#login_loss_list1").remove();
	$("#login_loss_list2").remove();
	datas = null;
}
function ready(){
	$("#slt_span").html("<input id='begintime' />　至　 <input id='endtime' />");
	var nowDate = new Date();
	nowDate.setDate(1);
	var monthFirstDate = nowDate;
	var openDate = new Date(openTime * 1000);
	if(monthFirstDate.getTime() < openDate.getTime()){
		monthFirstDate = openDate;
	}
	$("#begintime").datepicker({
		minDate: new Date(openTime * 1000),
	  	maxDate: new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate" , monthFirstDate); 
	$("#endtime").datepicker({
		minDate: new Date(openTime * 1000),
	  	maxDate: new Date(),
	    hideIfNoPrevNext: true
	}).datepicker("setDate" ,new Date); 
	
	$("#login_loss_list1").flexigrid({
		url : 'game_stats_mgr/get_keep_list.jsp',
   	    dataType : 'json',
   		 preProcess : function(data){
	    	datas = data;
	    	return data;
	    },
   	 	colModel : [{display : '日期',
	        name : 'time',
	        width : 100,
	        align : 'center',
	        customValue:getDateStr
		},{display : '创角数',
			name : 'regist',
	        width : 65,
	        align : 'center',
		},{display : '1日留存率',
			name : 'keep1',
	        width : 65,
	        align : 'center',
	        customValue:formatKeep1
		},{display : '2日留存率',
			name : 'keep2',
	        width : 65,
	        align : 'center',
	        customValue:formatKeep1
		},{display : '3日留存率',
			name : 'keep3',
	        width : 65,
	        align : 'center',
	        customValue:formatKeep1
		},{display : '4日留存率',
			name : 'keep4',
	        width : 65,
	        align : 'center',
	        customValue:formatKeep1
		},{display : '5日留存率',
			name : 'keep5',
	        width : 65,
	        align : 'center',
	        customValue:formatKeep1
		},{display : '6日留存率',
			name : 'keep6',
	        width : 65,
	        align : 'center',
	        customValue:formatKeep1
		},{display : '7日留存率',
			name : 'keep7',
	        width : 65,
	        align : 'center',
	        customValue:formatKeep1
		},{display : '15日留存率',
			name : 'keep15',
	        width : 65,
	        align : 'center',
	        customValue:formatKeep1
		},{display : '30日留存率',
			name : 'keep30',
	        width : 65,
	        align : 'center',
	        customValue:formatKeep1
		}],
		usepager : true,
	    title : '留存统计分析',
	    useRp : true,
	    rp : 31,
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
	
	$("#login_loss_list2").flexigrid({
		url : 'game_stats_mgr/get_keep_list.jsp',
   	    dataType : 'json',
   		 preProcess : function(data){
	    	datas = data;
	    	return data;
	    },
   	 	colModel : [{display : '日期',
	        name : 'time',
	        width : 100,
	        align : 'center',
	        customValue:getDateStr
		},{display : '新账号数',
			name : 'newAmount',
	        width : 65,
	        align : 'center',
		},{display : '1日留存率',
			name : 'keep1',
	        width : 65,
	        align : 'center',
	        customValue:formatKeep2
		},{display : '2日留存率',
			name : 'keep2',
	        width : 65,
	        align : 'center',
	        customValue:formatKeep2
		},{display : '3日留存率',
			name : 'keep3',
	        width : 65,
	        align : 'center',
	        customValue:formatKeep2
		},{display : '4日留存率',
			name : 'keep4',
	        width : 65,
	        align : 'center',
	        customValue:formatKeep2
		},{display : '5日留存率',
			name : 'keep5',
	        width : 65,
	        align : 'center',
	        customValue:formatKeep2
		},{display : '6日留存率',
			name : 'keep6',
	        width : 65,
	        align : 'center',
	        customValue:formatKeep2
		},{display : '7日留存率',
			name : 'keep7',
	        width : 65,
	        align : 'center',
	        customValue:formatKeep2
		},{display : '15日留存率',
			name : 'keep15',
	        width : 65,
	        align : 'center',
	        customValue:formatKeep2
		},{display : '30日留存率',
			name : 'keep30',
	        width : 65,
	        align : 'center',
	        customValue:formatKeep2
		}],
		usepager : true,
	    title : '留存统计分析',
	    useRp : true,
	    rp : 31,
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
function formatKeep1(i, idx, value){
	if(value == -1){
		return "未统计";
	}
	var amount = datas.rows[i].regist;
	if(value > 0 && amount > 0){
		var percent = value / amount * 100;
	    return value + " （" + percent.toFixed(2) + "%）";
	}
	return "0 （0% ）";
}
function formatKeep2(i, idx, value){
	if(value == -1){
		return "未统计";
	}
	var amount = datas.rows[i].newAmount;
	if(value > 0 && amount > 0){
		var percent = value / amount * 100;
	    return value + " （" + percent.toFixed(2) + "%）";
	}
	return "0 （0% ）";
}
function search(){
	params = [
	          {name:'begintime', value:$("#begintime").val()},
	          {name:'endtime', value:$("#endtime").val()},
	         ];
	var type = $("#type").val();
	if(type == 1){
		$("#login_loss_list2").flexOptions({
			hide:true,
			params:params,
			newp:1
		});
		$("#login_loss_list1").flexOptions({
			hide:false,
			params:params,
			newp:1
		});
		$("#login_loss_list1").flexReload();
	}else{
		$("#login_loss_list1").flexOptions({
			hide:true,
			params:params,
			newp:1
		});
		$("#login_loss_list2").flexOptions({
			hide:false,
			params:params,
			newp:1
		});
		$("#login_loss_list2").flexReload();
	}
}
function download(){
	var form = $("<form>");  
	form.attr('style','display:none');
	form.attr('target','');  
	form.attr('method','post');  
	form.attr('action','game_stats_mgr/download_keep.jsp');
	$('body').append(form); 
	form.submit();  
	form.remove();
}

</script>