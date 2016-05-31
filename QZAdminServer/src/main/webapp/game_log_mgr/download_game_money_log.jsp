<%@page import="com.execel.formater.ConsumeTypeFormater"%>
<%@page import="com.execel.formater.MoneyTypeFormater"%>
<%@page import="com.execel.formater.TimeFormater"%>
<%@page import="com.utils.ExcelUtil"%>
<%@page import="com.execel.formater.TimeHourFormater"%>
<%@page import="com.execel.formater.ValueFormater"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="net.sf.json.JSONArray"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.db.util.ConnUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.db.util.ConnParam"%>
<%@page import="com.utils.StringUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.utils.TimeUtil.DATE_FORMATER"%>
<%@page import="com.utils.TimeUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
/**
	String searchName = request.getParameter("searchName").trim();
	String searchValue = request.getParameter("searchValue").trim();
	int consumeType = Integer.parseInt(request.getParameter("consumeType"));
	int moneyType = Integer.parseInt(request.getParameter("moneyType"));
	String begintime = request.getParameter("begintime");
	String endtime = request.getParameter("endtime");
	int t1 = TimeUtil.getSecond(TimeUtil.parseDate(begintime, DATE_FORMATER.yyyy_MM_dd).getTime());
	int t2 = TimeUtil.getSecond(TimeUtil.parseDate(endtime, DATE_FORMATER.yyyy_MM_dd).getTime()) + TimeUtil.DAY_SECOND;
	List<MoneyLogInfo> list = new ArrayList<MoneyLogInfo>();
	String orderby = "";
	String condition = " where n_time>=" + t1 + " and n_time<=" + t2;
	int now = TimeUtil.getNowSecond();
	if(searchValue.length() > 0){
		condition += " and n_" + searchName + " like " + StringUtil.getSqlValue(searchValue);
	}
	if(consumeType != 0){
		condition += " and n_consumeType=" + StringUtil.getSqlValue(consumeType);
	}
	if(moneyType != 0){
		condition += " and n_moneyType=" + StringUtil.getSqlValue(moneyType);
	}
	int total = 0;
	GameServerInfo server = (GameServerInfo)session.getAttribute("selserver");
	ConnParam mainConnParam = server.getMainConnParam();
	Connection conn = ConnUtil.getConnection(mainConnParam);
	try{
		Statement stmt = conn.createStatement();
		try{
			String sql = "select * from t_moneyloginfo " + condition + orderby;
			ResultSet result = stmt.executeQuery(sql);
			try{
				while(result.next()){
					MoneyLogInfo log = new MoneyLogInfo();
					log.read(result);
					list.add(log);
				}
			}finally{
				result.close();
			}
			String sql1 = "select count(n_id) from t_moneyloginfo" + condition;
			ResultSet result1 = stmt.executeQuery(sql1);
			try{
				if(result1.next()){
					total = result1.getInt(1);
				}
			}finally{
				result1.close();
			}
		}finally{
			stmt.close();
		}
	}finally{
		conn.close();
	}
	
	out.clear();
	out = pageContext.pushBody();
    String filedownload = "金钱报表" + begintime + "_" + endtime + ".xls";  
    String filedisplay = filedownload;
    filedisplay = new String(filedisplay.getBytes("utf-8"),"iso8859-1");   
    response.addHeader("Content-Disposition","attachment;filename=" + filedisplay);  
    
    OutputStream outp = null;  
    FileInputStream in = null;  
    try{
    	outp = response.getOutputStream();
    	List<ValueFormater> formaters = new ArrayList<ValueFormater>();
    	ValueFormater f1 = new ValueFormater("玩家ID", "uid");
    	formaters.add(f1);
    	ValueFormater f2 = new ValueFormater("玩家账号", "openid");
    	formaters.add(f2);
    	ValueFormater f3 = new ValueFormater("玩家昵称", "nickname");
    	formaters.add(f3);
    	CmdNameFormater f5 = new CmdNameFormater("功能", "cmd");
    	formaters.add(f5);
    	ConsumeTypeFormater f6 = new ConsumeTypeFormater("操作", "consumeType");
    	formaters.add(f6);
    	MoneyTypeFormater f7 = new MoneyTypeFormater("货币类型", "moneyType");
    	formaters.add(f7);
    	ValueFormater f8 = new ValueFormater("原额", "money");
    	formaters.add(f8);
    	ValueFormater f9 = new ValueFormater("操作金额", "consumeMoney");
    	formaters.add(f9);
    	ValueFormater f10 = new ValueFormater("余额", "overplusMoney");
    	formaters.add(f10);
    	TimeFormater f11 = new TimeFormater("时间", "time");
    	formaters.add(f11);
        ExcelUtil.write("金钱报表", list, formaters, outp);
        outp.flush();
     }catch(Exception e)  {
         e.printStackTrace();  
     }finally{  
         if(in != null)  
         {  
             in.close();  
             in = null;  
         }  
         if(outp != null)  
         {  
             outp.close();  
             outp = null;  
         }  
     }
*/
%>