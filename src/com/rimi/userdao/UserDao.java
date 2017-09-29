package com.rimi.userdao;

import java.util.List;

import com.rimi.userbean.UserBean;

public interface UserDao {
	public UserBean login(UserBean ub);

	public List<UserBean> getUserInfo(UserBean ub);

	public List<UserBean> userInfo();

	public UserBean getUserById(int userId);

	public boolean updateUser(UserBean ub);

	public List getUserByIds(List ids);
	public boolean deleteUser(int userId);
}
