package com.rimi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rimi.service.UserServiceImpl;
import com.rimi.userbean.UserBean;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		UserServiceImpl usa = new UserServiceImpl();

		if ("fuzzyquery".equals(method)) {
			request.getSession().setAttribute("userNames", request.getParameter("userName"));
			request.getSession().setAttribute("userPasswords", request.getParameter("userPassword"));
			List list = usa.getUserInfo(request.getParameter("userName"),
					Integer.parseInt(request.getParameter("userPassword")));
			request.setAttribute("userInfo", list);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		if ("pupdate".equals(method)) {
			String userId = request.getParameter("userId");
			UserBean ub = usa.getUserById(Integer.parseInt(userId));
			request.setAttribute("ub", ub);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
		if ("update".equals(method)) {
			int id = Integer.parseInt(request.getParameter("userId"));
			String name = request.getParameter("userName");
			int password = Integer.parseInt(request.getParameter("userPassword"));
			usa.updateUser(id, name, password);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		if("delete".equals(method)) {
			int userId=Integer.parseInt(request.getParameter("userId"));
			usa.deleteUser(userId);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
