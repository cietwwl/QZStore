<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,com.web.db.bean.*,com.db.util.*,java.sql.*,com.utils.*"%>
<div id="sl-systeminfo" class="sl-table">
	<div id="search_div" style="display:table;">
		<span style="float:left;">
			<select id="searchType" style="padding:2px;margin-left: 0px;">
				<option value="1">账号</option>
				<option value="2">昵称</option>
			</select>
			<input type="text" id="searchValue" style="margin-left:5px;margin-top:-5px;">
			<input style="margin-left:5px;margin-top:-5px;" type="button"  class="button orange small" value="查询" onclick="searchTalismans();"/>
		</span>
	</div>
	<table id="hero_table" style="display:none"></table>
</div>
<script type="text/javascript">
var herodatas;
function dispose(){
	$("#search_div").remove();
	$("#hero_table").remove();
	herodatas = null;
}
function ready(){
	$("#hero_table").flexigrid({
   	    url : 'game_player_mgr/get_hero_list.jsp',
   	    dataType : 'json',
   	    preProcess : function(data){
   	    	herodatas = data;
   	    	return data;
   	    },
   	    colModel : [{display : '自增ID',
       	        name : 'id',
       	        width : 50,
       	        align : 'center'
   	   		}, {display : '伙伴ID',
       	        name : 'heroId',
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
   	        }, {display : '等级',
   	        	name : 'level',
    	        width : 50,
    	        align : 'center'
   	        }, {display : '经验',
   	        	name : 'exp',
    	        width : 80,
    	        align : 'center'
   	        }, {display : '突破等级',
   	        	name : 'breakLevel',
    	        width : 50,
    	        align : 'center'
   	        },{display : '携带武魂',
   	        	name : 'eternal',
    	        width : 80,
    	        align : 'center',
    	        customValue:function(i, idx, val){
    	        	if(val == 0){
    	        		return "无";
    	        	}else{
    	        		return "武魂[" + val + "]";
    	        	}
    	        }
   	        }, {display : '获得时间',
   	        	name : 'createTime',
    	        width : 150,
    	        align : 'center'
   	        }],
   	    usepager : true,
   	    title : '伙伴管理',
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
   	    	if(!showError(herodatas) && herodatas.playerName){
   	    		$("div.ftitle").html(" [ " + herodatas.playerName + " ] - 伙伴管理");
   	    	}else{
   	    		$("div.ftitle").html("伙伴管理");
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
	$("#hero_table").flexOptions({
		params : [{name:'searchType', value:$("#searchType").val()},
		          {name:'searchValue', value:$("#searchValue").val()}
		],
		newp : 1
	});
	$("#hero_table").flexReload();
}
</script>