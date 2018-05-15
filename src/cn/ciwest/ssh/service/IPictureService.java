package cn.ciwest.ssh.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import cn.ciwest.ssh.model.PictureModel;

public interface IPictureService {
	public void createPicture(PictureModel pictureModel, File file) throws Exception;

	public PictureModel getPicture(int number) throws Exception;

	public void modifyPicture(PictureModel pictureModel) throws Exception;

	public void removePicture(int number) throws Exception;

	public List<PictureModel> getAllPicture() throws Exception;
}
