<%@page import="com.cache.SysJurisdictionCache"%>
<%@page import="com.game.constant.WebConstant"%>
<%@page import="com.web.obj.UserGroup"%>
<%@page import="com.db.util.ConnUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.web.db.bean.SysJurisdictionInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="user_jurisdiction_div" style="display:none;">
<form style="height:450px;">
	<input type="text" id="gid" style="display:none;"/>
	<span style="display: table-row;">
    <b>用户组名：</b>
	<input type="text" id="gname" style="font-weight:bold;padding:2px;" /></span>
<%
	List<SysJurisdictionInfo> jurisdictions = SysJurisdictionCache.getJurisdictions();
	for(SysJurisdictionInfo info : jurisdictions){
		if(info.getParentId() == 0){
%>
	<fieldset style="padding:3px;border:1px dashed orange;">
		<legend><input type="checkbox" name="jurisdiction" value="<%=info.getId()%>" style="margin-right:3px;vertical-align: middle;"/><b style="color: red;"><%=info.getName() %></b></legend>
<%
			for(SysJurisdictionInfo info1 : jurisdictions){
				if(info1.getParentId() == info.getId()){
%>
			<fieldset style="padding:3px;">
				<legend>
					<input type="checkbox" name="jurisdiction" value="<%=info1.getId()%>" style="margin-right:3px;vertical-align: middle;"/><%=info1.getName() %>
				</legend>
					<span style="float:left; margin-left: 20px;">
<%
					for(SysJurisdictionInfo info2 : jurisdictions){
						if(info2.getParentId() == info1.getId()){
%>
						<input type="checkbox" name="jurisdiction" value="<%=info2.getId()%>" style="margin-right:3px;margin-left:10px;vertical-align: middle;"/>
						<span><%=info2.getName() %></span>
<%
						}
					}
%>
					</span>
			</fieldset>
<%
				}
			}
%>
	</fieldset>
<%
		}
	}
%>
</form>
</div>
<table id="user_group_table"></table>
<div id="delete_tip" style="display:none;"></div>
<script type="text/javascript">
<%
UserGroup userGroup = (UserGroup)session.getAttribute("userGroup");
%>
var jurModGroup = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_MODIFY_USER_GROUP)%>;
var jurDelGroup = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_DELETE_USER_GROUP)%>;
var datas;
function dispose(){
	$("#user_jurisdiction_div").remove();
	$("#user_group_table").remove();
	$("#delete_tip").remove();
	datas = null;
}
function ready(){
	var bus = [];
	if(jurModGroup){
		bus = [{name: '添加', bclass: 'add', onpress : function(){groupHandle("添加用户组", -1)}}];
	}
	var showSel = jurDelGroup || jurModGroup;
	$("#user_group_table").flexigrid({
		url : 'system_mgr/get_user_group_list.jsp',
   	    dataType : 'json',
   		preProcess : function(data){
   			datas = data;
	    	return data;
	    },
   	 	colModel : [{display : '用户组ID',
	        name : 'id',
	        width : 50,
	        align : 'center'
		},{display : '用户组名称',
	        name : 'name',
	        width : 80,
	        align : 'center'
		},{display : '用户组类型',
			name : 'type',
	        width : 100,
	        align : 'center',
	        customValue : getUserGroupTypeName
		},{display : '用户组权限',
			name : 'jurisdictions',
	        width : 100,
	        align : 'center',
	        customValue : getHandleLink
		}],
		buttons : bus,
		usepager : true,
	    title : '用户组',
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
}
function getHandleLink(i, idx, data){
	var val = "";
	if(jurModGroup){
		var row = datas.rows[i];
		var name = "查看";
		if(row.type != 1){
			name = "修改";
		}
		val += "<a href='javascript:groupHandle(\"用户组管理\", " + i + ")'>" + name + "</a>";
	}
	if(datas.rows[i].type != 1 && jurDelGroup){
		val += "&nbsp;&nbsp;" + "<a href='javascript:deleteUserGrop(" + i + ")'>删除</a>"
	}
	return val;
}
function groupHandle(title, rowNum){
	var row = null;
	if(rowNum == -1){
		$("#gid").val("0");
		$("#gname").val("");
		$("input[name='jurisdiction']").each(function(i, dom){
			var o = $(dom);
			o.attr("checked", true);
			o.attr("disabled", false);
		});
	}else{
		row = datas.rows[rowNum];
		var jurisdictions = row.jurisdictions.split(",");
		$("input[name='jurisdiction']").each(function(i, dom){
			var o = $(dom);
			if(row.type != 1){
				o.attr("checked", false);
				o.attr("disabled", false);
				for(i = 0; i < jurisdictions.length; i++){
					if(o.val() == jurisdictions[i]){
						o.attr("checked", true);
						break;
					}
				}
			}else{
				o.attr("checked", true);
				o.attr("disabled", true);
			}
		});
		$("#gid").val(row.id);
		$("#gname").val(row.name);
	}
	if(row != null && row.type == 1){
		$("#gname").attr("disabled", true);
	}else{
		$("#gname").attr("disabled", false);
	}
	var oname = $("#gname").val();
	$("#user_jurisdiction_div").dialog({
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
				var gid = $("#gid").val();
				var gname = $.trim($("#gname").val());
				if(gname.length == 0){
					alert("用户组名称不能为空!");
					return;
				}else if(rowNum == -1 || (row != null && gname != row.name)){
					for(var i = 0; i < datas.rows.length; i++){
						if(datas.rows[i].name == gname){
							alert("目标用户组名已存在！");return;
						}
					}
				}
				var str = "";
				$("input[name='jurisdiction']:checked").each(function(i, dom){
					str = str + $(dom).val() + ",";
				});
				if(str.length > 0){
					str = str.substring(0, str.length - 1);
				}
				$.ajax({url:"system_mgr/url_user_group_save.jsp",
					data:{oname : oname,
						gid:gid,
						gname:gname,
						jurisdictions:str},
					type:"post",
					dataType:"json",
					cache:false,
					success:function(response){
						if(!showError(response)){
							$("#user_jurisdiction_div").dialog("close");
							if(gid == 0){
								alert("添加用户组成功!");
							}else{
								alert("修改用户组成功!");
							}
							$("#user_group_table").flexReload();
						}
					}
				});
			}
		}
	});
}
function deleteUserGrop(i){
	var row = datas.rows[i];
	$("#delete_tip").html("是否确定删除用户组[" + row.name + "]");
	$("#delete_tip").dialog({
		title:'删除用户组',
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		buttons:{
			"取消" : function(){
				$(this).dialog("close");
			},
			"确定" : function(){
				$.ajax({url:"system_mgr/url_user_group_delete.jsp",
					data:{gid: row.id},
					type:"post",
					dataType:"json",
					cache:false,
					success:function(response){
						if(!showError(response)){
							$("#delete_tip").dialog("close");
							alert("删除用户组成功!");
							$("#user_group_table").flexReload();
						}
					}
				});
			}
		}
	});
}
</script>