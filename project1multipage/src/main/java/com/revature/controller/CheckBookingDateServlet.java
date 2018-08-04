package com.revature.controller;

import java.io.IOException;

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
		String DayOfVisit = req.getParameter("DayOfVisit");
		String DayOfDeparture = req.getParameter("DayOfDeparture");
		System.out.println(DayOfVisit + " " + DayOfDeparture);
		
		BookingsDao.getBookingsBetween(DayOfVisit, DayOfDeparture);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		System.out.println("Successfully fired up CheckBookingDateServlet.post");
		
	}
}
