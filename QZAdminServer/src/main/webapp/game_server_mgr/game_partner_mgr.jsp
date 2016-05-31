<%@page import="com.web.obj.UserGroup"%>
<%@page import="com.game.constant.WebConstant"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="partner_dialog" style="display:none;">
	<input type="text" id="sid" value="0" style="display:none;" />
	<table>
		<tr>
			<td align="right">渠道编号:</td>
			<td align="left"><input type="text" id="pid"/></td>
			<td align="left">&nbsp;</td>
			<td align="right">渠道名称:</td>
			<td align="left"><input type="text" id="pname"/></td>
		</tr>
		<tr>
			<td align="right">正式支付地址:</td>
			<td align="left" colspan="6"><input type="text" id="payUrl" style="width:360px;"></td>
		</tr>
		<tr>
			<td align="right">测试支付地址:</td>
			<td align="left" colspan="6"><input type="text" id="payDebugUrl" style="width:360px;"></td>
		</tr>
		<tr>
			<td align="right">回调地址:</td>
			<td align="left" colspan="6"><input type="text" id="callbackUrl" style="width:360px;"></td>
		</tr>
		<tr>
			<td align="right">私钥:</td>
			<td align="left" colspan="6"><input type="text" id="privateKey" style="width:360px;"></td>
		</tr>
		<tr>
			<td align="right">公钥:</td>
			<td align="left" colspan="6"><input type="text" id="publicKey" style="width:360px;"></td>
		</tr>
	</table>
</div>
<div id="search_div" style="display:table;">
	<span>
		搜索：
		<select id="searchType" style="margin-left:5px;margin-top:-5px;text-align: center;padding:2px;">
			<option value="1">渠道编号</option>
			<option value="2">渠道名称</option>
		</select>
		<input type="text" id="searchValue" style="margin-left:5px;margin-top:-5px;">
		<input style="margin-left:5px;margin-top:-5px;text-align: center;" class="button orange small" type="button" value="查询" onclick="search();"/>
	</span>
