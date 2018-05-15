package cn.ciwest.ssh.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ciwest.ssh.model.MessageModel;
import cn.ciwest.ssh.service.IMessageService;

@Service("messageServiceImpl")
@Transactional
public class MessageServiceImpl implements IMessageService {
	private SessionFactory sf;

	@Autowired
	public MessageServiceImpl(SessionFactory sf) {
		this.sf = sf;
	}

	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void createMessage(MessageModel messageModel) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().save(messageModel);
	}

	@Override
	public MessageModel getMessage(int number) throws Exception {
		// TODO Auto-generated method stub
		MessageModel messageModel = sf.getCurrentSession().get(MessageModel.class, number);
		return messageModel;
	}

	@Override
	public void modifyMessage(MessageModel messageModel) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().update(messageModel);
	}

	@Override
	public void removeMessage(int number) throws Exception {
		// TODO Auto-generated method stub
		MessageModel messageModel = new MessageModel();
		messageModel.setNumber(number);
		sf.getCurrentSession().delete(messageModel);
	}

	@Override
	public List<MessageModel> getAllComment() throws Exception {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		String sql = "from MessageModel";
		Query<MessageModel> query = session.createQuery(sql, MessageModel.class);
		List<MessageModel> list = query.getResultList();
		tx.commit();
		session.close();
		return list;
	}

}
