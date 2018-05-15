package cn.ciwest.ssh.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ciwest.ssh.model.PictureModel;
import cn.ciwest.ssh.service.IPictureService;

@Service("pictureServiceImpl")
@Transactional
public class PictureServiceImpl implements IPictureService {
	private SessionFactory sf;

	@Autowired
	public PictureServiceImpl(SessionFactory sf) {
		this.sf = sf;
	}

	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void createPicture(PictureModel pictureModel, File file) throws Exception {
		// TODO Auto-generated method stub
		InputStream inputStream = new FileInputStream(file);
		Blob blob = sf.getCurrentSession().getLobHelper().createBlob(inputStream, inputStream.available());
		pictureModel.setPicture(blob);
		sf.getCurrentSession().save(pictureModel);
	}

	@Override
	public PictureModel getPicture(int number) throws Exception {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		PictureModel pictureModel = session.get(PictureModel.class, number);
		transaction.commit();
		session.close();
		return pictureModel;
	}

	@Override
	public void modifyPicture(PictureModel pictureModel) throws Exception {
		// TODO Auto-generated method stub
		PictureModel picture = getPicture(pictureModel.getNumber());
		picture.setName(pictureModel.getName());
		sf.getCurrentSession().update(picture);
	}

	@Override
	public void removePicture(int number) throws Exception {
		// TODO Auto-generated method stub
		PictureModel pictureModel = new PictureModel();
		pictureModel.setNumber(number);
		sf.getCurrentSession().delete(pictureModel);
	}

	@Override
	public List<PictureModel> getAllPicture() throws Exception {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from PictureModel ", PictureModel.class).getResultList();
	}

}
