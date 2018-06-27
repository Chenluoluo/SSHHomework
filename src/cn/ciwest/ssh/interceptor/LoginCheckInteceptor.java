package cn.ciwest.ssh.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import cn.ciwest.ssh.model.UserModel;

public class LoginCheckInteceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		System.out.println("登录检查拦截器销毁方法。。。");

	}

	@Override
	public void init() {
		System.out.println("登录检查拦截器初始化方法。。。");

	}

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		System.out.println("登录检查拦截器拦截方法。。。");

		UserModel userModel = (UserModel) ActionContext.getContext().getSession().get("user");
		if (userModel == null) {
			System.out.println("跳转登陆");
			return "login";
		} else {
			String result = ai.invoke();
			return result;
		}

	}

}
