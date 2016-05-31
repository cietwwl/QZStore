package org.apache.jsp.game_005fplayer_005fmgr;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.game.constant.WebConstant;
import com.web.obj.UserGroup;
import java.util.*;
import com.web.db.bean.*;
import com.db.util.*;
import java.sql.*;
import com.utils.*;
import com.cache.GamePartnerCache;
import com.web.db.game.GamePartnerInfo;
import java.util.List;

public final class game_005fplayer_005fmgr_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/jsp/select_partner.jsp");
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
      out.write("<div id=\"sl-systeminfo\" class=\"sl-table\">\r\n");
      out.write("\t<div id=\"search_div\" style=\"display:table;\">\r\n");
      out.write("\t\t<span>\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 List<GamePartnerInfo> partners = GamePartnerCache.getPartners(); 
      out.write("\r\n");
      out.write("<select id=\"partner\" style=\"margin-left:0px;padding:2px;\">\r\n");
      out.write("\t<option value='0' selected='selected'>全渠道</option>\r\n");
      out.write("\t");

		for(GamePartnerInfo info : partners){
			
      out.write("\r\n");
      out.write("\t\t\t\t<option value='");
      out.print(info.getId());
      out.write('\'');
      out.write('>');
      out.print(info.getName());
      out.write("</option>\r\n");
      out.write("\t\t\t");

		}
	
      out.write("\r\n");
      out.write("</select>");
      out.write("\r\n");
      out.write("\t\t\t<select id=\"searchType\" style=\"margin-left:5px;margin-top:-5px;padding:2px;\">\r\n");
      out.write("\t\t\t\t<option value=\"1\">账号</option>\r\n");
      out.write("\t\t\t\t<option value=\"2\">昵称</option>\r\n");
      out.write("\t\t\t\t<option value=\"3\">等级</option>\r\n");
      out.write("\t\t\t\t<option value=\"4\">在线</option>\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t\t<input style=\"margin-left:5px;margin-top:-5px;\" type=\"text\" id=\"searchValue\"/>\r\n");
      out.write("\t\t\t<input style=\"margin-left:5px;margin-top:-5px;\" type=\"button\"  class=\"button orange small\" value=\"查询\" onclick=\"searchPlayer();\"/>\r\n");
      out.write("\t\t</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<table id=\"players\" style=\"display:none\"></table>\r\n");
      out.write("\t<div id=\"banTip\" style=\"position:fixed; z-index: 9999;background: #FFF;border:solid 1px #6e8bde;display:none;padding:4px;\"></div>\r\n");
      out.write("\t<div id=\"banDialog\" style=\"display:none;\"></div>\r\n");
      out.write("\t<div id=\"relieveBanDialog\" style=\"display:none;\"></div>\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");

UserGroup userGroup = (UserGroup)session.getAttribute("userGroup");

      out.write("\r\n");
      out.write("var jurBanPlayer = ");
      out.print(userGroup.hasJurisdict(WebConstant.JURISDICTION_ID_BAN_PLAYER));
      out.write(";\r\n");
      out.write("var datas;\r\n");
      out.write("function dispose(){\r\n");
      out.write("\t$(\"#players\").remove();\r\n");
      out.write("\t$(\"#banTip\").remove();\r\n");
      out.write("\t$(\"#banDialog\").remove();\r\n");
      out.write("\t$(\"#relieveBanDialog\").remove();\r\n");
      out.write("\tdatas = null;\r\n");
      out.write("}\r\n");
      out.write("function ready(){\r\n");
      out.write("\t$(\"#players\").flexigrid({\r\n");
      out.write("   \t    url : 'game_player_mgr/get_player_list.jsp',\r\n");
      out.write("   \t    dataType : 'json',\r\n");
      out.write("   \t    preProcess : function(data){\r\n");
      out.write("   \t    \tdatas = data;\r\n");
      out.write("   \t    \treturn data;\r\n");
      out.write("   \t    },\r\n");
      out.write("   \t    getRowColor:function(row){\r\n");
      out.write("   \t    \tif(row.online == 1){\r\n");
      out.write("   \t    \t\treturn \"#bee9ad\";\r\n");
      out.write("   \t    \t}\r\n");
      out.write("   \t    },\r\n");
      out.write("   \t    colModel : [{display : '玩家ID',\r\n");
      out.write("   \t        name : 'userId',\r\n");
      out.write("   \t        width : 50,\r\n");
      out.write("   \t        align : 'center'\r\n");
      out.write("   \t\t}, {display : '玩家账号',\r\n");
      out.write("\t        name : 'username',\r\n");
      out.write("\t        width : 90,\r\n");
      out.write("\t        align : 'center'\r\n");
      out.write("        }, {display : '渠道',\r\n");
      out.write("\t        name : 'partnerName',\r\n");
      out.write("\t        width : 90,\r\n");
      out.write("\t        align : 'center'\r\n");
      out.write("        },  { display : '玩家昵称',\r\n");
      out.write("\t        name : 'playerName',\r\n");
      out.write("\t        width : 90,\r\n");
      out.write("\t        align : 'center'\r\n");
      out.write("        }, {display : '帐号状态',\r\n");
      out.write("        \tname : 'banLoginSign',\r\n");
      out.write("\t        width : 50,\r\n");
      out.write("\t        align : 'center',\r\n");
      out.write("\t        customValue:getBanLogin\r\n");
      out.write("        }, {display : '禁言',\r\n");
      out.write("        \tname : 'banChatSign',\r\n");
      out.write("\t        width : 50,\r\n");
      out.write("\t        align : 'center',\r\n");
      out.write("\t        customValue:getBanChat\r\n");
      out.write("        },{display : '等级',\r\n");
      out.write("\t        name : 'level',\r\n");
      out.write("\t        width : 50,\r\n");
      out.write("\t        sortable : true,\r\n");
      out.write("\t        align : 'center'\r\n");
      out.write("        }, {\r\n");
      out.write("        \tdisplay : '累计充值',\r\n");
      out.write("        \tname : 'chargeDiamond',\r\n");
      out.write("        \twidth : 90,\r\n");
      out.write("        \talign : 'center',\r\n");
      out.write("        \tsortable : true\r\n");
      out.write("        }, {display : '钻石',\r\n");
      out.write("   \t        name : 'diamond',\r\n");
      out.write("   \t        width : 90,\r\n");
      out.write("   \t        sortable : true,\r\n");
      out.write("   \t        align : 'center'\r\n");
      out.write("   \t    }, {display : '金币',\r\n");
      out.write("   \t        name : 'gold',\r\n");
      out.write("   \t        width : 90,\r\n");
      out.write("   \t        sortable : true,\r\n");
      out.write("   \t        align : 'center'\r\n");
      out.write("   \t   \t}, {display : '灵气',\r\n");
      out.write("   \t        name : 'gp',\r\n");
      out.write("   \t        width : 90,\r\n");
      out.write("   \t        sortable : true,\r\n");
      out.write("   \t        align : 'center'\r\n");
      out.write("   \t    }, {display : '石板',\r\n");
      out.write("   \t        name : 'slate',\r\n");
      out.write("   \t        width : 60,\r\n");
      out.write("   \t        sortable : true,\r\n");
      out.write("   \t        align : 'center'\r\n");
      out.write("   \t    }, {display : '名望',\r\n");
      out.write("   \t        name : 'fame',\r\n");
      out.write("   \t        width : 50,\r\n");
      out.write("   \t        sortable : true,\r\n");
      out.write("   \t        align : 'center'\r\n");
      out.write("   \t    }, {display : '伙伴扩充容量',\r\n");
      out.write("   \t        name : 'heroCapacity',\r\n");
      out.write("   \t        width : 60,\r\n");
      out.write("   \t        sortable : true,\r\n");
      out.write("   \t        align : 'center'\r\n");
      out.write("   \t    }, {display : '装备扩充容量',\r\n");
      out.write("   \t        name : 'equipmentCapacity',\r\n");
      out.write("   \t        width : 60,\r\n");
      out.write("   \t        sortable : true,\r\n");
      out.write("   \t        align : 'center'\r\n");
      out.write("   \t    }, {display : '武魂扩充容量',\r\n");
      out.write("   \t        name : 'eternalCapacity',\r\n");
      out.write("   \t        width : 60,\r\n");
      out.write("   \t        sortable : true,\r\n");
      out.write("   \t        align : 'center'\r\n");
      out.write("   \t    }, {display : '注册时间',\r\n");
      out.write("   \t        name : 'registTimeStr',\r\n");
      out.write("   \t        width : 135,\r\n");
      out.write("   \t        sortable : true,\r\n");
      out.write("   \t        align : 'center'\r\n");
      out.write("   \t    }, {display : '最后登陆时间',\r\n");
      out.write("   \t        name : 'loginTimeStr',\r\n");
      out.write("   \t        width : 135,\r\n");
      out.write("   \t        sortable : true,\r\n");
      out.write("   \t        align : 'center'\r\n");
      out.write("   \t    }],\r\n");
      out.write("   \t    usepager : true,\r\n");
      out.write("   \t    title : '玩家列表',\r\n");
      out.write("   \t    useRp : false,\r\n");
      out.write("   \t    rp : tableRp,\r\n");
      out.write("   \t    width : tableWidth,\r\n");
      out.write("   \t    height : tableHeight,\r\n");
      out.write("   \t    page: 1,\r\n");
      out.write("   \t    total: 1,\r\n");
      out.write("   \t    resizable: false,\r\n");
      out.write("   \t    autoload: false,\r\n");
      out.write("   \t    procmsg:'加载中，請稍後…',\r\n");
      out.write("   \t    singleSelect:true,\r\n");
      out.write(" \t\tonSuccess : function(obj){\r\n");
      out.write("\t \t\tshowError(datas);\r\n");
      out.write("\t    }\r\n");
      out.write("   \t});\r\n");
      out.write("\tsearchPlayer();\r\n");
      out.write("}\r\n");
      out.write("function getBanChat(row,col,state){\r\n");
      out.write("\tvar val = \"\";\r\n");
      out.write("\tif(state == 1){\r\n");
      out.write("\t\tif(jurBanPlayer){\r\n");
      out.write("\t\t\tval = \"onmouseover='showBanTip(event, 1, true, true)' onmouseout='showBanTip(event, 1, false, true)' onclick='relieveBan(1,\" + row +\")'\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn \"<img src='css/images/ban.png' style='cursor:pointer;float:left;' \" + val + \"/>禁言\";\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tif(jurBanPlayer){\r\n");
      out.write("\t\t\tval = \"onmouseover='showBanTip(event, 1, true, false)'  onmouseout='showBanTip(event, 1, false, false)' onclick='showBanDialog(1,\" + row +\")'\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn \"<img src='css/images/accept.png' style='cursor:pointer;float:left;' \" + val + \"/>正常\";\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function showBanTip(event, type, show, accept){\r\n");
      out.write("\ttip = $(\"#banTip\");\r\n");
      out.write("\tif(show){\r\n");
      out.write("\t\tif(accept){\r\n");
      out.write("\t\t\tif(type == 1){\r\n");
      out.write("\t\t\t\ttip.html(\"点击解禁\");\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\ttip.html(\"点击解封\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}else if(type == 1){\r\n");
      out.write("\t\t\ttip.html(\"点击禁言\");\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\ttip.html(\"点击封号\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\ttip.css(\"position\", \"fixed\");\r\n");
      out.write("\t\ttip.css(\"left\", event.clientX + 2);\r\n");
      out.write("\t\ttip.css(\"top\", event.clientY - 20);\r\n");
      out.write("\t\ttip.show();\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\ttip.hide();\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function getBanLogin(row,col,state){\r\n");
      out.write("\tvar val = \"\";\r\n");
      out.write("\tif(state == 1){\r\n");
      out.write("\t\tif(jurBanPlayer){\r\n");
      out.write("\t\t\tval = \"onmouseover='showBanTip(event, 2, true, true)' onmouseout='showBanTip(event, 2, false, true)' onclick='relieveBan(2,\" + row +\")'\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn \"<img src='css/images/ban.png' style='cursor:pointer;float:left;' \" + val + \"/>封禁\";\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tif(jurBanPlayer){\r\n");
      out.write("\t\t\tval = \"onmouseover='showBanTip(event, 2, true, false)'  onmouseout='showBanTip(event, 2, false, false)' onclick='showBanDialog(2,\" + row +\")'\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn \"<img src='css/images/accept.png' style='cursor:pointer;float:left;' \" + val + \"/>正常\";\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function relieveBan(banType,row){\r\n");
      out.write("\td = $(\"#relieveBanDialog\");\r\n");
      out.write("\thtmlText = \"<br>是否确定解禁!\";\r\n");
      out.write("\tif(banType == 1){\r\n");
      out.write("\t\td.attr(\"title\", \"解除禁言\");\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\td.attr(\"title\", \"解除封号\");\r\n");
      out.write("\t\thtmlText = \"<br>是否确定解封!\";\r\n");
      out.write("\t}\r\n");
      out.write("\td.html(htmlText);\r\n");
      out.write("\td.dialog({\r\n");
      out.write("\t\tresizable:false,\r\n");
      out.write("\t\tmodal:true,\r\n");
      out.write("\t\tautoOpen:true,\r\n");
      out.write("\t\tdraggable:true,\r\n");
      out.write("\t\ttitle:d.attr(\"title\"),\r\n");
      out.write("\t\tbuttons:{\r\n");
      out.write("\t\t\t\"取消\":function(){\r\n");
      out.write("\t\t\t\t$(this).dialog(\"close\");\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\t\"确定\":function(){\r\n");
      out.write("\t\t\t\tvar date =  $(\"#banDate\").val();\r\n");
      out.write("\t\t\t\tvar username = datas.rows[row].username;\r\n");
      out.write("\t\t\t\tvar partner = datas.rows[row].partner;\r\n");
      out.write("\t\t\t\t$.ajax({url:\"game_player_mgr/url_ban_account.jsp\",\r\n");
      out.write("\t\t\t\t\tdata:{\r\n");
      out.write("\t\t\t\t\t\tbanDate:date,\r\n");
      out.write("\t\t\t\t\t\tusername:username,\r\n");
      out.write("\t\t\t\t\t\tpartner:partner,\r\n");
      out.write("\t\t\t\t\t\tbanType:banType\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\ttype:\"post\",\r\n");
      out.write("\t\t\t\t\tdataType:\"json\",\r\n");
      out.write("\t\t\t\t\tcache:false,\r\n");
      out.write("\t\t\t\t\tsuccess:function(response){\r\n");
      out.write("\t\t\t\t\t\tif(!showError(response)){\r\n");
      out.write("\t\t\t\t\t\t\tplayer = response.data.player;\r\n");
      out.write("\t\t\t\t\t\t\tfor(i = 0; i < datas.rows.length; i++){\r\n");
      out.write("\t\t\t\t\t\t\t\tif(datas.rows[i].id == player.id){\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdatas.rows[i] = player;\r\n");
      out.write("\t\t\t\t\t\t\t\t\tbreak;\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t$('#relieveBanDialog').dialog(\"close\");\r\n");
      out.write("\t\t\t\t\t\t\tif(banType == 1){\r\n");
      out.write("\t\t\t\t\t\t\t\talert(\"解除禁言成功!\");\r\n");
      out.write("\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\talert(\"解除封号成功!\");\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#players\").flexAddData(datas);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function showBanDialog(banType,row){\r\n");
      out.write("\td = $('#banDialog');\r\n");
      out.write("\tvar options = document.getElementById(\"gameServer\").options;\r\n");
      out.write("\tif(banType == 1){\r\n");
      out.write("\t\td.attr(\"title\", \" [ \" + options[options.selectedIndex].text + \" ] 禁言\");\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\td.attr(\"title\", \" [ \" + options[options.selectedIndex].text + \" ] 封号\");\r\n");
      out.write("\t}\r\n");
      out.write("\thtmlText = \"<table><tr><td style='width:100px;text-align:right;'>账号:</td><td style='text-align:left;'>\" + datas.rows[row].username + \"</td></tr><tr><td style='text-align:right;'>玩家昵称:</td><td style='text-align:left;'>\" + datas.rows[row].playerName + \"</td></tr><tr><td style='text-align:right;'>封禁时间:</td><td style='text-align:left;'><input id='banDate'/>\" + getHour(0) + getMinute(0) + \"</td></tr></table>\";\r\n");
      out.write("\td.html(htmlText);\r\n");
      out.write("\td.dialog({\r\n");
      out.write("\t\tresizable:false,\r\n");
      out.write("\t\tmodal:true,\r\n");
      out.write("\t\tautoOpen:true,\r\n");
      out.write("\t\tdraggable:true,\r\n");
      out.write("\t\ttitle:d.attr(\"title\"),\r\n");
      out.write("\t\tbuttons:{\r\n");
      out.write("\t\t\t\"取消\":function(){\r\n");
      out.write("\t\t\t\t$(this).dialog(\"close\");\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\t\"确定\":function(){\r\n");
      out.write("\t\t\t\tvar date =  $(\"#banDate\").val() + \" \" + $(\"#hour0\").val() + \":\" + $(\"#minute0\").val() + \":00\";\r\n");
      out.write("\t\t\t\tvar username = datas.rows[row].username;\r\n");
      out.write("\t\t\t\tvar partner = datas.rows[row].partner;\r\n");
      out.write("\t\t\t\t$.ajax({url:\"game_player_mgr/url_ban_account.jsp\",\r\n");
      out.write("\t\t\t\t\tdata:{\r\n");
      out.write("\t\t\t\t\t\tbanDate:date,\r\n");
      out.write("\t\t\t\t\t\tusername:username,\r\n");
      out.write("\t\t\t\t\t\tpartner:partner,\r\n");
      out.write("\t\t\t\t\t\tbanType:banType\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\ttype:\"post\",\r\n");
      out.write("\t\t\t\t\t\tdataType:\"json\",\r\n");
      out.write("\t\t\t\t\t\tcache:false,\r\n");
      out.write("\t\t\t\t\t\tsuccess:function(response){\r\n");
      out.write("\t\t\t\t\t\t\t$('#banDialog').dialog(\"close\");\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#banDate\").val(\"\");\r\n");
      out.write("\t\t\t\t\t\t\tif(response.code == 0){\r\n");
      out.write("\t\t\t\t\t\t\t\tplayer = response.data.player;\r\n");
      out.write("\t\t\t\t\t\t\t\tfor(i = 0; i < datas.rows.length; i++){\r\n");
      out.write("\t\t\t\t\t\t\t\t\tif(datas.rows[i].id == player.id){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdatas.rows[i] = player;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tbreak;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\tif(banType == 1){\r\n");
      out.write("\t\t\t\t\t\t\t\t\talert(\"禁言成功!\");\r\n");
      out.write("\t\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\t\talert(\"封号成功!\");\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#players\").flexAddData(datas);\r\n");
      out.write("\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\tif(response.tip != null && response.tip.length > 0){\r\n");
      out.write("\t\t\t\t\t\t\t\t\talert(response.tip);\r\n");
      out.write("\t\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\t\talert(\"请求服务器出错!\");\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\tpickerDateByMin(\"banDate\", getNextDate(0 * 24 * 60 * 60 * 1000), getNextDate(1 * 24 * 60 * 60 * 1000));\r\n");
      out.write("}\r\n");
      out.write("function searchPlayer(){\r\n");
      out.write("\t$(\"#players\").flexOptions({\r\n");
      out.write("\t\tparams : [{name:'partner', value:$(\"#partner\").val()},\r\n");
      out.write("\t\t          {name:'searchType', value:$(\"#searchType\").val()},\r\n");
      out.write("\t\t          {name:'searchValue', value:$(\"#searchValue\").val()},\r\n");
      out.write("\t\t         ],\r\n");
      out.write("\t\tnewp:1\r\n");
      out.write("\t});\r\n");
      out.write("\t$(\"#players\").flexReload();\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
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