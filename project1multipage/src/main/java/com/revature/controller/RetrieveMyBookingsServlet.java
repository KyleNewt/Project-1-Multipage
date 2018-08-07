package com.revature.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.BookingsResponse;
import com.revature.beans.IssuesClientResponse;
import com.revature.dao.BookingsDao;
import com.revature.dao.IssuesDao;
import com.revature.dao.UserAccountsDao;

/**
 * Servlet implementation class RetrieveMyBookingsServlet
 */
public class RetrieveMyBookingsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Successfully fired up RetrieveMyBookingsServlet.post");
		String email= (String) req.getSession().getAttribute("email");
		if (UserAccountsDao.VerifyEmail(email)) {
			List<BookingsResponse> myBookings = BookingsDao.RetrieveMyBookings(email);
			resp.getWriter().write(myBookings.toString());
			return;
		} else {
			resp.getWriter().write("Verification Failed");
			return;
		}
	}

}
