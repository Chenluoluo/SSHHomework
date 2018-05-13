package cn.ciwest.ssh.service.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;

import cn.ciwest.ssh.model.UserModel;
import cn.ciwest.ssh.service.IUserService;

@Service("userServiceImpl")
@Transactional
public class UserServiceImpl implements IUserService {

	private SessionFactory sf;

	@Autowired
	public UserServiceImpl(SessionFactory sf) {
		this.sf = sf;
	}

	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void createUser(UserModel userModel) throws Exception {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(userModel);
		tx.commit();
		session.close();
	}

	@Override
	public UserModel getUser(String username) throws Exception {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		String sql = "from UserModel where username = '" + username +"'";
		Query<UserModel> query = session.createQuery(sql,UserModel.class);
		List<UserModel> list = query.getResultList();
		tx.commit();
		session.close();
		if (list.size() == 0)
			return null;
		return list.get(0);
	}

	@Override
	public UserModel modifyUser(UserModel userModel) throws Exception {
		// TODO Auto-generated method stub
		UserModel user = getUser(userModel.getUsername());
		Session session = sf.openSession();
		user.setName(userModel.getName());
		user.setEmail(userModel.getEmail());
		user.setPhone(userModel.getPhone());
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
		session.close();
		return user;
	}

	@Override
	public void removeUser(String username) throws Exception {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		String sql = "from UserModel where username = '" + username +"'";
		Query<UserModel> query = session.createQuery(sql,UserModel.class);
		List<UserModel> list = query.getResultList();
		session.delete(list.get(0));
		tx.commit();
		session.close();
	}

}
