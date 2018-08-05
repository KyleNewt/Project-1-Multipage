package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.BookingsDao;

public class BookingsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		System.out.println("Successfully fired up BookingsServlet.get");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		System.out.println("Successfully fired up CheckBookingDateServlet.post");
		String DayOfVisit = req.getParameter("dayOfVisit");
		String DayOfDeparture = req.getParameter("dayOfDeparture");
		int RoomId = Integer.parseInt(req.getParameter("roomId"));
		String emailVerification = req.getParameter("emailVerification");
		System.out.println(DayOfVisit + " " + DayOfDeparture + " " + RoomId + " " + emailVerification);
		//BookingsDao.BookRoom(DayOfVisit, DayOfDeparture, RoomId, emailVerification);
		
	}
}
