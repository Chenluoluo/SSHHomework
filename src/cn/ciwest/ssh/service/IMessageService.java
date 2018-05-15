package cn.ciwest.ssh.service;

import java.util.List;

import cn.ciwest.ssh.model.MessageModel;

public interface IMessageService {
	public void createMessage(MessageModel messageModel) throws Exception;

	public MessageModel getMessage(int number) throws Exception;

	public void modifyMessage(MessageModel messageModel) throws Exception;

	public void removeMessage(int number) throws Exception;

	public List<MessageModel> getAllComment() throws Exception;
}
