package com.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cache.SysRequestCache;
import com.cache.SysUserCache;
import com.web.db.bean.SysRequestInfo;
import com.web.db.bean.SysUserInfo;
import com.web.obj.UserGroup;

public class JurisdictionFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		String uri = request.getRequestURI();
		String path = request.getContextPath() + "/";
		String reqpath = uri;
		int index = uri.indexOf(path);
		if(index != -1){
			index += path.length();
		}
		reqpath = uri.substring(index, uri.length());
		SysRequestInfo info = SysRequestCache.getRequestByUrl(reqpath);
		HttpSession session = request.getSession();
		SysUserInfo user = (SysUserInfo)session.getAttribute("user");
		if(uri.endsWith(".jsp")){
			if(user == null){
				if(info == null || info.getJurisdictionId() != -1){
					response.sendRedirect(request.getContextPath() + "/redirect_login.jsp");
					return ;
				}
			}
		}
		boolean doFilter = info == null || info.getJurisdictionId() == -1;
		if(!doFilter){
			UserGroup group = SysUserCache.getUserGroup(user.getUserGroupId());
			doFilter = group != null && group.hasJurisdict(info.getJurisdictionId());
		}
		if(doFilter){
			arg2.doFilter(arg0, arg1);
		}else{
			response.sendRedirect(request.getContextPath() + "/jsp/jurisdiction_lazy.jsp");
			return ;
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
