<%@page import="com.game.constant.WebConstant"%>
<%@page import="com.web.obj.UserGroup"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search_div" style="display:table;padding:5px;margin-left: auto;margin-right: auto;">
	<span>
		<b style="margin-left:5px;margin-top:-5px;">渠道：</b><%@include file="/jsp/select_partner.jsp"%>
		<b style="margin-left:5px;margin-top:-5px;">帐号：</b><input id="openId" style="margin-left:5px;margin-top:-5px;">
		<input style="margin-left:5px;margin-top:-5px;" type="button" value="查询" onclick="search();" class="button orange small"/>
	</span>	
</div><br>
<table id="gm_table" style="margin-left: auto;margin-right: auto;">
	<tr>
		<td align="right">游戏帐号：</td>
		<td align="left"><input id="username" style="margin-left:5px;margin-top:-5px;" disabled="disabled"></td>
	</tr>
	<tr>
		<td align="right">游戏昵称：</td>
		<td align="left"><input id="playername" style="margin-left:5px;margin-top:-5px;" disabled="disabled"></td>
	</tr>
	<tr>
		<td align="right">游戏等级：</td>
		<td align="left">
			<input id="oldLevel" style="margin-left:5px;margin-top:-5px;margin-right: 30px;color:red;" value="0" disabled="disabled">
			<span id="changeLevel">
			增加：
			<input id="addLevel" onkeyup='limitValue("Level", value, false);' style="ime-mode:disabled;margin-left:5px;margin-top:-5px;margin-right: 5px;" value="0">
			</span>
		</td>
	</tr>
	<tr>
		<td align="right">玩家经验：</td>
		<td align="left">
			<input id="oldExp" style="margin-left:5px;margin-top:-5px;margin-right: 30px;color:red;" value="0" disabled="disabled">
			<span id="changeExp">
			增加：
			<input id="addExp" onkeyup='limitValue("Exp", value, false);' style="margin-left:5px;margin-top:-5px;margin-right: 5px;" value="0">
			</span>
		</td>
	</tr>
	<tr>
		<td align="right">充值钻石：</td>
		<td align="left">
			<input id="oldRecharge" style="margin-left:5px;margin-top:-5px;margin-right: 30px;color:red;" value="0" disabled="disabled">
			<span id="changeRecharge">
			增加：
			<input id="addRecharge" onkeyup='limitValue("Recharge", value, false);' style="margin-left:5px;margin-top:-5px;margin-right: 5px;" value="0">
			</span>
		</td>
	</tr>
	<tr>
		<td align="right">金币数量：</td>
		<td align="left">
			<input id="oldGold" style="margin-left:5px;margin-top:-5px;margin-right: 30px;color:red;" value="0" disabled="disabled">
			<span id="changeGold">
			增加：
			<input id="addGold" onkeyup='limitValue("Gold", value, false);' style="margin-left:5px;margin-top:-5px;margin-right: 5px;" value="0">
			减少：
			<input id="delGold" onkeyup='limitValue("Gold", value, true);' style="margin-left:5px;margin-top:-5px;" value="0">
			</span>
		</td>
	</tr>
	<tr>
		<td align="right">钻石数量：</td>
		<td align="left">
			<input id="oldDiamond" style="margin-left:5px;margin-top:-5px;margin-right: 30px;color:red;" value="0" disabled="disabled">
			<span id="changeDiamond">
			增加：
			<input id="addDiamond" onkeyup='limitValue("Diamond", value, false);' style="margin-left:5px;margin-top:-5px;margin-right: 5px;" value="0">
			减少：
			<input id="delDiamond" onkeyup='limitValue("Diamond", value, true);' style="margin-left:5px;margin-top:-5px;" value="0">
			</span>
		</td>
	</tr>
	<tr>
		<td align="right">玩家体力：</td>
		<td align="left">
			<input id="oldStamina" style="margin-left:5px;margin-top:-5px;margin-right: 30px;color:red;" value="0" disabled="disabled">
			<span id="changeStamina">
			增加：
			<input id="addStamina" onkeyup='limitValue("Stamina", value, false);' style="margin-left:5px;margin-top:-5px;margin-right: 5px;" value="0">
			减少：
			<input id="delStamina" onkeyup='limitValue("Stamina", value, true);' style="margin-left:5px;margin-top:-5px;" value="0">
			</span>
		</td>
	</tr>
	<tr>
		<td align="right">上古石板：</td>
		<td align="left">
			<input id="oldSlate" style="margin-left:5px;margin-top:-5px;margin-right: 30px;color:red;" value="0" disabled="disabled">
			<span id="changeSlate">
			增加：
			<input id="addSlate" onkeyup='limitValue("Slate", value, false);' style="margin-left:5px;margin-top:-5px;margin-right: 5px;" value="0">
			减少：
			<input id="delSlate" onkeyup='limitValue("Slate", value, true);' style="margin-left:5px;margin-top:-5px;" value="0">
			</span>
		</td>
	</tr>
