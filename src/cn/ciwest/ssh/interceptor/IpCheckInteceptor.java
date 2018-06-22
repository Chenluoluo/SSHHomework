package cn.ciwest.ssh.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class IpCheckInteceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		System.out.println("Ip检查拦截器销毁方法。。。");

	}

	@Override
	public void init() {
		System.out.println("Ip检查拦截器初始化方法。。。");

	}

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		System.out.println("Ip检查拦截器拦截方法。。。");

		String ip = ServletActionContext.getRequest().getRemoteAddr();
		System.out.println(ip);
//		if (ip.equals("0:0:0:0:0:0:0:1")) {
		if (false) {
			System.out.println("Ip被禁止访问");
			return "iperror";
		} else {
			String result = ai.invoke();
			return result;
		}

	}
}
