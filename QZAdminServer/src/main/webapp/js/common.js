$.datepicker.setDefaults({
	 autoSize: true ,         //???
	    showButtonPanel: true ,  // 显示按钮面板，包括 “今天” “关闭”
	    gotoCurrent: false,       //???
	    
	    //defaultDate: +7,       // 默认显示日期
	    firstDay: 1,             //???
	    
	    /* 选择约束 */
	    hideIfNoPrevNext: true,  // 当设置了最小日期\最大日期，且符合条件时隐藏导航按钮
	 monthNames: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
     monthNamesShort: ['一月','二月','三月','四月','五月','六月',
     '七月','八月','九月','十月','十一月','十二月'],
     dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],
     dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
     dayNamesMin: ['日','一','二','三','四','五','六'],
     currentText: '今天',
     dateFormat: 'yy-mm-dd',
	    /* 导航类 */
	    navigationAsDateFormat: true,
	    showOtherMonths: true,   // 是否在面板的空余格子中显示临近的月份的日子
	    selectOtherMonths: false, // 临近的月份的日子是否可选 
	    stepMonths: 1,           // 一次翻一个月
	    changeMonth: true,       // 可使用下拉列表改变月份
	    //changeYear: true,      // 可使用下拉列表改变年份
	    
	    /* 多面板 */
	    numberOfMonths: [ 1, 1 ],// 一次显示 a * b 个月的日期，展现为a行b列
	    showCurrentAtPos: 0,     // 显示多月时，设置在第几个面板显示当月。和 changeMonth 冲突？(下拉只能显示在第一个面板)
	    
	    /* 面板展现 */
	    showAnim: "fold",        // 折叠的方式展开，非内嵌时才管用
	    
	    /* 国际化\自定义文本配置 */
	    closeText: "关闭",
	    yearSuffix: "年",
	    //prevText: ""
	    nextText: "下一月",
	    
	    /* 周数 */
	    showWeek: true,          // 是否显示该年周数
	    weekHeader: "周"         // 周数列表头名称
});
$(function() {
    $.ajaxSetup({cache:false});
	$("#sl-accordion").accordion();

        $(".sl-selectable").selectable({
            selected:function(){
                        $(".ui-selected", this).each(function(){
                            link=$(this).attr('link');
                            name=$(this).attr('name');
                            renewTab(link, name);
                        });
            }
        });
        $("#sl-tabs").tabs({
            load:function(event,ui){
            	if(typeof ready=="function"){
                	ready();
            	}
            }
        });
});

//刷新tabs
function renewTab(link,name){
	if(typeof dispose == "function"){
		dispose();
	}
    $("#sl-tabs ul li").each(function(){
       $("#sl-tabs").tabs('remove',0);
    });
    $("#sl-tabs div").each(function(index, dom){
    	$(dom).remove();
    });
    $("#sl-tabs").tabs('add',link, name);
}

function changeGameServer(){
	var check = document.getElementById("checkState").checked ? 1 : 0;
	var name = $('#gameServer option:selected').text();
	$.ajax({url:"game_server_mgr/url_server_select.jsp",
		data:{check : check,
			sid : $("#gameServer").val()},
		type:"post",
		dataType:"json",
		cache:false,
		success:function(response){
			if(response.sign == 1){
				openTime = response.openTime;
				alert("选择服务器 [" + name + "] 成功!");
				ready();
			}else{
				$("#gameServer").val(response.oid);
				if(response.sign == 2){
					alert("服务器 [" + name + "] 管理地址或端口不可用，请重新选择!");
				}else{
					alert("服务器选择失败，请重新选择!");
				}
				$("#gameServer").Attr("selected", "selected");
			}
		}
	});
}

function getQualityColor(quality){
	if(quality == 1){
		return "#fff3c8";
	}else if(quality == 2){
		return "#00ff00";
	}else if(quality == 3){
		return "#3480ff";
	}else if(quality == 4){
		return "#c000ff";
	}else if(quality == 5){
		return "#ff6600";
	}else if(quality == 6){
		return "#fff21b";
	}else{
		return "#ffffff";
	}
}

function getStarName(i, idx, quality){
	return quality + "星";
}

