package cn.ciwest.ssh.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import cn.ciwest.ssh.model.UserModel;
import cn.ciwest.ssh.service.IUserService;

public class UserRegisterAction extends ActionSupport {

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
		userService.createUser(userModel);
		System.out.println("用户注册成功");
		return "success";
	}

}
