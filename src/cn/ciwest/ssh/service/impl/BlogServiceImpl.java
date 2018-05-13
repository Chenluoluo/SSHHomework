package cn.ciwest.ssh.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ciwest.ssh.model.BlogModel;
import cn.ciwest.ssh.service.IBlogService;

@Service("blogServiceImpl")
@Transactional
public class BlogServiceImpl implements IBlogService {

	private SessionFactory sf;

	@Autowired
	public BlogServiceImpl(SessionFactory sf) {
		this.sf = sf;
	}

	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void createBlog(BlogModel blogModel) throws Exception {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(blogModel);
		tx.commit();
		session.close();
	}

	@Override
	public BlogModel getBlog(int number) throws Exception {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		BlogModel blogModel = session.get(BlogModel.class, number);
		Transaction tx = session.beginTransaction();
		tx.commit();
		session.close();
		return blogModel;
	}

	@Override
	public void modifyBlog(BlogModel blogModel) throws Exception {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(blogModel);
		tx.commit();
		session.close();
	}

	@Override
	public void removeBlog(int number) throws Exception {
		// TODO Auto-generated method stub
		BlogModel blogModel = new BlogModel();
		blogModel.setNumber(number);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(blogModel);
		tx.commit();
		session.close();
	}

	@Override
	public List<BlogModel> getAllBlog() throws Exception {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		String sql = "from BlogModel";
		Query<BlogModel> query = session.createQuery(sql, BlogModel.class);
		List<BlogModel> list = query.getResultList();
		tx.commit();
		session.close();
		return list;
	}

}
