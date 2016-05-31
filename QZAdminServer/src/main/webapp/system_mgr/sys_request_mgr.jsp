<%@page import="com.cache.SysJurisdictionCache"%>
<%@page import="com.game.constant.WebConstant"%>
<%@page import="com.web.obj.UserGroup"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="com.web.db.bean.SysJurisdictionInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="request_dialog" style="display:none;">
	<table>
		<tr>
			<td align="right">请求权限:</td>
			<td align="left">
				<select id="jurisdictionId" style="padding: 2px;margin-left: 5px;" onchange="selJur();">
					<option value="-1">无限制</option>
				<%
					List<SysJurisdictionInfo> list = SysJurisdictionCache.getJurisdictions();
					for(SysJurisdictionInfo ju : list){
						if(ju.getId() % 100000 == 0){
							continue;
						}
				%>
					<option value="<%=ju.getId() %>"><%=ju.getId() %>-<%=ju.getName() %></option>
				<%
					}
				%>
				</select>
			</td>
		</tr>
		<tr>
			<td align="right">请求ID:</td>
			<td align="left"><input type="text" id="id" value="0" style="margin-left: 5px;"></td>
		</tr>
		<tr>
			<td align="right">请求名称:</td>
			<td align="left">
				<input type="text" style="margin-left: 5px;" id="name" />
			</td>
		</tr>
		<tr>
			<td align="right">请求地址:</td>
			<td align="left">
				<input type="text" style="width: 400px;margin-left: 5px;" id="url" />
			</td>
		</tr>
	</table>
</div>
<table id="request_table"></table>
<div id="delete_request_tip" style="display:none;"></div>
<script type="text/javascript">
<%
UserGroup userGroup = (UserGroup)session.getAttribute("userGroup");
%>
var jurModRequest = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_MODIRY_REQUEST_JURISDICTION)%>;
var jurDelRequest = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_DELETE_REQUEST_JURISDICTION)%>;
var datas;
var jids = [];
var jnames = [];
<%
	for(int i = 0; i < list.size(); i++){
		SysJurisdictionInfo info = list.get(i);
		%>
		jids[<%=i%>] = <%=info.getId()%>;
		jnames[<%=i%>] = "<%=info.getName()%>";
		<%
	}
%>
function dispose(){
	$("#request_table").remove();
	$("#request_dialog").remove();
	$("#delete_request_tip").remove();
	datas = null;
	jids = null;
	jnames = null;
}
function ready(){
	var bus = [];
	if(jurModRequest){
		bus = [{name: '添加', bclass: 'add', onpress : function(){requestHandle("创建请求", -1);}}];
	}
	var showSel = jurModRequest || jurDelRequest;
	$("#request_table").flexigrid({
		url : 'system_mgr/get_request_list.jsp',
   	    dataType : 'json',
   		preProcess : function(data){
   			datas = data;
	    	return data;
	    },
   	 	colModel : [{display : '请求ID',
			name : 'id',
	        width : 50,
	        align : 'center'
		},{display : '请求名称',
	        name : 'name',
	        width : 150,
	        align : 'center',
	        customValue : function(i, idx, value){
	        	var row = datas.rows[i];
	        	if(row.id == 0){
   	        		return "";
   	        	}else if(row.id % 100 == 0){
   	        		return "<b style='color: red;'>" + value + "</b>";
   	        	}else{
   	        		return value;
   	        	}
	        }
		},{display : '链接地址',
			name : 'url',
	        width : 300,
	        align : 'left'
		},{display : '权限',
			name : 'jurisdictionId',
	        width : 100,
	        align : 'center',
	        customValue : getJurisName
		},{display : '操作',
			name : 'id',
	        width : 100,
	        align : 'center',
	        customValue:function(i, idx, value){
	        	var val = "";
	        	if(jurModRequest){
	        		val += "<a href='javascript:requestHandle(\"修改请求\", " + i + ");'>修改</a>";
	        	}
	        	if(jurDelRequest){
	        		val += "&nbsp;&nbsp;<a href='javascript:delRequest(" + i + ");'>删除</a>";
	        	}
	        	return val
	        }
		}],
		buttons : bus,
		usepager : true,
	    title : '请求权限管理',
	    useRp : false,
	    rp : tableRp,
	    width : tableWidth,
	    height : tableHeight,
	    page: 1,
	    total: 1,
	    resizable: false,
	    autoload: true,
	    procmsg:'加载中，請稍後…',
	    singleSelect:true,
   	 	showToggleBtn : showSel,
 		onSuccess : function(obj){
	 		showError(datas);
	    }
	});
};
function delRequest(i){
	var req = datas.rows[i];
	$("#delete_request_tip").html("您确定要删除请求权限 [ " + req.id + " ] " + req.name + " 吗?");
	$("#delete_request_tip").dialog({
		title:'删除请求权限',
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		buttons:{
			"取消" : function(){
				$(this).dialog("close");
			},
			"确定" : function(){
				$.ajax({
					 url : "system_mgr/url_request_delete.jsp",
					 dataType : 'json',
					 data : {
						 id : req.id
					 },
					 cache : false,
					 type:"post",
					 success:function(response){
						 if(!showError(response)){
							 $("#delete_request_tip").dialog("close");
							 alert("删除请求权限成功!");
							 $("#request_table").flexReload();
						 }
					 }
				});
			}
		}
	});
}

