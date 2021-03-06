package com.revature.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.IssuesClientResponse;
import com.revature.dao.IssuesDao;
import com.revature.dao.UserAccountsDao;

public class RetrieveMyIssuesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Successfully fired up RetrieveMyIssuesServlet.post");
		String email= (String) req.getSession().getAttribute("email");
		if (UserAccountsDao.VerifyEmail(email)) {
			List<IssuesClientResponse> myIssues = IssuesDao.RetrieveMyIssues(email);
			resp.getWriter().write(myIssues.toString());
			return;
		} else {
			resp.getWriter().write("Verification Failed");
			return;
		}
	}
}
