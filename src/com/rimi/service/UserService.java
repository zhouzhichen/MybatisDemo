package com.rimi.service;

import java.util.List;

import com.rimi.userbean.UserBean;

public interface UserService {
	public UserBean login(String userName, int userPs);

	public List<UserBean> getUserInfo(String userName, int userAge);

	public List<UserBean> userInfo();

	public UserBean getUserById(int userId);

	public boolean updateUser(int userId, String userName, int userPs);
	
	public boolean deleteUser(int userId);

}
