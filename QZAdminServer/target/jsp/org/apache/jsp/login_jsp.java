package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.cache.SysUserCache;
import java.util.*;
import com.web.db.bean.*;
import com.db.util.*;
import java.sql.*;
import com.utils.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");

	session.removeAttribute("user");
	session.removeAttribute("selserver");
	session.removeAttribute("userGroup");
	String rat = request.getParameter("rat");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	if(username != null && username.length() > 0 && password != null && password.length() > 0){
		SysUserInfo user = SysUserCache.getSysUserInfo(username, password);
		if(user == null){
			session.setAttribute("username", username);
			session.setAttribute("error", "用户名或密码错误!");
			response.sendRedirect("index.jsp");
		}else{
			session.setAttribute("user", user);
			session.setAttribute("rat", rat);
			response.sendRedirect("main.jsp");
		}
	}else{
		if(username != null || password != null){
			session.setAttribute("error", "用户名或密码错误!");
		}
		response.sendRedirect("index.jsp");
	}

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
