package cn.ciwest.ssh.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.ciwest.ssh.model.UserModel;
import cn.ciwest.ssh.service.IUserService;

public class UserRemoveAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private IUserService userService = null;

	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		UserModel userModel = (UserModel) session.get("user");
		userService.removeUser(userModel.getUsername());
		System.out.println("账户删除成功");
		return "success";
	}

}
