package cn.ciwest.ssh.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.ciwest.ssh.model.MessageModel;
import cn.ciwest.ssh.model.UserModel;
import cn.ciwest.ssh.service.IMessageService;

public class MessageWriteAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private IMessageService messageService = null;

	@Autowired
	public void setMessageService(IMessageService messageService) {
		this.messageService = messageService;
	}

	private MessageModel messageModel = null;

	public MessageModel getMessageModel() {
		return messageModel;
	}

	public void setMessageModel(MessageModel messageModel) {
		this.messageModel = messageModel;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		UserModel userModel = (UserModel) session.get("user");
		messageModel.setUsername(userModel.getUsername());
		messageModel.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		messageService.createMessage(messageModel);
		System.out.println("留言成功");
		return super.execute();
	}
}
