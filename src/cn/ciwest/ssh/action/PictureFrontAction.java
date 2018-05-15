package cn.ciwest.ssh.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import cn.ciwest.ssh.model.PictureModel;
import cn.ciwest.ssh.service.IPictureService;

public class PictureFrontAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private IPictureService pictureService = null;

	@Autowired
	public void setPictureService(IPictureService pictureService) {
		this.pictureService = pictureService;
	}

	private List<PictureModel> listPicture = null;

	public List<PictureModel> getListPicture() {
		return listPicture;
	}

	public void setListPicture(List<PictureModel> listPicture) {
		this.listPicture = listPicture;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		listPicture = pictureService.getAllPicture();
		return SUCCESS;
	}
}
