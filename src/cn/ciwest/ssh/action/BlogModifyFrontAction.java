package cn.ciwest.ssh.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import cn.ciwest.ssh.model.BlogModel;
import cn.ciwest.ssh.service.IBlogService;

public class BlogModifyFrontAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private IBlogService blogService = null;

	@Autowired
	public void setBlogService(IBlogService blogService) {
		this.blogService = blogService;
	}

	private String number = null;
	private BlogModel blog = null;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public BlogModel getBlog() {
		return blog;
	}

	public void setBlog(BlogModel blog) {
		this.blog = blog;
	}

	@Override
	public String execute() throws Exception {
		blog = blogService.getBlog(Integer.parseInt(number));
		return SUCCESS;
	}
}