</table>
<br><br><br>
<div id="gm_submit" style="text-align: center;"><input type="button" value="提交修改" onclick="submit();" class="button orange small"/></div>
<!-- GM管理  -->
<script type="text/javascript">
<%
UserGroup userGroup = (UserGroup)session.getAttribute("userGroup");
%>
var jurModPlayer = <%=userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_GM_MODIFY_PLAYER)%>;
var maxVal;
var partner;
function dispose(){
	$("#search_div").remove();
	$("#gm_table").remove();
	$("#gm_submit").remove();
	maxVal = 0;
	partner = 0;
}
function ready(){
	disabledInput(true);
	maxVal = 2147483647;
	if(!jurModPlayer){
		$("#gm_submit").hide();
		$("#changeLevel").hide();
		$("#changeExp").hide();
		$("#changeRecharge").hide();
		$("#changeGold").hide();
		$("#changeDiamond").hide();
		$("#changeStamina").hide();
		$("#changeSlate").hide();
	}
}
function search(){
	if($("#openId").val() == ""){
		alert("请输入玩家帐号");
		return;
	}
	$.ajax({
		url : "game_operate_mgr/get_player.jsp",
		dataType : 'json',
		data : {
			partner : $("#partner").val(),
			openId : $("#openId").val(),
		 },
		cache : false,
		type:"post",
		success:function(response){
			if(!showError(response)){
				partner = response.partner;
				$("#username").val(response.username);
				$("#playername").val(response.playername);
				$("#oldLevel").val(response.level);
				$("#oldRecharge").val(response.recharge);
				$("#oldGold").val(response.gold);
				$("#oldDiamond").val(response.diamond);
				$("#oldExp").val(response.exp);
				$("#oldStamina").val(response.stamina);
				$("#oldSlate").val(response.slate);
				disabledInput(!jurModPlayer || partner <= 0);
			}
		}
	});
}
function submit(){
	if($("#username").val() == ""){
		alert("玩家不存在！");return;
	}
	var addLevel = $("#addLevel").val();
	var addExp = $("#addExp").val();
	var addRecharge = $("#addRecharge").val();
	var addGold = $("#addGold").val();
	var delGold = $("#delGold").val();
	var addDiamond = $("#addDiamond").val();
	var delDiamond = $("#delDiamond").val();
	var addStamina = $("#addStamina").val();
	var delStamina = $("#delStamina").val();
	var addSlate = $("#addSlate").val();
	var delSlate = $("#delSlate").val();
	if(addLevel == 0 && addRecharge == 0 && addExp == 0
			&& addGold == 0 && delGold == 0
			&& addDiamond == 0 && delDiamond == 0 
			&& addStamina == 0 && delStamina == 0 
			&& addSlate == 0 && delSlate == 0){
		alert("数据无修改!");
	}else{
		var adds = "";
		var dels = "";
		if(addLevel > 0){
			adds += "-1_0_" + addLevel + "_0_10000|";
		}
		if(addExp > 0){
			adds += "101_0_" + addExp + "_0_10000|";
		}
		if(addRecharge > 0){
			adds += "-2_0_" + addRecharge + "_0_10000|";
		}
		if(addGold > 0){
			adds += "2_0_" + addGold + "_0_10000|";
		}
		if(delGold > 0){
			dels += "2_0_" + delGold + "_0_10000|";
		}
		if(addDiamond > 0){
			adds += "3_0_" + addDiamond + "_0_10000|";
		}
		if(delDiamond > 0){
			dels += "3_0_" + delDiamond + "_0_10000|";
		}
		if(addStamina > 0){
			adds += "102_0_" + addStamina + "_0_10000|";
		}
		if(delStamina > 0){
			dels += "102_0_" + delStamina + "_0_10000|";
		}
		if(addSlate > 0){
			adds += "10_0_" + addSlate + "_0_10000|";
		}
		if(delSlate > 0){
			dels += "10_0_" + delSlate + "_0_10000|";
		}
		if(adds.length > 0){
			adds = adds.substring(0, adds.length - 1);
		}
		if(dels.length > 0){
			dels = dels.substring(0, dels.length - 1);
		}
		$.ajax({
			url : "game_operate_mgr/url_gm_modify.jsp",
			dataType : 'json',
			data : {
				partner : partner,
				username : $("#username").val(),
				items : adds,
				delItems : dels
			 },
			cache : false,
			type:"post",
			success:function(response){
				if(!showError(response)){
					search();
					$("#addLevel").val(0);
					$("#addExp").val(0);
					$("#addRecharge").val(0);
					$("#addGold").val(0);
					$("#addDiamond").val(0);
					$("#addStamina").val(0);
					$("#addSlate").val(0);
					$("#delGold").val(0);
					$("#delDiamond").val(0);
					$("#delStamina").val(0);
					$("#delSlate").val(0);
				}
			}
		});
	}
}
function limitValue(field, value, subtract){
	if(value == "" || value == 0){
		if(subtract){
			$("#del" + field).val(0);
		}else{
			$("#add" + field).val(0);
		}
	}else{
		if(isNaN(value) || value.indexOf(".") >= 0 || value.indexOf("-") >= 0){
			var strs = value.split("");
			for(var i = 0; i < strs.length; i ++){
				var val = strs[i];
				if(isNaN(val)){
					if(i > 0){
						value = value.substring(0, i);
					}else{
						value = 0;
					}
					break;
				}
			}
		}
		var zero = -1;
		var strs = [];
		if(value != 0){
			strs = value.split("");
			for(var i = 0; i < strs.length; i++){
				if(strs[i] == 0 && (i == 0 || zero >= 0)){
					zero = i;
				}else if(zero != -1){
					zero++;
					if(zero >= strs.length){
						value = 0;
					}else{
						value = value.substring(zero, strs.length);
					}
					break;
				}
			}
		}
		var vl = "";
		var changeValue = 0;
		if(subtract){
			vl = "#del";
			if(field != "Level" && field != "Recharge" && field != "Exp"){
				changeValue = parseInt($("#old" + field).val()) + parseInt($("#add" + field).val());
			}
		}else{
			vl = "#add";
			if(field == "Level"){
				changeValue = 100 - $("#old" + field).val();
			}else{
				changeValue = maxVal - $("#old" + field).val();
			}
		}
		if(value > changeValue){
			$(vl + field).val(changeValue);
		}else{
			$(vl + field).val(value);
		}
	}
}
function disabledInput(disabled){
	$("#addLevel").attr("disabled", disabled);
	$("#addExp").attr("disabled", disabled);
	$("#addRecharge").attr("disabled", disabled);
	$("#addGold").attr("disabled", disabled);
	$("#addDiamond").attr("disabled", disabled);
	$("#addStamina").attr("disabled", disabled);
	$("#addSlate").attr("disabled", disabled);
	$("#delGold").attr("disabled", disabled);
	$("#delDiamond").attr("disabled", disabled);
	$("#delStamina").attr("disabled", disabled);
	$("#delSlate").attr("disabled", disabled);
}
</script>