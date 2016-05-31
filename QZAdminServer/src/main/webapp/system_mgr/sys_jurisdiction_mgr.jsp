<%@page import="com.game.constant.WebConstant"%>
<%@page import="com.web.obj.UserGroup"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="jurisdiction_div"  style="display:none;">
	<table>
		<tr>
			<td align="right">权限id:</td>
			<td align="left">
				<input type="text" id="gid" style="margin-left:5px;margin-top:-5px;display:block;padding:2px;"/>
			</td>
		</tr>
		<tr>
			<td align="right">名称:</td>
			<td align="left">
				<input type="text" id="gname" style="margin-left:5px;margin-top:-5px;display:block;padding:2px;" />
			</td>
		</tr>
		<tr>
			<td align="right">父权限id:</td>
			<td align="left">
				<input type="text" id="gparentId" style="margin-left:5px;margin-top:-5px;display:block;padding:2px;" />
			</td>
		</tr>
		<tr>
			<td align="right">描述:</td>
			<td align="left">
				<textarea rows="3" cols="80" id="gdesc" style="display:block;padding:2px;resize:none;" ></textarea>
			</td>
		</tr>
	</table>
</div>
<div id="del_jurisdiction_tip" style="display:none;"></div>
<table id="jurisdiction_table"></table>
<script type="text/javascript">
<%
UserGroup userGroup = (UserGroup)session.getAttribute("userGroup");
%>
var jurModJuridict = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_MODIFY_JURISDICTION)%>;
var jurDelJuridict = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_DELETE_JURISDICTION)%>;
var datas;
function dispose(){
	$("#jurisdiction_div").remove();
	$("#del_jurisdiction_tip").remove();
	$("#jurisdiction_table").remove();
	datas = null;
}
function ready(){
	var bus = [];
	if(jurModJuridict){
		bus.push({name : '添加权限', bclass : 'add', onpress : function(){jurisdictionHandle("添加权限", -1)}});
	}
	if(jurDelJuridict){
		bus.push({name : '删除权限', bclass : 'delete', onpress : delJurisdiction});
	}
	var showBox = jurModJuridict || jurDelJuridict;
	$("#jurisdiction_table").flexigrid({
	    url : 'system_mgr/get_jurisdiction_list.jsp',
	    dataType : 'json',
	    preProcess : function(data){
	    	datas = data;
	    	return data;
	    },
	    colModel : [{display : '',
		        name : 'id',
		        width : 50,
		        align : 'center',
		        checkbox:true,
		        hide : !showBox
			},{display : '父ID',
       	        name : 'parentId',
       	        width : 80,
       	        align : 'center',
       	        customValue : function(i, idx, value){
       	        	if(value == 0){
       	        		return "";
       	        	}else if(value % 100000 == 0){
       	        		return "<b>" + value + "</b>";
       	        	}else{
       	        		return value;
       	        	}
       	        }
	   		}, {display : '权限ID',
    	        name : 'id',
    	        width : 80,
    	        align : 'center'
	        },  { display : '权限名称',
    	        name : 'name',
    	        width : 150,
    	        align : 'center',
    	        customValue : function(i, idx, value){
    	        	var row = datas.rows[i];
    	        	if(row.id == 0){
       	        		return "";
       	        	}else if(row.id % 100000 == 0){
       	        		return "<b style='color: red;'>" + value + "</b>";
       	        	}else if(row.id % 100 == 0){
       	        		return "<b>" + value + "</b>";
       	        	}else{
       	        		return value;
       	        	}
    	        }
	        }, {display : '操作',
	        	name : '',
    	        width : 100,
    	        align : 'center',
    	        customValue : function(i, idx, value){
    	        	if(jurModJuridict){
    	        		return "<a href='javascript:jurisdictionHandle(\"权限修改\", " + i + ")'>修改</a>";
    	        	}
    	        	return "";
    	        }
	        }, {display : '权限说明',
	        	name : 'desc',
    	        width : 300,
    	        align : 'center'
	        }],
	    buttons : bus,
   	    usepager : true,
   	    title : '权限管理',
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
   	 	showToggleBtn : showBox,
 		onSuccess : function(obj){
	 		showError(datas);
	    }
	});
}
function jurisdictionHandle(title, rowNum){
	var row = null;
	if(rowNum != -1){
		row = datas.rows[rowNum]
		$("#gid").val(row.id);
		$("#gname").val(row.name);
		$("#gparentId").val(row.parentId);
		$("#gdesc").val(row.desc);
	}else{
		$("#gid").val("");
		$("#gname").val("");
		$("#gparentId").val(0);
		$("#gdesc").val("");
	}
	var oid = $("#gid").val();
	if(oid.length == 0){
		oid = 0;
	}
	$("#jurisdiction_div").dialog({
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
				var parentId = $("#gparentId").val();
				var gdesc = $.trim($("#gdesc").val());
				if(gname.length == 0){
					alert("权限名称不能为空!");
					return;
				}else if(gid.length == 0){
					alert("权限id不能为空!");
					return;
				}else if(rowNum == -1 || (row != null && row.id != gid)){
					for(var i = 0; i < datas.rows.length; i++){
						if(datas.rows[i].id == gid){
							alert("目标ID已存在！");return;
						}
					}
				}
				$.ajax({url:"system_mgr/url_jurisdiction_save.jsp",
					data:{oid : oid,
						rowNum : rowNum,
						id : gid,
						name : gname,
						parentId : parentId,
						desc : gdesc},
					type:"post",
					dataType:"json",
					cache:false,
					success:function(response){
						if(!showError(response)){
							$("#jurisdiction_div").dialog("close");
							if(rowNum == -1){
								alert("添加权限成功!");
							}else{
								alert("修改权限成功!");
							}
							$("#jurisdiction_table").flexReload();
						}
					}
				});
			}
		}
	});
}
function delJurisdiction(){
	var jstr = "";
	$("input[name='id']:checked").each(function(){
		jstr += $(this).val() + ",";
	});
	if(jstr.length > 0){
		jstr = jstr.substring(0, jstr.length - 1);
	}else{
		alert("请选择要删除的权限");
		return;
	}
	$("#del_jurisdiction_tip").html("是否确定选中的删除权限" + jstr + "?");
	$("#del_jurisdiction_tip").dialog({
		title:'删除权限',
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		buttons:{
			"取消" : function(){
				$(this).dialog("close");
			},
			"确定" : function(){
				$.ajax({url:"system_mgr/url_jurisdiction_delete.jsp",
					data:{ids:jstr},
					type:"post",
					dataType:"json",
					cache:false,
					success:function(response){
						if(!showError(response)){
							$("#del_jurisdiction_tip").dialog("close");
							alert("删除权限成功!");
							$("#jurisdiction_table").flexReload();
						}
					}
				});
			}
		}
	});
}
</script>