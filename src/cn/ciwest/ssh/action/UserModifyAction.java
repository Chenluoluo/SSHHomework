package cn.ciwest.ssh.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.ciwest.ssh.model.UserModel;
import cn.ciwest.ssh.service.IUserService;

public class UserModifyAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private IUserService userService = null;

	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	private UserModel userModel = null;

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	@Override
	public String execute() throws Exception {
		UserModel user = userService.modifyUser(userModel);
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		session.put("user", user);
		System.out.println("信息修改成功");
		return "success";
	}

}
