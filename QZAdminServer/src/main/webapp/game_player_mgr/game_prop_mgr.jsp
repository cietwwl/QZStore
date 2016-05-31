<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,com.web.db.bean.*,com.db.util.*,java.sql.*,com.utils.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + ":/"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<div id="sl-systeminfo" class="sl-table">
	<div id="search_div" style="display:table;">
		<span style="float:left;">
			<select id="searchType" style="padding:2px;margin-left: 0px;">
				<option value="1">账号</option>
				<option value="2">昵称</option>
			</select>
			<input type="text" id="searchValue" style="margin-left:5px;margin-top:-5px;">
			<input style="margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="查询" onclick="searchItems();"/>
		</span>
	</div>
	<table id="item_table" style="display:none"></table>
</div>
<script type="text/javascript">
var itemdatas;
function dispose(){
	$("#search_div").remove();
	$("#item_table").remove();
	itemdatas = null;
}
function ready(){
	$("#item_table").flexigrid({
   	    url : 'game_player_mgr/get_prop_list.jsp',
   	    dataType : 'json',
   	    preProcess : function(data){
   	    	itemdatas = data;
   	    	return data;
   	    },
   	    colModel : [{display : '自增ID',
    	        	name : 'id',
     	        width : 50,
     	        align : 'center'
  	       		}, {display : '道具ID',
       	        name : 'propId',
       	        width : 50,
       	        align : 'center'
   	   		}, {display : '名称',
    	        name : 'name',
    	        width : 90,
    	        align : 'center'
   	        }, {display : '数量',
   	        	name : 'num',
    	        width : 50,
    	        align : 'center'
   	        }, {display : '获得时间',
      	        	name : 'createTime',
       	        width : 150,
       	        align : 'center'
      	    }],
   	    usepager : true,
   	    title : '道具管理',
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
   	    	if(!showError(itemdatas) && itemdatas.playerName){
   	    		$("div.ftitle").html(" [ " + itemdatas.playerName + " ] - 道具管理");
   	    	}else{
   	    		$("div.ftitle").html("道具管理");
   	    	}
   	    }
   	});
}
function searchItems(){
	var searchValue = $("#searchValue").val();
	if(searchValue.length == 0){
		alert("请输入查询条件!");
		return;
	}
	$("#item_table").flexOptions({
		params : [{name:'searchType', value:$("#searchType").val()},
		          {name:'searchValue', value:$("#searchValue").val()}
		         ],
		newp : 1
	});
	$("#item_table").flexReload();
}
</script>