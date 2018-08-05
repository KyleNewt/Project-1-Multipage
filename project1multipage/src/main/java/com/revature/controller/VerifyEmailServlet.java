package com.revature.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.UserAccountsDao;

/**
 * Servlet implementation class VerifyEmailServlet
 */
public class VerifyEmailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Successfully fired up VerifyEmailServlet.get");
		// TODO
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Successfully fired up VerifyEmailServlet.post");
		String email = req.getParameter("email");
		String emailVerified = "false";
		if (UserAccountsDao.VerifyEmail(email)) {
			emailVerified = "True";
		}
		System.out.println("emailVerified = " +emailVerified);
		resp.getWriter().write(emailVerified);
	}

}
