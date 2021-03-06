package com.revature.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.BookingsDao;
import com.revature.dao.IssuesDao;
import com.revature.dao.UserAccountsDao;

public class CreateIssueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	//TODO
    	resp.getWriter().append("Served at: ").append(req.getContextPath());
	}

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("Successfully fired up CreateIssueServlet.post");
		String issueTitle = req.getParameter("issueTitle");
		String issueText = req.getParameter("issueText");
		String email = (String) req.getSession().getAttribute("email");
		if (UserAccountsDao.VerifyEmail(email)) {
			IssuesDao.InsertIssue(email, issueTitle, issueText);
			return;
		} else {
			resp.getWriter().write("Verification Failed");
			return;
		}
	}
}
