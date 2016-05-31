<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="chats_div">
	<span style="margin-left:8px;">
	<input id="chat_dig" style="text-align:center;font-weight:bold;width:250px;" disabled="disabled" value="聊天监控">　　
	<input id="auto_flush" type="checkbox" checked="checked" style="margin-right:5px;vertical-align: middle;"  onclick="autoFlushChats();"><label for="auto_flush" style="vertical-align: middle;">自动刷新</label></span><br/>
	<textarea id="chatTxt" rows="30" cols="150" readonly="readonly" style="resize:none">
	</textarea>
</div>
<script type="text/javascript">
var time;
var interval;
function dispose(){
	$("#chats_div").remove();
	clearInterval(interval);
}
function ready(){
	time = 0;
	interval = setInterval(updateChat, 5000);
	$("#chatTxt").val("");
	updateChat();
}
function updateChat(){
	$.ajax({url:"game_player_mgr/get_chat_msgs.jsp",
		data:{
			type:1,
			time:time
		},
		type:"post",
		dataType:"json",
		cache:false,
		success:function(response){
			if(response.code == 0){
				time = response.data.time;
				var array = response.data.msgs;
				var txt = $("#chatTxt").val();
				for(var i = 0; i < array.length; i++){
					var msg = array[i];
					txt += parseChatMsg(msg) + "\r\n";
				}
				$("#chat_dig").val("当前聊天区服：[ " + response.serverName + " ]");
				if(txt.length > 0){
					$("#chatTxt").val(txt);
				}else{
					$("#chatTxt").val("\r\n\r\n\r\n\r\n\r\n\r\n\r\n                                       暂无人聊天...");
				}
				var scrollTop = $("#chatTxt")[0].scrollHeight;
                $("#chatTxt").scrollTop(scrollTop);  
			}else{
				$("#chat_dig").val("当前聊天区服：[" + response.serverName + "]");
				$("#auto_flush").attr("checked", false);
				$("#chatTxt").val("");
				clearInterval(interval);
				alert(" [ " + response.serverName + " ] 区服异常!!!!")
			}
		}
	});
}
function parseChatMsg(msg){
	return getTimeStr(0, 0, msg.senderTime) + " [vip" + msg.senderVip + "][lv" + msg.senderLv + "][" + msg.sender + "] ：" + msg.content;
}
function autoFlushChats(){
	clearInterval(interval);
	if($("#auto_flush").attr("checked") == "checked"){
		updateChat();
		interval = setInterval(updateChat, 5000);
	}
}
</script>