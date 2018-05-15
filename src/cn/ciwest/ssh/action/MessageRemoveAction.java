package cn.ciwest.ssh.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import cn.ciwest.ssh.service.IMessageService;

public class MessageRemoveAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private IMessageService messageService = null;

	@Autowired
	public void setMessageService(IMessageService messageService) {
		this.messageService = messageService;
	}

	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		messageService.removeMessage(number);
		System.out.println("留言删除成功");
		return super.execute();
	}
}
