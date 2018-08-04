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
		String DayOfVisit = req.getParameter("DayOfVisit");
		String DayOfDeparture = req.getParameter("DayOfDeparture");
		String RoomId = req.getParameter("room_id");
		System.out.println(DayOfVisit + " " + DayOfDeparture + " " + RoomId);
		BookingsDao.BookRoom(DayOfVisit, DayOfDeparture, RoomId);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		System.out.println("Successfully fired up CheckBookingDateServlet.post");
		
	}
}
