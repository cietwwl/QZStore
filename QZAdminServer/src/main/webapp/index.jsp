<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,com.web.db.bean.*"%>
<%
	SysUserInfo user = (SysUserInfo)session.getAttribute("user");
	if(user != null){
		response.sendRedirect("main.jsp");
	}
	String username = (String)session.getAttribute("username");
	if(username == null){
		username = "";
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>网站管理系统-网站后台管理</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<STYLE type=text/css>* {
	FONT-SIZE: 9pt; 
	OVERFLOW: hidden;
	vertical-align: middle;
}
BODY {
	MARGIN: 0 auto;
	text-align: center;
}
</STYLE>

<META name=GENERATOR content="MSHTML 8.00.6001.23520"></HEAD>
<BODY>
<FORM onsubmit="return chk(this);" method="post" name=NETSJ_Login action="login.jsp">
<TABLE border=0 cellSpacing=0 cellPadding=0 width=940 bgColor=#ffffff align=center>
  <TBODY>
  <TR>
    <TD style="BACKGROUND: url(css/admin/login01.jpg)" height=238>&nbsp;</TD>
    </TR>
	  <TR>
	    <TD height=190>
	      <TABLE border=0 cellSpacing=0 cellPadding=0 width="100%">
	        <TBODY>
		        <TR>
		          <TD style="BACKGROUND: url(css/admin/login02.jpg)" height=190 width=208>&nbsp;</TD>
		          <TD style="BACKGROUND: url(css/admin/login03.jpg)" width=518>
			            <TABLE border=0 cellSpacing=0 cellPadding=0 width=320 align=center>
				            <TBODY>
				              <tr>
				              	<td height=40><img src="css/admin/user.gif" width=30 height=30 style="margin-left:20px;margin-top:0px;margin-right: 0px;">　用户名</td>
				                <td height=40><input id="username" value='<%=username %>' name="username" style="width: 150px;margin-left:5px;margin-top:0px;"></td>
				              </tr>
				              <tr>
				                <td height=40><img src="css/admin/password.gif" width=30 height=30 style="margin-left:20px;margin-top:0px;">　密　码</td>
				                <td height=40><input id="password" type="password" name="password" style="width: 150px;margin-left:5px;margin-top:0px;"></td>
				              </tr>
				              <tr>
				                <th height=60 colspan="2"><input src="css/admin/login.gif" type="image" name="submit"> </th>
				              </tr>
				              <tr>
				              	<th colspan="2">
					              	<input id="rat1" type="radio" name="rat" value="1" style="margin-top:0px;" checked="checked"><label for="rat1">1024 × 768</label>
					              	<input id="rat2" type="radio" name="rat" value="2" style="margin-left:10px;margin-top:0px;"><label for="rat2">1280 × 720</label>
					              	<input id="rat3" type="radio" name="rat" value="3" style="margin-left:10px;margin-top:0px;"><label for="rat3">1440 × 900</label>
				              	</th>
				              </tr>
				            </TBODY>
			            </TABLE>
		            </TD>
		         <TD style="BACKGROUND: url(css/admin/login04.jpg)" width=214>&nbsp;</TD>
		       </TR>
	       </TBODY>
	     </TABLE>
	   </TD>
	 </TR>
  <TR>
  <TD style="BACKGROUND: url(css/admin/login05.jpg)" height=133>&nbsp;</TD>
  </TR></TBODY></TABLE></FORM>
<SCRIPT language=JavaScript type=text/JavaScript>
function chk(a)
{
	if (a.username.value=="")
	{
		alert ("请输入管理帐号！");
		a.username.focus();
		return false;
	}
	if (a.password.value=="")
	{
		alert("请输入管理密码");
		a.password.focus();
		return false;
	}
	a.submit.value="正在登陆中...";
	a.submit.disabled=true;
	a.Submit.disabled=true;
}
<%
	String error = (String)session.getAttribute("error");
	if(error!=null){
%>
		alert('<%=error%>');
<%
		session.setAttribute("error", null);
	}
%>
</SCRIPT>
</BODY></HTML>