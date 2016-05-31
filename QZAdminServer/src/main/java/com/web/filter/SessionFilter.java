//package com.web.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//public class SessionFilter implements Filter {
//
//	@Override
//	public void destroy() {
//	}
//
//	@Override
//	public void doFilter(ServletRequest arg0, ServletResponse arg1,
//			FilterChain arg2) throws IOException, ServletException {
//		HttpServletRequest request = (HttpServletRequest) arg0;
//		HttpServletResponse response = (HttpServletResponse) arg1;
//		String uri = request.getRequestURI();
//		String path = request.getContextPath() + "/";
//		int index = uri.indexOf(path);
//		if(index != -1){
//			
//		}
//		System.out.println("请求地址11:" + request.getPathInfo());
//		System.out.println("请求地址:" + uri);
//		if(uri.indexOf(".jsp") > -1){
//			if(uri.indexOf("login.jsp") != -1 
//					|| uri.indexOf("index.jsp") != -1
//					|| uri.indexOf("convert_cd_key.jsp") != -1){
//				arg2.doFilter(arg0, arg1);
//				return;
//			}
//			HttpSession session = request.getSession();
//			if(session.getAttribute("user") == null){
//				response.sendRedirect(request.getContextPath() + "/redirect_login.jsp");
//			}else{
//				arg2.doFilter(arg0, arg1);
//			}
//		}else{
//			arg2.doFilter(arg0, arg1);
//		}
//	}
//
//	@Override
//	public void init(FilterConfig arg0) throws ServletException {
//		
//	}
//
//}
