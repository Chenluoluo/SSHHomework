package cn.ciwest.ssh.service;

import java.util.List;

import cn.ciwest.ssh.model.CommentModel;

public interface ICommentService {
	public void createComment(CommentModel commentModel) throws Exception;

	public CommentModel getComment(int number) throws Exception;

	public void modifyComment(CommentModel commentModel) throws Exception;

	public void removeComment(int number) throws Exception;

	public List<CommentModel> getBlogComment(int blognumber) throws Exception;

	public List<CommentModel> getAllComment() throws Exception;
}