function requestHandle(title, rowNum){
	var req = null;
	if(rowNum == -1){
		$("#id").val(0);
		$("#name").val("");
		$("#url").val("");
		$("#jurisdictionId").val(-1);
	}else{
		req = datas.rows[rowNum];
		$("#id").val(req.id);
		$("#name").val(req.name);
		$("#url").val(req.url);
		$("#jurisdictionId").val(req.jurisdictionId);
	}
	var oid = $("#id").val();
	$("#request_dialog").dialog({
		title : title,
		width:500,
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		buttons:{
			"取消" : function(){
				$(this).dialog("close");
			},
			"确定" : function(){
				var id = $("#id").val();
				var name = $.trim($("#name").val());
				var url = $.trim($("#url").val());
				var jurisdictionId = $.trim($("#jurisdictionId").val());
				if(name.length == 0 || url.length == 0){
					alert("请求名称和链接地址不能为空!");
					return;
				}else if(req != null && id != req.id){
					for(var i = 0; i < datas.rows.length; i++){
						if(datas.rows[i].id == id){
							alert("目标ID已存在！");return;
						}
					}
				}
				$.ajax({
					 url : "system_mgr/url_request_save.jsp",
					 dataType : 'json',
					 data : {oid : oid,
						 id:id,
						 name:name,
						 url:url,
						 jurisdictionId : jurisdictionId,
						 rowNum : rowNum
					 },
					 cache : false,
					 type:"post",
					 success:function(response){
						 if(!showError(response)){
							 $("#request_dialog").dialog("close");
							 if(rowNum == -1){
								 alert("创建请求成功!");
							 }else{
								 alert("修改请求成功!");
							 }
							 $("#request_table").flexReload();
						 }
					 }
				});
			}
		}
	});
}
function getJurisName(i, idx, value){
	if(value == -1){
		return "无限制";
	}
	for(var i = 0; i < jids.length; i++){
		if(value == jids[i]){
			return jnames[i];
		}
	}
	return "<b style='color: red;'>找不到权限</b>";
}
function selJur(){
	var val = $("#jurisdictionId").val();
	if(val == -1){
		$("#id").val(0);
		$("#name").val("");
	}else{
		for(var i = 0; i < jids.length; i++){
			if(val == jids[i]){
				$("#id").val(jids[i]);
				$("#name").val(jnames[i]);
				break;
			}
		}
	}
}
</script>