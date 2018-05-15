package cn.ciwest.ssh.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import cn.ciwest.ssh.model.BlogModel;
import cn.ciwest.ssh.model.CommentModel;
import cn.ciwest.ssh.service.IBlogService;
import cn.ciwest.ssh.service.ICommentService;

public class BlogFrontAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private IBlogService blogService = null;

	@Autowired
	public void setBlogService(IBlogService blogService) {
		this.blogService = blogService;
	}

	private ICommentService commentService = null;

	@Autowired
	public void setCommentService(ICommentService commentService) {
		this.commentService = commentService;
	}

	private String number = null;
	private String author = null;
	private BlogModel blog = null;
	private List<CommentModel> listComment = null;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BlogModel getBlog() {
		return blog;
	}

	public void setBlog(BlogModel blog) {
		this.blog = blog;
	}

	public List<CommentModel> getListComment() {
		return listComment;
	}

	public void setListComment(List<CommentModel> listComment) {
		this.listComment = listComment;
	}

	@Override
	public String execute() throws Exception {
		blog = blogService.getBlog(Integer.parseInt(number));
		listComment = commentService.getBlogComment(Integer.parseInt(number));
		return SUCCESS;
	}
}
