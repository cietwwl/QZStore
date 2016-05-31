<%@page import="com.web.obj.UserGroup"%>
<%@page import="com.game.constant.WebConstant"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="web_refresh_dialog" style="display:none;">
	<input type="text" id="sid" value="0" style="display:none;" />
	<table>
		<tr>
			<td align="right">刷新名称:</td>
			<td align="left"><input type="text" id="fname"/></td>
			<td align="left">&nbsp;</td>
			<td align="right">类型：</td>
			<td align="left">
				<select id="ftype">
					<option value="0">不选择</option>
					<option value="1">区服</option>
					<option value="2">渠道</option>
				</select>
			</td>
		</tr>
		<tr>
			<td align="right">刷新地址:</td>
			<td align="left" colspan="6"><input type="text" id="furl" style="width:360px;"></td>
		</tr>
	</table>
</div>
<table id="web_refresh_table"></table>
<div id="game_tip" style="display:none;"></div>
<script type="text/javascript">
<%
UserGroup userGroup = (UserGroup)session.getAttribute("userGroup");
%>
var jurModWeb = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_MODIFY_WEB_REFRESH)%>;
var jurDelWeb = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_DELETE_WEB_REFRESH)%>;
var jurRefWeb = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_REFRESH_WEB_CACHE)%>;
var datas;
function dispose(){
	$("#web_refresh_dialog").remove();
	$("#web_refresh_table").remove();
	$("#game_tip").remove();
	datas = null;
}
function ready(){
	var bus = [];
	if(jurModWeb){
		bus = [{name: '添加', bclass: 'add', onpress : function(){webRefHandle("添加", -1);}}];
	}
	var showSel = jurModWeb;
	$("#web_refresh_table").flexigrid({
		url : 'game_server_mgr/get_web_refresh_list.jsp',
   	    dataType : 'json',
   		preProcess : function(data){
   			datas = data;
	    	return data;
	    },
   	 	colModel : [{display : '名称',
	        name : 'name',
	        width : 150,
	        align : 'center'
		},{display : '类型',
			name : 'type',
			width : 60,
			align : 'center',
			customValue : function(i, idx, value){
				if(value == 1){
					return "<b style='color:orange;'>区服</b>";
				}else if(value == 2){
					return "<b style='color:purple;'>渠道</b>";
				}
				return "未定义[ " + value + " ]";
			}
		},{display : '刷新地址',
			name : 'refUrl',
	        width : 400,
	        align : 'center',
	        customValue : function(i, idx, value){
	        	return "<span style='float:left;'>" + value + "<span>"
	        }
		},{display : '操作',
			name : 'id',
	        width : 100,
	        align : 'center',
	        customValue:function(i, idx, value){
	        	var val = "";
	        	if(jurModWeb){
		        	val = "<a href='javascript:webRefHandle(\"修改\", " + i + ");' style='margin-right:5px;'>修改</a>";
	        	}
	        	if(jurDelWeb){
	        		val += "<a href='javascript:delRef(" + i + ");' style='margin-right:5px;'>删除</a>";
	        	}
	        	if(jurRefWeb){
	        		val += "<a href='javascript:refresh(" + i + ");'>刷新</a>";
	        	}
	        	return val;
	        }
		}],
		buttons : bus,
		usepager : true,
	    title : 'Web刷新管理',
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
   	 	showToggleBtn : showSel,
 		onSuccess : function(obj){
	 		showError(datas);
	    }
	});
	search();
}

function search(){
	$("#web_refresh_table").flexOptions({
		params : [{name:'type', value:$("#ftype").val()}],
		newp : 1
	});
	$("#web_refresh_table").flexReload();
}

function webRefHandle(title, rowNum){
	var req = null;
	var id = 0;
	if(rowNum == -1){
		$("#fname").val("");
		$("#furl").val("");
	}else{
		req = datas.rows[rowNum];
		$("#fname").val(req.name);
		$("#furl").val(req.refUrl);
		id = req.id;
	}
	$("#web_refresh_dialog").dialog({
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
				var name = $.trim($("#fname").val());
				var furl = $("#furl").val();
				if(name.length == 0){
					alert("名称不能为空!");return;
				}else{
					if(furl.length == 0){
						alert("地址不能为空！");return;
					}
				}
				$.ajax({
					 url : "game_server_mgr/url_web_refresh_save.jsp",
					 dataType : 'json',
					 data : {id : id,
						 name : name,
						 furl : furl,
						 type : $("#ftype").val()
					 },
					 cache : false,
					 type:"post",
					 success:function(response){
						 if(!showError(response)){
							 $("#web_refresh_dialog").dialog("close");
							 if(rowNum == -1){
								 alert("成功添加!");
							 }else{
								 alert("成功修改!");
							 }
							 $("#web_refresh_table").flexReload();
						 }
					 }
				});
			}
		}
	});
}
function refresh(i){
	var row = datas.rows[i];
	d = $("#game_tip");
	d.html("<br><b>是否确定刷新 [ <span style='color:red;'>" + row.name + "</span> ] ！！！</b>");
	d.dialog({
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		title:"刷新应用渠道",
		buttons:{
			"取消":function(){
				$(this).dialog("close");
			},
			"确定":function(){
				$.ajax({url:"game_server_mgr/url_web_refresh.jsp",
					data:{furl : row.refUrl},
					type:"post",
					dataType:"json",
					cache:false,
					success:function(response){
						$("#game_tip").dialog("close");
						if(!showError(response)){
							alert("刷新成功！");
						}
					}
				});
			}
		}
	});
}

function delRef(i){
	var req = datas.rows[i];
	$("#game_tip").html("<br><b>您确定要删除[ <span style='color:red;'>" + req.name + "</span> ] 吗?</b>");
	$("#game_tip").dialog({
		title:'删除web刷新',
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
					 url : "game_server_mgr/url_web_refresh_delete.jsp",
					 dataType : 'json',
					 data : {
						 id : req.id
					 },
					 cache : false,
					 type:"post",
					 success:function(response){
						 if(!showError(response)){
							 $("#game_tip").dialog("close");
							 alert("成功删除!");
							 $("#web_refresh_table").flexReload();
						 }
					 }
				});
			}
		}
	});
}


</script>