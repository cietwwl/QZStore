<%@page import="com.game.constant.WebConstant"%>
<%@page import="com.web.obj.UserGroup"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu_div" style="display:none;">
	<input type="text" id="oid" style="display:none;"/>
	<table  style="width:400px;margin:auto;">
			<tr style="text-align:center">
				<td align="right">父菜单ID:</td>
				<td align="left" colspan="3"><input type="text" id="parentId" style="width:330px;"/></td>
			</tr>
			<tr style="text-align:center">
				<td align="right">菜单ID:</td>
				<td align="left" colspan="3"><input type="text" id="id" style="width:330px;"/></td>
			</tr>
			<tr style="text-align:center">
				<td align="right">菜单名称:</td>
				<td align="left" colspan="3"><input type="text" id="name" style="width:330px;"/></td>
			</tr>
			<tr style="text-align:center">
				<td align="right">链接地址:</td>
				<td align="left" colspan="3"><input type="text" id="url" style="width:330px;"/></td>
			</tr>
	</table>
</div>
<table id="menu_table"></table>
<div id="delete_menu_tip" style="display:none;"></div>
<script type="text/javascript">
<%
UserGroup userGroup = (UserGroup)session.getAttribute("userGroup");
%>
var jurModMenu = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_MODIFY_MENU)%>;
var jurStoMenu = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_STOP_MENU)%>;
var jurDelMenu = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_DELETE_MENU)%>;
var datas;
function dispose(){
	$("#menu_table").remove();
	$("#delete_menu_tip").remove();
	$("#menu_div").remove();
	datas = null;
}
function ready(){
	var bus = [];
	if(jurModMenu){
		bus = [{name: '添加', bclass: 'add', onpress : function(){menuHandle("添加菜单", -1);}}];
	}
	var showSel = jurModMenu || jurStoMenu || jurDelMenu;
	$("#menu_table").flexigrid({
		url : 'system_mgr/get_menu_list.jsp',
   	    dataType : 'json',
   		preProcess : function(data){
   			datas = data;
	    	return data;
	    },
   	 	colModel : [{display : '父菜单ID',
			name : 'parentId',
	        width : 100,
	        align : 'center'
		},{display : '菜单ID',
	        name : 'id',
	        width : 80,
	        align : 'center'
		},{display : '链接地址',
			name : 'url',
	        width : 250,
	        align : 'center'
		},{display : '菜单名称',
	        name : 'name',
	        width : 150,
	        align : 'center'
		},{display : '启用',
	        name : 'enable',
	        width : 50,
	        align : 'center',
	        customValue : function(i, idx, value){
	        	if(value == 1){
	        		return "是";
	        	}else{
	        		return "停用中...";
	        	}
	        }
		},{display : '操作',
			name : 'id',
	        width : 150,
	        align : 'center',
	        customValue : getMenuHandlerLink
		}],
		buttons : bus,
		usepager : true,
	    title : '菜单管理',
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
function getMenuHandlerLink(i, idx, id){
	var data = datas.rows[i];
	if(data.userGroupType != 1){
		var val = "停用";
		if(data.enable != 1){
			val = "启用";
		}
		var value = "";
		if(jurStoMenu){
			value += "<a href='javascript:enableMenu(" + data.id + ")'>" + val + "</a>";
		}
		if(jurModMenu){
			value += "&nbsp;&nbsp;<a href='javascript:menuHandle(\"修改菜单信息\", " + i + ")'>修改</a>";
		}
		if(jurDelMenu){
			value += "&nbsp;&nbsp;<a href='javascript:deleteMenu(" + data.id + ",\"" + data.name + "\")'>删除</a>";
		}
		return value;
	}else{
		return "";
	}
}
function menuHandle(title, rowNum){
	var row = null;
	if(rowNum == -1){
		$("#oid").val("0");
		$("#id").val("0");
		$("#name").val("");
		$("#url").val("");
		$("#parentId").val("0");
	}else{
		row = datas.rows[rowNum];
		$("#oid").val(row.id);
		$("#id").val(row.id);
		$("#name").val(row.name);
		$("#url").val(row.url);
		$("#parentId").val(row.parentId);
	}
	$("#menu_div").dialog({
		title : title,
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		width:600,
		buttons:{
			"取消" : function(){
				$(this).dialog("close");
			},
			"确定" : function(){
				var oid = $("#oid").val();
				var id = $("#id").val();
				var name = $.trim($("#name").val());
				var url = $("#url").val();
				var parentId = $("#parentId").val();
				var enable = 0;
				if(id == 0){
					alert("菜单id不能为0!");
					return;
				}else if(name.length == 0){
					alert("菜单名称不能为空!");
					return;
				}else if(row != null){
					if(id != row.id){
						for(var i = 0; i < datas.rows.length; i++){
							if(datas.rows[i].id == id){
								alert("目标ID已存在！");return;
							}
						}
					}
					enable = row.enable;
				}
				$.ajax({url:"system_mgr/url_menu_save.jsp",
					data:{id:id,
						name:name,
						url:url,
						parentId:parentId,
						oid:oid,
						enable : enable},
					type:"post",
					dataType:"json",
					cache:false,
					success:function(response){
						if(!showError(response)){
							$("#menu_div").dialog("close");
							if(oid == 0){
								alert("添加菜单成功!");
							}else{
								alert("修改菜单成功!");
							}
							$("#menu_table").flexReload();
						}
					}
				});
			}
		}
	});
}

function deleteMenu(id, name){
	$("#delete_menu_tip").html("是否确定删除菜单[" + name + "]");
	$("#delete_menu_tip").dialog({
		title:'删除用户',
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		buttons:{
			"取消" : function(){
				$(this).dialog("close");
			},
			"确定" : function(){
				$.ajax({url:"system_mgr/url_menu_delete.jsp",
					data:{id:id},
					type:"post",
					dataType:"json",
					cache:false,
					success:function(response){
						if(!showError(response)){
							$("#delete_menu_tip").dialog("close");
							alert("删除菜单成功!");
							$("#menu_table").flexReload();
						}
					}
				});
			}
		}
	});
}

function enableMenu(id){
	$.ajax({url:"system_mgr/url_menu_enable.jsp",
		data:{id:id},
		type:"post",
		dataType:"json",
		cache:false,
		success:function(response){
			if(!showError(response)){
				for(var i = 0; i < datas.rows.length; i++){
					var row = datas.rows[i];
					if(row.id == response.oid){
						row.enable = response.enable;
						break;
					}
				}
				$("#menu_table").flexAddData(datas);
			}
		}
	});
}
</script>