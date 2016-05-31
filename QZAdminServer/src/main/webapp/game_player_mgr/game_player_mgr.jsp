<%@page import="com.game.constant.WebConstant"%>
<%@page import="com.web.obj.UserGroup"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,com.web.db.bean.*,com.db.util.*,java.sql.*,com.utils.*"%>
<div id="sl-systeminfo" class="sl-table">
	<div id="search_div" style="display:table;">
		<span>
			<%@include file="/jsp/select_partner.jsp"%>
			<select id="searchType" style="margin-left:5px;margin-top:-5px;padding:2px;">
				<option value="1">账号</option>
				<option value="2">昵称</option>
				<option value="3">等级</option>
				<option value="4">在线</option>
			</select>
			<input style="margin-left:5px;margin-top:-5px;" type="text" id="searchValue"/>
			<input style="margin-left:5px;margin-top:-5px;" type="button"  class="button orange small" value="查询" onclick="searchPlayer();"/>
		</span>
	</div>
	<table id="players" style="display:none"></table>
	<div id="banTip" style="position:fixed; z-index: 9999;background: #FFF;border:solid 1px #6e8bde;display:none;padding:4px;"></div>
	<div id="banDialog" style="display:none;"></div>
	<div id="relieveBanDialog" style="display:none;"></div>
</div>
<script type="text/javascript">
<%
UserGroup userGroup = (UserGroup)session.getAttribute("userGroup");
%>
var jurBanPlayer = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_BAN_PLAYER)%>;
var datas;
function dispose(){
	$("#players").remove();
	$("#banTip").remove();
	$("#banDialog").remove();
	$("#relieveBanDialog").remove();
	datas = null;
}
function ready(){
	$("#players").flexigrid({
   	    url : 'game_player_mgr/get_player_list.jsp',
   	    dataType : 'json',
   	    preProcess : function(data){
   	    	datas = data;
   	    	return data;
   	    },
   	    getRowColor:function(row){
   	    	if(row.online == 1){
   	    		return "#bee9ad";
   	    	}
   	    },
   	    colModel : [{display : '玩家ID',
   	        name : 'userId',
   	        width : 50,
   	        align : 'center'
   		}, {display : '玩家账号',
	        name : 'username',
	        width : 90,
	        align : 'center'
        }, {display : '渠道',
	        name : 'partnerName',
	        width : 90,
	        align : 'center'
        },  { display : '玩家昵称',
	        name : 'playerName',
	        width : 90,
	        align : 'center'
        }, {display : '帐号状态',
        	name : 'banLoginSign',
	        width : 50,
	        align : 'center',
	        customValue:getBanLogin
        }, {display : '禁言',
        	name : 'banChatSign',
	        width : 50,
	        align : 'center',
	        customValue:getBanChat
        },{display : '等级',
	        name : 'level',
	        width : 50,
	        sortable : true,
	        align : 'center'
        }, {
        	display : '累计充值',
        	name : 'chargeDiamond',
        	width : 90,
        	align : 'center',
        	sortable : true
        }, {display : '钻石',
   	        name : 'diamond',
   	        width : 90,
   	        sortable : true,
   	        align : 'center'
   	    }, {display : '金币',
   	        name : 'gold',
   	        width : 90,
   	        sortable : true,
   	        align : 'center'
   	   	}, {display : '灵气',
   	        name : 'gp',
   	        width : 90,
   	        sortable : true,
   	        align : 'center'
   	    }, {display : '石板',
   	        name : 'slate',
   	        width : 60,
   	        sortable : true,
   	        align : 'center'
   	    }, {display : '名望',
   	        name : 'fame',
   	        width : 50,
   	        sortable : true,
   	        align : 'center'
   	    }, {display : '伙伴扩充容量',
   	        name : 'heroCapacity',
   	        width : 60,
   	        sortable : true,
   	        align : 'center'
   	    }, {display : '装备扩充容量',
   	        name : 'equipmentCapacity',
   	        width : 60,
   	        sortable : true,
   	        align : 'center'
   	    }, {display : '武魂扩充容量',
   	        name : 'eternalCapacity',
   	        width : 60,
   	        sortable : true,
   	        align : 'center'
   	    }, {display : '注册时间',
   	        name : 'registTimeStr',
   	        width : 135,
   	        sortable : true,
   	        align : 'center'
   	    }, {display : '最后登陆时间',
   	        name : 'loginTimeStr',
   	        width : 135,
   	        sortable : true,
   	        align : 'center'
   	    }],
   	    usepager : true,
   	    title : '玩家列表',
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
 		onSuccess : function(obj){
	 		showError(datas);
	    }
   	});
	searchPlayer();
}
function getBanChat(row,col,state){
	var val = "";
	if(state == 1){
		if(jurBanPlayer){
			val = "onmouseover='showBanTip(event, 1, true, true)' onmouseout='showBanTip(event, 1, false, true)' onclick='relieveBan(1," + row +")'";
		}
		return "<img src='css/images/ban.png' style='cursor:pointer;float:left;' " + val + "/>禁言";
	}else{
		if(jurBanPlayer){
			val = "onmouseover='showBanTip(event, 1, true, false)'  onmouseout='showBanTip(event, 1, false, false)' onclick='showBanDialog(1," + row +")'";
		}
		return "<img src='css/images/accept.png' style='cursor:pointer;float:left;' " + val + "/>正常";
	}
}

