<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="search_div" style="display:table;">
	<input style="float:left;margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="下载" onclick="download();"/>
</div>
<div id="sl-systeminfo" class="sl-table">
	<table id="mission_loss" style="display:none"></table>
</div>
<script type="text/javascript">
function dispose(){
	$("#mission_loss").remove();
}
var missiondatas;
function ready(){
	$("#mission_loss").flexigrid({
	    url : 'game_stats_mgr/get_mission_loss_list.jsp',
	    dataType : 'json',
	    preProcess : function(data){
	    	missiondatas = data;
	    	return data;
	    },
	    colModel : [{display : '任务Id',
       	        name : 'id',
       	        width : 50,
       	        align : 'center'
	   		}, {display : '任务名称',
    	        name : 'name',
    	        width : 90,
    	        align : 'center'
	        },  { display : '任务类型',
    	        name : 'type',
    	        width : 90,
    	        align : 'center',
    	        customValue:getMissionTypeName
	        }, {display : '任务等级',
	        	name : 'level',
    	        width : 50,
    	        align : 'center'
	        }, {display : '接受数量',
	        	name : 'acceptAmount',
    	        width : 50,
    	        align : 'center'
	        }, {display : '达成数量',
	        	name : 'reachAmount',
    	        width : 50,
    	        align : 'center'
	        }, {display : '提交数量',
    	        name : 'finishAmount',
    	        width : 50,
    	        sortable : true,
    	        align : 'center'
	        }],
	    usepager : true,
	    title : '任务流失',
	    useRp : true,
	    rp : tableRp,
	    width : tableWidth,
	    height : tableHeight,
	    page: 1,
	    total: 1,
	    resizable: false,
	    autoload: false,
	    procmsg:'加载中，請稍後…',
	    singleSelect:true,
	    autoload:true
	});
}
function download(){
	var form = $("<form>");  
	form.attr('style','display:none');
	form.attr('target','');  
	form.attr('method','post');  
	form.attr('action','game_stats_mgr/download_mission_loss.jsp');
	$('body').append(form); 
	form.submit();  
	form.remove();
	//$(this).dialog("close");
}
</script>