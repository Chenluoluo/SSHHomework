package cn.ciwest.ssh.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ciwest.ssh.model.UserModel;


/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter(
		urlPatterns = { 
		"*.jsp"
	})
public class LoginCheckFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginCheckFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		String uri = req.getRequestURI();
		System.out.println(uri);
		if (uri.equals("/SSHHomework/user/login.jsp") || uri.equals("/SSHHomework/user/register.jsp")) {
			chain.doFilter(request, response);
		} else if (uri.equals("/SSHHomework/user/loginFailed.jsp")){
			chain.doFilter(request, response);
		} else if (uri.equals("/SSHHomework/user/loginNoUser.jsp")){
			chain.doFilter(request, response);
		} else if (uri.equals("/SSHHomework/error/error.jsp")){
			chain.doFilter(request, response);
		} else {
			if (session == null) {
				System.out.println("用户未登录");
				res.sendRedirect("/SSHHomework/user/login.jsp");
			} else if ((UserModel)session.getAttribute("user") == null) {
				System.out.println("用户已经退出登录");
				res.sendRedirect("/SSHHomework/user/login.jsp");
			}else {
				chain.doFilter(request, response);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
