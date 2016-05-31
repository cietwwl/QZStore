package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.web.db.bean.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\r');
      out.write('\n');

	SysUserInfo user = (SysUserInfo)session.getAttribute("user");
	if(user != null){
		response.sendRedirect("main.jsp");
	}
	String username = (String)session.getAttribute("username");
	if(username == null){
		username = "";
	}

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\r\n");
      out.write("<HTML xmlns=\"http://www.w3.org/1999/xhtml\"><HEAD><TITLE>网站管理系统-网站后台管理</TITLE>\r\n");
      out.write("<META content=\"text/html; charset=utf-8\" http-equiv=Content-Type>\r\n");
      out.write("<STYLE type=text/css>* {\r\n");
      out.write("\tFONT-SIZE: 9pt; \r\n");
      out.write("\tOVERFLOW: hidden;\r\n");
      out.write("\tvertical-align: middle;\r\n");
      out.write("}\r\n");
      out.write("BODY {\r\n");
      out.write("\tMARGIN: 0 auto;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("</STYLE>\r\n");
      out.write("\r\n");
      out.write("<META name=GENERATOR content=\"MSHTML 8.00.6001.23520\"></HEAD>\r\n");
      out.write("<BODY>\r\n");
      out.write("<FORM onsubmit=\"return chk(this);\" method=\"post\" name=NETSJ_Login action=\"login.jsp\">\r\n");
      out.write("<TABLE border=0 cellSpacing=0 cellPadding=0 width=940 bgColor=#ffffff align=center>\r\n");
      out.write("  <TBODY>\r\n");
      out.write("  <TR>\r\n");
      out.write("    <TD style=\"BACKGROUND: url(css/admin/login01.jpg)\" height=238>&nbsp;</TD>\r\n");
      out.write("    </TR>\r\n");
      out.write("\t  <TR>\r\n");
      out.write("\t    <TD height=190>\r\n");
      out.write("\t      <TABLE border=0 cellSpacing=0 cellPadding=0 width=\"100%\">\r\n");
      out.write("\t        <TBODY>\r\n");
      out.write("\t\t        <TR>\r\n");
      out.write("\t\t          <TD style=\"BACKGROUND: url(css/admin/login02.jpg)\" height=190 width=208>&nbsp;</TD>\r\n");
      out.write("\t\t          <TD style=\"BACKGROUND: url(css/admin/login03.jpg)\" width=518>\r\n");
      out.write("\t\t\t            <TABLE border=0 cellSpacing=0 cellPadding=0 width=320 align=center>\r\n");
      out.write("\t\t\t\t            <TBODY>\r\n");
      out.write("\t\t\t\t              <tr>\r\n");
      out.write("\t\t\t\t              \t<td height=40><img src=\"css/admin/user.gif\" width=30 height=30 style=\"margin-left:20px;margin-top:0px;margin-right: 0px;\">　用户名</td>\r\n");
      out.write("\t\t\t\t                <td height=40><input id=\"username\" value='");
      out.print(username );
      out.write("' name=\"username\" style=\"width: 150px;margin-left:5px;margin-top:0px;\"></td>\r\n");
      out.write("\t\t\t\t              </tr>\r\n");
      out.write("\t\t\t\t              <tr>\r\n");
      out.write("\t\t\t\t                <td height=40><img src=\"css/admin/password.gif\" width=30 height=30 style=\"margin-left:20px;margin-top:0px;\">　密　码</td>\r\n");
      out.write("\t\t\t\t                <td height=40><input id=\"password\" type=\"password\" name=\"password\" style=\"width: 150px;margin-left:5px;margin-top:0px;\"></td>\r\n");
      out.write("\t\t\t\t              </tr>\r\n");
      out.write("\t\t\t\t              <tr>\r\n");
      out.write("\t\t\t\t                <th height=60 colspan=\"2\"><input src=\"css/admin/login.gif\" type=\"image\" name=\"submit\"> </th>\r\n");
      out.write("\t\t\t\t              </tr>\r\n");
      out.write("\t\t\t\t              <tr>\r\n");
      out.write("\t\t\t\t              \t<th colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t              \t<input id=\"rat1\" type=\"radio\" name=\"rat\" value=\"1\" style=\"margin-top:0px;\" checked=\"checked\"><label for=\"rat1\">1024 × 768</label>\r\n");
      out.write("\t\t\t\t\t              \t<input id=\"rat2\" type=\"radio\" name=\"rat\" value=\"2\" style=\"margin-left:10px;margin-top:0px;\"><label for=\"rat2\">1280 × 720</label>\r\n");
      out.write("\t\t\t\t\t              \t<input id=\"rat3\" type=\"radio\" name=\"rat\" value=\"3\" style=\"margin-left:10px;margin-top:0px;\"><label for=\"rat3\">1440 × 900</label>\r\n");
      out.write("\t\t\t\t              \t</th>\r\n");
      out.write("\t\t\t\t              </tr>\r\n");
      out.write("\t\t\t\t            </TBODY>\r\n");
      out.write("\t\t\t            </TABLE>\r\n");
      out.write("\t\t            </TD>\r\n");
      out.write("\t\t         <TD style=\"BACKGROUND: url(css/admin/login04.jpg)\" width=214>&nbsp;</TD>\r\n");
      out.write("\t\t       </TR>\r\n");
      out.write("\t       </TBODY>\r\n");
      out.write("\t     </TABLE>\r\n");
      out.write("\t   </TD>\r\n");
      out.write("\t </TR>\r\n");
      out.write("  <TR>\r\n");
      out.write("  <TD style=\"BACKGROUND: url(css/admin/login05.jpg)\" height=133>&nbsp;</TD>\r\n");
      out.write("  </TR></TBODY></TABLE></FORM>\r\n");
      out.write("<SCRIPT language=JavaScript type=text/JavaScript>\r\n");
      out.write("function chk(a)\r\n");
      out.write("{\r\n");
      out.write("\tif (a.username.value==\"\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\talert (\"请输入管理帐号！\");\r\n");
      out.write("\t\ta.username.focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\tif (a.password.value==\"\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\talert(\"请输入管理密码\");\r\n");
      out.write("\t\ta.password.focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\ta.submit.value=\"正在登陆中...\";\r\n");
      out.write("\ta.submit.disabled=true;\r\n");
      out.write("\ta.Submit.disabled=true;\r\n");
      out.write("}\r\n");

	String error = (String)session.getAttribute("error");
	if(error!=null){

      out.write("\r\n");
      out.write("\t\talert('");
      out.print(error);
      out.write("');\r\n");

		session.setAttribute("error", null);
	}

      out.write("\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("</BODY></HTML>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