function getTimeStr(i, idx, time){
	if(time > 0){
		datetime = new Date(time * 1000);
		var year = datetime.getFullYear();
		var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
		var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
		var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
		var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
		var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
		return year + "-" + month + "-" + date+" "+hour+":"+minute+":"+second;
	}else{
		return "";
	}
}
function getTimeStr1(i, idx, time){
	if(time > 0){
		datetime = new Date(time * 1000);
		var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
		var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
		return hour+":"+minute;
	}
	return "00:00";
}
function getTimeStr2(i, idx, time){
	if(time > 0){
		var datetime = new Date(time * 1000);
		var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
		var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
		var second = datetime.getSeconds() < 10 ? "0" + datetime.getSeconds() : datatime.getSeconds();
		return hour + ":" + minute + ":" + second;
	}
	return "00:00:00";
}

function getTimeStr3(i, idx, time){
	if(time > 0){
		var datetime = new Date(time * 1000);
		var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
		var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
		return hour + ":" + minute;
	}
	return "00:00";
}
function getHourTimeStr(hour){
	return (hour < 10 ? "0" + hour : hour) + ":00";
}

function getDateStr(i, idx, time){
	datetime = new Date(time * 1000);
	var year = datetime.getFullYear();
	var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
	var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
	return year + "-" + month + "-" + date;
}

function getDateChinaStr(i, idx, time){
	datetime = new Date(time * 1000);
	var year = datetime.getFullYear();
	var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
	var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
	return year + "年" + month + "月" + date + "日";
}
function getDateChinaTimeStr(i, idx, time){
	if(time > 0){
		datetime = new Date(time * 1000);
		var year = datetime.getFullYear();
		var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
		var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
		var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
		var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
		var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
		return year + "年" + month + "月" + date + "日 " + hour + ":" + minute + ":" + second;
	}
	return "";
}

function getLogoutTimeStr(i, idx, logoutTime){
	if(logoutTime == 0){
		return "在线";
	}else if(logoutTime == -1){
		return "异常";
	}else{
		return getTimeStr(i, idx, logoutTime);
	}
}

function getUserGroupTypeName(i, idx, type){
	if(type == 1){
		return "管理员";
	}
	return "普通用户";
}

function getCmdName(i, idx, cmd){
	cmd = cmd.replace("-", "_");
	return CMD["CMD_" + cmd];
}

function isInteger(value){
	var reg=/^[^0][\d]?$/;
	return reg.test(value);
}

function getNextDate(time){
	var date = new Date();
	var newtime=date.getTime()+time;  
	date.setTime(newtime);
	return date;
}

function getLastDate(date, time){
	var newtime=date.getTime()-time;  
	return new Date(newtime);
}


function showError(response){
	if(response.code != 0){
		if(response.tip != null && response.tip.length > 0){
			alert(response.tip);
		}else{
			alert("系统错误!");
		}
		return true;
	}
	return false;
}

function getGoodsTypeName(type){
	var n = Number(type);
	switch(n){
	case 1:
		return "英雄";
	case 2:
		return "金币";
	case 3:
		return "钻石";
	case 4:
		return "道具";
	case 5:
		return "灵气";
	case 6:
		return "装备";
	case 7:
		return "武魂";
	case 8:
		return "英雄经验";
	case 9:
		return "熔炼点数";
	case 10:
		return "上古石板";
	}
}

/**
 * 得到邮件发送类型
 * @param sendType
 * @returns {String}
 */
function getMailSendTypeName(sendType){
	switch(sendType){
		case 1:
			return "指定玩家";
		case 3:
			return "当前注册";
		case 4:
			return "指定时间段(登录/注册)";
		case 5:
			return "永久全服";
	}
}

function getPartName(i, idx, part){
	if(part == 1){
		return "武器";
	}else if(part == 2){
		return "防具";
	}else{
		return "未知";
	}
}

function getPartner(i, idx, partner){
	for(var i = 0; i < partnerKey.length; i++){
		if(partner == partnerKey[i]){
			return partnerVal[i];
		}
	}
	return partner;
}


