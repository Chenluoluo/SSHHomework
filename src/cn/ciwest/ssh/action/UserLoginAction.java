package cn.ciwest.ssh.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.ciwest.ssh.model.UserModel;
import cn.ciwest.ssh.service.IUserService;

public class UserLoginAction extends ActionSupport {

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
		if (userService.getUser(userModel.getUsername()) == null) {
			System.out.println("用户" + userModel.getUsername() + "不存在");
			return "nouser";
		} else {
			UserModel user = userService.getUser(userModel.getUsername());
			System.out.println("用户" + userModel.getUsername() + "存在");
			if (user.getPassword().equals(userModel.getPassword())) {
				System.out.println("用户：" + userModel.getUsername() + " 登录成功");
				ActionContext ac = ActionContext.getContext();
				Map<String, Object> session = ac.getSession();
				session.put("user", user);
				return SUCCESS;
			} else {
				System.out.println("用户：" + userModel.getUsername() + " 密码错误");
				return "failed";
			}
		}
	}

}
