package cn.ciwest.ssh.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import cn.ciwest.ssh.model.MessageModel;
import cn.ciwest.ssh.service.IMessageService;

public class MessageFrontAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private IMessageService messageService = null;

	@Autowired
	public void setMessageService(IMessageService messageService) {
		this.messageService = messageService;
	}

	private List<MessageModel> listMessage = null;

	public List<MessageModel> getListMessage() {
		return listMessage;
	}

	public void setListMessage(List<MessageModel> listMessage) {
		this.listMessage = listMessage;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		listMessage = messageService.getAllComment();
		return SUCCESS;
	}

}
