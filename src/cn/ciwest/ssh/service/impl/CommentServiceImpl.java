package cn.ciwest.ssh.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ciwest.ssh.model.CommentModel;
import cn.ciwest.ssh.service.ICommentService;

@Service("commentServiceImpl")
@Transactional
public class CommentServiceImpl implements ICommentService {
	private SessionFactory sf;

	@Autowired
	public CommentServiceImpl(SessionFactory sf) {
		this.sf = sf;
	}

	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void createComment(CommentModel commentModel) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().save(commentModel);
	}

	@Override
	public CommentModel getComment(int number) throws Exception {
		// TODO Auto-generated method stub
		CommentModel commentModel = sf.getCurrentSession().get(CommentModel.class, number);
		return commentModel;
	}

	@Override
	public void modifyComment(CommentModel commentModel) throws Exception {
		// TODO Auto-generated method stub
		sf.getCurrentSession().update(commentModel);
	}

	@Override
	public void removeComment(int number) throws Exception {
		// TODO Auto-generated method stub
		CommentModel commentModel = new CommentModel();
		commentModel.setNumber(number);
		sf.getCurrentSession().remove(commentModel);
	}

	@Override
	public List<CommentModel> getBlogComment(int blognumber) throws Exception {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		String sql = "from CommentModel where blognumber = '" + blognumber + "'";
		Query<CommentModel> query = session.createQuery(sql, CommentModel.class);
		List<CommentModel> list = query.getResultList();
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public List<CommentModel> getAllComment() throws Exception {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		String sql = "from CommentModel";
		Query<CommentModel> query = session.createQuery(sql, CommentModel.class);
		List<CommentModel> list = query.getResultList();
		tx.commit();
		session.close();
		return list;
	}

}
