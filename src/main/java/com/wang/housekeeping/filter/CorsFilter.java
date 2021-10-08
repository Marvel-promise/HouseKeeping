
package com.wang.housekeeping.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class CorsFilter implements Filter {

/**
     * Default constructor. 
     */

    public CorsFilter() {
        // TODO Auto-generated constructor stub
    }


/**
	 * @see Filter#destroy()
	 */

	public void destroy() {
		// TODO Auto-generated method stub
	}


/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("跨域过滤器执行.....");
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		// 得到请求域
		String currentOrigin = request.getHeader("Origin");
		
		System.out.println("请求域为:"+currentOrigin);
				
		//被允许跨域的客户端请求域设置列表字符串
//		String allowOrigins = "http://localhost:80,http://localhost:8080,http://localhost:7779";


		////测试代码-------显示被允许的请求域-------------
//		String[] allowOriginsArray = allowOrigins.split(",");
//		System.out.println("被允许的请求域:");
//		for(String allowOrigin : allowOriginsArray){
//
//			System.out.println("-----"+allowOrigin+"-----");
//		}
		////////////////////////////////////////////
		
		
//		if (currentOrigin!=null && allowOrigins.contains(currentOrigin)) {
//
//			response.setHeader("Access-Control-Allow-Origin", currentOrigin);
//
//		}

		//设置是否允许客户端读取cookie
		response.setHeader("Access-Control-Allow-Credentials", "true");
		
		response.addHeader("Access-Control-Allow-Headers", 
				"Accept,"
				+ "Origin,"
				+ "No-Cache,"
				+ "X-Requested-With,"
				+ "If-Modified-Since,"
				+ "Pragma,"
				+ "Last-Modified,"
				+ "Cache-Control,"
				+ "Expires,"
				+ "Content-Type,"
				+ "X-E4M-With");
		
		System.out.println("跨域过滤器放行.....");
		chain.doFilter(req, res);
	}


/**
	 * @see Filter#init(FilterConfig)
	 */

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

