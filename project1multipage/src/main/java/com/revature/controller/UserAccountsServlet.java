package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.UserAccountsDao;

public class UserAccountsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		System.out.println("Successfully fired up UserAccountsServlet.get");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Successfully fired up UserAccountsServlet.post");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		if (UserAccountsDao.VerifyLogin(email, password)) {
			HttpSession session = req.getSession();
			session.setAttribute("email", email);
			if (UserAccountsDao.CheckManager(email, password)) {
				session.setAttribute("isManager", true);
				resp.sendRedirect("html/managerDashboard.html");
			} else {
				session.setAttribute("isManager", false);
				resp.sendRedirect("html/myAccount.html");
			}
		} else {
			resp.sendRedirect("index.html");
		}

	}
}
