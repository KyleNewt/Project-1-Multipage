package com.revature.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.UserAccountsDao;

/**
 * Servlet implementation class VerifyLoginServlet
 */
public class VerifyLoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Successfully fired up VerifyLoginServlet.post");
		String email= (String) req.getSession().getAttribute("email");
		if (UserAccountsDao.VerifyEmail(email)) {
			return;
		} else {
			resp.getWriter().write("Verification Failed");
			return;
		}
	}

}