function showBanTip(event, type, show, accept){
	tip = $("#banTip");
	if(show){
		if(accept){
			if(type == 1){
				tip.html("点击解禁");
			}else{
				tip.html("点击解封");
			}
		}else if(type == 1){
			tip.html("点击禁言");
		}else{
			tip.html("点击封号");
		}
		tip.css("position", "fixed");
		tip.css("left", event.clientX + 2);
		tip.css("top", event.clientY - 20);
		tip.show();
	}else{
		tip.hide();
	}
}

function getBanLogin(row,col,state){
	var val = "";
	if(state == 1){
		if(jurBanPlayer){
			val = "onmouseover='showBanTip(event, 2, true, true)' onmouseout='showBanTip(event, 2, false, true)' onclick='relieveBan(2," + row +")'";
		}
		return "<img src='css/images/ban.png' style='cursor:pointer;float:left;' " + val + "/>封禁";
	}else{
		if(jurBanPlayer){
			val = "onmouseover='showBanTip(event, 2, true, false)'  onmouseout='showBanTip(event, 2, false, false)' onclick='showBanDialog(2," + row +")'";
		}
		return "<img src='css/images/accept.png' style='cursor:pointer;float:left;' " + val + "/>正常";
	}
}

function relieveBan(banType,row){
	d = $("#relieveBanDialog");
	htmlText = "<br>是否确定解禁!";
	if(banType == 1){
		d.attr("title", "解除禁言");
	}else{
		d.attr("title", "解除封号");
		htmlText = "<br>是否确定解封!";
	}
	d.html(htmlText);
	d.dialog({
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		title:d.attr("title"),
		buttons:{
			"取消":function(){
				$(this).dialog("close");
			},
			"确定":function(){
				var date =  $("#banDate").val();
				var username = datas.rows[row].username;
				var partner = datas.rows[row].partner;
				$.ajax({url:"game_player_mgr/url_ban_account.jsp",
					data:{
						banDate:date,
						username:username,
						partner:partner,
						banType:banType
						},
					type:"post",
					dataType:"json",
					cache:false,
					success:function(response){
						if(!showError(response)){
							player = response.data.player;
							for(i = 0; i < datas.rows.length; i++){
								if(datas.rows[i].id == player.id){
									datas.rows[i] = player;
									break;
								}
							}
							$('#relieveBanDialog').dialog("close");
							if(banType == 1){
								alert("解除禁言成功!");
							}else{
								alert("解除封号成功!");
							}
							$("#players").flexAddData(datas);
						}
					}
				});
			}
		}
	});
}

function showBanDialog(banType,row){
	d = $('#banDialog');
	var options = document.getElementById("gameServer").options;
	if(banType == 1){
		d.attr("title", " [ " + options[options.selectedIndex].text + " ] 禁言");
	}else{
		d.attr("title", " [ " + options[options.selectedIndex].text + " ] 封号");
	}
	htmlText = "<table><tr><td style='width:100px;text-align:right;'>账号:</td><td style='text-align:left;'>" + datas.rows[row].username + "</td></tr><tr><td style='text-align:right;'>玩家昵称:</td><td style='text-align:left;'>" + datas.rows[row].playerName + "</td></tr><tr><td style='text-align:right;'>封禁时间:</td><td style='text-align:left;'><input id='banDate'/>" + getHour(0) + getMinute(0) + "</td></tr></table>";
	d.html(htmlText);
	d.dialog({
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		title:d.attr("title"),
		buttons:{
			"取消":function(){
				$(this).dialog("close");
			},
			"确定":function(){
				var date =  $("#banDate").val() + " " + $("#hour0").val() + ":" + $("#minute0").val() + ":00";
				var username = datas.rows[row].username;
				var partner = datas.rows[row].partner;
				$.ajax({url:"game_player_mgr/url_ban_account.jsp",
					data:{
						banDate:date,
						username:username,
						partner:partner,
						banType:banType
						},
						type:"post",
						dataType:"json",
						cache:false,
						success:function(response){
							$('#banDialog').dialog("close");
							$("#banDate").val("");
							if(response.code == 0){
								player = response.data.player;
								for(i = 0; i < datas.rows.length; i++){
									if(datas.rows[i].id == player.id){
										datas.rows[i] = player;
										break;
									}
								}
								if(banType == 1){
									alert("禁言成功!");
								}else{
									alert("封号成功!");
								}
								$("#players").flexAddData(datas);
							}else{
								if(response.tip != null && response.tip.length > 0){
									alert(response.tip);
								}else{
									alert("请求服务器出错!");
								}
							}
						}
				});
			}
		}
	});
	pickerDateByMin("banDate", getNextDate(0 * 24 * 60 * 60 * 1000), getNextDate(1 * 24 * 60 * 60 * 1000));
}
function searchPlayer(){
	$("#players").flexOptions({
		params : [{name:'partner', value:$("#partner").val()},
		          {name:'searchType', value:$("#searchType").val()},
		          {name:'searchValue', value:$("#searchValue").val()},
		         ],
		newp:1
	});
	$("#players").flexReload();
}
</script>
