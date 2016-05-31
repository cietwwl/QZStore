<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,com.web.db.bean.*,com.db.util.*,java.sql.*,com.utils.*"%>
<div id="sl-systeminfo" class="sl-table">
	<div id="search_div" style="display:table;">
		<span style="float:left;">
			<select id="searchType" style="padding:2px;margin-left: 0px;">
				<option value="1">账号</option>
				<option value="2">昵称</option>
			</select>
			<input type="text" id="searchValue" style="margin-left:5px;margin-top:-5px;">
			<input style="margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="查询" onclick="searchTalismans();"/>
		</span>
	</div>
	<table id="equip_table" style="display:none"></table>
</div>
<script type="text/javascript">
var equipdatas;
function dispose(){
	$("#search_div").remove();
	$("#equip_table").remove();
	equipdatas = null;
}
function ready(){
	$("#equip_table").flexigrid({
   	    url : 'game_player_mgr/get_equip_list.jsp',
   	    dataType : 'json',
   	    preProcess : function(data){
   	    	equipdatas = data;
   	    	return data;
   	    },
   	    colModel : [{display : '自增ID',
       	        name : 'userEquipmentId',
       	        width : 50,
       	        align : 'center'
   	   		}, {display : '装备ID',
       	        name : 'equipmentId',
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
   	        },{display : '存放位置',
   	        	name : 'userHeroId',
    	        width : 100,
    	        align : 'center',
    	        customValue:function(i, idx, location){
    	        	if(location == 0){
    	        		return "背包";
    	        	}else{
    	        		return "伙伴[" + location + "]";
    	        	}
    	        }
   	        },{display : '获得时间',
      	       	name : 'createTime',
       	        width : 150,
       	        align : 'center'
      		}],
   	    usepager : true,
   	    title : '装备管理',
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
   	    	if(!showError(equipdatas) && equipdatas.playerName){
   	    		$("div.ftitle").html(" [ " + equipdatas.playerName + " ] - 装备管理");
   	    	}else{
   	    		$("div.ftitle").html("装备管理");
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
	$("#equip_table").flexOptions({
		params : [{name:'searchType', value:$("#searchType").val()},
		          {name:'searchValue', value:$("#searchValue").val()}
		         ],
		newp : 1
	});
	$("#equip_table").flexReload();
}
</script>