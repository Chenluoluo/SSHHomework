package cn.ciwest.ssh.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import cn.ciwest.ssh.model.BlogModel;
import cn.ciwest.ssh.service.IBlogService;

public class HomeFrontAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private IBlogService blogService = null;

	@Autowired
	public void setBlogService(IBlogService blogService) {
		this.blogService = blogService;
	}

	private List<BlogModel> listBlog = null;

	public List<BlogModel> getListBlog() {
		return listBlog;
	}

	public void setListBlog(List<BlogModel> listBlog) {
		this.listBlog = listBlog;
	}

	@Override
	public String execute() throws Exception {
		listBlog = blogService.getAllBlog();
		return SUCCESS;
	}

}