function getHour(num){
	var hour = "<select id='hour" + num + "' style='width:40px;'>"
	for(var i = 0; i < 24; i++){
		var val = "" + i;
		if(i < 10){
			val = "0" + i;
		}
		hour += "<option value =" + val + ">" + val + "</option>";
	}
	return hour + "</select>";
}
function getMinute(num){
	var minute = "<select id='minute" + num + "' style='width:40px;'>"
	for(var i = 0; i < 24; i++){
		var val = "" + i;
		if(i < 10){
			val = "0" + i;
		}
		minute += "<option value =" + val + ">" + val + "</option>";
	}
	return minute + "</select>";
}
function formatTime(date){
	return date.getFullYear() + "-" + toTimeValue(date.getMonth(), true) + "-" + toTimeValue(date.getDate(), false) + " " + toTimeValue(date.getHours(), false) + ":" + toTimeValue(date.getMinutes(), false) + ":00"
}
function parseDate(value){
	value = value.replace(/ /g, ";")
	value = value.replace(/-/g, ";")
	value = value.replace(/:/g, ";")
	var val = value.split(";");
	return new Date(val[0], val[1], val[2], val[3], val[4], val[5]);
}
function toTimeValue(num, add){
	if(add){
		num ++;
	}
	var value = num.toString();
	if(value.length == 1){
		return "0" + value;
	}
	return value;
}
function getTimeByName(timeName, timeId){
	return "<table style='margin:auto;'><tr><td style='text-align:right;'>" + timeName + ":</td><td style='text-align:left;'><input id='" + timeId + "'/>" + getHour(0) + getMinute(0) + "</td></tr>";
}
function getTime(startId, endId){
	return "<table style='margin:auto;'><tr><td style='text-align:right;'>开始时间:</td><td style='text-align:left;'><input id='" + startId + "'/>" + getHour(1) + getMinute(1) + "</td></tr>"
		+ "<tr><td style='text-align:right;'>结束时间:</td><td style='text-align:left;'><input id='" + endId + "'/>" + getHour(2) + getMinute(2) + "</td></tr></table>";
}
function toTimeByOne(timeId){
	return $("#" + timeId).val() + " " + $("#hour0").val() + ":" + $("#minute0").val() + ":00";
}
function toTime(startId, endId){
	var start = $("#" + startId).val();
	var hour1 = $("#hour1").val();
	var minute1 = $("#minute1").val();
	var end = $("#" + endId).val();
	var hour2 = $("#hour2").val();
	var minute2 = $("#minute2").val();
	return start + " " + hour1 + ":" + minute1 + ":00--" + end + " " + hour2 + ":" + minute2 + ":00";
}
function pickerMinDate(id, date){  //嵌入最小日期模版
	pickerDateByMin(id, date, new Date());
}
function pickerMaxDate(id, date){  //嵌入最大日期
	$("#" + id).datepicker({
		maxDate:date
	}).datepicker("setDate", new Date());
}
function pickerMaxMinDate(id, max, min){
	$("#" + id).datepicker({
		minDate:min,
		maxDate:max
	}).datepicker("setDate", new Date());
}
function pickerDate(id, date){  //嵌入日期模版
	$("#" + id).datepicker({}).datepicker("setDate" ,date); 
}
function pickerDateByMin(id, min, date){
	$("#" + id).datepicker({ 
		 minDate: min,     // 最小日期
	}).datepicker("setDate" , date);
}
function timeOddDialog(dialogId, title, timeName, timeId, inputId){//弹窗
	dig1 = $("#" + dialogId);
	dig1.html(getTimeByName(timeName, timeId));
	dig1.dialog({
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		title:title,
		buttons:{
			"取消":function(){
				$(this).dialog("close");
			},
			"确定":function(){
				$("#" + inputId).val(toTimeByOne(timeId));
				$(this).dialog("close");
			}
		}
	});
}
function timeDialog(dialogId, title, startId, endId, inputId){//弹窗
	dig2 = $("#" + dialogId);
	dig2.html(getTime(startId, endId));
	dig2.dialog({
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		title:title,
		buttons:{
			"取消":function(){
				$(this).dialog("close");
			},
			"确定":function(){
				$("#" + inputId).val(toTime(startId, endId));
				$(this).dialog("close");
			}
		}
	});
}
function whether(i, idx, value){//判断是否
	if(value > 0){
		return "是";
	}else{
		return "否";
	}
}
