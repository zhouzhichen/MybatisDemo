package com.rimi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rimi.service.UserServiceImpl;
import com.rimi.userbean.UserBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		int password= Integer.parseInt(request.getParameter("password"));
		UserServiceImpl usa=new UserServiceImpl();
		UserBean ub=usa.login(name, password);
		
		if(ub!=null) {
			request.setAttribute("ub",ub);
			request.setAttribute("userInfo",usa.userInfo());
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
