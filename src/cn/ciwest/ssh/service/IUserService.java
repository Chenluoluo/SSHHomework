package cn.ciwest.ssh.service;

import cn.ciwest.ssh.model.UserModel;

public interface IUserService {
	public void createUser(UserModel userModel) throws Exception;

	public UserModel getUser(String username) throws Exception;

	public UserModel modifyUser(UserModel userModel) throws Exception;

	public void removeUser(String username) throws Exception;
}
