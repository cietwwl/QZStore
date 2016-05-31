<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search_div" style="display:table;">
	<span style="float:left;">
		<span id="lastupdatetime"></span>
		<input style="float:left;margin-left:5px;margin-top:-5px;display:none;" type="button" class="button orange small" value="下载" onclick="download();"/>
	</span>
	<span style="float:top;color:red;margin-left:10px;margin-top:-5px;" id="select_tip"></span>
</div>
<table id="level_loss_list" style="display:none"></table>
<!-- 等级流失统计  -->
<script type="text/javascript">
var datas;
function dispose(){
	$("#search_div").remove();
	$("#level_loss_list").remove();
	datas = null;
}
function ready(){	
	$("#level_loss_list").flexigrid({
		url : 'game_stats_mgr/get_level_loss_list.jsp',
   	    dataType : 'json',
   		 preProcess : function(data){
	    	datas = data;
	    	if(datas.rows.length > 0){
				$("#lastupdatetime").html("上次更新时间：" + getTimeStr(0,0,datas.rows[0].time));
			}
	    	return data;
	    },
   	 	colModel : [{display : '等级',
	        name : 'level',
	        width : 40,
	        align : 'center'
		},{display : '处于该等级人数',
			name : 'levelAmount',
	        width : 80,
	        align : 'center'
		},{display : '超过该等级人数',
			name : 'reachLevelAmount',
	        width : 85,
	        align : 'center'
		},{display : '总角色人数',
			name : 'registAmount',
	        width : 60,
	        align : 'center'
		},{display : '流失人数(今日未登录)',
			name : 'lossAmount',
	        width : 140,
	        align : 'center'
		},{display : '流失人数/超过该等级人数',
			name : 'lossAmount',
	        width : 185,
	        align : 'center',
	        customValue:function(i, idx, value){
	        	if(datas.rows[i].reachLevelAmount > 0){
	        		return (value / datas.rows[i].reachLevelAmount * 100).toFixed(2) + "%";
	        	}else{
	        		return "0%";
	        	}
	        }
		},{display : '流失人数/总角色人数',
			name : 'lossAmount',
	        width : 160,
	        align : 'center',
	        customValue:function(i, idx, value){
	        	if(datas.rows[i].registAmount > 0){
	        		return (value / datas.rows[i].registAmount * 100).toFixed(2) + "%";
	        	}else{
	        		return "0%";
	        	}
	        }
		}],
		usepager : false,
	    title : '等级流失分析',
	    useRp : false,
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
	$("#select_tip").html("每五分钟更新一次数据　");
}
function search(){
	$("#level_loss_list").flexReload();
}

function download(){
	var form = $("<form>");  
	form.attr('style','display:none');
	form.attr('target','');  
	form.attr('method','post');  
	form.attr('action','game_stats_mgr/download_level_loss.jsp');
	$('body').append(form); 
	form.submit();  
	form.remove();
}
</script>