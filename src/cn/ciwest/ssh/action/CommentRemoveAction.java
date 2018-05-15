package cn.ciwest.ssh.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import cn.ciwest.ssh.service.ICommentService;

public class CommentRemoveAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private ICommentService commentService = null;

	@Autowired
	public void setCommentService(ICommentService commentService) {
		this.commentService = commentService;
	}

	private String number = null;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		commentService.removeComment(Integer.parseInt(number));
		return SUCCESS;
	}
}
