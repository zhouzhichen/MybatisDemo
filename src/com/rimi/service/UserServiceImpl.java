package com.rimi.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.rimi.userbean.UserBean;
import com.rimi.userdao.UserDao;

public class UserServiceImpl implements UserService {
	UserDao ud;
	SqlSession session;
	

	public UserServiceImpl() {
		try {
			InputStream in=Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory sf= new SqlSessionFactoryBuilder().build(in);
			session= sf.openSession();
			ud=session.getMapper(UserDao.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public UserBean login(String userName, int userPs) {
		return ud.login(new UserBean(userName,userPs));
	}

	@Override
	//Ä£ºý²éÑ¯
	public List<UserBean> getUserInfo(String userName, int password) {
		return ud.getUserInfo(new UserBean("%"+userName+"%",password));
	}

	@Override
	public UserBean getUserById(int userId) {
		return ud.getUserById(userId);
	}

	@Override
	public boolean updateUser(int userId, String userName, int userPs) {
		boolean ok=ud.updateUser(new UserBean(userId,userName,userPs));
		session.commit();
		return ok;
	}

	@Override
	public List<UserBean> userInfo() {
		return ud.userInfo();
	}

}
