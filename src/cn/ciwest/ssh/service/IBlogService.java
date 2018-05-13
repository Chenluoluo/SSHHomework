package cn.ciwest.ssh.service;

import java.util.List;

import cn.ciwest.ssh.model.BlogModel;

public interface IBlogService {
	public void createBlog(BlogModel blogModel) throws Exception;

	public BlogModel getBlog(int number) throws Exception;

	public void modifyBlog(BlogModel blogModel) throws Exception;

	public void removeBlog(int number) throws Exception;

	public List<BlogModel> getAllBlog() throws Exception;
}
