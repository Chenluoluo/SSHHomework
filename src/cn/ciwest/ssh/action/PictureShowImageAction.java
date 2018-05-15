package cn.ciwest.ssh.action;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import cn.ciwest.ssh.model.PictureModel;
import cn.ciwest.ssh.service.IPictureService;

public class PictureShowImageAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private IPictureService pictureService = null;

	@Autowired
	public void setPictureService(IPictureService pictureService) {
		this.pictureService = pictureService;
	}

	private PictureModel pictureModel = null;
	private String number = null;

	public PictureModel getPictureModel() {
		return pictureModel;
	}

	public void setPictureModel(PictureModel pictureModel) {
		this.pictureModel = pictureModel;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public InputStream getInputStream() throws Exception {
		pictureModel = pictureService.getPicture(Integer.parseInt(number));
		InputStream result = pictureModel.getPicture().getBinaryStream();
		return result;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
}
