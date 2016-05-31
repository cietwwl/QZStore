<%@page import="com.cache.SysUserCache"%>
<%@page import="com.game.constant.WebConstant"%>
<%@page import="com.web.obj.UserGroup"%>
<%@page import="com.web.db.bean.SysUserGroupInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="user_div" style="display:none;">
	<input type="text" id="uid" value="0" style="display:none;" />
	<table style="width:400px;">
		<tr>
			<td align="right">用户组:</td>
			<td align="left">
				<select id="userGroupId" style="padding:2px;float:left;margin-left:0px;">
				<%
					List<SysUserGroupInfo> groups = SysUserCache.getUserGroupInfos();
					for(SysUserGroupInfo group : groups){
						if(group.getType() != 1){
				%>
					<option value="<%=group.getId()%>"><%=group.getName() %></option>
				<%
						}
					}
				%>
				</select>
			</td>
		</tr>
		<tr>
			<td align="right">用户名称:</td>
			<td align="left"><input type="text" id="username"/> <span id="sp_tip" style="margin-left:5px;margin-top:-5px;color:red;display:none;">不修改密码为空</span></td>
		</tr>
		<tr>
			<td align="right">用户密码:</td>
			<td align="left">
				<span>
				<input type="password" id="password"/>
				<input id="show_password">
				<input id="show_box" type="checkbox" style="vertical-align:middle; margin:5px; padding:2" onclick="showPassword();"><label style="vertical-align:middle;" for="show_box">显示密码</label>
				</span>
			</td>
		</tr>
		<tr>
			<td align="right"><span id="note_name">备注:</span></td>
			<td align="left">
				<textarea id="note_text" rows="3" cols="60" style="margin-left: 0px;"></textarea>
			</td>
		</tr>
	</table>
</div>
<div id="del_user_div" style="display:none;"></div>
<table id="user_table"></table>
<script type="text/javascript">
<%
UserGroup userGroup = (UserGroup)session.getAttribute("userGroup");
%>
var jurModUser = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_MODIFY_USER)%>;
var jurDelUser = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_DELETE_USER)%>;
var jurSupUser = <%=userGroup.getType() == 1%>
var datas;
function dispose(){
	$("#user_table").remove();
	$("#del_user_div").remove();
	$("#user_div").remove();
	datas = null;
}
function ready(){
	var bus = []
	if(jurModUser){
		bus = [{name: '添加', bclass: 'add', onpress : function(){userHandle("添加用户", -1);}}];
	}
	var showSel = jurDelUser || jurModUser;
	$("#user_table").flexigrid({
		url : 'system_mgr/get_user_list.jsp',
   	    dataType : 'json',
   		preProcess : function(data){
   			datas = data;
	    	return data;
	    },
   	 	colModel : [{display : '用户ID',
	        name : 'id',
	        width : 50,
	        align : 'center'
		},{display : '用户名称',
	        name : 'username',
	        width : 80,
	        align : 'center'
		},{display : '用户组类型',
			name : 'userGroupType',
	        width : 100,
	        align : 'center',
	        customValue : getUserGroupTypeName
		},{display : '用户组',
			name : 'userGroupName',
	        width : 100,
	        align : 'center'
		},{display : '操作',
			name : 'id',
	        width : 100,
	        align : 'center',
	        customValue : getUserHandlerLink
		},{display : '备注',
			name : 'note',
	        width : 200,
	        align : 'center'
		}],
		buttons : bus,
		usepager : true,
	    title : '用户列表',
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
function getUserHandlerLink(i, idx, id){
	var val = "";
	if(datas.rows[i].userGroupType != 1){
		if(jurModUser){
			val += "<a href='javascript:userHandle(\"修改用户信息\", " + i + ")'>修改</a>";
		}
		if(jurDelUser){
			val += "&nbsp;&nbsp;<a href='javascript:deleteUser(" + i + ")'>删除</a>";
		}
	}
	return val;
}
function userHandle(title, rowNum){
	var row = null;
	if(rowNum == -1){
		$("#uid").val(0);
		$("#username").val("");
		$("#userGroupId").val("");
	}else{
		row = datas.rows[rowNum];
		$("#uid").val(row.id);
		$("#username").val(row.username);
		$("#userGroupId").val(row.userGroupId);
	}
	$("#password").val("");
	$("#show_password").val("");
	$("#show_password").hide();
	$("#note_text").val("");
	if(!jurSupUser){
		$("#note_name").hide();
		$("#note_text").hide();
	}
	showTip(rowNum);
	$("#user_div").dialog({
		title : title,
		resizable : false,
		modal : true,
		autoOpen : true,
		draggable : true,
		width : 420,
		buttons : {
			"取消" : function(){
				closeDig();
				$(this).dialog("close");
			},
			"确定" : function(){
				var uid = $("#uid").val();
				var username = $.trim($("#username").val());
				var password = "";
				if(!$("#show_box").attr("checked")){
					password = $("#password").val();
				}else{
					password = $("#show_password").val();
				}
				var userGroupId = $("#userGroupId").val();
				if(username.length == 0){
					alert("用户名称不能为空!");
					return;
				}else if(uid == 0 && password.length == 0){
					alert("密码不能为空!");
					return;
				}else if(rowNum == -1 || (row != null && username != row.username)){
					for(var i = 0; i < datas.rows.length; i++){
						if(datas.rows[i].username == username){
							alert("目标用户名已存在！");return;
						}
					}
				}
				$.ajax({
					url : "system_mgr/url_user_save.jsp",
					data:{rowNum : rowNum,
						uid : uid,
						username : username,
						password : password,
						userGroupId : userGroupId,
						noteText : $("#note_text").val()},
					type : "post",
					dataType : "json",
					cache : false,
					success : function(response){
						if(!showError(response)){
							closeDig();
							$("#user_div").dialog("close");
							if(uid == 0){
								alert("添加用户成功!");
							}else{
								alert("修改用户成功!");
							}
							$("#user_table").flexReload();
						}
					}
				});
			}
		}
	});
}
function deleteUser(i){
	var row = datas.rows[i];
	$("#del_user_div").html("是否确定删除用户[" + row.username + "]");
	$("#del_user_div").dialog({
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
				$.ajax({url:"system_mgr/url_user_delete.jsp",
					data:{uid : row.id},
					type:"post",
					dataType:"json",
					cache:false,
					success:function(response){
						if(!showError(response)){
							$("#del_user_div").dialog("close");
							alert("删除用户成功!");
							$("#user_table").flexReload();
						}
					}
				});
			}
		}
	});
}

function showPassword(){
	if($("#show_box").attr("checked")){
		$("#show_password").val($("#password").val());
		$("#show_password").show();
		$("#password").hide();
	}else{
		$("#password").val($("#show_password").val());
		$("#password").show();
		$("#show_password").hide();
	}
}
function closeDig(){
	if($("#show_box").attr("checked")){
		$("#show_box").attr("checked", false);
		$("#show_password").hide();
		$("#password").show();
	}
}
function showTip(rowNum){
	if(rowNum == -1){
		$("#sp_tip").hide();
	}else{
		$("#sp_tip").show();
	}
}
</script>