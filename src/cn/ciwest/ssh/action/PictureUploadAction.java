package cn.ciwest.ssh.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.ciwest.ssh.model.PictureModel;
import cn.ciwest.ssh.model.UserModel;
import cn.ciwest.ssh.service.IPictureService;

public class PictureUploadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private IPictureService pictureService = null;

	@Autowired
	public void setPictureService(IPictureService pictureService) {
		this.pictureService = pictureService;
	}

	private PictureModel pictureModel = null;
	private File file = null;

	public PictureModel getPictureModel() {
		return pictureModel;
	}

	public void setPictureModel(PictureModel pictureModel) {
		this.pictureModel = pictureModel;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		UserModel userModel = (UserModel) session.get("user");
		pictureModel.setAuthor(userModel.getUsername());
		pictureModel.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		pictureService.createPicture(pictureModel, file);
		System.out.println("图片保存成功");
		return SUCCESS;
	}

}
