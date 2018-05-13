package cn.ciwest.ssh.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.ciwest.ssh.model.UserModel;

public class UserLogoutAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		session.put("user", null);
		System.out.println("注销成功");
		return "success";
	}

}
