package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import com.cache.SysMenuCache;
import com.web.db.bean.SysMenuInfo;
import com.web.db.game.GameServerInfo;
import java.util.List;
import com.cache.GameServerCache;
import com.cache.SysUserCache;
import com.web.obj.UserGroup;
import com.web.db.bean.SysUserInfo;
import com.cache.GamePartnerCache;
import java.util.Map.Entry;
import java.util.Map;
import com.utils.TimeUtil;
import com.web.db.game.GameServerInfo;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/config.jsp");
    _jspx_dependants.add("/jsp/global_config.jsp");
  }

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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	SysUserInfo user = (SysUserInfo)session.getAttribute("user");
	if(user == null){
		response.sendRedirect("index.jsp");
		return ;
	}
	UserGroup group = (UserGroup)session.getAttribute("userGroup");
	if(group == null){
		group = SysUserCache.getUserGroup(user.getUserGroupId());
		if(group == null){
			response.sendRedirect("index.jsp");
			return ;
		}
		session.setAttribute("userGroup", group);
	}
	GameServerInfo selserver = (GameServerInfo)session.getAttribute("selserver");
	if(selserver == null){
		GameServerCache.initDefaultServer(session);
	}
	List<GameServerInfo> servers = GameServerCache.getGameServers();
	List<SysMenuInfo> menus = SysMenuCache.getMenus(group);
	String mainCcs = null;
	int rat = Integer.parseInt((String)session.getAttribute("rat"));
	if(rat == 1){
		mainCcs = "css/admin/basic1.css?version=1.1";
	}else if(rat == 2){
		mainCcs = "css/admin/basic.css?version=1.1";
	}else{
		mainCcs = "css/admin/basic2.css?version=1.1";
	}

      out.write(" \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta http-equiv=\"Content-Language\" content=\"zh-cn\" />\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("    <meta name=\"Robots\" content=\"all\" />\r\n");
      out.write("    <meta name=\"keywords\" content=\"all\" />\r\n");
      out.write("    <meta name=\"description\" content=\"\" />\r\n");
      out.write("    <meta name=\"author\" content=\"slime\" />\r\n");
      out.write("    <meta name=copyright content=\"2010\" />\r\n");
      out.write("    <meta http-equiv=\"Pragma\" content=\"no-cache\" />\r\n");
      out.write("\t<meta http-equiv=\"Cache-Control\" content=\"no-cache\" /> \r\n");
      out.write("\t<meta HTTP-EQUIV=\"Expires\" CONTENT=\"0\">\r\n");
      out.write("\t<meta http-equiv=\"Cache\" content=\"no-cache\">\r\n");
      out.write("    <title>后管管理</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href='");
      out.print(mainCcs);
      out.write("' />\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/themes/ui-lightness/jquery.ui.all.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/flexigrid.css?version=1.1\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/button.css?version=1.0\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-ui-1.8.2.custom.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/flexigrid.js?version=1.1\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/jquery.datepickercn.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/highcharts.src.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/exporting.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/cmd.js?version=1.1\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/common.js?version=1.0\"></script>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    ");

    	GameServerInfo info = (GameServerInfo)session.getAttribute("selserver");
    
      out.write("\r\n");
      out.write("    openTime=");
      out.print(TimeUtil.getTime(info.getStartTime()));
      out.write(";\r\n");
      out.write("    hourtime = 60 * 60 * 1000;\r\n");
      out.write("    daytime = 24 * hourtime;\r\n");
      out.write("    tableWidth = 1010;  //表格宽 \r\n");
      out.write("    tableHeight = 690;   //表格高\r\n");
      out.write("    tableRp = 25;  //表格默认一页显示行数\r\n");
      out.write("    partnerKey = [];\r\n");
      out.write("    partnerVal = [];\r\n");
      out.write("    window.onload = function(){\r\n");
      out.write("\t    var rat = ");
      out.print(session.getAttribute("rat"));
      out.write("\r\n");
      out.write("    \tif(rat == 1){\r\n");
      out.write("    \t    tableWidth = 785;  //表格宽 \r\n");
      out.write("    \t    tableHeight = 420;   //表格高\r\n");
      out.write("    \t    tableRp = 15;  //表格默认一页显示行数\r\n");
      out.write("    \t    //loadStyle(\"css/admin/basic1.css?version=1.1\");\r\n");
      out.write("    \t}else if(rat == 2){\r\n");
      out.write("    \t    tableWidth = 910;  //表格宽 \r\n");
      out.write("    \t    tableHeight = 550;   //表格高\r\n");
      out.write("    \t    tableRp = 20;  //表格默认一页显示行数\r\n");
      out.write("    \t   // loadStyle(\"css/admin/basic.css?version=1.1\");\r\n");
      out.write("    \t}else{\r\n");
      out.write("    \t    tableWidth = 1150;  //表格宽 \r\n");
      out.write("    \t    tableHeight = 690;   //表格高\r\n");
      out.write("    \t    tableRp = 25;  //表格默认一页显示行数\r\n");
      out.write("    \t    //loadStyle(\"css/admin/basic2.css?version=1.1\");\r\n");
      out.write("    \t}\r\n");
      out.write("    \tinitPartner();\r\n");
      out.write("    }\r\n");
      out.write("    function loadStyle(url){\r\n");
      out.write("    \tvar link = document.createElement(\"link\");\r\n");
      out.write("    \tlink.rel = \"stylesheet\";\r\n");
      out.write("    \tlink.type = \"text/css\";\r\n");
      out.write("    \tlink.href = url;\r\n");
      out.write("    \tdocument.getElementsByTagName(\"head\")[0].appendChild(link);\r\n");
      out.write("    }\r\n");
      out.write("\tfunction flush(){\r\n");
      out.write("\t\twindow.location.reload();\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction initPartner(){\r\n");
      out.write("\t\tvar i = 0;\r\n");
      out.write("\t\t");

    		Map<Integer, String> partnerMap = GamePartnerCache.getPartnerMap();
			for(Entry<Integer, String> entry : partnerMap.entrySet()){
				
      out.write("\r\n");
      out.write("\t\t\t\t\tpartnerKey[i] = ");
      out.print(entry.getKey());
      out.write(";\r\n");
      out.write("\t\t\t\t\tpartnerVal[i] = '");
      out.print(entry.getValue());
      out.write("';\r\n");
      out.write("\t\t\t\t\ti++;\r\n");
      out.write("\t\t\t\t");

			}
		
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("</script>");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body id=\"sl-index\">\r\n");
      out.write("<div id=\"sl-wrap\" class=\"ui-widget-content\">\r\n");
      out.write("  <div id=\"sl-header\" class=\"ui-widget-header\">\r\n");
      out.write("        <h2 align=\"center\" style=\"margin-bottom: 2px;margin-top: 2px;\">管理后台-棋战</h2>\r\n");
      out.write("        <div style=\"margin-bottom: 2px;\">\r\n");
      out.write("\t \t\t<b>当前帐号：</b><a style=\"color:#2932E1\">");
      out.print(user.getUsername() );
      out.write("</a>　\r\n");
      out.write("\t \t\t<b style=\"margin-left: 20px;\">登录时间：</b><a style=\"color:#2932E1\"> ");
      out.print(TimeUtil.formatDate(new Date(), TimeUtil.DATE_FORMATER.CHINA_yyyy_MM_dd_EN_HH_mm_ss) );
      out.write("</a>\r\n");
      out.write("\t        <b style=\"margin-left: 30px;\">当前服务器：</b>\r\n");
      out.write("\t       \t<select id=\"gameServer\" onchange=\"changeGameServer();\">\r\n");
      out.write("\t       \t\t");

	       		for(int i = 0; i < servers.size(); i++){
	       			GameServerInfo server = servers.get(i);
	       			if((selserver == null && i == 0) || (selserver != null && selserver.getId() == server.getId())){
	       		
      out.write("\r\n");
      out.write("\t           \t\t<option value=\"");
      out.print(server.getId());
      out.write("\" selected=\"selected\">");
      out.print(server.getServerName() );
      out.write("</option>\r\n");
      out.write("\t           \t");
		
	       			}else{
	       		
      out.write("\r\n");
      out.write("\t       \t\t\t<option value=\"");
      out.print(server.getId());
      out.write('"');
      out.write('>');
      out.print(server.getServerName() );
      out.write("</option>\r\n");
      out.write("\t       \t\t");

	       			}
	       		}
	       		
      out.write("\r\n");
      out.write("\t       \t</select>\r\n");
      out.write("        \t<span><input id=\"checkState\" type=\"checkbox\" style=\"margin-left: 2px; margin-right: 2px;vertical-align: middle;\" checked=\"checked\"><label for=\"checkState\" style=\"color: red;vertical-align: middle;\">check</label></span>\r\n");
      out.write("\t        <span style=\"float: right;margin-right: 30px;\">\r\n");
      out.write("\t \t\t<a style=\"margin-right:5px;color:#2932E1;\" href=\"logout.jsp\">退出</a>\r\n");
      out.write("\t        <a style='margin-right:5px;color:#2932E1;' href=\"\" onclick=\"flush();\">刷新</a></span>\r\n");
      out.write("        </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div id=\"sl-main-nav\">\r\n");
      out.write("        <div id=\"sl-accordion\">\r\n");
      out.write("        ");

	        for(SysMenuInfo menu : menus){
	        	if(menu.getParentId() == 0){
	    
      out.write("\r\n");
      out.write("\t       \t\t<h3><a href=\"#\">");
      out.print(menu.getName());
      out.write("</a></h3>\r\n");
      out.write("\t       \t\t<div>\r\n");
      out.write("\t               <ol class=\"sl-selectable\">\r\n");
      out.write("\t               ");

	               	for(SysMenuInfo m : menus){
	               		if(m.getParentId() == menu.getId()){
	               
      out.write("\r\n");
      out.write("\t               \t\t<li class = \"ui-widget-content\" link=\"");
      out.print(m.getUrl() );
      out.write("\" name=\"");
      out.print(m.getName());
      out.write('"');
      out.write('>');
      out.print(m.getName());
      out.write("</li>\r\n");
      out.write("\t               ");

	               		}
	               	}
	               
      out.write("\r\n");
      out.write("\t                </ol>\r\n");
      out.write("\t            </div>\r\n");
      out.write("\t       \t");

	        	}
	       	 }
	    
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div id=\"sl-content\">\r\n");
      out.write("      <div id=\"sl-tabs\">\r\n");
      out.write("\t\t<ul><li></li></ul>\r\n");
      out.write("     </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div id=\"sl-footer\" class=\"ui-widget-header\">\r\n");
      out.write("      <p>Release 20160323</p>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
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
