<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<script type="text/javascript">
		var value1 = "*格式：&economys=类型_值 <br>*类型：101.金币、102.钻石、103.竞技积分、104.神符积分、105.深渊积分、106.元素之塔积分、107副本星星、111.经验、112.体力、113.能量、114.公会贡献、115.活跃度、116.矿魂、117.公会捐献值、201.伊甸园白银宝箱次数";
		var value2 = "类型：<br>1.体力购买次数，2.竞技场挑战购买次数，3.探宝次数，4.英雄副本重置次数，5.护送可购买次数，6.劫镖可购买次数，7.精灵抓取机金币刷新次数，8.精灵抓取机钻石刷新次数；<br>" + 
					 "51.弥达斯次数，52.公会捐献次数，53.深渊挑战次数，54.元素之塔挑战次数，55.魔幻界挑战次数";
		function ready(){
			$("#tip").html("");
			var tip = $("#tip");
			tip.append(value1);
			$("#affiche").val("服务端将在X时X分重启服务器！！！！！！！！！");
		}; 
		function submit(){
			var openid = $("#openid").val();
			if(openid.length > 0){
				openid = "&openid=" + openid;
			}
			var cmds = $("#orders").val();
			if(openid.length <= 0 && cmds != "cmd=-50006" && cmds != "cmd=-50007" && cmds != "cmd=-50009" && cmds != "cmd=-50010" && cmds != "cmd=-50013"){
				alert("请输入玩家帐号");
			}else{
				cmds = cmds + openid + $("#data").val();
				if(cmds.indexOf("?") > 0 || cmds.indexOf("cmd=") < 0){
					alert("请检查参数");
				}else{
					var url = $("#servers").val();
					if(url.length <= 5){
						url = $("#url").val();
					}
					var data = encodeURI(cmds);
					$.ajax({
						type:'get',
						url:url,
						data:data,
						dataType:'jsonp',
						jsonp: 'jsonpCallback',
						success:function(result){
							if(result.code == 0){
								alert("提交成功!");
							}else{
								var code = result.code;
								if(code < -1000){
									alert("等级应不小于1，且不大于最大" + (-code - 1000) + "级");
								}else{
									switch(code){
										case -101:alert("已有机器人运行中，停止前一批");break;
										case -102:alert("等级不得逆向设置，须大于等于玩家等级");break;
										case 1:alert("系统错误");break;
										case 2:alert("cmd错误");break;
										case 3:alert("参数错误：拼写有误，或内容存在错误，请检查！");break;
										case 4:alert("操作超时");break;
										case 10009:alert("玩家不存在");break;
										case 11002:alert("道具不存在");break;
										case 11007:alert("背包空间不足");break;
										default:alert("错误码:" + code);
									}
								}
							}
						},
						error:function(){
							alert("操作成功：未收到数据返回，请检查网络状况或确认服务器是否开启！");
						}
					});
				}
			}
		}
		function reset(){
			window.location.reload();
		}
		function selectCmd(){
			$("#tip").html("");
			var value = $("#orders").val();
			var tip = $("#tip");
			if(value.length <= 0){
				$("#data").val("");
				$("#openid").val("");
				$("#openid").attr("disabled","disabled");
				tip.append("*增加效益：cmd=-50001&openid=?&economys=?<br>");
				tip.append("*增加道具：cmd=-50002&openid=?&items=?<br>");
				tip.append("*添加任务：cmd=-50003&openid=?&missionId=?<br>");
				tip.append("*充值钻石：cmd=-50004&openid=?&money=?<br>");
				tip.append("*一键提升：cmd=-50005&openid=?&level=?&boost=?<br>");
				tip.append("*发送邮件：cmd=-50006&title=?&content=?&userType=?&items=?&openids=?&nicknames=?<br>");
				tip.append("*开机器人：cmd=-50007&start=0&sleep=0&amount=0<br>");
				tip.append("*禁言封号：cmd=-50008&openid=?&banType=?&banTime=?<br>");
				tip.append("*发送公告：cmd=-50009&content=?&colorId=?&secondNum=?&sendNum=?<br>");
				tip.append("*限制指令：cmd=-50010&type=?&orders=?<br>");
				tip.append("*平台重置：cmd=-50011&openid=?&billno=?&amount=?<br>");
				tip.append("*<br>");
				tip.append("*发送装备~cmd=-50014&openid=?&params=?");
			}else{
				if(value == "cmd=-50001"){
					$("#data").val("&economys=?");
					tip.append(value1);
				}else if(value == "cmd=-50002"){
					$("#data").val("&items=?");
					tip.append("*格式：&items=类型_id_数量_10000<br>类型：301.道具、302.神符、303.元素、401.称号");
				}else if(value == "cmd=-50003"){
					$("#data").val("&missionId=?");
					tip.append("*格式：&missionId=任务id<br>负id：添加任务且不获得奖励<br>id=0:完成当前主线<br>id=-1：完成当前支线<br>id=当前：完成该任务<br>id\>当前：完成至该任务<br>id\<当前：添加该任务");
				}else if(value == "cmd=-50004"){
					$("#data").val("&money=?");
					tip.append("*格式：&money=数量(比例 1:10)<br>");
				}else if(value == "cmd=-50005"){
					$("#data").val("&level=10&boost=0");
					tip.append("*格式：&level=等级&boost=模式<br>*模式：<br>0.只提升等级；<br>1.初级配置；<br>2.高级配置；<br>");
				}else if(value == "cmd=-50006"){
					$("#data").val("&title=?&content=?&userType=?&items=?");
					tip.append("*格式：&title=标题(必须)&content=内容(必须)&userType=邮件类型(必须)&items=类型_id_数量_10000(必须)<br>*邮件类型：1当前全服、2当前在线、3指定玩家、4长期全服。<br>*指定玩家需追加：“&openids=帐号_帐号”或“&nicknames=昵称_昵称”<br>");
				}else if(value == "cmd=-50007"){
					$("#data").val("&start=0&sleep=0&amount=0");
					tip.append("*格式：&start=状态&sleep=间隔&amount=数量<br>*状态：1开启，0关闭");
				}else if(value == "cmd=-50008"){
					$("#data").val("&banType=?&banTime=?");
					tip.append("*格式：&banType=类型&banTime=结束时间(秒)<br>*类型：1禁言，2封号");
				}else if(value == "cmd=-50009"){
					$("#data").val("&content=将在X时X分重启服务器！&colorId=5&secondNum=30&sendNum=10");
					tip.append("*格式：&content=内容&colorId=颜色品质&secondNum=间隔秒数&sendNum=发送数量<br>");
				}else if(value == "cmd=-50010"){
					$("#data").val("&type=1&orders=?");
					tip.append("*格式：&type=类型&orders=指令id_指令id<br>*类型：1关闭，2开启<br>");
				}else if(value == "cmd=-50011"){
					$("#data").val("&billno=?&amount=?");
					tip.append("*格式：&billno=订单&amount=充值数量<br>");
				}else if(value == "cmd=-50012"){
					$("#data").val("");
					tip.append("*格式：无<br>");
				}else if(value == "cmd=-50014"){
					$("#data").val("&params=?");
					tip.append("*格式：& params=id_level|id_level<br>");
				}else if(value == "cmd=-50015"){
					$("#data").val("&functionId=?");
					tip.append("*格式：&functionId=功能id(非自增长id)<br>");
				}else if(value == "cmd=-50016"){
					$("#data").val("&type=?&number=?");
					tip.append("*格式：&type=类型&number=次数<br>");
					tip.append(value2);
				}else{
					$("#data").val("");
				}
				if(value == "cmd=-50006" || value == "cmd=-50007" || value == "cmd=-50009" || value == "cmd=-50010" || value == "cmd=-50013"){
					$("#openid").val("");
					$("#openid").attr("disabled","disabled");
				}else{
					$("#openid").removeAttr("disabled");
				}
			}
		}
		function selectServer(){
			var value = $("#servers").val();
			if(value.length > 0){
				$("#url").val("");
				$("#url").attr("disabled","disabled");
			}else{
				$("#url").removeAttr("disabled");
				$("#url").val("http://localhost:8004");
			}
		}
		function stopServer(){
			var cmd = $("#stop").val();
			if(cmd.length == 0){
				alert("请填写指令编号");
			}else if(cmd.length == 6 && cmd.indexOf("-300") >= 0){
				cmd = "cmd=" + cmd;
				var data = encodeURI(cmd);
				var url = $("#servers").val();
				if(url.length <= 5){
					url = $("#url").val();
				}
				$.ajax({
					type:'post',
					url:url,
					data:data,
					dataType:'jsonp',
					jsonp: 'jsonpCallback',
					success:function(result){
						if(result.code == 0){
							alert("提交成功!");
						}else{
							alert("错误码:" + result.code)
						}
					},
					error:function(){
						alert("操作成功，服务器未返回数据！");
					}
				});
			}else{
				alert("请正确填写指令编号");
				$("#stop").val("");
			}
		}
		function sendAffiche(){
			var affiche = $("#affiche").val();
			if(affiche.length == 0){
				alert("请输入公告内容！");
			}else{
				var cmd = "cmd=-50009&content=" + affiche + "&colorId=5&secondNum=10&sendNum=100";
				var data = encodeURI(cmd);
				var url = $("#servers").val();
				if(url.length <= 5){
					url = $("#url").val();
				}
				$.ajax({
					type:'post',
					url:url,
					data:data,
					dataType:'jsonp',
					jsonp: 'jsonpCallback',
					success:function(result){
						if(result.code == 0){
							alert("提交成功!");
						}else{
							alert("错误码:" + result.code)
						}
					},
					error:function(){
						alert("操作成功，服务器未返回数据！");
					}
				});
			}
		}
	</script>