</div>
<table id="partner_table"></table>
<div id="parter_refresh" style="display: none;"><table id="refresh_table"></table></div>
<div id="game_tip" style="display:none;"></div>
<script type="text/javascript">
<%
UserGroup userGroup = (UserGroup)session.getAttribute("userGroup");
%>
var jurModPartner = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_MODIFY_PARTNER)%>;
var jurDelPartner = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_DELETE_PARTNER)%>;
var jurRefPartner = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_REFRESH_WEB_CACHE)%>;
var datas;
var pdatas;
function dispose(){
	$("#search_div").remove();
	$("#partner_dialog").remove();
	$("#parter_refresh").remove();
	$("#partner_table").remove();
	$("#game_tip").remove();
	datas = null;
	pdatas = null;
}
function ready(){
	var bus = [];
	if(jurModPartner){
		bus = [{name: '添加', bclass: 'add', onpress : function(){partnerHandle("添加渠道", -1);}}];
	}
	if(jurRefPartner){
		bus.push({name: '刷新渠道', bclass: 'bflush', onpress : flushPartner});
	}
	var showSel = jurModPartner || jurDelPartner || jurRefPartner;
	$("#partner_table").flexigrid({
		url : 'game_server_mgr/get_partner_list.jsp',
   	    dataType : 'json',
   		preProcess : function(data){
   			datas = data;
	    	return data;
	    },
   	 	colModel : [{display : '渠道编号',
			name : 'id',
	        width : 80,
	        align : 'center'
		},{display : '渠道名称',
	        name : 'name',
	        width : 80,
	        align : 'center'
		},{display : '操作',
			name : 'id',
	        width : 100,
	        align : 'center',
	        customValue:function(i, idx, value){
	        	var val = "";
	        	if(jurModPartner){
	        		val += "<a href='javascript:partnerHandle(\"修改渠道\", " + i + ");' style='margin-right:5px;'>修改</a>";
	        	}
	        	if(jurDelPartner){
	        		val += "&nbsp;&nbsp;<a href='javascript:delPartner(" + i + ");'>删除</a>";
	        	}
	        	return val
	        }
		},{display : '正式支付地址',
			name : 'payUrl',
	        width : 300,
	        align : 'center',
	        customValue : function(i, idx, value){
	        	return "<span style='float:left;'>" + value + "<span>";
	        }
		},{display : '测试支付地址',
			name : 'payDebugUrl',
	        width : 300,
	        align : 'center',
	        customValue : function(i, idx, value){
	        	return "<span style='float:left;'>" + value + "<span>";
	        }
		},{display : '回调地址',
			name : 'callbackUrl',
			width : 300,
	        align : 'center',
	        customValue : function(i, idx, value){
	        	return "<span style='float:left;'>" + value + "<span>";
	        }
		},{display : '公钥',
			name : 'publicKey',
	        width : 100,
	        align : 'center',
	        hide : true,
		},{display : '私钥',
			name : 'privateKey',
	        width : 100,
	        align : 'center',
	        hide : true,
		}],
		buttons : bus,
		usepager : true,
	    title : '渠道管理',
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
	$("#refresh_table").flexigrid({
		 url : 'game_server_mgr/get_web_refresh_list.jsp',
		 dataType : 'json',
		 newp:1,
		 hide:true,
		 preProcess : function(data){
	    	pdatas = data;
	    	return data;
	    },
	 	colModel : [{display : '名称',
	        name : 'name',
	        width : 100,
	        align : 'center'
		},{display : '刷新地址',
			name : 'refUrl',
	        width : 350,
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
	        	if(jurRefPartner){
	        		val += "<a href='javascript:refresh(" + i + ");'>刷新</a>";
	        	}
	        	return val;
	        }
		}],
  		title : '渠道刷新（配置->Web管理）',
  		resizable: false,
  	    usepager : true,
  	    useRp : false,
  	    rp : 15,
  	    width : 580,
  	    height : 420,
  	    page: 1,
  	    total: 1,
  	    procmsg:'加载中，請稍後…',
  	    singleSelect:true,
  	 	autoload:false
	});
	search();
}

function search(){
	$("#partner_table").flexOptions({
		params : [{name:'searchType', value:$("#searchType").val()},
		          {name:'searchValue', value:$("#searchValue").val()},
		         ],
		newp : 1
	});
	$("#partner_table").flexReload();
}

function partnerHandle(title, rowNum){
	var req = null;
	if(rowNum == -1){
		$("#pid").val(0);
		$("#pname").val("");
		$("#payUrl").val("");
		$("#payDebugUrl").val("");
		$("#callbackUrl").val("");
		$("#privateKey").val("");
		$("#publicKey").val("");
	}else{
		req = datas.rows[rowNum];
		$("#pid").val(req.id);
		$("#pname").val(req.name);
		$("#payUrl").val(req.payUrl);
		$("#payDebugUrl").val(req.payDebugUrl);
		$("#callbackUrl").val(req.callbackUrl);
		$("#privateKey").val(req.privateKey);
		$("#publicKey").val(req.publicKey);
	}
	var oid = $("#pid").val();
	$("#partner_dialog").dialog({
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
				var id = $("#pid").val();
				var name = $.trim($("#pname").val());
				if(name.length == 0){
					alert("渠道名称不能为空!");
					return;
				}else if(req != null && id != req.id){
					for(var i = 0; i < datas.rows.length; i++){
						if(datas.rows[i].id == id){
							alert("目标ID已存在！");return;
						}
					}
				}
				$.ajax({
					 url : "game_server_mgr/url_partner_save.jsp",
					 dataType : 'json',
					 data : {oid : oid,
						 id : id,
						 name : name,
						 payUrl : $("#payUrl").val(),
						 payDebugUrl : $("#payDebugUrl").val(),
						 callbackUrl : $("#callbackUrl").val(),
						 privateKey : $("#privateKey").val(),
						 publicKey : $("#publicKey").val(),
						 rowNum : rowNum
					 },
					 cache : false,
					 type:"post",
					 success:function(response){
						 if(!showError(response)){
							 $("#partner_dialog").dialog("close");
							 if(rowNum == -1){
								 alert("添加渠道成功!");
							 }else{
								 alert("修改渠道成功!");
							 }
							 $("#partner_table").flexReload();
						 }
					 }
				});
			}
		}
	});
}

function delPartner(i){
	var req = datas.rows[i];
	$("#game_tip").html("<br><b>您确定要删除渠道[ <span style='color:orange;'>" + req.id + "</span> ] <span style='color:red;'>" + req.name + "</span> 吗?</b>");
	$("#game_tip").dialog({
		title:'删除渠道',
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
					 url : "game_server_mgr/url_partner_delete.jsp",
					 dataType : 'json',
					 data : {
						 id : req.id
					 },
					 cache : false,
					 type:"post",
					 success:function(response){
						 if(!showError(response)){
							 $("#game_tip").dialog("close");
							 alert("删除渠道成功!");
							 $("#partner_table").flexReload();
						 }
					 }
				});
			}
		}
	});
}

function flushPartner(){
	$("#parter_refresh").dialog({
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		width : 610,
		height : 650,  //使用auto会导致长列表第一次打开出现问题
		title:"刷新应用渠道"
	});
	$("#refresh_table").flexOptions({
		 params : [{name:'type', value:2}],
		 newp:1,
		 hide:false
	});
	$("#refresh_table").flexReload();
}

function refresh(i){
	var row = pdatas.rows[i];
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


</script>