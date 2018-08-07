package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.UserAccountsDao;

public class UserAccountsCreationServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		System.out.println("Successfully fired up UserAccountCreationServlet.get");
		String email = req.getParameter("email");
		String emailConfirmation = req.getParameter("emailConfirmation");
		String password = req.getParameter("password");
		String passwordConfirmation = req.getParameter("passwordConfirmation");

		if (email != emailConfirmation || password != passwordConfirmation) {
			resp.sendRedirect("html/createAccount.html");
		} else {
			// Check if user already exists
			if (UserAccountsDao.CheckIfUserAccountExists(email)) {
				resp.sendRedirect("index.html");
			} else {
				UserAccountsDao.AddNewUser(email, password);
				resp.sendRedirect("html/AccountCreationSuccessful.html");
			}

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Successfully fired up UserAccountCreationServlet.post");
		resp.setContentType("text/plain");
		String email = req.getParameter("email");
		String emailConfirmation = req.getParameter("emailConfirmation");
		String password = req.getParameter("password");
		String passwordConfirmation = req.getParameter("passwordConfirmation");

		if (!email.equals(emailConfirmation) || !password.equals(passwordConfirmation)) {
			resp.sendRedirect("html/createAccount.html");
		} else {
			// Check if user already exists
			if (UserAccountsDao.CheckIfUserAccountExists(email)) {
				resp.sendRedirect("index.html");
			} else {
				UserAccountsDao.AddNewUser(email, password);
				resp.sendRedirect("html/AccountCreationSuccessful.html");
			}

		}
	}
}
