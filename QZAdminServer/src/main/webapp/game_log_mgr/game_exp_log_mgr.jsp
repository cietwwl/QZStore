<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search_div" style="display:table;">
	<span style="float:left;">
		<select id="consumeType" style="padding:2px;display: none;">
			<option value="0" selected="selected">全部</option>
			<option value="1">获得</option>
			<option value="2">消耗</option>
		</select>
		<span id="slt_span" style="margin-left:5px;margin-top:-5px;"></span>
		<select id="searchName" style="padding:2px;">
			<option value="user_id" selected="selected">玩家ID</option>
		</select>
		<input type="text" id="searchValue" style="margin-left:5px;margin-top:-5px;" >
		<input style="margin-left:5px;margin-top:-5px;" type="button" class="button orange small" value="查询" onclick="searchMoneyLog();"/>
		<input style="margin-left:5px;margin-top:-5px;display: none;" type="button" class="button orange small" value="下载" onclick="openDownloadDialog();"/>
	</span>
</div>
<div id="download_div" style="display:none;">
	<table>
		<tr>
			<td align="right" style="padding:2px;width:110px;">
				操作
			</td>
			<td align="left" style="padding:2px;">
				<select id="downconsumeType" style="padding:2px;">
					<option value="0" selected="selected">全部</option>
					<option value="1">获得</option>
					<option value="2">消耗</option>
				</select>
			</td>
		</tr>
		<tr>
			<td align="right" style="padding:2px;width:110px;">
				<select id="downsearchName" style="padding:2px;">
					<option value=user_id selected="selected">玩家ID</option>
				</select>
			</td>
			<td align="left" style="padding:2px;">
				<input type="text" id="downsearchValue"/>
			</td>
		</tr>
		<tr>
			<td align="right" style="padding:2px;width:110px;">
				开始时间
			</td>
			<td align="left" style="padding:2px;">
				<input id="downbegintime" />
			</td>
		</tr>
		<tr>
			<td align="right" style="padding:2px;width:110px;">
				结束时间
			</td>
			<td align="left" style="padding:2px;">
				<input id="downendtime" />
			</td>
		</tr>
	</table>
</div>
<table id="exp_log_table"></table>
<!-- 经验日志 -->
<script type="text/javascript">
var datas;
function dispose(){
	$("#search_div").remove();
	$("#download_div").remove();
	$("#exp_log_table").remove();
	datas = null;
}
function ready(){
	$("#slt_span").html("<input id='begin' />　至　 <input id='end' />");
	$("#begin").datepicker({ 
      	minDate: new Date(openTime * 1000),  
      	maxDate: new Date()
	}).datepicker("setDate" , getLastDate(new Date(), 1 * 24 * 60 * 60 * 1000)); 
	$("#end").datepicker({
	    firstDay: 2,             
      	minDate: new Date(openTime * 1000),    
      	maxDate: new Date()
	}).datepicker("setDate" ,(new Date));
	
	$("#downbegintime").datepicker({ 
      	minDate: new Date(openTime * 1000),    
      	maxDate: new Date()
	}).datepicker("setDate" ,(new Date)); 
	$("#downendtime").datepicker({ 
      	minDate: new Date(openTime * 1000),   
      	maxDate: new Date(),
	}).datepicker("setDate" ,(new Date)); 
	
	$("#exp_log_table").flexigrid({
		url : 'game_log_mgr/get_game_exp_log_list.jsp',
   	    dataType : 'json',
	    preProcess : function(data){
	    	datas = data;
	    	return data;
	    },
   	 	colModel : [{display : '玩家ID',
	        name : 'userId',
	        width : 50,
	        align : 'center'
		},{display : '玩家名称',
			name : 'playername',
	        width : 80,
	        align : 'center'
		},{display : '类型',
			name : 'typeName',
	        width : 80,
	        align : 'center'
		},{display : '操作',
			name : 'num',
	        width : 50,
	        align : 'center',
	        customValue : function(i, idx, num){
	        	if(num > 0){
	        		return "<span style='color:green;'>获得</span>";
	        	}else{
	        		return "<span style='color:red;'>消耗</span>";
	        	}
	        }
		},{display : '原有数量',
			name : 'originalAmount',
	        width : 80,
	        align : 'center'
		},{display : '操作数量',
			name : 'num',
	        width : 80,
	        align : 'center'
		},{display : '剩余数量',
			name : 'surplusAmount',
	        width : 80,
	        align : 'center'
		},{display : '描述',
			name : 'description',
	        width : 160,
	        align : 'center'
		},{
			display : '时间',
			name : 'createTime',
	        width : 120,
	        align : 'center'
		}],
		usepager : true,
	    title : '经验日志',
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
	searchMoneyLog();
}
function searchMoneyLog(){
	begin = $("#begin").datepicker("getDate");
	end = $("#end").datepicker("getDate");
	if(end.getTime() < begin.getTime()){
		alert("结束日期不能小于开始日期");
		return;
	}
	var params = [{name:'consumeType',value:$("#consumeType").val()},
	              {name:'searchName',value:$("#searchName").val()},
	              {name:'searchValue',value:$("#searchValue").val()},
	              {name:'begintime',value:$("#begin").val()},
	              {name:'endtime',value:$("#end").val()}];
	$("#exp_log_table").flexOptions({
		params:params,
		newp:1
	});
	$("#exp_log_table").flexReload();
}
function openDownloadDialog(){
	$("#downconsumeType").val($("#consumeType").val());
	$("#downsearchName").val($("#searchValue").val());
	$("#downsearchValue").val($("#searchValue").val());
	$("#downbegintime").val($("#begin").val());
	$("#downendtime").val($("#end").val());
	$("#download_div").dialog({
		title:'下载在线数据报表',
		resizable:false,
		modal:true,
		autoOpen:true,
		draggable:true,
		buttons:{
			"取消" : function(){
				$(this).dialog("close");
			},
			"确定" : function(){
				begin = $("#downbegintime").datepicker("getDate");
				end = $("#downendtime").datepicker("getDate");
				if(end.getTime() < begin.getTime()){
					alert("结束日期不能小于开始日期");
					return;
				}
				var form = $("<form>");  
				form.attr('style','display:none');
				form.attr('target','');  
				form.attr('method','post');  
				form.attr('action','game_log_mgr/download_game_money_log.jsp');
				var input1 = $("<input type='text' name='begintime' value='" + $("#downbegintime").val() + "'>");
				form.append(input1);
				var input2 = $("<input type='text' name='endtime' value='" + $("#downendtime").val() + "'>");
				form.append(input2); 
				var input3 = $("<input type='text' name='consumeType' value='" + $("#downconsumeType").val() + "'>");
				form.append(input3);
				var input4 = $("<input type='text' name='searchValue' value='" + $("#downsearchValue").val() + "'>");
				form.append(input4);
				var input6 = $("<input type='text' name='searchName' value='" + $("#downsearchName").val() + "'>");
				form.append(input6);
				$('body').append(form); 
				form.submit();  
				form.remove();
				$(this).dialog("close");
			}
		}
	});
}
</script>