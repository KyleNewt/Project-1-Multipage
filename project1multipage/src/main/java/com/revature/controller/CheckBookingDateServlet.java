package com.revature.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.BookingsDao;

public class CheckBookingDateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		System.out.println("Successfully fired up CheckBookingDateServlet.get");
		String dayOfVisit = req.getParameter("dayOfVisit");
		String dayOfDeparture = req.getParameter("dayOfDeparture");
		
		BookingsDao.getBookingsBetween(dayOfVisit, dayOfDeparture);

		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		System.out.println("Successfully fired up CheckBookingDateServlet.post");
		String dayOfVisit = req.getParameter("dayOfVisit");
		String dayOfDeparture = req.getParameter("dayOfDeparture");

		Set<Integer> myData = BookingsDao.getBookingsBetween(dayOfVisit, dayOfDeparture);
		resp.getWriter().write(myData.toString());
	}
}
