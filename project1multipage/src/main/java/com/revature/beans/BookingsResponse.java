package com.revature.beans;

import java.sql.Date;

public class BookingsResponse {
	int roomId;
	Date bookingStartDate;
	Date bookingEndDate;
	int totalPrice;
	String status;

	public BookingsResponse(int roomId, Date bookingStartDate, Date bookingEndDate, int totalPrice, String status) {
		this.roomId = roomId;
		this.bookingStartDate = bookingStartDate;
		this.bookingEndDate = bookingEndDate;
		this.totalPrice = totalPrice;
		this.status = status;
	}
	
	public String toString(){
		return roomId+","+bookingStartDate+","+bookingEndDate+","+totalPrice+","+status;
	}

}