<div id="cmd_mgr">
	<h2 style="text-align:center;margin-top:20px;">后台工具</h2>
		<hr/><br>
		<input id="stop" style="width:295px" placeholder="停服cmd">
		<button style="width:295px" type="button" onclick="stopServer()">停服</button><br>
		<input id="affiche" style="width:295px" placeholder="公告内容">
		<button style="width:295px" type="button" onclick="sendAffiche()">发送停服公告</button><br>
		<button style="font:14px;width:105px;height:30px" disabled="disabled"><b>选择服务器：</b></button>
		<select id="servers" style="width:490px;height:30px;margin-left:0px" onChange="selectServer()">
			<option value ="">不选择（默认本地服务器）</option>
			<option value ="http://192.168.0.100:8004">100</option>
			<option value ="http://119.29.17.171:8004">TX</option>
			<option value ="http://192.168.0.104:8004">ZCK</option>
			<option value ="http://192.168.0.222:8004">HJW</option>
			<option value ="http://192.168.0.123:8004">DH</option>
		</select><br>
		<input id="url" style="height:30px;margin-left:0px;width:595px" placeholder="URL地址" value="http://localhost:8004"><br>
		<button style="font:14px;width:105px;height:30px" disabled="disabled"><b>　玩家帐号：</b></button>
		<input id="openid" style="width:490px;height:30px;margin-left:0px" placeholder="openid"><br>
		<button style="font:14px;width:105px;height:30px" disabled="disabled"><b>　选择指令：</b></button>
		<select id="orders" style="width:490px;height:30px;margin-left:0px" onChange="selectCmd()">
			<option value ="cmd=-50001">增加效益</option>
			<option value ="cmd=-50002">增加道具</option>
			<option value ="cmd=-50003">任务添加</option>
			<option value ="cmd=-50004">充值钻石</option>
			<option value ="cmd=-50005">一键提升</option>
			<option value ="cmd=-50006">发送系统邮件</option>
			<option value ="cmd=-50007">运行机器人</option>
			<option value ="cmd=-50008">封号/禁言</option>
			<option value ="cmd=-50009">发送公告</option>
			<option value ="cmd=-50010">开关指令</option>
			<option value ="cmd=-50011">充值</option>
			<option value ="cmd=-50012">重置玩家数据</option>
			<option value ="cmd=-50013">测试</option>
			<option value ="cmd=-50014">发送装备</option>
			<option value ="cmd=-50015">开放功能</option>
			<option value ="cmd=-50016">次数添加</option>
			<option value ="">其他</option>
		</select><br>
		<button style="width:40px;height:80px" disabled="disabled"><b>参<br>数</b></button>
		<textarea id="data" rows="5" cols="65" placeholder="&名词=值&名词=值" >&economys=?</textarea><br><br>
		<button style="width:295px" id="submit" name="submit" type="button" onclick="submit()">确定</button>
		<button style="width:295px" id="reset" name="reset" type="button" onclick="reset()">重置</button><br>
		<hr><br>
		<button style="width:40px;height:120px" disabled="disabled"><b>说<br>明</b></button>
		<textarea id="tip" rows="8" cols="65"></textarea><br>
		<hr><br>
</div>