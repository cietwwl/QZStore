<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,com.web.db.bean.*,com.db.util.*,java.sql.*,com.utils.*"%>
<div id="sl-systeminfo" class="sl-table">
	<div id="search_div" style="display:table;">
		<span style="float:left;">
			<select id="searchType" style="padding:2px;margin-left: 0px;">
				<option value="1">账号</option>
				<option value="2">昵称</option>
			</select>
			<input type="text" id="searchValue" style="margin-left:5px;margin-top:-5px;">
			<input style="margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="查找" onclick="searchTalismans();"/>
		</span>
	</div>
	<table id="eternal_table" style="display:none"></table>
</div>
<script type="text/javascript">
var eternaldatas;
function dispose(){
	$("#search_div").remove();
	$("#eternal_table").remove();
	eternaldatas = null;
}
function ready(){
	$("#eternal_table").flexigrid({
   	    url : 'game_player_mgr/get_eternal_list.jsp',
   	    dataType : 'json',
   	    preProcess : function(data){
   	    	eternaldatas = data;
   	    	return data;
   	    },
   	    colModel : [{display : '自增ID',
       	        name : 'userEternalId',
       	        width : 50,
       	        align : 'center'
   	   		}, {display : '武魂ID',
       	        name : 'eternalId',
       	        width : 50,
       	        align : 'center'
   	   		}, {display : '名称',
    	        name : 'name',
    	        width : 90,
    	        align : 'center'
   	        },  { display : '星级',
    	        name : 'quality',
    	        width : 50,
    	        align : 'center',
    	        customValue:getStarName
   	        }, {display : '是否使用',
   	        	name : 'use',
    	        width : 50,
    	        align : 'center',
    	        customValue:function(i, idx, use){
    	        	if(use == 'true'){
    	        		return "是";
    	        	}else{
    	        		return "否";
    	        	}
    	        }
   	        }, {display : '获得时间',
      	        name : 'createTime',
       	        width : 150,
       	        align : 'center'
      	    }],
   	    usepager : true,
   	    title : '武魂管理',
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
   	    onSuccess:function(obj){
   	    	if(!showError(eternaldatas) && eternaldatas.playerName){
   	   	    	$("div.ftitle").html(" [ " + eternaldatas.playerName + " ] - 武魂管理");
   	    	}else{
   	    		$("div.ftitle").html("武魂管理");
   	    	}
   	    }
   	});
}
function searchTalismans(){
	var searchValue = $("#searchValue").val();
	if(searchValue.length == 0){
		alert("请输入查询条件!");
		return;
	}
	$("#eternal_table").flexOptions({
		params : [{name:'searchType', value:$("#searchType").val()},
		          {name:'searchValue', value:$("#searchValue").val()}
		],
		newp : 1
	});
	$("#eternal_table").flexReload();
}
</script>