package cn.ciwest.ssh.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.ciwest.ssh.model.CommentModel;
import cn.ciwest.ssh.model.UserModel;
import cn.ciwest.ssh.service.ICommentService;

public class CommentEditAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private ICommentService commentService = null;

	@Autowired
	public void setCommentService(ICommentService commentService) {
		this.commentService = commentService;
	}

	private CommentModel commentModel = null;

	public CommentModel getCommentModel() {
		return commentModel;
	}

	public void setCommentModel(CommentModel commentModel) {
		this.commentModel = commentModel;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		UserModel userModel = (UserModel) session.get("user");
		commentModel.setUsername(userModel.getUsername());
		commentModel.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		commentService.createComment(commentModel);
		System.out.println("评论成功");
		return SUCCESS;
	}
}
